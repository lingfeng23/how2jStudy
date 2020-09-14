package interfaceAndExtends;

import objectOriented.Hero;

/**
 * @author malf
 * @description 只能使用魔法攻击的英雄
 * @project how2jStudy
 * @since 2020/9/14
 */
public class APHero extends Hero implements AP {
	@Override
	public void magicAttack() {
		System.out.printf("进行魔法攻击。");
	}
}
