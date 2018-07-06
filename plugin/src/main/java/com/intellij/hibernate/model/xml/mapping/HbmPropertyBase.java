/*
 * Copyright (c) 2000-2007 JetBrains s.r.o. All Rights Reserved.
 */

// Generated on Fri Nov 17 19:09:30 MSK 2006
// DTD/Schema  :    hibernate-mapping-3.0.dtd

package com.intellij.hibernate.model.xml.mapping;

import com.intellij.javaee.model.xml.CommonDomModelElement;
import com.intellij.util.xml.GenericAttributeValue;
import javax.annotation.Nonnull;

import java.util.List;

public interface HbmPropertyBase extends CommonDomModelElement, HbmAttributeBase, HbmColumnsHolderBase, HbmTypeHolderBase {

	@Nonnull
	GenericAttributeValue<String> getNode();

	@Nonnull
	GenericAttributeValue<Integer> getLength();

	@Nonnull
	List<HbmMeta> getMetas();
	HbmMeta addMeta();

}