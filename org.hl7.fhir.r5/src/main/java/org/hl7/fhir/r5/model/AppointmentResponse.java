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
 * A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.
 */
@ResourceDef(name="AppointmentResponse", profile="http://hl7.org/fhir/StructureDefinition/AppointmentResponse")
public class AppointmentResponse extends DomainResource {

    /**
     * This records identifiers associated with this appointment response concern that are defined by business processes and/ or used to refer to it when a direct URL reference to the resource itself is not appropriate.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External Ids for this item", formalDefinition="This records identifiers associated with this appointment response concern that are defined by business processes and/ or used to refer to it when a direct URL reference to the resource itself is not appropriate." )
    protected List<Identifier> identifier;

    /**
     * Appointment that this response is replying to.
     */
    @Child(name = "appointment", type = {Appointment.class}, order=1, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Appointment this response relates to", formalDefinition="Appointment that this response is replying to." )
    protected Reference appointment;

    /**
     * Date/Time that the appointment is to take place, or requested new start time.
     */
    @Child(name = "start", type = {InstantType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Time from appointment, or requested new start time", formalDefinition="Date/Time that the appointment is to take place, or requested new start time." )
    protected InstantType start;

    /**
     * This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time.
     */
    @Child(name = "end", type = {InstantType.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Time from appointment, or requested new end time", formalDefinition="This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time." )
    protected InstantType end;

    /**
     * Role of participant in the appointment.
     */
    @Child(name = "participantType", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Role of participant in the appointment", formalDefinition="Role of participant in the appointment." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-participant-type")
    protected List<CodeableConcept> participantType;

    /**
     * A Person, Location, HealthcareService, or Device that is participating in the appointment.
     */
    @Child(name = "actor", type = {Patient.class, Group.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class, Device.class, HealthcareService.class, Location.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Person(s), Location, HealthcareService, or Device", formalDefinition="A Person, Location, HealthcareService, or Device that is participating in the appointment." )
    protected Reference actor;

    /**
     * Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty.
     */
    @Child(name = "participantStatus", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="accepted | declined | tentative | needs-action", formalDefinition="Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/participationstatus")
    protected Enumeration<ParticipationStatus> participantStatus;

    /**
     * Additional comments about the appointment.
     */
    @Child(name = "comment", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Additional comments", formalDefinition="Additional comments about the appointment." )
    protected StringType comment;

    private static final long serialVersionUID = -1779591264L;

  /**
   * Constructor
   */
    public AppointmentResponse() {
      super();
    }

  /**
   * Constructor
   */
    public AppointmentResponse(Reference appointment, ParticipationStatus participantStatus) {
      super();
      this.setAppointment(appointment);
      this.setParticipantStatus(participantStatus);
    }

    /**
     * @return {@link #identifier} (This records identifiers associated with this appointment response concern that are defined by business processes and/ or used to refer to it when a direct URL reference to the resource itself is not appropriate.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AppointmentResponse setIdentifier(List<Identifier> theIdentifier) { 
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

    public AppointmentResponse addIdentifier(Identifier t) { //3
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
     * @return {@link #appointment} (Appointment that this response is replying to.)
     */
    public Reference getAppointment() { 
      if (this.appointment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.appointment");
        else if (Configuration.doAutoCreate())
          this.appointment = new Reference(); // cc
      return this.appointment;
    }

    public boolean hasAppointment() { 
      return this.appointment != null && !this.appointment.isEmpty();
    }

    /**
     * @param value {@link #appointment} (Appointment that this response is replying to.)
     */
    public AppointmentResponse setAppointment(Reference value) { 
      this.appointment = value;
      return this;
    }

    /**
     * @return {@link #start} (Date/Time that the appointment is to take place, or requested new start time.). This is the underlying object with id, value and extensions. The accessor "getStart" gives direct access to the value
     */
    public InstantType getStartElement() { 
      if (this.start == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.start");
        else if (Configuration.doAutoCreate())
          this.start = new InstantType(); // bb
      return this.start;
    }

    public boolean hasStartElement() { 
      return this.start != null && !this.start.isEmpty();
    }

    public boolean hasStart() { 
      return this.start != null && !this.start.isEmpty();
    }

    /**
     * @param value {@link #start} (Date/Time that the appointment is to take place, or requested new start time.). This is the underlying object with id, value and extensions. The accessor "getStart" gives direct access to the value
     */
    public AppointmentResponse setStartElement(InstantType value) { 
      this.start = value;
      return this;
    }

    /**
     * @return Date/Time that the appointment is to take place, or requested new start time.
     */
    public Date getStart() { 
      return this.start == null ? null : this.start.getValue();
    }

    /**
     * @param value Date/Time that the appointment is to take place, or requested new start time.
     */
    public AppointmentResponse setStart(Date value) { 
      if (value == null)
        this.start = null;
      else {
        if (this.start == null)
          this.start = new InstantType();
        this.start.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #end} (This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time.). This is the underlying object with id, value and extensions. The accessor "getEnd" gives direct access to the value
     */
    public InstantType getEndElement() { 
      if (this.end == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.end");
        else if (Configuration.doAutoCreate())
          this.end = new InstantType(); // bb
      return this.end;
    }

    public boolean hasEndElement() { 
      return this.end != null && !this.end.isEmpty();
    }

    public boolean hasEnd() { 
      return this.end != null && !this.end.isEmpty();
    }

    /**
     * @param value {@link #end} (This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time.). This is the underlying object with id, value and extensions. The accessor "getEnd" gives direct access to the value
     */
    public AppointmentResponse setEndElement(InstantType value) { 
      this.end = value;
      return this;
    }

    /**
     * @return This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time.
     */
    public Date getEnd() { 
      return this.end == null ? null : this.end.getValue();
    }

    /**
     * @param value This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time.
     */
    public AppointmentResponse setEnd(Date value) { 
      if (value == null)
        this.end = null;
      else {
        if (this.end == null)
          this.end = new InstantType();
        this.end.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #participantType} (Role of participant in the appointment.)
     */
    public List<CodeableConcept> getParticipantType() { 
      if (this.participantType == null)
        this.participantType = new ArrayList<CodeableConcept>();
      return this.participantType;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AppointmentResponse setParticipantType(List<CodeableConcept> theParticipantType) { 
      this.participantType = theParticipantType;
      return this;
    }

    public boolean hasParticipantType() { 
      if (this.participantType == null)
        return false;
      for (CodeableConcept item : this.participantType)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addParticipantType() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.participantType == null)
        this.participantType = new ArrayList<CodeableConcept>();
      this.participantType.add(t);
      return t;
    }

    public AppointmentResponse addParticipantType(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.participantType == null)
        this.participantType = new ArrayList<CodeableConcept>();
      this.participantType.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #participantType}, creating it if it does not already exist {3}
     */
    public CodeableConcept getParticipantTypeFirstRep() { 
      if (getParticipantType().isEmpty()) {
        addParticipantType();
      }
      return getParticipantType().get(0);
    }

    /**
     * @return {@link #actor} (A Person, Location, HealthcareService, or Device that is participating in the appointment.)
     */
    public Reference getActor() { 
      if (this.actor == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.actor");
        else if (Configuration.doAutoCreate())
          this.actor = new Reference(); // cc
      return this.actor;
    }

    public boolean hasActor() { 
      return this.actor != null && !this.actor.isEmpty();
    }

    /**
     * @param value {@link #actor} (A Person, Location, HealthcareService, or Device that is participating in the appointment.)
     */
    public AppointmentResponse setActor(Reference value) { 
      this.actor = value;
      return this;
    }

    /**
     * @return {@link #participantStatus} (Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty.). This is the underlying object with id, value and extensions. The accessor "getParticipantStatus" gives direct access to the value
     */
    public Enumeration<ParticipationStatus> getParticipantStatusElement() { 
      if (this.participantStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.participantStatus");
        else if (Configuration.doAutoCreate())
          this.participantStatus = new Enumeration<ParticipationStatus>(new ParticipationStatusEnumFactory()); // bb
      return this.participantStatus;
    }

    public boolean hasParticipantStatusElement() { 
      return this.participantStatus != null && !this.participantStatus.isEmpty();
    }

    public boolean hasParticipantStatus() { 
      return this.participantStatus != null && !this.participantStatus.isEmpty();
    }

    /**
     * @param value {@link #participantStatus} (Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty.). This is the underlying object with id, value and extensions. The accessor "getParticipantStatus" gives direct access to the value
     */
    public AppointmentResponse setParticipantStatusElement(Enumeration<ParticipationStatus> value) { 
      this.participantStatus = value;
      return this;
    }

    /**
     * @return Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty.
     */
    public ParticipationStatus getParticipantStatus() { 
      return this.participantStatus == null ? null : this.participantStatus.getValue();
    }

    /**
     * @param value Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty.
     */
    public AppointmentResponse setParticipantStatus(ParticipationStatus value) { 
        if (this.participantStatus == null)
          this.participantStatus = new Enumeration<ParticipationStatus>(new ParticipationStatusEnumFactory());
        this.participantStatus.setValue(value);
      return this;
    }

    /**
     * @return {@link #comment} (Additional comments about the appointment.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
     */
    public StringType getCommentElement() { 
      if (this.comment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AppointmentResponse.comment");
        else if (Configuration.doAutoCreate())
          this.comment = new StringType(); // bb
      return this.comment;
    }

    public boolean hasCommentElement() { 
      return this.comment != null && !this.comment.isEmpty();
    }

    public boolean hasComment() { 
      return this.comment != null && !this.comment.isEmpty();
    }

    /**
     * @param value {@link #comment} (Additional comments about the appointment.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
     */
    public AppointmentResponse setCommentElement(StringType value) { 
      this.comment = value;
      return this;
    }

    /**
     * @return Additional comments about the appointment.
     */
    public String getComment() { 
      return this.comment == null ? null : this.comment.getValue();
    }

    /**
     * @param value Additional comments about the appointment.
     */
    public AppointmentResponse setComment(String value) { 
      if (Utilities.noString(value))
        this.comment = null;
      else {
        if (this.comment == null)
          this.comment = new StringType();
        this.comment.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "This records identifiers associated with this appointment response concern that are defined by business processes and/ or used to refer to it when a direct URL reference to the resource itself is not appropriate.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("appointment", "Reference(Appointment)", "Appointment that this response is replying to.", 0, 1, appointment));
        children.add(new Property("start", "instant", "Date/Time that the appointment is to take place, or requested new start time.", 0, 1, start));
        children.add(new Property("end", "instant", "This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time.", 0, 1, end));
        children.add(new Property("participantType", "CodeableConcept", "Role of participant in the appointment.", 0, java.lang.Integer.MAX_VALUE, participantType));
        children.add(new Property("actor", "Reference(Patient|Group|Practitioner|PractitionerRole|RelatedPerson|Device|HealthcareService|Location)", "A Person, Location, HealthcareService, or Device that is participating in the appointment.", 0, 1, actor));
        children.add(new Property("participantStatus", "code", "Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty.", 0, 1, participantStatus));
        children.add(new Property("comment", "string", "Additional comments about the appointment.", 0, 1, comment));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "This records identifiers associated with this appointment response concern that are defined by business processes and/ or used to refer to it when a direct URL reference to the resource itself is not appropriate.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1474995297: /*appointment*/  return new Property("appointment", "Reference(Appointment)", "Appointment that this response is replying to.", 0, 1, appointment);
        case 109757538: /*start*/  return new Property("start", "instant", "Date/Time that the appointment is to take place, or requested new start time.", 0, 1, start);
        case 100571: /*end*/  return new Property("end", "instant", "This may be either the same as the appointment request to confirm the details of the appointment, or alternately a new time to request a re-negotiation of the end time.", 0, 1, end);
        case 841294093: /*participantType*/  return new Property("participantType", "CodeableConcept", "Role of participant in the appointment.", 0, java.lang.Integer.MAX_VALUE, participantType);
        case 92645877: /*actor*/  return new Property("actor", "Reference(Patient|Group|Practitioner|PractitionerRole|RelatedPerson|Device|HealthcareService|Location)", "A Person, Location, HealthcareService, or Device that is participating in the appointment.", 0, 1, actor);
        case 996096261: /*participantStatus*/  return new Property("participantStatus", "code", "Participation status of the participant. When the status is declined or tentative if the start/end times are different to the appointment, then these times should be interpreted as a requested time change. When the status is accepted, the times can either be the time of the appointment (as a confirmation of the time) or can be empty.", 0, 1, participantStatus);
        case 950398559: /*comment*/  return new Property("comment", "string", "Additional comments about the appointment.", 0, 1, comment);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1474995297: /*appointment*/ return this.appointment == null ? new Base[0] : new Base[] {this.appointment}; // Reference
        case 109757538: /*start*/ return this.start == null ? new Base[0] : new Base[] {this.start}; // InstantType
        case 100571: /*end*/ return this.end == null ? new Base[0] : new Base[] {this.end}; // InstantType
        case 841294093: /*participantType*/ return this.participantType == null ? new Base[0] : this.participantType.toArray(new Base[this.participantType.size()]); // CodeableConcept
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : new Base[] {this.actor}; // Reference
        case 996096261: /*participantStatus*/ return this.participantStatus == null ? new Base[0] : new Base[] {this.participantStatus}; // Enumeration<ParticipationStatus>
        case 950398559: /*comment*/ return this.comment == null ? new Base[0] : new Base[] {this.comment}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -1474995297: // appointment
          this.appointment = TypeConvertor.castToReference(value); // Reference
          return value;
        case 109757538: // start
          this.start = TypeConvertor.castToInstant(value); // InstantType
          return value;
        case 100571: // end
          this.end = TypeConvertor.castToInstant(value); // InstantType
          return value;
        case 841294093: // participantType
          this.getParticipantType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 92645877: // actor
          this.actor = TypeConvertor.castToReference(value); // Reference
          return value;
        case 996096261: // participantStatus
          value = new ParticipationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.participantStatus = (Enumeration) value; // Enumeration<ParticipationStatus>
          return value;
        case 950398559: // comment
          this.comment = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("appointment")) {
          this.appointment = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("start")) {
          this.start = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("end")) {
          this.end = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("participantType")) {
          this.getParticipantType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("actor")) {
          this.actor = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("participantStatus")) {
          value = new ParticipationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.participantStatus = (Enumeration) value; // Enumeration<ParticipationStatus>
        } else if (name.equals("comment")) {
          this.comment = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1474995297:  return getAppointment();
        case 109757538:  return getStartElement();
        case 100571:  return getEndElement();
        case 841294093:  return addParticipantType(); 
        case 92645877:  return getActor();
        case 996096261:  return getParticipantStatusElement();
        case 950398559:  return getCommentElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1474995297: /*appointment*/ return new String[] {"Reference"};
        case 109757538: /*start*/ return new String[] {"instant"};
        case 100571: /*end*/ return new String[] {"instant"};
        case 841294093: /*participantType*/ return new String[] {"CodeableConcept"};
        case 92645877: /*actor*/ return new String[] {"Reference"};
        case 996096261: /*participantStatus*/ return new String[] {"code"};
        case 950398559: /*comment*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("appointment")) {
          this.appointment = new Reference();
          return this.appointment;
        }
        else if (name.equals("start")) {
          throw new FHIRException("Cannot call addChild on a primitive type AppointmentResponse.start");
        }
        else if (name.equals("end")) {
          throw new FHIRException("Cannot call addChild on a primitive type AppointmentResponse.end");
        }
        else if (name.equals("participantType")) {
          return addParticipantType();
        }
        else if (name.equals("actor")) {
          this.actor = new Reference();
          return this.actor;
        }
        else if (name.equals("participantStatus")) {
          throw new FHIRException("Cannot call addChild on a primitive type AppointmentResponse.participantStatus");
        }
        else if (name.equals("comment")) {
          throw new FHIRException("Cannot call addChild on a primitive type AppointmentResponse.comment");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "AppointmentResponse";

  }

      public AppointmentResponse copy() {
        AppointmentResponse dst = new AppointmentResponse();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AppointmentResponse dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.appointment = appointment == null ? null : appointment.copy();
        dst.start = start == null ? null : start.copy();
        dst.end = end == null ? null : end.copy();
        if (participantType != null) {
          dst.participantType = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : participantType)
            dst.participantType.add(i.copy());
        };
        dst.actor = actor == null ? null : actor.copy();
        dst.participantStatus = participantStatus == null ? null : participantStatus.copy();
        dst.comment = comment == null ? null : comment.copy();
      }

      protected AppointmentResponse typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AppointmentResponse))
          return false;
        AppointmentResponse o = (AppointmentResponse) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(appointment, o.appointment, true)
           && compareDeep(start, o.start, true) && compareDeep(end, o.end, true) && compareDeep(participantType, o.participantType, true)
           && compareDeep(actor, o.actor, true) && compareDeep(participantStatus, o.participantStatus, true)
           && compareDeep(comment, o.comment, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AppointmentResponse))
          return false;
        AppointmentResponse o = (AppointmentResponse) other_;
        return compareValues(start, o.start, true) && compareValues(end, o.end, true) && compareValues(participantStatus, o.participantStatus, true)
           && compareValues(comment, o.comment, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, appointment, start
          , end, participantType, actor, participantStatus, comment);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.AppointmentResponse;
   }


}

