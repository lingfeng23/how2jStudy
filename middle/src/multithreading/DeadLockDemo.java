package multithreading;

/**
 * @author malf
 * @description 死锁示例
 * @project how2jStudy
 * @since 2020/10/22
 */
public class DeadLockDemo {
	public static void main(String[] args) {
		final Hero ahri = new Hero();
		ahri.name = "九尾妖狐";
		final Hero annie = new Hero();
		annie.name = "安妮";
		Thread thread1 = new Thread() {
			public void run() {
				synchronized (ahri) {
					System.out.println("thread1 占有九尾妖狐");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					System.out.println("thread1 试图占有安妮");
					System.out.println("thread1 等待中");
					synchronized (annie) {
						System.out.println("..........");
					}
				}
			}
		};
		thread1.start();
		Thread thread2 = new Thread() {
			public void run() {
				synchronized (annie) {
					System.out.println("thread2 占有安妮");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					System.out.println("thread2 试图占有九尾妖狐");
					System.out.println("thread2 等待中");
					synchronized (ahri) {
						System.out.println("..........");
					}
				}
			}
		};
		thread2.start();
	}
}
