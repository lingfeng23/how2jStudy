package multithreading;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/14
 */
public class Hero {
	public String name;
	public float blood;
	public int damage;

	// 回血
	public synchronized void recover() {
		blood = blood + 1;
		this.notify();
	}

	// 掉血
	public synchronized void hurt() {
		if (blood == 1) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		blood = blood - 1;
	}

	public void attack(Hero hero) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		hero.blood -= damage;
		System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, hero.name, hero.name, hero.blood);
		if (hero.isDead()) {
			System.out.println(hero.name + "死了");
		}
	}

	public boolean isDead() {
		return 0 >= blood ? true : false;
	}
}
