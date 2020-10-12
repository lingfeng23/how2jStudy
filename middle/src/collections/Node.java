package collections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author malf
 * @description 集合框架 二叉树
 * @project how2jStudy
 * @since 2020/10/13
 */
public class Node {
	public Node left;
	public Node right;
	public Object value;

	public void add(Object object) {
		if (null == value) {
			value = object;
		} else {
			if ((Integer) object - (Integer) value <= 0) {
				if (null == left) {
					left = new Node();
				}
				left.add(object);
			} else {
				if (null == right) {
					right = new Node();
				}
				right.add(object);
			}
		}
	}

	public List<Object> values() {
		List<Object> values = new ArrayList<>();
		// 左节点
		if (null != left) {
			values.addAll(left.values());
		}
		// 当前节点
		values.add(value);
		// 右节点
		if (null != right) {
			values.addAll(right.values());
		}
		return values;
	}

	public static void main(String[] args) {
		int randoms[] = new int[]{1, 2, 3, 4, 5};
		Node roots = new Node();
		for (int number : randoms) {
			roots.add(number);
		}

		System.out.println(roots.values());
	}
}
