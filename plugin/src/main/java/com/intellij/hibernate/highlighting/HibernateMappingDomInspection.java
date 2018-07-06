/*
 * Copyright (c) 2000-2006 JetBrains s.r.o. All Rights Reserved.
 */

package com.intellij.hibernate.highlighting;

import javax.annotation.Nonnull;

import com.intellij.hibernate.HibernateMessages;
import com.intellij.hibernate.model.HibernateConstants;
import com.intellij.hibernate.model.xml.mapping.HbmHibernateMapping;
import com.intellij.javaee.model.JavaeePersistenceORMResolveConverters;
import com.intellij.util.xml.Converter;
import com.intellij.util.xml.DomElement;
import com.intellij.util.xml.GenericDomValue;
import com.intellij.util.xml.WrappingConverter;
import com.intellij.util.xml.highlighting.BasicDomElementsInspection;
import com.intellij.util.xml.highlighting.DomElementAnnotationHolder;
import com.intellij.util.xml.highlighting.DomHighlightingHelper;
import org.jetbrains.annotations.NonNls;

/**
 * @author Gregory.Shrago
 */
public class HibernateMappingDomInspection extends BasicDomElementsInspection<HbmHibernateMapping> {

  public HibernateMappingDomInspection() {
    super(HbmHibernateMapping.class);
  }

  @Nonnull
  public String getGroupDisplayName() {
    return HibernateConstants.HIBERNATE_INSPECTIONS_GROUP;
  }

  @Nonnull
  public String getDisplayName() {
    return HibernateMessages.message("inspection.name.hibernate.mapping");
  }

  @Nonnull
  @NonNls
  public String getShortName() {
    return "HibernateMappingDomInspection";
  }

  protected boolean shouldCheckResolveProblems(final GenericDomValue value) {
    final Converter realConverter = WrappingConverter.getDeepestConverter(value.getConverter(), value);
    return !(realConverter instanceof JavaeePersistenceORMResolveConverters.ResolverBase);
  }

  protected void checkDomElement(final DomElement element, final DomElementAnnotationHolder holder, final DomHighlightingHelper helper) {
    final int oldSize = holder.getSize();
    element.accept(new HibernateMappingHighlightingVisitor(holder));
    if (oldSize == holder.getSize()) {
      super.checkDomElement(element, holder, helper);
    }
  }
}