package panel;

import page.SpendPage;
import service.SpendService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @author malf
 * @description 消费一览面板类
 * @project how2jStudy
 * @since 2020/9/17
 */
public class SpendPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}

	public static SpendPanel instance = new SpendPanel();

	public JLabel monthSpend = new JLabel("本月消费");
	public JLabel todaySpend = new JLabel("今日消费");
	public JLabel dayAvgSpend = new JLabel("日均消费");
	public JLabel monthAvailable = new JLabel("本月剩余");
	public JLabel dayAvgAvailable = new JLabel("日均可用");
	public JLabel monthLeftDay = new JLabel("距离月末");

	public JLabel monthSpendValue = new JLabel("￥2300");
	public JLabel todaySpendValue = new JLabel("￥25");
	public JLabel averageSpendValue = new JLabel("￥120");
	public JLabel monthLeftValue = new JLabel("￥2084");
	public JLabel averageDayLeftValue = new JLabel("￥389");
	public JLabel monthLeftDayValue = new JLabel("15天");

	CircleProgressBar bar;

	public SpendPanel() {
		this.setLayout(new BorderLayout());
		bar = new CircleProgressBar();
		bar.setBackgroundColor(ColorUtil.BLUE);
		GUIUtil.setColor(ColorUtil.GRAY, monthSpend, todaySpend, dayAvgSpend, monthAvailable, dayAvgAvailable,
				monthLeftDay, averageSpendValue, monthLeftValue, averageDayLeftValue, monthLeftDayValue);
		GUIUtil.setColor(ColorUtil.BLUE, monthSpendValue, todaySpendValue);
		monthSpendValue.setFont(new Font("微软雅黑", Font.BOLD, 23));
		todaySpendValue.setFont(new Font("微软雅黑", Font.BOLD, 23));
		this.add(center(), BorderLayout.CENTER);
		this.add(south(), BorderLayout.SOUTH);
	}

	private JPanel center() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(west(), BorderLayout.WEST);
		panel.add(bar, BorderLayout.CENTER);
		return panel;
	}

	private Component west() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		panel.add(monthSpend);
		panel.add(monthSpendValue);
		panel.add(todaySpend);
		panel.add(todaySpendValue);
		return panel;
	}

	private JPanel south() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 4));
		panel.add(dayAvgSpend);
		panel.add(monthAvailable);
		panel.add(dayAvgAvailable);
		panel.add(monthLeftDay);
		panel.add(averageSpendValue);
		panel.add(monthLeftValue);
		panel.add(averageDayLeftValue);
		panel.add(monthLeftDayValue);
		return panel;
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(SpendPanel.instance);
	}

	@Override
	public void updateData() {
		SpendPage spend = new SpendService().getSpendPage();
		monthSpend.setText(spend.monthSpend);
		todaySpend.setText(spend.todaySpend);
		dayAvgSpend.setText(spend.dayAvgSpend);
		monthAvailable.setText(spend.monthAvailable);
		dayAvgAvailable.setText(spend.dayAvgAvailable);
		monthLeftDay.setText(spend.monthLeftDay);

		bar.setProcess(spend.usagePercentage);
		if (spend.isOverSpend) {
			monthAvailable.setForeground(ColorUtil.WARN);
			monthSpend.setForeground(ColorUtil.WARN);
			todaySpend.setForeground(ColorUtil.WARN);

		} else {
			monthAvailable.setForeground(ColorUtil.GRAY);
			monthSpend.setForeground(ColorUtil.BLUE);
			todaySpend.setForeground(ColorUtil.BLUE);
		}
		bar.setForegroundColor(ColorUtil.getByPercentage(spend.usagePercentage));
		addListener();
	}

	@Override
	public void addListener() {

	}
}
