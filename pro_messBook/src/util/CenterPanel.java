package util;

import javax.swing.*;
import java.awt.*;

/**
 * @author malf
 * @description 居中面板类
 * @project how2jStudy
 * @since 2020/9/17
 */
public class CenterPanel extends JPanel {
	private double rate;             // 拉伸比例
	private JComponent component;    // 显示的组件
	private boolean stretch;          // 是否拉伸

	public CenterPanel(double rate, boolean stretch) {
		this.setLayout(null);
		this.rate = rate;
		this.stretch = stretch;
	}

	public CenterPanel(double rate) {
		this(rate, true);
	}

	public void repaint() {
		if (null != component) {
			Dimension containerSize = this.getSize();
			Dimension componentSize = component.getPreferredSize();
			if (stretch) {
				component.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
			} else {
				component.setSize(componentSize);
			}
			component.setLocation(
					containerSize.width / 2 - component.getSize().width / 2,
					containerSize.height / 2 - component.getSize().height / 2);
		}
		super.repaint();
	}

	public void show(JComponent component) {
		this.component = component;
		Component[] components = getComponents();
		for (Component com : components) {
			remove(com);
		}
		add(component);
		this.updateUI();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		CenterPanel centerPanel = new CenterPanel(0.85, true);
		frame.setContentPane(centerPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JButton button = new JButton("abc");
		centerPanel.show(button);
	}
}
