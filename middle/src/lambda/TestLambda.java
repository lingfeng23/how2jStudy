package lambda;

import collections.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/13
 */
public class TestLambda {
	public static void main(String[] args) {
		Random random = new Random();
		List<Hero> heroes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			heroes.add(new Hero("Hero" + i, random.nextInt(1000), random.nextInt(100)));
		}
		System.out.println(heroes);
		filter(heroes);
	}

	private static void filter(List<Hero> heroes) {
		for (Hero hero : heroes) {
			if (hero.blood > 100 && hero.damage < 50) {
				System.out.println(hero);
			}
		}
	}
}
