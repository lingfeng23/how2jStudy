package listener;

import entity.Category;
import panel.CategoryPanel;
import panel.MainPanel;
import panel.RecordPanel;
import panel.SpendPanel;
import service.RecordService;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author malf
 * @description 消费记录监听类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class RecordListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		RecordPanel panel = RecordPanel.instance;
		if (0 == panel.boxModel.categories.size()) {
			JOptionPane.showMessageDialog(panel, "暂无消费分类，无法添加，请先增加消费分类");
			MainPanel.instance.workingPanel.show(CategoryPanel.instance);
			return;
		}

		if (!GUIUtil.checkZero(panel.textSpend, "花费金额"))
			return;
		int spend = Integer.parseInt(panel.textSpend.getText());
		Category c = panel.getSelectedCategory();
		String comment = panel.textComment.getText();
		Date d = panel.datePicker.getDate();
		new RecordService().add(spend, c, comment, d);
		JOptionPane.showMessageDialog(panel, "添加成功");

		MainPanel.instance.workingPanel.show(SpendPanel.instance);
	}
}
