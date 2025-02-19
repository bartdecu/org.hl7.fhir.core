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
 * An action that is or was performed on or for a patient, practitioner, device, organization, or location. For example, this can be a physical intervention on a patient like an operation, or less invasive like long term services, counseling, or hypnotherapy.  This can be a quality or safety inspection for a location, organization, or device.  This can be an accreditation procedure on a practitioner for licensing.
 */
@ResourceDef(name="Procedure", profile="http://hl7.org/fhir/StructureDefinition/Procedure")
public class Procedure extends DomainResource {

    @Block()
    public static class ProcedurePerformerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Distinguishes the type of involvement of the performer in the procedure. For example, surgeon, anaesthetist, endoscopist.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Type of performance", formalDefinition="Distinguishes the type of involvement of the performer in the procedure. For example, surgeon, anaesthetist, endoscopist." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/performer-role")
        protected CodeableConcept function;

        /**
         * Indicates who or what performed the procedure.
         */
        @Child(name = "actor", type = {Practitioner.class, PractitionerRole.class, Organization.class, Patient.class, RelatedPerson.class, Device.class, CareTeam.class, HealthcareService.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Who performed the procedure", formalDefinition="Indicates who or what performed the procedure." )
        protected Reference actor;

        /**
         * The organization the device or practitioner was acting on behalf of.
         */
        @Child(name = "onBehalfOf", type = {Organization.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Organization the device or practitioner was acting for", formalDefinition="The organization the device or practitioner was acting on behalf of." )
        protected Reference onBehalfOf;

        private static final long serialVersionUID = -1804820116L;

    /**
     * Constructor
     */
      public ProcedurePerformerComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ProcedurePerformerComponent(Reference actor) {
        super();
        this.setActor(actor);
      }

        /**
         * @return {@link #function} (Distinguishes the type of involvement of the performer in the procedure. For example, surgeon, anaesthetist, endoscopist.)
         */
        public CodeableConcept getFunction() { 
          if (this.function == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProcedurePerformerComponent.function");
            else if (Configuration.doAutoCreate())
              this.function = new CodeableConcept(); // cc
          return this.function;
        }

        public boolean hasFunction() { 
          return this.function != null && !this.function.isEmpty();
        }

        /**
         * @param value {@link #function} (Distinguishes the type of involvement of the performer in the procedure. For example, surgeon, anaesthetist, endoscopist.)
         */
        public ProcedurePerformerComponent setFunction(CodeableConcept value) { 
          this.function = value;
          return this;
        }

        /**
         * @return {@link #actor} (Indicates who or what performed the procedure.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProcedurePerformerComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (Indicates who or what performed the procedure.)
         */
        public ProcedurePerformerComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        /**
         * @return {@link #onBehalfOf} (The organization the device or practitioner was acting on behalf of.)
         */
        public Reference getOnBehalfOf() { 
          if (this.onBehalfOf == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProcedurePerformerComponent.onBehalfOf");
            else if (Configuration.doAutoCreate())
              this.onBehalfOf = new Reference(); // cc
          return this.onBehalfOf;
        }

        public boolean hasOnBehalfOf() { 
          return this.onBehalfOf != null && !this.onBehalfOf.isEmpty();
        }

        /**
         * @param value {@link #onBehalfOf} (The organization the device or practitioner was acting on behalf of.)
         */
        public ProcedurePerformerComponent setOnBehalfOf(Reference value) { 
          this.onBehalfOf = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("function", "CodeableConcept", "Distinguishes the type of involvement of the performer in the procedure. For example, surgeon, anaesthetist, endoscopist.", 0, 1, function));
          children.add(new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|Patient|RelatedPerson|Device|CareTeam|HealthcareService)", "Indicates who or what performed the procedure.", 0, 1, actor));
          children.add(new Property("onBehalfOf", "Reference(Organization)", "The organization the device or practitioner was acting on behalf of.", 0, 1, onBehalfOf));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Distinguishes the type of involvement of the performer in the procedure. For example, surgeon, anaesthetist, endoscopist.", 0, 1, function);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|Patient|RelatedPerson|Device|CareTeam|HealthcareService)", "Indicates who or what performed the procedure.", 0, 1, actor);
          case -14402964: /*onBehalfOf*/  return new Property("onBehalfOf", "Reference(Organization)", "The organization the device or practitioner was acting on behalf of.", 0, 1, onBehalfOf);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1380938712: /*function*/ return this.function == null ? new Base[0] : new Base[] {this.function}; // CodeableConcept
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : new Base[] {this.actor}; // Reference
        case -14402964: /*onBehalfOf*/ return this.onBehalfOf == null ? new Base[0] : new Base[] {this.onBehalfOf}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1380938712: // function
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 92645877: // actor
          this.actor = TypeConvertor.castToReference(value); // Reference
          return value;
        case -14402964: // onBehalfOf
          this.onBehalfOf = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("function")) {
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("actor")) {
          this.actor = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("onBehalfOf")) {
          this.onBehalfOf = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1380938712:  return getFunction();
        case 92645877:  return getActor();
        case -14402964:  return getOnBehalfOf();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1380938712: /*function*/ return new String[] {"CodeableConcept"};
        case 92645877: /*actor*/ return new String[] {"Reference"};
        case -14402964: /*onBehalfOf*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("function")) {
          this.function = new CodeableConcept();
          return this.function;
        }
        else if (name.equals("actor")) {
          this.actor = new Reference();
          return this.actor;
        }
        else if (name.equals("onBehalfOf")) {
          this.onBehalfOf = new Reference();
          return this.onBehalfOf;
        }
        else
          return super.addChild(name);
      }

      public ProcedurePerformerComponent copy() {
        ProcedurePerformerComponent dst = new ProcedurePerformerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ProcedurePerformerComponent dst) {
        super.copyValues(dst);
        dst.function = function == null ? null : function.copy();
        dst.actor = actor == null ? null : actor.copy();
        dst.onBehalfOf = onBehalfOf == null ? null : onBehalfOf.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ProcedurePerformerComponent))
          return false;
        ProcedurePerformerComponent o = (ProcedurePerformerComponent) other_;
        return compareDeep(function, o.function, true) && compareDeep(actor, o.actor, true) && compareDeep(onBehalfOf, o.onBehalfOf, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ProcedurePerformerComponent))
          return false;
        ProcedurePerformerComponent o = (ProcedurePerformerComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(function, actor, onBehalfOf
          );
      }

  public String fhirType() {
    return "Procedure.performer";

  }

  }

    @Block()
    public static class ProcedureFocalDeviceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The kind of change that happened to the device during the procedure.
         */
        @Child(name = "action", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Kind of change to device", formalDefinition="The kind of change that happened to the device during the procedure." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-action")
        protected CodeableConcept action;

        /**
         * The device that was manipulated (changed) during the procedure.
         */
        @Child(name = "manipulated", type = {Device.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Device that was changed", formalDefinition="The device that was manipulated (changed) during the procedure." )
        protected Reference manipulated;

        private static final long serialVersionUID = -217582010L;

    /**
     * Constructor
     */
      public ProcedureFocalDeviceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ProcedureFocalDeviceComponent(Reference manipulated) {
        super();
        this.setManipulated(manipulated);
      }

        /**
         * @return {@link #action} (The kind of change that happened to the device during the procedure.)
         */
        public CodeableConcept getAction() { 
          if (this.action == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProcedureFocalDeviceComponent.action");
            else if (Configuration.doAutoCreate())
              this.action = new CodeableConcept(); // cc
          return this.action;
        }

        public boolean hasAction() { 
          return this.action != null && !this.action.isEmpty();
        }

        /**
         * @param value {@link #action} (The kind of change that happened to the device during the procedure.)
         */
        public ProcedureFocalDeviceComponent setAction(CodeableConcept value) { 
          this.action = value;
          return this;
        }

        /**
         * @return {@link #manipulated} (The device that was manipulated (changed) during the procedure.)
         */
        public Reference getManipulated() { 
          if (this.manipulated == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ProcedureFocalDeviceComponent.manipulated");
            else if (Configuration.doAutoCreate())
              this.manipulated = new Reference(); // cc
          return this.manipulated;
        }

        public boolean hasManipulated() { 
          return this.manipulated != null && !this.manipulated.isEmpty();
        }

        /**
         * @param value {@link #manipulated} (The device that was manipulated (changed) during the procedure.)
         */
        public ProcedureFocalDeviceComponent setManipulated(Reference value) { 
          this.manipulated = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("action", "CodeableConcept", "The kind of change that happened to the device during the procedure.", 0, 1, action));
          children.add(new Property("manipulated", "Reference(Device)", "The device that was manipulated (changed) during the procedure.", 0, 1, manipulated));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1422950858: /*action*/  return new Property("action", "CodeableConcept", "The kind of change that happened to the device during the procedure.", 0, 1, action);
          case 947372650: /*manipulated*/  return new Property("manipulated", "Reference(Device)", "The device that was manipulated (changed) during the procedure.", 0, 1, manipulated);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1422950858: /*action*/ return this.action == null ? new Base[0] : new Base[] {this.action}; // CodeableConcept
        case 947372650: /*manipulated*/ return this.manipulated == null ? new Base[0] : new Base[] {this.manipulated}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1422950858: // action
          this.action = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 947372650: // manipulated
          this.manipulated = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("action")) {
          this.action = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("manipulated")) {
          this.manipulated = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1422950858:  return getAction();
        case 947372650:  return getManipulated();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1422950858: /*action*/ return new String[] {"CodeableConcept"};
        case 947372650: /*manipulated*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("action")) {
          this.action = new CodeableConcept();
          return this.action;
        }
        else if (name.equals("manipulated")) {
          this.manipulated = new Reference();
          return this.manipulated;
        }
        else
          return super.addChild(name);
      }

      public ProcedureFocalDeviceComponent copy() {
        ProcedureFocalDeviceComponent dst = new ProcedureFocalDeviceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ProcedureFocalDeviceComponent dst) {
        super.copyValues(dst);
        dst.action = action == null ? null : action.copy();
        dst.manipulated = manipulated == null ? null : manipulated.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ProcedureFocalDeviceComponent))
          return false;
        ProcedureFocalDeviceComponent o = (ProcedureFocalDeviceComponent) other_;
        return compareDeep(action, o.action, true) && compareDeep(manipulated, o.manipulated, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ProcedureFocalDeviceComponent))
          return false;
        ProcedureFocalDeviceComponent o = (ProcedureFocalDeviceComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(action, manipulated);
      }

  public String fhirType() {
    return "Procedure.focalDevice";

  }

  }

    /**
     * Business identifiers assigned to this procedure by the performer or other systems which remain constant as the resource is updated and is propagated from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External Identifiers for this procedure", formalDefinition="Business identifiers assigned to this procedure by the performer or other systems which remain constant as the resource is updated and is propagated from server to server." )
    protected List<Identifier> identifier;

    /**
     * The URL pointing to a FHIR-defined protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure.
     */
    @Child(name = "instantiatesCanonical", type = {CanonicalType.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Instantiates FHIR protocol or definition", formalDefinition="The URL pointing to a FHIR-defined protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure." )
    protected List<CanonicalType> instantiatesCanonical;

    /**
     * The URL pointing to an externally maintained protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure.
     */
    @Child(name = "instantiatesUri", type = {UriType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Instantiates external protocol or definition", formalDefinition="The URL pointing to an externally maintained protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure." )
    protected List<UriType> instantiatesUri;

    /**
     * A reference to a resource that contains details of the request for this procedure.
     */
    @Child(name = "basedOn", type = {CarePlan.class, ServiceRequest.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A request for this procedure", formalDefinition="A reference to a resource that contains details of the request for this procedure." )
    protected List<Reference> basedOn;

    /**
     * A larger event of which this particular procedure is a component or step.
     */
    @Child(name = "partOf", type = {Procedure.class, Observation.class, MedicationAdministration.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Part of referenced event", formalDefinition="A larger event of which this particular procedure is a component or step." )
    protected List<Reference> partOf;

    /**
     * A code specifying the state of the procedure. Generally, this will be the in-progress or completed state.
     */
    @Child(name = "status", type = {CodeType.class}, order=5, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="preparation | in-progress | not-done | on-hold | stopped | completed | entered-in-error | unknown", formalDefinition="A code specifying the state of the procedure. Generally, this will be the in-progress or completed state." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/event-status")
    protected Enumeration<EventStatus> status;

    /**
     * Captures the reason for the current state of the procedure.
     */
    @Child(name = "statusReason", type = {CodeableConcept.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reason for current status", formalDefinition="Captures the reason for the current state of the procedure." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/procedure-not-performed-reason")
    protected CodeableConcept statusReason;

    /**
     * A code that classifies the procedure for searching, sorting and display purposes (e.g. "Surgical Procedure").
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Classification of the procedure", formalDefinition="A code that classifies the procedure for searching, sorting and display purposes (e.g. \"Surgical Procedure\")." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/procedure-category")
    protected List<CodeableConcept> category;

    /**
     * The specific procedure that is performed. Use text if the exact nature of the procedure cannot be coded (e.g. "Laparoscopic Appendectomy").
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Identification of the procedure", formalDefinition="The specific procedure that is performed. Use text if the exact nature of the procedure cannot be coded (e.g. \"Laparoscopic Appendectomy\")." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/procedure-code")
    protected CodeableConcept code;

    /**
     * On whom or what the procedure was performed. This is usually an individual human, but can also be performed on animals, groups of humans or animals, organizations or practitioners (for licensing), locations or devices (for safety inspections or regulatory authorizations).
     */
    @Child(name = "subject", type = {Patient.class, Group.class, Device.class, Practitioner.class, Organization.class, Location.class}, order=9, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Individual or entity the procedure was performed on", formalDefinition="On whom or what the procedure was performed. This is usually an individual human, but can also be performed on animals, groups of humans or animals, organizations or practitioners (for licensing), locations or devices (for safety inspections or regulatory authorizations)." )
    protected Reference subject;

    /**
     * The Encounter during which this Procedure was created or performed or to which the creation of this record is tightly associated.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The Encounter during which this Procedure was created", formalDefinition="The Encounter during which this Procedure was created or performed or to which the creation of this record is tightly associated." )
    protected Reference encounter;

    /**
     * Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.
     */
    @Child(name = "occurrence", type = {DateTimeType.class, Period.class, StringType.class, Age.class, Range.class, Timing.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the procedure occurred or is occurring", formalDefinition="Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured." )
    protected DataType occurrence;

    /**
     * The date the occurrence of the procedure was first captured in the record regardless of Procedure.status (potentially after the occurrence of the event).
     */
    @Child(name = "recorded", type = {DateTimeType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the procedure was first captured in the subject's record", formalDefinition="The date the occurrence of the procedure was first captured in the record regardless of Procedure.status (potentially after the occurrence of the event)." )
    protected DateTimeType recorded;

    /**
     * Individual who recorded the record and takes responsibility for its content.
     */
    @Child(name = "recorder", type = {Patient.class, RelatedPerson.class, Practitioner.class, PractitionerRole.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who recorded the procedure", formalDefinition="Individual who recorded the record and takes responsibility for its content." )
    protected Reference recorder;

    /**
     * Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.
     */
    @Child(name = "reported", type = {BooleanType.class, Patient.class, RelatedPerson.class, Practitioner.class, PractitionerRole.class, Organization.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reported rather than primary record", formalDefinition="Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report." )
    protected DataType reported;

    /**
     * Limited to "real" people rather than equipment.
     */
    @Child(name = "performer", type = {}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The people who performed the procedure", formalDefinition="Limited to \"real\" people rather than equipment." )
    protected List<ProcedurePerformerComponent> performer;

    /**
     * The location where the procedure actually happened.  E.g. a newborn at home, a tracheostomy at a restaurant.
     */
    @Child(name = "location", type = {Location.class}, order=16, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Where the procedure happened", formalDefinition="The location where the procedure actually happened.  E.g. a newborn at home, a tracheostomy at a restaurant." )
    protected Reference location;

    /**
     * The coded reason or reference why the procedure was performed. This may be a coded entity of some type, or may simply be present as text, or may be a reference to one of several resources that justify the procedure.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The justification that the procedure was performed", formalDefinition="The coded reason or reference why the procedure was performed. This may be a coded entity of some type, or may simply be present as text, or may be a reference to one of several resources that justify the procedure." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/procedure-reason")
    protected List<CodeableReference> reason;

    /**
     * Detailed and structured anatomical location information. Multiple locations are allowed - e.g. multiple punch biopsies of a lesion.
     */
    @Child(name = "bodySite", type = {CodeableConcept.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Target body sites", formalDefinition="Detailed and structured anatomical location information. Multiple locations are allowed - e.g. multiple punch biopsies of a lesion." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
    protected List<CodeableConcept> bodySite;

    /**
     * The outcome of the procedure - did it resolve the reasons for the procedure being performed?
     */
    @Child(name = "outcome", type = {CodeableConcept.class}, order=19, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The result of procedure", formalDefinition="The outcome of the procedure - did it resolve the reasons for the procedure being performed?" )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/procedure-outcome")
    protected CodeableConcept outcome;

    /**
     * This could be a histology result, pathology report, surgical report, etc.
     */
    @Child(name = "report", type = {DiagnosticReport.class, DocumentReference.class, Composition.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Any report resulting from the procedure", formalDefinition="This could be a histology result, pathology report, surgical report, etc." )
    protected List<Reference> report;

    /**
     * Any complications that occurred during the procedure, or in the immediate post-performance period. These are generally tracked separately from the notes, which will typically describe the procedure itself rather than any 'post procedure' issues.
     */
    @Child(name = "complication", type = {CodeableConcept.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Complication following the procedure", formalDefinition="Any complications that occurred during the procedure, or in the immediate post-performance period. These are generally tracked separately from the notes, which will typically describe the procedure itself rather than any 'post procedure' issues." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-code")
    protected List<CodeableConcept> complication;

    /**
     * Any complications that occurred during the procedure, or in the immediate post-performance period.
     */
    @Child(name = "complicationDetail", type = {Condition.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A condition that is a result of the procedure", formalDefinition="Any complications that occurred during the procedure, or in the immediate post-performance period." )
    protected List<Reference> complicationDetail;

    /**
     * If the procedure required specific follow up - e.g. removal of sutures. The follow up may be represented as a simple note or could potentially be more complex, in which case the CarePlan resource can be used.
     */
    @Child(name = "followUp", type = {CodeableConcept.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Instructions for follow up", formalDefinition="If the procedure required specific follow up - e.g. removal of sutures. The follow up may be represented as a simple note or could potentially be more complex, in which case the CarePlan resource can be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/procedure-followup")
    protected List<CodeableConcept> followUp;

    /**
     * Any other notes and comments about the procedure.
     */
    @Child(name = "note", type = {Annotation.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional information about the procedure", formalDefinition="Any other notes and comments about the procedure." )
    protected List<Annotation> note;

    /**
     * A device that is implanted, removed or otherwise manipulated (calibration, battery replacement, fitting a prosthesis, attaching a wound-vac, etc.) as a focal portion of the Procedure.
     */
    @Child(name = "focalDevice", type = {}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Manipulated, implanted, or removed device", formalDefinition="A device that is implanted, removed or otherwise manipulated (calibration, battery replacement, fitting a prosthesis, attaching a wound-vac, etc.) as a focal portion of the Procedure." )
    protected List<ProcedureFocalDeviceComponent> focalDevice;

    /**
     * Identifies medications, devices and any other substance used as part of the procedure.
     */
    @Child(name = "used", type = {CodeableReference.class}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Items used during procedure", formalDefinition="Identifies medications, devices and any other substance used as part of the procedure." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-type")
    protected List<CodeableReference> used;

    /**
     * Other resources from the patient record that may be relevant to the procedure.  The information from these resources was either used to create the instance or is provided to help with its interpretation. This extension should not be used if more specific inline elements or extensions are available.
     */
    @Child(name = "supportingInfo", type = {Reference.class}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Extra information relevant to the procedure", formalDefinition="Other resources from the patient record that may be relevant to the procedure.  The information from these resources was either used to create the instance or is provided to help with its interpretation. This extension should not be used if more specific inline elements or extensions are available." )
    protected List<Reference> supportingInfo;

    private static final long serialVersionUID = -1752782660L;

  /**
   * Constructor
   */
    public Procedure() {
      super();
    }

  /**
   * Constructor
   */
    public Procedure(EventStatus status, Reference subject) {
      super();
      this.setStatus(status);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Business identifiers assigned to this procedure by the performer or other systems which remain constant as the resource is updated and is propagated from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setIdentifier(List<Identifier> theIdentifier) { 
      this.identifier = theIdentifier;
      return this;
    }

    public boolean hasIdentifier() { 
      if (this.identifier == null)
        return false;
      for (Identifier item : this.identifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Identifier addIdentifier() { //3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public Procedure addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure.)
     */
    public List<CanonicalType> getInstantiatesCanonical() { 
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      return this.instantiatesCanonical;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setInstantiatesCanonical(List<CanonicalType> theInstantiatesCanonical) { 
      this.instantiatesCanonical = theInstantiatesCanonical;
      return this;
    }

    public boolean hasInstantiatesCanonical() { 
      if (this.instantiatesCanonical == null)
        return false;
      for (CanonicalType item : this.instantiatesCanonical)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure.)
     */
    public CanonicalType addInstantiatesCanonicalElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      this.instantiatesCanonical.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure.)
     */
    public Procedure addInstantiatesCanonical(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      this.instantiatesCanonical.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure.)
     */
    public boolean hasInstantiatesCanonical(String value) { 
      if (this.instantiatesCanonical == null)
        return false;
      for (CanonicalType v : this.instantiatesCanonical)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure.)
     */
    public List<UriType> getInstantiatesUri() { 
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      return this.instantiatesUri;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setInstantiatesUri(List<UriType> theInstantiatesUri) { 
      this.instantiatesUri = theInstantiatesUri;
      return this;
    }

    public boolean hasInstantiatesUri() { 
      if (this.instantiatesUri == null)
        return false;
      for (UriType item : this.instantiatesUri)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure.)
     */
    public UriType addInstantiatesUriElement() {//2 
      UriType t = new UriType();
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      this.instantiatesUri.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure.)
     */
    public Procedure addInstantiatesUri(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      this.instantiatesUri.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure.)
     */
    public boolean hasInstantiatesUri(String value) { 
      if (this.instantiatesUri == null)
        return false;
      for (UriType v : this.instantiatesUri)
        if (v.getValue().equals(value)) // uri
          return true;
      return false;
    }

    /**
     * @return {@link #basedOn} (A reference to a resource that contains details of the request for this procedure.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setBasedOn(List<Reference> theBasedOn) { 
      this.basedOn = theBasedOn;
      return this;
    }

    public boolean hasBasedOn() { 
      if (this.basedOn == null)
        return false;
      for (Reference item : this.basedOn)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addBasedOn() { //3
      Reference t = new Reference();
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return t;
    }

    public Procedure addBasedOn(Reference t) { //3
      if (t == null)
        return this;
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist {3}
     */
    public Reference getBasedOnFirstRep() { 
      if (getBasedOn().isEmpty()) {
        addBasedOn();
      }
      return getBasedOn().get(0);
    }

    /**
     * @return {@link #partOf} (A larger event of which this particular procedure is a component or step.)
     */
    public List<Reference> getPartOf() { 
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      return this.partOf;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setPartOf(List<Reference> thePartOf) { 
      this.partOf = thePartOf;
      return this;
    }

    public boolean hasPartOf() { 
      if (this.partOf == null)
        return false;
      for (Reference item : this.partOf)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPartOf() { //3
      Reference t = new Reference();
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      this.partOf.add(t);
      return t;
    }

    public Procedure addPartOf(Reference t) { //3
      if (t == null)
        return this;
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      this.partOf.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #partOf}, creating it if it does not already exist {3}
     */
    public Reference getPartOfFirstRep() { 
      if (getPartOf().isEmpty()) {
        addPartOf();
      }
      return getPartOf().get(0);
    }

    /**
     * @return {@link #status} (A code specifying the state of the procedure. Generally, this will be the in-progress or completed state.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<EventStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Procedure.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<EventStatus>(new EventStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (A code specifying the state of the procedure. Generally, this will be the in-progress or completed state.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Procedure setStatusElement(Enumeration<EventStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code specifying the state of the procedure. Generally, this will be the in-progress or completed state.
     */
    public EventStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code specifying the state of the procedure. Generally, this will be the in-progress or completed state.
     */
    public Procedure setStatus(EventStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<EventStatus>(new EventStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #statusReason} (Captures the reason for the current state of the procedure.)
     */
    public CodeableConcept getStatusReason() { 
      if (this.statusReason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Procedure.statusReason");
        else if (Configuration.doAutoCreate())
          this.statusReason = new CodeableConcept(); // cc
      return this.statusReason;
    }

    public boolean hasStatusReason() { 
      return this.statusReason != null && !this.statusReason.isEmpty();
    }

    /**
     * @param value {@link #statusReason} (Captures the reason for the current state of the procedure.)
     */
    public Procedure setStatusReason(CodeableConcept value) { 
      this.statusReason = value;
      return this;
    }

    /**
     * @return {@link #category} (A code that classifies the procedure for searching, sorting and display purposes (e.g. "Surgical Procedure").)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setCategory(List<CodeableConcept> theCategory) { 
      this.category = theCategory;
      return this;
    }

    public boolean hasCategory() { 
      if (this.category == null)
        return false;
      for (CodeableConcept item : this.category)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCategory() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return t;
    }

    public Procedure addCategory(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #category}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCategoryFirstRep() { 
      if (getCategory().isEmpty()) {
        addCategory();
      }
      return getCategory().get(0);
    }

    /**
     * @return {@link #code} (The specific procedure that is performed. Use text if the exact nature of the procedure cannot be coded (e.g. "Laparoscopic Appendectomy").)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Procedure.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (The specific procedure that is performed. Use text if the exact nature of the procedure cannot be coded (e.g. "Laparoscopic Appendectomy").)
     */
    public Procedure setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #subject} (On whom or what the procedure was performed. This is usually an individual human, but can also be performed on animals, groups of humans or animals, organizations or practitioners (for licensing), locations or devices (for safety inspections or regulatory authorizations).)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Procedure.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (On whom or what the procedure was performed. This is usually an individual human, but can also be performed on animals, groups of humans or animals, organizations or practitioners (for licensing), locations or devices (for safety inspections or regulatory authorizations).)
     */
    public Procedure setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The Encounter during which this Procedure was created or performed or to which the creation of this record is tightly associated.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Procedure.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The Encounter during which this Procedure was created or performed or to which the creation of this record is tightly associated.)
     */
    public Procedure setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #occurrence} (Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
     */
    public DataType getOccurrence() { 
      return this.occurrence;
    }

    /**
     * @return {@link #occurrence} (Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
     */
    public DateTimeType getOccurrenceDateTimeType() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new DateTimeType();
      if (!(this.occurrence instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (DateTimeType) this.occurrence;
    }

    public boolean hasOccurrenceDateTimeType() { 
      return this != null && this.occurrence instanceof DateTimeType;
    }

    /**
     * @return {@link #occurrence} (Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
     */
    public Period getOccurrencePeriod() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new Period();
      if (!(this.occurrence instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (Period) this.occurrence;
    }

    public boolean hasOccurrencePeriod() { 
      return this != null && this.occurrence instanceof Period;
    }

    /**
     * @return {@link #occurrence} (Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
     */
    public StringType getOccurrenceStringType() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new StringType();
      if (!(this.occurrence instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (StringType) this.occurrence;
    }

    public boolean hasOccurrenceStringType() { 
      return this != null && this.occurrence instanceof StringType;
    }

    /**
     * @return {@link #occurrence} (Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
     */
    public Age getOccurrenceAge() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new Age();
      if (!(this.occurrence instanceof Age))
        throw new FHIRException("Type mismatch: the type Age was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (Age) this.occurrence;
    }

    public boolean hasOccurrenceAge() { 
      return this != null && this.occurrence instanceof Age;
    }

    /**
     * @return {@link #occurrence} (Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
     */
    public Range getOccurrenceRange() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new Range();
      if (!(this.occurrence instanceof Range))
        throw new FHIRException("Type mismatch: the type Range was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (Range) this.occurrence;
    }

    public boolean hasOccurrenceRange() { 
      return this != null && this.occurrence instanceof Range;
    }

    /**
     * @return {@link #occurrence} (Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
     */
    public Timing getOccurrenceTiming() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new Timing();
      if (!(this.occurrence instanceof Timing))
        throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (Timing) this.occurrence;
    }

    public boolean hasOccurrenceTiming() { 
      return this != null && this.occurrence instanceof Timing;
    }

    public boolean hasOccurrence() { 
      return this.occurrence != null && !this.occurrence.isEmpty();
    }

    /**
     * @param value {@link #occurrence} (Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.)
     */
    public Procedure setOccurrence(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period || value instanceof StringType || value instanceof Age || value instanceof Range || value instanceof Timing))
        throw new Error("Not the right type for Procedure.occurrence[x]: "+value.fhirType());
      this.occurrence = value;
      return this;
    }

    /**
     * @return {@link #recorded} (The date the occurrence of the procedure was first captured in the record regardless of Procedure.status (potentially after the occurrence of the event).). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public DateTimeType getRecordedElement() { 
      if (this.recorded == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Procedure.recorded");
        else if (Configuration.doAutoCreate())
          this.recorded = new DateTimeType(); // bb
      return this.recorded;
    }

    public boolean hasRecordedElement() { 
      return this.recorded != null && !this.recorded.isEmpty();
    }

    public boolean hasRecorded() { 
      return this.recorded != null && !this.recorded.isEmpty();
    }

    /**
     * @param value {@link #recorded} (The date the occurrence of the procedure was first captured in the record regardless of Procedure.status (potentially after the occurrence of the event).). This is the underlying object with id, value and extensions. The accessor "getRecorded" gives direct access to the value
     */
    public Procedure setRecordedElement(DateTimeType value) { 
      this.recorded = value;
      return this;
    }

    /**
     * @return The date the occurrence of the procedure was first captured in the record regardless of Procedure.status (potentially after the occurrence of the event).
     */
    public Date getRecorded() { 
      return this.recorded == null ? null : this.recorded.getValue();
    }

    /**
     * @param value The date the occurrence of the procedure was first captured in the record regardless of Procedure.status (potentially after the occurrence of the event).
     */
    public Procedure setRecorded(Date value) { 
      if (value == null)
        this.recorded = null;
      else {
        if (this.recorded == null)
          this.recorded = new DateTimeType();
        this.recorded.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #recorder} (Individual who recorded the record and takes responsibility for its content.)
     */
    public Reference getRecorder() { 
      if (this.recorder == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Procedure.recorder");
        else if (Configuration.doAutoCreate())
          this.recorder = new Reference(); // cc
      return this.recorder;
    }

    public boolean hasRecorder() { 
      return this.recorder != null && !this.recorder.isEmpty();
    }

    /**
     * @param value {@link #recorder} (Individual who recorded the record and takes responsibility for its content.)
     */
    public Procedure setRecorder(Reference value) { 
      this.recorder = value;
      return this;
    }

    /**
     * @return {@link #reported} (Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.)
     */
    public DataType getReported() { 
      return this.reported;
    }

    /**
     * @return {@link #reported} (Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.)
     */
    public BooleanType getReportedBooleanType() throws FHIRException { 
      if (this.reported == null)
        this.reported = new BooleanType();
      if (!(this.reported instanceof BooleanType))
        throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.reported.getClass().getName()+" was encountered");
      return (BooleanType) this.reported;
    }

    public boolean hasReportedBooleanType() { 
      return this != null && this.reported instanceof BooleanType;
    }

    /**
     * @return {@link #reported} (Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.)
     */
    public Reference getReportedReference() throws FHIRException { 
      if (this.reported == null)
        this.reported = new Reference();
      if (!(this.reported instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.reported.getClass().getName()+" was encountered");
      return (Reference) this.reported;
    }

    public boolean hasReportedReference() { 
      return this != null && this.reported instanceof Reference;
    }

    public boolean hasReported() { 
      return this.reported != null && !this.reported.isEmpty();
    }

    /**
     * @param value {@link #reported} (Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.)
     */
    public Procedure setReported(DataType value) { 
      if (value != null && !(value instanceof BooleanType || value instanceof Reference))
        throw new Error("Not the right type for Procedure.reported[x]: "+value.fhirType());
      this.reported = value;
      return this;
    }

    /**
     * @return {@link #performer} (Limited to "real" people rather than equipment.)
     */
    public List<ProcedurePerformerComponent> getPerformer() { 
      if (this.performer == null)
        this.performer = new ArrayList<ProcedurePerformerComponent>();
      return this.performer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setPerformer(List<ProcedurePerformerComponent> thePerformer) { 
      this.performer = thePerformer;
      return this;
    }

    public boolean hasPerformer() { 
      if (this.performer == null)
        return false;
      for (ProcedurePerformerComponent item : this.performer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ProcedurePerformerComponent addPerformer() { //3
      ProcedurePerformerComponent t = new ProcedurePerformerComponent();
      if (this.performer == null)
        this.performer = new ArrayList<ProcedurePerformerComponent>();
      this.performer.add(t);
      return t;
    }

    public Procedure addPerformer(ProcedurePerformerComponent t) { //3
      if (t == null)
        return this;
      if (this.performer == null)
        this.performer = new ArrayList<ProcedurePerformerComponent>();
      this.performer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist {3}
     */
    public ProcedurePerformerComponent getPerformerFirstRep() { 
      if (getPerformer().isEmpty()) {
        addPerformer();
      }
      return getPerformer().get(0);
    }

    /**
     * @return {@link #location} (The location where the procedure actually happened.  E.g. a newborn at home, a tracheostomy at a restaurant.)
     */
    public Reference getLocation() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Procedure.location");
        else if (Configuration.doAutoCreate())
          this.location = new Reference(); // cc
      return this.location;
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (The location where the procedure actually happened.  E.g. a newborn at home, a tracheostomy at a restaurant.)
     */
    public Procedure setLocation(Reference value) { 
      this.location = value;
      return this;
    }

    /**
     * @return {@link #reason} (The coded reason or reference why the procedure was performed. This may be a coded entity of some type, or may simply be present as text, or may be a reference to one of several resources that justify the procedure.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setReason(List<CodeableReference> theReason) { 
      this.reason = theReason;
      return this;
    }

    public boolean hasReason() { 
      if (this.reason == null)
        return false;
      for (CodeableReference item : this.reason)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addReason() { //3
      CodeableReference t = new CodeableReference();
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      this.reason.add(t);
      return t;
    }

    public Procedure addReason(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      this.reason.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reason}, creating it if it does not already exist {3}
     */
    public CodeableReference getReasonFirstRep() { 
      if (getReason().isEmpty()) {
        addReason();
      }
      return getReason().get(0);
    }

    /**
     * @return {@link #bodySite} (Detailed and structured anatomical location information. Multiple locations are allowed - e.g. multiple punch biopsies of a lesion.)
     */
    public List<CodeableConcept> getBodySite() { 
      if (this.bodySite == null)
        this.bodySite = new ArrayList<CodeableConcept>();
      return this.bodySite;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setBodySite(List<CodeableConcept> theBodySite) { 
      this.bodySite = theBodySite;
      return this;
    }

    public boolean hasBodySite() { 
      if (this.bodySite == null)
        return false;
      for (CodeableConcept item : this.bodySite)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addBodySite() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.bodySite == null)
        this.bodySite = new ArrayList<CodeableConcept>();
      this.bodySite.add(t);
      return t;
    }

    public Procedure addBodySite(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.bodySite == null)
        this.bodySite = new ArrayList<CodeableConcept>();
      this.bodySite.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #bodySite}, creating it if it does not already exist {3}
     */
    public CodeableConcept getBodySiteFirstRep() { 
      if (getBodySite().isEmpty()) {
        addBodySite();
      }
      return getBodySite().get(0);
    }

    /**
     * @return {@link #outcome} (The outcome of the procedure - did it resolve the reasons for the procedure being performed?)
     */
    public CodeableConcept getOutcome() { 
      if (this.outcome == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Procedure.outcome");
        else if (Configuration.doAutoCreate())
          this.outcome = new CodeableConcept(); // cc
      return this.outcome;
    }

    public boolean hasOutcome() { 
      return this.outcome != null && !this.outcome.isEmpty();
    }

    /**
     * @param value {@link #outcome} (The outcome of the procedure - did it resolve the reasons for the procedure being performed?)
     */
    public Procedure setOutcome(CodeableConcept value) { 
      this.outcome = value;
      return this;
    }

    /**
     * @return {@link #report} (This could be a histology result, pathology report, surgical report, etc.)
     */
    public List<Reference> getReport() { 
      if (this.report == null)
        this.report = new ArrayList<Reference>();
      return this.report;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setReport(List<Reference> theReport) { 
      this.report = theReport;
      return this;
    }

    public boolean hasReport() { 
      if (this.report == null)
        return false;
      for (Reference item : this.report)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addReport() { //3
      Reference t = new Reference();
      if (this.report == null)
        this.report = new ArrayList<Reference>();
      this.report.add(t);
      return t;
    }

    public Procedure addReport(Reference t) { //3
      if (t == null)
        return this;
      if (this.report == null)
        this.report = new ArrayList<Reference>();
      this.report.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #report}, creating it if it does not already exist {3}
     */
    public Reference getReportFirstRep() { 
      if (getReport().isEmpty()) {
        addReport();
      }
      return getReport().get(0);
    }

    /**
     * @return {@link #complication} (Any complications that occurred during the procedure, or in the immediate post-performance period. These are generally tracked separately from the notes, which will typically describe the procedure itself rather than any 'post procedure' issues.)
     */
    public List<CodeableConcept> getComplication() { 
      if (this.complication == null)
        this.complication = new ArrayList<CodeableConcept>();
      return this.complication;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setComplication(List<CodeableConcept> theComplication) { 
      this.complication = theComplication;
      return this;
    }

    public boolean hasComplication() { 
      if (this.complication == null)
        return false;
      for (CodeableConcept item : this.complication)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addComplication() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.complication == null)
        this.complication = new ArrayList<CodeableConcept>();
      this.complication.add(t);
      return t;
    }

    public Procedure addComplication(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.complication == null)
        this.complication = new ArrayList<CodeableConcept>();
      this.complication.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #complication}, creating it if it does not already exist {3}
     */
    public CodeableConcept getComplicationFirstRep() { 
      if (getComplication().isEmpty()) {
        addComplication();
      }
      return getComplication().get(0);
    }

    /**
     * @return {@link #complicationDetail} (Any complications that occurred during the procedure, or in the immediate post-performance period.)
     */
    public List<Reference> getComplicationDetail() { 
      if (this.complicationDetail == null)
        this.complicationDetail = new ArrayList<Reference>();
      return this.complicationDetail;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setComplicationDetail(List<Reference> theComplicationDetail) { 
      this.complicationDetail = theComplicationDetail;
      return this;
    }

    public boolean hasComplicationDetail() { 
      if (this.complicationDetail == null)
        return false;
      for (Reference item : this.complicationDetail)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addComplicationDetail() { //3
      Reference t = new Reference();
      if (this.complicationDetail == null)
        this.complicationDetail = new ArrayList<Reference>();
      this.complicationDetail.add(t);
      return t;
    }

    public Procedure addComplicationDetail(Reference t) { //3
      if (t == null)
        return this;
      if (this.complicationDetail == null)
        this.complicationDetail = new ArrayList<Reference>();
      this.complicationDetail.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #complicationDetail}, creating it if it does not already exist {3}
     */
    public Reference getComplicationDetailFirstRep() { 
      if (getComplicationDetail().isEmpty()) {
        addComplicationDetail();
      }
      return getComplicationDetail().get(0);
    }

    /**
     * @return {@link #followUp} (If the procedure required specific follow up - e.g. removal of sutures. The follow up may be represented as a simple note or could potentially be more complex, in which case the CarePlan resource can be used.)
     */
    public List<CodeableConcept> getFollowUp() { 
      if (this.followUp == null)
        this.followUp = new ArrayList<CodeableConcept>();
      return this.followUp;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setFollowUp(List<CodeableConcept> theFollowUp) { 
      this.followUp = theFollowUp;
      return this;
    }

    public boolean hasFollowUp() { 
      if (this.followUp == null)
        return false;
      for (CodeableConcept item : this.followUp)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addFollowUp() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.followUp == null)
        this.followUp = new ArrayList<CodeableConcept>();
      this.followUp.add(t);
      return t;
    }

    public Procedure addFollowUp(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.followUp == null)
        this.followUp = new ArrayList<CodeableConcept>();
      this.followUp.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #followUp}, creating it if it does not already exist {3}
     */
    public CodeableConcept getFollowUpFirstRep() { 
      if (getFollowUp().isEmpty()) {
        addFollowUp();
      }
      return getFollowUp().get(0);
    }

    /**
     * @return {@link #note} (Any other notes and comments about the procedure.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setNote(List<Annotation> theNote) { 
      this.note = theNote;
      return this;
    }

    public boolean hasNote() { 
      if (this.note == null)
        return false;
      for (Annotation item : this.note)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Annotation addNote() { //3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public Procedure addNote(Annotation t) { //3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist {3}
     */
    public Annotation getNoteFirstRep() { 
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

    /**
     * @return {@link #focalDevice} (A device that is implanted, removed or otherwise manipulated (calibration, battery replacement, fitting a prosthesis, attaching a wound-vac, etc.) as a focal portion of the Procedure.)
     */
    public List<ProcedureFocalDeviceComponent> getFocalDevice() { 
      if (this.focalDevice == null)
        this.focalDevice = new ArrayList<ProcedureFocalDeviceComponent>();
      return this.focalDevice;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setFocalDevice(List<ProcedureFocalDeviceComponent> theFocalDevice) { 
      this.focalDevice = theFocalDevice;
      return this;
    }

    public boolean hasFocalDevice() { 
      if (this.focalDevice == null)
        return false;
      for (ProcedureFocalDeviceComponent item : this.focalDevice)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ProcedureFocalDeviceComponent addFocalDevice() { //3
      ProcedureFocalDeviceComponent t = new ProcedureFocalDeviceComponent();
      if (this.focalDevice == null)
        this.focalDevice = new ArrayList<ProcedureFocalDeviceComponent>();
      this.focalDevice.add(t);
      return t;
    }

    public Procedure addFocalDevice(ProcedureFocalDeviceComponent t) { //3
      if (t == null)
        return this;
      if (this.focalDevice == null)
        this.focalDevice = new ArrayList<ProcedureFocalDeviceComponent>();
      this.focalDevice.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #focalDevice}, creating it if it does not already exist {3}
     */
    public ProcedureFocalDeviceComponent getFocalDeviceFirstRep() { 
      if (getFocalDevice().isEmpty()) {
        addFocalDevice();
      }
      return getFocalDevice().get(0);
    }

    /**
     * @return {@link #used} (Identifies medications, devices and any other substance used as part of the procedure.)
     */
    public List<CodeableReference> getUsed() { 
      if (this.used == null)
        this.used = new ArrayList<CodeableReference>();
      return this.used;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setUsed(List<CodeableReference> theUsed) { 
      this.used = theUsed;
      return this;
    }

    public boolean hasUsed() { 
      if (this.used == null)
        return false;
      for (CodeableReference item : this.used)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addUsed() { //3
      CodeableReference t = new CodeableReference();
      if (this.used == null)
        this.used = new ArrayList<CodeableReference>();
      this.used.add(t);
      return t;
    }

    public Procedure addUsed(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.used == null)
        this.used = new ArrayList<CodeableReference>();
      this.used.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #used}, creating it if it does not already exist {3}
     */
    public CodeableReference getUsedFirstRep() { 
      if (getUsed().isEmpty()) {
        addUsed();
      }
      return getUsed().get(0);
    }

    /**
     * @return {@link #supportingInfo} (Other resources from the patient record that may be relevant to the procedure.  The information from these resources was either used to create the instance or is provided to help with its interpretation. This extension should not be used if more specific inline elements or extensions are available.)
     */
    public List<Reference> getSupportingInfo() { 
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<Reference>();
      return this.supportingInfo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Procedure setSupportingInfo(List<Reference> theSupportingInfo) { 
      this.supportingInfo = theSupportingInfo;
      return this;
    }

    public boolean hasSupportingInfo() { 
      if (this.supportingInfo == null)
        return false;
      for (Reference item : this.supportingInfo)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSupportingInfo() { //3
      Reference t = new Reference();
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<Reference>();
      this.supportingInfo.add(t);
      return t;
    }

    public Procedure addSupportingInfo(Reference t) { //3
      if (t == null)
        return this;
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<Reference>();
      this.supportingInfo.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #supportingInfo}, creating it if it does not already exist {3}
     */
    public Reference getSupportingInfoFirstRep() { 
      if (getSupportingInfo().isEmpty()) {
        addSupportingInfo();
      }
      return getSupportingInfo().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifiers assigned to this procedure by the performer or other systems which remain constant as the resource is updated and is propagated from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("instantiatesCanonical", "canonical(PlanDefinition|ActivityDefinition|Measure|OperationDefinition|Questionnaire)", "The URL pointing to a FHIR-defined protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical));
        children.add(new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri));
        children.add(new Property("basedOn", "Reference(CarePlan|ServiceRequest)", "A reference to a resource that contains details of the request for this procedure.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("partOf", "Reference(Procedure|Observation|MedicationAdministration)", "A larger event of which this particular procedure is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("status", "code", "A code specifying the state of the procedure. Generally, this will be the in-progress or completed state.", 0, 1, status));
        children.add(new Property("statusReason", "CodeableConcept", "Captures the reason for the current state of the procedure.", 0, 1, statusReason));
        children.add(new Property("category", "CodeableConcept", "A code that classifies the procedure for searching, sorting and display purposes (e.g. \"Surgical Procedure\").", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("code", "CodeableConcept", "The specific procedure that is performed. Use text if the exact nature of the procedure cannot be coded (e.g. \"Laparoscopic Appendectomy\").", 0, 1, code));
        children.add(new Property("subject", "Reference(Patient|Group|Device|Practitioner|Organization|Location)", "On whom or what the procedure was performed. This is usually an individual human, but can also be performed on animals, groups of humans or animals, organizations or practitioners (for licensing), locations or devices (for safety inspections or regulatory authorizations).", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The Encounter during which this Procedure was created or performed or to which the creation of this record is tightly associated.", 0, 1, encounter));
        children.add(new Property("occurrence[x]", "dateTime|Period|string|Age|Range|Timing", "Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, occurrence));
        children.add(new Property("recorded", "dateTime", "The date the occurrence of the procedure was first captured in the record regardless of Procedure.status (potentially after the occurrence of the event).", 0, 1, recorded));
        children.add(new Property("recorder", "Reference(Patient|RelatedPerson|Practitioner|PractitionerRole)", "Individual who recorded the record and takes responsibility for its content.", 0, 1, recorder));
        children.add(new Property("reported[x]", "boolean|Reference(Patient|RelatedPerson|Practitioner|PractitionerRole|Organization)", "Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.", 0, 1, reported));
        children.add(new Property("performer", "", "Limited to \"real\" people rather than equipment.", 0, java.lang.Integer.MAX_VALUE, performer));
        children.add(new Property("location", "Reference(Location)", "The location where the procedure actually happened.  E.g. a newborn at home, a tracheostomy at a restaurant.", 0, 1, location));
        children.add(new Property("reason", "CodeableReference(Condition|Observation|Procedure|DiagnosticReport|DocumentReference)", "The coded reason or reference why the procedure was performed. This may be a coded entity of some type, or may simply be present as text, or may be a reference to one of several resources that justify the procedure.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("bodySite", "CodeableConcept", "Detailed and structured anatomical location information. Multiple locations are allowed - e.g. multiple punch biopsies of a lesion.", 0, java.lang.Integer.MAX_VALUE, bodySite));
        children.add(new Property("outcome", "CodeableConcept", "The outcome of the procedure - did it resolve the reasons for the procedure being performed?", 0, 1, outcome));
        children.add(new Property("report", "Reference(DiagnosticReport|DocumentReference|Composition)", "This could be a histology result, pathology report, surgical report, etc.", 0, java.lang.Integer.MAX_VALUE, report));
        children.add(new Property("complication", "CodeableConcept", "Any complications that occurred during the procedure, or in the immediate post-performance period. These are generally tracked separately from the notes, which will typically describe the procedure itself rather than any 'post procedure' issues.", 0, java.lang.Integer.MAX_VALUE, complication));
        children.add(new Property("complicationDetail", "Reference(Condition)", "Any complications that occurred during the procedure, or in the immediate post-performance period.", 0, java.lang.Integer.MAX_VALUE, complicationDetail));
        children.add(new Property("followUp", "CodeableConcept", "If the procedure required specific follow up - e.g. removal of sutures. The follow up may be represented as a simple note or could potentially be more complex, in which case the CarePlan resource can be used.", 0, java.lang.Integer.MAX_VALUE, followUp));
        children.add(new Property("note", "Annotation", "Any other notes and comments about the procedure.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("focalDevice", "", "A device that is implanted, removed or otherwise manipulated (calibration, battery replacement, fitting a prosthesis, attaching a wound-vac, etc.) as a focal portion of the Procedure.", 0, java.lang.Integer.MAX_VALUE, focalDevice));
        children.add(new Property("used", "CodeableReference(Device|Medication|Substance|BiologicallyDerivedProduct)", "Identifies medications, devices and any other substance used as part of the procedure.", 0, java.lang.Integer.MAX_VALUE, used));
        children.add(new Property("supportingInfo", "Reference(Any)", "Other resources from the patient record that may be relevant to the procedure.  The information from these resources was either used to create the instance or is provided to help with its interpretation. This extension should not be used if more specific inline elements or extensions are available.", 0, java.lang.Integer.MAX_VALUE, supportingInfo));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifiers assigned to this procedure by the performer or other systems which remain constant as the resource is updated and is propagated from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 8911915: /*instantiatesCanonical*/  return new Property("instantiatesCanonical", "canonical(PlanDefinition|ActivityDefinition|Measure|OperationDefinition|Questionnaire)", "The URL pointing to a FHIR-defined protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical);
        case -1926393373: /*instantiatesUri*/  return new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol, guideline, order set or other definition that is adhered to in whole or in part by this Procedure.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|ServiceRequest)", "A reference to a resource that contains details of the request for this procedure.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(Procedure|Observation|MedicationAdministration)", "A larger event of which this particular procedure is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case -892481550: /*status*/  return new Property("status", "code", "A code specifying the state of the procedure. Generally, this will be the in-progress or completed state.", 0, 1, status);
        case 2051346646: /*statusReason*/  return new Property("statusReason", "CodeableConcept", "Captures the reason for the current state of the procedure.", 0, 1, statusReason);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A code that classifies the procedure for searching, sorting and display purposes (e.g. \"Surgical Procedure\").", 0, java.lang.Integer.MAX_VALUE, category);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "The specific procedure that is performed. Use text if the exact nature of the procedure cannot be coded (e.g. \"Laparoscopic Appendectomy\").", 0, 1, code);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Device|Practitioner|Organization|Location)", "On whom or what the procedure was performed. This is usually an individual human, but can also be performed on animals, groups of humans or animals, organizations or practitioners (for licensing), locations or devices (for safety inspections or regulatory authorizations).", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The Encounter during which this Procedure was created or performed or to which the creation of this record is tightly associated.", 0, 1, encounter);
        case -2022646513: /*occurrence[x]*/  return new Property("occurrence[x]", "dateTime|Period|string|Age|Range|Timing", "Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, occurrence);
        case 1687874001: /*occurrence*/  return new Property("occurrence[x]", "dateTime|Period|string|Age|Range|Timing", "Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, occurrence);
        case -298443636: /*occurrenceDateTime*/  return new Property("occurrence[x]", "dateTime", "Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, occurrence);
        case 1397156594: /*occurrencePeriod*/  return new Property("occurrence[x]", "Period", "Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, occurrence);
        case 1496896834: /*occurrenceString*/  return new Property("occurrence[x]", "string", "Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, occurrence);
        case -2022672018: /*occurrenceAge*/  return new Property("occurrence[x]", "Age", "Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, occurrence);
        case 1847908844: /*occurrenceRange*/  return new Property("occurrence[x]", "Range", "Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, occurrence);
        case 1515218299: /*occurrenceTiming*/  return new Property("occurrence[x]", "Timing", "Estimated or actual date, date-time, period, or age when the procedure did occur or is occurring.  Allows a period to support complex procedures that span more than one date, and also allows for the length of the procedure to be captured.", 0, 1, occurrence);
        case -799233872: /*recorded*/  return new Property("recorded", "dateTime", "The date the occurrence of the procedure was first captured in the record regardless of Procedure.status (potentially after the occurrence of the event).", 0, 1, recorded);
        case -799233858: /*recorder*/  return new Property("recorder", "Reference(Patient|RelatedPerson|Practitioner|PractitionerRole)", "Individual who recorded the record and takes responsibility for its content.", 0, 1, recorder);
        case -241505587: /*reported[x]*/  return new Property("reported[x]", "boolean|Reference(Patient|RelatedPerson|Practitioner|PractitionerRole|Organization)", "Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.", 0, 1, reported);
        case -427039533: /*reported*/  return new Property("reported[x]", "boolean|Reference(Patient|RelatedPerson|Practitioner|PractitionerRole|Organization)", "Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.", 0, 1, reported);
        case 1219992533: /*reportedBoolean*/  return new Property("reported[x]", "boolean", "Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.", 0, 1, reported);
        case 1198143416: /*reportedReference*/  return new Property("reported[x]", "Reference(Patient|RelatedPerson|Practitioner|PractitionerRole|Organization)", "Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.", 0, 1, reported);
        case 481140686: /*performer*/  return new Property("performer", "", "Limited to \"real\" people rather than equipment.", 0, java.lang.Integer.MAX_VALUE, performer);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The location where the procedure actually happened.  E.g. a newborn at home, a tracheostomy at a restaurant.", 0, 1, location);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|Procedure|DiagnosticReport|DocumentReference)", "The coded reason or reference why the procedure was performed. This may be a coded entity of some type, or may simply be present as text, or may be a reference to one of several resources that justify the procedure.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 1702620169: /*bodySite*/  return new Property("bodySite", "CodeableConcept", "Detailed and structured anatomical location information. Multiple locations are allowed - e.g. multiple punch biopsies of a lesion.", 0, java.lang.Integer.MAX_VALUE, bodySite);
        case -1106507950: /*outcome*/  return new Property("outcome", "CodeableConcept", "The outcome of the procedure - did it resolve the reasons for the procedure being performed?", 0, 1, outcome);
        case -934521548: /*report*/  return new Property("report", "Reference(DiagnosticReport|DocumentReference|Composition)", "This could be a histology result, pathology report, surgical report, etc.", 0, java.lang.Integer.MAX_VALUE, report);
        case -1644401602: /*complication*/  return new Property("complication", "CodeableConcept", "Any complications that occurred during the procedure, or in the immediate post-performance period. These are generally tracked separately from the notes, which will typically describe the procedure itself rather than any 'post procedure' issues.", 0, java.lang.Integer.MAX_VALUE, complication);
        case -1685272017: /*complicationDetail*/  return new Property("complicationDetail", "Reference(Condition)", "Any complications that occurred during the procedure, or in the immediate post-performance period.", 0, java.lang.Integer.MAX_VALUE, complicationDetail);
        case 301801004: /*followUp*/  return new Property("followUp", "CodeableConcept", "If the procedure required specific follow up - e.g. removal of sutures. The follow up may be represented as a simple note or could potentially be more complex, in which case the CarePlan resource can be used.", 0, java.lang.Integer.MAX_VALUE, followUp);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Any other notes and comments about the procedure.", 0, java.lang.Integer.MAX_VALUE, note);
        case -1129235173: /*focalDevice*/  return new Property("focalDevice", "", "A device that is implanted, removed or otherwise manipulated (calibration, battery replacement, fitting a prosthesis, attaching a wound-vac, etc.) as a focal portion of the Procedure.", 0, java.lang.Integer.MAX_VALUE, focalDevice);
        case 3599293: /*used*/  return new Property("used", "CodeableReference(Device|Medication|Substance|BiologicallyDerivedProduct)", "Identifies medications, devices and any other substance used as part of the procedure.", 0, java.lang.Integer.MAX_VALUE, used);
        case 1922406657: /*supportingInfo*/  return new Property("supportingInfo", "Reference(Any)", "Other resources from the patient record that may be relevant to the procedure.  The information from these resources was either used to create the instance or is provided to help with its interpretation. This extension should not be used if more specific inline elements or extensions are available.", 0, java.lang.Integer.MAX_VALUE, supportingInfo);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 8911915: /*instantiatesCanonical*/ return this.instantiatesCanonical == null ? new Base[0] : this.instantiatesCanonical.toArray(new Base[this.instantiatesCanonical.size()]); // CanonicalType
        case -1926393373: /*instantiatesUri*/ return this.instantiatesUri == null ? new Base[0] : this.instantiatesUri.toArray(new Base[this.instantiatesUri.size()]); // UriType
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<EventStatus>
        case 2051346646: /*statusReason*/ return this.statusReason == null ? new Base[0] : new Base[] {this.statusReason}; // CodeableConcept
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case 1687874001: /*occurrence*/ return this.occurrence == null ? new Base[0] : new Base[] {this.occurrence}; // DataType
        case -799233872: /*recorded*/ return this.recorded == null ? new Base[0] : new Base[] {this.recorded}; // DateTimeType
        case -799233858: /*recorder*/ return this.recorder == null ? new Base[0] : new Base[] {this.recorder}; // Reference
        case -427039533: /*reported*/ return this.reported == null ? new Base[0] : new Base[] {this.reported}; // DataType
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : this.performer.toArray(new Base[this.performer.size()]); // ProcedurePerformerComponent
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case 1702620169: /*bodySite*/ return this.bodySite == null ? new Base[0] : this.bodySite.toArray(new Base[this.bodySite.size()]); // CodeableConcept
        case -1106507950: /*outcome*/ return this.outcome == null ? new Base[0] : new Base[] {this.outcome}; // CodeableConcept
        case -934521548: /*report*/ return this.report == null ? new Base[0] : this.report.toArray(new Base[this.report.size()]); // Reference
        case -1644401602: /*complication*/ return this.complication == null ? new Base[0] : this.complication.toArray(new Base[this.complication.size()]); // CodeableConcept
        case -1685272017: /*complicationDetail*/ return this.complicationDetail == null ? new Base[0] : this.complicationDetail.toArray(new Base[this.complicationDetail.size()]); // Reference
        case 301801004: /*followUp*/ return this.followUp == null ? new Base[0] : this.followUp.toArray(new Base[this.followUp.size()]); // CodeableConcept
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -1129235173: /*focalDevice*/ return this.focalDevice == null ? new Base[0] : this.focalDevice.toArray(new Base[this.focalDevice.size()]); // ProcedureFocalDeviceComponent
        case 3599293: /*used*/ return this.used == null ? new Base[0] : this.used.toArray(new Base[this.used.size()]); // CodeableReference
        case 1922406657: /*supportingInfo*/ return this.supportingInfo == null ? new Base[0] : this.supportingInfo.toArray(new Base[this.supportingInfo.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 8911915: // instantiatesCanonical
          this.getInstantiatesCanonical().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case -1926393373: // instantiatesUri
          this.getInstantiatesUri().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -995410646: // partOf
          this.getPartOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          value = new EventStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EventStatus>
          return value;
        case 2051346646: // statusReason
          this.statusReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1687874001: // occurrence
          this.occurrence = TypeConvertor.castToType(value); // DataType
          return value;
        case -799233872: // recorded
          this.recorded = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -799233858: // recorder
          this.recorder = TypeConvertor.castToReference(value); // Reference
          return value;
        case -427039533: // reported
          this.reported = TypeConvertor.castToType(value); // DataType
          return value;
        case 481140686: // performer
          this.getPerformer().add((ProcedurePerformerComponent) value); // ProcedurePerformerComponent
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 1702620169: // bodySite
          this.getBodySite().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1106507950: // outcome
          this.outcome = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -934521548: // report
          this.getReport().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1644401602: // complication
          this.getComplication().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1685272017: // complicationDetail
          this.getComplicationDetail().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 301801004: // followUp
          this.getFollowUp().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -1129235173: // focalDevice
          this.getFocalDevice().add((ProcedureFocalDeviceComponent) value); // ProcedureFocalDeviceComponent
          return value;
        case 3599293: // used
          this.getUsed().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 1922406657: // supportingInfo
          this.getSupportingInfo().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("instantiatesCanonical")) {
          this.getInstantiatesCanonical().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("instantiatesUri")) {
          this.getInstantiatesUri().add(TypeConvertor.castToUri(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("partOf")) {
          this.getPartOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          value = new EventStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EventStatus>
        } else if (name.equals("statusReason")) {
          this.statusReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("occurrence[x]")) {
          this.occurrence = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("recorded")) {
          this.recorded = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("recorder")) {
          this.recorder = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("reported[x]")) {
          this.reported = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("performer")) {
          this.getPerformer().add((ProcedurePerformerComponent) value);
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("bodySite")) {
          this.getBodySite().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("outcome")) {
          this.outcome = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("report")) {
          this.getReport().add(TypeConvertor.castToReference(value));
        } else if (name.equals("complication")) {
          this.getComplication().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("complicationDetail")) {
          this.getComplicationDetail().add(TypeConvertor.castToReference(value));
        } else if (name.equals("followUp")) {
          this.getFollowUp().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("focalDevice")) {
          this.getFocalDevice().add((ProcedureFocalDeviceComponent) value);
        } else if (name.equals("used")) {
          this.getUsed().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("supportingInfo")) {
          this.getSupportingInfo().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 8911915:  return addInstantiatesCanonicalElement();
        case -1926393373:  return addInstantiatesUriElement();
        case -332612366:  return addBasedOn(); 
        case -995410646:  return addPartOf(); 
        case -892481550:  return getStatusElement();
        case 2051346646:  return getStatusReason();
        case 50511102:  return addCategory(); 
        case 3059181:  return getCode();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case -2022646513:  return getOccurrence();
        case 1687874001:  return getOccurrence();
        case -799233872:  return getRecordedElement();
        case -799233858:  return getRecorder();
        case -241505587:  return getReported();
        case -427039533:  return getReported();
        case 481140686:  return addPerformer(); 
        case 1901043637:  return getLocation();
        case -934964668:  return addReason(); 
        case 1702620169:  return addBodySite(); 
        case -1106507950:  return getOutcome();
        case -934521548:  return addReport(); 
        case -1644401602:  return addComplication(); 
        case -1685272017:  return addComplicationDetail(); 
        case 301801004:  return addFollowUp(); 
        case 3387378:  return addNote(); 
        case -1129235173:  return addFocalDevice(); 
        case 3599293:  return addUsed(); 
        case 1922406657:  return addSupportingInfo(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 8911915: /*instantiatesCanonical*/ return new String[] {"canonical"};
        case -1926393373: /*instantiatesUri*/ return new String[] {"uri"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 2051346646: /*statusReason*/ return new String[] {"CodeableConcept"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case 1687874001: /*occurrence*/ return new String[] {"dateTime", "Period", "string", "Age", "Range", "Timing"};
        case -799233872: /*recorded*/ return new String[] {"dateTime"};
        case -799233858: /*recorder*/ return new String[] {"Reference"};
        case -427039533: /*reported*/ return new String[] {"boolean", "Reference"};
        case 481140686: /*performer*/ return new String[] {};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case 1702620169: /*bodySite*/ return new String[] {"CodeableConcept"};
        case -1106507950: /*outcome*/ return new String[] {"CodeableConcept"};
        case -934521548: /*report*/ return new String[] {"Reference"};
        case -1644401602: /*complication*/ return new String[] {"CodeableConcept"};
        case -1685272017: /*complicationDetail*/ return new String[] {"Reference"};
        case 301801004: /*followUp*/ return new String[] {"CodeableConcept"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -1129235173: /*focalDevice*/ return new String[] {};
        case 3599293: /*used*/ return new String[] {"CodeableReference"};
        case 1922406657: /*supportingInfo*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("instantiatesCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type Procedure.instantiatesCanonical");
        }
        else if (name.equals("instantiatesUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type Procedure.instantiatesUri");
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("partOf")) {
          return addPartOf();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Procedure.status");
        }
        else if (name.equals("statusReason")) {
          this.statusReason = new CodeableConcept();
          return this.statusReason;
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("occurrenceDateTime")) {
          this.occurrence = new DateTimeType();
          return this.occurrence;
        }
        else if (name.equals("occurrencePeriod")) {
          this.occurrence = new Period();
          return this.occurrence;
        }
        else if (name.equals("occurrenceString")) {
          this.occurrence = new StringType();
          return this.occurrence;
        }
        else if (name.equals("occurrenceAge")) {
          this.occurrence = new Age();
          return this.occurrence;
        }
        else if (name.equals("occurrenceRange")) {
          this.occurrence = new Range();
          return this.occurrence;
        }
        else if (name.equals("occurrenceTiming")) {
          this.occurrence = new Timing();
          return this.occurrence;
        }
        else if (name.equals("recorded")) {
          throw new FHIRException("Cannot call addChild on a primitive type Procedure.recorded");
        }
        else if (name.equals("recorder")) {
          this.recorder = new Reference();
          return this.recorder;
        }
        else if (name.equals("reportedBoolean")) {
          this.reported = new BooleanType();
          return this.reported;
        }
        else if (name.equals("reportedReference")) {
          this.reported = new Reference();
          return this.reported;
        }
        else if (name.equals("performer")) {
          return addPerformer();
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("bodySite")) {
          return addBodySite();
        }
        else if (name.equals("outcome")) {
          this.outcome = new CodeableConcept();
          return this.outcome;
        }
        else if (name.equals("report")) {
          return addReport();
        }
        else if (name.equals("complication")) {
          return addComplication();
        }
        else if (name.equals("complicationDetail")) {
          return addComplicationDetail();
        }
        else if (name.equals("followUp")) {
          return addFollowUp();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("focalDevice")) {
          return addFocalDevice();
        }
        else if (name.equals("used")) {
          return addUsed();
        }
        else if (name.equals("supportingInfo")) {
          return addSupportingInfo();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Procedure";

  }

      public Procedure copy() {
        Procedure dst = new Procedure();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Procedure dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (instantiatesCanonical != null) {
          dst.instantiatesCanonical = new ArrayList<CanonicalType>();
          for (CanonicalType i : instantiatesCanonical)
            dst.instantiatesCanonical.add(i.copy());
        };
        if (instantiatesUri != null) {
          dst.instantiatesUri = new ArrayList<UriType>();
          for (UriType i : instantiatesUri)
            dst.instantiatesUri.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        if (partOf != null) {
          dst.partOf = new ArrayList<Reference>();
          for (Reference i : partOf)
            dst.partOf.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.statusReason = statusReason == null ? null : statusReason.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.occurrence = occurrence == null ? null : occurrence.copy();
        dst.recorded = recorded == null ? null : recorded.copy();
        dst.recorder = recorder == null ? null : recorder.copy();
        dst.reported = reported == null ? null : reported.copy();
        if (performer != null) {
          dst.performer = new ArrayList<ProcedurePerformerComponent>();
          for (ProcedurePerformerComponent i : performer)
            dst.performer.add(i.copy());
        };
        dst.location = location == null ? null : location.copy();
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        if (bodySite != null) {
          dst.bodySite = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : bodySite)
            dst.bodySite.add(i.copy());
        };
        dst.outcome = outcome == null ? null : outcome.copy();
        if (report != null) {
          dst.report = new ArrayList<Reference>();
          for (Reference i : report)
            dst.report.add(i.copy());
        };
        if (complication != null) {
          dst.complication = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : complication)
            dst.complication.add(i.copy());
        };
        if (complicationDetail != null) {
          dst.complicationDetail = new ArrayList<Reference>();
          for (Reference i : complicationDetail)
            dst.complicationDetail.add(i.copy());
        };
        if (followUp != null) {
          dst.followUp = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : followUp)
            dst.followUp.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (focalDevice != null) {
          dst.focalDevice = new ArrayList<ProcedureFocalDeviceComponent>();
          for (ProcedureFocalDeviceComponent i : focalDevice)
            dst.focalDevice.add(i.copy());
        };
        if (used != null) {
          dst.used = new ArrayList<CodeableReference>();
          for (CodeableReference i : used)
            dst.used.add(i.copy());
        };
        if (supportingInfo != null) {
          dst.supportingInfo = new ArrayList<Reference>();
          for (Reference i : supportingInfo)
            dst.supportingInfo.add(i.copy());
        };
      }

      protected Procedure typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Procedure))
          return false;
        Procedure o = (Procedure) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(instantiatesCanonical, o.instantiatesCanonical, true)
           && compareDeep(instantiatesUri, o.instantiatesUri, true) && compareDeep(basedOn, o.basedOn, true)
           && compareDeep(partOf, o.partOf, true) && compareDeep(status, o.status, true) && compareDeep(statusReason, o.statusReason, true)
           && compareDeep(category, o.category, true) && compareDeep(code, o.code, true) && compareDeep(subject, o.subject, true)
           && compareDeep(encounter, o.encounter, true) && compareDeep(occurrence, o.occurrence, true) && compareDeep(recorded, o.recorded, true)
           && compareDeep(recorder, o.recorder, true) && compareDeep(reported, o.reported, true) && compareDeep(performer, o.performer, true)
           && compareDeep(location, o.location, true) && compareDeep(reason, o.reason, true) && compareDeep(bodySite, o.bodySite, true)
           && compareDeep(outcome, o.outcome, true) && compareDeep(report, o.report, true) && compareDeep(complication, o.complication, true)
           && compareDeep(complicationDetail, o.complicationDetail, true) && compareDeep(followUp, o.followUp, true)
           && compareDeep(note, o.note, true) && compareDeep(focalDevice, o.focalDevice, true) && compareDeep(used, o.used, true)
           && compareDeep(supportingInfo, o.supportingInfo, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Procedure))
          return false;
        Procedure o = (Procedure) other_;
        return compareValues(instantiatesCanonical, o.instantiatesCanonical, true) && compareValues(instantiatesUri, o.instantiatesUri, true)
           && compareValues(status, o.status, true) && compareValues(recorded, o.recorded, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, instantiatesCanonical
          , instantiatesUri, basedOn, partOf, status, statusReason, category, code, subject
          , encounter, occurrence, recorded, recorder, reported, performer, location, reason
          , bodySite, outcome, report, complication, complicationDetail, followUp, note
          , focalDevice, used, supportingInfo);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Procedure;
   }


}

