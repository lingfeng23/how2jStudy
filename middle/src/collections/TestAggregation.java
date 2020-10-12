package collections;

import java.util.*;

/**
 * @author malf
 * @description 聚合操作
 * @project how2jStudy
 * @since 2020/10/13
 */
public class TestAggregation {
	public static void main(String[] args) {
		Random random = new Random();
		List<Hero> heroes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			heroes.add(new Hero("AAA" + i, random.nextInt(1000), random.nextInt(100)));
		}
		System.out.println(heroes);
		Collections.sort(heroes, new Comparator<Hero>() {
			@Override
			public int compare(Hero o1, Hero o2) {
				return (int) (o2.blood - o1.blood);
			}
		});
		Hero hero = heroes.get(2);
		System.out.println("血量第三高的英雄名字是" + hero.name);

		String name = heroes.stream()
				.sorted((hero1, hero2) -> hero1.blood > hero2.blood ? -1 : 1)
				.skip(2)
				.map(data -> data.name)
				.findFirst()
				.get();
		System.out.println(name);
	}
}
