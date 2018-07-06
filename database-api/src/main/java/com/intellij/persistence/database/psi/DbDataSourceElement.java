package com.intellij.persistence.database.psi;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.intellij.persistence.database.DataSourceInfo;
import com.intellij.persistence.database.DatabaseConnectionInfo;
import com.intellij.util.ArrayFactory;

/**
 * @author Gregory.Shrago
 */
public interface DbDataSourceElement extends DbElement, DataSourceInfo
{
	DbDataSourceElement[] EMPTY_ARRAY = new DbDataSourceElement[0];

	ArrayFactory<DbDataSourceElement> ARRAY_FACTORY = i -> i == 0 ? EMPTY_ARRAY : new DbDataSourceElement[i];

	@Nullable
	DatabaseConnectionInfo getConnectionInfo();

	@Nonnull
	DbTableElement[] getMyTables();

	@Nonnull
	DbCatalogElement[] getCatalogs();

	@Nonnull
	DbSchemaElement[] getSchemas();

	@Nullable
	DbTableElement findTable(final String table, final String schema, final String catalog);

	void clearCaches();

}
