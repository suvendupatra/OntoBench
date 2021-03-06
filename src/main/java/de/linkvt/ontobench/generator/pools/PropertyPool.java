package de.linkvt.ontobench.generator.pools;

import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.PrefixManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * An owl object property pool.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PropertyPool extends ResourcePool<OWLObjectProperty> {
  private final OWLDataFactory factory;
  private final PrefixManager prefixManager;

  @Autowired
  public PropertyPool(OWLDataFactory factory, PrefixManager prefixManager) {
    this.factory = factory;
    this.prefixManager = prefixManager;
  }

  @Override
  public OWLObjectProperty getExclusiveObject(String name) {
    return factory.getOWLObjectProperty(name, prefixManager);
  }

  @Override
  protected String getGenericNameBase() {
    return ":Property";
  }

}
