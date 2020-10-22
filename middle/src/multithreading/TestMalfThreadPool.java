package multithreading;

import sun.nio.ch.ThreadPool;

/**
 * @author malf
 * @description 测试自定义线程池
 * @project how2jStudy
 * @since 2020/10/22
 */
public class TestMalfThreadPool {
	public static void main(String[] args) {
		MalfThreadPool pool = new MalfThreadPool();
		for (int i = 0; i < 5; i++) {
			Runnable task = new Runnable() {
				@Override
				public void run() {

				}
			};
			pool.add(task);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
