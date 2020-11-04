package panel;

import entity.Category;
import listener.CategoryListener;
import model.CategoryTableModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author malf
 * @description 分类信息面板类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class CategoryPanel extends JPanel {
	static {
		GUIUtil.useLNF();
	}

	public static CategoryPanel instance = new CategoryPanel();

	public JButton add = new JButton("新增");
	public JButton edit = new JButton("编辑");
	public JButton delete = new JButton("删除");

	public CategoryTableModel tableModel = new CategoryTableModel();
	public JTable table = new JTable(tableModel);

	public CategoryPanel() {
		GUIUtil.setColor(ColorUtil.BLUE, add, edit, delete);
		JScrollPane sp = new JScrollPane(table);
		JPanel pSubmit = new JPanel();
		pSubmit.add(add);
		pSubmit.add(edit);
		pSubmit.add(delete);

		this.setLayout(new BorderLayout());
		this.add(sp, BorderLayout.CENTER);
		this.add(pSubmit, BorderLayout.SOUTH);

		addListener();
	}

	public Category getSelectedCategory() {
		int index = table.getSelectedRow();
		return tableModel.categories.get(index);
	}

	public void updateData() {
		tableModel.categories = new CategoryService().list();
		table.updateUI();
		table.getSelectionModel().setSelectionInterval(0, 0);
		if (0 == tableModel.categories.size()) {
			edit.setEnabled(false);
			delete.setEnabled(false);
		} else {
			edit.setEnabled(true);
			delete.setEnabled(true);
		}

	}

	public void addListener() {
		CategoryListener listener = new CategoryListener();
		add.addActionListener(listener);
		edit.addActionListener(listener);
		delete.addActionListener(listener);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(CategoryPanel.instance);
	}
}
