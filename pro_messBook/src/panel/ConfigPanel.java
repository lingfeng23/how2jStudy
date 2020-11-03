package panel;

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
public class ConfigPanel extends JPanel {
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

		JPanel pInput = new JPanel();
		JPanel pSubmit = new JPanel();
		int gap = 40;
		pInput.setLayout(new GridLayout(4, 1, gap, gap));

		pInput.add(budget);
		pInput.add(textBudget);
		pInput.add(mysql);
		pInput.add(mysqlPath);
		this.setLayout(new BorderLayout());
		this.add(pInput, BorderLayout.NORTH);

		pSubmit.add(submit);
		this.add(pSubmit, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		GUIUtil.showPanel(ConfigPanel.instance);
	}
}
