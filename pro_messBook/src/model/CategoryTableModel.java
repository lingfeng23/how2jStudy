package model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author malf
 * @description 分类表格Model类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class CategoryTableModel implements TableModel {
	String[] columnNames = new String[]{"分类名称", "消费次数"};
	List<String> categories = new ArrayList<>();

	public CategoryTableModel() {
		categories.add("餐饮");
		categories.add("交通");
		categories.add("住宿");
		categories.add("话费");
	}

	@Override
	public int getRowCount() {
		return categories.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (0 == columnIndex) {
			return categories.get(rowIndex);
		}
		if (1 == columnIndex) {
			return 0;
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	}

	@Override
	public void addTableModelListener(TableModelListener l) {

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {

	}
}
