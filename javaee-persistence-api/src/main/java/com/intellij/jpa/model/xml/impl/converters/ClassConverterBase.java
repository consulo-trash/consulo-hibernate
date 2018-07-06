package com.intellij.jpa.model.xml.impl.converters;


import javax.annotation.Nullable;

import org.jetbrains.annotations.NonNls;
import com.intellij.psi.PsiClass;
import com.intellij.util.xml.ConvertContext;
import com.intellij.util.xml.Converter;

public class ClassConverterBase  extends Converter<PsiClass>
{
	@Nullable
	@Override
	public PsiClass fromString(@Nullable @NonNls String s, ConvertContext convertContext)
	{
		return null;
	}

	@Nullable
	@Override
	public String toString(@Nullable PsiClass psiClass, ConvertContext convertContext)
	{
		return null;
	}
}
