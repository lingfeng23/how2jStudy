package panel;

import listener.ConfigListener;
import service.ConfigService;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author malf
 * @description 设置界面类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class ConfigPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}

	public static ConfigPanel instance = new ConfigPanel();

	JLabel budget = new JLabel("本月预算(￥)");
	public JTextField textBudget = new JTextField("0");
	JLabel mysql = new JLabel("Mysql安装目录");
	public JTextField mysqlPath = new JTextField("");
	JButton submit = new JButton("更新");

	public ConfigPanel() {
		GUIUtil.setColor(ColorUtil.GRAY, budget, mysql);
		GUIUtil.setColor(ColorUtil.BLUE, submit);

		JPanel inputPanel = new JPanel();
		JPanel submitPanel = new JPanel();
		int gap = 40;
		inputPanel.setLayout(new GridLayout(4, 1, gap, gap));

		inputPanel.add(budget);
		inputPanel.add(textBudget);
		inputPanel.add(mysql);
		inputPanel.add(mysqlPath);
		submitPanel.add(submit);

		this.setLayout(new BorderLayout());
		this.add(inputPanel, BorderLayout.NORTH);
		this.add(submitPanel, BorderLayout.CENTER);

		addListener();
	}

	@Override
	public void updateData() {
		String budget = new ConfigService().get(ConfigService.budget);
		String mysql = new ConfigService().get(ConfigService.mysqlPath);
		textBudget.setText(budget);
		mysqlPath.setText(mysql);
		textBudget.grabFocus();
	}

	public void addListener() {
		ConfigListener l = new ConfigListener();
		submit.addActionListener(l);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(ConfigPanel.instance);
	}
}
