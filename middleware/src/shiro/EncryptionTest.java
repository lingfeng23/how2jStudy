package shiro;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author malf
 * @description MD5加密
 * @project how2jStudy
 * @since 2020/11/9
 */
public class EncryptionTest {
	public static void main(String[] args) {
		String password = "password";
		String encodedPassword = new Md5Hash(password).toString();
		System.out.println(encodedPassword);

		String salt = new SecureRandomNumberGenerator().nextBytes().toString();
		int times = 2;
		String algorithmName = "md5";
		encodedPassword = new SimpleHash(algorithmName, password, salt, times).toString();
		System.out.printf("原始密码是%s，盐是%s，运算次数是%d，最终密码是%s", password, salt, times, encodedPassword);
	}
}
