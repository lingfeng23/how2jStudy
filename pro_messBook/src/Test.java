import com.birosoft.liquid.util.Panel;
import util.GUIUtil;

import javax.swing.*;

/**
 * @author malf
 * @description 测试类
 * @project how2jStudy
 * @since 2020/10/9
 */
public class Test {
	public static void main(String[] args) {
		GUIUtil.useLNF();
		JPanel panel = new JPanel();
		panel.add(new JButton("按钮1"));
		panel.add(new JButton("按钮2"));
		GUIUtil.showPanel(panel);
	}
}
