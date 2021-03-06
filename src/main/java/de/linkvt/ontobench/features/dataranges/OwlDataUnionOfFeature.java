package de.linkvt.ontobench.features.dataranges;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataUnionOf;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataUnionOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype d1 = factory.getOWLDatatype(":DataUnionOf_Datatype1", pm);
    OWLDatatype d2 = factory.getOWLDatatype(":DataUnionOf_Datatype2", pm);
    OWLDataUnionOf union = factory.getOWLDataUnionOf(d1, d2);

    OWLDataProperty property = factory.getOWLDataProperty(":DataUnionOf", pm);
    addToGenericDomainAndNewRange(property, union);
  }

  @Override
  public String getName() {
    return "owl:unionOf";
  }

  @Override
  public String getToken() {
    return "uniondata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_RANGES;
  }
}
