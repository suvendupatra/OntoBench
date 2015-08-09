package de.linkvt.bachelor.features.annotations.ontology.dc;

import com.google.common.base.Optional;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;
import de.linkvt.bachelor.features.annotations.ontology.OntologyConstants;

import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.vocab.Namespaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DcIdentifierFeature extends Feature {

  @Autowired
  private OntologyConstants ontologyConstants;

  @Override
  public void addToOntology() {
    OWLAnnotationProperty property = factory.getOWLAnnotationProperty(IRI.create(Namespaces.DC + "identifier"));

    Optional<IRI> optionalIri = ontology.getOntologyID().getOntologyIRI();
    if (optionalIri.isPresent()) {
      String iri = optionalIri.get().toString();
      OWLAnnotation identifier = factory.getOWLAnnotation(property, factory.getOWLLiteral(iri));

      addChangeToOntology(new AddOntologyAnnotation(ontology, identifier));
    }
  }

  @Override
  public String getName() {
    return "dc:identifier";
  }

  @Override
  public String getToken() {
    return "dcidentifier";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DC;
  }
}