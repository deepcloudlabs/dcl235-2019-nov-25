package com.example.swing;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("serial")
public class JCustomTable<T> extends JPanel implements ItemListener {

	private JTable table;
	private JComboBox<T> cbTableColumnNames;
	private GenericTableModel<T> model;
	private List<T> data;
	private JLabel info;
	private String columnName;
	private JScrollPane scrollPane;
	private JScrollBar verticalScrollBar;
	private Field columnField;
	private Class<?> valueClass;

	@SuppressWarnings("unchecked")
	public JCustomTable(Class<? extends T> valueClass) {
		info = new JLabel("Empty!");
		setLayout(new BorderLayout());
		add(info, BorderLayout.SOUTH);
		model = new GenericTableModel<T>(valueClass);
		table = new JTable(model);
		table.setShowHorizontalLines(false);
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(true);
		scrollPane = new JScrollPane(table);
		verticalScrollBar = scrollPane.getVerticalScrollBar();
		verticalScrollBar.addAdjustmentListener(model);
		verticalScrollBar.setUnitIncrement(1);
		add(scrollPane, BorderLayout.CENTER);
		cbTableColumnNames = new JComboBox<T>((T[]) model.getColumnNames().toArray(new String[0]));
		cbTableColumnNames.addItemListener(this);
		add(cbTableColumnNames, BorderLayout.NORTH);
		this.valueClass = valueClass;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
		try {
			columnField = valueClass.getDeclaredField(columnName);
			columnField.setAccessible(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		setColumnName(e.getItem().toString());
	}

	class Node {
		String fieldName;
		String columnName;
		int order;

		public Node(String fieldName, String columnName, int order) {
			this.fieldName = fieldName;
			this.columnName = columnName;
			this.order = order;
		}

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getColumnName() {
			return columnName;
		}

		public void setColumnName(String columnName) {
			this.columnName = columnName;
		}

		public int getOrder() {
			return order;
		}

		public void setOrder(int order) {
			this.order = order;
		}

	}

	@SuppressWarnings({ "unused", "hiding" })
	class GenericTableModel<T> extends AbstractTableModel implements AdjustmentListener {

		private Class<? extends T> clazz;
		private List<Node> nodes;
		private List<Class<?>> clsProperties;
		private Map<String, Column> columnProperties;

		public GenericTableModel(Class<? extends T> clazz) {
			this.clazz = clazz;
			nodes = new ArrayList<>();
			clsProperties = new ArrayList<>();
			columnProperties = new HashMap<>();
			for (Field field : clazz.getDeclaredFields()) {
				if (field.isAnnotationPresent(IgnoreField.class))
					continue;
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					nodes.add(new Node(field.getName(), column.name(), column.order()));
				} else {
					nodes.add(new Node(field.getName(), field.getName(), Integer.MAX_VALUE));
				}
				if (field.getType().equals(int.class)) {
					clsProperties.add(Number.class);
				} else {
					clsProperties.add(field.getType());
				}
			}
			Collections.sort(nodes, Comparator.comparing(Node::getOrder));
		}

		@Override
		public int getRowCount() {
			return data.size() + (int) ((double) scrollPane.getHeight() / table.getRowHeight() + 0.5) - 1;
		}

		@Override
		public int getColumnCount() {
			return nodes.size();
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return clsProperties.get(columnIndex);
		}

		@Override
		public String getColumnName(int column) {
			return nodes.get(column).getColumnName();
		}

		public List<String> getColumnNames() {
			return nodes.stream().map(Node::getColumnName).collect(Collectors.toList());
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			if (rowIndex >= data.size()) {
				return "";
			}
			Object o = data.get(rowIndex);
			String fieldName = nodes.get(columnIndex).getFieldName();
			Field f = null;
			try {
				f = o.getClass().getDeclaredField(fieldName);
				f.setAccessible(true);
				Object value = f.get(o);
				f.setAccessible(false);
				return value;
			} catch (Exception ex) {
				return ex.getMessage();
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			try {
				int index = e.getValue() / table.getRowHeight();
				T value = (T) data.get(index);
				info.setText(columnField.get(value).toString());
			} catch (Exception ex) {
				info.setText("Invalid field");
			}
		}
	}
}
