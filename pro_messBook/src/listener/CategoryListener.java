package listener;

import entity.Category;
import panel.CategoryPanel;
import service.CategoryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author malf
 * @description 分类操作按钮监听器
 * @project how2jStudy
 * @since 2020/11/2
 */
public class CategoryListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		CategoryPanel panel = CategoryPanel.instance;
		JButton button = (JButton) e.getSource();
		if (button == panel.add) {
			String name = JOptionPane.showInputDialog(null);
			if (0 == name.length()) {
				JOptionPane.showMessageDialog(panel, "分类名称不能为空");
				return;
			}
			new CategoryService().add(name);
		}
		if (button == panel.edit) {
			Category c = panel.getSelectedCategory();
			int id = c.id;
			String name = JOptionPane.showInputDialog("修改分类名称", c.name);
			if (0 == name.length()) {
				JOptionPane.showMessageDialog(panel, "分类名称不能为空");
				return;
			}
			new CategoryService().update(id, name);
		}
		if (button == panel.delete) {
			Category c = panel.getSelectedCategory();
			if (0 != c.recordNumber) {
				JOptionPane.showMessageDialog(panel, "本分类下有消费记录存在，不能删除");
				return;
			}
			if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(panel, "确认要删除？"))
				return;
			int id = c.id;
			new CategoryService().delete(id);
		}
		panel.updateData();
	}
}
