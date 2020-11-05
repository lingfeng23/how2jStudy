package startup;

import frame.MainFrame;
import panel.MainPanel;
import panel.SpendPanel;
import util.GUIUtil;

import javax.swing.*;

/**
 * @author malf
 * @description 启动类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class Bootstrap {
	public static void main(String[] args) throws Exception{
		GUIUtil.useLNF();

		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				MainFrame.instance.setVisible(true);
				MainPanel.instance.workingPanel.show(SpendPanel.instance);
			}
		});
	}
}
