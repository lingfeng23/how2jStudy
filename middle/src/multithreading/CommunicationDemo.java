package multithreading;

/**
 * @author malf
 * @description 线程间通信交互
 * @project how2jStudy
 * @since 2020/10/22
 */
public class CommunicationDemo {
	public static void main(String[] args) {
		final Hero gareen = new Hero();
		gareen.name = "盖伦";
		gareen.blood = 600;
		Thread thread1 = new Thread() {
			public void run() {
				while (true) {
					// 增加通信方法后无需循环判断
					/*while (gareen.blood == 1) {
						continue;
					}*/
					gareen.hurt();
					System.out.printf("thread1 为%s 减血1点,减少血后，%s的血量是%.0f%n",
							gareen.name, gareen.name, gareen.blood);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		thread1.start();
		Thread thread2 = new Thread() {
			public void run() {
				while (true) {
					gareen.recover();
					System.out.printf("thread2 为%s 回血1点,增加血后，%s的血量是%.0f%n",
							gareen.name, gareen.name, gareen.blood);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		thread2.start();
	}
}
