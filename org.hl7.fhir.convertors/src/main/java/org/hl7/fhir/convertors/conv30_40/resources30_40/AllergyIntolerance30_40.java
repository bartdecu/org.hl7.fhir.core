package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Annotation30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

public class AllergyIntolerance30_40 {

  public static org.hl7.fhir.dstu3.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.r4.model.AllergyIntolerance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.AllergyIntolerance tgt = new org.hl7.fhir.dstu3.model.AllergyIntolerance();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(convertAllergyIntoleranceClinicalStatus(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(convertAllergyIntoleranceVerificationStatus(src.getVerificationStatus()));
    if (src.hasType())
      tgt.setTypeElement(convertAllergyIntoleranceType(src.getTypeElement()));
    tgt.setCategory(src.getCategory().stream()
      .map(AllergyIntolerance30_40::convertAllergyIntoleranceCategory)
      .collect(Collectors.toList()));
    if (src.hasCriticality())
      tgt.setCriticalityElement(convertAllergyIntoleranceCriticality(src.getCriticalityElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getOnset()));
    if (src.hasRecordedDate())
      tgt.setAssertedDateElement(DateTime30_40.convertDateTime(src.getRecordedDateElement()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference30_40.convertReference(src.getRecorder()));
    if (src.hasAsserter())
      tgt.setAsserter(Reference30_40.convertReference(src.getAsserter()));
    if (src.hasLastOccurrence())
      tgt.setLastOccurrenceElement(DateTime30_40.convertDateTime(src.getLastOccurrenceElement()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent t : src.getReaction())
      tgt.addReaction(convertAllergyIntoleranceReactionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.dstu3.model.AllergyIntolerance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AllergyIntolerance tgt = new org.hl7.fhir.r4.model.AllergyIntolerance();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(convertAllergyIntoleranceClinicalStatus(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(convertAllergyIntoleranceVerificationStatus(src.getVerificationStatus()));
    if (src.hasType())
      tgt.setTypeElement(convertAllergyIntoleranceType(src.getTypeElement()));
    tgt.setCategory(src.getCategory().stream()
      .map(AllergyIntolerance30_40::convertAllergyIntoleranceCategory)
      .collect(Collectors.toList()));
    if (src.hasCriticality())
      tgt.setCriticalityElement(convertAllergyIntoleranceCriticality(src.getCriticalityElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getOnset()));
    if (src.hasAssertedDate())
      tgt.setRecordedDateElement(DateTime30_40.convertDateTime(src.getAssertedDateElement()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference30_40.convertReference(src.getRecorder()));
    if (src.hasAsserter())
      tgt.setAsserter(Reference30_40.convertReference(src.getAsserter()));
    if (src.hasLastOccurrence())
      tgt.setLastOccurrenceElement(DateTime30_40.convertDateTime(src.getLastOccurrenceElement()));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    for (org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent t : src.getReaction())
      tgt.addReaction(convertAllergyIntoleranceReactionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory> convertAllergyIntoleranceCategory(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategoryEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case FOOD:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.FOOD);
        break;
      case MEDICATION:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.MEDICATION);
        break;
      case ENVIRONMENT:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.ENVIRONMENT);
        break;
      case BIOLOGIC:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.BIOLOGIC);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory> convertAllergyIntoleranceCategory(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategoryEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case FOOD:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.FOOD);
        break;
      case MEDICATION:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.MEDICATION);
        break;
      case ENVIRONMENT:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.ENVIRONMENT);
        break;
      case BIOLOGIC:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.BIOLOGIC);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus convertAllergyIntoleranceClinicalStatus(org.hl7.fhir.r4.model.CodeableConcept src) throws FHIRException {
    if (src == null)
      return null;
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "active"))
      return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.ACTIVE;
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "inactive"))
      return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.INACTIVE;
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "resolved"))
      return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.RESOLVED;
    return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.NULL;
  }

  static public org.hl7.fhir.r4.model.CodeableConcept convertAllergyIntoleranceClinicalStatus(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
      case ACTIVE:
        return new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical").setCode("active"));
      case INACTIVE:
        return new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical").setCode("inactive"));
      case RESOLVED:
        return new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical").setCode("resolved"));
      default:
        return null;
    }
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality> convertAllergyIntoleranceCriticality(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticalityEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case LOW:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.LOW);
        break;
      case HIGH:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.HIGH);
        break;
      case UNABLETOASSESS:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.UNABLETOASSESS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality> convertAllergyIntoleranceCriticality(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticalityEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case LOW:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.LOW);
        break;
      case HIGH:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.HIGH);
        break;
      case UNABLETOASSESS:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.UNABLETOASSESS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent convertAllergyIntoleranceReactionComponent(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept30_40.convertCodeableConcept(src.getSubstance()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getManifestation())
      tgt.addManifestation(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(DateTime30_40.convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertAllergyIntoleranceSeverity(src.getSeverityElement()));
    if (src.hasExposureRoute())
      tgt.setExposureRoute(CodeableConcept30_40.convertCodeableConcept(src.getExposureRoute()));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent convertAllergyIntoleranceReactionComponent(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept30_40.convertCodeableConcept(src.getSubstance()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getManifestation())
      tgt.addManifestation(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(DateTime30_40.convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertAllergyIntoleranceSeverity(src.getSeverityElement()));
    if (src.hasExposureRoute())
      tgt.setExposureRoute(CodeableConcept30_40.convertCodeableConcept(src.getExposureRoute()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity> convertAllergyIntoleranceSeverity(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverityEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case MILD:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity.MILD);
        break;
      case MODERATE:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity.MODERATE);
        break;
      case SEVERE:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity.SEVERE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity> convertAllergyIntoleranceSeverity(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverityEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case MILD:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity.MILD);
        break;
      case MODERATE:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity.MODERATE);
        break;
      case SEVERE:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity.SEVERE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType> convertAllergyIntoleranceType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case ALLERGY:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType.ALLERGY);
        break;
      case INTOLERANCE:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType.INTOLERANCE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType> convertAllergyIntoleranceType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case ALLERGY:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType.ALLERGY);
        break;
      case INTOLERANCE:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType.INTOLERANCE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.CodeableConcept convertAllergyIntoleranceVerificationStatus(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
      case UNCONFIRMED:
        return new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification").setCode("unconfirmed"));
      case CONFIRMED:
        return new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification").setCode("confirmed"));
      case REFUTED:
        return new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification").setCode("refuted"));
      case ENTEREDINERROR:
        return new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification").setCode("entered-in-error"));
      default:
        return null;
    }
  }

  static public org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus convertAllergyIntoleranceVerificationStatus(org.hl7.fhir.r4.model.CodeableConcept src) throws FHIRException {
    if (src == null)
      return null;
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification", "unconfirmed"))
      return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.UNCONFIRMED;
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification", "confirmed"))
      return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.CONFIRMED;
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification", "refuted"))
      return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.REFUTED;
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification", "entered-in-error"))
      return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.ENTEREDINERROR;
    return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.NULL;
  }
}