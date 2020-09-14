package objectOriented;

import interfaceAndExtends.Item;

/**
 * @author malf
 * @description 英雄类
 * @project how2jStudy
 * @since 2020/9/14
 */
public class Hero {
	/* 姓名 */
	String name;
	/* 血量 */
	float hp;
	/* 护甲 */
	float armor;
	/* 移动速度 */
	int moveSpeed;

	public Hero() {
		System.out.println("Hero的构造方法");
	}
	public Hero(String name) {
		System.out.println("Hero的有参构造方法。");
		this.name = name;
	}

	public void useItem(Item i) {
		System.out.println("英雄使用物品");
		i.effect();
	}

	// 类方法，静态方法，通过类就可以直接调用
	public static void battleWin() {
		System.out.println("英雄经过战斗胜出。");
	}

	// 非静态内部类，只有一个外部类对象存在的时候，才有意义
	// 战斗成绩只有在一个英雄对象存在的时候才有意义
	class BattleScore {
		/* 杀伤数量 */
		int kill;
		/* 死亡次数 */
		int die;
		/* 帮助数量 */
		int assit;
		public void legendary() {
			if (kill >= 8) {
				System.out.println("超神");
			} else {
				System.out.println("尚未超神");
			}
		}
	}

	// 敌方的水晶
	static class EnemyCrystal {
		int hp = 5000;
		// 如果水晶血量为0，则宣布胜利
		public void checkIfWin() {
			if (hp == 0) {
				Hero.battleWin();
			}
		}
	}
}
