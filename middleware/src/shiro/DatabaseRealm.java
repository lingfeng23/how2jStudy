package shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/11/9
 */
public class DatabaseRealm extends AuthorizingRealm {
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// 能进入到这里，表示账号已经通过验证了
		String userName = (String) principalCollection.getPrimaryPrincipal();
		// 通过 UserDao 获取角色和权限
		UserDao userDao = new UserDao();
		Set<String> roles = userDao.roles(userName);
		Set<String> permissions = userDao.permissions(userName);
		// 授权对象
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 把角色和权限关联进去
		info.setRoles(roles);
		info.setStringPermissions(permissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取账号密码
		UsernamePasswordToken t = (UsernamePasswordToken) token;
		String userName = token.getPrincipal().toString();
		String password = new String(t.getPassword());
		// 获取数据库中的密码
		UserDao userDao = new UserDao();
		User user = userDao.getUser(userName);
		String passwordInDB = user.getPassword();
		String salt = user.getSalt();
		String encodedPassword = new SimpleHash("md5", password, salt, 2).toString();
		if (null == user || !encodedPassword.equals(passwordInDB)) {
			throw new AuthenticationException();
		}
		// 如果为空就是账号不存在，如果不相同就是密码错误，但是都抛出 AuthenticationException，而不是抛出具体错误原因，免得给破解者提供帮助信息
//		if (null == passwordInDB || !passwordInDB.equals(password)){
//			throw new AuthenticationException();
//		}
		// 认证信息里存放账号密码, getName() 是当前 Realm 的继承方法,通常返回当前类名 :databaseRealm
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, password, getName());
		return info;
	}
}
