package controlFlow;

/**
 * @author malf
 * @description 水仙花数
 * 水仙花数定义：
 * 1. 一定是3位数
 * 2. 每一位的立方，加起来恰好是这个数本身，比如153=1*1*1+5*5*5+3*3*3
 * 寻找所有的水仙花数
 * @project how2jStudy
 * @since 2020/9/14
 */
public class narcissisticNumber {
	public static void main(String[] args) {
		for (int i = 100; i < 1000; i++) {
			int baiwei = i / 100;
			int shiwei = i / 10 % 10;
			int gewei = i % 10;
			int cube = baiwei * baiwei * baiwei + shiwei * shiwei * shiwei + gewei * gewei * gewei;
			if (cube == i) {
				System.out.println("找到水仙花数:" + i);
			}
		}
	}

}
