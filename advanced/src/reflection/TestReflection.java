package reflection;

import objectOriented.Hero;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/9/14
 */
public class TestReflection {
	public static void main(String[] args) {
		String className = "objectOriented.Hero";
		try {
			Class clazz1 = Class.forName(className);
			Class clazz2 = Hero.class;
			Class clazz3 = new Hero().getClass();
			System.out.println(clazz1 == clazz2); // true
			System.out.println(clazz1 == clazz3); // true
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
