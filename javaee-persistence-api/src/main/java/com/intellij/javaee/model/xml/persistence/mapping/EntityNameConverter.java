package com.intellij.javaee.model.xml.persistence.mapping;

import javax.annotation.Nullable;

import org.jetbrains.annotations.NonNls;
import com.intellij.persistence.model.PersistentEntity;
import com.intellij.util.xml.ConvertContext;
import com.intellij.util.xml.Converter;

public class EntityNameConverter extends Converter<String>
{
	@Nullable
	@Override
	public String fromString(@Nullable @NonNls String s, ConvertContext convertContext)
	{
		return null;
	}

	@Nullable
	@Override
	public String toString(@Nullable String s, ConvertContext convertContext)
	{
		return null;
	}

	@Nullable
	protected String getEntityName(final PersistentEntity entity)
	{
		return null;
	}
}
