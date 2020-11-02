package test;

import com.birosoft.liquid.util.Panel;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author malf
 * @description 测试类
 * @project how2jStudy
 * @since 2020/10/9
 */
public class Test {
	public static void main(String[] args) {
		GUIUtil.useLNF();
		// 面板
		JPanel panel = new JPanel();
		// 进度条组件
		CircleProgressBar bar = new CircleProgressBar();
		bar.setBackgroundColor(ColorUtil.BLUE);
		bar.setProcess(20);
		// 按钮
		JButton button = new JButton("点击");
		// 添加组件
		panel.setLayout(new BorderLayout());
		panel.add(bar, BorderLayout.CENTER);
		panel.add(button, BorderLayout.SOUTH);
		// 显示面板
		GUIUtil.showPanel(panel);

		// 给按钮加监听器
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SwingWorker() {
					@Override
					protected Object doInBackground() throws Exception {
						for (int i = 0; i < 100; i++) {
							bar.setProcess(i + 1);
							bar.setForegroundColor(ColorUtil.getByPercentage(i + 1));
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
							}
						}
						return null;
					}
				}.execute();
			}
		});
	}
}
