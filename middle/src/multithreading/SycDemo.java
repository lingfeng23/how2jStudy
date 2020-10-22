package multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author malf
 * @description 同步问题
 * @project how2jStudy
 * @since 2020/10/14
 */
public class SycDemo {
	public static void main(String[] args) {
		final Hero aa = new Hero();
		aa.name = "AA";
		aa.blood = 1000;
		int n = 10000;
		Thread[] adds = new Thread[n];
		Thread[] reduces = new Thread[n];
		for (int i = 0; i < n; i++) {
			Thread thread = new Thread() {
				public void run() {
					synchronized (aa) {
						aa.recover();
					}
					// aa.recover();	// 非同步处理
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			};
			thread.start();
			adds[i] = thread;
		}
		for (int i = 0; i < n; i++) {
			Thread thread = new Thread() {
				public void run() {
					synchronized (aa) {
						aa.hurt();
					}
					// aa.hurt();	// 非同步处理
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			};
			thread.start();
			reduces[i] = thread;
		}
		// 等待所有回血线程结束
		for (Thread t : adds) {
			try {
				t.join();
			} catch (InterruptedException e) {
			}
		}
		// 等待所有掉血线程结束
		for (Thread t : reduces) {
			try {
				t.join();
			} catch (InterruptedException e) {
			}
		}
		System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n",
				n, n, aa.blood);

		// 把非线程安全的集合转换为线程安全
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = Collections.synchronizedList(list1);
	}
}
