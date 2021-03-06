package de.linkvt.ontobench.features.annotations.ontology.rdfs;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class RdfsLabelMultiLanguageFeature extends Feature {

  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":propertyWithInfos");
    OWLClass range = featurePool.getExclusiveClass(":ClassWithInfos");
    OWLAnnotationProperty label = factory.getRDFSLabel();

    OWLAnnotation enAnnotation = factory.getOWLAnnotation(label, factory.getOWLLiteral("Label of a property", Locale.ENGLISH.getLanguage()));
    OWLAnnotation deAnnotation = factory.getOWLAnnotation(label, factory.getOWLLiteral("Bezeichnung einer Property", Locale.GERMAN.getLanguage()));
    OWLAnnotation jpAnnotation = factory.getOWLAnnotation(label, factory.getOWLLiteral("プロパティの指定", Locale.JAPANESE.getLanguage()));

    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), deAnnotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), enAnnotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(property.getIRI(), jpAnnotation));

    OWLAnnotation enClassAnnotation = factory.getOWLAnnotation(label, factory.getOWLLiteral("Label of a class", Locale.ENGLISH.getLanguage()));
    OWLAnnotation deClassAnnotation = factory.getOWLAnnotation(label, factory.getOWLLiteral("Bezeichnung einer Klasse", Locale.GERMAN.getLanguage()));
    OWLAnnotation jpClassAnnotation = factory.getOWLAnnotation(label, factory.getOWLLiteral("どうもありがとうミスターロボット", Locale.JAPANESE.getLanguage()));

    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(range.getIRI(), enClassAnnotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(range.getIRI(), deClassAnnotation));
    addAxiomToOntology(factory.getOWLAnnotationAssertionAxiom(range.getIRI(), jpClassAnnotation));


    addToGenericDomainAndNewRange(property, range);
  }

  @Override
  public String getName() {
    return "rdfs:label";
  }

  @Override
  public String getClarification() {
    return "on Class & Property, multilingual";
  }

  @Override
  public String getToken() {
    return "rdfslabelmultilanguage";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
