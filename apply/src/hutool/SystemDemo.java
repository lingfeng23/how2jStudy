package hutool;

import cn.hutool.core.util.StrUtil;
import cn.hutool.system.SystemUtil;
import org.junit.Test;

import java.sql.Struct;

/**
 * @author malf
 * @description 系统工具示例
 * @project how2jStudy
 * @since 2020/10/23
 */
public class SystemDemo {
	@Test
	@Comment("系统属性工具")
	public void test() {
		System.out.println("虚拟机信息：" + StrUtil.trim(SystemUtil.getJvmInfo().toString()));
		System.out.println("java规范：" + StrUtil.trim(SystemUtil.getJavaSpecInfo().toString()));
		System.out.println("当前Java信息：" + StrUtil.trim(SystemUtil.getJavaInfo().toString()));
		System.out.println("当前系统信息：" + StrUtil.trim(SystemUtil.getOsInfo().toString()));
		System.out.println("用户信息：" + StrUtil.trim(SystemUtil.getUserInfo().toString()));
		System.out.println("主机信息：" + StrUtil.trim(SystemUtil.getHostInfo().toString()));
		System.out.println("内存信息：" + StrUtil.trim(SystemUtil.getRuntimeInfo().toString()));

	}
}
