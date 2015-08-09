package de.linkvt.bachelor.features.classes.values.data;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataHasValueFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDataProperty property = factory.getOWLDataProperty(IRI.create("hasValueData"));
    OWLDataHasValue hasValue = factory.getOWLDataHasValue(property, factory.getOWLLiteral(6));
    addToGenericDomainAndNewRange(property, OWL2Datatype.XSD_POSITIVE_INTEGER.getDatatype(factory));

    OWLClass range = featurePool.getReusableClass("HasValueDataRange");
    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, hasValue));
  }

  @Override
  public String getName() {
    return "owl:hasValue (Data Property)";
  }

  @Override
  public String getToken() {
    return "hasvaluedata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.CLASS;
  }
}
