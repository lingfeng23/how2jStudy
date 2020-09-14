package interfaceAndExtends;

import objectOriented.Hero;

/**
 * @author malf
 * @description 既能进行物理攻击，又能进行魔法攻击的英雄
 * @project how2jStudy
 * @since 2020/9/14
 */
public class ADAPHero extends Hero implements AD, AP {
	@Override
	public void physicAttack() {
		System.out.printf("物理攻击。");
	}

	@Override
	public void magicAttack() {
		System.out.printf("魔法攻击。");
	}
}
