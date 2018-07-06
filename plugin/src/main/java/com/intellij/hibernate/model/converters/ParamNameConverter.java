package com.intellij.hibernate.model.converters;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.intellij.codeInsight.daemon.EmptyResolveMessageProvider;
import com.intellij.hibernate.HibernateManager;
import com.intellij.hibernate.HibernateMessages;
import com.intellij.util.xml.Converter;
import com.intellij.util.xml.WrappingConverter;
import com.intellij.util.xml.GenericDomValue;

/**
 * @author Gregory.Shrago
 */
public class ParamNameConverter extends WrappingConverter implements EmptyResolveMessageProvider {
  @Nullable
  public Converter getConverter(@Nonnull final GenericDomValue domElement) {
    return HibernateManager.getInstance(domElement.getManager().getProject()).getConvertersRegistry().getNameConverter(domElement.getParent());
  }

  public String getUnresolvedMessagePattern() {
    return HibernateMessages.message("cannot.resolve.parameter.name.0");
  }
}