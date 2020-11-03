package model;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author malf
 * @description 分类下拉框Model类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class CategoryComboBoxModel implements ComboBoxModel<String> {
	public List<String> categories = new ArrayList<>();
	String category;

	public CategoryComboBoxModel() {
		categories.add("餐饮");
		categories.add("交通");
		categories.add("话费");
		categories.add("住宿");
		category = categories.get(0);
	}

	@Override
	public void setSelectedItem(Object anItem) {
		category = (String) anItem;
	}

	@Override
	public Object getSelectedItem() {
		return category;
	}

	@Override
	public int getSize() {
		return categories.size();
	}

	@Override
	public String getElementAt(int index) {
		return null;
	}

	@Override
	public void addListDataListener(ListDataListener l) {

	}

	@Override
	public void removeListDataListener(ListDataListener l) {

	}
}
