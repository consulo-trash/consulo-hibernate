package com.intellij.hibernate.model.xml.mapping;

import com.intellij.jam.model.common.CommonDomModelElement;

/**
 * @author Gregory.Shrago
 */
public interface HbmAttributeContainerBase extends CommonDomModelElement
{
  void visitAttributes(final HbmAttributeVisitor visitor);
}