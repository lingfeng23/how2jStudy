package annotation.hibernate;

import java.lang.reflect.Method;

/**
 * @author malf
 * @description 解析注解并运用
 * @project how2jStudy
 * @since 2020/9/15
 */
public class ParseAnnotation {
	public static void main(String[] args) {
		Class<Hero> clazz = Hero.class;
		MyEntity entity = (MyEntity) clazz.getAnnotation(MyEntity.class);
		if (null == entity) {
			System.out.println("Hero 不是实体类");
		} else {
			MyTable table = (MyTable) clazz.getAnnotation(MyTable.class);
			String tableName = table.name();
			System.out.println("对应的表名：" + tableName);
			Method[] methods = clazz.getMethods();
			Method primaryKeyMethod = null;
			for (Method m : methods) {
				MyId id = m.getAnnotation(MyId.class);
				if (null != id) {
					primaryKeyMethod = m;
					break;
				}
			}
			if (null != primaryKeyMethod) {
				System.out.println("主键：" + primaryKeyMethod.getName());
				MyGeneratedValue generatedValue = primaryKeyMethod.getAnnotation(MyGeneratedValue.class);
				System.out.println("自增策略时：" + generatedValue.strategy());
				MyColumn column = primaryKeyMethod.getAnnotation(MyColumn.class);
				System.out.println("对应的字段：" + column.value());
			}

		}
	}
}
