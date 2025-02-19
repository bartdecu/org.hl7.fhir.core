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
 * Measurements and simple assertions made about a patient, device or other subject.
 */
@ResourceDef(name="Observation", profile="http://hl7.org/fhir/StructureDefinition/Observation")
public class Observation extends DomainResource {

    public enum TriggeredBytype {
        /**
         * Performance of one or more other tests depending on the results of the initial test.  This may include collection of additional specimen. While a new ServiceRequest is not required to perform the additional test, where it is still needed (e.g., requesting another laboratory to perform the reflex test), the Observation.basedOn would reference the new ServiceRequest that requested the additional test to be performed as well as the original ServiceRequest to reflect the one that provided the authorization.
         */
        REFLEX, 
        /**
         * Performance of the same test again with the same parameters/settings/solution.
         */
        REPEAT, 
        /**
         * Performance of the same test but with different parameters/settings/solution.
         */
        RERUN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static TriggeredBytype fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("reflex".equals(codeString))
          return REFLEX;
        if ("repeat".equals(codeString))
          return REPEAT;
        if ("re-run".equals(codeString))
          return RERUN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown TriggeredBytype code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case REFLEX: return "reflex";
            case REPEAT: return "repeat";
            case RERUN: return "re-run";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case REFLEX: return "http://hl7.org/fhir/observation-triggeredbytype";
            case REPEAT: return "http://hl7.org/fhir/observation-triggeredbytype";
            case RERUN: return "http://hl7.org/fhir/observation-triggeredbytype";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case REFLEX: return "Performance of one or more other tests depending on the results of the initial test.  This may include collection of additional specimen. While a new ServiceRequest is not required to perform the additional test, where it is still needed (e.g., requesting another laboratory to perform the reflex test), the Observation.basedOn would reference the new ServiceRequest that requested the additional test to be performed as well as the original ServiceRequest to reflect the one that provided the authorization.";
            case REPEAT: return "Performance of the same test again with the same parameters/settings/solution.";
            case RERUN: return "Performance of the same test but with different parameters/settings/solution.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case REFLEX: return "Reflex";
            case REPEAT: return "Repeat (per policy)";
            case RERUN: return "Re-run (per policy)";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class TriggeredBytypeEnumFactory implements EnumFactory<TriggeredBytype> {
    public TriggeredBytype fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("reflex".equals(codeString))
          return TriggeredBytype.REFLEX;
        if ("repeat".equals(codeString))
          return TriggeredBytype.REPEAT;
        if ("re-run".equals(codeString))
          return TriggeredBytype.RERUN;
        throw new IllegalArgumentException("Unknown TriggeredBytype code '"+codeString+"'");
        }
        public Enumeration<TriggeredBytype> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<TriggeredBytype>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("reflex".equals(codeString))
          return new Enumeration<TriggeredBytype>(this, TriggeredBytype.REFLEX);
        if ("repeat".equals(codeString))
          return new Enumeration<TriggeredBytype>(this, TriggeredBytype.REPEAT);
        if ("re-run".equals(codeString))
          return new Enumeration<TriggeredBytype>(this, TriggeredBytype.RERUN);
        throw new FHIRException("Unknown TriggeredBytype code '"+codeString+"'");
        }
    public String toCode(TriggeredBytype code) {
      if (code == TriggeredBytype.REFLEX)
        return "reflex";
      if (code == TriggeredBytype.REPEAT)
        return "repeat";
      if (code == TriggeredBytype.RERUN)
        return "re-run";
      return "?";
      }
    public String toSystem(TriggeredBytype code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class ObservationTriggeredByComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Reference to the triggering observation.
         */
        @Child(name = "observation", type = {Observation.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Triggering observation", formalDefinition="Reference to the triggering observation." )
        protected Reference observation;

        /**
         * The type of trigger.
Reflex | Repeat | Re-run.
         */
        @Child(name = "type", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="reflex | repeat | re-run", formalDefinition="The type of trigger.\nReflex | Repeat | Re-run." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-triggeredbytype")
        protected Enumeration<TriggeredBytype> type;

        /**
         * Provides the reason why this observation was performed as a result of the observation(s) referenced.
         */
        @Child(name = "reason", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Reason that the observation was triggered", formalDefinition="Provides the reason why this observation was performed as a result of the observation(s) referenced." )
        protected StringType reason;

        private static final long serialVersionUID = -737822241L;

    /**
     * Constructor
     */
      public ObservationTriggeredByComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ObservationTriggeredByComponent(Reference observation, TriggeredBytype type) {
        super();
        this.setObservation(observation);
        this.setType(type);
      }

        /**
         * @return {@link #observation} (Reference to the triggering observation.)
         */
        public Reference getObservation() { 
          if (this.observation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationTriggeredByComponent.observation");
            else if (Configuration.doAutoCreate())
              this.observation = new Reference(); // cc
          return this.observation;
        }

        public boolean hasObservation() { 
          return this.observation != null && !this.observation.isEmpty();
        }

        /**
         * @param value {@link #observation} (Reference to the triggering observation.)
         */
        public ObservationTriggeredByComponent setObservation(Reference value) { 
          this.observation = value;
          return this;
        }

        /**
         * @return {@link #type} (The type of trigger.
Reflex | Repeat | Re-run.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<TriggeredBytype> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationTriggeredByComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<TriggeredBytype>(new TriggeredBytypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of trigger.
Reflex | Repeat | Re-run.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public ObservationTriggeredByComponent setTypeElement(Enumeration<TriggeredBytype> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type of trigger.
Reflex | Repeat | Re-run.
         */
        public TriggeredBytype getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type of trigger.
Reflex | Repeat | Re-run.
         */
        public ObservationTriggeredByComponent setType(TriggeredBytype value) { 
            if (this.type == null)
              this.type = new Enumeration<TriggeredBytype>(new TriggeredBytypeEnumFactory());
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #reason} (Provides the reason why this observation was performed as a result of the observation(s) referenced.). This is the underlying object with id, value and extensions. The accessor "getReason" gives direct access to the value
         */
        public StringType getReasonElement() { 
          if (this.reason == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationTriggeredByComponent.reason");
            else if (Configuration.doAutoCreate())
              this.reason = new StringType(); // bb
          return this.reason;
        }

        public boolean hasReasonElement() { 
          return this.reason != null && !this.reason.isEmpty();
        }

        public boolean hasReason() { 
          return this.reason != null && !this.reason.isEmpty();
        }

        /**
         * @param value {@link #reason} (Provides the reason why this observation was performed as a result of the observation(s) referenced.). This is the underlying object with id, value and extensions. The accessor "getReason" gives direct access to the value
         */
        public ObservationTriggeredByComponent setReasonElement(StringType value) { 
          this.reason = value;
          return this;
        }

        /**
         * @return Provides the reason why this observation was performed as a result of the observation(s) referenced.
         */
        public String getReason() { 
          return this.reason == null ? null : this.reason.getValue();
        }

        /**
         * @param value Provides the reason why this observation was performed as a result of the observation(s) referenced.
         */
        public ObservationTriggeredByComponent setReason(String value) { 
          if (Utilities.noString(value))
            this.reason = null;
          else {
            if (this.reason == null)
              this.reason = new StringType();
            this.reason.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("observation", "Reference(Observation)", "Reference to the triggering observation.", 0, 1, observation));
          children.add(new Property("type", "code", "The type of trigger.\nReflex | Repeat | Re-run.", 0, 1, type));
          children.add(new Property("reason", "string", "Provides the reason why this observation was performed as a result of the observation(s) referenced.", 0, 1, reason));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 122345516: /*observation*/  return new Property("observation", "Reference(Observation)", "Reference to the triggering observation.", 0, 1, observation);
          case 3575610: /*type*/  return new Property("type", "code", "The type of trigger.\nReflex | Repeat | Re-run.", 0, 1, type);
          case -934964668: /*reason*/  return new Property("reason", "string", "Provides the reason why this observation was performed as a result of the observation(s) referenced.", 0, 1, reason);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 122345516: /*observation*/ return this.observation == null ? new Base[0] : new Base[] {this.observation}; // Reference
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<TriggeredBytype>
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : new Base[] {this.reason}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 122345516: // observation
          this.observation = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3575610: // type
          value = new TriggeredBytypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<TriggeredBytype>
          return value;
        case -934964668: // reason
          this.reason = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("observation")) {
          this.observation = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("type")) {
          value = new TriggeredBytypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<TriggeredBytype>
        } else if (name.equals("reason")) {
          this.reason = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 122345516:  return getObservation();
        case 3575610:  return getTypeElement();
        case -934964668:  return getReasonElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 122345516: /*observation*/ return new String[] {"Reference"};
        case 3575610: /*type*/ return new String[] {"code"};
        case -934964668: /*reason*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("observation")) {
          this.observation = new Reference();
          return this.observation;
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type Observation.triggeredBy.type");
        }
        else if (name.equals("reason")) {
          throw new FHIRException("Cannot call addChild on a primitive type Observation.triggeredBy.reason");
        }
        else
          return super.addChild(name);
      }

      public ObservationTriggeredByComponent copy() {
        ObservationTriggeredByComponent dst = new ObservationTriggeredByComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ObservationTriggeredByComponent dst) {
        super.copyValues(dst);
        dst.observation = observation == null ? null : observation.copy();
        dst.type = type == null ? null : type.copy();
        dst.reason = reason == null ? null : reason.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ObservationTriggeredByComponent))
          return false;
        ObservationTriggeredByComponent o = (ObservationTriggeredByComponent) other_;
        return compareDeep(observation, o.observation, true) && compareDeep(type, o.type, true) && compareDeep(reason, o.reason, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ObservationTriggeredByComponent))
          return false;
        ObservationTriggeredByComponent o = (ObservationTriggeredByComponent) other_;
        return compareValues(type, o.type, true) && compareValues(reason, o.reason, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(observation, type, reason
          );
      }

  public String fhirType() {
    return "Observation.triggeredBy";

  }

  }

    @Block()
    public static class ObservationReferenceRangeComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The value of the low bound of the reference range.  The low bound of the reference range endpoint is inclusive of the value (e.g.  reference range is >=5 - <=9). If the low bound is omitted,  it is assumed to be meaningless (e.g. reference range is <=2.3).
         */
        @Child(name = "low", type = {Quantity.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Low Range, if relevant", formalDefinition="The value of the low bound of the reference range.  The low bound of the reference range endpoint is inclusive of the value (e.g.  reference range is >=5 - <=9). If the low bound is omitted,  it is assumed to be meaningless (e.g. reference range is <=2.3)." )
        protected Quantity low;

        /**
         * The value of the high bound of the reference range.  The high bound of the reference range endpoint is inclusive of the value (e.g.  reference range is >=5 - <=9). If the high bound is omitted,  it is assumed to be meaningless (e.g. reference range is >= 2.3).
         */
        @Child(name = "high", type = {Quantity.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="High Range, if relevant", formalDefinition="The value of the high bound of the reference range.  The high bound of the reference range endpoint is inclusive of the value (e.g.  reference range is >=5 - <=9). If the high bound is omitted,  it is assumed to be meaningless (e.g. reference range is >= 2.3)." )
        protected Quantity high;

        /**
         * The value of the normal value of the reference range.
         */
        @Child(name = "normalValue", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Normal value, if relevant", formalDefinition="The value of the normal value of the reference range." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-referencerange-normalvalue")
        protected CodeableConcept normalValue;

        /**
         * Codes to indicate the what part of the targeted reference population it applies to. For example, the normal or therapeutic range.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Reference range qualifier", formalDefinition="Codes to indicate the what part of the targeted reference population it applies to. For example, the normal or therapeutic range." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/referencerange-meaning")
        protected CodeableConcept type;

        /**
         * Codes to indicate the target population this reference range applies to.  For example, a reference range may be based on the normal population or a particular sex or race.  Multiple `appliesTo`  are interpreted as an "AND" of the target populations.  For example, to represent a target population of African American females, both a code of female and a code for African American would be used.
         */
        @Child(name = "appliesTo", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Reference range population", formalDefinition="Codes to indicate the target population this reference range applies to.  For example, a reference range may be based on the normal population or a particular sex or race.  Multiple `appliesTo`  are interpreted as an \"AND\" of the target populations.  For example, to represent a target population of African American females, both a code of female and a code for African American would be used." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/referencerange-appliesto")
        protected List<CodeableConcept> appliesTo;

        /**
         * The age at which this reference range is applicable. This is a neonatal age (e.g. number of weeks at term) if the meaning says so.
         */
        @Child(name = "age", type = {Range.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Applicable age range, if relevant", formalDefinition="The age at which this reference range is applicable. This is a neonatal age (e.g. number of weeks at term) if the meaning says so." )
        protected Range age;

        /**
         * Text based reference range in an observation which may be used when a quantitative range is not appropriate for an observation.  An example would be a reference value of "Negative" or a list or table of "normals".
         */
        @Child(name = "text", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Text based reference range in an observation", formalDefinition="Text based reference range in an observation which may be used when a quantitative range is not appropriate for an observation.  An example would be a reference value of \"Negative\" or a list or table of \"normals\"." )
        protected StringType text;

        private static final long serialVersionUID = -2015583438L;

    /**
     * Constructor
     */
      public ObservationReferenceRangeComponent() {
        super();
      }

        /**
         * @return {@link #low} (The value of the low bound of the reference range.  The low bound of the reference range endpoint is inclusive of the value (e.g.  reference range is >=5 - <=9). If the low bound is omitted,  it is assumed to be meaningless (e.g. reference range is <=2.3).)
         */
        public Quantity getLow() { 
          if (this.low == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationReferenceRangeComponent.low");
            else if (Configuration.doAutoCreate())
              this.low = new Quantity(); // cc
          return this.low;
        }

        public boolean hasLow() { 
          return this.low != null && !this.low.isEmpty();
        }

        /**
         * @param value {@link #low} (The value of the low bound of the reference range.  The low bound of the reference range endpoint is inclusive of the value (e.g.  reference range is >=5 - <=9). If the low bound is omitted,  it is assumed to be meaningless (e.g. reference range is <=2.3).)
         */
        public ObservationReferenceRangeComponent setLow(Quantity value) { 
          this.low = value;
          return this;
        }

        /**
         * @return {@link #high} (The value of the high bound of the reference range.  The high bound of the reference range endpoint is inclusive of the value (e.g.  reference range is >=5 - <=9). If the high bound is omitted,  it is assumed to be meaningless (e.g. reference range is >= 2.3).)
         */
        public Quantity getHigh() { 
          if (this.high == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationReferenceRangeComponent.high");
            else if (Configuration.doAutoCreate())
              this.high = new Quantity(); // cc
          return this.high;
        }

        public boolean hasHigh() { 
          return this.high != null && !this.high.isEmpty();
        }

        /**
         * @param value {@link #high} (The value of the high bound of the reference range.  The high bound of the reference range endpoint is inclusive of the value (e.g.  reference range is >=5 - <=9). If the high bound is omitted,  it is assumed to be meaningless (e.g. reference range is >= 2.3).)
         */
        public ObservationReferenceRangeComponent setHigh(Quantity value) { 
          this.high = value;
          return this;
        }

        /**
         * @return {@link #normalValue} (The value of the normal value of the reference range.)
         */
        public CodeableConcept getNormalValue() { 
          if (this.normalValue == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationReferenceRangeComponent.normalValue");
            else if (Configuration.doAutoCreate())
              this.normalValue = new CodeableConcept(); // cc
          return this.normalValue;
        }

        public boolean hasNormalValue() { 
          return this.normalValue != null && !this.normalValue.isEmpty();
        }

        /**
         * @param value {@link #normalValue} (The value of the normal value of the reference range.)
         */
        public ObservationReferenceRangeComponent setNormalValue(CodeableConcept value) { 
          this.normalValue = value;
          return this;
        }

        /**
         * @return {@link #type} (Codes to indicate the what part of the targeted reference population it applies to. For example, the normal or therapeutic range.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationReferenceRangeComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Codes to indicate the what part of the targeted reference population it applies to. For example, the normal or therapeutic range.)
         */
        public ObservationReferenceRangeComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #appliesTo} (Codes to indicate the target population this reference range applies to.  For example, a reference range may be based on the normal population or a particular sex or race.  Multiple `appliesTo`  are interpreted as an "AND" of the target populations.  For example, to represent a target population of African American females, both a code of female and a code for African American would be used.)
         */
        public List<CodeableConcept> getAppliesTo() { 
          if (this.appliesTo == null)
            this.appliesTo = new ArrayList<CodeableConcept>();
          return this.appliesTo;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ObservationReferenceRangeComponent setAppliesTo(List<CodeableConcept> theAppliesTo) { 
          this.appliesTo = theAppliesTo;
          return this;
        }

        public boolean hasAppliesTo() { 
          if (this.appliesTo == null)
            return false;
          for (CodeableConcept item : this.appliesTo)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addAppliesTo() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.appliesTo == null)
            this.appliesTo = new ArrayList<CodeableConcept>();
          this.appliesTo.add(t);
          return t;
        }

        public ObservationReferenceRangeComponent addAppliesTo(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.appliesTo == null)
            this.appliesTo = new ArrayList<CodeableConcept>();
          this.appliesTo.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #appliesTo}, creating it if it does not already exist {3}
         */
        public CodeableConcept getAppliesToFirstRep() { 
          if (getAppliesTo().isEmpty()) {
            addAppliesTo();
          }
          return getAppliesTo().get(0);
        }

        /**
         * @return {@link #age} (The age at which this reference range is applicable. This is a neonatal age (e.g. number of weeks at term) if the meaning says so.)
         */
        public Range getAge() { 
          if (this.age == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationReferenceRangeComponent.age");
            else if (Configuration.doAutoCreate())
              this.age = new Range(); // cc
          return this.age;
        }

        public boolean hasAge() { 
          return this.age != null && !this.age.isEmpty();
        }

        /**
         * @param value {@link #age} (The age at which this reference range is applicable. This is a neonatal age (e.g. number of weeks at term) if the meaning says so.)
         */
        public ObservationReferenceRangeComponent setAge(Range value) { 
          this.age = value;
          return this;
        }

        /**
         * @return {@link #text} (Text based reference range in an observation which may be used when a quantitative range is not appropriate for an observation.  An example would be a reference value of "Negative" or a list or table of "normals".). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public StringType getTextElement() { 
          if (this.text == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationReferenceRangeComponent.text");
            else if (Configuration.doAutoCreate())
              this.text = new StringType(); // bb
          return this.text;
        }

        public boolean hasTextElement() { 
          return this.text != null && !this.text.isEmpty();
        }

        public boolean hasText() { 
          return this.text != null && !this.text.isEmpty();
        }

        /**
         * @param value {@link #text} (Text based reference range in an observation which may be used when a quantitative range is not appropriate for an observation.  An example would be a reference value of "Negative" or a list or table of "normals".). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public ObservationReferenceRangeComponent setTextElement(StringType value) { 
          this.text = value;
          return this;
        }

        /**
         * @return Text based reference range in an observation which may be used when a quantitative range is not appropriate for an observation.  An example would be a reference value of "Negative" or a list or table of "normals".
         */
        public String getText() { 
          return this.text == null ? null : this.text.getValue();
        }

        /**
         * @param value Text based reference range in an observation which may be used when a quantitative range is not appropriate for an observation.  An example would be a reference value of "Negative" or a list or table of "normals".
         */
        public ObservationReferenceRangeComponent setText(String value) { 
          if (Utilities.noString(value))
            this.text = null;
          else {
            if (this.text == null)
              this.text = new StringType();
            this.text.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("low", "Quantity", "The value of the low bound of the reference range.  The low bound of the reference range endpoint is inclusive of the value (e.g.  reference range is >=5 - <=9). If the low bound is omitted,  it is assumed to be meaningless (e.g. reference range is <=2.3).", 0, 1, low));
          children.add(new Property("high", "Quantity", "The value of the high bound of the reference range.  The high bound of the reference range endpoint is inclusive of the value (e.g.  reference range is >=5 - <=9). If the high bound is omitted,  it is assumed to be meaningless (e.g. reference range is >= 2.3).", 0, 1, high));
          children.add(new Property("normalValue", "CodeableConcept", "The value of the normal value of the reference range.", 0, 1, normalValue));
          children.add(new Property("type", "CodeableConcept", "Codes to indicate the what part of the targeted reference population it applies to. For example, the normal or therapeutic range.", 0, 1, type));
          children.add(new Property("appliesTo", "CodeableConcept", "Codes to indicate the target population this reference range applies to.  For example, a reference range may be based on the normal population or a particular sex or race.  Multiple `appliesTo`  are interpreted as an \"AND\" of the target populations.  For example, to represent a target population of African American females, both a code of female and a code for African American would be used.", 0, java.lang.Integer.MAX_VALUE, appliesTo));
          children.add(new Property("age", "Range", "The age at which this reference range is applicable. This is a neonatal age (e.g. number of weeks at term) if the meaning says so.", 0, 1, age));
          children.add(new Property("text", "string", "Text based reference range in an observation which may be used when a quantitative range is not appropriate for an observation.  An example would be a reference value of \"Negative\" or a list or table of \"normals\".", 0, 1, text));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 107348: /*low*/  return new Property("low", "Quantity", "The value of the low bound of the reference range.  The low bound of the reference range endpoint is inclusive of the value (e.g.  reference range is >=5 - <=9). If the low bound is omitted,  it is assumed to be meaningless (e.g. reference range is <=2.3).", 0, 1, low);
          case 3202466: /*high*/  return new Property("high", "Quantity", "The value of the high bound of the reference range.  The high bound of the reference range endpoint is inclusive of the value (e.g.  reference range is >=5 - <=9). If the high bound is omitted,  it is assumed to be meaningless (e.g. reference range is >= 2.3).", 0, 1, high);
          case -270017334: /*normalValue*/  return new Property("normalValue", "CodeableConcept", "The value of the normal value of the reference range.", 0, 1, normalValue);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Codes to indicate the what part of the targeted reference population it applies to. For example, the normal or therapeutic range.", 0, 1, type);
          case -2089924569: /*appliesTo*/  return new Property("appliesTo", "CodeableConcept", "Codes to indicate the target population this reference range applies to.  For example, a reference range may be based on the normal population or a particular sex or race.  Multiple `appliesTo`  are interpreted as an \"AND\" of the target populations.  For example, to represent a target population of African American females, both a code of female and a code for African American would be used.", 0, java.lang.Integer.MAX_VALUE, appliesTo);
          case 96511: /*age*/  return new Property("age", "Range", "The age at which this reference range is applicable. This is a neonatal age (e.g. number of weeks at term) if the meaning says so.", 0, 1, age);
          case 3556653: /*text*/  return new Property("text", "string", "Text based reference range in an observation which may be used when a quantitative range is not appropriate for an observation.  An example would be a reference value of \"Negative\" or a list or table of \"normals\".", 0, 1, text);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 107348: /*low*/ return this.low == null ? new Base[0] : new Base[] {this.low}; // Quantity
        case 3202466: /*high*/ return this.high == null ? new Base[0] : new Base[] {this.high}; // Quantity
        case -270017334: /*normalValue*/ return this.normalValue == null ? new Base[0] : new Base[] {this.normalValue}; // CodeableConcept
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -2089924569: /*appliesTo*/ return this.appliesTo == null ? new Base[0] : this.appliesTo.toArray(new Base[this.appliesTo.size()]); // CodeableConcept
        case 96511: /*age*/ return this.age == null ? new Base[0] : new Base[] {this.age}; // Range
        case 3556653: /*text*/ return this.text == null ? new Base[0] : new Base[] {this.text}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 107348: // low
          this.low = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 3202466: // high
          this.high = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -270017334: // normalValue
          this.normalValue = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -2089924569: // appliesTo
          this.getAppliesTo().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 96511: // age
          this.age = TypeConvertor.castToRange(value); // Range
          return value;
        case 3556653: // text
          this.text = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("low")) {
          this.low = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("high")) {
          this.high = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("normalValue")) {
          this.normalValue = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("appliesTo")) {
          this.getAppliesTo().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("age")) {
          this.age = TypeConvertor.castToRange(value); // Range
        } else if (name.equals("text")) {
          this.text = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 107348:  return getLow();
        case 3202466:  return getHigh();
        case -270017334:  return getNormalValue();
        case 3575610:  return getType();
        case -2089924569:  return addAppliesTo(); 
        case 96511:  return getAge();
        case 3556653:  return getTextElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 107348: /*low*/ return new String[] {"Quantity"};
        case 3202466: /*high*/ return new String[] {"Quantity"};
        case -270017334: /*normalValue*/ return new String[] {"CodeableConcept"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -2089924569: /*appliesTo*/ return new String[] {"CodeableConcept"};
        case 96511: /*age*/ return new String[] {"Range"};
        case 3556653: /*text*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("low")) {
          this.low = new Quantity();
          return this.low;
        }
        else if (name.equals("high")) {
          this.high = new Quantity();
          return this.high;
        }
        else if (name.equals("normalValue")) {
          this.normalValue = new CodeableConcept();
          return this.normalValue;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("appliesTo")) {
          return addAppliesTo();
        }
        else if (name.equals("age")) {
          this.age = new Range();
          return this.age;
        }
        else if (name.equals("text")) {
          throw new FHIRException("Cannot call addChild on a primitive type Observation.referenceRange.text");
        }
        else
          return super.addChild(name);
      }

      public ObservationReferenceRangeComponent copy() {
        ObservationReferenceRangeComponent dst = new ObservationReferenceRangeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ObservationReferenceRangeComponent dst) {
        super.copyValues(dst);
        dst.low = low == null ? null : low.copy();
        dst.high = high == null ? null : high.copy();
        dst.normalValue = normalValue == null ? null : normalValue.copy();
        dst.type = type == null ? null : type.copy();
        if (appliesTo != null) {
          dst.appliesTo = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : appliesTo)
            dst.appliesTo.add(i.copy());
        };
        dst.age = age == null ? null : age.copy();
        dst.text = text == null ? null : text.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ObservationReferenceRangeComponent))
          return false;
        ObservationReferenceRangeComponent o = (ObservationReferenceRangeComponent) other_;
        return compareDeep(low, o.low, true) && compareDeep(high, o.high, true) && compareDeep(normalValue, o.normalValue, true)
           && compareDeep(type, o.type, true) && compareDeep(appliesTo, o.appliesTo, true) && compareDeep(age, o.age, true)
           && compareDeep(text, o.text, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ObservationReferenceRangeComponent))
          return false;
        ObservationReferenceRangeComponent o = (ObservationReferenceRangeComponent) other_;
        return compareValues(text, o.text, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(low, high, normalValue, type
          , appliesTo, age, text);
      }

  public String fhirType() {
    return "Observation.referenceRange";

  }

  }

    @Block()
    public static class ObservationComponentComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Describes what was observed. Sometimes this is called the observation "code".
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Type of component observation (code / type)", formalDefinition="Describes what was observed. Sometimes this is called the observation \"code\"." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-codes")
        protected CodeableConcept code;

        /**
         * The information determined as a result of making the observation, if the information has a simple value.
         */
        @Child(name = "value", type = {Quantity.class, CodeableConcept.class, StringType.class, BooleanType.class, IntegerType.class, Range.class, Ratio.class, SampledData.class, TimeType.class, DateTimeType.class, Period.class, Attachment.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Actual component result", formalDefinition="The information determined as a result of making the observation, if the information has a simple value." )
        protected DataType value;

        /**
         * Provides a reason why the expected value in the element Observation.component.value[x] is missing.
         */
        @Child(name = "dataAbsentReason", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Why the component result is missing", formalDefinition="Provides a reason why the expected value in the element Observation.component.value[x] is missing." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/data-absent-reason")
        protected CodeableConcept dataAbsentReason;

        /**
         * A categorical assessment of an observation value.  For example, high, low, normal.
         */
        @Child(name = "interpretation", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="High, low, normal, etc.", formalDefinition="A categorical assessment of an observation value.  For example, high, low, normal." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-interpretation")
        protected List<CodeableConcept> interpretation;

        /**
         * Guidance on how to interpret the value by comparison to a normal or recommended range.
         */
        @Child(name = "referenceRange", type = {ObservationReferenceRangeComponent.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Provides guide for interpretation of component result", formalDefinition="Guidance on how to interpret the value by comparison to a normal or recommended range." )
        protected List<ObservationReferenceRangeComponent> referenceRange;

        private static final long serialVersionUID = -1771757751L;

    /**
     * Constructor
     */
      public ObservationComponentComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ObservationComponentComponent(CodeableConcept code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (Describes what was observed. Sometimes this is called the observation "code".)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationComponentComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Describes what was observed. Sometimes this is called the observation "code".)
         */
        public ObservationComponentComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() { 
          return this != null && this.value instanceof Quantity;
        }

        /**
         * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
         */
        public CodeableConcept getValueCodeableConcept() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableConcept();
          if (!(this.value instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableConcept) this.value;
        }

        public boolean hasValueCodeableConcept() { 
          return this != null && this.value instanceof CodeableConcept;
        }

        /**
         * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
         */
        public StringType getValueStringType() throws FHIRException { 
          if (this.value == null)
            this.value = new StringType();
          if (!(this.value instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (StringType) this.value;
        }

        public boolean hasValueStringType() { 
          return this != null && this.value instanceof StringType;
        }

        /**
         * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
         */
        public BooleanType getValueBooleanType() throws FHIRException { 
          if (this.value == null)
            this.value = new BooleanType();
          if (!(this.value instanceof BooleanType))
            throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (BooleanType) this.value;
        }

        public boolean hasValueBooleanType() { 
          return this != null && this.value instanceof BooleanType;
        }

        /**
         * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
         */
        public IntegerType getValueIntegerType() throws FHIRException { 
          if (this.value == null)
            this.value = new IntegerType();
          if (!(this.value instanceof IntegerType))
            throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (IntegerType) this.value;
        }

        public boolean hasValueIntegerType() { 
          return this != null && this.value instanceof IntegerType;
        }

        /**
         * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
         */
        public Range getValueRange() throws FHIRException { 
          if (this.value == null)
            this.value = new Range();
          if (!(this.value instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Range) this.value;
        }

        public boolean hasValueRange() { 
          return this != null && this.value instanceof Range;
        }

        /**
         * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
         */
        public Ratio getValueRatio() throws FHIRException { 
          if (this.value == null)
            this.value = new Ratio();
          if (!(this.value instanceof Ratio))
            throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Ratio) this.value;
        }

        public boolean hasValueRatio() { 
          return this != null && this.value instanceof Ratio;
        }

        /**
         * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
         */
        public SampledData getValueSampledData() throws FHIRException { 
          if (this.value == null)
            this.value = new SampledData();
          if (!(this.value instanceof SampledData))
            throw new FHIRException("Type mismatch: the type SampledData was expected, but "+this.value.getClass().getName()+" was encountered");
          return (SampledData) this.value;
        }

        public boolean hasValueSampledData() { 
          return this != null && this.value instanceof SampledData;
        }

        /**
         * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
         */
        public TimeType getValueTimeType() throws FHIRException { 
          if (this.value == null)
            this.value = new TimeType();
          if (!(this.value instanceof TimeType))
            throw new FHIRException("Type mismatch: the type TimeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (TimeType) this.value;
        }

        public boolean hasValueTimeType() { 
          return this != null && this.value instanceof TimeType;
        }

        /**
         * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
         */
        public DateTimeType getValueDateTimeType() throws FHIRException { 
          if (this.value == null)
            this.value = new DateTimeType();
          if (!(this.value instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (DateTimeType) this.value;
        }

        public boolean hasValueDateTimeType() { 
          return this != null && this.value instanceof DateTimeType;
        }

        /**
         * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
         */
        public Period getValuePeriod() throws FHIRException { 
          if (this.value == null)
            this.value = new Period();
          if (!(this.value instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Period) this.value;
        }

        public boolean hasValuePeriod() { 
          return this != null && this.value instanceof Period;
        }

        /**
         * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
         */
        public Attachment getValueAttachment() throws FHIRException { 
          if (this.value == null)
            this.value = new Attachment();
          if (!(this.value instanceof Attachment))
            throw new FHIRException("Type mismatch: the type Attachment was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Attachment) this.value;
        }

        public boolean hasValueAttachment() { 
          return this != null && this.value instanceof Attachment;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
         */
        public ObservationComponentComponent setValue(DataType value) { 
          if (value != null && !(value instanceof Quantity || value instanceof CodeableConcept || value instanceof StringType || value instanceof BooleanType || value instanceof IntegerType || value instanceof Range || value instanceof Ratio || value instanceof SampledData || value instanceof TimeType || value instanceof DateTimeType || value instanceof Period || value instanceof Attachment))
            throw new Error("Not the right type for Observation.component.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        /**
         * @return {@link #dataAbsentReason} (Provides a reason why the expected value in the element Observation.component.value[x] is missing.)
         */
        public CodeableConcept getDataAbsentReason() { 
          if (this.dataAbsentReason == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ObservationComponentComponent.dataAbsentReason");
            else if (Configuration.doAutoCreate())
              this.dataAbsentReason = new CodeableConcept(); // cc
          return this.dataAbsentReason;
        }

        public boolean hasDataAbsentReason() { 
          return this.dataAbsentReason != null && !this.dataAbsentReason.isEmpty();
        }

        /**
         * @param value {@link #dataAbsentReason} (Provides a reason why the expected value in the element Observation.component.value[x] is missing.)
         */
        public ObservationComponentComponent setDataAbsentReason(CodeableConcept value) { 
          this.dataAbsentReason = value;
          return this;
        }

        /**
         * @return {@link #interpretation} (A categorical assessment of an observation value.  For example, high, low, normal.)
         */
        public List<CodeableConcept> getInterpretation() { 
          if (this.interpretation == null)
            this.interpretation = new ArrayList<CodeableConcept>();
          return this.interpretation;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ObservationComponentComponent setInterpretation(List<CodeableConcept> theInterpretation) { 
          this.interpretation = theInterpretation;
          return this;
        }

        public boolean hasInterpretation() { 
          if (this.interpretation == null)
            return false;
          for (CodeableConcept item : this.interpretation)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addInterpretation() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.interpretation == null)
            this.interpretation = new ArrayList<CodeableConcept>();
          this.interpretation.add(t);
          return t;
        }

        public ObservationComponentComponent addInterpretation(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.interpretation == null)
            this.interpretation = new ArrayList<CodeableConcept>();
          this.interpretation.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #interpretation}, creating it if it does not already exist {3}
         */
        public CodeableConcept getInterpretationFirstRep() { 
          if (getInterpretation().isEmpty()) {
            addInterpretation();
          }
          return getInterpretation().get(0);
        }

        /**
         * @return {@link #referenceRange} (Guidance on how to interpret the value by comparison to a normal or recommended range.)
         */
        public List<ObservationReferenceRangeComponent> getReferenceRange() { 
          if (this.referenceRange == null)
            this.referenceRange = new ArrayList<ObservationReferenceRangeComponent>();
          return this.referenceRange;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ObservationComponentComponent setReferenceRange(List<ObservationReferenceRangeComponent> theReferenceRange) { 
          this.referenceRange = theReferenceRange;
          return this;
        }

        public boolean hasReferenceRange() { 
          if (this.referenceRange == null)
            return false;
          for (ObservationReferenceRangeComponent item : this.referenceRange)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ObservationReferenceRangeComponent addReferenceRange() { //3
          ObservationReferenceRangeComponent t = new ObservationReferenceRangeComponent();
          if (this.referenceRange == null)
            this.referenceRange = new ArrayList<ObservationReferenceRangeComponent>();
          this.referenceRange.add(t);
          return t;
        }

        public ObservationComponentComponent addReferenceRange(ObservationReferenceRangeComponent t) { //3
          if (t == null)
            return this;
          if (this.referenceRange == null)
            this.referenceRange = new ArrayList<ObservationReferenceRangeComponent>();
          this.referenceRange.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #referenceRange}, creating it if it does not already exist {3}
         */
        public ObservationReferenceRangeComponent getReferenceRangeFirstRep() { 
          if (getReferenceRange().isEmpty()) {
            addReferenceRange();
          }
          return getReferenceRange().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "Describes what was observed. Sometimes this is called the observation \"code\".", 0, 1, code));
          children.add(new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Ratio|SampledData|time|dateTime|Period|Attachment", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value));
          children.add(new Property("dataAbsentReason", "CodeableConcept", "Provides a reason why the expected value in the element Observation.component.value[x] is missing.", 0, 1, dataAbsentReason));
          children.add(new Property("interpretation", "CodeableConcept", "A categorical assessment of an observation value.  For example, high, low, normal.", 0, java.lang.Integer.MAX_VALUE, interpretation));
          children.add(new Property("referenceRange", "@Observation.referenceRange", "Guidance on how to interpret the value by comparison to a normal or recommended range.", 0, java.lang.Integer.MAX_VALUE, referenceRange));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Describes what was observed. Sometimes this is called the observation \"code\".", 0, 1, code);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Ratio|SampledData|time|dateTime|Period|Attachment", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Ratio|SampledData|time|dateTime|Period|Attachment", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
          case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
          case 2030767386: /*valueRatio*/  return new Property("value[x]", "Ratio", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
          case -962229101: /*valueSampledData*/  return new Property("value[x]", "SampledData", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
          case -765708322: /*valueTime*/  return new Property("value[x]", "time", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
          case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
          case -1524344174: /*valuePeriod*/  return new Property("value[x]", "Period", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
          case 1034315687: /*dataAbsentReason*/  return new Property("dataAbsentReason", "CodeableConcept", "Provides a reason why the expected value in the element Observation.component.value[x] is missing.", 0, 1, dataAbsentReason);
          case -297950712: /*interpretation*/  return new Property("interpretation", "CodeableConcept", "A categorical assessment of an observation value.  For example, high, low, normal.", 0, java.lang.Integer.MAX_VALUE, interpretation);
          case -1912545102: /*referenceRange*/  return new Property("referenceRange", "@Observation.referenceRange", "Guidance on how to interpret the value by comparison to a normal or recommended range.", 0, java.lang.Integer.MAX_VALUE, referenceRange);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        case 1034315687: /*dataAbsentReason*/ return this.dataAbsentReason == null ? new Base[0] : new Base[] {this.dataAbsentReason}; // CodeableConcept
        case -297950712: /*interpretation*/ return this.interpretation == null ? new Base[0] : this.interpretation.toArray(new Base[this.interpretation.size()]); // CodeableConcept
        case -1912545102: /*referenceRange*/ return this.referenceRange == null ? new Base[0] : this.referenceRange.toArray(new Base[this.referenceRange.size()]); // ObservationReferenceRangeComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        case 1034315687: // dataAbsentReason
          this.dataAbsentReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -297950712: // interpretation
          this.getInterpretation().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1912545102: // referenceRange
          this.getReferenceRange().add((ObservationReferenceRangeComponent) value); // ObservationReferenceRangeComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("dataAbsentReason")) {
          this.dataAbsentReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("interpretation")) {
          this.getInterpretation().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("referenceRange")) {
          this.getReferenceRange().add((ObservationReferenceRangeComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        case 1034315687:  return getDataAbsentReason();
        case -297950712:  return addInterpretation(); 
        case -1912545102:  return addReferenceRange(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"Quantity", "CodeableConcept", "string", "boolean", "integer", "Range", "Ratio", "SampledData", "time", "dateTime", "Period", "Attachment"};
        case 1034315687: /*dataAbsentReason*/ return new String[] {"CodeableConcept"};
        case -297950712: /*interpretation*/ return new String[] {"CodeableConcept"};
        case -1912545102: /*referenceRange*/ return new String[] {"@Observation.referenceRange"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueString")) {
          this.value = new StringType();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueInteger")) {
          this.value = new IntegerType();
          return this.value;
        }
        else if (name.equals("valueRange")) {
          this.value = new Range();
          return this.value;
        }
        else if (name.equals("valueRatio")) {
          this.value = new Ratio();
          return this.value;
        }
        else if (name.equals("valueSampledData")) {
          this.value = new SampledData();
          return this.value;
        }
        else if (name.equals("valueTime")) {
          this.value = new TimeType();
          return this.value;
        }
        else if (name.equals("valueDateTime")) {
          this.value = new DateTimeType();
          return this.value;
        }
        else if (name.equals("valuePeriod")) {
          this.value = new Period();
          return this.value;
        }
        else if (name.equals("valueAttachment")) {
          this.value = new Attachment();
          return this.value;
        }
        else if (name.equals("dataAbsentReason")) {
          this.dataAbsentReason = new CodeableConcept();
          return this.dataAbsentReason;
        }
        else if (name.equals("interpretation")) {
          return addInterpretation();
        }
        else if (name.equals("referenceRange")) {
          return addReferenceRange();
        }
        else
          return super.addChild(name);
      }

      public ObservationComponentComponent copy() {
        ObservationComponentComponent dst = new ObservationComponentComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ObservationComponentComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.value = value == null ? null : value.copy();
        dst.dataAbsentReason = dataAbsentReason == null ? null : dataAbsentReason.copy();
        if (interpretation != null) {
          dst.interpretation = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : interpretation)
            dst.interpretation.add(i.copy());
        };
        if (referenceRange != null) {
          dst.referenceRange = new ArrayList<ObservationReferenceRangeComponent>();
          for (ObservationReferenceRangeComponent i : referenceRange)
            dst.referenceRange.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ObservationComponentComponent))
          return false;
        ObservationComponentComponent o = (ObservationComponentComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(value, o.value, true) && compareDeep(dataAbsentReason, o.dataAbsentReason, true)
           && compareDeep(interpretation, o.interpretation, true) && compareDeep(referenceRange, o.referenceRange, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ObservationComponentComponent))
          return false;
        ObservationComponentComponent o = (ObservationComponentComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, value, dataAbsentReason
          , interpretation, referenceRange);
      }

  public String fhirType() {
    return "Observation.component";

  }

  }

    /**
     * A unique identifier assigned to this observation.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business Identifier for observation", formalDefinition="A unique identifier assigned to this observation." )
    protected List<Identifier> identifier;

    /**
     * The reference to a FHIR ObservationDefinition resource that provides the definition that is adhered to in whole or in part by this Observation instance.
     */
    @Child(name = "instantiates", type = {CanonicalType.class, ObservationDefinition.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Instantiates FHIR ObservationDefinition", formalDefinition="The reference to a FHIR ObservationDefinition resource that provides the definition that is adhered to in whole or in part by this Observation instance." )
    protected DataType instantiates;

    /**
     * A plan, proposal or order that is fulfilled in whole or in part by this event.  For example, a MedicationRequest may require a patient to have laboratory test performed before  it is dispensed.
     */
    @Child(name = "basedOn", type = {CarePlan.class, DeviceRequest.class, ImmunizationRecommendation.class, MedicationRequest.class, NutritionOrder.class, ServiceRequest.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Fulfills plan, proposal or order", formalDefinition="A plan, proposal or order that is fulfilled in whole or in part by this event.  For example, a MedicationRequest may require a patient to have laboratory test performed before  it is dispensed." )
    protected List<Reference> basedOn;

    /**
     * Identifies the observation(s) that triggered the performance of this observation.
     */
    @Child(name = "triggeredBy", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Triggering observation(s)", formalDefinition="Identifies the observation(s) that triggered the performance of this observation." )
    protected List<ObservationTriggeredByComponent> triggeredBy;

    /**
     * A larger event of which this particular Observation is a component or step.  For example,  an observation as part of a procedure.
     */
    @Child(name = "partOf", type = {MedicationAdministration.class, MedicationDispense.class, MedicationUsage.class, Procedure.class, Immunization.class, ImagingStudy.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Part of referenced event", formalDefinition="A larger event of which this particular Observation is a component or step.  For example,  an observation as part of a procedure." )
    protected List<Reference> partOf;

    /**
     * The status of the result value.
     */
    @Child(name = "status", type = {CodeType.class}, order=5, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="registered | preliminary | final | amended +", formalDefinition="The status of the result value." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-status")
    protected Enumeration<ObservationStatus> status;

    /**
     * A code that classifies the general type of observation being made.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Classification of  type of observation", formalDefinition="A code that classifies the general type of observation being made." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-category")
    protected List<CodeableConcept> category;

    /**
     * Describes what was observed. Sometimes this is called the observation "name".
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=7, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Type of observation (code / type)", formalDefinition="Describes what was observed. Sometimes this is called the observation \"name\"." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-codes")
    protected CodeableConcept code;

    /**
     * The patient, or group of patients, location, device, organization, procedure or practitioner this observation is about and into whose or what record the observation is placed. If the actual focus of the observation is different from the subject (or a sample of, part, or region of the subject), the `focus` element or the `code` itself specifies the actual focus of the observation.
     */
    @Child(name = "subject", type = {Patient.class, Group.class, Device.class, Location.class, Organization.class, Procedure.class, Practitioner.class, Medication.class, Substance.class, BiologicallyDerivedProduct.class, NutritionProduct.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who and/or what the observation is about", formalDefinition="The patient, or group of patients, location, device, organization, procedure or practitioner this observation is about and into whose or what record the observation is placed. If the actual focus of the observation is different from the subject (or a sample of, part, or region of the subject), the `focus` element or the `code` itself specifies the actual focus of the observation." )
    protected Reference subject;

    /**
     * The actual focus of an observation when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, fetus, or donor. For example, fetus observations in a mother's record.  The focus of an observation could also be an existing condition,  an intervention, the subject's diet,  another observation of the subject,  or a body structure such as tumor or implanted device.   An example use case would be using the Observation resource to capture whether the mother is trained to change her child's tracheostomy tube. In this example, the child is the patient of record and the mother is the focus.
     */
    @Child(name = "focus", type = {Reference.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="What the observation is about, when it is not about the subject of record", formalDefinition="The actual focus of an observation when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, fetus, or donor. For example, fetus observations in a mother's record.  The focus of an observation could also be an existing condition,  an intervention, the subject's diet,  another observation of the subject,  or a body structure such as tumor or implanted device.   An example use case would be using the Observation resource to capture whether the mother is trained to change her child's tracheostomy tube. In this example, the child is the patient of record and the mother is the focus." )
    protected List<Reference> focus;

    /**
     * The healthcare event  (e.g. a patient and healthcare provider interaction) during which this observation is made.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Healthcare event during which this observation is made", formalDefinition="The healthcare event  (e.g. a patient and healthcare provider interaction) during which this observation is made." )
    protected Reference encounter;

    /**
     * The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the "physiologically relevant time". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself.
     */
    @Child(name = "effective", type = {DateTimeType.class, Period.class, Timing.class, InstantType.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Clinically relevant time/time-period for observation", formalDefinition="The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the \"physiologically relevant time\". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself." )
    protected DataType effective;

    /**
     * The date and time this version of the observation was made available to providers, typically after the results have been reviewed and verified.
     */
    @Child(name = "issued", type = {InstantType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date/Time this version was made available", formalDefinition="The date and time this version of the observation was made available to providers, typically after the results have been reviewed and verified." )
    protected InstantType issued;

    /**
     * Who was responsible for asserting the observed value as "true".
     */
    @Child(name = "performer", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class, Patient.class, RelatedPerson.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who is responsible for the observation", formalDefinition="Who was responsible for asserting the observed value as \"true\"." )
    protected List<Reference> performer;

    /**
     * The information determined as a result of making the observation, if the information has a simple value.
     */
    @Child(name = "value", type = {Quantity.class, CodeableConcept.class, StringType.class, BooleanType.class, IntegerType.class, Range.class, Ratio.class, SampledData.class, TimeType.class, DateTimeType.class, Period.class, Attachment.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Actual result", formalDefinition="The information determined as a result of making the observation, if the information has a simple value." )
    protected DataType value;

    /**
     * Provides a reason why the expected value in the element Observation.value[x] is missing.
     */
    @Child(name = "dataAbsentReason", type = {CodeableConcept.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why the result is missing", formalDefinition="Provides a reason why the expected value in the element Observation.value[x] is missing." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/data-absent-reason")
    protected CodeableConcept dataAbsentReason;

    /**
     * A categorical assessment of an observation value.  For example, high, low, normal.
     */
    @Child(name = "interpretation", type = {CodeableConcept.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="High, low, normal, etc.", formalDefinition="A categorical assessment of an observation value.  For example, high, low, normal." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-interpretation")
    protected List<CodeableConcept> interpretation;

    /**
     * Comments about the observation or the results.
     */
    @Child(name = "note", type = {Annotation.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comments about the observation", formalDefinition="Comments about the observation or the results." )
    protected List<Annotation> note;

    /**
     * Indicates the site on the subject's body where the observation was made (i.e. the target site).
     */
    @Child(name = "bodySite", type = {CodeableConcept.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Observed body part", formalDefinition="Indicates the site on the subject's body where the observation was made (i.e. the target site)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
    protected CodeableConcept bodySite;

    /**
     * Indicates the body structure on the subject's body where the observation was made (i.e. the target site).
     */
    @Child(name = "bodyStructure", type = {BodyStructure.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Observed body structure", formalDefinition="Indicates the body structure on the subject's body where the observation was made (i.e. the target site)." )
    protected Reference bodyStructure;

    /**
     * Indicates the mechanism used to perform the observation.
     */
    @Child(name = "method", type = {CodeableConcept.class}, order=20, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="How it was done", formalDefinition="Indicates the mechanism used to perform the observation." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-methods")
    protected CodeableConcept method;

    /**
     * The specimen that was used when this observation was made.
     */
    @Child(name = "specimen", type = {Specimen.class}, order=21, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Specimen used for this observation", formalDefinition="The specimen that was used when this observation was made." )
    protected Reference specimen;

    /**
     * The device used to generate the observation data.
     */
    @Child(name = "device", type = {Device.class, DeviceMetric.class}, order=22, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="(Measurement) Device", formalDefinition="The device used to generate the observation data." )
    protected Reference device;

    /**
     * Guidance on how to interpret the value by comparison to a normal or recommended range.  Multiple reference ranges are interpreted as an "OR".   In other words, to represent two distinct target populations, two `referenceRange` elements would be used.
     */
    @Child(name = "referenceRange", type = {}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Provides guide for interpretation", formalDefinition="Guidance on how to interpret the value by comparison to a normal or recommended range.  Multiple reference ranges are interpreted as an \"OR\".   In other words, to represent two distinct target populations, two `referenceRange` elements would be used." )
    protected List<ObservationReferenceRangeComponent> referenceRange;

    /**
     * This observation is a group observation (e.g. a battery, a panel of tests, a set of vital sign measurements) that includes the target as a member of the group.
     */
    @Child(name = "hasMember", type = {Observation.class, QuestionnaireResponse.class, MolecularSequence.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Related resource that belongs to the Observation group", formalDefinition="This observation is a group observation (e.g. a battery, a panel of tests, a set of vital sign measurements) that includes the target as a member of the group." )
    protected List<Reference> hasMember;

    /**
     * The target resource that represents a measurement from which this observation value is derived. For example, a calculated anion gap or a fetal measurement based on an ultrasound image.
     */
    @Child(name = "derivedFrom", type = {DocumentReference.class, ImagingStudy.class, ImagingSelection.class, QuestionnaireResponse.class, Observation.class, MolecularSequence.class}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Related resource from which the observation is made", formalDefinition="The target resource that represents a measurement from which this observation value is derived. For example, a calculated anion gap or a fetal measurement based on an ultrasound image." )
    protected List<Reference> derivedFrom;

    /**
     * Some observations have multiple component observations.  These component observations are expressed as separate code value pairs that share the same attributes.  Examples include systolic and diastolic component observations for blood pressure measurement and multiple component observations for genetics observations.
     */
    @Child(name = "component", type = {}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Component results", formalDefinition="Some observations have multiple component observations.  These component observations are expressed as separate code value pairs that share the same attributes.  Examples include systolic and diastolic component observations for blood pressure measurement and multiple component observations for genetics observations." )
    protected List<ObservationComponentComponent> component;

    private static final long serialVersionUID = -44103660L;

  /**
   * Constructor
   */
    public Observation() {
      super();
    }

  /**
   * Constructor
   */
    public Observation(ObservationStatus status, CodeableConcept code) {
      super();
      this.setStatus(status);
      this.setCode(code);
    }

    /**
     * @return {@link #identifier} (A unique identifier assigned to this observation.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Observation setIdentifier(List<Identifier> theIdentifier) { 
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

    public Observation addIdentifier(Identifier t) { //3
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
     * @return {@link #instantiates} (The reference to a FHIR ObservationDefinition resource that provides the definition that is adhered to in whole or in part by this Observation instance.)
     */
    public DataType getInstantiates() { 
      return this.instantiates;
    }

    /**
     * @return {@link #instantiates} (The reference to a FHIR ObservationDefinition resource that provides the definition that is adhered to in whole or in part by this Observation instance.)
     */
    public CanonicalType getInstantiatesCanonicalType() throws FHIRException { 
      if (this.instantiates == null)
        this.instantiates = new CanonicalType();
      if (!(this.instantiates instanceof CanonicalType))
        throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.instantiates.getClass().getName()+" was encountered");
      return (CanonicalType) this.instantiates;
    }

    public boolean hasInstantiatesCanonicalType() { 
      return this != null && this.instantiates instanceof CanonicalType;
    }

    /**
     * @return {@link #instantiates} (The reference to a FHIR ObservationDefinition resource that provides the definition that is adhered to in whole or in part by this Observation instance.)
     */
    public Reference getInstantiatesReference() throws FHIRException { 
      if (this.instantiates == null)
        this.instantiates = new Reference();
      if (!(this.instantiates instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.instantiates.getClass().getName()+" was encountered");
      return (Reference) this.instantiates;
    }

    public boolean hasInstantiatesReference() { 
      return this != null && this.instantiates instanceof Reference;
    }

    public boolean hasInstantiates() { 
      return this.instantiates != null && !this.instantiates.isEmpty();
    }

    /**
     * @param value {@link #instantiates} (The reference to a FHIR ObservationDefinition resource that provides the definition that is adhered to in whole or in part by this Observation instance.)
     */
    public Observation setInstantiates(DataType value) { 
      if (value != null && !(value instanceof CanonicalType || value instanceof Reference))
        throw new Error("Not the right type for Observation.instantiates[x]: "+value.fhirType());
      this.instantiates = value;
      return this;
    }

    /**
     * @return {@link #basedOn} (A plan, proposal or order that is fulfilled in whole or in part by this event.  For example, a MedicationRequest may require a patient to have laboratory test performed before  it is dispensed.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Observation setBasedOn(List<Reference> theBasedOn) { 
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

    public Observation addBasedOn(Reference t) { //3
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
     * @return {@link #triggeredBy} (Identifies the observation(s) that triggered the performance of this observation.)
     */
    public List<ObservationTriggeredByComponent> getTriggeredBy() { 
      if (this.triggeredBy == null)
        this.triggeredBy = new ArrayList<ObservationTriggeredByComponent>();
      return this.triggeredBy;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Observation setTriggeredBy(List<ObservationTriggeredByComponent> theTriggeredBy) { 
      this.triggeredBy = theTriggeredBy;
      return this;
    }

    public boolean hasTriggeredBy() { 
      if (this.triggeredBy == null)
        return false;
      for (ObservationTriggeredByComponent item : this.triggeredBy)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ObservationTriggeredByComponent addTriggeredBy() { //3
      ObservationTriggeredByComponent t = new ObservationTriggeredByComponent();
      if (this.triggeredBy == null)
        this.triggeredBy = new ArrayList<ObservationTriggeredByComponent>();
      this.triggeredBy.add(t);
      return t;
    }

    public Observation addTriggeredBy(ObservationTriggeredByComponent t) { //3
      if (t == null)
        return this;
      if (this.triggeredBy == null)
        this.triggeredBy = new ArrayList<ObservationTriggeredByComponent>();
      this.triggeredBy.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #triggeredBy}, creating it if it does not already exist {3}
     */
    public ObservationTriggeredByComponent getTriggeredByFirstRep() { 
      if (getTriggeredBy().isEmpty()) {
        addTriggeredBy();
      }
      return getTriggeredBy().get(0);
    }

    /**
     * @return {@link #partOf} (A larger event of which this particular Observation is a component or step.  For example,  an observation as part of a procedure.)
     */
    public List<Reference> getPartOf() { 
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      return this.partOf;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Observation setPartOf(List<Reference> thePartOf) { 
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

    public Observation addPartOf(Reference t) { //3
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
     * @return {@link #status} (The status of the result value.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<ObservationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Observation.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<ObservationStatus>(new ObservationStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of the result value.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Observation setStatusElement(Enumeration<ObservationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the result value.
     */
    public ObservationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the result value.
     */
    public Observation setStatus(ObservationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<ObservationStatus>(new ObservationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #category} (A code that classifies the general type of observation being made.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Observation setCategory(List<CodeableConcept> theCategory) { 
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

    public Observation addCategory(CodeableConcept t) { //3
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
     * @return {@link #code} (Describes what was observed. Sometimes this is called the observation "name".)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Observation.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Describes what was observed. Sometimes this is called the observation "name".)
     */
    public Observation setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #subject} (The patient, or group of patients, location, device, organization, procedure or practitioner this observation is about and into whose or what record the observation is placed. If the actual focus of the observation is different from the subject (or a sample of, part, or region of the subject), the `focus` element or the `code` itself specifies the actual focus of the observation.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Observation.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The patient, or group of patients, location, device, organization, procedure or practitioner this observation is about and into whose or what record the observation is placed. If the actual focus of the observation is different from the subject (or a sample of, part, or region of the subject), the `focus` element or the `code` itself specifies the actual focus of the observation.)
     */
    public Observation setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #focus} (The actual focus of an observation when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, fetus, or donor. For example, fetus observations in a mother's record.  The focus of an observation could also be an existing condition,  an intervention, the subject's diet,  another observation of the subject,  or a body structure such as tumor or implanted device.   An example use case would be using the Observation resource to capture whether the mother is trained to change her child's tracheostomy tube. In this example, the child is the patient of record and the mother is the focus.)
     */
    public List<Reference> getFocus() { 
      if (this.focus == null)
        this.focus = new ArrayList<Reference>();
      return this.focus;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Observation setFocus(List<Reference> theFocus) { 
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

    public Observation addFocus(Reference t) { //3
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
     * @return {@link #encounter} (The healthcare event  (e.g. a patient and healthcare provider interaction) during which this observation is made.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Observation.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The healthcare event  (e.g. a patient and healthcare provider interaction) during which this observation is made.)
     */
    public Observation setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #effective} (The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the "physiologically relevant time". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself.)
     */
    public DataType getEffective() { 
      return this.effective;
    }

    /**
     * @return {@link #effective} (The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the "physiologically relevant time". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself.)
     */
    public DateTimeType getEffectiveDateTimeType() throws FHIRException { 
      if (this.effective == null)
        this.effective = new DateTimeType();
      if (!(this.effective instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.effective.getClass().getName()+" was encountered");
      return (DateTimeType) this.effective;
    }

    public boolean hasEffectiveDateTimeType() { 
      return this != null && this.effective instanceof DateTimeType;
    }

    /**
     * @return {@link #effective} (The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the "physiologically relevant time". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself.)
     */
    public Period getEffectivePeriod() throws FHIRException { 
      if (this.effective == null)
        this.effective = new Period();
      if (!(this.effective instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.effective.getClass().getName()+" was encountered");
      return (Period) this.effective;
    }

    public boolean hasEffectivePeriod() { 
      return this != null && this.effective instanceof Period;
    }

    /**
     * @return {@link #effective} (The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the "physiologically relevant time". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself.)
     */
    public Timing getEffectiveTiming() throws FHIRException { 
      if (this.effective == null)
        this.effective = new Timing();
      if (!(this.effective instanceof Timing))
        throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.effective.getClass().getName()+" was encountered");
      return (Timing) this.effective;
    }

    public boolean hasEffectiveTiming() { 
      return this != null && this.effective instanceof Timing;
    }

    /**
     * @return {@link #effective} (The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the "physiologically relevant time". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself.)
     */
    public InstantType getEffectiveInstantType() throws FHIRException { 
      if (this.effective == null)
        this.effective = new InstantType();
      if (!(this.effective instanceof InstantType))
        throw new FHIRException("Type mismatch: the type InstantType was expected, but "+this.effective.getClass().getName()+" was encountered");
      return (InstantType) this.effective;
    }

    public boolean hasEffectiveInstantType() { 
      return this != null && this.effective instanceof InstantType;
    }

    public boolean hasEffective() { 
      return this.effective != null && !this.effective.isEmpty();
    }

    /**
     * @param value {@link #effective} (The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the "physiologically relevant time". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself.)
     */
    public Observation setEffective(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period || value instanceof Timing || value instanceof InstantType))
        throw new Error("Not the right type for Observation.effective[x]: "+value.fhirType());
      this.effective = value;
      return this;
    }

    /**
     * @return {@link #issued} (The date and time this version of the observation was made available to providers, typically after the results have been reviewed and verified.). This is the underlying object with id, value and extensions. The accessor "getIssued" gives direct access to the value
     */
    public InstantType getIssuedElement() { 
      if (this.issued == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Observation.issued");
        else if (Configuration.doAutoCreate())
          this.issued = new InstantType(); // bb
      return this.issued;
    }

    public boolean hasIssuedElement() { 
      return this.issued != null && !this.issued.isEmpty();
    }

    public boolean hasIssued() { 
      return this.issued != null && !this.issued.isEmpty();
    }

    /**
     * @param value {@link #issued} (The date and time this version of the observation was made available to providers, typically after the results have been reviewed and verified.). This is the underlying object with id, value and extensions. The accessor "getIssued" gives direct access to the value
     */
    public Observation setIssuedElement(InstantType value) { 
      this.issued = value;
      return this;
    }

    /**
     * @return The date and time this version of the observation was made available to providers, typically after the results have been reviewed and verified.
     */
    public Date getIssued() { 
      return this.issued == null ? null : this.issued.getValue();
    }

    /**
     * @param value The date and time this version of the observation was made available to providers, typically after the results have been reviewed and verified.
     */
    public Observation setIssued(Date value) { 
      if (value == null)
        this.issued = null;
      else {
        if (this.issued == null)
          this.issued = new InstantType();
        this.issued.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #performer} (Who was responsible for asserting the observed value as "true".)
     */
    public List<Reference> getPerformer() { 
      if (this.performer == null)
        this.performer = new ArrayList<Reference>();
      return this.performer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Observation setPerformer(List<Reference> thePerformer) { 
      this.performer = thePerformer;
      return this;
    }

    public boolean hasPerformer() { 
      if (this.performer == null)
        return false;
      for (Reference item : this.performer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPerformer() { //3
      Reference t = new Reference();
      if (this.performer == null)
        this.performer = new ArrayList<Reference>();
      this.performer.add(t);
      return t;
    }

    public Observation addPerformer(Reference t) { //3
      if (t == null)
        return this;
      if (this.performer == null)
        this.performer = new ArrayList<Reference>();
      this.performer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist {3}
     */
    public Reference getPerformerFirstRep() { 
      if (getPerformer().isEmpty()) {
        addPerformer();
      }
      return getPerformer().get(0);
    }

    /**
     * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
     */
    public DataType getValue() { 
      return this.value;
    }

    /**
     * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
     */
    public Quantity getValueQuantity() throws FHIRException { 
      if (this.value == null)
        this.value = new Quantity();
      if (!(this.value instanceof Quantity))
        throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
      return (Quantity) this.value;
    }

    public boolean hasValueQuantity() { 
      return this != null && this.value instanceof Quantity;
    }

    /**
     * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
     */
    public CodeableConcept getValueCodeableConcept() throws FHIRException { 
      if (this.value == null)
        this.value = new CodeableConcept();
      if (!(this.value instanceof CodeableConcept))
        throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.value.getClass().getName()+" was encountered");
      return (CodeableConcept) this.value;
    }

    public boolean hasValueCodeableConcept() { 
      return this != null && this.value instanceof CodeableConcept;
    }

    /**
     * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
     */
    public StringType getValueStringType() throws FHIRException { 
      if (this.value == null)
        this.value = new StringType();
      if (!(this.value instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.value.getClass().getName()+" was encountered");
      return (StringType) this.value;
    }

    public boolean hasValueStringType() { 
      return this != null && this.value instanceof StringType;
    }

    /**
     * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
     */
    public BooleanType getValueBooleanType() throws FHIRException { 
      if (this.value == null)
        this.value = new BooleanType();
      if (!(this.value instanceof BooleanType))
        throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.value.getClass().getName()+" was encountered");
      return (BooleanType) this.value;
    }

    public boolean hasValueBooleanType() { 
      return this != null && this.value instanceof BooleanType;
    }

    /**
     * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
     */
    public IntegerType getValueIntegerType() throws FHIRException { 
      if (this.value == null)
        this.value = new IntegerType();
      if (!(this.value instanceof IntegerType))
        throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.value.getClass().getName()+" was encountered");
      return (IntegerType) this.value;
    }

    public boolean hasValueIntegerType() { 
      return this != null && this.value instanceof IntegerType;
    }

    /**
     * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
     */
    public Range getValueRange() throws FHIRException { 
      if (this.value == null)
        this.value = new Range();
      if (!(this.value instanceof Range))
        throw new FHIRException("Type mismatch: the type Range was expected, but "+this.value.getClass().getName()+" was encountered");
      return (Range) this.value;
    }

    public boolean hasValueRange() { 
      return this != null && this.value instanceof Range;
    }

    /**
     * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
     */
    public Ratio getValueRatio() throws FHIRException { 
      if (this.value == null)
        this.value = new Ratio();
      if (!(this.value instanceof Ratio))
        throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.value.getClass().getName()+" was encountered");
      return (Ratio) this.value;
    }

    public boolean hasValueRatio() { 
      return this != null && this.value instanceof Ratio;
    }

    /**
     * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
     */
    public SampledData getValueSampledData() throws FHIRException { 
      if (this.value == null)
        this.value = new SampledData();
      if (!(this.value instanceof SampledData))
        throw new FHIRException("Type mismatch: the type SampledData was expected, but "+this.value.getClass().getName()+" was encountered");
      return (SampledData) this.value;
    }

    public boolean hasValueSampledData() { 
      return this != null && this.value instanceof SampledData;
    }

    /**
     * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
     */
    public TimeType getValueTimeType() throws FHIRException { 
      if (this.value == null)
        this.value = new TimeType();
      if (!(this.value instanceof TimeType))
        throw new FHIRException("Type mismatch: the type TimeType was expected, but "+this.value.getClass().getName()+" was encountered");
      return (TimeType) this.value;
    }

    public boolean hasValueTimeType() { 
      return this != null && this.value instanceof TimeType;
    }

    /**
     * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
     */
    public DateTimeType getValueDateTimeType() throws FHIRException { 
      if (this.value == null)
        this.value = new DateTimeType();
      if (!(this.value instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.value.getClass().getName()+" was encountered");
      return (DateTimeType) this.value;
    }

    public boolean hasValueDateTimeType() { 
      return this != null && this.value instanceof DateTimeType;
    }

    /**
     * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
     */
    public Period getValuePeriod() throws FHIRException { 
      if (this.value == null)
        this.value = new Period();
      if (!(this.value instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.value.getClass().getName()+" was encountered");
      return (Period) this.value;
    }

    public boolean hasValuePeriod() { 
      return this != null && this.value instanceof Period;
    }

    /**
     * @return {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
     */
    public Attachment getValueAttachment() throws FHIRException { 
      if (this.value == null)
        this.value = new Attachment();
      if (!(this.value instanceof Attachment))
        throw new FHIRException("Type mismatch: the type Attachment was expected, but "+this.value.getClass().getName()+" was encountered");
      return (Attachment) this.value;
    }

    public boolean hasValueAttachment() { 
      return this != null && this.value instanceof Attachment;
    }

    public boolean hasValue() { 
      return this.value != null && !this.value.isEmpty();
    }

    /**
     * @param value {@link #value} (The information determined as a result of making the observation, if the information has a simple value.)
     */
    public Observation setValue(DataType value) { 
      if (value != null && !(value instanceof Quantity || value instanceof CodeableConcept || value instanceof StringType || value instanceof BooleanType || value instanceof IntegerType || value instanceof Range || value instanceof Ratio || value instanceof SampledData || value instanceof TimeType || value instanceof DateTimeType || value instanceof Period || value instanceof Attachment))
        throw new Error("Not the right type for Observation.value[x]: "+value.fhirType());
      this.value = value;
      return this;
    }

    /**
     * @return {@link #dataAbsentReason} (Provides a reason why the expected value in the element Observation.value[x] is missing.)
     */
    public CodeableConcept getDataAbsentReason() { 
      if (this.dataAbsentReason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Observation.dataAbsentReason");
        else if (Configuration.doAutoCreate())
          this.dataAbsentReason = new CodeableConcept(); // cc
      return this.dataAbsentReason;
    }

    public boolean hasDataAbsentReason() { 
      return this.dataAbsentReason != null && !this.dataAbsentReason.isEmpty();
    }

    /**
     * @param value {@link #dataAbsentReason} (Provides a reason why the expected value in the element Observation.value[x] is missing.)
     */
    public Observation setDataAbsentReason(CodeableConcept value) { 
      this.dataAbsentReason = value;
      return this;
    }

    /**
     * @return {@link #interpretation} (A categorical assessment of an observation value.  For example, high, low, normal.)
     */
    public List<CodeableConcept> getInterpretation() { 
      if (this.interpretation == null)
        this.interpretation = new ArrayList<CodeableConcept>();
      return this.interpretation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Observation setInterpretation(List<CodeableConcept> theInterpretation) { 
      this.interpretation = theInterpretation;
      return this;
    }

    public boolean hasInterpretation() { 
      if (this.interpretation == null)
        return false;
      for (CodeableConcept item : this.interpretation)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addInterpretation() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.interpretation == null)
        this.interpretation = new ArrayList<CodeableConcept>();
      this.interpretation.add(t);
      return t;
    }

    public Observation addInterpretation(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.interpretation == null)
        this.interpretation = new ArrayList<CodeableConcept>();
      this.interpretation.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #interpretation}, creating it if it does not already exist {3}
     */
    public CodeableConcept getInterpretationFirstRep() { 
      if (getInterpretation().isEmpty()) {
        addInterpretation();
      }
      return getInterpretation().get(0);
    }

    /**
     * @return {@link #note} (Comments about the observation or the results.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Observation setNote(List<Annotation> theNote) { 
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

    public Observation addNote(Annotation t) { //3
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
     * @return {@link #bodySite} (Indicates the site on the subject's body where the observation was made (i.e. the target site).)
     */
    public CodeableConcept getBodySite() { 
      if (this.bodySite == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Observation.bodySite");
        else if (Configuration.doAutoCreate())
          this.bodySite = new CodeableConcept(); // cc
      return this.bodySite;
    }

    public boolean hasBodySite() { 
      return this.bodySite != null && !this.bodySite.isEmpty();
    }

    /**
     * @param value {@link #bodySite} (Indicates the site on the subject's body where the observation was made (i.e. the target site).)
     */
    public Observation setBodySite(CodeableConcept value) { 
      this.bodySite = value;
      return this;
    }

    /**
     * @return {@link #bodyStructure} (Indicates the body structure on the subject's body where the observation was made (i.e. the target site).)
     */
    public Reference getBodyStructure() { 
      if (this.bodyStructure == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Observation.bodyStructure");
        else if (Configuration.doAutoCreate())
          this.bodyStructure = new Reference(); // cc
      return this.bodyStructure;
    }

    public boolean hasBodyStructure() { 
      return this.bodyStructure != null && !this.bodyStructure.isEmpty();
    }

    /**
     * @param value {@link #bodyStructure} (Indicates the body structure on the subject's body where the observation was made (i.e. the target site).)
     */
    public Observation setBodyStructure(Reference value) { 
      this.bodyStructure = value;
      return this;
    }

    /**
     * @return {@link #method} (Indicates the mechanism used to perform the observation.)
     */
    public CodeableConcept getMethod() { 
      if (this.method == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Observation.method");
        else if (Configuration.doAutoCreate())
          this.method = new CodeableConcept(); // cc
      return this.method;
    }

    public boolean hasMethod() { 
      return this.method != null && !this.method.isEmpty();
    }

    /**
     * @param value {@link #method} (Indicates the mechanism used to perform the observation.)
     */
    public Observation setMethod(CodeableConcept value) { 
      this.method = value;
      return this;
    }

    /**
     * @return {@link #specimen} (The specimen that was used when this observation was made.)
     */
    public Reference getSpecimen() { 
      if (this.specimen == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Observation.specimen");
        else if (Configuration.doAutoCreate())
          this.specimen = new Reference(); // cc
      return this.specimen;
    }

    public boolean hasSpecimen() { 
      return this.specimen != null && !this.specimen.isEmpty();
    }

    /**
     * @param value {@link #specimen} (The specimen that was used when this observation was made.)
     */
    public Observation setSpecimen(Reference value) { 
      this.specimen = value;
      return this;
    }

    /**
     * @return {@link #device} (The device used to generate the observation data.)
     */
    public Reference getDevice() { 
      if (this.device == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Observation.device");
        else if (Configuration.doAutoCreate())
          this.device = new Reference(); // cc
      return this.device;
    }

    public boolean hasDevice() { 
      return this.device != null && !this.device.isEmpty();
    }

    /**
     * @param value {@link #device} (The device used to generate the observation data.)
     */
    public Observation setDevice(Reference value) { 
      this.device = value;
      return this;
    }

    /**
     * @return {@link #referenceRange} (Guidance on how to interpret the value by comparison to a normal or recommended range.  Multiple reference ranges are interpreted as an "OR".   In other words, to represent two distinct target populations, two `referenceRange` elements would be used.)
     */
    public List<ObservationReferenceRangeComponent> getReferenceRange() { 
      if (this.referenceRange == null)
        this.referenceRange = new ArrayList<ObservationReferenceRangeComponent>();
      return this.referenceRange;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Observation setReferenceRange(List<ObservationReferenceRangeComponent> theReferenceRange) { 
      this.referenceRange = theReferenceRange;
      return this;
    }

    public boolean hasReferenceRange() { 
      if (this.referenceRange == null)
        return false;
      for (ObservationReferenceRangeComponent item : this.referenceRange)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ObservationReferenceRangeComponent addReferenceRange() { //3
      ObservationReferenceRangeComponent t = new ObservationReferenceRangeComponent();
      if (this.referenceRange == null)
        this.referenceRange = new ArrayList<ObservationReferenceRangeComponent>();
      this.referenceRange.add(t);
      return t;
    }

    public Observation addReferenceRange(ObservationReferenceRangeComponent t) { //3
      if (t == null)
        return this;
      if (this.referenceRange == null)
        this.referenceRange = new ArrayList<ObservationReferenceRangeComponent>();
      this.referenceRange.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #referenceRange}, creating it if it does not already exist {3}
     */
    public ObservationReferenceRangeComponent getReferenceRangeFirstRep() { 
      if (getReferenceRange().isEmpty()) {
        addReferenceRange();
      }
      return getReferenceRange().get(0);
    }

    /**
     * @return {@link #hasMember} (This observation is a group observation (e.g. a battery, a panel of tests, a set of vital sign measurements) that includes the target as a member of the group.)
     */
    public List<Reference> getHasMember() { 
      if (this.hasMember == null)
        this.hasMember = new ArrayList<Reference>();
      return this.hasMember;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Observation setHasMember(List<Reference> theHasMember) { 
      this.hasMember = theHasMember;
      return this;
    }

    public boolean hasHasMember() { 
      if (this.hasMember == null)
        return false;
      for (Reference item : this.hasMember)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addHasMember() { //3
      Reference t = new Reference();
      if (this.hasMember == null)
        this.hasMember = new ArrayList<Reference>();
      this.hasMember.add(t);
      return t;
    }

    public Observation addHasMember(Reference t) { //3
      if (t == null)
        return this;
      if (this.hasMember == null)
        this.hasMember = new ArrayList<Reference>();
      this.hasMember.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #hasMember}, creating it if it does not already exist {3}
     */
    public Reference getHasMemberFirstRep() { 
      if (getHasMember().isEmpty()) {
        addHasMember();
      }
      return getHasMember().get(0);
    }

    /**
     * @return {@link #derivedFrom} (The target resource that represents a measurement from which this observation value is derived. For example, a calculated anion gap or a fetal measurement based on an ultrasound image.)
     */
    public List<Reference> getDerivedFrom() { 
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<Reference>();
      return this.derivedFrom;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Observation setDerivedFrom(List<Reference> theDerivedFrom) { 
      this.derivedFrom = theDerivedFrom;
      return this;
    }

    public boolean hasDerivedFrom() { 
      if (this.derivedFrom == null)
        return false;
      for (Reference item : this.derivedFrom)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addDerivedFrom() { //3
      Reference t = new Reference();
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<Reference>();
      this.derivedFrom.add(t);
      return t;
    }

    public Observation addDerivedFrom(Reference t) { //3
      if (t == null)
        return this;
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<Reference>();
      this.derivedFrom.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #derivedFrom}, creating it if it does not already exist {3}
     */
    public Reference getDerivedFromFirstRep() { 
      if (getDerivedFrom().isEmpty()) {
        addDerivedFrom();
      }
      return getDerivedFrom().get(0);
    }

    /**
     * @return {@link #component} (Some observations have multiple component observations.  These component observations are expressed as separate code value pairs that share the same attributes.  Examples include systolic and diastolic component observations for blood pressure measurement and multiple component observations for genetics observations.)
     */
    public List<ObservationComponentComponent> getComponent() { 
      if (this.component == null)
        this.component = new ArrayList<ObservationComponentComponent>();
      return this.component;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Observation setComponent(List<ObservationComponentComponent> theComponent) { 
      this.component = theComponent;
      return this;
    }

    public boolean hasComponent() { 
      if (this.component == null)
        return false;
      for (ObservationComponentComponent item : this.component)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ObservationComponentComponent addComponent() { //3
      ObservationComponentComponent t = new ObservationComponentComponent();
      if (this.component == null)
        this.component = new ArrayList<ObservationComponentComponent>();
      this.component.add(t);
      return t;
    }

    public Observation addComponent(ObservationComponentComponent t) { //3
      if (t == null)
        return this;
      if (this.component == null)
        this.component = new ArrayList<ObservationComponentComponent>();
      this.component.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #component}, creating it if it does not already exist {3}
     */
    public ObservationComponentComponent getComponentFirstRep() { 
      if (getComponent().isEmpty()) {
        addComponent();
      }
      return getComponent().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A unique identifier assigned to this observation.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("instantiates[x]", "canonical(ObservationDefinition)|Reference(ObservationDefinition)", "The reference to a FHIR ObservationDefinition resource that provides the definition that is adhered to in whole or in part by this Observation instance.", 0, 1, instantiates));
        children.add(new Property("basedOn", "Reference(CarePlan|DeviceRequest|ImmunizationRecommendation|MedicationRequest|NutritionOrder|ServiceRequest)", "A plan, proposal or order that is fulfilled in whole or in part by this event.  For example, a MedicationRequest may require a patient to have laboratory test performed before  it is dispensed.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("triggeredBy", "", "Identifies the observation(s) that triggered the performance of this observation.", 0, java.lang.Integer.MAX_VALUE, triggeredBy));
        children.add(new Property("partOf", "Reference(MedicationAdministration|MedicationDispense|MedicationUsage|Procedure|Immunization|ImagingStudy)", "A larger event of which this particular Observation is a component or step.  For example,  an observation as part of a procedure.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("status", "code", "The status of the result value.", 0, 1, status));
        children.add(new Property("category", "CodeableConcept", "A code that classifies the general type of observation being made.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("code", "CodeableConcept", "Describes what was observed. Sometimes this is called the observation \"name\".", 0, 1, code));
        children.add(new Property("subject", "Reference(Patient|Group|Device|Location|Organization|Procedure|Practitioner|Medication|Substance|BiologicallyDerivedProduct|NutritionProduct)", "The patient, or group of patients, location, device, organization, procedure or practitioner this observation is about and into whose or what record the observation is placed. If the actual focus of the observation is different from the subject (or a sample of, part, or region of the subject), the `focus` element or the `code` itself specifies the actual focus of the observation.", 0, 1, subject));
        children.add(new Property("focus", "Reference(Any)", "The actual focus of an observation when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, fetus, or donor. For example, fetus observations in a mother's record.  The focus of an observation could also be an existing condition,  an intervention, the subject's diet,  another observation of the subject,  or a body structure such as tumor or implanted device.   An example use case would be using the Observation resource to capture whether the mother is trained to change her child's tracheostomy tube. In this example, the child is the patient of record and the mother is the focus.", 0, java.lang.Integer.MAX_VALUE, focus));
        children.add(new Property("encounter", "Reference(Encounter)", "The healthcare event  (e.g. a patient and healthcare provider interaction) during which this observation is made.", 0, 1, encounter));
        children.add(new Property("effective[x]", "dateTime|Period|Timing|instant", "The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the \"physiologically relevant time\". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself.", 0, 1, effective));
        children.add(new Property("issued", "instant", "The date and time this version of the observation was made available to providers, typically after the results have been reviewed and verified.", 0, 1, issued));
        children.add(new Property("performer", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|RelatedPerson)", "Who was responsible for asserting the observed value as \"true\".", 0, java.lang.Integer.MAX_VALUE, performer));
        children.add(new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Ratio|SampledData|time|dateTime|Period|Attachment", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value));
        children.add(new Property("dataAbsentReason", "CodeableConcept", "Provides a reason why the expected value in the element Observation.value[x] is missing.", 0, 1, dataAbsentReason));
        children.add(new Property("interpretation", "CodeableConcept", "A categorical assessment of an observation value.  For example, high, low, normal.", 0, java.lang.Integer.MAX_VALUE, interpretation));
        children.add(new Property("note", "Annotation", "Comments about the observation or the results.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("bodySite", "CodeableConcept", "Indicates the site on the subject's body where the observation was made (i.e. the target site).", 0, 1, bodySite));
        children.add(new Property("bodyStructure", "Reference(BodyStructure)", "Indicates the body structure on the subject's body where the observation was made (i.e. the target site).", 0, 1, bodyStructure));
        children.add(new Property("method", "CodeableConcept", "Indicates the mechanism used to perform the observation.", 0, 1, method));
        children.add(new Property("specimen", "Reference(Specimen)", "The specimen that was used when this observation was made.", 0, 1, specimen));
        children.add(new Property("device", "Reference(Device|DeviceMetric)", "The device used to generate the observation data.", 0, 1, device));
        children.add(new Property("referenceRange", "", "Guidance on how to interpret the value by comparison to a normal or recommended range.  Multiple reference ranges are interpreted as an \"OR\".   In other words, to represent two distinct target populations, two `referenceRange` elements would be used.", 0, java.lang.Integer.MAX_VALUE, referenceRange));
        children.add(new Property("hasMember", "Reference(Observation|QuestionnaireResponse|MolecularSequence)", "This observation is a group observation (e.g. a battery, a panel of tests, a set of vital sign measurements) that includes the target as a member of the group.", 0, java.lang.Integer.MAX_VALUE, hasMember));
        children.add(new Property("derivedFrom", "Reference(DocumentReference|ImagingStudy|ImagingSelection|QuestionnaireResponse|Observation|MolecularSequence)", "The target resource that represents a measurement from which this observation value is derived. For example, a calculated anion gap or a fetal measurement based on an ultrasound image.", 0, java.lang.Integer.MAX_VALUE, derivedFrom));
        children.add(new Property("component", "", "Some observations have multiple component observations.  These component observations are expressed as separate code value pairs that share the same attributes.  Examples include systolic and diastolic component observations for blood pressure measurement and multiple component observations for genetics observations.", 0, java.lang.Integer.MAX_VALUE, component));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A unique identifier assigned to this observation.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1926387433: /*instantiates[x]*/  return new Property("instantiates[x]", "canonical(ObservationDefinition)|Reference(ObservationDefinition)", "The reference to a FHIR ObservationDefinition resource that provides the definition that is adhered to in whole or in part by this Observation instance.", 0, 1, instantiates);
        case -246883639: /*instantiates*/  return new Property("instantiates[x]", "canonical(ObservationDefinition)|Reference(ObservationDefinition)", "The reference to a FHIR ObservationDefinition resource that provides the definition that is adhered to in whole or in part by this Observation instance.", 0, 1, instantiates);
        case 8911915: /*instantiatesCanonical*/  return new Property("instantiates[x]", "canonical(ObservationDefinition)", "The reference to a FHIR ObservationDefinition resource that provides the definition that is adhered to in whole or in part by this Observation instance.", 0, 1, instantiates);
        case -1744595326: /*instantiatesReference*/  return new Property("instantiates[x]", "Reference(ObservationDefinition)", "The reference to a FHIR ObservationDefinition resource that provides the definition that is adhered to in whole or in part by this Observation instance.", 0, 1, instantiates);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|DeviceRequest|ImmunizationRecommendation|MedicationRequest|NutritionOrder|ServiceRequest)", "A plan, proposal or order that is fulfilled in whole or in part by this event.  For example, a MedicationRequest may require a patient to have laboratory test performed before  it is dispensed.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -680451314: /*triggeredBy*/  return new Property("triggeredBy", "", "Identifies the observation(s) that triggered the performance of this observation.", 0, java.lang.Integer.MAX_VALUE, triggeredBy);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(MedicationAdministration|MedicationDispense|MedicationUsage|Procedure|Immunization|ImagingStudy)", "A larger event of which this particular Observation is a component or step.  For example,  an observation as part of a procedure.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the result value.", 0, 1, status);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A code that classifies the general type of observation being made.", 0, java.lang.Integer.MAX_VALUE, category);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Describes what was observed. Sometimes this is called the observation \"name\".", 0, 1, code);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Device|Location|Organization|Procedure|Practitioner|Medication|Substance|BiologicallyDerivedProduct|NutritionProduct)", "The patient, or group of patients, location, device, organization, procedure or practitioner this observation is about and into whose or what record the observation is placed. If the actual focus of the observation is different from the subject (or a sample of, part, or region of the subject), the `focus` element or the `code` itself specifies the actual focus of the observation.", 0, 1, subject);
        case 97604824: /*focus*/  return new Property("focus", "Reference(Any)", "The actual focus of an observation when it is not the patient of record representing something or someone associated with the patient such as a spouse, parent, fetus, or donor. For example, fetus observations in a mother's record.  The focus of an observation could also be an existing condition,  an intervention, the subject's diet,  another observation of the subject,  or a body structure such as tumor or implanted device.   An example use case would be using the Observation resource to capture whether the mother is trained to change her child's tracheostomy tube. In this example, the child is the patient of record and the mother is the focus.", 0, java.lang.Integer.MAX_VALUE, focus);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The healthcare event  (e.g. a patient and healthcare provider interaction) during which this observation is made.", 0, 1, encounter);
        case 247104889: /*effective[x]*/  return new Property("effective[x]", "dateTime|Period|Timing|instant", "The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the \"physiologically relevant time\". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself.", 0, 1, effective);
        case -1468651097: /*effective*/  return new Property("effective[x]", "dateTime|Period|Timing|instant", "The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the \"physiologically relevant time\". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself.", 0, 1, effective);
        case -275306910: /*effectiveDateTime*/  return new Property("effective[x]", "dateTime", "The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the \"physiologically relevant time\". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself.", 0, 1, effective);
        case -403934648: /*effectivePeriod*/  return new Property("effective[x]", "Period", "The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the \"physiologically relevant time\". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself.", 0, 1, effective);
        case -285872943: /*effectiveTiming*/  return new Property("effective[x]", "Timing", "The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the \"physiologically relevant time\". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself.", 0, 1, effective);
        case -1295730118: /*effectiveInstant*/  return new Property("effective[x]", "instant", "The time or time-period the observed value is asserted as being true. For biological subjects - e.g. human patients - this is usually called the \"physiologically relevant time\". This is usually either the time of the procedure or of specimen collection, but very often the source of the date/time is not known, only the date/time itself.", 0, 1, effective);
        case -1179159893: /*issued*/  return new Property("issued", "instant", "The date and time this version of the observation was made available to providers, typically after the results have been reviewed and verified.", 0, 1, issued);
        case 481140686: /*performer*/  return new Property("performer", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|RelatedPerson)", "Who was responsible for asserting the observed value as \"true\".", 0, java.lang.Integer.MAX_VALUE, performer);
        case -1410166417: /*value[x]*/  return new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Ratio|SampledData|time|dateTime|Period|Attachment", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
        case 111972721: /*value*/  return new Property("value[x]", "Quantity|CodeableConcept|string|boolean|integer|Range|Ratio|SampledData|time|dateTime|Period|Attachment", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
        case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
        case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
        case -1424603934: /*valueString*/  return new Property("value[x]", "string", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
        case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
        case -1668204915: /*valueInteger*/  return new Property("value[x]", "integer", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
        case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
        case 2030767386: /*valueRatio*/  return new Property("value[x]", "Ratio", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
        case -962229101: /*valueSampledData*/  return new Property("value[x]", "SampledData", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
        case -765708322: /*valueTime*/  return new Property("value[x]", "time", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
        case 1047929900: /*valueDateTime*/  return new Property("value[x]", "dateTime", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
        case -1524344174: /*valuePeriod*/  return new Property("value[x]", "Period", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
        case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "The information determined as a result of making the observation, if the information has a simple value.", 0, 1, value);
        case 1034315687: /*dataAbsentReason*/  return new Property("dataAbsentReason", "CodeableConcept", "Provides a reason why the expected value in the element Observation.value[x] is missing.", 0, 1, dataAbsentReason);
        case -297950712: /*interpretation*/  return new Property("interpretation", "CodeableConcept", "A categorical assessment of an observation value.  For example, high, low, normal.", 0, java.lang.Integer.MAX_VALUE, interpretation);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Comments about the observation or the results.", 0, java.lang.Integer.MAX_VALUE, note);
        case 1702620169: /*bodySite*/  return new Property("bodySite", "CodeableConcept", "Indicates the site on the subject's body where the observation was made (i.e. the target site).", 0, 1, bodySite);
        case -1001731599: /*bodyStructure*/  return new Property("bodyStructure", "Reference(BodyStructure)", "Indicates the body structure on the subject's body where the observation was made (i.e. the target site).", 0, 1, bodyStructure);
        case -1077554975: /*method*/  return new Property("method", "CodeableConcept", "Indicates the mechanism used to perform the observation.", 0, 1, method);
        case -2132868344: /*specimen*/  return new Property("specimen", "Reference(Specimen)", "The specimen that was used when this observation was made.", 0, 1, specimen);
        case -1335157162: /*device*/  return new Property("device", "Reference(Device|DeviceMetric)", "The device used to generate the observation data.", 0, 1, device);
        case -1912545102: /*referenceRange*/  return new Property("referenceRange", "", "Guidance on how to interpret the value by comparison to a normal or recommended range.  Multiple reference ranges are interpreted as an \"OR\".   In other words, to represent two distinct target populations, two `referenceRange` elements would be used.", 0, java.lang.Integer.MAX_VALUE, referenceRange);
        case -458019372: /*hasMember*/  return new Property("hasMember", "Reference(Observation|QuestionnaireResponse|MolecularSequence)", "This observation is a group observation (e.g. a battery, a panel of tests, a set of vital sign measurements) that includes the target as a member of the group.", 0, java.lang.Integer.MAX_VALUE, hasMember);
        case 1077922663: /*derivedFrom*/  return new Property("derivedFrom", "Reference(DocumentReference|ImagingStudy|ImagingSelection|QuestionnaireResponse|Observation|MolecularSequence)", "The target resource that represents a measurement from which this observation value is derived. For example, a calculated anion gap or a fetal measurement based on an ultrasound image.", 0, java.lang.Integer.MAX_VALUE, derivedFrom);
        case -1399907075: /*component*/  return new Property("component", "", "Some observations have multiple component observations.  These component observations are expressed as separate code value pairs that share the same attributes.  Examples include systolic and diastolic component observations for blood pressure measurement and multiple component observations for genetics observations.", 0, java.lang.Integer.MAX_VALUE, component);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -246883639: /*instantiates*/ return this.instantiates == null ? new Base[0] : new Base[] {this.instantiates}; // DataType
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -680451314: /*triggeredBy*/ return this.triggeredBy == null ? new Base[0] : this.triggeredBy.toArray(new Base[this.triggeredBy.size()]); // ObservationTriggeredByComponent
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<ObservationStatus>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 97604824: /*focus*/ return this.focus == null ? new Base[0] : this.focus.toArray(new Base[this.focus.size()]); // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -1468651097: /*effective*/ return this.effective == null ? new Base[0] : new Base[] {this.effective}; // DataType
        case -1179159893: /*issued*/ return this.issued == null ? new Base[0] : new Base[] {this.issued}; // InstantType
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : this.performer.toArray(new Base[this.performer.size()]); // Reference
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        case 1034315687: /*dataAbsentReason*/ return this.dataAbsentReason == null ? new Base[0] : new Base[] {this.dataAbsentReason}; // CodeableConcept
        case -297950712: /*interpretation*/ return this.interpretation == null ? new Base[0] : this.interpretation.toArray(new Base[this.interpretation.size()]); // CodeableConcept
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 1702620169: /*bodySite*/ return this.bodySite == null ? new Base[0] : new Base[] {this.bodySite}; // CodeableConcept
        case -1001731599: /*bodyStructure*/ return this.bodyStructure == null ? new Base[0] : new Base[] {this.bodyStructure}; // Reference
        case -1077554975: /*method*/ return this.method == null ? new Base[0] : new Base[] {this.method}; // CodeableConcept
        case -2132868344: /*specimen*/ return this.specimen == null ? new Base[0] : new Base[] {this.specimen}; // Reference
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : new Base[] {this.device}; // Reference
        case -1912545102: /*referenceRange*/ return this.referenceRange == null ? new Base[0] : this.referenceRange.toArray(new Base[this.referenceRange.size()]); // ObservationReferenceRangeComponent
        case -458019372: /*hasMember*/ return this.hasMember == null ? new Base[0] : this.hasMember.toArray(new Base[this.hasMember.size()]); // Reference
        case 1077922663: /*derivedFrom*/ return this.derivedFrom == null ? new Base[0] : this.derivedFrom.toArray(new Base[this.derivedFrom.size()]); // Reference
        case -1399907075: /*component*/ return this.component == null ? new Base[0] : this.component.toArray(new Base[this.component.size()]); // ObservationComponentComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -246883639: // instantiates
          this.instantiates = TypeConvertor.castToType(value); // DataType
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -680451314: // triggeredBy
          this.getTriggeredBy().add((ObservationTriggeredByComponent) value); // ObservationTriggeredByComponent
          return value;
        case -995410646: // partOf
          this.getPartOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          value = new ObservationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ObservationStatus>
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
        case 97604824: // focus
          this.getFocus().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1468651097: // effective
          this.effective = TypeConvertor.castToType(value); // DataType
          return value;
        case -1179159893: // issued
          this.issued = TypeConvertor.castToInstant(value); // InstantType
          return value;
        case 481140686: // performer
          this.getPerformer().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        case 1034315687: // dataAbsentReason
          this.dataAbsentReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -297950712: // interpretation
          this.getInterpretation().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 1702620169: // bodySite
          this.bodySite = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1001731599: // bodyStructure
          this.bodyStructure = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1077554975: // method
          this.method = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -2132868344: // specimen
          this.specimen = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1335157162: // device
          this.device = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1912545102: // referenceRange
          this.getReferenceRange().add((ObservationReferenceRangeComponent) value); // ObservationReferenceRangeComponent
          return value;
        case -458019372: // hasMember
          this.getHasMember().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1077922663: // derivedFrom
          this.getDerivedFrom().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1399907075: // component
          this.getComponent().add((ObservationComponentComponent) value); // ObservationComponentComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("instantiates[x]")) {
          this.instantiates = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("triggeredBy")) {
          this.getTriggeredBy().add((ObservationTriggeredByComponent) value);
        } else if (name.equals("partOf")) {
          this.getPartOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          value = new ObservationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ObservationStatus>
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("focus")) {
          this.getFocus().add(TypeConvertor.castToReference(value));
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("effective[x]")) {
          this.effective = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("issued")) {
          this.issued = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("performer")) {
          this.getPerformer().add(TypeConvertor.castToReference(value));
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("dataAbsentReason")) {
          this.dataAbsentReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("interpretation")) {
          this.getInterpretation().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("bodySite")) {
          this.bodySite = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("bodyStructure")) {
          this.bodyStructure = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("method")) {
          this.method = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("specimen")) {
          this.specimen = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("device")) {
          this.device = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("referenceRange")) {
          this.getReferenceRange().add((ObservationReferenceRangeComponent) value);
        } else if (name.equals("hasMember")) {
          this.getHasMember().add(TypeConvertor.castToReference(value));
        } else if (name.equals("derivedFrom")) {
          this.getDerivedFrom().add(TypeConvertor.castToReference(value));
        } else if (name.equals("component")) {
          this.getComponent().add((ObservationComponentComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1926387433:  return getInstantiates();
        case -246883639:  return getInstantiates();
        case -332612366:  return addBasedOn(); 
        case -680451314:  return addTriggeredBy(); 
        case -995410646:  return addPartOf(); 
        case -892481550:  return getStatusElement();
        case 50511102:  return addCategory(); 
        case 3059181:  return getCode();
        case -1867885268:  return getSubject();
        case 97604824:  return addFocus(); 
        case 1524132147:  return getEncounter();
        case 247104889:  return getEffective();
        case -1468651097:  return getEffective();
        case -1179159893:  return getIssuedElement();
        case 481140686:  return addPerformer(); 
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        case 1034315687:  return getDataAbsentReason();
        case -297950712:  return addInterpretation(); 
        case 3387378:  return addNote(); 
        case 1702620169:  return getBodySite();
        case -1001731599:  return getBodyStructure();
        case -1077554975:  return getMethod();
        case -2132868344:  return getSpecimen();
        case -1335157162:  return getDevice();
        case -1912545102:  return addReferenceRange(); 
        case -458019372:  return addHasMember(); 
        case 1077922663:  return addDerivedFrom(); 
        case -1399907075:  return addComponent(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -246883639: /*instantiates*/ return new String[] {"canonical", "Reference"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -680451314: /*triggeredBy*/ return new String[] {};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 97604824: /*focus*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -1468651097: /*effective*/ return new String[] {"dateTime", "Period", "Timing", "instant"};
        case -1179159893: /*issued*/ return new String[] {"instant"};
        case 481140686: /*performer*/ return new String[] {"Reference"};
        case 111972721: /*value*/ return new String[] {"Quantity", "CodeableConcept", "string", "boolean", "integer", "Range", "Ratio", "SampledData", "time", "dateTime", "Period", "Attachment"};
        case 1034315687: /*dataAbsentReason*/ return new String[] {"CodeableConcept"};
        case -297950712: /*interpretation*/ return new String[] {"CodeableConcept"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 1702620169: /*bodySite*/ return new String[] {"CodeableConcept"};
        case -1001731599: /*bodyStructure*/ return new String[] {"Reference"};
        case -1077554975: /*method*/ return new String[] {"CodeableConcept"};
        case -2132868344: /*specimen*/ return new String[] {"Reference"};
        case -1335157162: /*device*/ return new String[] {"Reference"};
        case -1912545102: /*referenceRange*/ return new String[] {};
        case -458019372: /*hasMember*/ return new String[] {"Reference"};
        case 1077922663: /*derivedFrom*/ return new String[] {"Reference"};
        case -1399907075: /*component*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("instantiatesCanonical")) {
          this.instantiates = new CanonicalType();
          return this.instantiates;
        }
        else if (name.equals("instantiatesReference")) {
          this.instantiates = new Reference();
          return this.instantiates;
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("triggeredBy")) {
          return addTriggeredBy();
        }
        else if (name.equals("partOf")) {
          return addPartOf();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Observation.status");
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
        else if (name.equals("focus")) {
          return addFocus();
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("effectiveDateTime")) {
          this.effective = new DateTimeType();
          return this.effective;
        }
        else if (name.equals("effectivePeriod")) {
          this.effective = new Period();
          return this.effective;
        }
        else if (name.equals("effectiveTiming")) {
          this.effective = new Timing();
          return this.effective;
        }
        else if (name.equals("effectiveInstant")) {
          this.effective = new InstantType();
          return this.effective;
        }
        else if (name.equals("issued")) {
          throw new FHIRException("Cannot call addChild on a primitive type Observation.issued");
        }
        else if (name.equals("performer")) {
          return addPerformer();
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueString")) {
          this.value = new StringType();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueInteger")) {
          this.value = new IntegerType();
          return this.value;
        }
        else if (name.equals("valueRange")) {
          this.value = new Range();
          return this.value;
        }
        else if (name.equals("valueRatio")) {
          this.value = new Ratio();
          return this.value;
        }
        else if (name.equals("valueSampledData")) {
          this.value = new SampledData();
          return this.value;
        }
        else if (name.equals("valueTime")) {
          this.value = new TimeType();
          return this.value;
        }
        else if (name.equals("valueDateTime")) {
          this.value = new DateTimeType();
          return this.value;
        }
        else if (name.equals("valuePeriod")) {
          this.value = new Period();
          return this.value;
        }
        else if (name.equals("valueAttachment")) {
          this.value = new Attachment();
          return this.value;
        }
        else if (name.equals("dataAbsentReason")) {
          this.dataAbsentReason = new CodeableConcept();
          return this.dataAbsentReason;
        }
        else if (name.equals("interpretation")) {
          return addInterpretation();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("bodySite")) {
          this.bodySite = new CodeableConcept();
          return this.bodySite;
        }
        else if (name.equals("bodyStructure")) {
          this.bodyStructure = new Reference();
          return this.bodyStructure;
        }
        else if (name.equals("method")) {
          this.method = new CodeableConcept();
          return this.method;
        }
        else if (name.equals("specimen")) {
          this.specimen = new Reference();
          return this.specimen;
        }
        else if (name.equals("device")) {
          this.device = new Reference();
          return this.device;
        }
        else if (name.equals("referenceRange")) {
          return addReferenceRange();
        }
        else if (name.equals("hasMember")) {
          return addHasMember();
        }
        else if (name.equals("derivedFrom")) {
          return addDerivedFrom();
        }
        else if (name.equals("component")) {
          return addComponent();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Observation";

  }

      public Observation copy() {
        Observation dst = new Observation();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Observation dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.instantiates = instantiates == null ? null : instantiates.copy();
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        if (triggeredBy != null) {
          dst.triggeredBy = new ArrayList<ObservationTriggeredByComponent>();
          for (ObservationTriggeredByComponent i : triggeredBy)
            dst.triggeredBy.add(i.copy());
        };
        if (partOf != null) {
          dst.partOf = new ArrayList<Reference>();
          for (Reference i : partOf)
            dst.partOf.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.subject = subject == null ? null : subject.copy();
        if (focus != null) {
          dst.focus = new ArrayList<Reference>();
          for (Reference i : focus)
            dst.focus.add(i.copy());
        };
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.effective = effective == null ? null : effective.copy();
        dst.issued = issued == null ? null : issued.copy();
        if (performer != null) {
          dst.performer = new ArrayList<Reference>();
          for (Reference i : performer)
            dst.performer.add(i.copy());
        };
        dst.value = value == null ? null : value.copy();
        dst.dataAbsentReason = dataAbsentReason == null ? null : dataAbsentReason.copy();
        if (interpretation != null) {
          dst.interpretation = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : interpretation)
            dst.interpretation.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.bodySite = bodySite == null ? null : bodySite.copy();
        dst.bodyStructure = bodyStructure == null ? null : bodyStructure.copy();
        dst.method = method == null ? null : method.copy();
        dst.specimen = specimen == null ? null : specimen.copy();
        dst.device = device == null ? null : device.copy();
        if (referenceRange != null) {
          dst.referenceRange = new ArrayList<ObservationReferenceRangeComponent>();
          for (ObservationReferenceRangeComponent i : referenceRange)
            dst.referenceRange.add(i.copy());
        };
        if (hasMember != null) {
          dst.hasMember = new ArrayList<Reference>();
          for (Reference i : hasMember)
            dst.hasMember.add(i.copy());
        };
        if (derivedFrom != null) {
          dst.derivedFrom = new ArrayList<Reference>();
          for (Reference i : derivedFrom)
            dst.derivedFrom.add(i.copy());
        };
        if (component != null) {
          dst.component = new ArrayList<ObservationComponentComponent>();
          for (ObservationComponentComponent i : component)
            dst.component.add(i.copy());
        };
      }

      protected Observation typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Observation))
          return false;
        Observation o = (Observation) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(instantiates, o.instantiates, true)
           && compareDeep(basedOn, o.basedOn, true) && compareDeep(triggeredBy, o.triggeredBy, true) && compareDeep(partOf, o.partOf, true)
           && compareDeep(status, o.status, true) && compareDeep(category, o.category, true) && compareDeep(code, o.code, true)
           && compareDeep(subject, o.subject, true) && compareDeep(focus, o.focus, true) && compareDeep(encounter, o.encounter, true)
           && compareDeep(effective, o.effective, true) && compareDeep(issued, o.issued, true) && compareDeep(performer, o.performer, true)
           && compareDeep(value, o.value, true) && compareDeep(dataAbsentReason, o.dataAbsentReason, true)
           && compareDeep(interpretation, o.interpretation, true) && compareDeep(note, o.note, true) && compareDeep(bodySite, o.bodySite, true)
           && compareDeep(bodyStructure, o.bodyStructure, true) && compareDeep(method, o.method, true) && compareDeep(specimen, o.specimen, true)
           && compareDeep(device, o.device, true) && compareDeep(referenceRange, o.referenceRange, true) && compareDeep(hasMember, o.hasMember, true)
           && compareDeep(derivedFrom, o.derivedFrom, true) && compareDeep(component, o.component, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Observation))
          return false;
        Observation o = (Observation) other_;
        return compareValues(status, o.status, true) && compareValues(issued, o.issued, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, instantiates, basedOn
          , triggeredBy, partOf, status, category, code, subject, focus, encounter, effective
          , issued, performer, value, dataAbsentReason, interpretation, note, bodySite, bodyStructure
          , method, specimen, device, referenceRange, hasMember, derivedFrom, component
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Observation;
   }


}

