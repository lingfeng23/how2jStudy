package hutool;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.core.util.EscapeUtil;
import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.URLUtil;
import org.junit.Test;

import java.awt.*;

/**
 * @author malf
 * @description 编码工具
 * @project how2jStudy
 * @since 2020/10/23
 */
public class EncodeDemo {
	@Test
	@Comment("判断是否是十六进制")
	public void test1() {
		String str1 = "12";
		boolean flag1 = HexUtil.isHexNumber(str1);
		String str2 = "0x12";
		boolean flag2 = HexUtil.isHexNumber(str2);
		System.out.println(flag1);
		System.out.println(flag2);
	}

	@Test
	@Comment("字符串和十六进制相互转换")
	public void test2() {
		String str1 = "床前明月光";
		String str2 = HexUtil.encodeHexStr(str1);
		String str3 = HexUtil.decodeHexStr(str2);
		System.out.println(str2);
		System.out.println(str3);
	}

	@Test
	@Comment("颜色转换")
	public void test3() {
		Color color1 = Color.red;
		String str1 = HexUtil.encodeColor(color1);
		String str2 = "#112233";
		Color color2 = HexUtil.decodeColor(str2);
		System.out.println(color1 + "==" + str1);
		System.out.println(color2 + "==" + str2);
	}

	@Test
	@Comment("转义与反转义")
	public void test4() {
		String str1 = "<script>location.href='http://baidu.com'</script>";
		String str2 = EscapeUtil.escapeHtml4(str1);
		String str3 = EscapeUtil.unescapeHtml4(str2);
		System.out.println(str2);
		System.out.println(str3);
	}

	@Test
	@Comment("hash算法")
	public void test5() {
		String str = "床前明月光";
		int number = 12;
		long hash1 = HashUtil.additiveHash(str, Integer.MAX_VALUE);
		long hash2 = HashUtil.rotatingHash(str, Integer.MAX_VALUE);
		long hash3 = HashUtil.oneByOneHash(str);
		long hash4 = HashUtil.bernstein(str);
		long hash5 = HashUtil.intHash(number);
		System.out.println("加法算法对应的哈希值：" + hash1);
		System.out.println("旋转算法对应的哈希值：" + hash2);
		System.out.println("一次一个算法对应的哈希值" + hash3);
		System.out.println("Bernstein算法对应的哈希值：" + hash4);
		System.out.println("Thomas Wang的整数算法对应的哈希值：" + hash5);
	}

	@Test
	@Comment("URL转换工具")
	public void test6() {
		String str1 = "baidu.com";
		String str2 = "tencent.com";
		String url1 = URLUtil.formatUrl(str1);
		String url2 = URLUtil.encode(str2);
		String url3 = URLUtil.decode(url2);
		String url4 = URLUtil.getPath(str2);
		System.out.println("格式化后：" + url1);
		System.out.println("编码数据：" + url2);
		System.out.println("解码素具：" + url3);
		System.out.println("对应路径：" + url4);
	}

	@Test
	@Comment("Base32/64转换")
	public void test7() {
		String charset = "utf-8";
		String content = "床前明月光";

		String str1 = Base32.encode(content, charset);
		content = Base32.decodeStr(str1, charset);
		System.out.println("32位编码：" + str1);
		System.out.println("32位解码：" + content);

		String str2 = Base64.encode(content, charset);
		content = Base64.decodeStr(str2, charset);
		System.out.println("64位编码：" + str2);
		System.out.println("64位解码：" + content);
	}

	@Test
	@Comment("Unicode转换")
	public void test8() {
		String content = "床前明月光";

		String unicode = UnicodeUtil.toUnicode(content);
		content = UnicodeUtil.toString(unicode);
		System.out.println("Unicode：" + unicode);
		System.out.println("原字符串：" + content);
	}
}
