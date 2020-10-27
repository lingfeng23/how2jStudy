package util;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author malf
 * @description 专门用在图形界面上的工具类
 * @project how2jStudy
 * @since 2020/9/17
 */
public class GUIUtil {
	private static String imageFolder = "../pro_messBook/img";

	public static void setImageIcon(JButton button, String fileName, String tip) {
		ImageIcon icon = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
		button.setIcon(icon);
		button.setPreferredSize(new Dimension(61, 81));
		button.setToolTipText(tip);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setText(tip);
	}

	public static void setColor(Color color, JComponent... components) {
		for (JComponent component: components) {
			component.setForeground(color);
		}
	}

	/**
	 *
	 * @param panel
	 * @param stretchRate 拉伸比例为1表示满屏幕
	 */
	public static void showPanel(JPanel panel, double stretchRate) {
		GUIUtil.useLNF();
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		CenterPanel centerPanel = new CenterPanel(stretchRate);
		frame.setContentPane(centerPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		centerPanel.show(panel);
	}

	public static void showPanel(JPanel panel) {
		showPanel(panel, 0.85);
	}

	public static boolean checkNumber(JTextField textField, String input) {
		if (!checkEmpty(textField, input)) {
			return false;
		}
		String text = textField.getText().trim();
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, input + " 需要是整数");
			textField.grabFocus();
			return false;
		}
	}

	public static boolean checkEmpty(JTextField textField, String input) {
		String text = textField.getText().trim();
		if (0 == text.length()) {
			JOptionPane.showMessageDialog(null, input + " 不能为空");
			textField.grabFocus();
			return false;
		}
		return true;
	}

	public static boolean checkZero(JTextField textField, String input) {
		if (!checkNumber(textField, input)) {
			return false;
		}
		String text = textField.getText().trim();
		if (0 == Integer.parseInt(text)) {
			JOptionPane.showMessageDialog(null, input + "不能为零");
			textField.grabFocus();
			return false;
		}
		return true;
	}

	public static int getInt(JTextField textField) {
		return Integer.parseInt(textField.getText());
	}

	public static void useLNF() {
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}






}