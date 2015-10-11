package de.linkvt.bachelor.features.dataranges;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDatatype;
import org.springframework.stereotype.Component;

@Component
public class RdfsDatatypeFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype datatype = factory.getOWLDatatype(":RdfsDatatype", pm);
    addAxiomToOntology(factory.getOWLDeclarationAxiom(datatype));
  }

  @Override
  public String getName() {
    return "rdfs:Datatype";
  }

  @Override
  public String getToken() {
    return "datatype";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_RANGES;
  }

  @Override
  public boolean isGeneral() {
    return true;
  }
}
