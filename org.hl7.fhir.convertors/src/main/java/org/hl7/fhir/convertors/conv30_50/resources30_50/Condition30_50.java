package org.hl7.fhir.convertors.conv30_50.resources30_50;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Annotation30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;

public class Condition30_50 {

  private static final String CODE_SYSTEM_LEGACY_CONDITION_VER_CLINICAL_URL = "http://hl7.org/fhir/condition-ver-status";

  private static final String CODE_SYSTEM_CONDITION_VER_CLINICAL_URL = "http://terminology.hl7.org/CodeSystem/condition-ver-status";

  private static final String CODE_SYSTEM_LEGACY_CONDITION_CLINICAL_URL = "http://hl7.org/fhir/condition-clinical";

  private static final String CODE_SYSTEM_CONDITION_CLINICAL_URL = "http://terminology.hl7.org/CodeSystem/condition-clinical";

  public static org.hl7.fhir.r5.model.Condition convertCondition(org.hl7.fhir.dstu3.model.Condition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Condition tgt = new org.hl7.fhir.r5.model.Condition();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(convertConditionClinicalStatus(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(convertConditionVerificationStatus(src.getVerificationStatus()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasSeverity())
      tgt.setSeverity(CodeableConcept30_50.convertCodeableConcept(src.getSeverity()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference30_50.convertReference(src.getContext()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getOnset()));
    if (src.hasAbatement())
      tgt.setAbatement(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getAbatement()));
    if (src.hasAssertedDate())
      tgt.setRecordedDateElement(DateTime30_50.convertDateTime(src.getAssertedDateElement()));
    if (src.hasAsserter())
      tgt.addParticipant().setFunction(new CodeableConcept(new Coding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "informant", "Informant"))).setActor(Reference30_50.convertReference(src.getAsserter()));
    if (src.hasStage())
      tgt.addStage(convertConditionStageComponent(src.getStage()));
    for (org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent t : src.getEvidence())
      tgt.getEvidence().addAll(convertConditionEvidenceComponent(t));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Condition convertCondition(org.hl7.fhir.r5.model.Condition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Condition tgt = new org.hl7.fhir.dstu3.model.Condition();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(convertConditionClinicalStatus(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(convertConditionVerificationStatus(src.getVerificationStatus()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasSeverity())
      tgt.setSeverity(CodeableConcept30_50.convertCodeableConcept(src.getSeverity()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference30_50.convertReference(src.getEncounter()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getOnset()));
    if (src.hasAbatement())
      tgt.setAbatement(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getAbatement()));
    if (src.hasRecordedDate())
      tgt.setAssertedDateElement(DateTime30_50.convertDateTime(src.getRecordedDateElement()));
    for (org.hl7.fhir.r5.model.Condition.ConditionParticipantComponent t : src.getParticipant()) {
      if (t.getFunction().hasCoding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "informant"))
        tgt.setAsserter(Reference30_50.convertReference(t.getActor()));
    }
    if (src.hasStage())
      tgt.setStage(convertConditionStageComponent(src.getStageFirstRep()));
    for (org.hl7.fhir.r5.model.CodeableReference t : src.getEvidence())
      tgt.addEvidence(convertConditionEvidenceComponent(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Condition.ConditionClinicalStatus convertConditionClinicalStatus(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null)
      return null;
    if (src.hasCoding(CODE_SYSTEM_CONDITION_CLINICAL_URL, "active") || src.hasCoding(CODE_SYSTEM_LEGACY_CONDITION_CLINICAL_URL, "active"))
      return org.hl7.fhir.dstu3.model.Condition.ConditionClinicalStatus.ACTIVE;
    if (src.hasCoding(CODE_SYSTEM_CONDITION_CLINICAL_URL, "recurrence") || src.hasCoding(CODE_SYSTEM_LEGACY_CONDITION_CLINICAL_URL, "recurrence"))
      return org.hl7.fhir.dstu3.model.Condition.ConditionClinicalStatus.RECURRENCE;
    if (src.hasCoding(CODE_SYSTEM_CONDITION_CLINICAL_URL, "inactive") || src.hasCoding(CODE_SYSTEM_LEGACY_CONDITION_CLINICAL_URL, "inactive"))
      return org.hl7.fhir.dstu3.model.Condition.ConditionClinicalStatus.INACTIVE;
    if (src.hasCoding(CODE_SYSTEM_CONDITION_CLINICAL_URL, "remission") || src.hasCoding(CODE_SYSTEM_LEGACY_CONDITION_CLINICAL_URL, "remission"))
      return org.hl7.fhir.dstu3.model.Condition.ConditionClinicalStatus.REMISSION;
    if (src.hasCoding(CODE_SYSTEM_CONDITION_CLINICAL_URL, "resolved") || src.hasCoding(CODE_SYSTEM_LEGACY_CONDITION_CLINICAL_URL, "resolved"))
      return org.hl7.fhir.dstu3.model.Condition.ConditionClinicalStatus.RESOLVED;
    return org.hl7.fhir.dstu3.model.Condition.ConditionClinicalStatus.NULL;
  }

  static public org.hl7.fhir.r5.model.CodeableConcept convertConditionClinicalStatus(org.hl7.fhir.dstu3.model.Condition.ConditionClinicalStatus src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CodeableConcept cc = new org.hl7.fhir.r5.model.CodeableConcept();
    switch (src) {
      case ACTIVE:
        cc.addCoding().setSystem(CODE_SYSTEM_CONDITION_CLINICAL_URL).setCode("active");
        return cc;
      case RECURRENCE:
        cc.addCoding().setSystem(CODE_SYSTEM_CONDITION_CLINICAL_URL).setCode("recurrence");
        return cc;
      case INACTIVE:
        cc.addCoding().setSystem(CODE_SYSTEM_CONDITION_CLINICAL_URL).setCode("inactive");
        return cc;
      case REMISSION:
        cc.addCoding().setSystem(CODE_SYSTEM_CONDITION_CLINICAL_URL).setCode("remission");
        return cc;
      case RESOLVED:
        cc.addCoding().setSystem(CODE_SYSTEM_CONDITION_CLINICAL_URL).setCode("resolved");
        return cc;
      default:
        return null;
    }
  }

  public static List<org.hl7.fhir.r5.model.CodeableReference> convertConditionEvidenceComponent(org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    List<org.hl7.fhir.r5.model.CodeableReference> list = new ArrayList<>();
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCode()) {
      org.hl7.fhir.r5.model.CodeableReference tgt = new org.hl7.fhir.r5.model.CodeableReference();
      ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
      tgt.setConcept(CodeableConcept30_50.convertCodeableConcept(t));
      list.add(tgt);
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getDetail()) {
      org.hl7.fhir.r5.model.CodeableReference tgt = new org.hl7.fhir.r5.model.CodeableReference();
      ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
      tgt.setReference(Reference30_50.convertReference(t));
      list.add(tgt);
    }
    return list;
  }

  public static org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent convertConditionEvidenceComponent(org.hl7.fhir.r5.model.CodeableReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent tgt = new org.hl7.fhir.dstu3.model.Condition.ConditionEvidenceComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasConcept())
      tgt.addCode(CodeableConcept30_50.convertCodeableConcept(src.getConcept()));
    if (src.hasReference())
      tgt.addDetail(Reference30_50.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Condition.ConditionStageComponent convertConditionStageComponent(org.hl7.fhir.r5.model.Condition.ConditionStageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Condition.ConditionStageComponent tgt = new org.hl7.fhir.dstu3.model.Condition.ConditionStageComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasSummary())
      tgt.setSummary(CodeableConcept30_50.convertCodeableConcept(src.getSummary()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAssessment()) tgt.addAssessment(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Condition.ConditionStageComponent convertConditionStageComponent(org.hl7.fhir.dstu3.model.Condition.ConditionStageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Condition.ConditionStageComponent tgt = new org.hl7.fhir.r5.model.Condition.ConditionStageComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasSummary())
      tgt.setSummary(CodeableConcept30_50.convertCodeableConcept(src.getSummary()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAssessment())
      tgt.addAssessment(Reference30_50.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus convertConditionVerificationStatus(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null)
      return null;
    if (src.hasCoding(CODE_SYSTEM_CONDITION_VER_CLINICAL_URL, "provisional") || src.hasCoding(CODE_SYSTEM_LEGACY_CONDITION_VER_CLINICAL_URL, "provisional"))
      return org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.PROVISIONAL;
    if (src.hasCoding(CODE_SYSTEM_CONDITION_VER_CLINICAL_URL, "differential") || src.hasCoding(CODE_SYSTEM_LEGACY_CONDITION_VER_CLINICAL_URL, "differential"))
      return org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.DIFFERENTIAL;
    if (src.hasCoding(CODE_SYSTEM_CONDITION_VER_CLINICAL_URL, "confirmed") || src.hasCoding(CODE_SYSTEM_LEGACY_CONDITION_VER_CLINICAL_URL, "confirmed"))
      return org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.CONFIRMED;
    if (src.hasCoding(CODE_SYSTEM_CONDITION_VER_CLINICAL_URL, "refuted") || src.hasCoding(CODE_SYSTEM_LEGACY_CONDITION_VER_CLINICAL_URL, "refuted"))
      return org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.REFUTED;
    if (src.hasCoding(CODE_SYSTEM_CONDITION_VER_CLINICAL_URL, "entered-in-error") || src.hasCoding(CODE_SYSTEM_LEGACY_CONDITION_VER_CLINICAL_URL, "entered-in-error"))
      return org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.ENTEREDINERROR;
    return org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus.NULL;
  }

  static public org.hl7.fhir.r5.model.CodeableConcept convertConditionVerificationStatus(org.hl7.fhir.dstu3.model.Condition.ConditionVerificationStatus src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CodeableConcept cc = new org.hl7.fhir.r5.model.CodeableConcept();
    switch (src) {
      case PROVISIONAL:
        cc.addCoding().setSystem(CODE_SYSTEM_CONDITION_VER_CLINICAL_URL).setCode("provisional");
        return cc;
      case DIFFERENTIAL:
        cc.addCoding().setSystem(CODE_SYSTEM_CONDITION_VER_CLINICAL_URL).setCode("differential");
        return cc;
      case CONFIRMED:
        cc.addCoding().setSystem(CODE_SYSTEM_CONDITION_VER_CLINICAL_URL).setCode("confirmed");
        return cc;
      case REFUTED:
        cc.addCoding().setSystem(CODE_SYSTEM_CONDITION_VER_CLINICAL_URL).setCode("refuted");
        return cc;
      case ENTEREDINERROR:
        cc.addCoding().setSystem(CODE_SYSTEM_CONDITION_VER_CLINICAL_URL).setCode("entered-in-error");
        return cc;
      default:
        return null;
    }
  }
}