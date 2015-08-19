package de.linkvt.bachelor.features.classexpressions.restrictions.object.cardinality;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectCardinalityOwlLiteFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getReusablePropertyAndRemoveFromPool();
    OWLClass range = featurePool.getExclusiveClass(":CardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectExactCardinality exactCardinality = factory.getOWLObjectExactCardinality(1, property);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, exactCardinality));
  }

  @Override
  public String getName() {
    return "owl:cardinality (Object Property, OWL Lite)";
  }

  @Override
  public String getToken() {
    return "cardinalitylite";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}