package com.intellij.hibernate.facet;

import com.intellij.persistence.model.PersistencePackage;
import com.intellij.openapi.extensions.ExtensionPointName;
import javax.annotation.Nonnull;

import java.util.List;

/**
 * @author Gregory.Shrago
 */
public interface HibernateSessionFactoryProvider {
  ExtensionPointName<HibernateSessionFactoryProvider> EP_NAME = ExtensionPointName.create("com.intellij.hibernate.sessionFactoryProvider");

  @Nonnull
  List<PersistencePackage> getSessionFactories(final HibernateFacet facet);
}
