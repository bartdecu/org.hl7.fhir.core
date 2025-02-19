package org.hl7.fhir.r5.context;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * This implements a two level cache. 
 *  - a temporary cache for remembering previous local operations
 *  - a persistent cache for remembering tx server operations
 *  
 * the cache is a series of pairs: a map, and a list. the map is the loaded cache, the list is the persistent cache, carefully maintained in order for version control consistency
 * 
 * @author graha
 *
 */
public class TerminologyCache {
  public static final boolean TRANSIENT = false;
  public static final boolean PERMANENT = true;
  private static final String NAME_FOR_NO_SYSTEM = "all-systems";
  private static final String ENTRY_MARKER = "-------------------------------------------------------------------------------------";
  private static final String BREAK = "####";

  private static final String CACHE_FILE_EXTENSION = ".cache";

  private static final String CAPABILITY_STATEMENT_TITLE = ".capabilityStatement";
  private static final String TERMINOLOGY_CAPABILITIES_TITLE = ".terminologyCapabilities";

  @Getter
  private int requestCount;
  @Getter
  private int hitCount;
  @Getter
  private int networkCount;

  public class CacheToken {
    @Getter
    private String name;
    private String key;
    @Getter
    private String request;
    @Accessors(fluent = true)
    @Getter
    private boolean hasVersion;

    public void setName(String n) {
      if (name == null)
        name = n;
      else if (!n.equals(name))
        name = NAME_FOR_NO_SYSTEM;
    }
  }

  private class CacheEntry {
    private String request;
    private boolean persistent;
    private ValidationResult v;
    private ValueSetExpansionOutcome e;
  }
  
  private class NamedCache {
    private String name; 
    private List<CacheEntry> list = new ArrayList<CacheEntry>(); // persistent entries
    private Map<String, CacheEntry> map = new HashMap<String, CacheEntry>();
  }
  

  private Object lock;
  private String folder;

  private CapabilityStatement capabilityStatementCache = null;

  public boolean hasCapabilityStatement() {
    return capabilityStatementCache != null;
  }

  public CapabilityStatement getCapabilityStatement() {
    return capabilityStatementCache;
  }

  public void cacheCapabilityStatement(CapabilityStatement capabilityStatement) {
    if (noCaching) {
      return;
    }
    this.capabilityStatementCache = capabilityStatement;
    save(capabilityStatementCache, CAPABILITY_STATEMENT_TITLE);
  }

  private TerminologyCapabilities terminologyCapabilitiesCache = null;

  public boolean hasTerminologyCapabilities() {
    return terminologyCapabilitiesCache != null;
  }

  public TerminologyCapabilities getTerminologyCapabilities() {
    return terminologyCapabilitiesCache;
  }

  public void cacheTerminologyCapabilities(TerminologyCapabilities terminologyCapabilities) {
    if (noCaching) {
      return;
    }
    this.terminologyCapabilitiesCache = terminologyCapabilities;
    save(terminologyCapabilitiesCache, TERMINOLOGY_CAPABILITIES_TITLE);
  }

  private Map<String, NamedCache> caches = new HashMap<String, NamedCache>();
  @Getter @Setter
  private static boolean noCaching;
  
  @Getter @Setter
  private static boolean cacheErrors;

  // use lock from the context
  public TerminologyCache(Object lock, String folder) throws FileNotFoundException, IOException, FHIRException {
    super();
    this.lock = lock;
    this.folder = folder;
    requestCount = 0;
    hitCount = 0;
    networkCount = 0;

    if (folder != null) {
      load();
  }
  }
  
  public void clear() {
    caches.clear();
  }

  public CacheToken generateValidationToken(ValidationOptions options, Coding code, ValueSet vs) {
    CacheToken ct = new CacheToken();
    if (code.hasSystem()) {
      ct.name = getNameForSystem(code.getSystem());
      ct.hasVersion = code.hasVersion();
    }
    else
      ct.name = NAME_FOR_NO_SYSTEM;
    nameCacheToken(vs, ct);
    JsonParser json = new JsonParser();
    json.setOutputStyle(OutputStyle.PRETTY);
    if (vs != null && vs.hasUrl() && vs.hasVersion()) {
      try {
        ct.request = "{\"code\" : "+json.composeString(code, "codeableConcept")+", \"url\": \""+Utilities.escapeJson(vs.getUrl())
            +"\", \"version\": \""+Utilities.escapeJson(vs.getVersion())+"\""+(options == null ? "" : ", "+options.toJson())+"}\r\n";      
      } catch (IOException e) {
        throw new Error(e);
      }
    } else {
      ValueSet vsc = getVSEssense(vs);
      try {
        ct.request = "{\"code\" : "+json.composeString(code, "code")+", \"valueSet\" :"+(vsc == null ? "null" : extracted(json, vsc))+(options == null ? "" : ", "+options.toJson())+"}";
      } catch (IOException e) {
        throw new Error(e);
      }
    }
    ct.key = String.valueOf(hashJson(ct.request));
    return ct;
  }

  public String extracted(JsonParser json, ValueSet vsc) throws IOException {
    String s = null;
    if (vsc.getExpansion().getContains().size() > 1000 || vsc.getCompose().getIncludeFirstRep().getConcept().size() > 1000) {      
      s =  vsc.getUrl();
    } else {
      s = json.composeString(vsc);
    }
    return s;
  }

  public CacheToken generateValidationToken(ValidationOptions options, CodeableConcept code, ValueSet vs) {
    CacheToken ct = new CacheToken();
    for (Coding c : code.getCoding()) {
      if (c.hasSystem()) {
        ct.setName(getNameForSystem(c.getSystem()));
        ct.hasVersion = c.hasVersion();
      }
    }
    nameCacheToken(vs, ct);
    JsonParser json = new JsonParser();
    json.setOutputStyle(OutputStyle.PRETTY);
    if (vs != null && vs.hasUrl() && vs.hasVersion()) {
      try {
       ct.request = "{\"code\" : "+json.composeString(code, "codeableConcept")+", \"url\": \""+Utilities.escapeJson(vs.getUrl())+
           "\", \"version\": \""+Utilities.escapeJson(vs.getVersion())+"\""+(options == null ? "" : ", "+options.toJson())+"+}\r\n";      
      } catch (IOException e) {
        throw new Error(e);
      }
    } else {
      ValueSet vsc = getVSEssense(vs);
      try {
        ct.request = "{\"code\" : "+json.composeString(code, "codeableConcept")+", \"valueSet\" :"+extracted(json, vsc)+(options == null ? "" : ", "+options.toJson())+"}";
      } catch (IOException e) {
        throw new Error(e);
      }
    }
    ct.key = String.valueOf(hashJson(ct.request));
    return ct;
  }
  
  public ValueSet getVSEssense(ValueSet vs) {
    if (vs == null)
      return null;
    ValueSet vsc = new ValueSet();
    vsc.setCompose(vs.getCompose());
    if (vs.hasExpansion()) {
      vsc.getExpansion().getParameter().addAll(vs.getExpansion().getParameter());
      vsc.getExpansion().getContains().addAll(vs.getExpansion().getContains());
    }
    return vsc;
  }

  public CacheToken generateExpandToken(ValueSet vs, boolean hierarchical) {
    CacheToken ct = new CacheToken();
    nameCacheToken(vs, ct);
    if (vs.hasUrl() && vs.hasVersion()) {
      ct.request = "{\"hierarchical\" : "+(hierarchical ? "true" : "false")+", \"url\": \""+Utilities.escapeJson(vs.getUrl())+"\", \"version\": \""+Utilities.escapeJson(vs.getVersion())+"\"}\r\n";      
    } else {
      ValueSet vsc = getVSEssense(vs);
      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);
      try {
      ct.request = "{\"hierarchical\" : "+(hierarchical ? "true" : "false")+", \"valueSet\" :"+extracted(json, vsc)+"}\r\n";
      } catch (IOException e) {
        throw new Error(e);
      }
    }
    ct.key = String.valueOf(hashJson(ct.request));
    return ct;
  }

  public void nameCacheToken(ValueSet vs, CacheToken ct) {
    if (vs != null) {
      for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
        if (inc.hasSystem()) {
          ct.setName(getNameForSystem(inc.getSystem()));
          ct.hasVersion = inc.hasVersion();
        }
      }
      for (ConceptSetComponent inc : vs.getCompose().getExclude()) {
        if (inc.hasSystem()) {
          ct.setName(getNameForSystem(inc.getSystem()));
          ct.hasVersion = inc.hasVersion();
        }
      }
      for (ValueSetExpansionContainsComponent inc : vs.getExpansion().getContains()) {
        if (inc.hasSystem()) {
          ct.setName(getNameForSystem(inc.getSystem()));
          ct.hasVersion = inc.hasVersion();
        }
      }
    }
  }

  private String getNameForSystem(String system) {
    if (system.equals("http://snomed.info/sct"))
      return "snomed";
    if (system.equals("http://www.nlm.nih.gov/research/umls/rxnorm"))
      return "rxnorm";
    if (system.equals("http://loinc.org"))
      return "loinc";
    if (system.equals("http://unitsofmeasure.org"))
      return "ucum";
    if (system.startsWith("http://hl7.org/fhir/sid/"))
      return system.substring(24).replace("/", "");
    if (system.startsWith("urn:iso:std:iso:"))
      return "iso"+system.substring(16).replace(":", "");
    if (system.startsWith("http://terminology.hl7.org/CodeSystem/"))
      return system.substring(38).replace("/", "");
    if (system.startsWith("http://hl7.org/fhir/"))
      return system.substring(20).replace("/", "");
    if (system.equals("urn:ietf:bcp:47"))
      return "lang";
    if (system.equals("urn:ietf:bcp:13"))
      return "mimetypes";
    if (system.equals("urn:iso:std:iso:11073:10101"))
      return "11073";
    if (system.equals("http://dicom.nema.org/resources/ontology/DCM"))
      return "dicom";
    return system.replace("/", "_").replace(":", "_").replace("?", "X").replace("#", "X");
  }

  public NamedCache getNamedCache(CacheToken cacheToken) {

    final String cacheName = cacheToken.name == null ? "null" : cacheToken.name;

    NamedCache nc = caches.get(cacheName);

    if (nc == null) {
      nc = new NamedCache();
      nc.name = cacheName;
      caches.put(nc.name, nc);
    }
    return nc;
  }
  
  public ValueSetExpansionOutcome getExpansion(CacheToken cacheToken) {
    synchronized (lock) {
      NamedCache nc = getNamedCache(cacheToken);
      CacheEntry e = nc.map.get(cacheToken.key);
      if (e == null)
        return null;
      else
        return e.e;
    }
  }

  public void cacheExpansion(CacheToken cacheToken, ValueSetExpansionOutcome res, boolean persistent) {
    synchronized (lock) {      
      NamedCache nc = getNamedCache(cacheToken);
      CacheEntry e = new CacheEntry();
      e.request = cacheToken.request;
      e.persistent = persistent;
      e.e = res;
      store(cacheToken, persistent, nc, e);
    }    
  }

  public void store(CacheToken cacheToken, boolean persistent, NamedCache nc, CacheEntry e) {
    if (noCaching) {
      return;
    }

    if ( !cacheErrors &&
      ( e.v!= null
        && e.v.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED
        && !cacheToken.hasVersion)) {
      return;
    }

    boolean n = nc.map.containsKey(cacheToken.key);
    nc.map.put(cacheToken.key, e);
    if (persistent) {
      if (n) {
        for (int i = nc.list.size()- 1; i>= 0; i--) {
          if (nc.list.get(i).request.equals(e.request)) {
            nc.list.remove(i);
          }
        }
      }
      nc.list.add(e);
      save(nc);  
    }
  }

  public ValidationResult getValidation(CacheToken cacheToken) {
    if (cacheToken.key == null) {
      return null;
    }
    synchronized (lock) {
      requestCount++;
      NamedCache nc = getNamedCache(cacheToken);
      CacheEntry e = nc.map.get(cacheToken.key);
      if (e == null) {
        networkCount++;
        return null;
      } else {
        hitCount++;
        return e.v;
    }
  }
  }

  public void cacheValidation(CacheToken cacheToken, ValidationResult res, boolean persistent) {
    if (cacheToken.key != null) {
      synchronized (lock) {      
        NamedCache nc = getNamedCache(cacheToken);
        CacheEntry e = new CacheEntry();
        e.request = cacheToken.request;
        e.persistent = persistent;
        e.v = res;
        store(cacheToken, persistent, nc, e);
      }    
    }
  }

  
  // persistence
  
  public void save() {
    
  }
  
  private <K extends Resource> void save(K resource, String title) {
    if (folder == null)
      return;

    try {
      OutputStreamWriter sw = new OutputStreamWriter(new FileOutputStream(Utilities.path(folder, title + CACHE_FILE_EXTENSION)), "UTF-8");

      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);

      sw.write(json.composeString(resource).trim());
      sw.close();
    } catch (Exception e) {
      System.out.println("error saving capability statement "+e.getMessage());
    }
  }

  private void save(NamedCache nc) {
    if (folder == null)
      return;
    
    try {
      OutputStreamWriter sw = new OutputStreamWriter(new FileOutputStream(Utilities.path(folder, nc.name+CACHE_FILE_EXTENSION)), "UTF-8");
      sw.write(ENTRY_MARKER+"\r\n");
      JsonParser json = new JsonParser();
      json.setOutputStyle(OutputStyle.PRETTY);
      for (CacheEntry ce : nc.list) {
        sw.write(ce.request.trim());
        sw.write(BREAK+"\r\n");
        if (ce.e != null) {
          sw.write("e: {\r\n");
          if (ce.e.getValueset() != null)
            sw.write("  \"valueSet\" : "+json.composeString(ce.e.getValueset()).trim()+",\r\n");
          sw.write("  \"error\" : \""+Utilities.escapeJson(ce.e.getError()).trim()+"\"\r\n}\r\n");
        } else {
          sw.write("v: {\r\n");
          boolean first = true;
          if (ce.v.getDisplay() != null) {            
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"display\" : \""+Utilities.escapeJson(ce.v.getDisplay()).trim()+"\"");
          }
          if (ce.v.getCode() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"code\" : \""+Utilities.escapeJson(ce.v.getCode()).trim()+"\"");
          }
          if (ce.v.getSystem() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"system\" : \""+Utilities.escapeJson(ce.v.getSystem()).trim()+"\"");
          }
          if (ce.v.getSeverity() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"severity\" : "+"\""+ce.v.getSeverity().toCode().trim()+"\""+"");
          }
          if (ce.v.getMessage() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"error\" : \""+Utilities.escapeJson(ce.v.getMessage()).trim()+"\"");
          }
          if (ce.v.getErrorClass() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"class\" : \""+Utilities.escapeJson(ce.v.getErrorClass().toString())+"\"");
          }
          if (ce.v.getDefinition() != null) {
            if (first) first = false; else sw.write(",\r\n");
            sw.write("  \"definition\" : \""+Utilities.escapeJson(ce.v.getDefinition()).trim()+"\"");
          }
          sw.write("\r\n}\r\n");
        }
        sw.write(ENTRY_MARKER+"\r\n");
      }      
      sw.close();
    } catch (Exception e) {
      System.out.println("error saving "+nc.name+": "+e.getMessage());
    }
  }

  private boolean isCapabilityCache(String fn) {
    if (fn == null) {
      return false;
    }
    return fn.startsWith(CAPABILITY_STATEMENT_TITLE) || fn.startsWith(TERMINOLOGY_CAPABILITIES_TITLE);
  }

  private void loadCapabilityCache(String fn) {
        try {
          String src = TextFile.fileToString(Utilities.path(folder, fn));

      JsonObject o = (JsonObject) new com.google.gson.JsonParser().parse(src);
      Resource resource = new JsonParser().parse(o);

      if (fn.startsWith(CAPABILITY_STATEMENT_TITLE)) {
        this.capabilityStatementCache = (CapabilityStatement) resource;
      } else if (fn.startsWith(TERMINOLOGY_CAPABILITIES_TITLE)) {
        this.terminologyCapabilitiesCache = (TerminologyCapabilities) resource;
      }
    } catch (Exception e) {
      throw new FHIRException("Error loading " + fn + ": " + e.getMessage(), e);
    }
  }



  private CacheEntry getCacheEntry(String request, String resultString) throws IOException {
              CacheEntry ce = new CacheEntry();
              ce.persistent = true;
    ce.request = request;
    boolean e = resultString.charAt(0) == 'e';
    resultString = resultString.substring(3);
    JsonObject o = (JsonObject) new com.google.gson.JsonParser().parse(resultString);
              String error = loadJS(o.get("error"));
              if (e) {
                if (o.has("valueSet"))
                  ce.e = new ValueSetExpansionOutcome((ValueSet) new JsonParser().parse(o.getAsJsonObject("valueSet")), error, TerminologyServiceErrorClass.UNKNOWN);
                else
                  ce.e = new ValueSetExpansionOutcome(error, TerminologyServiceErrorClass.UNKNOWN);
              } else {
                String t = loadJS(o.get("severity"));
                IssueSeverity severity = t == null ? null :  IssueSeverity.fromCode(t);
                String display = loadJS(o.get("display"));
                String code = loadJS(o.get("code"));
                String system = loadJS(o.get("system"));
                String definition = loadJS(o.get("definition"));
                t = loadJS(o.get("class"));
                TerminologyServiceErrorClass errorClass = t == null ? null : TerminologyServiceErrorClass.valueOf(t) ;
                ce.v = new ValidationResult(severity, error, system, new ConceptDefinitionComponent().setDisplay(display).setDefinition(definition).setCode(code)).setErrorClass(errorClass);
              }
    return ce;
  }

  private void loadNamedCache(String fn) {
    int c = 0;
    try {
      String src = TextFile.fileToString(Utilities.path(folder, fn));
      String title = fn.substring(0, fn.lastIndexOf("."));

      NamedCache nc = new NamedCache();
      nc.name = title;

      if (src.startsWith("?"))
        src = src.substring(1);
      int i = src.indexOf(ENTRY_MARKER);
      while (i > -1) {
        c++;
        String s = src.substring(0, i);
        src = src.substring(i + ENTRY_MARKER.length() + 1);
        i = src.indexOf(ENTRY_MARKER);
        if (!Utilities.noString(s)) {
          int j = s.indexOf(BREAK);
          String request = s.substring(0, j);
          String p = s.substring(j + BREAK.length() + 1).trim();

          CacheEntry cacheEntry = getCacheEntry(request, p);

          nc.map.put(String.valueOf(hashJson(cacheEntry.request)), cacheEntry);
          nc.list.add(cacheEntry);
            }
        caches.put(nc.name, nc);
          }        
        } catch (Exception e) {
          System.out.println("Error loading "+fn+": "+e.getMessage()+" entry "+c+" - ignoring it");
          e.printStackTrace();
        }
      }

  private void load() throws FHIRException {
    for (String fn : new File(folder).list()) {
      if (fn.endsWith(CACHE_FILE_EXTENSION) && !fn.equals("validation" + CACHE_FILE_EXTENSION)) {
        try {
          if (isCapabilityCache(fn)) {
            loadCapabilityCache(fn);
          } else {
            loadNamedCache(fn);
          }
        } catch (FHIRException e) {
          throw e;
        }
      }
    }
  }
  
  private String loadJS(JsonElement e) {
    if (e == null)
      return null;
    if (!(e instanceof JsonPrimitive))
      return null;
    String s = e.getAsString();
    if ("".equals(s))
      return null;
    return s;
  }

  protected String hashJson(String s) {
    s = StringUtils.remove(s, ' ');
    s = StringUtils.remove(s, '\n');
    s = StringUtils.remove(s, '\r');
    return String.valueOf(s.hashCode());
  }

  // management
  
  public TerminologyCache copy() {
    // TODO Auto-generated method stub
    return null;
  }
  
  public String summary(ValueSet vs) {
    if (vs == null)
      return "null";
    
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (ConceptSetComponent cc : vs.getCompose().getInclude())
      b.append("Include "+getIncSummary(cc));
    for (ConceptSetComponent cc : vs.getCompose().getExclude())
      b.append("Exclude "+getIncSummary(cc));
    return b.toString();
  }

  private String getIncSummary(ConceptSetComponent cc) {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (UriType vs : cc.getValueSet())
      b.append(vs.asStringValue());
    String vsd = b.length() > 0 ? " where the codes are in the value sets ("+b.toString()+")" : "";
    String system = cc.getSystem();
    if (cc.hasConcept())
      return Integer.toString(cc.getConcept().size())+" codes from "+system+vsd;
    if (cc.hasFilter()) {
      String s = "";
      for (ConceptSetFilterComponent f : cc.getFilter()) {
        if (!Utilities.noString(s))
          s = s + " & ";
        s = s + f.getProperty()+" "+(f.hasOp() ? f.getOp().toCode() : "?")+" "+f.getValue();
      }
      return "from "+system+" where "+s+vsd;
    }
    return "All codes from "+system+vsd;
  }

  public String summary(Coding code) {
    return code.getSystem()+"#"+code.getCode()+": \""+code.getDisplay()+"\"";
  }

  public String summary(CodeableConcept code) {
    StringBuilder b = new StringBuilder();
    b.append("{");
    boolean first = true;
    for (Coding c : code.getCoding()) {
      if (first) first = false; else b.append(",");
      b.append(summary(c));
    }
    b.append("}: \"");
    b.append(code.getText());
    b.append("\"");
    return b.toString();
  }

  public void removeCS(String url) {
    synchronized (lock) {
      String name = getNameForSystem(url);
      if (caches.containsKey(name)) {
        caches.remove(name);
      }
    }   
  }

  public String getFolder() {
    return folder;
  }
 
  
}