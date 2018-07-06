/*
 * Copyright (c) 2000-2006 JetBrains s.r.o. All Rights Reserved.
 */

package com.intellij.hibernate.highlighting;

import javax.annotation.Nonnull;

import com.intellij.hibernate.HibernateMessages;
import com.intellij.hibernate.model.HibernateConstants;
import com.intellij.hibernate.model.xml.config.HibernateConfiguration;
import com.intellij.util.xml.highlighting.BasicDomElementsInspection;
import com.intellij.util.xml.highlighting.DomElementAnnotationHolder;
import com.intellij.util.xml.highlighting.DomHighlightingHelper;
import com.intellij.util.xml.DomElement;
import com.intellij.util.xml.GenericDomValue;
import com.intellij.util.xml.impl.ExtendsClassChecker;
import org.jetbrains.annotations.NonNls;

/**
 * @author Gregory.Shrago
 */
public class HibernateConfigDomInspection extends BasicDomElementsInspection<HibernateConfiguration> {

  public HibernateConfigDomInspection() {
    super(HibernateConfiguration.class);
  }

  protected void checkDomElement(final DomElement element, final DomElementAnnotationHolder holder, final DomHighlightingHelper helper) {
    final int oldSize = holder.getSize();
    super.checkDomElement(element, holder, helper);

    if (oldSize == holder.getSize() && element instanceof GenericDomValue) {
      ExtendsClassChecker.checkExtendsClassInReferences((GenericDomValue)element, holder);
    }
  }
  

  @Nonnull
  public String getGroupDisplayName() {
    return HibernateConstants.HIBERNATE_INSPECTIONS_GROUP;
  }

  @Nonnull
  public String getDisplayName() {
    return HibernateMessages.message("inspection.name.hibernate.configuration");
  }

  @Nonnull
  @NonNls
  public String getShortName() {
    return "HibernateConfigDomInspection";
  }

}