package org.hl7.fhir.core.generator.engine;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.core.generator.analysis.Analyser;
import org.hl7.fhir.core.generator.analysis.Analysis;
import org.hl7.fhir.core.generator.codegen.Configuration;
import org.hl7.fhir.core.generator.codegen.JavaConstantsGenerator;
import org.hl7.fhir.core.generator.codegen.JavaEnumerationsGenerator;
import org.hl7.fhir.core.generator.codegen.JavaFactoryGenerator;
import org.hl7.fhir.core.generator.codegen.JavaParserJsonGenerator;
import org.hl7.fhir.core.generator.codegen.JavaParserRdfGenerator;
import org.hl7.fhir.core.generator.codegen.JavaParserXmlGenerator;
import org.hl7.fhir.core.generator.codegen.JavaResourceGenerator;
import org.hl7.fhir.core.generator.codegen.JavaTypeGenerator;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.ToolsVersion;

public class JavaCoreGenerator {

  // C:\work\org.hl7.fhir\org.hl7.fhir.core\org.hl7.fhir.r5
  // C:\work\org.hl7.fhir\org.hl7.fhir.core\org.hl7.fhir.r5.new
  
  public static void main(String[] args) throws Exception {
    System.out.println("HAPI CORE Code Generator");
    if (args.length != 3) {
      System.out.println("Usage: invoke with 3 command line parameters to generate HAPI R5 code");
      System.out.println("1: fhir version to generate from (e.g. 4.2.0 or 'current'");
      System.out.println("2: project directory to read java-adorment from - e.g. C:\\work\\org.hl7.fhir\\org.hl7.fhir.core\\org.hl7.fhir.r5");
      System.out.println("3: project directory to generate code into - e.g. C:\\work\\org.hl7.fhir\\org.hl7.fhir.core\\org.hl7.fhir.r5.new");
    } else {
      String version = args[0];
      String src = args[1];
      String dest = args[2];
      new JavaCoreGenerator().generate(version, src, dest);
    }
  }

  private void generate(String version, String src, String dest) throws Exception {
    long start = System.currentTimeMillis();
    Date date = new Date();
    
    String ap = Utilities.path(src);
    System.out.println("Load Configuration from "+ap);
    Configuration config = new Configuration(ap);
    String pid = VersionUtilities.isR4BVer(version) ? "r4b" : "r5";
    String jid = VersionUtilities.isR4BVer(version) ? "r4b" : "r5";
    
    
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    System.out.println("Cache: "+pcm.getFolder());
    System.out.println("Load hl7.fhir."+pid+".core");
    NpmPackage npm = pcm.loadPackage("hl7.fhir."+pid+".core", version);
    Definitions master = VersionUtilities.isR4BVer(version) ? DefinitionsLoaderR4B.load(npm) : DefinitionsLoaderR5.load(npm); 
    master.fix();
    markValueSets(master, config);
    
    System.out.println("Load hl7.fhir."+pid+".expansions");
    Definitions expansions = DefinitionsLoaderR5.load(pcm.loadPackage("hl7.fhir."+pid+".expansions", version));
    
    System.out.println("Process Expansions");
    updateExpansions(master, expansions);
    
    System.out.println("Generate Model in "+dest);   
    System.out.println(" .. Constants");
    JavaConstantsGenerator cgen = new JavaConstantsGenerator(new FileOutputStream(Utilities.path(dest, "src", "main", "java", "org", "hl7", "fhir", jid, "model", "Constants.java")), master, config, date, npm.version(), jid);
    cgen.generate();
    cgen.close();
    System.out.println(" .. Enumerations");
    JavaEnumerationsGenerator egen = new JavaEnumerationsGenerator(new FileOutputStream(Utilities.path(dest, "src", "main", "java", "org", "hl7", "fhir", jid, "model", "Enumerations.java")), master, config, date, npm.version(), jid);
    egen.generate();
    egen.close();
    
    JavaFactoryGenerator fgen = new JavaFactoryGenerator(new FileOutputStream(Utilities.path(dest, "src", "main", "java", "org", "hl7", "fhir", jid, "model", "ResourceFactory.java")), master, config, date, npm.version(), jid);
    JavaTypeGenerator tgen = new JavaTypeGenerator(new FileOutputStream(Utilities.path(dest, "src", "main", "java", "org", "hl7", "fhir", jid, "model", "ResourceType.java")), master, config, date, npm.version(), jid);
    JavaParserJsonGenerator jgen = new JavaParserJsonGenerator(new FileOutputStream(Utilities.path(dest, "src", "main", "java", "org", "hl7", "fhir", jid, "formats", "JsonParser.java")), master, config, date, npm.version(), jid);
    JavaParserXmlGenerator xgen = new JavaParserXmlGenerator(new FileOutputStream(Utilities.path(dest, "src", "main", "java", "org", "hl7", "fhir", jid, "formats", "XmlParser.java")), master, config, date, npm.version(), jid);
    JavaParserRdfGenerator rgen = new JavaParserRdfGenerator(new FileOutputStream(Utilities.path(dest, "src", "main", "java", "org", "hl7", "fhir", jid, "formats", "RdfParser.java")), master, config, date, npm.version(), jid);
    
    if (VersionUtilities.isR4BVer(version)) {
      StructureDefinition sd = master.getStructures().get("http://hl7.org/fhir/StructureDefinition/Element");
      genClass(version, dest, date, config, jid, npm, master, jgen, xgen, rgen, sd);      
    }
    for (StructureDefinition sd : master.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() == StructureDefinitionKind.COMPLEXTYPE) {
        if (!Utilities.existsInList(sd.getName(), "Base", "PrimitiveType") && !sd.getName().contains(".") && sd.getAbstract()) {
          genClass(version, dest, date, config, jid, npm, master, jgen, xgen, rgen, sd);
        }
      }
    }
    for (StructureDefinition sd : master.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() == StructureDefinitionKind.COMPLEXTYPE) {
        if (!Utilities.existsInList(sd.getName(), "Base", "PrimitiveType") && !sd.getName().contains(".") && !sd.getAbstract()) {
          genClass(version, dest, date, config, jid, npm, master, jgen, xgen, rgen, sd);
        }
      }
    }
    if (VersionUtilities.isR4BVer(version)) {
      StructureDefinition sd = master.getStructures().get("http://hl7.org/fhir/StructureDefinition/Resource");
      genClass(version, dest, date, config, jid, npm, master, jgen, xgen, rgen, sd);      
    }
    for (StructureDefinition sd : master.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() == StructureDefinitionKind.RESOURCE) {
        if (!Utilities.existsInList(sd.getName(), "Base", "PrimitiveType") && !sd.getName().contains(".") && sd.getAbstract()) {
          genClass(version, dest, date, config, jid, npm, master, jgen, xgen, rgen, sd);
        }
      }
    }
    for (StructureDefinition sd : master.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() == StructureDefinitionKind.RESOURCE) {
        if (!Utilities.existsInList(sd.getName(), "Base", "PrimitiveType") && !sd.getName().contains(".") && !sd.getAbstract()) {
          genClass(version, dest, date, config, jid, npm, master, jgen, xgen, rgen, sd);
        }
      }
    }
    System.out.println(" .. Factory");
    fgen.generate();
    fgen.close();
    System.out.println(" .. Types");
    tgen.generate();
    tgen.close();
    System.out.println(" .. JsonParser");
    jgen.generate();
    jgen.close();
    System.out.println(" .. XmlParser");
    xgen.generate();
    xgen.close();
    System.out.println(" .. RdfParser");
    rgen.generate();
    rgen.close();
    System.out.println("Done ("+Long.toString(System.currentTimeMillis()-start)+"ms)");   
    
  }

  public void genClass(String version, String dest, Date date, Configuration config, String jid, NpmPackage npm, Definitions master,
      JavaParserJsonGenerator jgen, JavaParserXmlGenerator xgen, JavaParserRdfGenerator rgen, StructureDefinition sd)
      throws Exception, IOException, UnsupportedEncodingException, FileNotFoundException {
    String name = javaName(sd.getName());

    System.out.println(" .. "+name);
    Analyser jca = new Analyser(master, config, version);
    Analysis analysis = jca.analyse(sd);
    
    String fn = Utilities.path(dest, "src", "main", "java", "org", "hl7", "fhir", jid, "model", name+".java");
    JavaResourceGenerator gen = new JavaResourceGenerator(new FileOutputStream(fn), master, config, date, npm.version(), jid);
    gen.generate(analysis); 
    gen.close();
    jgen.seeClass(analysis);
    xgen.seeClass(analysis);
    rgen.seeClass(analysis);
  }

  @SuppressWarnings("unchecked")
  private void markValueSets(Definitions defns, Configuration config) {
    for (StructureDefinition sd : defns.getStructures().getList()) {
      if (sd.getDerivation() == TypeDerivationRule.SPECIALIZATION && sd.getKind() != StructureDefinitionKind.PRIMITIVETYPE && !sd.getName().contains(".")) {
        for (ElementDefinition ed : sd.getSnapshot().getElement()) {
          if (ed.hasBinding() && ed.getBinding().hasValueSet() && ed.getBinding().getStrength() == BindingStrength.REQUIRED) {
            ValueSet vs = defns.getValuesets().get(ed.getBinding().getValueSet());
            if (vs != null) {
              if (!vs.hasUserData("usages")) {
                vs.setUserData("usages", new ArrayList<>());
              }
              List<String> list = (List<String>) vs.getUserData("usages");
              if (!list.contains(sd.getName())) {
                list.add(sd.getName());
              }
            }
          }
        }
      }
    }

    for (ValueSet vs : defns.getValuesets().getList()) {
      List<String> list = (List<String>) vs.getUserData("usages");
      boolean shared = false;
      if (list != null && list.size() > 1) {
        shared = true;
      }
      if (config.getIni().hasProperty("shared", vs.getUrl())) {
        shared = config.getIni().getBooleanProperty("shared", vs.getUrl());
      }
      if (shared) {
        vs.setUserData("shared", true);
      }
    }
  }

  private String javaName(String name) {
    return "List".equals(name) ? "ListResource" : name;
  }

  private void updateExpansions(Definitions master, Definitions expansions) {
    for (ValueSet vs: master.getValuesets().getList()) {
      ValueSet vse = expansions.getValuesets().get(vs.getUrl());
      if (vse != null) {
        vs.setUserData("expansion", vse);
      }
    }    
  }




}