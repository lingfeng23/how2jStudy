package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author malf
 * @description 数组与集合框架 & 泛型 & 遍历
 * @project how2jStudy
 * @since 2020/10/13
 */
public class TestArrayList {
	public static void main(String[] args) {
		// 使用数组的局限性顶折
		Hero heros[] = new Hero[10];
		heros[0] = new Hero("AAA");
		// heros[20] = new Hero("ZZZ");	// 数组越界异常

		// ArrayList存放对象
		ArrayList heroList = new ArrayList();
		heroList.add(new Hero("AAA"));
		heroList.add(new Hero("BBB"));
		System.out.println(heroList.size());

		// 泛型
		List<Hero> heroes = new ArrayList<>();
		heroes.add(new Hero("AAA"));
		heroes.add(new Hero("CCC"));

		// 遍历
		for (int i = 0; i < heroList.size(); i++) {
			System.out.println(heroList.get(i).toString());
		}
		Iterator<Hero> iterator = heroes.iterator();
		while (iterator.hasNext()) {
			Hero hero = iterator.next();
			System.out.println(hero.toString());
		}
		for (Hero item : heroes) {
			System.out.println(item.toString());
		}
	}
}
