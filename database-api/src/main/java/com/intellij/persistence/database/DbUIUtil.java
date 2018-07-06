package com.intellij.persistence.database;

import java.util.Arrays;
import java.util.Comparator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;

import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.persistence.database.psi.DbDataSourceElement;
import com.intellij.ui.ColoredListCellRenderer;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.util.ArrayUtil;

/**
 * @author Gregory.Shrago
 */
public class DbUIUtil
{
	private DbUIUtil()
	{
	}

	public static void configureDataSourceComboBox(final JComboBox comboBox, final DbDataSourceElement[] dataSources)
	{
		configureDataSourceComboBox(comboBox, dataSources, false);

	}

	public static void configureDataSourceComboBox(final JComboBox comboBox, final DbDataSourceElement[] dataSources, boolean allowNull)
	{
		Arrays.sort(dataSources, new Comparator<DataSourceInfo>()
		{
			public int compare(final DataSourceInfo o1, final DataSourceInfo o2)
			{
				return Comparing.compare(StringUtil.toLowerCase(o1.getName()), StringUtil.toLowerCase(o2.getName()));
			}
		});
		final DbDataSourceElement[] items = allowNull ? ArrayUtil.mergeArrays(new DbDataSourceElement[]{null}, dataSources, DbDataSourceElement.ARRAY_FACTORY) : dataSources;
		comboBox.setModel(new DefaultComboBoxModel(items));
		comboBox.setRenderer(new ColoredListCellRenderer()
		{
			@Override
			protected void customizeCellRenderer(final JList list, final Object value, final int index, final boolean selected, final boolean hasFocus)
			{
				final DbDataSourceElement element = (DbDataSourceElement) value;
				setIcon(value != null ? element.getIcon() : null);
				final String name = value == null ? "<none>" : element.getName();
				append(StringUtil.notNullize(name), new SimpleTextAttributes(SimpleTextAttributes.STYLE_PLAIN, getForeground()));
			}
		});
		comboBox.setEditable(false);
	}
}
