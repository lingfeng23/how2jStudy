package util;

import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import javax.swing.*;
import java.awt.*;

/**
 * @author malf
 * @description 柱状图相关工具类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class ChartUtil {
	public static int max(double[] values) {
		int max = 0;
		for (double value : values) {
			if (value > max) {
				max = (int) value;
			}
		}
		return max;
	}

	private static double[] values() {
		double[] result = new double[30];
		for (int i = 0; i < result.length; i++) {
			result[i] = (int) (Math.random() * 300);
		}
		return result;
	}

	private static String[] labels() {
		String[] labels = new String[30];
		for (int i = 0; i < labels.length; i++) {
			if (0 == i % 5) {
				labels[i] = String.valueOf(i + 1 + "日");
			}
		}
		return labels;
	}

	public static Image getImage(int width, int height) {
		// 模拟样本数据
		double[] values = values();
		// 下方显示的文字
		String[] labels = labels();
		// 样本中的最大值
		int max = max(values);
		// 数据颜色
		Color[] colors = new Color[]{ColorUtil.BLUE};
		// 柱状体
		BarChart chart = new BarChart();
		// 设置样本个数
		chart.setSampleCount(values.length);
		// 设置样本数据
		chart.setSampleValues(0, values);
		// 设置文字
		chart.setSampleLabels(labels);
		// 设置取值范围
		chart.setRange(0, max * 1.2);
		// 设置背景横线
		chart.setValueLinesOn(true);
		// 显示文字
		chart.setSampleLabelsOn(true);
		// 把文字显示在下方
		chart.setSampleLabelStyle(Chart.BELOW);
		// 样本值的字体
		chart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
		// 显示图例说明
		chart.setLegendOn(true);
		// 把图例说明放在左侧
		chart.setLegendPosition(Chart.LEFT);
		// 图例说明中的文字
		chart.setLegendLabels(new String[]{"月消费报表"});
		// 下方文字的字体
		chart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
		// 图表中间背景颜色
		chart.setChartBackground(Color.white);
		// 图表整体背景颜色
		chart.setBackground(ColorUtil.BACK_GROUND);
		// 把图表转换为Image类型
		Image image = chart.getImage(width, height);
		return image;
	}

	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		Image image = ChartUtil.getImage(400, 300);
		Icon icon = new ImageIcon(image);
		label.setIcon(icon);
		panel.add(label);
		GUIUtil.showPanel(panel);
	}
}
