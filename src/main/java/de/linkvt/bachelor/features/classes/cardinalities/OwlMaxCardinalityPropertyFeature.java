package de.linkvt.bachelor.features.classes.cardinalities;

import de.linkvt.bachelor.features.Feature;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

/**
 * An owl functional property.
 */
@Component
public class OwlMaxCardinalityPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getReusablePropertyAndRemoveFromPool();
    OWLClass range = featurePool.getExclusiveClass("MaxCardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectMaxCardinality maxCardinality = factory.getOWLObjectMaxCardinality(8, property);
    OWLAxiom axiom = factory.getOWLSubClassOfAxiom(range, maxCardinality);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:maxCardinality";
  }

  @Override
  public String getToken() {
    return "maxcardinality";
  }
}