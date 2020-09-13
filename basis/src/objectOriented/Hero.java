package objectOriented;

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

	public static void main(String[] args) {
		Hero garen = new Hero();
		garen.name = "盖伦";
		garen.hp = 200f;
		garen.armor = 20f;
		garen.moveSpeed = 350;

		Hero teemo = new Hero();
		teemo.name = "提莫";
		teemo.hp = 400f;
		teemo.armor =15f;
		teemo.moveSpeed = 330;
	}
}
