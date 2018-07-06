package com.intellij.persistence;

import javax.swing.Icon;

import com.intellij.openapi.util.IconLoader;

/**
 * @author Gregory.Shrago
 */
public interface DatabaseIcons {
//  Icon DATASOURCE_ICON = Icons.DATASOURCE_ICON;
//  Icon DATASOURCE_DISABLED_ICON = Icons.DATASOURCE_DISABLED_ICON;
//  Icon DATASOURCE_TABLE_ICON = Icons.DATASOURCE_TABLE_ICON;
//  Icon DATASOURCE_VIEW_ICON = Icons.DATASOURCE_VIEW_ICON;
//  Icon DATASOURCE_SEQUENCE_ICON = Icons.DATASOURCE_SEQUENCE_ICON;
//  Icon DATASOURCE_COLUMN_ICON = Icons.DATASOURCE_COLUMN_ICON;
//  Icon DATASOURCE_FK_COLUMN_ICON = Icons.DATASOURCE_FK_COLUMN_ICON;
//  Icon DATASOURCE_PK_COLUMN_ICON = Icons.DATASOURCE_PK_COLUMN_ICON;

  Icon OVR_BINARY = IconLoader.getIcon("/javaee/typeBinary.png");
  Icon OVR_DATE_TIME = IconLoader.getIcon("/javaee/typeDateTime.png");
  Icon OVR_NUMERIC = IconLoader.getIcon("/javaee/typeNumeric.png");
  Icon OVR_STRING = IconLoader.getIcon("/javaee/typeString.png");

  Icon OVR_NULLABLE = IconLoader.getIcon("/javaee/typeNullable.png");
  Icon OVR_NOTNULL = IconLoader.getIcon("/javaee/typeNotNull.png");

  Icon CONSOLE_ICON = IconLoader.getIcon("/runConfigurations/ql_console.png");
  Icon CONSOLE_OUTPUT_ICON = IconLoader.getIcon("/debugger/console.png");
  Icon SQL_ICON = IconLoader.getIcon("/nodes/sql.png");

  Icon IMPORT_DATASOURCES = IconLoader.getIcon("/javaee/persistenceRelationship.png");

  Icon PROPERTIES_ICON = IconLoader.getIcon("/actions/properties.png");
  Icon SYNCHRONIZE_ICON = IconLoader.getIcon("/actions/sync.png");
  Icon SELECT_ALL_ICON = IconLoader.getIcon("/actions/selectall.png");
  Icon UNSELECT_ALL_ICON = IconLoader.getIcon("/actions/unselectall.png");

}
