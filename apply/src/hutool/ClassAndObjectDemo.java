package hutool;

import cn.hutool.core.util.ReflectUtil;
import org.junit.Test;

/**
 * @author malf
 * @description 类和对象工具示例
 * @project how2jStudy
 * @since 2020/10/23
 */
public class ClassAndObjectDemo {
	@Test
	@Comment("设置属性")
	public void test1() {
		Hero hero = new Hero();
		ReflectUtil.setFieldValue(hero, "name", "盖伦");
		System.out.println(hero.getName());
	}

	@Test
	@Comment("调用方法")
	public void test2() {
		Hero hero = new Hero();
		ReflectUtil.invoke(hero, "setName", "拜伦");
		System.out.println(hero.getName());
	}

	class Hero {
		String name;
		int blood;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getBlood() {
			return blood;
		}

		public void setBlood(int blood) {
			this.blood = blood;
		}
	}
}
