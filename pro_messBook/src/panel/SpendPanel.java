package panel;

import javax.swing.*;

/**
 * @author malf
 * @description 消费一览面板类
 * @project how2jStudy
 * @since 2020/9/17
 */
public class SpendPanel {
	// 设计为单例模式
	private SpendPanel() {}
	public static SpendPanel instance = new SpendPanel();

	JLabel monthSpend = new JLabel("本月消费");
	JLabel todaySpend = new JLabel("今日消费");
	JLabel averageSpend = new JLabel("日均消费");
	JLabel monthLeft = new JLabel("本月剩余");
	JLabel averageDayLeft = new JLabel("日均可用");
	JLabel monthLeftDay = new JLabel("距离月末");

	JLabel monthSpendValue = new JLabel("￥2300");
	JLabel todaySpendValue = new JLabel("￥25");
	JLabel averageSpendValue = new JLabel("￥120");
	JLabel monthLeftValue = new JLabel("￥1048");
	JLabel averageDayLeftValue = new JLabel("￥389");
	JLabel monthLeftDayValue = new JLabel("15天");
}
