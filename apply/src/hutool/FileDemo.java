package hutool;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.util.StrUtil;
import org.junit.Test;

/**
 * @author malf
 * @description 和文件相关工具示例
 * @project how2jStudy
 * @since 2020/10/23
 */
public class FileDemo {
	int width = 200;
	int height = 100;

	@Test
	@Comment("创建线段干扰的验证码")
	public void test1() {
		LineCaptcha captcha = CaptchaUtil.createLineCaptcha(width, height);
		System.out.println("当前验证码：" + captcha.getCode());
		String path = "E:/malf/how2jStudy/apply/src/hutool/test1.png";
		captcha.write(path);
	}

	@Test
	@Comment("创建圆圈干扰的验证码")
	public void test2() {
		int codeCount = 5;
		int circleCount = 40;
		CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(width, height, codeCount, circleCount);
		System.out.println("当前验证码：" + captcha.getCode());
		String path = "E:/malf/how2jStudy/apply/src/hutool/test2.png";
		captcha.write(path);
	}

	@Test
	@Comment("创建扭曲线干扰的验证码")
	public void test3() {
		int codeCount = 5;
		int thickness = 2;
		ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(width, height, codeCount, thickness);
		System.out.println("当前验证码：" + captcha.getCode());
		String path = "E:/malf/how2jStudy/apply/src/hutool/test3.png";
		captcha.write(path);
	}
}
