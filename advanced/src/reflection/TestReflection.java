package reflection;

import objectOriented.Hero;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author malf
 * @description 反射：获取类对象、创建对象、访问属性、调用方法
 * @project how2jStudy
 * @since 2020/9/14
 */
public class TestReflection {
	public static void main(String[] args) throws InterruptedException {
		// 一：获取类对象
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

		Thread thread1 = new Thread() {
			public void run() {
				// 调用method1方法
				TestReflection.method1();
			}
		};
		Thread thread2 = new Thread() {
			public void run() {
				// 调用method2方法
				TestReflection.method2();
			}
		};
		thread1.setName("第一个线程");
		thread1.start();
		// 保证第一个线程先调用method1
		Thread.sleep(1000);
		thread2.setName("第二个线程");
		thread2.start();

		// 二：创建对象
		// 1、使用new创建对象
		Hero hero1 = new Hero();
		// 2、使用反射创建对象
		try {
			Class clazz = Class.forName(className);
			// 构造器
			Constructor constructor = clazz.getConstructor();
			// 通过构造器实例化
			Hero hero2 = (Hero) constructor.newInstance();
		} catch (Exception e) {
		}

		// 三：访问属性
		Hero hero = new Hero();
		hero.name = "garen";
		try {
			// 获取name字段
			Field field1 = hero.getClass().getDeclaredField("name");
			// 给字段赋值
			field1.set(hero, "temmo");
			System.out.println(hero.name);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 四：调用方法
	}

	public static void method1() {
		synchronized (TestReflection.class) {
			System.out.println(Thread.currentThread().getName() + "进入method1方法");
		}
		try {
			System.out.println("运行5秒");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

	public static synchronized void method2() {
		System.out.println(Thread.currentThread().getName() + "进入method2方法");
		try {
			System.out.println("运行5秒");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}
}
