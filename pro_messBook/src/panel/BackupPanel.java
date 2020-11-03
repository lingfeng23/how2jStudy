package panel;

import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;

/**
 * @author malf
 * @description 备份面板类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class BackupPanel extends JPanel {
	static{
		GUIUtil.useLNF();
	}

	public static BackupPanel instance = new BackupPanel();
	JButton backup =new JButton("备份");

	public BackupPanel() {
		GUIUtil.setColor(ColorUtil.BLUE, backup);
		this.add(backup);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(BackupPanel.instance);
	}
}
