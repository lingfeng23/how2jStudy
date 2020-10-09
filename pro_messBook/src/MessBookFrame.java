import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/9/17
 */
public class MessBookFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500, 450);
		frame.setTitle("一本糊涂账");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JToolBar toolBar = new JToolBar();
		JButton spend = new JButton("消费一览");
		JButton record = new JButton("记一笔");
		JButton category = new JButton("消费分类");
		JButton report = new JButton("月消费报表");
		JButton config = new JButton("设置");
		JButton backup = new JButton("备份");
		JButton recover = new JButton("恢复");

		toolBar.add(spend);
		toolBar.add(record);
		toolBar.add(category);
		toolBar.add(report);
		toolBar.add(config);
		toolBar.add(backup);
		toolBar.add(recover);

		frame.setLayout(new BorderLayout());
		frame.add(toolBar, BorderLayout.NORTH);
		frame.add(new JPanel(), BorderLayout.CENTER);

		frame.setVisible(true);

		spend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		record.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		category.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		config.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		backup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		recover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

	}
}
