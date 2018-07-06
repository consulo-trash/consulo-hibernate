package com.intellij.javaee.model.role;

import javax.annotation.Nonnull;

import com.intellij.openapi.util.Key;
import com.intellij.openapi.util.UserDataHolder;
import com.intellij.persistence.roles.PersistenceClassRole;

/**
 * TODO [VISTALL] STUB!!!
 */
public interface ClassRoleManager extends UserDataHolder
{
	<T> T getUserData(Key<PersistenceClassRole> key, @Nonnull Key<T> value);
}
