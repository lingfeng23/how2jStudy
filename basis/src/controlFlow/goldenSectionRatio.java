package controlFlow;

/**
 * @author malf
 * @description 黄金分割点
 * @project how2jStudy
 * @since 2020/9/14
 */
public class goldenSectionRatio {
	public static void main(String[] args) {
		// 寻找某两个数相除，其结果 离黄金分割点 0.618最近
		// 分母和分子不能同时为偶数
		// 分母和分子 取值范围在[1-20]
		int range = 20; // 取值范围
		float breakPoint = 0.618f; // 黄金分割点

		float minDiff = 100; // 离黄金分割点的差值
		int answerFenzi = 0; // 找到的分子
		int answerFenmu = 0; // 找到的分母
		for (int fenzi = 1; fenzi <= range; fenzi++) {
			for (int fenmu = 1; fenmu <= range; fenmu++) {
				// 分母和分子不能同时为偶数
				if (0 == fenzi % 2 & 0 == fenmu % 2)
					continue;

				// 取值
				float value = (float) fenzi / fenmu;
				// 取离黄金分割点的差值
				float diff = value - breakPoint;
				// 绝对值
				diff = diff < 0 ? 0 - diff : diff;

				// 找出最小的差值
				if (diff < minDiff) {
					minDiff = diff;
					answerFenzi = fenzi;
					answerFenmu = fenmu;
				}
			}
		}
		System.out.println("离黄金分割点(" + breakPoint + ")最近的两个数相除是:" + answerFenzi + "/" + answerFenmu + "="
				+ ((float) answerFenzi / answerFenmu));

	}
}
