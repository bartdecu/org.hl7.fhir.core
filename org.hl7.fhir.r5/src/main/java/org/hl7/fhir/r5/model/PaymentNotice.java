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
 * This resource provides the status of the payment for goods and services rendered, and the request and response resource references.
 */
@ResourceDef(name="PaymentNotice", profile="http://hl7.org/fhir/StructureDefinition/PaymentNotice")
public class PaymentNotice extends DomainResource {

    /**
     * A unique identifier assigned to this payment notice.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Business Identifier for the payment noctice", formalDefinition="A unique identifier assigned to this payment notice." )
    protected List<Identifier> identifier;

    /**
     * The status of the resource instance.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | cancelled | draft | entered-in-error", formalDefinition="The status of the resource instance." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/fm-status")
    protected Enumeration<FinancialResourceStatusCodes> status;

    /**
     * Reference of resource for which payment is being made.
     */
    @Child(name = "request", type = {Reference.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Request reference", formalDefinition="Reference of resource for which payment is being made." )
    protected Reference request;

    /**
     * Reference of response to resource for which payment is being made.
     */
    @Child(name = "response", type = {Reference.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Response reference", formalDefinition="Reference of response to resource for which payment is being made." )
    protected Reference response;

    /**
     * The date when this resource was created.
     */
    @Child(name = "created", type = {DateTimeType.class}, order=4, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Creation date", formalDefinition="The date when this resource was created." )
    protected DateTimeType created;

    /**
     * The practitioner who is responsible for the services rendered to the patient.
     */
    @Child(name = "provider", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Responsible practitioner", formalDefinition="The practitioner who is responsible for the services rendered to the patient." )
    protected Reference provider;

    /**
     * A reference to the payment which is the subject of this notice.
     */
    @Child(name = "payment", type = {PaymentReconciliation.class}, order=6, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Payment reference", formalDefinition="A reference to the payment which is the subject of this notice." )
    protected Reference payment;

    /**
     * The date when the above payment action occurred.
     */
    @Child(name = "paymentDate", type = {DateType.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Payment or clearing date", formalDefinition="The date when the above payment action occurred." )
    protected DateType paymentDate;

    /**
     * The party who will receive or has received payment that is the subject of this notification.
     */
    @Child(name = "payee", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Party being paid", formalDefinition="The party who will receive or has received payment that is the subject of this notification." )
    protected Reference payee;

    /**
     * The party who is notified of the payment status.
     */
    @Child(name = "recipient", type = {Organization.class}, order=9, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Party being notified", formalDefinition="The party who is notified of the payment status." )
    protected Reference recipient;

    /**
     * The amount sent to the payee.
     */
    @Child(name = "amount", type = {Money.class}, order=10, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Monetary amount of the payment", formalDefinition="The amount sent to the payee." )
    protected Money amount;

    /**
     * A code indicating whether payment has been sent or cleared.
     */
    @Child(name = "paymentStatus", type = {CodeableConcept.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Issued or cleared Status of the payment", formalDefinition="A code indicating whether payment has been sent or cleared." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/payment-status")
    protected CodeableConcept paymentStatus;

    private static final long serialVersionUID = 1832126720L;

  /**
   * Constructor
   */
    public PaymentNotice() {
      super();
    }

  /**
   * Constructor
   */
    public PaymentNotice(FinancialResourceStatusCodes status, Date created, Reference payment, Reference recipient, Money amount) {
      super();
      this.setStatus(status);
      this.setCreated(created);
      this.setPayment(payment);
      this.setRecipient(recipient);
      this.setAmount(amount);
    }

    /**
     * @return {@link #identifier} (A unique identifier assigned to this payment notice.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PaymentNotice setIdentifier(List<Identifier> theIdentifier) { 
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

    public PaymentNotice addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (The status of the resource instance.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<FinancialResourceStatusCodes> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentNotice.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<FinancialResourceStatusCodes>(new FinancialResourceStatusCodesEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of the resource instance.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public PaymentNotice setStatusElement(Enumeration<FinancialResourceStatusCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the resource instance.
     */
    public FinancialResourceStatusCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the resource instance.
     */
    public PaymentNotice setStatus(FinancialResourceStatusCodes value) { 
        if (this.status == null)
          this.status = new Enumeration<FinancialResourceStatusCodes>(new FinancialResourceStatusCodesEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #request} (Reference of resource for which payment is being made.)
     */
    public Reference getRequest() { 
      if (this.request == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentNotice.request");
        else if (Configuration.doAutoCreate())
          this.request = new Reference(); // cc
      return this.request;
    }

    public boolean hasRequest() { 
      return this.request != null && !this.request.isEmpty();
    }

    /**
     * @param value {@link #request} (Reference of resource for which payment is being made.)
     */
    public PaymentNotice setRequest(Reference value) { 
      this.request = value;
      return this;
    }

    /**
     * @return {@link #response} (Reference of response to resource for which payment is being made.)
     */
    public Reference getResponse() { 
      if (this.response == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentNotice.response");
        else if (Configuration.doAutoCreate())
          this.response = new Reference(); // cc
      return this.response;
    }

    public boolean hasResponse() { 
      return this.response != null && !this.response.isEmpty();
    }

    /**
     * @param value {@link #response} (Reference of response to resource for which payment is being made.)
     */
    public PaymentNotice setResponse(Reference value) { 
      this.response = value;
      return this;
    }

    /**
     * @return {@link #created} (The date when this resource was created.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public DateTimeType getCreatedElement() { 
      if (this.created == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentNotice.created");
        else if (Configuration.doAutoCreate())
          this.created = new DateTimeType(); // bb
      return this.created;
    }

    public boolean hasCreatedElement() { 
      return this.created != null && !this.created.isEmpty();
    }

    public boolean hasCreated() { 
      return this.created != null && !this.created.isEmpty();
    }

    /**
     * @param value {@link #created} (The date when this resource was created.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public PaymentNotice setCreatedElement(DateTimeType value) { 
      this.created = value;
      return this;
    }

    /**
     * @return The date when this resource was created.
     */
    public Date getCreated() { 
      return this.created == null ? null : this.created.getValue();
    }

    /**
     * @param value The date when this resource was created.
     */
    public PaymentNotice setCreated(Date value) { 
        if (this.created == null)
          this.created = new DateTimeType();
        this.created.setValue(value);
      return this;
    }

    /**
     * @return {@link #provider} (The practitioner who is responsible for the services rendered to the patient.)
     */
    public Reference getProvider() { 
      if (this.provider == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentNotice.provider");
        else if (Configuration.doAutoCreate())
          this.provider = new Reference(); // cc
      return this.provider;
    }

    public boolean hasProvider() { 
      return this.provider != null && !this.provider.isEmpty();
    }

    /**
     * @param value {@link #provider} (The practitioner who is responsible for the services rendered to the patient.)
     */
    public PaymentNotice setProvider(Reference value) { 
      this.provider = value;
      return this;
    }

    /**
     * @return {@link #payment} (A reference to the payment which is the subject of this notice.)
     */
    public Reference getPayment() { 
      if (this.payment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentNotice.payment");
        else if (Configuration.doAutoCreate())
          this.payment = new Reference(); // cc
      return this.payment;
    }

    public boolean hasPayment() { 
      return this.payment != null && !this.payment.isEmpty();
    }

    /**
     * @param value {@link #payment} (A reference to the payment which is the subject of this notice.)
     */
    public PaymentNotice setPayment(Reference value) { 
      this.payment = value;
      return this;
    }

    /**
     * @return {@link #paymentDate} (The date when the above payment action occurred.). This is the underlying object with id, value and extensions. The accessor "getPaymentDate" gives direct access to the value
     */
    public DateType getPaymentDateElement() { 
      if (this.paymentDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentNotice.paymentDate");
        else if (Configuration.doAutoCreate())
          this.paymentDate = new DateType(); // bb
      return this.paymentDate;
    }

    public boolean hasPaymentDateElement() { 
      return this.paymentDate != null && !this.paymentDate.isEmpty();
    }

    public boolean hasPaymentDate() { 
      return this.paymentDate != null && !this.paymentDate.isEmpty();
    }

    /**
     * @param value {@link #paymentDate} (The date when the above payment action occurred.). This is the underlying object with id, value and extensions. The accessor "getPaymentDate" gives direct access to the value
     */
    public PaymentNotice setPaymentDateElement(DateType value) { 
      this.paymentDate = value;
      return this;
    }

    /**
     * @return The date when the above payment action occurred.
     */
    public Date getPaymentDate() { 
      return this.paymentDate == null ? null : this.paymentDate.getValue();
    }

    /**
     * @param value The date when the above payment action occurred.
     */
    public PaymentNotice setPaymentDate(Date value) { 
      if (value == null)
        this.paymentDate = null;
      else {
        if (this.paymentDate == null)
          this.paymentDate = new DateType();
        this.paymentDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #payee} (The party who will receive or has received payment that is the subject of this notification.)
     */
    public Reference getPayee() { 
      if (this.payee == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentNotice.payee");
        else if (Configuration.doAutoCreate())
          this.payee = new Reference(); // cc
      return this.payee;
    }

    public boolean hasPayee() { 
      return this.payee != null && !this.payee.isEmpty();
    }

    /**
     * @param value {@link #payee} (The party who will receive or has received payment that is the subject of this notification.)
     */
    public PaymentNotice setPayee(Reference value) { 
      this.payee = value;
      return this;
    }

    /**
     * @return {@link #recipient} (The party who is notified of the payment status.)
     */
    public Reference getRecipient() { 
      if (this.recipient == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentNotice.recipient");
        else if (Configuration.doAutoCreate())
          this.recipient = new Reference(); // cc
      return this.recipient;
    }

    public boolean hasRecipient() { 
      return this.recipient != null && !this.recipient.isEmpty();
    }

    /**
     * @param value {@link #recipient} (The party who is notified of the payment status.)
     */
    public PaymentNotice setRecipient(Reference value) { 
      this.recipient = value;
      return this;
    }

    /**
     * @return {@link #amount} (The amount sent to the payee.)
     */
    public Money getAmount() { 
      if (this.amount == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentNotice.amount");
        else if (Configuration.doAutoCreate())
          this.amount = new Money(); // cc
      return this.amount;
    }

    public boolean hasAmount() { 
      return this.amount != null && !this.amount.isEmpty();
    }

    /**
     * @param value {@link #amount} (The amount sent to the payee.)
     */
    public PaymentNotice setAmount(Money value) { 
      this.amount = value;
      return this;
    }

    /**
     * @return {@link #paymentStatus} (A code indicating whether payment has been sent or cleared.)
     */
    public CodeableConcept getPaymentStatus() { 
      if (this.paymentStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentNotice.paymentStatus");
        else if (Configuration.doAutoCreate())
          this.paymentStatus = new CodeableConcept(); // cc
      return this.paymentStatus;
    }

    public boolean hasPaymentStatus() { 
      return this.paymentStatus != null && !this.paymentStatus.isEmpty();
    }

    /**
     * @param value {@link #paymentStatus} (A code indicating whether payment has been sent or cleared.)
     */
    public PaymentNotice setPaymentStatus(CodeableConcept value) { 
      this.paymentStatus = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A unique identifier assigned to this payment notice.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The status of the resource instance.", 0, 1, status));
        children.add(new Property("request", "Reference(Any)", "Reference of resource for which payment is being made.", 0, 1, request));
        children.add(new Property("response", "Reference(Any)", "Reference of response to resource for which payment is being made.", 0, 1, response));
        children.add(new Property("created", "dateTime", "The date when this resource was created.", 0, 1, created));
        children.add(new Property("provider", "Reference(Practitioner|PractitionerRole|Organization)", "The practitioner who is responsible for the services rendered to the patient.", 0, 1, provider));
        children.add(new Property("payment", "Reference(PaymentReconciliation)", "A reference to the payment which is the subject of this notice.", 0, 1, payment));
        children.add(new Property("paymentDate", "date", "The date when the above payment action occurred.", 0, 1, paymentDate));
        children.add(new Property("payee", "Reference(Practitioner|PractitionerRole|Organization)", "The party who will receive or has received payment that is the subject of this notification.", 0, 1, payee));
        children.add(new Property("recipient", "Reference(Organization)", "The party who is notified of the payment status.", 0, 1, recipient));
        children.add(new Property("amount", "Money", "The amount sent to the payee.", 0, 1, amount));
        children.add(new Property("paymentStatus", "CodeableConcept", "A code indicating whether payment has been sent or cleared.", 0, 1, paymentStatus));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A unique identifier assigned to this payment notice.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the resource instance.", 0, 1, status);
        case 1095692943: /*request*/  return new Property("request", "Reference(Any)", "Reference of resource for which payment is being made.", 0, 1, request);
        case -340323263: /*response*/  return new Property("response", "Reference(Any)", "Reference of response to resource for which payment is being made.", 0, 1, response);
        case 1028554472: /*created*/  return new Property("created", "dateTime", "The date when this resource was created.", 0, 1, created);
        case -987494927: /*provider*/  return new Property("provider", "Reference(Practitioner|PractitionerRole|Organization)", "The practitioner who is responsible for the services rendered to the patient.", 0, 1, provider);
        case -786681338: /*payment*/  return new Property("payment", "Reference(PaymentReconciliation)", "A reference to the payment which is the subject of this notice.", 0, 1, payment);
        case -1540873516: /*paymentDate*/  return new Property("paymentDate", "date", "The date when the above payment action occurred.", 0, 1, paymentDate);
        case 106443592: /*payee*/  return new Property("payee", "Reference(Practitioner|PractitionerRole|Organization)", "The party who will receive or has received payment that is the subject of this notification.", 0, 1, payee);
        case 820081177: /*recipient*/  return new Property("recipient", "Reference(Organization)", "The party who is notified of the payment status.", 0, 1, recipient);
        case -1413853096: /*amount*/  return new Property("amount", "Money", "The amount sent to the payee.", 0, 1, amount);
        case 1430704536: /*paymentStatus*/  return new Property("paymentStatus", "CodeableConcept", "A code indicating whether payment has been sent or cleared.", 0, 1, paymentStatus);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<FinancialResourceStatusCodes>
        case 1095692943: /*request*/ return this.request == null ? new Base[0] : new Base[] {this.request}; // Reference
        case -340323263: /*response*/ return this.response == null ? new Base[0] : new Base[] {this.response}; // Reference
        case 1028554472: /*created*/ return this.created == null ? new Base[0] : new Base[] {this.created}; // DateTimeType
        case -987494927: /*provider*/ return this.provider == null ? new Base[0] : new Base[] {this.provider}; // Reference
        case -786681338: /*payment*/ return this.payment == null ? new Base[0] : new Base[] {this.payment}; // Reference
        case -1540873516: /*paymentDate*/ return this.paymentDate == null ? new Base[0] : new Base[] {this.paymentDate}; // DateType
        case 106443592: /*payee*/ return this.payee == null ? new Base[0] : new Base[] {this.payee}; // Reference
        case 820081177: /*recipient*/ return this.recipient == null ? new Base[0] : new Base[] {this.recipient}; // Reference
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // Money
        case 1430704536: /*paymentStatus*/ return this.paymentStatus == null ? new Base[0] : new Base[] {this.paymentStatus}; // CodeableConcept
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
          value = new FinancialResourceStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FinancialResourceStatusCodes>
          return value;
        case 1095692943: // request
          this.request = TypeConvertor.castToReference(value); // Reference
          return value;
        case -340323263: // response
          this.response = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1028554472: // created
          this.created = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -987494927: // provider
          this.provider = TypeConvertor.castToReference(value); // Reference
          return value;
        case -786681338: // payment
          this.payment = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1540873516: // paymentDate
          this.paymentDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case 106443592: // payee
          this.payee = TypeConvertor.castToReference(value); // Reference
          return value;
        case 820081177: // recipient
          this.recipient = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1413853096: // amount
          this.amount = TypeConvertor.castToMoney(value); // Money
          return value;
        case 1430704536: // paymentStatus
          this.paymentStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new FinancialResourceStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FinancialResourceStatusCodes>
        } else if (name.equals("request")) {
          this.request = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("response")) {
          this.response = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("created")) {
          this.created = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("provider")) {
          this.provider = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("payment")) {
          this.payment = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("paymentDate")) {
          this.paymentDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("payee")) {
          this.payee = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("recipient")) {
          this.recipient = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("amount")) {
          this.amount = TypeConvertor.castToMoney(value); // Money
        } else if (name.equals("paymentStatus")) {
          this.paymentStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case 1095692943:  return getRequest();
        case -340323263:  return getResponse();
        case 1028554472:  return getCreatedElement();
        case -987494927:  return getProvider();
        case -786681338:  return getPayment();
        case -1540873516:  return getPaymentDateElement();
        case 106443592:  return getPayee();
        case 820081177:  return getRecipient();
        case -1413853096:  return getAmount();
        case 1430704536:  return getPaymentStatus();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 1095692943: /*request*/ return new String[] {"Reference"};
        case -340323263: /*response*/ return new String[] {"Reference"};
        case 1028554472: /*created*/ return new String[] {"dateTime"};
        case -987494927: /*provider*/ return new String[] {"Reference"};
        case -786681338: /*payment*/ return new String[] {"Reference"};
        case -1540873516: /*paymentDate*/ return new String[] {"date"};
        case 106443592: /*payee*/ return new String[] {"Reference"};
        case 820081177: /*recipient*/ return new String[] {"Reference"};
        case -1413853096: /*amount*/ return new String[] {"Money"};
        case 1430704536: /*paymentStatus*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type PaymentNotice.status");
        }
        else if (name.equals("request")) {
          this.request = new Reference();
          return this.request;
        }
        else if (name.equals("response")) {
          this.response = new Reference();
          return this.response;
        }
        else if (name.equals("created")) {
          throw new FHIRException("Cannot call addChild on a primitive type PaymentNotice.created");
        }
        else if (name.equals("provider")) {
          this.provider = new Reference();
          return this.provider;
        }
        else if (name.equals("payment")) {
          this.payment = new Reference();
          return this.payment;
        }
        else if (name.equals("paymentDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type PaymentNotice.paymentDate");
        }
        else if (name.equals("payee")) {
          this.payee = new Reference();
          return this.payee;
        }
        else if (name.equals("recipient")) {
          this.recipient = new Reference();
          return this.recipient;
        }
        else if (name.equals("amount")) {
          this.amount = new Money();
          return this.amount;
        }
        else if (name.equals("paymentStatus")) {
          this.paymentStatus = new CodeableConcept();
          return this.paymentStatus;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "PaymentNotice";

  }

      public PaymentNotice copy() {
        PaymentNotice dst = new PaymentNotice();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PaymentNotice dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.request = request == null ? null : request.copy();
        dst.response = response == null ? null : response.copy();
        dst.created = created == null ? null : created.copy();
        dst.provider = provider == null ? null : provider.copy();
        dst.payment = payment == null ? null : payment.copy();
        dst.paymentDate = paymentDate == null ? null : paymentDate.copy();
        dst.payee = payee == null ? null : payee.copy();
        dst.recipient = recipient == null ? null : recipient.copy();
        dst.amount = amount == null ? null : amount.copy();
        dst.paymentStatus = paymentStatus == null ? null : paymentStatus.copy();
      }

      protected PaymentNotice typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PaymentNotice))
          return false;
        PaymentNotice o = (PaymentNotice) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(request, o.request, true)
           && compareDeep(response, o.response, true) && compareDeep(created, o.created, true) && compareDeep(provider, o.provider, true)
           && compareDeep(payment, o.payment, true) && compareDeep(paymentDate, o.paymentDate, true) && compareDeep(payee, o.payee, true)
           && compareDeep(recipient, o.recipient, true) && compareDeep(amount, o.amount, true) && compareDeep(paymentStatus, o.paymentStatus, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PaymentNotice))
          return false;
        PaymentNotice o = (PaymentNotice) other_;
        return compareValues(status, o.status, true) && compareValues(created, o.created, true) && compareValues(paymentDate, o.paymentDate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, request
          , response, created, provider, payment, paymentDate, payee, recipient, amount
          , paymentStatus);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.PaymentNotice;
   }


}

