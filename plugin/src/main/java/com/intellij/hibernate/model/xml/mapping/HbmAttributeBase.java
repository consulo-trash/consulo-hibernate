package com.intellij.hibernate.model.xml.mapping;

import javax.annotation.Nullable;

import com.intellij.hibernate.model.converters.AttributeMemberConverter;
import com.intellij.hibernate.model.enums.AccessType;
import com.intellij.jam.model.common.CommonDomModelElement;
import com.intellij.persistence.model.PersistentAttribute;
import com.intellij.psi.PsiMember;
import com.intellij.util.xml.Attribute;
import com.intellij.util.xml.Convert;
import com.intellij.util.xml.GenericAttributeValue;
import com.intellij.util.xml.MutableGenericValue;
import com.intellij.util.xml.NameValue;
import com.intellij.util.xml.PrimaryKey;

/**
 * @author Gregory.Shrago
 */
public interface HbmAttributeBase extends CommonDomModelElement, PersistentAttribute {

  @PrimaryKey
  MutableGenericValue<String> getName();

  GenericAttributeValue<AccessType> getAccess();

  @Nullable
  PsiMember getPsiMember();

  @NameValue
  @Attribute("name")
  @Convert(AttributeMemberConverter.class)
  GenericAttributeValue<PsiMember> getTargetMember();

}
