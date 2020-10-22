package multithreading;

/**
 * @author malf
 * @description 多线程准备类
 * 线程相关的方法：
 * sleep		当前线程暂停
 * join			加入到当前线程
 * setPriority	线程优先级
 * yield		临时暂停
 * setDaemon	守护线程
 * @project how2jStudy
 * @since 2020/10/13
 */
public class TestThread {
	public static void main(String[] args) {
		Hero aa = new Hero();
		aa.name = "AA";
		aa.blood = 600;
		aa.damage = 50;
		Hero bb = new Hero();
		bb.name = "BB";
		bb.blood = 500;
		bb.damage = 40;
		Hero oo = new Hero();
		oo.name = "OO";
		oo.blood = 560;
		oo.damage = 80;
		Hero pp = new Hero();
		pp.name = "PP";
		pp.blood = 650;
		pp.damage = 60;
		while (!aa.isDead()) {
			oo.attack(aa);
		}
		while (!bb.isDead()) {
			pp.attack(bb);
		}
	}
}
