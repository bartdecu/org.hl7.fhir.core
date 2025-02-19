package org.hl7.fhir.r5.model;


/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

// Generated on Fri, Jul 15, 2022 11:20+1000 for FHIR vcurrent

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * The header for a message exchange that is either requesting or responding to an action.  The reference(s) that are the subject of the action as well as other information related to the action are typically transmitted in a bundle in which the MessageHeader resource instance is the first resource in the bundle.
 */
@ResourceDef(name="MessageHeader", profile="http://hl7.org/fhir/StructureDefinition/MessageHeader")
public class MessageHeader extends DomainResource {

    public enum ResponseType {
        /**
         * The message was accepted and processed without error.
         */
        OK, 
        /**
         * Some internal unexpected error occurred - wait and try again. Note - this is usually used for things like database unavailable, which may be expected to resolve, though human intervention may be required.
         */
        TRANSIENTERROR, 
        /**
         * The message was rejected because of a problem with the content. There is no point in re-sending without change. The response narrative SHALL describe the issue.
         */
        FATALERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ResponseType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("ok".equals(codeString))
          return OK;
        if ("transient-error".equals(codeString))
          return TRANSIENTERROR;
        if ("fatal-error".equals(codeString))
          return FATALERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ResponseType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case OK: return "ok";
            case TRANSIENTERROR: return "transient-error";
            case FATALERROR: return "fatal-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case OK: return "http://hl7.org/fhir/response-code";
            case TRANSIENTERROR: return "http://hl7.org/fhir/response-code";
            case FATALERROR: return "http://hl7.org/fhir/response-code";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case OK: return "The message was accepted and processed without error.";
            case TRANSIENTERROR: return "Some internal unexpected error occurred - wait and try again. Note - this is usually used for things like database unavailable, which may be expected to resolve, though human intervention may be required.";
            case FATALERROR: return "The message was rejected because of a problem with the content. There is no point in re-sending without change. The response narrative SHALL describe the issue.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case OK: return "OK";
            case TRANSIENTERROR: return "Transient Error";
            case FATALERROR: return "Fatal Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ResponseTypeEnumFactory implements EnumFactory<ResponseType> {
    public ResponseType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("ok".equals(codeString))
          return ResponseType.OK;
        if ("transient-error".equals(codeString))
          return ResponseType.TRANSIENTERROR;
        if ("fatal-error".equals(codeString))
          return ResponseType.FATALERROR;
        throw new IllegalArgumentException("Unknown ResponseType code '"+codeString+"'");
        }
        public Enumeration<ResponseType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ResponseType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("ok".equals(codeString))
          return new Enumeration<ResponseType>(this, ResponseType.OK);
        if ("transient-error".equals(codeString))
          return new Enumeration<ResponseType>(this, ResponseType.TRANSIENTERROR);
        if ("fatal-error".equals(codeString))
          return new Enumeration<ResponseType>(this, ResponseType.FATALERROR);
        throw new FHIRException("Unknown ResponseType code '"+codeString+"'");
        }
    public String toCode(ResponseType code) {
      if (code == ResponseType.OK)
        return "ok";
      if (code == ResponseType.TRANSIENTERROR)
        return "transient-error";
      if (code == ResponseType.FATALERROR)
        return "fatal-error";
      return "?";
      }
    public String toSystem(ResponseType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class MessageDestinationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Human-readable name for the target system.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Name of system", formalDefinition="Human-readable name for the target system." )
        protected StringType name;

        /**
         * Identifies the target end system in situations where the initial message transmission is to an intermediary system.
         */
        @Child(name = "target", type = {Device.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Particular delivery destination within the destination", formalDefinition="Identifies the target end system in situations where the initial message transmission is to an intermediary system." )
        protected Reference target;

        /**
         * Indicates where the message should be routed to.
         */
        @Child(name = "endpoint", type = {UrlType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Actual destination address or id", formalDefinition="Indicates where the message should be routed to." )
        protected UrlType endpoint;

        /**
         * Allows data conveyed by a message to be addressed to a particular person or department when routing to a specific application isn't sufficient.
         */
        @Child(name = "receiver", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Intended \"real-world\" recipient for the data", formalDefinition="Allows data conveyed by a message to be addressed to a particular person or department when routing to a specific application isn't sufficient." )
        protected Reference receiver;

        private static final long serialVersionUID = -686949282L;

    /**
     * Constructor
     */
      public MessageDestinationComponent() {
        super();
      }

        /**
         * @return {@link #name} (Human-readable name for the target system.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MessageDestinationComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new StringType(); // bb
          return this.name;
        }

        public boolean hasNameElement() { 
          return this.name != null && !this.name.isEmpty();
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (Human-readable name for the target system.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public MessageDestinationComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Human-readable name for the target system.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Human-readable name for the target system.
         */
        public MessageDestinationComponent setName(String value) { 
          if (Utilities.noString(value))
            this.name = null;
          else {
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #target} (Identifies the target end system in situations where the initial message transmission is to an intermediary system.)
         */
        public Reference getTarget() { 
          if (this.target == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MessageDestinationComponent.target");
            else if (Configuration.doAutoCreate())
              this.target = new Reference(); // cc
          return this.target;
        }

        public boolean hasTarget() { 
          return this.target != null && !this.target.isEmpty();
        }

        /**
         * @param value {@link #target} (Identifies the target end system in situations where the initial message transmission is to an intermediary system.)
         */
        public MessageDestinationComponent setTarget(Reference value) { 
          this.target = value;
          return this;
        }

        /**
         * @return {@link #endpoint} (Indicates where the message should be routed to.). This is the underlying object with id, value and extensions. The accessor "getEndpoint" gives direct access to the value
         */
        public UrlType getEndpointElement() { 
          if (this.endpoint == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MessageDestinationComponent.endpoint");
            else if (Configuration.doAutoCreate())
              this.endpoint = new UrlType(); // bb
          return this.endpoint;
        }

        public boolean hasEndpointElement() { 
          return this.endpoint != null && !this.endpoint.isEmpty();
        }

        public boolean hasEndpoint() { 
          return this.endpoint != null && !this.endpoint.isEmpty();
        }

        /**
         * @param value {@link #endpoint} (Indicates where the message should be routed to.). This is the underlying object with id, value and extensions. The accessor "getEndpoint" gives direct access to the value
         */
        public MessageDestinationComponent setEndpointElement(UrlType value) { 
          this.endpoint = value;
          return this;
        }

        /**
         * @return Indicates where the message should be routed to.
         */
        public String getEndpoint() { 
          return this.endpoint == null ? null : this.endpoint.getValue();
        }

        /**
         * @param value Indicates where the message should be routed to.
         */
        public MessageDestinationComponent setEndpoint(String value) { 
          if (Utilities.noString(value))
            this.endpoint = null;
          else {
            if (this.endpoint == null)
              this.endpoint = new UrlType();
            this.endpoint.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #receiver} (Allows data conveyed by a message to be addressed to a particular person or department when routing to a specific application isn't sufficient.)
         */
        public Reference getReceiver() { 
          if (this.receiver == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MessageDestinationComponent.receiver");
            else if (Configuration.doAutoCreate())
              this.receiver = new Reference(); // cc
          return this.receiver;
        }

        public boolean hasReceiver() { 
          return this.receiver != null && !this.receiver.isEmpty();
        }

        /**
         * @param value {@link #receiver} (Allows data conveyed by a message to be addressed to a particular person or department when routing to a specific application isn't sufficient.)
         */
        public MessageDestinationComponent setReceiver(Reference value) { 
          this.receiver = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "Human-readable name for the target system.", 0, 1, name));
          children.add(new Property("target", "Reference(Device)", "Identifies the target end system in situations where the initial message transmission is to an intermediary system.", 0, 1, target));
          children.add(new Property("endpoint", "url", "Indicates where the message should be routed to.", 0, 1, endpoint));
          children.add(new Property("receiver", "Reference(Practitioner|PractitionerRole|Organization)", "Allows data conveyed by a message to be addressed to a particular person or department when routing to a specific application isn't sufficient.", 0, 1, receiver));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "Human-readable name for the target system.", 0, 1, name);
          case -880905839: /*target*/  return new Property("target", "Reference(Device)", "Identifies the target end system in situations where the initial message transmission is to an intermediary system.", 0, 1, target);
          case 1741102485: /*endpoint*/  return new Property("endpoint", "url", "Indicates where the message should be routed to.", 0, 1, endpoint);
          case -808719889: /*receiver*/  return new Property("receiver", "Reference(Practitioner|PractitionerRole|Organization)", "Allows data conveyed by a message to be addressed to a particular person or department when routing to a specific application isn't sufficient.", 0, 1, receiver);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -880905839: /*target*/ return this.target == null ? new Base[0] : new Base[] {this.target}; // Reference
        case 1741102485: /*endpoint*/ return this.endpoint == null ? new Base[0] : new Base[] {this.endpoint}; // UrlType
        case -808719889: /*receiver*/ return this.receiver == null ? new Base[0] : new Base[] {this.receiver}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -880905839: // target
          this.target = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1741102485: // endpoint
          this.endpoint = TypeConvertor.castToUrl(value); // UrlType
          return value;
        case -808719889: // receiver
          this.receiver = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("target")) {
          this.target = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("endpoint")) {
          this.endpoint = TypeConvertor.castToUrl(value); // UrlType
        } else if (name.equals("receiver")) {
          this.receiver = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case -880905839:  return getTarget();
        case 1741102485:  return getEndpointElement();
        case -808719889:  return getReceiver();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case -880905839: /*target*/ return new String[] {"Reference"};
        case 1741102485: /*endpoint*/ return new String[] {"url"};
        case -808719889: /*receiver*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type MessageHeader.destination.name");
        }
        else if (name.equals("target")) {
          this.target = new Reference();
          return this.target;
        }
        else if (name.equals("endpoint")) {
          throw new FHIRException("Cannot call addChild on a primitive type MessageHeader.destination.endpoint");
        }
        else if (name.equals("receiver")) {
          this.receiver = new Reference();
          return this.receiver;
        }
        else
          return super.addChild(name);
      }

      public MessageDestinationComponent copy() {
        MessageDestinationComponent dst = new MessageDestinationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MessageDestinationComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.target = target == null ? null : target.copy();
        dst.endpoint = endpoint == null ? null : endpoint.copy();
        dst.receiver = receiver == null ? null : receiver.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MessageDestinationComponent))
          return false;
        MessageDestinationComponent o = (MessageDestinationComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(target, o.target, true) && compareDeep(endpoint, o.endpoint, true)
           && compareDeep(receiver, o.receiver, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MessageDestinationComponent))
          return false;
        MessageDestinationComponent o = (MessageDestinationComponent) other_;
        return compareValues(name, o.name, true) && compareValues(endpoint, o.endpoint, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, target, endpoint, receiver
          );
      }

  public String fhirType() {
    return "MessageHeader.destination";

  }

  }

    @Block()
    public static class MessageSourceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Human-readable name for the source system.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Name of system", formalDefinition="Human-readable name for the source system." )
        protected StringType name;

        /**
         * May include configuration or other information useful in debugging.
         */
        @Child(name = "software", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Name of software running the system", formalDefinition="May include configuration or other information useful in debugging." )
        protected StringType software;

        /**
         * Can convey versions of multiple systems in situations where a message passes through multiple hands.
         */
        @Child(name = "version", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Version of software running", formalDefinition="Can convey versions of multiple systems in situations where a message passes through multiple hands." )
        protected StringType version;

        /**
         * An e-mail, phone, website or other contact point to use to resolve issues with message communications.
         */
        @Child(name = "contact", type = {ContactPoint.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Human contact for problems", formalDefinition="An e-mail, phone, website or other contact point to use to resolve issues with message communications." )
        protected ContactPoint contact;

        /**
         * Identifies the routing target to send acknowledgements to.
         */
        @Child(name = "endpoint", type = {UrlType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Actual message source address or id", formalDefinition="Identifies the routing target to send acknowledgements to." )
        protected UrlType endpoint;

        private static final long serialVersionUID = -350916401L;

    /**
     * Constructor
     */
      public MessageSourceComponent() {
        super();
      }

        /**
         * @return {@link #name} (Human-readable name for the source system.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MessageSourceComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new StringType(); // bb
          return this.name;
        }

        public boolean hasNameElement() { 
          return this.name != null && !this.name.isEmpty();
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (Human-readable name for the source system.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public MessageSourceComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Human-readable name for the source system.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Human-readable name for the source system.
         */
        public MessageSourceComponent setName(String value) { 
          if (Utilities.noString(value))
            this.name = null;
          else {
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #software} (May include configuration or other information useful in debugging.). This is the underlying object with id, value and extensions. The accessor "getSoftware" gives direct access to the value
         */
        public StringType getSoftwareElement() { 
          if (this.software == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MessageSourceComponent.software");
            else if (Configuration.doAutoCreate())
              this.software = new StringType(); // bb
          return this.software;
        }

        public boolean hasSoftwareElement() { 
          return this.software != null && !this.software.isEmpty();
        }

        public boolean hasSoftware() { 
          return this.software != null && !this.software.isEmpty();
        }

        /**
         * @param value {@link #software} (May include configuration or other information useful in debugging.). This is the underlying object with id, value and extensions. The accessor "getSoftware" gives direct access to the value
         */
        public MessageSourceComponent setSoftwareElement(StringType value) { 
          this.software = value;
          return this;
        }

        /**
         * @return May include configuration or other information useful in debugging.
         */
        public String getSoftware() { 
          return this.software == null ? null : this.software.getValue();
        }

        /**
         * @param value May include configuration or other information useful in debugging.
         */
        public MessageSourceComponent setSoftware(String value) { 
          if (Utilities.noString(value))
            this.software = null;
          else {
            if (this.software == null)
              this.software = new StringType();
            this.software.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #version} (Can convey versions of multiple systems in situations where a message passes through multiple hands.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
         */
        public StringType getVersionElement() { 
          if (this.version == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MessageSourceComponent.version");
            else if (Configuration.doAutoCreate())
              this.version = new StringType(); // bb
          return this.version;
        }

        public boolean hasVersionElement() { 
          return this.version != null && !this.version.isEmpty();
        }

        public boolean hasVersion() { 
          return this.version != null && !this.version.isEmpty();
        }

        /**
         * @param value {@link #version} (Can convey versions of multiple systems in situations where a message passes through multiple hands.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
         */
        public MessageSourceComponent setVersionElement(StringType value) { 
          this.version = value;
          return this;
        }

        /**
         * @return Can convey versions of multiple systems in situations where a message passes through multiple hands.
         */
        public String getVersion() { 
          return this.version == null ? null : this.version.getValue();
        }

        /**
         * @param value Can convey versions of multiple systems in situations where a message passes through multiple hands.
         */
        public MessageSourceComponent setVersion(String value) { 
          if (Utilities.noString(value))
            this.version = null;
          else {
            if (this.version == null)
              this.version = new StringType();
            this.version.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #contact} (An e-mail, phone, website or other contact point to use to resolve issues with message communications.)
         */
        public ContactPoint getContact() { 
          if (this.contact == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MessageSourceComponent.contact");
            else if (Configuration.doAutoCreate())
              this.contact = new ContactPoint(); // cc
          return this.contact;
        }

        public boolean hasContact() { 
          return this.contact != null && !this.contact.isEmpty();
        }

        /**
         * @param value {@link #contact} (An e-mail, phone, website or other contact point to use to resolve issues with message communications.)
         */
        public MessageSourceComponent setContact(ContactPoint value) { 
          this.contact = value;
          return this;
        }

        /**
         * @return {@link #endpoint} (Identifies the routing target to send acknowledgements to.). This is the underlying object with id, value and extensions. The accessor "getEndpoint" gives direct access to the value
         */
        public UrlType getEndpointElement() { 
          if (this.endpoint == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MessageSourceComponent.endpoint");
            else if (Configuration.doAutoCreate())
              this.endpoint = new UrlType(); // bb
          return this.endpoint;
        }

        public boolean hasEndpointElement() { 
          return this.endpoint != null && !this.endpoint.isEmpty();
        }

        public boolean hasEndpoint() { 
          return this.endpoint != null && !this.endpoint.isEmpty();
        }

        /**
         * @param value {@link #endpoint} (Identifies the routing target to send acknowledgements to.). This is the underlying object with id, value and extensions. The accessor "getEndpoint" gives direct access to the value
         */
        public MessageSourceComponent setEndpointElement(UrlType value) { 
          this.endpoint = value;
          return this;
        }

        /**
         * @return Identifies the routing target to send acknowledgements to.
         */
        public String getEndpoint() { 
          return this.endpoint == null ? null : this.endpoint.getValue();
        }

        /**
         * @param value Identifies the routing target to send acknowledgements to.
         */
        public MessageSourceComponent setEndpoint(String value) { 
          if (Utilities.noString(value))
            this.endpoint = null;
          else {
            if (this.endpoint == null)
              this.endpoint = new UrlType();
            this.endpoint.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "Human-readable name for the source system.", 0, 1, name));
          children.add(new Property("software", "string", "May include configuration or other information useful in debugging.", 0, 1, software));
          children.add(new Property("version", "string", "Can convey versions of multiple systems in situations where a message passes through multiple hands.", 0, 1, version));
          children.add(new Property("contact", "ContactPoint", "An e-mail, phone, website or other contact point to use to resolve issues with message communications.", 0, 1, contact));
          children.add(new Property("endpoint", "url", "Identifies the routing target to send acknowledgements to.", 0, 1, endpoint));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "Human-readable name for the source system.", 0, 1, name);
          case 1319330215: /*software*/  return new Property("software", "string", "May include configuration or other information useful in debugging.", 0, 1, software);
          case 351608024: /*version*/  return new Property("version", "string", "Can convey versions of multiple systems in situations where a message passes through multiple hands.", 0, 1, version);
          case 951526432: /*contact*/  return new Property("contact", "ContactPoint", "An e-mail, phone, website or other contact point to use to resolve issues with message communications.", 0, 1, contact);
          case 1741102485: /*endpoint*/  return new Property("endpoint", "url", "Identifies the routing target to send acknowledgements to.", 0, 1, endpoint);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 1319330215: /*software*/ return this.software == null ? new Base[0] : new Base[] {this.software}; // StringType
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : new Base[] {this.contact}; // ContactPoint
        case 1741102485: /*endpoint*/ return this.endpoint == null ? new Base[0] : new Base[] {this.endpoint}; // UrlType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 1319330215: // software
          this.software = TypeConvertor.castToString(value); // StringType
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case 951526432: // contact
          this.contact = TypeConvertor.castToContactPoint(value); // ContactPoint
          return value;
        case 1741102485: // endpoint
          this.endpoint = TypeConvertor.castToUrl(value); // UrlType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("software")) {
          this.software = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("contact")) {
          this.contact = TypeConvertor.castToContactPoint(value); // ContactPoint
        } else if (name.equals("endpoint")) {
          this.endpoint = TypeConvertor.castToUrl(value); // UrlType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 1319330215:  return getSoftwareElement();
        case 351608024:  return getVersionElement();
        case 951526432:  return getContact();
        case 1741102485:  return getEndpointElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 1319330215: /*software*/ return new String[] {"string"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactPoint"};
        case 1741102485: /*endpoint*/ return new String[] {"url"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type MessageHeader.source.name");
        }
        else if (name.equals("software")) {
          throw new FHIRException("Cannot call addChild on a primitive type MessageHeader.source.software");
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type MessageHeader.source.version");
        }
        else if (name.equals("contact")) {
          this.contact = new ContactPoint();
          return this.contact;
        }
        else if (name.equals("endpoint")) {
          throw new FHIRException("Cannot call addChild on a primitive type MessageHeader.source.endpoint");
        }
        else
          return super.addChild(name);
      }

      public MessageSourceComponent copy() {
        MessageSourceComponent dst = new MessageSourceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MessageSourceComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.software = software == null ? null : software.copy();
        dst.version = version == null ? null : version.copy();
        dst.contact = contact == null ? null : contact.copy();
        dst.endpoint = endpoint == null ? null : endpoint.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MessageSourceComponent))
          return false;
        MessageSourceComponent o = (MessageSourceComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(software, o.software, true) && compareDeep(version, o.version, true)
           && compareDeep(contact, o.contact, true) && compareDeep(endpoint, o.endpoint, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MessageSourceComponent))
          return false;
        MessageSourceComponent o = (MessageSourceComponent) other_;
        return compareValues(name, o.name, true) && compareValues(software, o.software, true) && compareValues(version, o.version, true)
           && compareValues(endpoint, o.endpoint, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, software, version
          , contact, endpoint);
      }

  public String fhirType() {
    return "MessageHeader.source";

  }

  }

    @Block()
    public static class MessageHeaderResponseComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The MessageHeader.id of the message to which this message is a response.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Id of original message", formalDefinition="The MessageHeader.id of the message to which this message is a response." )
        protected Identifier identifier;

        /**
         * Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not.
         */
        @Child(name = "code", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="ok | transient-error | fatal-error", formalDefinition="Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/response-code")
        protected Enumeration<ResponseType> code;

        /**
         * Full details of any issues found in the message.
         */
        @Child(name = "details", type = {OperationOutcome.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Specific list of hints/warnings/errors", formalDefinition="Full details of any issues found in the message." )
        protected Reference details;

        private static final long serialVersionUID = 1091046778L;

    /**
     * Constructor
     */
      public MessageHeaderResponseComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MessageHeaderResponseComponent(Identifier identifier, ResponseType code) {
        super();
        this.setIdentifier(identifier);
        this.setCode(code);
      }

        /**
         * @return {@link #identifier} (The MessageHeader.id of the message to which this message is a response.)
         */
        public Identifier getIdentifier() { 
          if (this.identifier == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MessageHeaderResponseComponent.identifier");
            else if (Configuration.doAutoCreate())
              this.identifier = new Identifier(); // cc
          return this.identifier;
        }

        public boolean hasIdentifier() { 
          return this.identifier != null && !this.identifier.isEmpty();
        }

        /**
         * @param value {@link #identifier} (The MessageHeader.id of the message to which this message is a response.)
         */
        public MessageHeaderResponseComponent setIdentifier(Identifier value) { 
          this.identifier = value;
          return this;
        }

        /**
         * @return {@link #code} (Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public Enumeration<ResponseType> getCodeElement() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MessageHeaderResponseComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new Enumeration<ResponseType>(new ResponseTypeEnumFactory()); // bb
          return this.code;
        }

        public boolean hasCodeElement() { 
          return this.code != null && !this.code.isEmpty();
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public MessageHeaderResponseComponent setCodeElement(Enumeration<ResponseType> value) { 
          this.code = value;
          return this;
        }

        /**
         * @return Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not.
         */
        public ResponseType getCode() { 
          return this.code == null ? null : this.code.getValue();
        }

        /**
         * @param value Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not.
         */
        public MessageHeaderResponseComponent setCode(ResponseType value) { 
            if (this.code == null)
              this.code = new Enumeration<ResponseType>(new ResponseTypeEnumFactory());
            this.code.setValue(value);
          return this;
        }

        /**
         * @return {@link #details} (Full details of any issues found in the message.)
         */
        public Reference getDetails() { 
          if (this.details == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MessageHeaderResponseComponent.details");
            else if (Configuration.doAutoCreate())
              this.details = new Reference(); // cc
          return this.details;
        }

        public boolean hasDetails() { 
          return this.details != null && !this.details.isEmpty();
        }

        /**
         * @param value {@link #details} (Full details of any issues found in the message.)
         */
        public MessageHeaderResponseComponent setDetails(Reference value) { 
          this.details = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("identifier", "Identifier", "The MessageHeader.id of the message to which this message is a response.", 0, 1, identifier));
          children.add(new Property("code", "code", "Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not.", 0, 1, code));
          children.add(new Property("details", "Reference(OperationOutcome)", "Full details of any issues found in the message.", 0, 1, details));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "The MessageHeader.id of the message to which this message is a response.", 0, 1, identifier);
          case 3059181: /*code*/  return new Property("code", "code", "Code that identifies the type of response to the message - whether it was successful or not, and whether it should be resent or not.", 0, 1, code);
          case 1557721666: /*details*/  return new Property("details", "Reference(OperationOutcome)", "Full details of any issues found in the message.", 0, 1, details);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : new Base[] {this.identifier}; // Identifier
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // Enumeration<ResponseType>
        case 1557721666: /*details*/ return this.details == null ? new Base[0] : new Base[] {this.details}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case 3059181: // code
          value = new ResponseTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.code = (Enumeration) value; // Enumeration<ResponseType>
          return value;
        case 1557721666: // details
          this.details = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("code")) {
          value = new ResponseTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.code = (Enumeration) value; // Enumeration<ResponseType>
        } else if (name.equals("details")) {
          this.details = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return getIdentifier();
        case 3059181:  return getCodeElement();
        case 1557721666:  return getDetails();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3059181: /*code*/ return new String[] {"code"};
        case 1557721666: /*details*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = new Identifier();
          return this.identifier;
        }
        else if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a primitive type MessageHeader.response.code");
        }
        else if (name.equals("details")) {
          this.details = new Reference();
          return this.details;
        }
        else
          return super.addChild(name);
      }

      public MessageHeaderResponseComponent copy() {
        MessageHeaderResponseComponent dst = new MessageHeaderResponseComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MessageHeaderResponseComponent dst) {
        super.copyValues(dst);
        dst.identifier = identifier == null ? null : identifier.copy();
        dst.code = code == null ? null : code.copy();
        dst.details = details == null ? null : details.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MessageHeaderResponseComponent))
          return false;
        MessageHeaderResponseComponent o = (MessageHeaderResponseComponent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(code, o.code, true) && compareDeep(details, o.details, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MessageHeaderResponseComponent))
          return false;
        MessageHeaderResponseComponent o = (MessageHeaderResponseComponent) other_;
        return compareValues(code, o.code, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, code, details
          );
      }

  public String fhirType() {
    return "MessageHeader.response";

  }

  }

    /**
     * Code that identifies the event this message represents and connects it with its definition. Events defined as part of the FHIR specification have the system value "http://terminology.hl7.org/CodeSystem/message-events".  Alternatively uri to the EventDefinition.
     */
    @Child(name = "event", type = {Coding.class, UriType.class}, order=0, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Code for the event this message represents or link to event definition", formalDefinition="Code that identifies the event this message represents and connects it with its definition. Events defined as part of the FHIR specification have the system value \"http://terminology.hl7.org/CodeSystem/message-events\".  Alternatively uri to the EventDefinition." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/message-events")
    protected DataType event;

    /**
     * The destination application which the message is intended for.
     */
    @Child(name = "destination", type = {}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Message destination application(s)", formalDefinition="The destination application which the message is intended for." )
    protected List<MessageDestinationComponent> destination;

    /**
     * Identifies the sending system to allow the use of a trust relationship.
     */
    @Child(name = "sender", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Real world sender of the message", formalDefinition="Identifies the sending system to allow the use of a trust relationship." )
    protected Reference sender;

    /**
     * The person or device that performed the data entry leading to this message. When there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions.
     */
    @Child(name = "enterer", type = {Practitioner.class, PractitionerRole.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The source of the data entry", formalDefinition="The person or device that performed the data entry leading to this message. When there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions." )
    protected Reference enterer;

    /**
     * The logical author of the message - the personor device that decided the described event should happen. When there is more than one candidate, pick the most proximal to the MessageHeader. Can provide other authors in extensions.
     */
    @Child(name = "author", type = {Practitioner.class, PractitionerRole.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The source of the decision", formalDefinition="The logical author of the message - the personor device that decided the described event should happen. When there is more than one candidate, pick the most proximal to the MessageHeader. Can provide other authors in extensions." )
    protected Reference author;

    /**
     * The source application from which this message originated.
     */
    @Child(name = "source", type = {}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Message source application", formalDefinition="The source application from which this message originated." )
    protected MessageSourceComponent source;

    /**
     * The person or organization that accepts overall responsibility for the contents of the message. The implication is that the message event happened under the policies of the responsible party.
     */
    @Child(name = "responsible", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Final responsibility for event", formalDefinition="The person or organization that accepts overall responsibility for the contents of the message. The implication is that the message event happened under the policies of the responsible party." )
    protected Reference responsible;

    /**
     * Coded indication of the cause for the event - indicates  a reason for the occurrence of the event that is a focus of this message.
     */
    @Child(name = "reason", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Cause of event", formalDefinition="Coded indication of the cause for the event - indicates  a reason for the occurrence of the event that is a focus of this message." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/message-reason-encounter")
    protected CodeableConcept reason;

    /**
     * Information about the message that this message is a response to.  Only present if this message is a response.
     */
    @Child(name = "response", type = {}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If this is a reply to prior message", formalDefinition="Information about the message that this message is a response to.  Only present if this message is a response." )
    protected MessageHeaderResponseComponent response;

    /**
     * The actual data of the message - a reference to the root/focus class of the event.
     */
    @Child(name = "focus", type = {Reference.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The actual content of the message", formalDefinition="The actual data of the message - a reference to the root/focus class of the event." )
    protected List<Reference> focus;

    /**
     * Permanent link to the MessageDefinition for this message.
     */
    @Child(name = "definition", type = {CanonicalType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Link to the definition for this message", formalDefinition="Permanent link to the MessageDefinition for this message." )
    protected CanonicalType definition;

    private static final long serialVersionUID = -2012792051L;

  /**
   * Constructor
   */
    public MessageHeader() {
      super();
    }

  /**
   * Constructor
   */
    public MessageHeader(DataType event, MessageSourceComponent source) {
      super();
      this.setEvent(event);
      this.setSource(source);
    }

    /**
     * @return {@link #event} (Code that identifies the event this message represents and connects it with its definition. Events defined as part of the FHIR specification have the system value "http://terminology.hl7.org/CodeSystem/message-events".  Alternatively uri to the EventDefinition.)
     */
    public DataType getEvent() { 
      return this.event;
    }

    /**
     * @return {@link #event} (Code that identifies the event this message represents and connects it with its definition. Events defined as part of the FHIR specification have the system value "http://terminology.hl7.org/CodeSystem/message-events".  Alternatively uri to the EventDefinition.)
     */
    public Coding getEventCoding() throws FHIRException { 
      if (this.event == null)
        this.event = new Coding();
      if (!(this.event instanceof Coding))
        throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.event.getClass().getName()+" was encountered");
      return (Coding) this.event;
    }

    public boolean hasEventCoding() { 
      return this != null && this.event instanceof Coding;
    }

    /**
     * @return {@link #event} (Code that identifies the event this message represents and connects it with its definition. Events defined as part of the FHIR specification have the system value "http://terminology.hl7.org/CodeSystem/message-events".  Alternatively uri to the EventDefinition.)
     */
    public UriType getEventUriType() throws FHIRException { 
      if (this.event == null)
        this.event = new UriType();
      if (!(this.event instanceof UriType))
        throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.event.getClass().getName()+" was encountered");
      return (UriType) this.event;
    }

    public boolean hasEventUriType() { 
      return this != null && this.event instanceof UriType;
    }

    public boolean hasEvent() { 
      return this.event != null && !this.event.isEmpty();
    }

    /**
     * @param value {@link #event} (Code that identifies the event this message represents and connects it with its definition. Events defined as part of the FHIR specification have the system value "http://terminology.hl7.org/CodeSystem/message-events".  Alternatively uri to the EventDefinition.)
     */
    public MessageHeader setEvent(DataType value) { 
      if (value != null && !(value instanceof Coding || value instanceof UriType))
        throw new Error("Not the right type for MessageHeader.event[x]: "+value.fhirType());
      this.event = value;
      return this;
    }

    /**
     * @return {@link #destination} (The destination application which the message is intended for.)
     */
    public List<MessageDestinationComponent> getDestination() { 
      if (this.destination == null)
        this.destination = new ArrayList<MessageDestinationComponent>();
      return this.destination;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MessageHeader setDestination(List<MessageDestinationComponent> theDestination) { 
      this.destination = theDestination;
      return this;
    }

    public boolean hasDestination() { 
      if (this.destination == null)
        return false;
      for (MessageDestinationComponent item : this.destination)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MessageDestinationComponent addDestination() { //3
      MessageDestinationComponent t = new MessageDestinationComponent();
      if (this.destination == null)
        this.destination = new ArrayList<MessageDestinationComponent>();
      this.destination.add(t);
      return t;
    }

    public MessageHeader addDestination(MessageDestinationComponent t) { //3
      if (t == null)
        return this;
      if (this.destination == null)
        this.destination = new ArrayList<MessageDestinationComponent>();
      this.destination.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #destination}, creating it if it does not already exist {3}
     */
    public MessageDestinationComponent getDestinationFirstRep() { 
      if (getDestination().isEmpty()) {
        addDestination();
      }
      return getDestination().get(0);
    }

    /**
     * @return {@link #sender} (Identifies the sending system to allow the use of a trust relationship.)
     */
    public Reference getSender() { 
      if (this.sender == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MessageHeader.sender");
        else if (Configuration.doAutoCreate())
          this.sender = new Reference(); // cc
      return this.sender;
    }

    public boolean hasSender() { 
      return this.sender != null && !this.sender.isEmpty();
    }

    /**
     * @param value {@link #sender} (Identifies the sending system to allow the use of a trust relationship.)
     */
    public MessageHeader setSender(Reference value) { 
      this.sender = value;
      return this;
    }

    /**
     * @return {@link #enterer} (The person or device that performed the data entry leading to this message. When there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions.)
     */
    public Reference getEnterer() { 
      if (this.enterer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MessageHeader.enterer");
        else if (Configuration.doAutoCreate())
          this.enterer = new Reference(); // cc
      return this.enterer;
    }

    public boolean hasEnterer() { 
      return this.enterer != null && !this.enterer.isEmpty();
    }

    /**
     * @param value {@link #enterer} (The person or device that performed the data entry leading to this message. When there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions.)
     */
    public MessageHeader setEnterer(Reference value) { 
      this.enterer = value;
      return this;
    }

    /**
     * @return {@link #author} (The logical author of the message - the personor device that decided the described event should happen. When there is more than one candidate, pick the most proximal to the MessageHeader. Can provide other authors in extensions.)
     */
    public Reference getAuthor() { 
      if (this.author == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MessageHeader.author");
        else if (Configuration.doAutoCreate())
          this.author = new Reference(); // cc
      return this.author;
    }

    public boolean hasAuthor() { 
      return this.author != null && !this.author.isEmpty();
    }

    /**
     * @param value {@link #author} (The logical author of the message - the personor device that decided the described event should happen. When there is more than one candidate, pick the most proximal to the MessageHeader. Can provide other authors in extensions.)
     */
    public MessageHeader setAuthor(Reference value) { 
      this.author = value;
      return this;
    }

    /**
     * @return {@link #source} (The source application from which this message originated.)
     */
    public MessageSourceComponent getSource() { 
      if (this.source == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MessageHeader.source");
        else if (Configuration.doAutoCreate())
          this.source = new MessageSourceComponent(); // cc
      return this.source;
    }

    public boolean hasSource() { 
      return this.source != null && !this.source.isEmpty();
    }

    /**
     * @param value {@link #source} (The source application from which this message originated.)
     */
    public MessageHeader setSource(MessageSourceComponent value) { 
      this.source = value;
      return this;
    }

    /**
     * @return {@link #responsible} (The person or organization that accepts overall responsibility for the contents of the message. The implication is that the message event happened under the policies of the responsible party.)
     */
    public Reference getResponsible() { 
      if (this.responsible == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MessageHeader.responsible");
        else if (Configuration.doAutoCreate())
          this.responsible = new Reference(); // cc
      return this.responsible;
    }

    public boolean hasResponsible() { 
      return this.responsible != null && !this.responsible.isEmpty();
    }

    /**
     * @param value {@link #responsible} (The person or organization that accepts overall responsibility for the contents of the message. The implication is that the message event happened under the policies of the responsible party.)
     */
    public MessageHeader setResponsible(Reference value) { 
      this.responsible = value;
      return this;
    }

    /**
     * @return {@link #reason} (Coded indication of the cause for the event - indicates  a reason for the occurrence of the event that is a focus of this message.)
     */
    public CodeableConcept getReason() { 
      if (this.reason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MessageHeader.reason");
        else if (Configuration.doAutoCreate())
          this.reason = new CodeableConcept(); // cc
      return this.reason;
    }

    public boolean hasReason() { 
      return this.reason != null && !this.reason.isEmpty();
    }

    /**
     * @param value {@link #reason} (Coded indication of the cause for the event - indicates  a reason for the occurrence of the event that is a focus of this message.)
     */
    public MessageHeader setReason(CodeableConcept value) { 
      this.reason = value;
      return this;
    }

    /**
     * @return {@link #response} (Information about the message that this message is a response to.  Only present if this message is a response.)
     */
    public MessageHeaderResponseComponent getResponse() { 
      if (this.response == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MessageHeader.response");
        else if (Configuration.doAutoCreate())
          this.response = new MessageHeaderResponseComponent(); // cc
      return this.response;
    }

    public boolean hasResponse() { 
      return this.response != null && !this.response.isEmpty();
    }

    /**
     * @param value {@link #response} (Information about the message that this message is a response to.  Only present if this message is a response.)
     */
    public MessageHeader setResponse(MessageHeaderResponseComponent value) { 
      this.response = value;
      return this;
    }

    /**
     * @return {@link #focus} (The actual data of the message - a reference to the root/focus class of the event.)
     */
    public List<Reference> getFocus() { 
      if (this.focus == null)
        this.focus = new ArrayList<Reference>();
      return this.focus;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MessageHeader setFocus(List<Reference> theFocus) { 
      this.focus = theFocus;
      return this;
    }

    public boolean hasFocus() { 
      if (this.focus == null)
        return false;
      for (Reference item : this.focus)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addFocus() { //3
      Reference t = new Reference();
      if (this.focus == null)
        this.focus = new ArrayList<Reference>();
      this.focus.add(t);
      return t;
    }

    public MessageHeader addFocus(Reference t) { //3
      if (t == null)
        return this;
      if (this.focus == null)
        this.focus = new ArrayList<Reference>();
      this.focus.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #focus}, creating it if it does not already exist {3}
     */
    public Reference getFocusFirstRep() { 
      if (getFocus().isEmpty()) {
        addFocus();
      }
      return getFocus().get(0);
    }

    /**
     * @return {@link #definition} (Permanent link to the MessageDefinition for this message.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
     */
    public CanonicalType getDefinitionElement() { 
      if (this.definition == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MessageHeader.definition");
        else if (Configuration.doAutoCreate())
          this.definition = new CanonicalType(); // bb
      return this.definition;
    }

    public boolean hasDefinitionElement() { 
      return this.definition != null && !this.definition.isEmpty();
    }

    public boolean hasDefinition() { 
      return this.definition != null && !this.definition.isEmpty();
    }

    /**
     * @param value {@link #definition} (Permanent link to the MessageDefinition for this message.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
     */
    public MessageHeader setDefinitionElement(CanonicalType value) { 
      this.definition = value;
      return this;
    }

    /**
     * @return Permanent link to the MessageDefinition for this message.
     */
    public String getDefinition() { 
      return this.definition == null ? null : this.definition.getValue();
    }

    /**
     * @param value Permanent link to the MessageDefinition for this message.
     */
    public MessageHeader setDefinition(String value) { 
      if (Utilities.noString(value))
        this.definition = null;
      else {
        if (this.definition == null)
          this.definition = new CanonicalType();
        this.definition.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("event[x]", "Coding|uri", "Code that identifies the event this message represents and connects it with its definition. Events defined as part of the FHIR specification have the system value \"http://terminology.hl7.org/CodeSystem/message-events\".  Alternatively uri to the EventDefinition.", 0, 1, event));
        children.add(new Property("destination", "", "The destination application which the message is intended for.", 0, java.lang.Integer.MAX_VALUE, destination));
        children.add(new Property("sender", "Reference(Practitioner|PractitionerRole|Organization)", "Identifies the sending system to allow the use of a trust relationship.", 0, 1, sender));
        children.add(new Property("enterer", "Reference(Practitioner|PractitionerRole)", "The person or device that performed the data entry leading to this message. When there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions.", 0, 1, enterer));
        children.add(new Property("author", "Reference(Practitioner|PractitionerRole)", "The logical author of the message - the personor device that decided the described event should happen. When there is more than one candidate, pick the most proximal to the MessageHeader. Can provide other authors in extensions.", 0, 1, author));
        children.add(new Property("source", "", "The source application from which this message originated.", 0, 1, source));
        children.add(new Property("responsible", "Reference(Practitioner|PractitionerRole|Organization)", "The person or organization that accepts overall responsibility for the contents of the message. The implication is that the message event happened under the policies of the responsible party.", 0, 1, responsible));
        children.add(new Property("reason", "CodeableConcept", "Coded indication of the cause for the event - indicates  a reason for the occurrence of the event that is a focus of this message.", 0, 1, reason));
        children.add(new Property("response", "", "Information about the message that this message is a response to.  Only present if this message is a response.", 0, 1, response));
        children.add(new Property("focus", "Reference(Any)", "The actual data of the message - a reference to the root/focus class of the event.", 0, java.lang.Integer.MAX_VALUE, focus));
        children.add(new Property("definition", "canonical(MessageDefinition)", "Permanent link to the MessageDefinition for this message.", 0, 1, definition));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 278115238: /*event[x]*/  return new Property("event[x]", "Coding|uri", "Code that identifies the event this message represents and connects it with its definition. Events defined as part of the FHIR specification have the system value \"http://terminology.hl7.org/CodeSystem/message-events\".  Alternatively uri to the EventDefinition.", 0, 1, event);
        case 96891546: /*event*/  return new Property("event[x]", "Coding|uri", "Code that identifies the event this message represents and connects it with its definition. Events defined as part of the FHIR specification have the system value \"http://terminology.hl7.org/CodeSystem/message-events\".  Alternatively uri to the EventDefinition.", 0, 1, event);
        case -355957084: /*eventCoding*/  return new Property("event[x]", "Coding", "Code that identifies the event this message represents and connects it with its definition. Events defined as part of the FHIR specification have the system value \"http://terminology.hl7.org/CodeSystem/message-events\".  Alternatively uri to the EventDefinition.", 0, 1, event);
        case 278109298: /*eventUri*/  return new Property("event[x]", "uri", "Code that identifies the event this message represents and connects it with its definition. Events defined as part of the FHIR specification have the system value \"http://terminology.hl7.org/CodeSystem/message-events\".  Alternatively uri to the EventDefinition.", 0, 1, event);
        case -1429847026: /*destination*/  return new Property("destination", "", "The destination application which the message is intended for.", 0, java.lang.Integer.MAX_VALUE, destination);
        case -905962955: /*sender*/  return new Property("sender", "Reference(Practitioner|PractitionerRole|Organization)", "Identifies the sending system to allow the use of a trust relationship.", 0, 1, sender);
        case -1591951995: /*enterer*/  return new Property("enterer", "Reference(Practitioner|PractitionerRole)", "The person or device that performed the data entry leading to this message. When there is more than one candidate, pick the most proximal to the message. Can provide other enterers in extensions.", 0, 1, enterer);
        case -1406328437: /*author*/  return new Property("author", "Reference(Practitioner|PractitionerRole)", "The logical author of the message - the personor device that decided the described event should happen. When there is more than one candidate, pick the most proximal to the MessageHeader. Can provide other authors in extensions.", 0, 1, author);
        case -896505829: /*source*/  return new Property("source", "", "The source application from which this message originated.", 0, 1, source);
        case 1847674614: /*responsible*/  return new Property("responsible", "Reference(Practitioner|PractitionerRole|Organization)", "The person or organization that accepts overall responsibility for the contents of the message. The implication is that the message event happened under the policies of the responsible party.", 0, 1, responsible);
        case -934964668: /*reason*/  return new Property("reason", "CodeableConcept", "Coded indication of the cause for the event - indicates  a reason for the occurrence of the event that is a focus of this message.", 0, 1, reason);
        case -340323263: /*response*/  return new Property("response", "", "Information about the message that this message is a response to.  Only present if this message is a response.", 0, 1, response);
        case 97604824: /*focus*/  return new Property("focus", "Reference(Any)", "The actual data of the message - a reference to the root/focus class of the event.", 0, java.lang.Integer.MAX_VALUE, focus);
        case -1014418093: /*definition*/  return new Property("definition", "canonical(MessageDefinition)", "Permanent link to the MessageDefinition for this message.", 0, 1, definition);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 96891546: /*event*/ return this.event == null ? new Base[0] : new Base[] {this.event}; // DataType
        case -1429847026: /*destination*/ return this.destination == null ? new Base[0] : this.destination.toArray(new Base[this.destination.size()]); // MessageDestinationComponent
        case -905962955: /*sender*/ return this.sender == null ? new Base[0] : new Base[] {this.sender}; // Reference
        case -1591951995: /*enterer*/ return this.enterer == null ? new Base[0] : new Base[] {this.enterer}; // Reference
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : new Base[] {this.author}; // Reference
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // MessageSourceComponent
        case 1847674614: /*responsible*/ return this.responsible == null ? new Base[0] : new Base[] {this.responsible}; // Reference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : new Base[] {this.reason}; // CodeableConcept
        case -340323263: /*response*/ return this.response == null ? new Base[0] : new Base[] {this.response}; // MessageHeaderResponseComponent
        case 97604824: /*focus*/ return this.focus == null ? new Base[0] : this.focus.toArray(new Base[this.focus.size()]); // Reference
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : new Base[] {this.definition}; // CanonicalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 96891546: // event
          this.event = TypeConvertor.castToType(value); // DataType
          return value;
        case -1429847026: // destination
          this.getDestination().add((MessageDestinationComponent) value); // MessageDestinationComponent
          return value;
        case -905962955: // sender
          this.sender = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1591951995: // enterer
          this.enterer = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1406328437: // author
          this.author = TypeConvertor.castToReference(value); // Reference
          return value;
        case -896505829: // source
          this.source = (MessageSourceComponent) value; // MessageSourceComponent
          return value;
        case 1847674614: // responsible
          this.responsible = TypeConvertor.castToReference(value); // Reference
          return value;
        case -934964668: // reason
          this.reason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -340323263: // response
          this.response = (MessageHeaderResponseComponent) value; // MessageHeaderResponseComponent
          return value;
        case 97604824: // focus
          this.getFocus().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1014418093: // definition
          this.definition = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("event[x]")) {
          this.event = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("destination")) {
          this.getDestination().add((MessageDestinationComponent) value);
        } else if (name.equals("sender")) {
          this.sender = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("enterer")) {
          this.enterer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("author")) {
          this.author = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("source")) {
          this.source = (MessageSourceComponent) value; // MessageSourceComponent
        } else if (name.equals("responsible")) {
          this.responsible = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("reason")) {
          this.reason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("response")) {
          this.response = (MessageHeaderResponseComponent) value; // MessageHeaderResponseComponent
        } else if (name.equals("focus")) {
          this.getFocus().add(TypeConvertor.castToReference(value));
        } else if (name.equals("definition")) {
          this.definition = TypeConvertor.castToCanonical(value); // CanonicalType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 278115238:  return getEvent();
        case 96891546:  return getEvent();
        case -1429847026:  return addDestination(); 
        case -905962955:  return getSender();
        case -1591951995:  return getEnterer();
        case -1406328437:  return getAuthor();
        case -896505829:  return getSource();
        case 1847674614:  return getResponsible();
        case -934964668:  return getReason();
        case -340323263:  return getResponse();
        case 97604824:  return addFocus(); 
        case -1014418093:  return getDefinitionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 96891546: /*event*/ return new String[] {"Coding", "uri"};
        case -1429847026: /*destination*/ return new String[] {};
        case -905962955: /*sender*/ return new String[] {"Reference"};
        case -1591951995: /*enterer*/ return new String[] {"Reference"};
        case -1406328437: /*author*/ return new String[] {"Reference"};
        case -896505829: /*source*/ return new String[] {};
        case 1847674614: /*responsible*/ return new String[] {"Reference"};
        case -934964668: /*reason*/ return new String[] {"CodeableConcept"};
        case -340323263: /*response*/ return new String[] {};
        case 97604824: /*focus*/ return new String[] {"Reference"};
        case -1014418093: /*definition*/ return new String[] {"canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("eventCoding")) {
          this.event = new Coding();
          return this.event;
        }
        else if (name.equals("eventUri")) {
          this.event = new UriType();
          return this.event;
        }
        else if (name.equals("destination")) {
          return addDestination();
        }
        else if (name.equals("sender")) {
          this.sender = new Reference();
          return this.sender;
        }
        else if (name.equals("enterer")) {
          this.enterer = new Reference();
          return this.enterer;
        }
        else if (name.equals("author")) {
          this.author = new Reference();
          return this.author;
        }
        else if (name.equals("source")) {
          this.source = new MessageSourceComponent();
          return this.source;
        }
        else if (name.equals("responsible")) {
          this.responsible = new Reference();
          return this.responsible;
        }
        else if (name.equals("reason")) {
          this.reason = new CodeableConcept();
          return this.reason;
        }
        else if (name.equals("response")) {
          this.response = new MessageHeaderResponseComponent();
          return this.response;
        }
        else if (name.equals("focus")) {
          return addFocus();
        }
        else if (name.equals("definition")) {
          throw new FHIRException("Cannot call addChild on a primitive type MessageHeader.definition");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "MessageHeader";

  }

      public MessageHeader copy() {
        MessageHeader dst = new MessageHeader();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MessageHeader dst) {
        super.copyValues(dst);
        dst.event = event == null ? null : event.copy();
        if (destination != null) {
          dst.destination = new ArrayList<MessageDestinationComponent>();
          for (MessageDestinationComponent i : destination)
            dst.destination.add(i.copy());
        };
        dst.sender = sender == null ? null : sender.copy();
        dst.enterer = enterer == null ? null : enterer.copy();
        dst.author = author == null ? null : author.copy();
        dst.source = source == null ? null : source.copy();
        dst.responsible = responsible == null ? null : responsible.copy();
        dst.reason = reason == null ? null : reason.copy();
        dst.response = response == null ? null : response.copy();
        if (focus != null) {
          dst.focus = new ArrayList<Reference>();
          for (Reference i : focus)
            dst.focus.add(i.copy());
        };
        dst.definition = definition == null ? null : definition.copy();
      }

      protected MessageHeader typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MessageHeader))
          return false;
        MessageHeader o = (MessageHeader) other_;
        return compareDeep(event, o.event, true) && compareDeep(destination, o.destination, true) && compareDeep(sender, o.sender, true)
           && compareDeep(enterer, o.enterer, true) && compareDeep(author, o.author, true) && compareDeep(source, o.source, true)
           && compareDeep(responsible, o.responsible, true) && compareDeep(reason, o.reason, true) && compareDeep(response, o.response, true)
           && compareDeep(focus, o.focus, true) && compareDeep(definition, o.definition, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MessageHeader))
          return false;
        MessageHeader o = (MessageHeader) other_;
        return compareValues(definition, o.definition, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(event, destination, sender
          , enterer, author, source, responsible, reason, response, focus, definition
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.MessageHeader;
   }


}

