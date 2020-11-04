package panel;

import listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author malf
 * @description 主窗体
 * @project how2jStudy
 * @since 2020/11/2
 */
public class MainPanel extends JPanel {
	static {
		GUIUtil.useLNF();
	}

	public static MainPanel instance = new MainPanel();
	public JToolBar toolBar = new JToolBar();
	public JButton spend = new JButton();
	public JButton record = new JButton();
	public JButton category = new JButton();
	public JButton report = new JButton();
	public JButton config = new JButton();
	public JButton backup = new JButton();
	public JButton recover = new JButton();
	public CenterPanel workingPanel;

	private MainPanel() {
		GUIUtil.setImageIcon(spend, "home.png", "消费一览");
		GUIUtil.setImageIcon(record, "record.png", "记一笔");
		GUIUtil.setImageIcon(category, "category2.png", "消费分类");
		GUIUtil.setImageIcon(report, "report.png", "月消费报表");
		GUIUtil.setImageIcon(config, "config.png", "设置");
		GUIUtil.setImageIcon(backup, "backup.png", "备份");
		GUIUtil.setImageIcon(record, "record.png", "恢复");
		toolBar.add(spend);
		toolBar.add(record);
		toolBar.add(category);
		toolBar.add(report);
		toolBar.add(config);
		toolBar.add(backup);
		toolBar.add(recover);
		toolBar.setFloatable(false);

		workingPanel = new CenterPanel(0.8);
		setLayout(new BorderLayout());
		add(toolBar, BorderLayout.NORTH);
		add(workingPanel, BorderLayout.CENTER);

		// 增加监听器
		addListener();
	}

	private void addListener() {
		ToolBarListener listener = new ToolBarListener();
		spend.addActionListener(listener);
		record.addActionListener(listener);
		category.addActionListener(listener);
		report.addActionListener(listener);
		config.addActionListener(listener);
		backup.addActionListener(listener);
		recover.addActionListener(listener);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(MainPanel.instance, 1);
	}

}
