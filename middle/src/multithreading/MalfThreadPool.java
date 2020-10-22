package multithreading;

import sun.nio.ch.ThreadPool;

import java.util.LinkedList;

/**
 * @author malf
 * @description 自定义线程池
 * @project how2jStudy
 * @since 2020/10/22
 */
public class MalfThreadPool {
	// 线程池大小
	int threadPoolSize;
	// 任务容器
	LinkedList<Runnable> tasks = new LinkedList<>();

	// 试图消费任务的线程
	public MalfThreadPool() {
		threadPoolSize = 10;
		// 启动10个任务消费者线程
		synchronized (tasks) {
			for (int i = 0; i < threadPoolSize; i++) {
				new TaskConsumeThread("任务消费者线程" + i).start();
			}
		}
	}

	public void add(Runnable runnable) {
		synchronized (tasks) {
			tasks.add(runnable);
			// 唤醒等待的任务消费者线程
			tasks.notifyAll();
		}
	}

	class TaskConsumeThread extends Thread {
		public TaskConsumeThread(String name) {
			super(name);
		}

		Runnable task;

		public void run() {
			System.out.println("启动：" + this.getName());
			while (true) {
				synchronized (tasks) {
					while (tasks.isEmpty()) {
						try {
							tasks.wait();
						} catch (InterruptedException e) {
						}
					}
					task = tasks.removeLast();
					// 允许添加任务的线程可以继续添加任务
					tasks.notifyAll();
				}
				System.out.println(this.getName() + " 获取到任务并执行");
				task.run();
			}
		}
	}
}
