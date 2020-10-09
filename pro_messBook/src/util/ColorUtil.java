package util;

import java.awt.*;

/**
 * @author malf
 * @description 专门用于处理颜色的工具类
 * @project how2jStudy
 * @since 2020/10/9
 */
public class ColorUtil {
	public static Color BLUE = Color.decode("#3399FF");
	public static Color GRAY = Color.decode("#999999");
	public static Color BACK_GROUND = Color.decode("#eeeeee");
	public static Color WARN = Color.decode("#FF3333");

	public static Color getByPercentage(int percentage) {
		if (percentage > 100) {
			percentage = 100;
		}
		int red = 51;
		int green = 255;
		int blue = 51;
		float rate = percentage / 100f;
		red = (int) ((255 - 51) * rate + 51);
		green = 255 - red + 51;
		Color color = new Color(red, green, blue);
		return color;
	}


}
