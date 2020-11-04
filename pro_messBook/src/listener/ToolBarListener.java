package listener;

import panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author malf
 * @description 工具条监听器类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class ToolBarListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		MainPanel panel = MainPanel.instance;
		JButton button = (JButton) e.getSource();
		if (button == panel.report)
			panel.workingPanel.show(ReportPanel.instance);
		if (button == panel.category)
			panel.workingPanel.show(CategoryPanel.instance);
		if (button == panel.spend)
			panel.workingPanel.show(SpendPanel.instance);
		if (button == panel.record)
			panel.workingPanel.show(RecordPanel.instance);
		if (button == panel.config)
			panel.workingPanel.show(ConfigPanel.instance);
		if (button == panel.backup)
			panel.workingPanel.show(BackupPanel.instance);
		if (button == panel.recover)
			panel.workingPanel.show(RecoverPanel.instance);
	}
}
