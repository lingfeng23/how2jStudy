package listener;

import panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/11/2
 */
public class ConfigListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		ConfigPanel panel = ConfigPanel.instance;
		if (!GUIUtil.checkNumber(panel.textBudget, "本月预算")) {
			return;
		}
		String mysqlPath = panel.mysqlPath.getText();
		if (0 != mysqlPath.length()) {
			File file = new File(mysqlPath, "/bin/mysql.exe");
			if (!file.exists()) {
				JOptionPane.showMessageDialog(panel, "Mysql路径不正确");
				panel.mysqlPath.grabFocus();
				return;
			}
		}
		ConfigService service = new ConfigService();
		service.update(ConfigService.budget, panel.textBudget.getText());
		service.update(ConfigService.mysqlPath, mysqlPath);
		JOptionPane.showMessageDialog(panel, "设置修改成功！");
	}
}
