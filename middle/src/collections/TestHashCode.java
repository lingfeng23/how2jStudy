package collections;

import java.util.*;

/**
 * @author malf
 * @description hashcode 原理
 * @project how2jStudy
 * @since 2020/10/13
 */
public class TestHashCode {
	public static void main(String[] args) {
		List<Hero> heroes = new ArrayList<>();
		for (int i = 0; i < 2000000; i++) {
			Hero hero = new Hero("Hero" + 1);
			heroes.add(hero);
		}
		for (int i = 0; i < 10; i++) {
			Collections.shuffle(heroes);
			long start = System.currentTimeMillis();
			String target = "Hero100000";
			for (Hero hero : heroes) {
				if (hero.name.equals(target)) {
					System.out.println("Find");
					break;
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("花费：" + (end - start));
		}

		Map<String, Hero> heroMap = new HashMap<>();
		for (int i = 0; i < 2000000; i++) {
			Hero hero = new Hero("Hero" + i);
			heroMap.put(hero.name, hero);
		}
		for (int i = 0; i < 10; i++) {
			long start = System.currentTimeMillis();
			Hero targetHero = heroMap.get("Hero100000");
			System.out.println(targetHero.name);
			long end = System.currentTimeMillis();
			System.out.println("HashMap花费：" + (end - start));
		}

	}
}
