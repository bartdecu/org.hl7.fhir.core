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
 * A formal computable definition of an operation (on the RESTful interface) or a named query (using the search interaction).
 */
@ResourceDef(name="OperationDefinition", profile="http://hl7.org/fhir/StructureDefinition/OperationDefinition")
public class OperationDefinition extends CanonicalResource {

    public enum OperationKind {
        /**
         * This operation is invoked as an operation.
         */
        OPERATION, 
        /**
         * This operation is a named query, invoked using the search mechanism.
         */
        QUERY, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static OperationKind fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("operation".equals(codeString))
          return OPERATION;
        if ("query".equals(codeString))
          return QUERY;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown OperationKind code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case OPERATION: return "operation";
            case QUERY: return "query";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case OPERATION: return "http://hl7.org/fhir/operation-kind";
            case QUERY: return "http://hl7.org/fhir/operation-kind";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case OPERATION: return "This operation is invoked as an operation.";
            case QUERY: return "This operation is a named query, invoked using the search mechanism.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case OPERATION: return "Operation";
            case QUERY: return "Query";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class OperationKindEnumFactory implements EnumFactory<OperationKind> {
    public OperationKind fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("operation".equals(codeString))
          return OperationKind.OPERATION;
        if ("query".equals(codeString))
          return OperationKind.QUERY;
        throw new IllegalArgumentException("Unknown OperationKind code '"+codeString+"'");
        }
        public Enumeration<OperationKind> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<OperationKind>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("operation".equals(codeString))
          return new Enumeration<OperationKind>(this, OperationKind.OPERATION);
        if ("query".equals(codeString))
          return new Enumeration<OperationKind>(this, OperationKind.QUERY);
        throw new FHIRException("Unknown OperationKind code '"+codeString+"'");
        }
    public String toCode(OperationKind code) {
      if (code == OperationKind.OPERATION)
        return "operation";
      if (code == OperationKind.QUERY)
        return "query";
      return "?";
      }
    public String toSystem(OperationKind code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class OperationDefinitionParameterComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The name of used to identify the parameter.
         */
        @Child(name = "name", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name in Parameters.parameter.name or in URL", formalDefinition="The name of used to identify the parameter." )
        protected CodeType name;

        /**
         * Whether this is an input or an output parameter.
         */
        @Child(name = "use", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="in | out", formalDefinition="Whether this is an input or an output parameter." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/operation-parameter-use")
        protected Enumeration<OperationParameterUse> use;

        /**
         * The minimum number of times this parameter SHALL appear in the request or response.
         */
        @Child(name = "min", type = {IntegerType.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Minimum Cardinality", formalDefinition="The minimum number of times this parameter SHALL appear in the request or response." )
        protected IntegerType min;

        /**
         * The maximum number of times this element is permitted to appear in the request or response.
         */
        @Child(name = "max", type = {StringType.class}, order=4, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Maximum Cardinality (a number or *)", formalDefinition="The maximum number of times this element is permitted to appear in the request or response." )
        protected StringType max;

        /**
         * Describes the meaning or use of this parameter.
         */
        @Child(name = "documentation", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of meaning/use", formalDefinition="Describes the meaning or use of this parameter." )
        protected StringType documentation;

        /**
         * The type for this parameter.
         */
        @Child(name = "type", type = {CodeType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What type this parameter has", formalDefinition="The type for this parameter." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/all-types")
        protected Enumeration<FHIRAllTypes> type;

        /**
         * Used when the type is "Reference" or "canonical", and identifies a profile structure or implementation Guide that applies to the target of the reference this parameter refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide.
         */
        @Child(name = "targetProfile", type = {CanonicalType.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="If type is Reference | canonical, allowed targets", formalDefinition="Used when the type is \"Reference\" or \"canonical\", and identifies a profile structure or implementation Guide that applies to the target of the reference this parameter refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide." )
        protected List<CanonicalType> targetProfile;

        /**
         * How the parameter is understood as a search parameter. This is only used if the parameter type is 'string'.
         */
        @Child(name = "searchType", type = {CodeType.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="number | date | string | token | reference | composite | quantity | uri | special", formalDefinition="How the parameter is understood as a search parameter. This is only used if the parameter type is 'string'." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/search-param-type")
        protected Enumeration<SearchParamType> searchType;

        /**
         * Binds to a value set if this parameter is coded (code, Coding, CodeableConcept).
         */
        @Child(name = "binding", type = {}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="ValueSet details if this is coded", formalDefinition="Binds to a value set if this parameter is coded (code, Coding, CodeableConcept)." )
        protected OperationDefinitionParameterBindingComponent binding;

        /**
         * Identifies other resource parameters within the operation invocation that are expected to resolve to this resource.
         */
        @Child(name = "referencedFrom", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="References to this parameter", formalDefinition="Identifies other resource parameters within the operation invocation that are expected to resolve to this resource." )
        protected List<OperationDefinitionParameterReferencedFromComponent> referencedFrom;

        /**
         * The parts of a nested Parameter.
         */
        @Child(name = "part", type = {OperationDefinitionParameterComponent.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Parts of a nested Parameter", formalDefinition="The parts of a nested Parameter." )
        protected List<OperationDefinitionParameterComponent> part;

        private static final long serialVersionUID = -153032790L;

    /**
     * Constructor
     */
      public OperationDefinitionParameterComponent() {
        super();
      }

    /**
     * Constructor
     */
      public OperationDefinitionParameterComponent(String name, OperationParameterUse use, int min, String max) {
        super();
        this.setName(name);
        this.setUse(use);
        this.setMin(min);
        this.setMax(max);
      }

        /**
         * @return {@link #name} (The name of used to identify the parameter.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public CodeType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OperationDefinitionParameterComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new CodeType(); // bb
          return this.name;
        }

        public boolean hasNameElement() { 
          return this.name != null && !this.name.isEmpty();
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (The name of used to identify the parameter.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public OperationDefinitionParameterComponent setNameElement(CodeType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return The name of used to identify the parameter.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value The name of used to identify the parameter.
         */
        public OperationDefinitionParameterComponent setName(String value) { 
            if (this.name == null)
              this.name = new CodeType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #use} (Whether this is an input or an output parameter.). This is the underlying object with id, value and extensions. The accessor "getUse" gives direct access to the value
         */
        public Enumeration<OperationParameterUse> getUseElement() { 
          if (this.use == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OperationDefinitionParameterComponent.use");
            else if (Configuration.doAutoCreate())
              this.use = new Enumeration<OperationParameterUse>(new OperationParameterUseEnumFactory()); // bb
          return this.use;
        }

        public boolean hasUseElement() { 
          return this.use != null && !this.use.isEmpty();
        }

        public boolean hasUse() { 
          return this.use != null && !this.use.isEmpty();
        }

        /**
         * @param value {@link #use} (Whether this is an input or an output parameter.). This is the underlying object with id, value and extensions. The accessor "getUse" gives direct access to the value
         */
        public OperationDefinitionParameterComponent setUseElement(Enumeration<OperationParameterUse> value) { 
          this.use = value;
          return this;
        }

        /**
         * @return Whether this is an input or an output parameter.
         */
        public OperationParameterUse getUse() { 
          return this.use == null ? null : this.use.getValue();
        }

        /**
         * @param value Whether this is an input or an output parameter.
         */
        public OperationDefinitionParameterComponent setUse(OperationParameterUse value) { 
            if (this.use == null)
              this.use = new Enumeration<OperationParameterUse>(new OperationParameterUseEnumFactory());
            this.use.setValue(value);
          return this;
        }

        /**
         * @return {@link #min} (The minimum number of times this parameter SHALL appear in the request or response.). This is the underlying object with id, value and extensions. The accessor "getMin" gives direct access to the value
         */
        public IntegerType getMinElement() { 
          if (this.min == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OperationDefinitionParameterComponent.min");
            else if (Configuration.doAutoCreate())
              this.min = new IntegerType(); // bb
          return this.min;
        }

        public boolean hasMinElement() { 
          return this.min != null && !this.min.isEmpty();
        }

        public boolean hasMin() { 
          return this.min != null && !this.min.isEmpty();
        }

        /**
         * @param value {@link #min} (The minimum number of times this parameter SHALL appear in the request or response.). This is the underlying object with id, value and extensions. The accessor "getMin" gives direct access to the value
         */
        public OperationDefinitionParameterComponent setMinElement(IntegerType value) { 
          this.min = value;
          return this;
        }

        /**
         * @return The minimum number of times this parameter SHALL appear in the request or response.
         */
        public int getMin() { 
          return this.min == null || this.min.isEmpty() ? 0 : this.min.getValue();
        }

        /**
         * @param value The minimum number of times this parameter SHALL appear in the request or response.
         */
        public OperationDefinitionParameterComponent setMin(int value) { 
            if (this.min == null)
              this.min = new IntegerType();
            this.min.setValue(value);
          return this;
        }

        /**
         * @return {@link #max} (The maximum number of times this element is permitted to appear in the request or response.). This is the underlying object with id, value and extensions. The accessor "getMax" gives direct access to the value
         */
        public StringType getMaxElement() { 
          if (this.max == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OperationDefinitionParameterComponent.max");
            else if (Configuration.doAutoCreate())
              this.max = new StringType(); // bb
          return this.max;
        }

        public boolean hasMaxElement() { 
          return this.max != null && !this.max.isEmpty();
        }

        public boolean hasMax() { 
          return this.max != null && !this.max.isEmpty();
        }

        /**
         * @param value {@link #max} (The maximum number of times this element is permitted to appear in the request or response.). This is the underlying object with id, value and extensions. The accessor "getMax" gives direct access to the value
         */
        public OperationDefinitionParameterComponent setMaxElement(StringType value) { 
          this.max = value;
          return this;
        }

        /**
         * @return The maximum number of times this element is permitted to appear in the request or response.
         */
        public String getMax() { 
          return this.max == null ? null : this.max.getValue();
        }

        /**
         * @param value The maximum number of times this element is permitted to appear in the request or response.
         */
        public OperationDefinitionParameterComponent setMax(String value) { 
            if (this.max == null)
              this.max = new StringType();
            this.max.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (Describes the meaning or use of this parameter.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public StringType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OperationDefinitionParameterComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new StringType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Describes the meaning or use of this parameter.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public OperationDefinitionParameterComponent setDocumentationElement(StringType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Describes the meaning or use of this parameter.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Describes the meaning or use of this parameter.
         */
        public OperationDefinitionParameterComponent setDocumentation(String value) { 
          if (Utilities.noString(value))
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new StringType();
            this.documentation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #type} (The type for this parameter.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<FHIRAllTypes> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OperationDefinitionParameterComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<FHIRAllTypes>(new FHIRAllTypesEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type for this parameter.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public OperationDefinitionParameterComponent setTypeElement(Enumeration<FHIRAllTypes> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type for this parameter.
         */
        public FHIRAllTypes getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type for this parameter.
         */
        public OperationDefinitionParameterComponent setType(FHIRAllTypes value) { 
          if (value == null)
            this.type = null;
          else {
            if (this.type == null)
              this.type = new Enumeration<FHIRAllTypes>(new FHIRAllTypesEnumFactory());
            this.type.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #targetProfile} (Used when the type is "Reference" or "canonical", and identifies a profile structure or implementation Guide that applies to the target of the reference this parameter refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide.)
         */
        public List<CanonicalType> getTargetProfile() { 
          if (this.targetProfile == null)
            this.targetProfile = new ArrayList<CanonicalType>();
          return this.targetProfile;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public OperationDefinitionParameterComponent setTargetProfile(List<CanonicalType> theTargetProfile) { 
          this.targetProfile = theTargetProfile;
          return this;
        }

        public boolean hasTargetProfile() { 
          if (this.targetProfile == null)
            return false;
          for (CanonicalType item : this.targetProfile)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #targetProfile} (Used when the type is "Reference" or "canonical", and identifies a profile structure or implementation Guide that applies to the target of the reference this parameter refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide.)
         */
        public CanonicalType addTargetProfileElement() {//2 
          CanonicalType t = new CanonicalType();
          if (this.targetProfile == null)
            this.targetProfile = new ArrayList<CanonicalType>();
          this.targetProfile.add(t);
          return t;
        }

        /**
         * @param value {@link #targetProfile} (Used when the type is "Reference" or "canonical", and identifies a profile structure or implementation Guide that applies to the target of the reference this parameter refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide.)
         */
        public OperationDefinitionParameterComponent addTargetProfile(String value) { //1
          CanonicalType t = new CanonicalType();
          t.setValue(value);
          if (this.targetProfile == null)
            this.targetProfile = new ArrayList<CanonicalType>();
          this.targetProfile.add(t);
          return this;
        }

        /**
         * @param value {@link #targetProfile} (Used when the type is "Reference" or "canonical", and identifies a profile structure or implementation Guide that applies to the target of the reference this parameter refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide.)
         */
        public boolean hasTargetProfile(String value) { 
          if (this.targetProfile == null)
            return false;
          for (CanonicalType v : this.targetProfile)
            if (v.getValue().equals(value)) // canonical
              return true;
          return false;
        }

        /**
         * @return {@link #searchType} (How the parameter is understood as a search parameter. This is only used if the parameter type is 'string'.). This is the underlying object with id, value and extensions. The accessor "getSearchType" gives direct access to the value
         */
        public Enumeration<SearchParamType> getSearchTypeElement() { 
          if (this.searchType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OperationDefinitionParameterComponent.searchType");
            else if (Configuration.doAutoCreate())
              this.searchType = new Enumeration<SearchParamType>(new SearchParamTypeEnumFactory()); // bb
          return this.searchType;
        }

        public boolean hasSearchTypeElement() { 
          return this.searchType != null && !this.searchType.isEmpty();
        }

        public boolean hasSearchType() { 
          return this.searchType != null && !this.searchType.isEmpty();
        }

        /**
         * @param value {@link #searchType} (How the parameter is understood as a search parameter. This is only used if the parameter type is 'string'.). This is the underlying object with id, value and extensions. The accessor "getSearchType" gives direct access to the value
         */
        public OperationDefinitionParameterComponent setSearchTypeElement(Enumeration<SearchParamType> value) { 
          this.searchType = value;
          return this;
        }

        /**
         * @return How the parameter is understood as a search parameter. This is only used if the parameter type is 'string'.
         */
        public SearchParamType getSearchType() { 
          return this.searchType == null ? null : this.searchType.getValue();
        }

        /**
         * @param value How the parameter is understood as a search parameter. This is only used if the parameter type is 'string'.
         */
        public OperationDefinitionParameterComponent setSearchType(SearchParamType value) { 
          if (value == null)
            this.searchType = null;
          else {
            if (this.searchType == null)
              this.searchType = new Enumeration<SearchParamType>(new SearchParamTypeEnumFactory());
            this.searchType.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #binding} (Binds to a value set if this parameter is coded (code, Coding, CodeableConcept).)
         */
        public OperationDefinitionParameterBindingComponent getBinding() { 
          if (this.binding == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OperationDefinitionParameterComponent.binding");
            else if (Configuration.doAutoCreate())
              this.binding = new OperationDefinitionParameterBindingComponent(); // cc
          return this.binding;
        }

        public boolean hasBinding() { 
          return this.binding != null && !this.binding.isEmpty();
        }

        /**
         * @param value {@link #binding} (Binds to a value set if this parameter is coded (code, Coding, CodeableConcept).)
         */
        public OperationDefinitionParameterComponent setBinding(OperationDefinitionParameterBindingComponent value) { 
          this.binding = value;
          return this;
        }

        /**
         * @return {@link #referencedFrom} (Identifies other resource parameters within the operation invocation that are expected to resolve to this resource.)
         */
        public List<OperationDefinitionParameterReferencedFromComponent> getReferencedFrom() { 
          if (this.referencedFrom == null)
            this.referencedFrom = new ArrayList<OperationDefinitionParameterReferencedFromComponent>();
          return this.referencedFrom;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public OperationDefinitionParameterComponent setReferencedFrom(List<OperationDefinitionParameterReferencedFromComponent> theReferencedFrom) { 
          this.referencedFrom = theReferencedFrom;
          return this;
        }

        public boolean hasReferencedFrom() { 
          if (this.referencedFrom == null)
            return false;
          for (OperationDefinitionParameterReferencedFromComponent item : this.referencedFrom)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public OperationDefinitionParameterReferencedFromComponent addReferencedFrom() { //3
          OperationDefinitionParameterReferencedFromComponent t = new OperationDefinitionParameterReferencedFromComponent();
          if (this.referencedFrom == null)
            this.referencedFrom = new ArrayList<OperationDefinitionParameterReferencedFromComponent>();
          this.referencedFrom.add(t);
          return t;
        }

        public OperationDefinitionParameterComponent addReferencedFrom(OperationDefinitionParameterReferencedFromComponent t) { //3
          if (t == null)
            return this;
          if (this.referencedFrom == null)
            this.referencedFrom = new ArrayList<OperationDefinitionParameterReferencedFromComponent>();
          this.referencedFrom.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #referencedFrom}, creating it if it does not already exist {3}
         */
        public OperationDefinitionParameterReferencedFromComponent getReferencedFromFirstRep() { 
          if (getReferencedFrom().isEmpty()) {
            addReferencedFrom();
          }
          return getReferencedFrom().get(0);
        }

        /**
         * @return {@link #part} (The parts of a nested Parameter.)
         */
        public List<OperationDefinitionParameterComponent> getPart() { 
          if (this.part == null)
            this.part = new ArrayList<OperationDefinitionParameterComponent>();
          return this.part;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public OperationDefinitionParameterComponent setPart(List<OperationDefinitionParameterComponent> thePart) { 
          this.part = thePart;
          return this;
        }

        public boolean hasPart() { 
          if (this.part == null)
            return false;
          for (OperationDefinitionParameterComponent item : this.part)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public OperationDefinitionParameterComponent addPart() { //3
          OperationDefinitionParameterComponent t = new OperationDefinitionParameterComponent();
          if (this.part == null)
            this.part = new ArrayList<OperationDefinitionParameterComponent>();
          this.part.add(t);
          return t;
        }

        public OperationDefinitionParameterComponent addPart(OperationDefinitionParameterComponent t) { //3
          if (t == null)
            return this;
          if (this.part == null)
            this.part = new ArrayList<OperationDefinitionParameterComponent>();
          this.part.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #part}, creating it if it does not already exist {3}
         */
        public OperationDefinitionParameterComponent getPartFirstRep() { 
          if (getPart().isEmpty()) {
            addPart();
          }
          return getPart().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "code", "The name of used to identify the parameter.", 0, 1, name));
          children.add(new Property("use", "code", "Whether this is an input or an output parameter.", 0, 1, use));
          children.add(new Property("min", "integer", "The minimum number of times this parameter SHALL appear in the request or response.", 0, 1, min));
          children.add(new Property("max", "string", "The maximum number of times this element is permitted to appear in the request or response.", 0, 1, max));
          children.add(new Property("documentation", "string", "Describes the meaning or use of this parameter.", 0, 1, documentation));
          children.add(new Property("type", "code", "The type for this parameter.", 0, 1, type));
          children.add(new Property("targetProfile", "canonical(StructureDefinition)", "Used when the type is \"Reference\" or \"canonical\", and identifies a profile structure or implementation Guide that applies to the target of the reference this parameter refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide.", 0, java.lang.Integer.MAX_VALUE, targetProfile));
          children.add(new Property("searchType", "code", "How the parameter is understood as a search parameter. This is only used if the parameter type is 'string'.", 0, 1, searchType));
          children.add(new Property("binding", "", "Binds to a value set if this parameter is coded (code, Coding, CodeableConcept).", 0, 1, binding));
          children.add(new Property("referencedFrom", "", "Identifies other resource parameters within the operation invocation that are expected to resolve to this resource.", 0, java.lang.Integer.MAX_VALUE, referencedFrom));
          children.add(new Property("part", "@OperationDefinition.parameter", "The parts of a nested Parameter.", 0, java.lang.Integer.MAX_VALUE, part));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "code", "The name of used to identify the parameter.", 0, 1, name);
          case 116103: /*use*/  return new Property("use", "code", "Whether this is an input or an output parameter.", 0, 1, use);
          case 108114: /*min*/  return new Property("min", "integer", "The minimum number of times this parameter SHALL appear in the request or response.", 0, 1, min);
          case 107876: /*max*/  return new Property("max", "string", "The maximum number of times this element is permitted to appear in the request or response.", 0, 1, max);
          case 1587405498: /*documentation*/  return new Property("documentation", "string", "Describes the meaning or use of this parameter.", 0, 1, documentation);
          case 3575610: /*type*/  return new Property("type", "code", "The type for this parameter.", 0, 1, type);
          case 1994521304: /*targetProfile*/  return new Property("targetProfile", "canonical(StructureDefinition)", "Used when the type is \"Reference\" or \"canonical\", and identifies a profile structure or implementation Guide that applies to the target of the reference this parameter refers to. If any profiles are specified, then the content must conform to at least one of them. The URL can be a local reference - to a contained StructureDefinition, or a reference to another StructureDefinition or Implementation Guide by a canonical URL. When an implementation guide is specified, the target resource SHALL conform to at least one profile defined in the implementation guide.", 0, java.lang.Integer.MAX_VALUE, targetProfile);
          case -710454014: /*searchType*/  return new Property("searchType", "code", "How the parameter is understood as a search parameter. This is only used if the parameter type is 'string'.", 0, 1, searchType);
          case -108220795: /*binding*/  return new Property("binding", "", "Binds to a value set if this parameter is coded (code, Coding, CodeableConcept).", 0, 1, binding);
          case -1896721981: /*referencedFrom*/  return new Property("referencedFrom", "", "Identifies other resource parameters within the operation invocation that are expected to resolve to this resource.", 0, java.lang.Integer.MAX_VALUE, referencedFrom);
          case 3433459: /*part*/  return new Property("part", "@OperationDefinition.parameter", "The parts of a nested Parameter.", 0, java.lang.Integer.MAX_VALUE, part);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // CodeType
        case 116103: /*use*/ return this.use == null ? new Base[0] : new Base[] {this.use}; // Enumeration<OperationParameterUse>
        case 108114: /*min*/ return this.min == null ? new Base[0] : new Base[] {this.min}; // IntegerType
        case 107876: /*max*/ return this.max == null ? new Base[0] : new Base[] {this.max}; // StringType
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<FHIRAllTypes>
        case 1994521304: /*targetProfile*/ return this.targetProfile == null ? new Base[0] : this.targetProfile.toArray(new Base[this.targetProfile.size()]); // CanonicalType
        case -710454014: /*searchType*/ return this.searchType == null ? new Base[0] : new Base[] {this.searchType}; // Enumeration<SearchParamType>
        case -108220795: /*binding*/ return this.binding == null ? new Base[0] : new Base[] {this.binding}; // OperationDefinitionParameterBindingComponent
        case -1896721981: /*referencedFrom*/ return this.referencedFrom == null ? new Base[0] : this.referencedFrom.toArray(new Base[this.referencedFrom.size()]); // OperationDefinitionParameterReferencedFromComponent
        case 3433459: /*part*/ return this.part == null ? new Base[0] : this.part.toArray(new Base[this.part.size()]); // OperationDefinitionParameterComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 116103: // use
          value = new OperationParameterUseEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.use = (Enumeration) value; // Enumeration<OperationParameterUse>
          return value;
        case 108114: // min
          this.min = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 107876: // max
          this.max = TypeConvertor.castToString(value); // StringType
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          value = new FHIRAllTypesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<FHIRAllTypes>
          return value;
        case 1994521304: // targetProfile
          this.getTargetProfile().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case -710454014: // searchType
          value = new SearchParamTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.searchType = (Enumeration) value; // Enumeration<SearchParamType>
          return value;
        case -108220795: // binding
          this.binding = (OperationDefinitionParameterBindingComponent) value; // OperationDefinitionParameterBindingComponent
          return value;
        case -1896721981: // referencedFrom
          this.getReferencedFrom().add((OperationDefinitionParameterReferencedFromComponent) value); // OperationDefinitionParameterReferencedFromComponent
          return value;
        case 3433459: // part
          this.getPart().add((OperationDefinitionParameterComponent) value); // OperationDefinitionParameterComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("use")) {
          value = new OperationParameterUseEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.use = (Enumeration) value; // Enumeration<OperationParameterUse>
        } else if (name.equals("min")) {
          this.min = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("max")) {
          this.max = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          value = new FHIRAllTypesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<FHIRAllTypes>
        } else if (name.equals("targetProfile")) {
          this.getTargetProfile().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("searchType")) {
          value = new SearchParamTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.searchType = (Enumeration) value; // Enumeration<SearchParamType>
        } else if (name.equals("binding")) {
          this.binding = (OperationDefinitionParameterBindingComponent) value; // OperationDefinitionParameterBindingComponent
        } else if (name.equals("referencedFrom")) {
          this.getReferencedFrom().add((OperationDefinitionParameterReferencedFromComponent) value);
        } else if (name.equals("part")) {
          this.getPart().add((OperationDefinitionParameterComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 116103:  return getUseElement();
        case 108114:  return getMinElement();
        case 107876:  return getMaxElement();
        case 1587405498:  return getDocumentationElement();
        case 3575610:  return getTypeElement();
        case 1994521304:  return addTargetProfileElement();
        case -710454014:  return getSearchTypeElement();
        case -108220795:  return getBinding();
        case -1896721981:  return addReferencedFrom(); 
        case 3433459:  return addPart(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"code"};
        case 116103: /*use*/ return new String[] {"code"};
        case 108114: /*min*/ return new String[] {"integer"};
        case 107876: /*max*/ return new String[] {"string"};
        case 1587405498: /*documentation*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"code"};
        case 1994521304: /*targetProfile*/ return new String[] {"canonical"};
        case -710454014: /*searchType*/ return new String[] {"code"};
        case -108220795: /*binding*/ return new String[] {};
        case -1896721981: /*referencedFrom*/ return new String[] {};
        case 3433459: /*part*/ return new String[] {"@OperationDefinition.parameter"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.parameter.name");
        }
        else if (name.equals("use")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.parameter.use");
        }
        else if (name.equals("min")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.parameter.min");
        }
        else if (name.equals("max")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.parameter.max");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.parameter.documentation");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.parameter.type");
        }
        else if (name.equals("targetProfile")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.parameter.targetProfile");
        }
        else if (name.equals("searchType")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.parameter.searchType");
        }
        else if (name.equals("binding")) {
          this.binding = new OperationDefinitionParameterBindingComponent();
          return this.binding;
        }
        else if (name.equals("referencedFrom")) {
          return addReferencedFrom();
        }
        else if (name.equals("part")) {
          return addPart();
        }
        else
          return super.addChild(name);
      }

      public OperationDefinitionParameterComponent copy() {
        OperationDefinitionParameterComponent dst = new OperationDefinitionParameterComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(OperationDefinitionParameterComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.use = use == null ? null : use.copy();
        dst.min = min == null ? null : min.copy();
        dst.max = max == null ? null : max.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
        dst.type = type == null ? null : type.copy();
        if (targetProfile != null) {
          dst.targetProfile = new ArrayList<CanonicalType>();
          for (CanonicalType i : targetProfile)
            dst.targetProfile.add(i.copy());
        };
        dst.searchType = searchType == null ? null : searchType.copy();
        dst.binding = binding == null ? null : binding.copy();
        if (referencedFrom != null) {
          dst.referencedFrom = new ArrayList<OperationDefinitionParameterReferencedFromComponent>();
          for (OperationDefinitionParameterReferencedFromComponent i : referencedFrom)
            dst.referencedFrom.add(i.copy());
        };
        if (part != null) {
          dst.part = new ArrayList<OperationDefinitionParameterComponent>();
          for (OperationDefinitionParameterComponent i : part)
            dst.part.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof OperationDefinitionParameterComponent))
          return false;
        OperationDefinitionParameterComponent o = (OperationDefinitionParameterComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(use, o.use, true) && compareDeep(min, o.min, true)
           && compareDeep(max, o.max, true) && compareDeep(documentation, o.documentation, true) && compareDeep(type, o.type, true)
           && compareDeep(targetProfile, o.targetProfile, true) && compareDeep(searchType, o.searchType, true)
           && compareDeep(binding, o.binding, true) && compareDeep(referencedFrom, o.referencedFrom, true)
           && compareDeep(part, o.part, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof OperationDefinitionParameterComponent))
          return false;
        OperationDefinitionParameterComponent o = (OperationDefinitionParameterComponent) other_;
        return compareValues(name, o.name, true) && compareValues(use, o.use, true) && compareValues(min, o.min, true)
           && compareValues(max, o.max, true) && compareValues(documentation, o.documentation, true) && compareValues(type, o.type, true)
           && compareValues(targetProfile, o.targetProfile, true) && compareValues(searchType, o.searchType, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, use, min, max, documentation
          , type, targetProfile, searchType, binding, referencedFrom, part);
      }

  public String fhirType() {
    return "OperationDefinition.parameter";

  }

  }

    @Block()
    public static class OperationDefinitionParameterBindingComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances.
         */
        @Child(name = "strength", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="required | extensible | preferred | example", formalDefinition="Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/binding-strength")
        protected Enumeration<BindingStrength> strength;

        /**
         * Points to the value set or external definition (e.g. implicit value set) that identifies the set of codes to be used.
         */
        @Child(name = "valueSet", type = {CanonicalType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Source of value set", formalDefinition="Points to the value set or external definition (e.g. implicit value set) that identifies the set of codes to be used." )
        protected CanonicalType valueSet;

        private static final long serialVersionUID = -2048653907L;

    /**
     * Constructor
     */
      public OperationDefinitionParameterBindingComponent() {
        super();
      }

    /**
     * Constructor
     */
      public OperationDefinitionParameterBindingComponent(BindingStrength strength, String valueSet) {
        super();
        this.setStrength(strength);
        this.setValueSet(valueSet);
      }

        /**
         * @return {@link #strength} (Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances.). This is the underlying object with id, value and extensions. The accessor "getStrength" gives direct access to the value
         */
        public Enumeration<BindingStrength> getStrengthElement() { 
          if (this.strength == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OperationDefinitionParameterBindingComponent.strength");
            else if (Configuration.doAutoCreate())
              this.strength = new Enumeration<BindingStrength>(new BindingStrengthEnumFactory()); // bb
          return this.strength;
        }

        public boolean hasStrengthElement() { 
          return this.strength != null && !this.strength.isEmpty();
        }

        public boolean hasStrength() { 
          return this.strength != null && !this.strength.isEmpty();
        }

        /**
         * @param value {@link #strength} (Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances.). This is the underlying object with id, value and extensions. The accessor "getStrength" gives direct access to the value
         */
        public OperationDefinitionParameterBindingComponent setStrengthElement(Enumeration<BindingStrength> value) { 
          this.strength = value;
          return this;
        }

        /**
         * @return Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances.
         */
        public BindingStrength getStrength() { 
          return this.strength == null ? null : this.strength.getValue();
        }

        /**
         * @param value Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances.
         */
        public OperationDefinitionParameterBindingComponent setStrength(BindingStrength value) { 
            if (this.strength == null)
              this.strength = new Enumeration<BindingStrength>(new BindingStrengthEnumFactory());
            this.strength.setValue(value);
          return this;
        }

        /**
         * @return {@link #valueSet} (Points to the value set or external definition (e.g. implicit value set) that identifies the set of codes to be used.). This is the underlying object with id, value and extensions. The accessor "getValueSet" gives direct access to the value
         */
        public CanonicalType getValueSetElement() { 
          if (this.valueSet == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OperationDefinitionParameterBindingComponent.valueSet");
            else if (Configuration.doAutoCreate())
              this.valueSet = new CanonicalType(); // bb
          return this.valueSet;
        }

        public boolean hasValueSetElement() { 
          return this.valueSet != null && !this.valueSet.isEmpty();
        }

        public boolean hasValueSet() { 
          return this.valueSet != null && !this.valueSet.isEmpty();
        }

        /**
         * @param value {@link #valueSet} (Points to the value set or external definition (e.g. implicit value set) that identifies the set of codes to be used.). This is the underlying object with id, value and extensions. The accessor "getValueSet" gives direct access to the value
         */
        public OperationDefinitionParameterBindingComponent setValueSetElement(CanonicalType value) { 
          this.valueSet = value;
          return this;
        }

        /**
         * @return Points to the value set or external definition (e.g. implicit value set) that identifies the set of codes to be used.
         */
        public String getValueSet() { 
          return this.valueSet == null ? null : this.valueSet.getValue();
        }

        /**
         * @param value Points to the value set or external definition (e.g. implicit value set) that identifies the set of codes to be used.
         */
        public OperationDefinitionParameterBindingComponent setValueSet(String value) { 
            if (this.valueSet == null)
              this.valueSet = new CanonicalType();
            this.valueSet.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("strength", "code", "Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances.", 0, 1, strength));
          children.add(new Property("valueSet", "canonical(ValueSet)", "Points to the value set or external definition (e.g. implicit value set) that identifies the set of codes to be used.", 0, 1, valueSet));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1791316033: /*strength*/  return new Property("strength", "code", "Indicates the degree of conformance expectations associated with this binding - that is, the degree to which the provided value set must be adhered to in the instances.", 0, 1, strength);
          case -1410174671: /*valueSet*/  return new Property("valueSet", "canonical(ValueSet)", "Points to the value set or external definition (e.g. implicit value set) that identifies the set of codes to be used.", 0, 1, valueSet);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1791316033: /*strength*/ return this.strength == null ? new Base[0] : new Base[] {this.strength}; // Enumeration<BindingStrength>
        case -1410174671: /*valueSet*/ return this.valueSet == null ? new Base[0] : new Base[] {this.valueSet}; // CanonicalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1791316033: // strength
          value = new BindingStrengthEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.strength = (Enumeration) value; // Enumeration<BindingStrength>
          return value;
        case -1410174671: // valueSet
          this.valueSet = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("strength")) {
          value = new BindingStrengthEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.strength = (Enumeration) value; // Enumeration<BindingStrength>
        } else if (name.equals("valueSet")) {
          this.valueSet = TypeConvertor.castToCanonical(value); // CanonicalType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1791316033:  return getStrengthElement();
        case -1410174671:  return getValueSetElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1791316033: /*strength*/ return new String[] {"code"};
        case -1410174671: /*valueSet*/ return new String[] {"canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("strength")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.parameter.binding.strength");
        }
        else if (name.equals("valueSet")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.parameter.binding.valueSet");
        }
        else
          return super.addChild(name);
      }

      public OperationDefinitionParameterBindingComponent copy() {
        OperationDefinitionParameterBindingComponent dst = new OperationDefinitionParameterBindingComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(OperationDefinitionParameterBindingComponent dst) {
        super.copyValues(dst);
        dst.strength = strength == null ? null : strength.copy();
        dst.valueSet = valueSet == null ? null : valueSet.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof OperationDefinitionParameterBindingComponent))
          return false;
        OperationDefinitionParameterBindingComponent o = (OperationDefinitionParameterBindingComponent) other_;
        return compareDeep(strength, o.strength, true) && compareDeep(valueSet, o.valueSet, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof OperationDefinitionParameterBindingComponent))
          return false;
        OperationDefinitionParameterBindingComponent o = (OperationDefinitionParameterBindingComponent) other_;
        return compareValues(strength, o.strength, true) && compareValues(valueSet, o.valueSet, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(strength, valueSet);
      }

  public String fhirType() {
    return "OperationDefinition.parameter.binding";

  }

  }

    @Block()
    public static class OperationDefinitionParameterReferencedFromComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The name of the parameter or dot-separated path of parameter names pointing to the resource parameter that is expected to contain a reference to this resource.
         */
        @Child(name = "source", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Referencing parameter", formalDefinition="The name of the parameter or dot-separated path of parameter names pointing to the resource parameter that is expected to contain a reference to this resource." )
        protected StringType source;

        /**
         * The id of the element in the referencing resource that is expected to resolve to this resource.
         */
        @Child(name = "sourceId", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Element id of reference", formalDefinition="The id of the element in the referencing resource that is expected to resolve to this resource." )
        protected StringType sourceId;

        private static final long serialVersionUID = -104239783L;

    /**
     * Constructor
     */
      public OperationDefinitionParameterReferencedFromComponent() {
        super();
      }

    /**
     * Constructor
     */
      public OperationDefinitionParameterReferencedFromComponent(String source) {
        super();
        this.setSource(source);
      }

        /**
         * @return {@link #source} (The name of the parameter or dot-separated path of parameter names pointing to the resource parameter that is expected to contain a reference to this resource.). This is the underlying object with id, value and extensions. The accessor "getSource" gives direct access to the value
         */
        public StringType getSourceElement() { 
          if (this.source == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OperationDefinitionParameterReferencedFromComponent.source");
            else if (Configuration.doAutoCreate())
              this.source = new StringType(); // bb
          return this.source;
        }

        public boolean hasSourceElement() { 
          return this.source != null && !this.source.isEmpty();
        }

        public boolean hasSource() { 
          return this.source != null && !this.source.isEmpty();
        }

        /**
         * @param value {@link #source} (The name of the parameter or dot-separated path of parameter names pointing to the resource parameter that is expected to contain a reference to this resource.). This is the underlying object with id, value and extensions. The accessor "getSource" gives direct access to the value
         */
        public OperationDefinitionParameterReferencedFromComponent setSourceElement(StringType value) { 
          this.source = value;
          return this;
        }

        /**
         * @return The name of the parameter or dot-separated path of parameter names pointing to the resource parameter that is expected to contain a reference to this resource.
         */
        public String getSource() { 
          return this.source == null ? null : this.source.getValue();
        }

        /**
         * @param value The name of the parameter or dot-separated path of parameter names pointing to the resource parameter that is expected to contain a reference to this resource.
         */
        public OperationDefinitionParameterReferencedFromComponent setSource(String value) { 
            if (this.source == null)
              this.source = new StringType();
            this.source.setValue(value);
          return this;
        }

        /**
         * @return {@link #sourceId} (The id of the element in the referencing resource that is expected to resolve to this resource.). This is the underlying object with id, value and extensions. The accessor "getSourceId" gives direct access to the value
         */
        public StringType getSourceIdElement() { 
          if (this.sourceId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OperationDefinitionParameterReferencedFromComponent.sourceId");
            else if (Configuration.doAutoCreate())
              this.sourceId = new StringType(); // bb
          return this.sourceId;
        }

        public boolean hasSourceIdElement() { 
          return this.sourceId != null && !this.sourceId.isEmpty();
        }

        public boolean hasSourceId() { 
          return this.sourceId != null && !this.sourceId.isEmpty();
        }

        /**
         * @param value {@link #sourceId} (The id of the element in the referencing resource that is expected to resolve to this resource.). This is the underlying object with id, value and extensions. The accessor "getSourceId" gives direct access to the value
         */
        public OperationDefinitionParameterReferencedFromComponent setSourceIdElement(StringType value) { 
          this.sourceId = value;
          return this;
        }

        /**
         * @return The id of the element in the referencing resource that is expected to resolve to this resource.
         */
        public String getSourceId() { 
          return this.sourceId == null ? null : this.sourceId.getValue();
        }

        /**
         * @param value The id of the element in the referencing resource that is expected to resolve to this resource.
         */
        public OperationDefinitionParameterReferencedFromComponent setSourceId(String value) { 
          if (Utilities.noString(value))
            this.sourceId = null;
          else {
            if (this.sourceId == null)
              this.sourceId = new StringType();
            this.sourceId.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("source", "string", "The name of the parameter or dot-separated path of parameter names pointing to the resource parameter that is expected to contain a reference to this resource.", 0, 1, source));
          children.add(new Property("sourceId", "string", "The id of the element in the referencing resource that is expected to resolve to this resource.", 0, 1, sourceId));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -896505829: /*source*/  return new Property("source", "string", "The name of the parameter or dot-separated path of parameter names pointing to the resource parameter that is expected to contain a reference to this resource.", 0, 1, source);
          case 1746327190: /*sourceId*/  return new Property("sourceId", "string", "The id of the element in the referencing resource that is expected to resolve to this resource.", 0, 1, sourceId);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // StringType
        case 1746327190: /*sourceId*/ return this.sourceId == null ? new Base[0] : new Base[] {this.sourceId}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -896505829: // source
          this.source = TypeConvertor.castToString(value); // StringType
          return value;
        case 1746327190: // sourceId
          this.sourceId = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("source")) {
          this.source = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("sourceId")) {
          this.sourceId = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -896505829:  return getSourceElement();
        case 1746327190:  return getSourceIdElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -896505829: /*source*/ return new String[] {"string"};
        case 1746327190: /*sourceId*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("source")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.parameter.referencedFrom.source");
        }
        else if (name.equals("sourceId")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.parameter.referencedFrom.sourceId");
        }
        else
          return super.addChild(name);
      }

      public OperationDefinitionParameterReferencedFromComponent copy() {
        OperationDefinitionParameterReferencedFromComponent dst = new OperationDefinitionParameterReferencedFromComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(OperationDefinitionParameterReferencedFromComponent dst) {
        super.copyValues(dst);
        dst.source = source == null ? null : source.copy();
        dst.sourceId = sourceId == null ? null : sourceId.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof OperationDefinitionParameterReferencedFromComponent))
          return false;
        OperationDefinitionParameterReferencedFromComponent o = (OperationDefinitionParameterReferencedFromComponent) other_;
        return compareDeep(source, o.source, true) && compareDeep(sourceId, o.sourceId, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof OperationDefinitionParameterReferencedFromComponent))
          return false;
        OperationDefinitionParameterReferencedFromComponent o = (OperationDefinitionParameterReferencedFromComponent) other_;
        return compareValues(source, o.source, true) && compareValues(sourceId, o.sourceId, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(source, sourceId);
      }

  public String fhirType() {
    return "OperationDefinition.parameter.referencedFrom";

  }

  }

    @Block()
    public static class OperationDefinitionOverloadComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Name of parameter to include in overload.
         */
        @Child(name = "parameterName", type = {StringType.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Name of parameter to include in overload", formalDefinition="Name of parameter to include in overload." )
        protected List<StringType> parameterName;

        /**
         * Comments to go on overload.
         */
        @Child(name = "comment", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Comments to go on overload", formalDefinition="Comments to go on overload." )
        protected StringType comment;

        private static final long serialVersionUID = -907948545L;

    /**
     * Constructor
     */
      public OperationDefinitionOverloadComponent() {
        super();
      }

        /**
         * @return {@link #parameterName} (Name of parameter to include in overload.)
         */
        public List<StringType> getParameterName() { 
          if (this.parameterName == null)
            this.parameterName = new ArrayList<StringType>();
          return this.parameterName;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public OperationDefinitionOverloadComponent setParameterName(List<StringType> theParameterName) { 
          this.parameterName = theParameterName;
          return this;
        }

        public boolean hasParameterName() { 
          if (this.parameterName == null)
            return false;
          for (StringType item : this.parameterName)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #parameterName} (Name of parameter to include in overload.)
         */
        public StringType addParameterNameElement() {//2 
          StringType t = new StringType();
          if (this.parameterName == null)
            this.parameterName = new ArrayList<StringType>();
          this.parameterName.add(t);
          return t;
        }

        /**
         * @param value {@link #parameterName} (Name of parameter to include in overload.)
         */
        public OperationDefinitionOverloadComponent addParameterName(String value) { //1
          StringType t = new StringType();
          t.setValue(value);
          if (this.parameterName == null)
            this.parameterName = new ArrayList<StringType>();
          this.parameterName.add(t);
          return this;
        }

        /**
         * @param value {@link #parameterName} (Name of parameter to include in overload.)
         */
        public boolean hasParameterName(String value) { 
          if (this.parameterName == null)
            return false;
          for (StringType v : this.parameterName)
            if (v.getValue().equals(value)) // string
              return true;
          return false;
        }

        /**
         * @return {@link #comment} (Comments to go on overload.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
         */
        public StringType getCommentElement() { 
          if (this.comment == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create OperationDefinitionOverloadComponent.comment");
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
         * @param value {@link #comment} (Comments to go on overload.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
         */
        public OperationDefinitionOverloadComponent setCommentElement(StringType value) { 
          this.comment = value;
          return this;
        }

        /**
         * @return Comments to go on overload.
         */
        public String getComment() { 
          return this.comment == null ? null : this.comment.getValue();
        }

        /**
         * @param value Comments to go on overload.
         */
        public OperationDefinitionOverloadComponent setComment(String value) { 
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
          children.add(new Property("parameterName", "string", "Name of parameter to include in overload.", 0, java.lang.Integer.MAX_VALUE, parameterName));
          children.add(new Property("comment", "string", "Comments to go on overload.", 0, 1, comment));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -379607596: /*parameterName*/  return new Property("parameterName", "string", "Name of parameter to include in overload.", 0, java.lang.Integer.MAX_VALUE, parameterName);
          case 950398559: /*comment*/  return new Property("comment", "string", "Comments to go on overload.", 0, 1, comment);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -379607596: /*parameterName*/ return this.parameterName == null ? new Base[0] : this.parameterName.toArray(new Base[this.parameterName.size()]); // StringType
        case 950398559: /*comment*/ return this.comment == null ? new Base[0] : new Base[] {this.comment}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -379607596: // parameterName
          this.getParameterName().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case 950398559: // comment
          this.comment = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("parameterName")) {
          this.getParameterName().add(TypeConvertor.castToString(value));
        } else if (name.equals("comment")) {
          this.comment = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -379607596:  return addParameterNameElement();
        case 950398559:  return getCommentElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -379607596: /*parameterName*/ return new String[] {"string"};
        case 950398559: /*comment*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("parameterName")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.overload.parameterName");
        }
        else if (name.equals("comment")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.overload.comment");
        }
        else
          return super.addChild(name);
      }

      public OperationDefinitionOverloadComponent copy() {
        OperationDefinitionOverloadComponent dst = new OperationDefinitionOverloadComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(OperationDefinitionOverloadComponent dst) {
        super.copyValues(dst);
        if (parameterName != null) {
          dst.parameterName = new ArrayList<StringType>();
          for (StringType i : parameterName)
            dst.parameterName.add(i.copy());
        };
        dst.comment = comment == null ? null : comment.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof OperationDefinitionOverloadComponent))
          return false;
        OperationDefinitionOverloadComponent o = (OperationDefinitionOverloadComponent) other_;
        return compareDeep(parameterName, o.parameterName, true) && compareDeep(comment, o.comment, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof OperationDefinitionOverloadComponent))
          return false;
        OperationDefinitionOverloadComponent o = (OperationDefinitionOverloadComponent) other_;
        return compareValues(parameterName, o.parameterName, true) && compareValues(comment, o.comment, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(parameterName, comment);
      }

  public String fhirType() {
    return "OperationDefinition.overload";

  }

  }

    /**
     * An absolute URI that is used to identify this operation definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this operation definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the operation definition is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this operation definition, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this operation definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this operation definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the operation definition is stored on different servers." )
    protected UriType url;

    /**
     * The identifier that is used to identify this version of the operation definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the operation definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the operation definition", formalDefinition="The identifier that is used to identify this version of the operation definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the operation definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * A natural language name identifying the operation definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this operation definition (computer friendly)", formalDefinition="A natural language name identifying the operation definition. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the operation definition.
     */
    @Child(name = "title", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this operation definition (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the operation definition." )
    protected StringType title;

    /**
     * The status of this operation definition. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=4, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this operation definition. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * Whether this is an operation or a named query.
     */
    @Child(name = "kind", type = {CodeType.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="operation | query", formalDefinition="Whether this is an operation or a named query." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/operation-kind")
    protected Enumeration<OperationKind> kind;

    /**
     * A Boolean value to indicate that this operation definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this operation definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date  (and optionally time) when the operation definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the operation definition changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the operation definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the operation definition changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual that published the operation definition.
     */
    @Child(name = "publisher", type = {StringType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher (organization or individual)", formalDefinition="The name of the organization or individual that published the operation definition." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the operation definition from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the operation definition", formalDefinition="A free text natural language description of the operation definition from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate operation definition instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate operation definition instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the operation definition is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for operation definition (if applicable)", formalDefinition="A legal or geographic region in which the operation definition is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explanation of why this operation definition is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this operation definition is defined", formalDefinition="Explanation of why this operation definition is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * Whether the operation affects state. Side effects such as producing audit trail entries do not count as 'affecting  state'.
     */
    @Child(name = "affectsState", type = {BooleanType.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Whether content is changed by the operation", formalDefinition="Whether the operation affects state. Side effects such as producing audit trail entries do not count as 'affecting  state'." )
    protected BooleanType affectsState;

    /**
     * The name used to invoke the operation.
     */
    @Child(name = "code", type = {CodeType.class}, order=15, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name used to invoke the operation", formalDefinition="The name used to invoke the operation." )
    protected CodeType code;

    /**
     * Additional information about how to use this operation or named query.
     */
    @Child(name = "comment", type = {MarkdownType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Additional information about use", formalDefinition="Additional information about how to use this operation or named query." )
    protected MarkdownType comment;

    /**
     * Indicates that this operation definition is a constraining profile on the base.
     */
    @Child(name = "base", type = {CanonicalType.class}, order=17, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Marks this as a profile of the base", formalDefinition="Indicates that this operation definition is a constraining profile on the base." )
    protected CanonicalType base;

    /**
     * The types on which this operation can be executed.
     */
    @Child(name = "resource", type = {CodeType.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Types this operation applies to", formalDefinition="The types on which this operation can be executed." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/resource-types")
    protected List<CodeType> resource;

    /**
     * Indicates whether this operation or named query can be invoked at the system level (e.g. without needing to choose a resource type for the context).
     */
    @Child(name = "system", type = {BooleanType.class}, order=19, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Invoke at the system level?", formalDefinition="Indicates whether this operation or named query can be invoked at the system level (e.g. without needing to choose a resource type for the context)." )
    protected BooleanType system;

    /**
     * Indicates whether this operation or named query can be invoked at the resource type level for any given resource type level (e.g. without needing to choose a specific resource id for the context).
     */
    @Child(name = "type", type = {BooleanType.class}, order=20, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Invoke at the type level?", formalDefinition="Indicates whether this operation or named query can be invoked at the resource type level for any given resource type level (e.g. without needing to choose a specific resource id for the context)." )
    protected BooleanType type;

    /**
     * Indicates whether this operation can be invoked on a particular instance of one of the given types.
     */
    @Child(name = "instance", type = {BooleanType.class}, order=21, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Invoke on an instance?", formalDefinition="Indicates whether this operation can be invoked on a particular instance of one of the given types." )
    protected BooleanType instance;

    /**
     * Additional validation information for the in parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource as a whole.
     */
    @Child(name = "inputProfile", type = {CanonicalType.class}, order=22, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Validation information for in parameters", formalDefinition="Additional validation information for the in parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource as a whole." )
    protected CanonicalType inputProfile;

    /**
     * Additional validation information for the out parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource.
     */
    @Child(name = "outputProfile", type = {CanonicalType.class}, order=23, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Validation information for out parameters", formalDefinition="Additional validation information for the out parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource." )
    protected CanonicalType outputProfile;

    /**
     * The parameters for the operation/query.
     */
    @Child(name = "parameter", type = {}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Parameters for the operation/query", formalDefinition="The parameters for the operation/query." )
    protected List<OperationDefinitionParameterComponent> parameter;

    /**
     * Defines an appropriate combination of parameters to use when invoking this operation, to help code generators when generating overloaded parameter sets for this operation.
     */
    @Child(name = "overload", type = {}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Define overloaded variants for when  generating code", formalDefinition="Defines an appropriate combination of parameters to use when invoking this operation, to help code generators when generating overloaded parameter sets for this operation." )
    protected List<OperationDefinitionOverloadComponent> overload;

    private static final long serialVersionUID = 715394391L;

  /**
   * Constructor
   */
    public OperationDefinition() {
      super();
    }

  /**
   * Constructor
   */
    public OperationDefinition(String name, PublicationStatus status, OperationKind kind, String code, boolean system, boolean type, boolean instance) {
      super();
      this.setName(name);
      this.setStatus(status);
      this.setKind(kind);
      this.setCode(code);
      this.setSystem(system);
      this.setType(type);
      this.setInstance(instance);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this operation definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this operation definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the operation definition is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.url");
        else if (Configuration.doAutoCreate())
          this.url = new UriType(); // bb
      return this.url;
    }

    public boolean hasUrlElement() { 
      return this.url != null && !this.url.isEmpty();
    }

    public boolean hasUrl() { 
      return this.url != null && !this.url.isEmpty();
    }

    /**
     * @param value {@link #url} (An absolute URI that is used to identify this operation definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this operation definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the operation definition is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public OperationDefinition setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this operation definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this operation definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the operation definition is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this operation definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this operation definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the operation definition is stored on different servers.
     */
    public OperationDefinition setUrl(String value) { 
      if (Utilities.noString(value))
        this.url = null;
      else {
        if (this.url == null)
          this.url = new UriType();
        this.url.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #version} (The identifier that is used to identify this version of the operation definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the operation definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the operation definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the operation definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public OperationDefinition setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the operation definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the operation definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the operation definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the operation definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public OperationDefinition setVersion(String value) { 
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
     * @return {@link #name} (A natural language name identifying the operation definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.name");
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
     * @param value {@link #name} (A natural language name identifying the operation definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public OperationDefinition setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the operation definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the operation definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public OperationDefinition setName(String value) { 
        if (this.name == null)
          this.name = new StringType();
        this.name.setValue(value);
      return this;
    }

    /**
     * @return {@link #title} (A short, descriptive, user-friendly title for the operation definition.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.title");
        else if (Configuration.doAutoCreate())
          this.title = new StringType(); // bb
      return this.title;
    }

    public boolean hasTitleElement() { 
      return this.title != null && !this.title.isEmpty();
    }

    public boolean hasTitle() { 
      return this.title != null && !this.title.isEmpty();
    }

    /**
     * @param value {@link #title} (A short, descriptive, user-friendly title for the operation definition.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public OperationDefinition setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the operation definition.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the operation definition.
     */
    public OperationDefinition setTitle(String value) { 
      if (Utilities.noString(value))
        this.title = null;
      else {
        if (this.title == null)
          this.title = new StringType();
        this.title.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #status} (The status of this operation definition. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of this operation definition. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public OperationDefinition setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this operation definition. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this operation definition. Enables tracking the life-cycle of the content.
     */
    public OperationDefinition setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #kind} (Whether this is an operation or a named query.). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
     */
    public Enumeration<OperationKind> getKindElement() { 
      if (this.kind == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.kind");
        else if (Configuration.doAutoCreate())
          this.kind = new Enumeration<OperationKind>(new OperationKindEnumFactory()); // bb
      return this.kind;
    }

    public boolean hasKindElement() { 
      return this.kind != null && !this.kind.isEmpty();
    }

    public boolean hasKind() { 
      return this.kind != null && !this.kind.isEmpty();
    }

    /**
     * @param value {@link #kind} (Whether this is an operation or a named query.). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
     */
    public OperationDefinition setKindElement(Enumeration<OperationKind> value) { 
      this.kind = value;
      return this;
    }

    /**
     * @return Whether this is an operation or a named query.
     */
    public OperationKind getKind() { 
      return this.kind == null ? null : this.kind.getValue();
    }

    /**
     * @param value Whether this is an operation or a named query.
     */
    public OperationDefinition setKind(OperationKind value) { 
        if (this.kind == null)
          this.kind = new Enumeration<OperationKind>(new OperationKindEnumFactory());
        this.kind.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this operation definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.experimental");
        else if (Configuration.doAutoCreate())
          this.experimental = new BooleanType(); // bb
      return this.experimental;
    }

    public boolean hasExperimentalElement() { 
      return this.experimental != null && !this.experimental.isEmpty();
    }

    public boolean hasExperimental() { 
      return this.experimental != null && !this.experimental.isEmpty();
    }

    /**
     * @param value {@link #experimental} (A Boolean value to indicate that this operation definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public OperationDefinition setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this operation definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this operation definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public OperationDefinition setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the operation definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the operation definition changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.date");
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
     * @param value {@link #date} (The date  (and optionally time) when the operation definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the operation definition changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public OperationDefinition setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the operation definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the operation definition changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the operation definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the operation definition changes.
     */
    public OperationDefinition setDate(Date value) { 
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
     * @return {@link #publisher} (The name of the organization or individual that published the operation definition.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.publisher");
        else if (Configuration.doAutoCreate())
          this.publisher = new StringType(); // bb
      return this.publisher;
    }

    public boolean hasPublisherElement() { 
      return this.publisher != null && !this.publisher.isEmpty();
    }

    public boolean hasPublisher() { 
      return this.publisher != null && !this.publisher.isEmpty();
    }

    /**
     * @param value {@link #publisher} (The name of the organization or individual that published the operation definition.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public OperationDefinition setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual that published the operation definition.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual that published the operation definition.
     */
    public OperationDefinition setPublisher(String value) { 
      if (Utilities.noString(value))
        this.publisher = null;
      else {
        if (this.publisher == null)
          this.publisher = new StringType();
        this.publisher.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #contact} (Contact details to assist a user in finding and communicating with the publisher.)
     */
    public List<ContactDetail> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public OperationDefinition setContact(List<ContactDetail> theContact) { 
      this.contact = theContact;
      return this;
    }

    public boolean hasContact() { 
      if (this.contact == null)
        return false;
      for (ContactDetail item : this.contact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addContact() { //3
      ContactDetail t = new ContactDetail();
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return t;
    }

    public OperationDefinition addContact(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {3}
     */
    public ContactDetail getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #description} (A free text natural language description of the operation definition from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.description");
        else if (Configuration.doAutoCreate())
          this.description = new MarkdownType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (A free text natural language description of the operation definition from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public OperationDefinition setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the operation definition from a consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the operation definition from a consumer's perspective.
     */
    public OperationDefinition setDescription(String value) { 
      if (value == null)
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate operation definition instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public OperationDefinition setUseContext(List<UsageContext> theUseContext) { 
      this.useContext = theUseContext;
      return this;
    }

    public boolean hasUseContext() { 
      if (this.useContext == null)
        return false;
      for (UsageContext item : this.useContext)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public UsageContext addUseContext() { //3
      UsageContext t = new UsageContext();
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return t;
    }

    public OperationDefinition addUseContext(UsageContext t) { //3
      if (t == null)
        return this;
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #useContext}, creating it if it does not already exist {3}
     */
    public UsageContext getUseContextFirstRep() { 
      if (getUseContext().isEmpty()) {
        addUseContext();
      }
      return getUseContext().get(0);
    }

    /**
     * @return {@link #jurisdiction} (A legal or geographic region in which the operation definition is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public OperationDefinition setJurisdiction(List<CodeableConcept> theJurisdiction) { 
      this.jurisdiction = theJurisdiction;
      return this;
    }

    public boolean hasJurisdiction() { 
      if (this.jurisdiction == null)
        return false;
      for (CodeableConcept item : this.jurisdiction)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addJurisdiction() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return t;
    }

    public OperationDefinition addJurisdiction(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist {3}
     */
    public CodeableConcept getJurisdictionFirstRep() { 
      if (getJurisdiction().isEmpty()) {
        addJurisdiction();
      }
      return getJurisdiction().get(0);
    }

    /**
     * @return {@link #purpose} (Explanation of why this operation definition is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.purpose");
        else if (Configuration.doAutoCreate())
          this.purpose = new MarkdownType(); // bb
      return this.purpose;
    }

    public boolean hasPurposeElement() { 
      return this.purpose != null && !this.purpose.isEmpty();
    }

    public boolean hasPurpose() { 
      return this.purpose != null && !this.purpose.isEmpty();
    }

    /**
     * @param value {@link #purpose} (Explanation of why this operation definition is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public OperationDefinition setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explanation of why this operation definition is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explanation of why this operation definition is needed and why it has been designed as it has.
     */
    public OperationDefinition setPurpose(String value) { 
      if (value == null)
        this.purpose = null;
      else {
        if (this.purpose == null)
          this.purpose = new MarkdownType();
        this.purpose.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #affectsState} (Whether the operation affects state. Side effects such as producing audit trail entries do not count as 'affecting  state'.). This is the underlying object with id, value and extensions. The accessor "getAffectsState" gives direct access to the value
     */
    public BooleanType getAffectsStateElement() { 
      if (this.affectsState == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.affectsState");
        else if (Configuration.doAutoCreate())
          this.affectsState = new BooleanType(); // bb
      return this.affectsState;
    }

    public boolean hasAffectsStateElement() { 
      return this.affectsState != null && !this.affectsState.isEmpty();
    }

    public boolean hasAffectsState() { 
      return this.affectsState != null && !this.affectsState.isEmpty();
    }

    /**
     * @param value {@link #affectsState} (Whether the operation affects state. Side effects such as producing audit trail entries do not count as 'affecting  state'.). This is the underlying object with id, value and extensions. The accessor "getAffectsState" gives direct access to the value
     */
    public OperationDefinition setAffectsStateElement(BooleanType value) { 
      this.affectsState = value;
      return this;
    }

    /**
     * @return Whether the operation affects state. Side effects such as producing audit trail entries do not count as 'affecting  state'.
     */
    public boolean getAffectsState() { 
      return this.affectsState == null || this.affectsState.isEmpty() ? false : this.affectsState.getValue();
    }

    /**
     * @param value Whether the operation affects state. Side effects such as producing audit trail entries do not count as 'affecting  state'.
     */
    public OperationDefinition setAffectsState(boolean value) { 
        if (this.affectsState == null)
          this.affectsState = new BooleanType();
        this.affectsState.setValue(value);
      return this;
    }

    /**
     * @return {@link #code} (The name used to invoke the operation.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
     */
    public CodeType getCodeElement() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeType(); // bb
      return this.code;
    }

    public boolean hasCodeElement() { 
      return this.code != null && !this.code.isEmpty();
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (The name used to invoke the operation.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
     */
    public OperationDefinition setCodeElement(CodeType value) { 
      this.code = value;
      return this;
    }

    /**
     * @return The name used to invoke the operation.
     */
    public String getCode() { 
      return this.code == null ? null : this.code.getValue();
    }

    /**
     * @param value The name used to invoke the operation.
     */
    public OperationDefinition setCode(String value) { 
        if (this.code == null)
          this.code = new CodeType();
        this.code.setValue(value);
      return this;
    }

    /**
     * @return {@link #comment} (Additional information about how to use this operation or named query.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
     */
    public MarkdownType getCommentElement() { 
      if (this.comment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.comment");
        else if (Configuration.doAutoCreate())
          this.comment = new MarkdownType(); // bb
      return this.comment;
    }

    public boolean hasCommentElement() { 
      return this.comment != null && !this.comment.isEmpty();
    }

    public boolean hasComment() { 
      return this.comment != null && !this.comment.isEmpty();
    }

    /**
     * @param value {@link #comment} (Additional information about how to use this operation or named query.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
     */
    public OperationDefinition setCommentElement(MarkdownType value) { 
      this.comment = value;
      return this;
    }

    /**
     * @return Additional information about how to use this operation or named query.
     */
    public String getComment() { 
      return this.comment == null ? null : this.comment.getValue();
    }

    /**
     * @param value Additional information about how to use this operation or named query.
     */
    public OperationDefinition setComment(String value) { 
      if (value == null)
        this.comment = null;
      else {
        if (this.comment == null)
          this.comment = new MarkdownType();
        this.comment.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #base} (Indicates that this operation definition is a constraining profile on the base.). This is the underlying object with id, value and extensions. The accessor "getBase" gives direct access to the value
     */
    public CanonicalType getBaseElement() { 
      if (this.base == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.base");
        else if (Configuration.doAutoCreate())
          this.base = new CanonicalType(); // bb
      return this.base;
    }

    public boolean hasBaseElement() { 
      return this.base != null && !this.base.isEmpty();
    }

    public boolean hasBase() { 
      return this.base != null && !this.base.isEmpty();
    }

    /**
     * @param value {@link #base} (Indicates that this operation definition is a constraining profile on the base.). This is the underlying object with id, value and extensions. The accessor "getBase" gives direct access to the value
     */
    public OperationDefinition setBaseElement(CanonicalType value) { 
      this.base = value;
      return this;
    }

    /**
     * @return Indicates that this operation definition is a constraining profile on the base.
     */
    public String getBase() { 
      return this.base == null ? null : this.base.getValue();
    }

    /**
     * @param value Indicates that this operation definition is a constraining profile on the base.
     */
    public OperationDefinition setBase(String value) { 
      if (Utilities.noString(value))
        this.base = null;
      else {
        if (this.base == null)
          this.base = new CanonicalType();
        this.base.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #resource} (The types on which this operation can be executed.)
     */
    public List<CodeType> getResource() { 
      if (this.resource == null)
        this.resource = new ArrayList<CodeType>();
      return this.resource;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public OperationDefinition setResource(List<CodeType> theResource) { 
      this.resource = theResource;
      return this;
    }

    public boolean hasResource() { 
      if (this.resource == null)
        return false;
      for (CodeType item : this.resource)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #resource} (The types on which this operation can be executed.)
     */
    public CodeType addResourceElement() {//2 
      CodeType t = new CodeType();
      if (this.resource == null)
        this.resource = new ArrayList<CodeType>();
      this.resource.add(t);
      return t;
    }

    /**
     * @param value {@link #resource} (The types on which this operation can be executed.)
     */
    public OperationDefinition addResource(String value) { //1
      CodeType t = new CodeType();
      t.setValue(value);
      if (this.resource == null)
        this.resource = new ArrayList<CodeType>();
      this.resource.add(t);
      return this;
    }

    /**
     * @param value {@link #resource} (The types on which this operation can be executed.)
     */
    public boolean hasResource(String value) { 
      if (this.resource == null)
        return false;
      for (CodeType v : this.resource)
        if (v.getValue().equals(value)) // code
          return true;
      return false;
    }

    /**
     * @return {@link #system} (Indicates whether this operation or named query can be invoked at the system level (e.g. without needing to choose a resource type for the context).). This is the underlying object with id, value and extensions. The accessor "getSystem" gives direct access to the value
     */
    public BooleanType getSystemElement() { 
      if (this.system == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.system");
        else if (Configuration.doAutoCreate())
          this.system = new BooleanType(); // bb
      return this.system;
    }

    public boolean hasSystemElement() { 
      return this.system != null && !this.system.isEmpty();
    }

    public boolean hasSystem() { 
      return this.system != null && !this.system.isEmpty();
    }

    /**
     * @param value {@link #system} (Indicates whether this operation or named query can be invoked at the system level (e.g. without needing to choose a resource type for the context).). This is the underlying object with id, value and extensions. The accessor "getSystem" gives direct access to the value
     */
    public OperationDefinition setSystemElement(BooleanType value) { 
      this.system = value;
      return this;
    }

    /**
     * @return Indicates whether this operation or named query can be invoked at the system level (e.g. without needing to choose a resource type for the context).
     */
    public boolean getSystem() { 
      return this.system == null || this.system.isEmpty() ? false : this.system.getValue();
    }

    /**
     * @param value Indicates whether this operation or named query can be invoked at the system level (e.g. without needing to choose a resource type for the context).
     */
    public OperationDefinition setSystem(boolean value) { 
        if (this.system == null)
          this.system = new BooleanType();
        this.system.setValue(value);
      return this;
    }

    /**
     * @return {@link #type} (Indicates whether this operation or named query can be invoked at the resource type level for any given resource type level (e.g. without needing to choose a specific resource id for the context).). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public BooleanType getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.type");
        else if (Configuration.doAutoCreate())
          this.type = new BooleanType(); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Indicates whether this operation or named query can be invoked at the resource type level for any given resource type level (e.g. without needing to choose a specific resource id for the context).). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public OperationDefinition setTypeElement(BooleanType value) { 
      this.type = value;
      return this;
    }

    /**
     * @return Indicates whether this operation or named query can be invoked at the resource type level for any given resource type level (e.g. without needing to choose a specific resource id for the context).
     */
    public boolean getType() { 
      return this.type == null || this.type.isEmpty() ? false : this.type.getValue();
    }

    /**
     * @param value Indicates whether this operation or named query can be invoked at the resource type level for any given resource type level (e.g. without needing to choose a specific resource id for the context).
     */
    public OperationDefinition setType(boolean value) { 
        if (this.type == null)
          this.type = new BooleanType();
        this.type.setValue(value);
      return this;
    }

    /**
     * @return {@link #instance} (Indicates whether this operation can be invoked on a particular instance of one of the given types.). This is the underlying object with id, value and extensions. The accessor "getInstance" gives direct access to the value
     */
    public BooleanType getInstanceElement() { 
      if (this.instance == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.instance");
        else if (Configuration.doAutoCreate())
          this.instance = new BooleanType(); // bb
      return this.instance;
    }

    public boolean hasInstanceElement() { 
      return this.instance != null && !this.instance.isEmpty();
    }

    public boolean hasInstance() { 
      return this.instance != null && !this.instance.isEmpty();
    }

    /**
     * @param value {@link #instance} (Indicates whether this operation can be invoked on a particular instance of one of the given types.). This is the underlying object with id, value and extensions. The accessor "getInstance" gives direct access to the value
     */
    public OperationDefinition setInstanceElement(BooleanType value) { 
      this.instance = value;
      return this;
    }

    /**
     * @return Indicates whether this operation can be invoked on a particular instance of one of the given types.
     */
    public boolean getInstance() { 
      return this.instance == null || this.instance.isEmpty() ? false : this.instance.getValue();
    }

    /**
     * @param value Indicates whether this operation can be invoked on a particular instance of one of the given types.
     */
    public OperationDefinition setInstance(boolean value) { 
        if (this.instance == null)
          this.instance = new BooleanType();
        this.instance.setValue(value);
      return this;
    }

    /**
     * @return {@link #inputProfile} (Additional validation information for the in parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource as a whole.). This is the underlying object with id, value and extensions. The accessor "getInputProfile" gives direct access to the value
     */
    public CanonicalType getInputProfileElement() { 
      if (this.inputProfile == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.inputProfile");
        else if (Configuration.doAutoCreate())
          this.inputProfile = new CanonicalType(); // bb
      return this.inputProfile;
    }

    public boolean hasInputProfileElement() { 
      return this.inputProfile != null && !this.inputProfile.isEmpty();
    }

    public boolean hasInputProfile() { 
      return this.inputProfile != null && !this.inputProfile.isEmpty();
    }

    /**
     * @param value {@link #inputProfile} (Additional validation information for the in parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource as a whole.). This is the underlying object with id, value and extensions. The accessor "getInputProfile" gives direct access to the value
     */
    public OperationDefinition setInputProfileElement(CanonicalType value) { 
      this.inputProfile = value;
      return this;
    }

    /**
     * @return Additional validation information for the in parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource as a whole.
     */
    public String getInputProfile() { 
      return this.inputProfile == null ? null : this.inputProfile.getValue();
    }

    /**
     * @param value Additional validation information for the in parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource as a whole.
     */
    public OperationDefinition setInputProfile(String value) { 
      if (Utilities.noString(value))
        this.inputProfile = null;
      else {
        if (this.inputProfile == null)
          this.inputProfile = new CanonicalType();
        this.inputProfile.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #outputProfile} (Additional validation information for the out parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource.). This is the underlying object with id, value and extensions. The accessor "getOutputProfile" gives direct access to the value
     */
    public CanonicalType getOutputProfileElement() { 
      if (this.outputProfile == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OperationDefinition.outputProfile");
        else if (Configuration.doAutoCreate())
          this.outputProfile = new CanonicalType(); // bb
      return this.outputProfile;
    }

    public boolean hasOutputProfileElement() { 
      return this.outputProfile != null && !this.outputProfile.isEmpty();
    }

    public boolean hasOutputProfile() { 
      return this.outputProfile != null && !this.outputProfile.isEmpty();
    }

    /**
     * @param value {@link #outputProfile} (Additional validation information for the out parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource.). This is the underlying object with id, value and extensions. The accessor "getOutputProfile" gives direct access to the value
     */
    public OperationDefinition setOutputProfileElement(CanonicalType value) { 
      this.outputProfile = value;
      return this;
    }

    /**
     * @return Additional validation information for the out parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource.
     */
    public String getOutputProfile() { 
      return this.outputProfile == null ? null : this.outputProfile.getValue();
    }

    /**
     * @param value Additional validation information for the out parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource.
     */
    public OperationDefinition setOutputProfile(String value) { 
      if (Utilities.noString(value))
        this.outputProfile = null;
      else {
        if (this.outputProfile == null)
          this.outputProfile = new CanonicalType();
        this.outputProfile.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #parameter} (The parameters for the operation/query.)
     */
    public List<OperationDefinitionParameterComponent> getParameter() { 
      if (this.parameter == null)
        this.parameter = new ArrayList<OperationDefinitionParameterComponent>();
      return this.parameter;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public OperationDefinition setParameter(List<OperationDefinitionParameterComponent> theParameter) { 
      this.parameter = theParameter;
      return this;
    }

    public boolean hasParameter() { 
      if (this.parameter == null)
        return false;
      for (OperationDefinitionParameterComponent item : this.parameter)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public OperationDefinitionParameterComponent addParameter() { //3
      OperationDefinitionParameterComponent t = new OperationDefinitionParameterComponent();
      if (this.parameter == null)
        this.parameter = new ArrayList<OperationDefinitionParameterComponent>();
      this.parameter.add(t);
      return t;
    }

    public OperationDefinition addParameter(OperationDefinitionParameterComponent t) { //3
      if (t == null)
        return this;
      if (this.parameter == null)
        this.parameter = new ArrayList<OperationDefinitionParameterComponent>();
      this.parameter.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #parameter}, creating it if it does not already exist {3}
     */
    public OperationDefinitionParameterComponent getParameterFirstRep() { 
      if (getParameter().isEmpty()) {
        addParameter();
      }
      return getParameter().get(0);
    }

    /**
     * @return {@link #overload} (Defines an appropriate combination of parameters to use when invoking this operation, to help code generators when generating overloaded parameter sets for this operation.)
     */
    public List<OperationDefinitionOverloadComponent> getOverload() { 
      if (this.overload == null)
        this.overload = new ArrayList<OperationDefinitionOverloadComponent>();
      return this.overload;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public OperationDefinition setOverload(List<OperationDefinitionOverloadComponent> theOverload) { 
      this.overload = theOverload;
      return this;
    }

    public boolean hasOverload() { 
      if (this.overload == null)
        return false;
      for (OperationDefinitionOverloadComponent item : this.overload)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public OperationDefinitionOverloadComponent addOverload() { //3
      OperationDefinitionOverloadComponent t = new OperationDefinitionOverloadComponent();
      if (this.overload == null)
        this.overload = new ArrayList<OperationDefinitionOverloadComponent>();
      this.overload.add(t);
      return t;
    }

    public OperationDefinition addOverload(OperationDefinitionOverloadComponent t) { //3
      if (t == null)
        return this;
      if (this.overload == null)
        this.overload = new ArrayList<OperationDefinitionOverloadComponent>();
      this.overload.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #overload}, creating it if it does not already exist {3}
     */
    public OperationDefinitionOverloadComponent getOverloadFirstRep() { 
      if (getOverload().isEmpty()) {
        addOverload();
      }
      return getOverload().get(0);
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getIdentifierMax() { 
      return 0;
    }
    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this operation definition when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public OperationDefinition setIdentifier(List<Identifier> theIdentifier) { 
      throw new Error("The resource type \"OperationDefinition\" does not implement the property \"identifier\"");
    }
    public boolean hasIdentifier() { 
      return false;
    }

    public Identifier addIdentifier() { //3
      throw new Error("The resource type \"OperationDefinition\" does not implement the property \"identifier\"");
    }
    public OperationDefinition addIdentifier(Identifier t) { //3
      throw new Error("The resource type \"OperationDefinition\" does not implement the property \"identifier\"");
    }
    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {2}
     */
    public Identifier getIdentifierFirstRep() { 
      throw new Error("The resource type \"OperationDefinition\" does not implement the property \"identifier\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getCopyrightMax() { 
      return 0;
    }
    /**
     * @return {@link #copyright} (A copyright statement relating to the operation definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the operation definition.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      throw new Error("The resource type \"OperationDefinition\" does not implement the property \"copyright\"");
    }

    public boolean hasCopyrightElement() { 
      return false;
    }
    public boolean hasCopyright() {
      return false;
    }

    /**
     * @param value {@link #copyright} (A copyright statement relating to the operation definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the operation definition.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public OperationDefinition setCopyrightElement(MarkdownType value) { 
      throw new Error("The resource type \"OperationDefinition\" does not implement the property \"copyright\"");
    }
    public String getCopyright() { 
      throw new Error("The resource type \"OperationDefinition\" does not implement the property \"copyright\"");
    }
    /**
     * @param value A copyright statement relating to the operation definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the operation definition.
     */
    public OperationDefinition setCopyright(String value) { 
      throw new Error("The resource type \"OperationDefinition\" does not implement the property \"copyright\"");
    }
      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this operation definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this operation definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the operation definition is stored on different servers.", 0, 1, url));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the operation definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the operation definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("name", "string", "A natural language name identifying the operation definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the operation definition.", 0, 1, title));
        children.add(new Property("status", "code", "The status of this operation definition. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("kind", "code", "Whether this is an operation or a named query.", 0, 1, kind));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this operation definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the operation definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the operation definition changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual that published the operation definition.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the operation definition from a consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate operation definition instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the operation definition is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explanation of why this operation definition is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("affectsState", "boolean", "Whether the operation affects state. Side effects such as producing audit trail entries do not count as 'affecting  state'.", 0, 1, affectsState));
        children.add(new Property("code", "code", "The name used to invoke the operation.", 0, 1, code));
        children.add(new Property("comment", "markdown", "Additional information about how to use this operation or named query.", 0, 1, comment));
        children.add(new Property("base", "canonical(OperationDefinition)", "Indicates that this operation definition is a constraining profile on the base.", 0, 1, base));
        children.add(new Property("resource", "code", "The types on which this operation can be executed.", 0, java.lang.Integer.MAX_VALUE, resource));
        children.add(new Property("system", "boolean", "Indicates whether this operation or named query can be invoked at the system level (e.g. without needing to choose a resource type for the context).", 0, 1, system));
        children.add(new Property("type", "boolean", "Indicates whether this operation or named query can be invoked at the resource type level for any given resource type level (e.g. without needing to choose a specific resource id for the context).", 0, 1, type));
        children.add(new Property("instance", "boolean", "Indicates whether this operation can be invoked on a particular instance of one of the given types.", 0, 1, instance));
        children.add(new Property("inputProfile", "canonical(StructureDefinition)", "Additional validation information for the in parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource as a whole.", 0, 1, inputProfile));
        children.add(new Property("outputProfile", "canonical(StructureDefinition)", "Additional validation information for the out parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource.", 0, 1, outputProfile));
        children.add(new Property("parameter", "", "The parameters for the operation/query.", 0, java.lang.Integer.MAX_VALUE, parameter));
        children.add(new Property("overload", "", "Defines an appropriate combination of parameters to use when invoking this operation, to help code generators when generating overloaded parameter sets for this operation.", 0, java.lang.Integer.MAX_VALUE, overload));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this operation definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this operation definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the operation definition is stored on different servers.", 0, 1, url);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the operation definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the operation definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the operation definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the operation definition.", 0, 1, title);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this operation definition. Enables tracking the life-cycle of the content.", 0, 1, status);
        case 3292052: /*kind*/  return new Property("kind", "code", "Whether this is an operation or a named query.", 0, 1, kind);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this operation definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the operation definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the operation definition changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual that published the operation definition.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the operation definition from a consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate operation definition instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the operation definition is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this operation definition is needed and why it has been designed as it has.", 0, 1, purpose);
        case -14805197: /*affectsState*/  return new Property("affectsState", "boolean", "Whether the operation affects state. Side effects such as producing audit trail entries do not count as 'affecting  state'.", 0, 1, affectsState);
        case 3059181: /*code*/  return new Property("code", "code", "The name used to invoke the operation.", 0, 1, code);
        case 950398559: /*comment*/  return new Property("comment", "markdown", "Additional information about how to use this operation or named query.", 0, 1, comment);
        case 3016401: /*base*/  return new Property("base", "canonical(OperationDefinition)", "Indicates that this operation definition is a constraining profile on the base.", 0, 1, base);
        case -341064690: /*resource*/  return new Property("resource", "code", "The types on which this operation can be executed.", 0, java.lang.Integer.MAX_VALUE, resource);
        case -887328209: /*system*/  return new Property("system", "boolean", "Indicates whether this operation or named query can be invoked at the system level (e.g. without needing to choose a resource type for the context).", 0, 1, system);
        case 3575610: /*type*/  return new Property("type", "boolean", "Indicates whether this operation or named query can be invoked at the resource type level for any given resource type level (e.g. without needing to choose a specific resource id for the context).", 0, 1, type);
        case 555127957: /*instance*/  return new Property("instance", "boolean", "Indicates whether this operation can be invoked on a particular instance of one of the given types.", 0, 1, instance);
        case 676942463: /*inputProfile*/  return new Property("inputProfile", "canonical(StructureDefinition)", "Additional validation information for the in parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource as a whole.", 0, 1, inputProfile);
        case 1826166120: /*outputProfile*/  return new Property("outputProfile", "canonical(StructureDefinition)", "Additional validation information for the out parameters - a single profile that covers all the parameters. The profile is a constraint on the parameters resource.", 0, 1, outputProfile);
        case 1954460585: /*parameter*/  return new Property("parameter", "", "The parameters for the operation/query.", 0, java.lang.Integer.MAX_VALUE, parameter);
        case 529823674: /*overload*/  return new Property("overload", "", "Defines an appropriate combination of parameters to use when invoking this operation, to help code generators when generating overloaded parameter sets for this operation.", 0, java.lang.Integer.MAX_VALUE, overload);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case 3292052: /*kind*/ return this.kind == null ? new Base[0] : new Base[] {this.kind}; // Enumeration<OperationKind>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case -14805197: /*affectsState*/ return this.affectsState == null ? new Base[0] : new Base[] {this.affectsState}; // BooleanType
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeType
        case 950398559: /*comment*/ return this.comment == null ? new Base[0] : new Base[] {this.comment}; // MarkdownType
        case 3016401: /*base*/ return this.base == null ? new Base[0] : new Base[] {this.base}; // CanonicalType
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : this.resource.toArray(new Base[this.resource.size()]); // CodeType
        case -887328209: /*system*/ return this.system == null ? new Base[0] : new Base[] {this.system}; // BooleanType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // BooleanType
        case 555127957: /*instance*/ return this.instance == null ? new Base[0] : new Base[] {this.instance}; // BooleanType
        case 676942463: /*inputProfile*/ return this.inputProfile == null ? new Base[0] : new Base[] {this.inputProfile}; // CanonicalType
        case 1826166120: /*outputProfile*/ return this.outputProfile == null ? new Base[0] : new Base[] {this.outputProfile}; // CanonicalType
        case 1954460585: /*parameter*/ return this.parameter == null ? new Base[0] : this.parameter.toArray(new Base[this.parameter.size()]); // OperationDefinitionParameterComponent
        case 529823674: /*overload*/ return this.overload == null ? new Base[0] : this.overload.toArray(new Base[this.overload.size()]); // OperationDefinitionOverloadComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116079: // url
          this.url = TypeConvertor.castToUri(value); // UriType
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case 3292052: // kind
          value = new OperationKindEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<OperationKind>
          return value;
        case -404562712: // experimental
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1447404028: // publisher
          this.publisher = TypeConvertor.castToString(value); // StringType
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -669707736: // useContext
          this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
          return value;
        case -507075711: // jurisdiction
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -220463842: // purpose
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -14805197: // affectsState
          this.affectsState = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 950398559: // comment
          this.comment = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 3016401: // base
          this.base = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -341064690: // resource
          this.getResource().add(TypeConvertor.castToCode(value)); // CodeType
          return value;
        case -887328209: // system
          this.system = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 555127957: // instance
          this.instance = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 676942463: // inputProfile
          this.inputProfile = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 1826166120: // outputProfile
          this.outputProfile = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 1954460585: // parameter
          this.getParameter().add((OperationDefinitionParameterComponent) value); // OperationDefinitionParameterComponent
          return value;
        case 529823674: // overload
          this.getOverload().add((OperationDefinitionOverloadComponent) value); // OperationDefinitionOverloadComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("kind")) {
          value = new OperationKindEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<OperationKind>
        } else if (name.equals("experimental")) {
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("publisher")) {
          this.publisher = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("jurisdiction")) {
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("purpose")) {
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("affectsState")) {
          this.affectsState = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("comment")) {
          this.comment = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("base")) {
          this.base = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("resource")) {
          this.getResource().add(TypeConvertor.castToCode(value));
        } else if (name.equals("system")) {
          this.system = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("instance")) {
          this.instance = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("inputProfile")) {
          this.inputProfile = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("outputProfile")) {
          this.outputProfile = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("parameter")) {
          this.getParameter().add((OperationDefinitionParameterComponent) value);
        } else if (name.equals("overload")) {
          this.getOverload().add((OperationDefinitionOverloadComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case 351608024:  return getVersionElement();
        case 3373707:  return getNameElement();
        case 110371416:  return getTitleElement();
        case -892481550:  return getStatusElement();
        case 3292052:  return getKindElement();
        case -404562712:  return getExperimentalElement();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case -14805197:  return getAffectsStateElement();
        case 3059181:  return getCodeElement();
        case 950398559:  return getCommentElement();
        case 3016401:  return getBaseElement();
        case -341064690:  return addResourceElement();
        case -887328209:  return getSystemElement();
        case 3575610:  return getTypeElement();
        case 555127957:  return getInstanceElement();
        case 676942463:  return getInputProfileElement();
        case 1826166120:  return getOutputProfileElement();
        case 1954460585:  return addParameter(); 
        case 529823674:  return addOverload(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 3292052: /*kind*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case -14805197: /*affectsState*/ return new String[] {"boolean"};
        case 3059181: /*code*/ return new String[] {"code"};
        case 950398559: /*comment*/ return new String[] {"markdown"};
        case 3016401: /*base*/ return new String[] {"canonical"};
        case -341064690: /*resource*/ return new String[] {"code"};
        case -887328209: /*system*/ return new String[] {"boolean"};
        case 3575610: /*type*/ return new String[] {"boolean"};
        case 555127957: /*instance*/ return new String[] {"boolean"};
        case 676942463: /*inputProfile*/ return new String[] {"canonical"};
        case 1826166120: /*outputProfile*/ return new String[] {"canonical"};
        case 1954460585: /*parameter*/ return new String[] {};
        case 529823674: /*overload*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.url");
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.version");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.title");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.status");
        }
        else if (name.equals("kind")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.kind");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.purpose");
        }
        else if (name.equals("affectsState")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.affectsState");
        }
        else if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.code");
        }
        else if (name.equals("comment")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.comment");
        }
        else if (name.equals("base")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.base");
        }
        else if (name.equals("resource")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.resource");
        }
        else if (name.equals("system")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.system");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.type");
        }
        else if (name.equals("instance")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.instance");
        }
        else if (name.equals("inputProfile")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.inputProfile");
        }
        else if (name.equals("outputProfile")) {
          throw new FHIRException("Cannot call addChild on a primitive type OperationDefinition.outputProfile");
        }
        else if (name.equals("parameter")) {
          return addParameter();
        }
        else if (name.equals("overload")) {
          return addOverload();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "OperationDefinition";

  }

      public OperationDefinition copy() {
        OperationDefinition dst = new OperationDefinition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(OperationDefinition dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        dst.version = version == null ? null : version.copy();
        dst.name = name == null ? null : name.copy();
        dst.title = title == null ? null : title.copy();
        dst.status = status == null ? null : status.copy();
        dst.kind = kind == null ? null : kind.copy();
        dst.experimental = experimental == null ? null : experimental.copy();
        dst.date = date == null ? null : date.copy();
        dst.publisher = publisher == null ? null : publisher.copy();
        if (contact != null) {
          dst.contact = new ArrayList<ContactDetail>();
          for (ContactDetail i : contact)
            dst.contact.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
        if (jurisdiction != null) {
          dst.jurisdiction = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : jurisdiction)
            dst.jurisdiction.add(i.copy());
        };
        dst.purpose = purpose == null ? null : purpose.copy();
        dst.affectsState = affectsState == null ? null : affectsState.copy();
        dst.code = code == null ? null : code.copy();
        dst.comment = comment == null ? null : comment.copy();
        dst.base = base == null ? null : base.copy();
        if (resource != null) {
          dst.resource = new ArrayList<CodeType>();
          for (CodeType i : resource)
            dst.resource.add(i.copy());
        };
        dst.system = system == null ? null : system.copy();
        dst.type = type == null ? null : type.copy();
        dst.instance = instance == null ? null : instance.copy();
        dst.inputProfile = inputProfile == null ? null : inputProfile.copy();
        dst.outputProfile = outputProfile == null ? null : outputProfile.copy();
        if (parameter != null) {
          dst.parameter = new ArrayList<OperationDefinitionParameterComponent>();
          for (OperationDefinitionParameterComponent i : parameter)
            dst.parameter.add(i.copy());
        };
        if (overload != null) {
          dst.overload = new ArrayList<OperationDefinitionOverloadComponent>();
          for (OperationDefinitionOverloadComponent i : overload)
            dst.overload.add(i.copy());
        };
      }

      protected OperationDefinition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof OperationDefinition))
          return false;
        OperationDefinition o = (OperationDefinition) other_;
        return compareDeep(url, o.url, true) && compareDeep(version, o.version, true) && compareDeep(name, o.name, true)
           && compareDeep(title, o.title, true) && compareDeep(status, o.status, true) && compareDeep(kind, o.kind, true)
           && compareDeep(experimental, o.experimental, true) && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true)
           && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(purpose, o.purpose, true) && compareDeep(affectsState, o.affectsState, true)
           && compareDeep(code, o.code, true) && compareDeep(comment, o.comment, true) && compareDeep(base, o.base, true)
           && compareDeep(resource, o.resource, true) && compareDeep(system, o.system, true) && compareDeep(type, o.type, true)
           && compareDeep(instance, o.instance, true) && compareDeep(inputProfile, o.inputProfile, true) && compareDeep(outputProfile, o.outputProfile, true)
           && compareDeep(parameter, o.parameter, true) && compareDeep(overload, o.overload, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof OperationDefinition))
          return false;
        OperationDefinition o = (OperationDefinition) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(status, o.status, true) && compareValues(kind, o.kind, true)
           && compareValues(experimental, o.experimental, true) && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true)
           && compareValues(description, o.description, true) && compareValues(purpose, o.purpose, true) && compareValues(affectsState, o.affectsState, true)
           && compareValues(code, o.code, true) && compareValues(comment, o.comment, true) && compareValues(base, o.base, true)
           && compareValues(resource, o.resource, true) && compareValues(system, o.system, true) && compareValues(type, o.type, true)
           && compareValues(instance, o.instance, true) && compareValues(inputProfile, o.inputProfile, true) && compareValues(outputProfile, o.outputProfile, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, version, name, title
          , status, kind, experimental, date, publisher, contact, description, useContext
          , jurisdiction, purpose, affectsState, code, comment, base, resource, system
          , type, instance, inputProfile, outputProfile, parameter, overload);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.OperationDefinition;
   }

// Manual code (from Configuration.txt):
  public boolean supportsCopyright() {
    return false;
  }

// end addition

}

