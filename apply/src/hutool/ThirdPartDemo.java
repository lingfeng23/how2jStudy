package hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import org.junit.Before;
import org.junit.Test;

/**
 * @author malf
 * @description 和第三方相关工具示例
 * @project how2jStudy
 * @since 2020/10/23
 */
public class ThirdPartDemo {
	private MailAccount account;

	@Before
	public void prepareMailAccount() {
		account = new MailAccount();
		account.setHost("smtp.163.com");
		account.setPort(25);
		account.setAuth(true);
		account.setFrom("15131257162@163.com");
		account.setUser("malf");
		account.setPass("password");
	}

	@Test
	@Comment("发送普通文本")
	public void test1() {
		// TODO 测试失败
		MailUtil.send(account, "malinfei@cyberstone.com.cn",
				"测试", "床前明月光", false);
	}

	@Test
	@Comment("生成二维码图片和解析图片")
	public void test2() {
		String string = "床前明月光";
		String path = "E:\\malf\\how2jStudy\\apply\\src\\hutool\\qrcode.jpg";
		QrCodeUtil.generate(string, 300, 300, FileUtil.file(path));
		System.out.println("字符串=" + string + ",二维码地址=" + path);
		string = QrCodeUtil.decode(FileUtil.file(path));
		System.out.println("二维码地址=" + path + ",二维码内容=" + string);
	}

}
