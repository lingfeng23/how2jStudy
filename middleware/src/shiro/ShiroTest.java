package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/11/9
 */
public class ShiroTest {
	public static void main(String[] args) {
		// 用户
		List<User> users = new ArrayList<>();

		User malf = new User();
		malf.setName("malf");
		malf.setPassword("password");
		User lingfeng23 = new User();
		lingfeng23.setName("lingfeng23");
		lingfeng23.setPassword("lingfeng23");
		User zhangsan = new User();
		zhangsan.setName("zhangsan");
		zhangsan.setPassword("wrong");

		users.add(malf);
		users.add(lingfeng23);
		users.add(zhangsan);

		// 角色
		List<String> roles = new ArrayList<>();
		String admin = "admin";
		String productManager = "productManager";
		roles.add(admin);
		roles.add(productManager);

		// 权限
		List<String> permits = new ArrayList<>();
		String addProduct = "addProduct";
		String addOrder = "addOrder";
		permits.add(addOrder);
		permits.add(addProduct);

		// 用户登录
		for (User user : users) {
			if (login(user)) {
				System.out.printf("%s \t成功登录，密码为：%s\t%n", user.getName(), user.getPassword());
			} else {
				System.out.printf("%s \t登录失败，密码为：%s\t%n", user.getName(), user.getPassword());
			}
		}
		System.out.println("********************分割线********************");
		// 判断登录用户是否有某个角色
		for (User user : users) {
			for (String role : roles) {
				if (login(user)) {
					if (hasRole(user, role)) {
						System.out.printf("%s\t 拥有角色: %s\t%n", user.getName(), role);
					} else {
						System.out.printf("%s\t 没有角色: %s\t%n", user.getName(), role);
					}
				}
			}
		}
		System.out.println("********************分割线********************");
		// 判断登录用户是否有某个权限
		for (User user : users) {
			for (String permit : permits) {
				if (login(user)) {
					if (isPermitted(user, permit)) {
						System.out.printf("%s\t 拥有权限: %s\t%n", user.getName(), permit);
					} else {
						System.out.printf("%s\t 没有权限: %s\t%n", user.getName(), permit);
					}
				}
			}
		}
	}


	private static boolean hasRole(User user, String role) {
		Subject subject = getSubject(user);
		return subject.hasRole(role);
	}

	private static boolean isPermitted(User user, String permit) {
		Subject subject = getSubject(user);
		return subject.isPermitted(permit);
	}

	private static Subject getSubject(User user) {
		// 加载配置文件，并获取工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("E:\\malf\\how2jStudy\\middleware\\src\\shiro\\shiro.ini");
		// 获取安全管理者实例
		SecurityManager manager = factory.getInstance();
		// 将安全管理者放入全局对象
		SecurityUtils.setSecurityManager(manager);
		// 全局对象通过安全管理者生成 Subject 对象
		Subject subject = SecurityUtils.getSubject();
		return subject;
	}

	private static boolean login(User user) {
		Subject subject = getSubject(user);
		// 如果已经登录过，退出
		if (subject.isAuthenticated()) {
			subject.logout();
		}
		// 封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
		try {
			// 将用户数据 token 传递到 Realm 中进行对比
			subject.login(token);
		} catch (AuthenticationException e) {
			return false;
		}
		return subject.isAuthenticated();
	}

}
