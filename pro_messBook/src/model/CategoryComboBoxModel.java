package model;

import entity.Category;
import service.CategoryService;

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
public class CategoryComboBoxModel implements ComboBoxModel<Category> {
	//public List<String> categories = new ArrayList<>();
	//String category;
	public List<Category> categories = new CategoryService().list();
	public Category category;

	public CategoryComboBoxModel() {
//		categories.add("餐饮");
//		categories.add("交通");
//		categories.add("话费");
//		categories.add("住宿");
		if (!categories.isEmpty()) {
			category = categories.get(0);
		}
	}

	@Override
	public void setSelectedItem(Object anItem) {
		category = (Category) anItem;
	}

	@Override
	public Object getSelectedItem() {
		if (!categories.isEmpty()) {
			return category;
		} else {
			return null;
		}
	}

	@Override
	public int getSize() {
		return categories.size();
	}

	@Override
	public Category getElementAt(int index) {
		return categories.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {

	}

	@Override
	public void removeListDataListener(ListDataListener l) {

	}
}
