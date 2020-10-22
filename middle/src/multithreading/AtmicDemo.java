package multithreading;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author malf
 * @description 原子类示例
 * @project how2jStudy
 * @since 2020/10/22
 */
public class AtmicDemo {
	private static int value = 0;
	private static AtomicInteger atomicInteger = new AtomicInteger();

	public static void main(String[] args) {
		int number = 100000;
		Thread[] threads1 = new Thread[number];
		for (int i = 0; i < number; i++) {
			Thread thread = new Thread() {
				public void run() {
					value++;
				}
			};
			thread.start();
			threads1[i] = thread;
		}
		// 等待线程全部结束
		for (Thread thread : threads1) {
			try {
				thread.join();
			} catch (InterruptedException e) {
			}
		}
		System.out.printf("%d个线程进行value++后，value的值变成:%d%n",
				number, value);
		Thread[] threads2 = new Thread[number];
		for (int i = 0; i < number; i++) {
			Thread thread = new Thread() {
				public void run() {
					atomicInteger.incrementAndGet();
				}
			};
			thread.start();
			threads2[i] = thread;
		}
		for (Thread thread : threads2) {
			try {
				thread.join();
			} catch (InterruptedException e) {
			}
		}
		System.out.printf("%d个线程进行atomicValue.incrementAndGet()后，atomicValue的值变成:%d%n",
				number, atomicInteger.intValue());
	}
}
