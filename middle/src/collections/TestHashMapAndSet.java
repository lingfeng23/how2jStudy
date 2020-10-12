package collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author malf
 * @description 集合框架 HashMap & HashSet
 * @project how2jStudy
 * @since 2020/10/13
 */
public class TestHashMapAndSet {
	public static void main(String[] args) {
		Map<String, String> dict = new HashMap<>();
		dict.put("AAA", "aaa");
		dict.put("BBB", "bbb");
		System.out.println(dict.get("BBB"));

		Set<String> names = new HashSet<>();
		names.add("AAA");
		names.add("BBB");
		names.add("AAA");
		System.out.println(names);
	}
}
