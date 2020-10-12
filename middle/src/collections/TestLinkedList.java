package collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author malf
 * @description 集合框架 LinkedList
 * @project how2jStudy
 * @since 2020/10/13
 */
public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList<Hero> heros = new LinkedList<>();
		heros.addLast(new Hero("BBB"));
		heros.addFirst(new Hero("AAA"));

		System.out.println(heros.getLast().toString());
		System.out.println(heros);

		Queue<Hero> queue = new LinkedList<>();
		queue.offer(new Hero("aaa"));
		queue.offer(new Hero("bbb"));
		queue.offer(new Hero("ccc"));
		Hero hero = queue.poll();	// 取出第一个元素
		System.out.println(hero.toString());
		System.out.println(queue);
		hero = queue.peek();	// 查看第一个元素但不取出
		System.out.println(hero.toString());
	}
}
