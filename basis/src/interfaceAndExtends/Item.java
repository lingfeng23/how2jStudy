package interfaceAndExtends;

/**
 * @author malf
 * @description 物品类
 * @project how2jStudy
 * @since 2020/9/14
 */
public class Item {
	String name;
	int price;

	public void buy() {
		System.out.println("购买");
	}
	public void effect() {
		System.out.println("物品使用后，可以有效果。");
	}
}
