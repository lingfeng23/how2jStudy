package panel;

import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;

/**
 * @author malf
 * @description 恢复面板类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class RecoverPanel extends JPanel {
	static {
		GUIUtil.useLNF();
	}

	public static RecoverPanel instance = new RecoverPanel();

	JButton recover = new JButton("恢复");

	public RecoverPanel() {
		GUIUtil.setColor(ColorUtil.BLUE, recover);
		this.add(recover);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(RecoverPanel.instance);
	}
}
