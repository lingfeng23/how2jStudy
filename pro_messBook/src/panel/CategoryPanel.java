package panel;

import model.CategoryTableModel;
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
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(CategoryPanel.instance);
	}
}
