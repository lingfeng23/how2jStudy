package interfaceAndExtends;

import objectOriented.Hero;

/**
 * @author malf
 * @description 只能使用物理攻击的英雄
 * @project how2jStudy
 * @since 2020/9/14
 */
public class ADHero extends Hero implements AD {
	/* 移动速度 */
	int moveSpeed = 400;

	public ADHero(String name) {
		super(name);
		System.out.println("ADHero的构造函数");
	}

	// 隐藏父类的battleWin方法
	public static void battleWin() {
		System.out.println("AD 英雄经过战斗胜出。");
	}

	@Override
	public void physicAttack() {
		System.out.printf("进行物理攻击。");
	}

	public static void main(String[] args) {
		new ADHero("AAA");
	}
}
