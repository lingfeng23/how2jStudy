package collections;

/**
 * @author malf
 * @description 重写了 toString() 的Hero
 * @project how2jStudy
 * @since 2020/10/13
 */
public class Hero implements Comparable<Hero> {
	public String name;
	public float blood;
	public int damage;

	public Hero() {
	}

	public Hero(String name) {
		this.name = name;
	}

	public Hero(String name, float blood, int damage) {
		this.name = name;
		this.blood = blood;
		this.damage = damage;
	}

	public String toString() {
		return name + "血量：" + blood + ",伤害：" + damage;
	}

	@Override
	public int compareTo(Hero o) {
		if (damage < o.damage) {
			return 1;
		} else {
			return -1;
		}
	}
}
