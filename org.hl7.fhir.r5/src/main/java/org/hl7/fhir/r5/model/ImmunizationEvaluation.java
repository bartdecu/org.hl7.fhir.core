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
 * Describes a comparison of an immunization event against published recommendations to determine if the administration is "valid" in relation to those  recommendations.
 */
@ResourceDef(name="ImmunizationEvaluation", profile="http://hl7.org/fhir/StructureDefinition/ImmunizationEvaluation")
public class ImmunizationEvaluation extends DomainResource {

    public enum ImmunizationEvaluationStatusCodes {
        /**
         * All actions that are implied by the administration have occurred.
         */
        COMPLETED, 
        /**
         * The administration was entered in error and therefore nullified.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ImmunizationEvaluationStatusCodes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ImmunizationEvaluationStatusCodes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case COMPLETED: return "completed";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case COMPLETED: return "http://hl7.org/fhir/CodeSystem/medication-admin-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/CodeSystem/medication-admin-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case COMPLETED: return "All actions that are implied by the administration have occurred.";
            case ENTEREDINERROR: return "The administration was entered in error and therefore nullified.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case COMPLETED: return "Completed";
            case ENTEREDINERROR: return "Entered in Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ImmunizationEvaluationStatusCodesEnumFactory implements EnumFactory<ImmunizationEvaluationStatusCodes> {
    public ImmunizationEvaluationStatusCodes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("completed".equals(codeString))
          return ImmunizationEvaluationStatusCodes.COMPLETED;
        if ("entered-in-error".equals(codeString))
          return ImmunizationEvaluationStatusCodes.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown ImmunizationEvaluationStatusCodes code '"+codeString+"'");
        }
        public Enumeration<ImmunizationEvaluationStatusCodes> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ImmunizationEvaluationStatusCodes>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("completed".equals(codeString))
          return new Enumeration<ImmunizationEvaluationStatusCodes>(this, ImmunizationEvaluationStatusCodes.COMPLETED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<ImmunizationEvaluationStatusCodes>(this, ImmunizationEvaluationStatusCodes.ENTEREDINERROR);
        throw new FHIRException("Unknown ImmunizationEvaluationStatusCodes code '"+codeString+"'");
        }
    public String toCode(ImmunizationEvaluationStatusCodes code) {
      if (code == ImmunizationEvaluationStatusCodes.COMPLETED)
        return "completed";
      if (code == ImmunizationEvaluationStatusCodes.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(ImmunizationEvaluationStatusCodes code) {
      return code.getSystem();
      }
    }

    /**
     * A unique identifier assigned to this immunization evaluation record.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Business identifier", formalDefinition="A unique identifier assigned to this immunization evaluation record." )
    protected List<Identifier> identifier;

    /**
     * Indicates the current status of the evaluation of the vaccination administration event.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="completed | entered-in-error", formalDefinition="Indicates the current status of the evaluation of the vaccination administration event." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/immunization-evaluation-status")
    protected Enumeration<ImmunizationEvaluationStatusCodes> status;

    /**
     * The individual for whom the evaluation is being done.
     */
    @Child(name = "patient", type = {Patient.class}, order=2, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who this evaluation is for", formalDefinition="The individual for whom the evaluation is being done." )
    protected Reference patient;

    /**
     * The date the evaluation of the vaccine administration event was performed.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Date evaluation was performed", formalDefinition="The date the evaluation of the vaccine administration event was performed." )
    protected DateTimeType date;

    /**
     * Indicates the authority who published the protocol (e.g. ACIP).
     */
    @Child(name = "authority", type = {Organization.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Who is responsible for publishing the recommendations", formalDefinition="Indicates the authority who published the protocol (e.g. ACIP)." )
    protected Reference authority;

    /**
     * The vaccine preventable disease the dose is being evaluated against.
     */
    @Child(name = "targetDisease", type = {CodeableConcept.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The vaccine preventable disease schedule being evaluated", formalDefinition="The vaccine preventable disease the dose is being evaluated against." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/immunization-target-disease")
    protected CodeableConcept targetDisease;

    /**
     * The vaccine administration event being evaluated.
     */
    @Child(name = "immunizationEvent", type = {Immunization.class}, order=6, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Immunization being evaluated", formalDefinition="The vaccine administration event being evaluated." )
    protected Reference immunizationEvent;

    /**
     * Indicates if the dose is valid or not valid with respect to the published recommendations.
     */
    @Child(name = "doseStatus", type = {CodeableConcept.class}, order=7, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Status of the dose relative to published recommendations", formalDefinition="Indicates if the dose is valid or not valid with respect to the published recommendations." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/immunization-evaluation-dose-status")
    protected CodeableConcept doseStatus;

    /**
     * Provides an explanation as to why the vaccine administration event is valid or not relative to the published recommendations.
     */
    @Child(name = "doseStatusReason", type = {CodeableConcept.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Reason why the doese is considered valid, invalid or some other status", formalDefinition="Provides an explanation as to why the vaccine administration event is valid or not relative to the published recommendations." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/immunization-evaluation-dose-status-reason")
    protected List<CodeableConcept> doseStatusReason;

    /**
     * Additional information about the evaluation.
     */
    @Child(name = "description", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Evaluation notes", formalDefinition="Additional information about the evaluation." )
    protected StringType description;

    /**
     * One possible path to achieve presumed immunity against a disease - within the context of an authority.
     */
    @Child(name = "series", type = {StringType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Name of vaccine series", formalDefinition="One possible path to achieve presumed immunity against a disease - within the context of an authority." )
    protected StringType series;

    /**
     * Nominal position in a series as determined by the outcome of the evaluation process.
     */
    @Child(name = "doseNumber", type = {StringType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Dose number within series", formalDefinition="Nominal position in a series as determined by the outcome of the evaluation process." )
    protected StringType doseNumber;

    /**
     * The recommended number of doses to achieve immunity as determined by the outcome of the evaluation process.
     */
    @Child(name = "seriesDoses", type = {StringType.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Recommended number of doses for immunity", formalDefinition="The recommended number of doses to achieve immunity as determined by the outcome of the evaluation process." )
    protected StringType seriesDoses;

    private static final long serialVersionUID = -434973409L;

  /**
   * Constructor
   */
    public ImmunizationEvaluation() {
      super();
    }

  /**
   * Constructor
   */
    public ImmunizationEvaluation(ImmunizationEvaluationStatusCodes status, Reference patient, CodeableConcept targetDisease, Reference immunizationEvent, CodeableConcept doseStatus) {
      super();
      this.setStatus(status);
      this.setPatient(patient);
      this.setTargetDisease(targetDisease);
      this.setImmunizationEvent(immunizationEvent);
      this.setDoseStatus(doseStatus);
    }

    /**
     * @return {@link #identifier} (A unique identifier assigned to this immunization evaluation record.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImmunizationEvaluation setIdentifier(List<Identifier> theIdentifier) { 
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

    public ImmunizationEvaluation addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (Indicates the current status of the evaluation of the vaccination administration event.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<ImmunizationEvaluationStatusCodes> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImmunizationEvaluation.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<ImmunizationEvaluationStatusCodes>(new ImmunizationEvaluationStatusCodesEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (Indicates the current status of the evaluation of the vaccination administration event.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ImmunizationEvaluation setStatusElement(Enumeration<ImmunizationEvaluationStatusCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return Indicates the current status of the evaluation of the vaccination administration event.
     */
    public ImmunizationEvaluationStatusCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value Indicates the current status of the evaluation of the vaccination administration event.
     */
    public ImmunizationEvaluation setStatus(ImmunizationEvaluationStatusCodes value) { 
        if (this.status == null)
          this.status = new Enumeration<ImmunizationEvaluationStatusCodes>(new ImmunizationEvaluationStatusCodesEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #patient} (The individual for whom the evaluation is being done.)
     */
    public Reference getPatient() { 
      if (this.patient == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImmunizationEvaluation.patient");
        else if (Configuration.doAutoCreate())
          this.patient = new Reference(); // cc
      return this.patient;
    }

    public boolean hasPatient() { 
      return this.patient != null && !this.patient.isEmpty();
    }

    /**
     * @param value {@link #patient} (The individual for whom the evaluation is being done.)
     */
    public ImmunizationEvaluation setPatient(Reference value) { 
      this.patient = value;
      return this;
    }

    /**
     * @return {@link #date} (The date the evaluation of the vaccine administration event was performed.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImmunizationEvaluation.date");
        else if (Configuration.doAutoCreate())
          this.date = new DateTimeType(); // bb
      return this.date;
    }

    public boolean hasDateElement() { 
      return this.date != null && !this.date.isEmpty();
    }

    public boolean hasDate() { 
      return this.date != null && !this.date.isEmpty();
    }

    /**
     * @param value {@link #date} (The date the evaluation of the vaccine administration event was performed.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public ImmunizationEvaluation setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date the evaluation of the vaccine administration event was performed.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date the evaluation of the vaccine administration event was performed.
     */
    public ImmunizationEvaluation setDate(Date value) { 
      if (value == null)
        this.date = null;
      else {
        if (this.date == null)
          this.date = new DateTimeType();
        this.date.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #authority} (Indicates the authority who published the protocol (e.g. ACIP).)
     */
    public Reference getAuthority() { 
      if (this.authority == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImmunizationEvaluation.authority");
        else if (Configuration.doAutoCreate())
          this.authority = new Reference(); // cc
      return this.authority;
    }

    public boolean hasAuthority() { 
      return this.authority != null && !this.authority.isEmpty();
    }

    /**
     * @param value {@link #authority} (Indicates the authority who published the protocol (e.g. ACIP).)
     */
    public ImmunizationEvaluation setAuthority(Reference value) { 
      this.authority = value;
      return this;
    }

    /**
     * @return {@link #targetDisease} (The vaccine preventable disease the dose is being evaluated against.)
     */
    public CodeableConcept getTargetDisease() { 
      if (this.targetDisease == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImmunizationEvaluation.targetDisease");
        else if (Configuration.doAutoCreate())
          this.targetDisease = new CodeableConcept(); // cc
      return this.targetDisease;
    }

    public boolean hasTargetDisease() { 
      return this.targetDisease != null && !this.targetDisease.isEmpty();
    }

    /**
     * @param value {@link #targetDisease} (The vaccine preventable disease the dose is being evaluated against.)
     */
    public ImmunizationEvaluation setTargetDisease(CodeableConcept value) { 
      this.targetDisease = value;
      return this;
    }

    /**
     * @return {@link #immunizationEvent} (The vaccine administration event being evaluated.)
     */
    public Reference getImmunizationEvent() { 
      if (this.immunizationEvent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImmunizationEvaluation.immunizationEvent");
        else if (Configuration.doAutoCreate())
          this.immunizationEvent = new Reference(); // cc
      return this.immunizationEvent;
    }

    public boolean hasImmunizationEvent() { 
      return this.immunizationEvent != null && !this.immunizationEvent.isEmpty();
    }

    /**
     * @param value {@link #immunizationEvent} (The vaccine administration event being evaluated.)
     */
    public ImmunizationEvaluation setImmunizationEvent(Reference value) { 
      this.immunizationEvent = value;
      return this;
    }

    /**
     * @return {@link #doseStatus} (Indicates if the dose is valid or not valid with respect to the published recommendations.)
     */
    public CodeableConcept getDoseStatus() { 
      if (this.doseStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImmunizationEvaluation.doseStatus");
        else if (Configuration.doAutoCreate())
          this.doseStatus = new CodeableConcept(); // cc
      return this.doseStatus;
    }

    public boolean hasDoseStatus() { 
      return this.doseStatus != null && !this.doseStatus.isEmpty();
    }

    /**
     * @param value {@link #doseStatus} (Indicates if the dose is valid or not valid with respect to the published recommendations.)
     */
    public ImmunizationEvaluation setDoseStatus(CodeableConcept value) { 
      this.doseStatus = value;
      return this;
    }

    /**
     * @return {@link #doseStatusReason} (Provides an explanation as to why the vaccine administration event is valid or not relative to the published recommendations.)
     */
    public List<CodeableConcept> getDoseStatusReason() { 
      if (this.doseStatusReason == null)
        this.doseStatusReason = new ArrayList<CodeableConcept>();
      return this.doseStatusReason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ImmunizationEvaluation setDoseStatusReason(List<CodeableConcept> theDoseStatusReason) { 
      this.doseStatusReason = theDoseStatusReason;
      return this;
    }

    public boolean hasDoseStatusReason() { 
      if (this.doseStatusReason == null)
        return false;
      for (CodeableConcept item : this.doseStatusReason)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addDoseStatusReason() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.doseStatusReason == null)
        this.doseStatusReason = new ArrayList<CodeableConcept>();
      this.doseStatusReason.add(t);
      return t;
    }

    public ImmunizationEvaluation addDoseStatusReason(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.doseStatusReason == null)
        this.doseStatusReason = new ArrayList<CodeableConcept>();
      this.doseStatusReason.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #doseStatusReason}, creating it if it does not already exist {3}
     */
    public CodeableConcept getDoseStatusReasonFirstRep() { 
      if (getDoseStatusReason().isEmpty()) {
        addDoseStatusReason();
      }
      return getDoseStatusReason().get(0);
    }

    /**
     * @return {@link #description} (Additional information about the evaluation.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImmunizationEvaluation.description");
        else if (Configuration.doAutoCreate())
          this.description = new StringType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (Additional information about the evaluation.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public ImmunizationEvaluation setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return Additional information about the evaluation.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value Additional information about the evaluation.
     */
    public ImmunizationEvaluation setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new StringType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #series} (One possible path to achieve presumed immunity against a disease - within the context of an authority.). This is the underlying object with id, value and extensions. The accessor "getSeries" gives direct access to the value
     */
    public StringType getSeriesElement() { 
      if (this.series == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImmunizationEvaluation.series");
        else if (Configuration.doAutoCreate())
          this.series = new StringType(); // bb
      return this.series;
    }

    public boolean hasSeriesElement() { 
      return this.series != null && !this.series.isEmpty();
    }

    public boolean hasSeries() { 
      return this.series != null && !this.series.isEmpty();
    }

    /**
     * @param value {@link #series} (One possible path to achieve presumed immunity against a disease - within the context of an authority.). This is the underlying object with id, value and extensions. The accessor "getSeries" gives direct access to the value
     */
    public ImmunizationEvaluation setSeriesElement(StringType value) { 
      this.series = value;
      return this;
    }

    /**
     * @return One possible path to achieve presumed immunity against a disease - within the context of an authority.
     */
    public String getSeries() { 
      return this.series == null ? null : this.series.getValue();
    }

    /**
     * @param value One possible path to achieve presumed immunity against a disease - within the context of an authority.
     */
    public ImmunizationEvaluation setSeries(String value) { 
      if (Utilities.noString(value))
        this.series = null;
      else {
        if (this.series == null)
          this.series = new StringType();
        this.series.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #doseNumber} (Nominal position in a series as determined by the outcome of the evaluation process.). This is the underlying object with id, value and extensions. The accessor "getDoseNumber" gives direct access to the value
     */
    public StringType getDoseNumberElement() { 
      if (this.doseNumber == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImmunizationEvaluation.doseNumber");
        else if (Configuration.doAutoCreate())
          this.doseNumber = new StringType(); // bb
      return this.doseNumber;
    }

    public boolean hasDoseNumberElement() { 
      return this.doseNumber != null && !this.doseNumber.isEmpty();
    }

    public boolean hasDoseNumber() { 
      return this.doseNumber != null && !this.doseNumber.isEmpty();
    }

    /**
     * @param value {@link #doseNumber} (Nominal position in a series as determined by the outcome of the evaluation process.). This is the underlying object with id, value and extensions. The accessor "getDoseNumber" gives direct access to the value
     */
    public ImmunizationEvaluation setDoseNumberElement(StringType value) { 
      this.doseNumber = value;
      return this;
    }

    /**
     * @return Nominal position in a series as determined by the outcome of the evaluation process.
     */
    public String getDoseNumber() { 
      return this.doseNumber == null ? null : this.doseNumber.getValue();
    }

    /**
     * @param value Nominal position in a series as determined by the outcome of the evaluation process.
     */
    public ImmunizationEvaluation setDoseNumber(String value) { 
      if (Utilities.noString(value))
        this.doseNumber = null;
      else {
        if (this.doseNumber == null)
          this.doseNumber = new StringType();
        this.doseNumber.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #seriesDoses} (The recommended number of doses to achieve immunity as determined by the outcome of the evaluation process.). This is the underlying object with id, value and extensions. The accessor "getSeriesDoses" gives direct access to the value
     */
    public StringType getSeriesDosesElement() { 
      if (this.seriesDoses == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ImmunizationEvaluation.seriesDoses");
        else if (Configuration.doAutoCreate())
          this.seriesDoses = new StringType(); // bb
      return this.seriesDoses;
    }

    public boolean hasSeriesDosesElement() { 
      return this.seriesDoses != null && !this.seriesDoses.isEmpty();
    }

    public boolean hasSeriesDoses() { 
      return this.seriesDoses != null && !this.seriesDoses.isEmpty();
    }

    /**
     * @param value {@link #seriesDoses} (The recommended number of doses to achieve immunity as determined by the outcome of the evaluation process.). This is the underlying object with id, value and extensions. The accessor "getSeriesDoses" gives direct access to the value
     */
    public ImmunizationEvaluation setSeriesDosesElement(StringType value) { 
      this.seriesDoses = value;
      return this;
    }

    /**
     * @return The recommended number of doses to achieve immunity as determined by the outcome of the evaluation process.
     */
    public String getSeriesDoses() { 
      return this.seriesDoses == null ? null : this.seriesDoses.getValue();
    }

    /**
     * @param value The recommended number of doses to achieve immunity as determined by the outcome of the evaluation process.
     */
    public ImmunizationEvaluation setSeriesDoses(String value) { 
      if (Utilities.noString(value))
        this.seriesDoses = null;
      else {
        if (this.seriesDoses == null)
          this.seriesDoses = new StringType();
        this.seriesDoses.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A unique identifier assigned to this immunization evaluation record.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "Indicates the current status of the evaluation of the vaccination administration event.", 0, 1, status));
        children.add(new Property("patient", "Reference(Patient)", "The individual for whom the evaluation is being done.", 0, 1, patient));
        children.add(new Property("date", "dateTime", "The date the evaluation of the vaccine administration event was performed.", 0, 1, date));
        children.add(new Property("authority", "Reference(Organization)", "Indicates the authority who published the protocol (e.g. ACIP).", 0, 1, authority));
        children.add(new Property("targetDisease", "CodeableConcept", "The vaccine preventable disease the dose is being evaluated against.", 0, 1, targetDisease));
        children.add(new Property("immunizationEvent", "Reference(Immunization)", "The vaccine administration event being evaluated.", 0, 1, immunizationEvent));
        children.add(new Property("doseStatus", "CodeableConcept", "Indicates if the dose is valid or not valid with respect to the published recommendations.", 0, 1, doseStatus));
        children.add(new Property("doseStatusReason", "CodeableConcept", "Provides an explanation as to why the vaccine administration event is valid or not relative to the published recommendations.", 0, java.lang.Integer.MAX_VALUE, doseStatusReason));
        children.add(new Property("description", "string", "Additional information about the evaluation.", 0, 1, description));
        children.add(new Property("series", "string", "One possible path to achieve presumed immunity against a disease - within the context of an authority.", 0, 1, series));
        children.add(new Property("doseNumber", "string", "Nominal position in a series as determined by the outcome of the evaluation process.", 0, 1, doseNumber));
        children.add(new Property("seriesDoses", "string", "The recommended number of doses to achieve immunity as determined by the outcome of the evaluation process.", 0, 1, seriesDoses));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A unique identifier assigned to this immunization evaluation record.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "Indicates the current status of the evaluation of the vaccination administration event.", 0, 1, status);
        case -791418107: /*patient*/  return new Property("patient", "Reference(Patient)", "The individual for whom the evaluation is being done.", 0, 1, patient);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date the evaluation of the vaccine administration event was performed.", 0, 1, date);
        case 1475610435: /*authority*/  return new Property("authority", "Reference(Organization)", "Indicates the authority who published the protocol (e.g. ACIP).", 0, 1, authority);
        case -319593813: /*targetDisease*/  return new Property("targetDisease", "CodeableConcept", "The vaccine preventable disease the dose is being evaluated against.", 0, 1, targetDisease);
        case 1081446840: /*immunizationEvent*/  return new Property("immunizationEvent", "Reference(Immunization)", "The vaccine administration event being evaluated.", 0, 1, immunizationEvent);
        case -745826705: /*doseStatus*/  return new Property("doseStatus", "CodeableConcept", "Indicates if the dose is valid or not valid with respect to the published recommendations.", 0, 1, doseStatus);
        case 662783379: /*doseStatusReason*/  return new Property("doseStatusReason", "CodeableConcept", "Provides an explanation as to why the vaccine administration event is valid or not relative to the published recommendations.", 0, java.lang.Integer.MAX_VALUE, doseStatusReason);
        case -1724546052: /*description*/  return new Property("description", "string", "Additional information about the evaluation.", 0, 1, description);
        case -905838985: /*series*/  return new Property("series", "string", "One possible path to achieve presumed immunity against a disease - within the context of an authority.", 0, 1, series);
        case -887709242: /*doseNumber*/  return new Property("doseNumber", "string", "Nominal position in a series as determined by the outcome of the evaluation process.", 0, 1, doseNumber);
        case -1936727105: /*seriesDoses*/  return new Property("seriesDoses", "string", "The recommended number of doses to achieve immunity as determined by the outcome of the evaluation process.", 0, 1, seriesDoses);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<ImmunizationEvaluationStatusCodes>
        case -791418107: /*patient*/ return this.patient == null ? new Base[0] : new Base[] {this.patient}; // Reference
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1475610435: /*authority*/ return this.authority == null ? new Base[0] : new Base[] {this.authority}; // Reference
        case -319593813: /*targetDisease*/ return this.targetDisease == null ? new Base[0] : new Base[] {this.targetDisease}; // CodeableConcept
        case 1081446840: /*immunizationEvent*/ return this.immunizationEvent == null ? new Base[0] : new Base[] {this.immunizationEvent}; // Reference
        case -745826705: /*doseStatus*/ return this.doseStatus == null ? new Base[0] : new Base[] {this.doseStatus}; // CodeableConcept
        case 662783379: /*doseStatusReason*/ return this.doseStatusReason == null ? new Base[0] : this.doseStatusReason.toArray(new Base[this.doseStatusReason.size()]); // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -905838985: /*series*/ return this.series == null ? new Base[0] : new Base[] {this.series}; // StringType
        case -887709242: /*doseNumber*/ return this.doseNumber == null ? new Base[0] : new Base[] {this.doseNumber}; // StringType
        case -1936727105: /*seriesDoses*/ return this.seriesDoses == null ? new Base[0] : new Base[] {this.seriesDoses}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -892481550: // status
          value = new ImmunizationEvaluationStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ImmunizationEvaluationStatusCodes>
          return value;
        case -791418107: // patient
          this.patient = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1475610435: // authority
          this.authority = TypeConvertor.castToReference(value); // Reference
          return value;
        case -319593813: // targetDisease
          this.targetDisease = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1081446840: // immunizationEvent
          this.immunizationEvent = TypeConvertor.castToReference(value); // Reference
          return value;
        case -745826705: // doseStatus
          this.doseStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 662783379: // doseStatusReason
          this.getDoseStatusReason().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -905838985: // series
          this.series = TypeConvertor.castToString(value); // StringType
          return value;
        case -887709242: // doseNumber
          this.doseNumber = TypeConvertor.castToString(value); // StringType
          return value;
        case -1936727105: // seriesDoses
          this.seriesDoses = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new ImmunizationEvaluationStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ImmunizationEvaluationStatusCodes>
        } else if (name.equals("patient")) {
          this.patient = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("authority")) {
          this.authority = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("targetDisease")) {
          this.targetDisease = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("immunizationEvent")) {
          this.immunizationEvent = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("doseStatus")) {
          this.doseStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("doseStatusReason")) {
          this.getDoseStatusReason().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("series")) {
          this.series = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("doseNumber")) {
          this.doseNumber = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("seriesDoses")) {
          this.seriesDoses = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case -791418107:  return getPatient();
        case 3076014:  return getDateElement();
        case 1475610435:  return getAuthority();
        case -319593813:  return getTargetDisease();
        case 1081446840:  return getImmunizationEvent();
        case -745826705:  return getDoseStatus();
        case 662783379:  return addDoseStatusReason(); 
        case -1724546052:  return getDescriptionElement();
        case -905838985:  return getSeriesElement();
        case -887709242:  return getDoseNumberElement();
        case -1936727105:  return getSeriesDosesElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -791418107: /*patient*/ return new String[] {"Reference"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1475610435: /*authority*/ return new String[] {"Reference"};
        case -319593813: /*targetDisease*/ return new String[] {"CodeableConcept"};
        case 1081446840: /*immunizationEvent*/ return new String[] {"Reference"};
        case -745826705: /*doseStatus*/ return new String[] {"CodeableConcept"};
        case 662783379: /*doseStatusReason*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -905838985: /*series*/ return new String[] {"string"};
        case -887709242: /*doseNumber*/ return new String[] {"string"};
        case -1936727105: /*seriesDoses*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImmunizationEvaluation.status");
        }
        else if (name.equals("patient")) {
          this.patient = new Reference();
          return this.patient;
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImmunizationEvaluation.date");
        }
        else if (name.equals("authority")) {
          this.authority = new Reference();
          return this.authority;
        }
        else if (name.equals("targetDisease")) {
          this.targetDisease = new CodeableConcept();
          return this.targetDisease;
        }
        else if (name.equals("immunizationEvent")) {
          this.immunizationEvent = new Reference();
          return this.immunizationEvent;
        }
        else if (name.equals("doseStatus")) {
          this.doseStatus = new CodeableConcept();
          return this.doseStatus;
        }
        else if (name.equals("doseStatusReason")) {
          return addDoseStatusReason();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImmunizationEvaluation.description");
        }
        else if (name.equals("series")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImmunizationEvaluation.series");
        }
        else if (name.equals("doseNumber")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImmunizationEvaluation.doseNumber");
        }
        else if (name.equals("seriesDoses")) {
          throw new FHIRException("Cannot call addChild on a primitive type ImmunizationEvaluation.seriesDoses");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ImmunizationEvaluation";

  }

      public ImmunizationEvaluation copy() {
        ImmunizationEvaluation dst = new ImmunizationEvaluation();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ImmunizationEvaluation dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.patient = patient == null ? null : patient.copy();
        dst.date = date == null ? null : date.copy();
        dst.authority = authority == null ? null : authority.copy();
        dst.targetDisease = targetDisease == null ? null : targetDisease.copy();
        dst.immunizationEvent = immunizationEvent == null ? null : immunizationEvent.copy();
        dst.doseStatus = doseStatus == null ? null : doseStatus.copy();
        if (doseStatusReason != null) {
          dst.doseStatusReason = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : doseStatusReason)
            dst.doseStatusReason.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        dst.series = series == null ? null : series.copy();
        dst.doseNumber = doseNumber == null ? null : doseNumber.copy();
        dst.seriesDoses = seriesDoses == null ? null : seriesDoses.copy();
      }

      protected ImmunizationEvaluation typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ImmunizationEvaluation))
          return false;
        ImmunizationEvaluation o = (ImmunizationEvaluation) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(patient, o.patient, true)
           && compareDeep(date, o.date, true) && compareDeep(authority, o.authority, true) && compareDeep(targetDisease, o.targetDisease, true)
           && compareDeep(immunizationEvent, o.immunizationEvent, true) && compareDeep(doseStatus, o.doseStatus, true)
           && compareDeep(doseStatusReason, o.doseStatusReason, true) && compareDeep(description, o.description, true)
           && compareDeep(series, o.series, true) && compareDeep(doseNumber, o.doseNumber, true) && compareDeep(seriesDoses, o.seriesDoses, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ImmunizationEvaluation))
          return false;
        ImmunizationEvaluation o = (ImmunizationEvaluation) other_;
        return compareValues(status, o.status, true) && compareValues(date, o.date, true) && compareValues(description, o.description, true)
           && compareValues(series, o.series, true) && compareValues(doseNumber, o.doseNumber, true) && compareValues(seriesDoses, o.seriesDoses, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, patient
          , date, authority, targetDisease, immunizationEvent, doseStatus, doseStatusReason
          , description, series, doseNumber, seriesDoses);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ImmunizationEvaluation;
   }


}

