package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author malf
 * @description 中文问题
 * @project how2jStudy
 * @since 2020/10/12
 */
public class ChineseQuestion {
	public static void main(String[] args) {
		File file = new File("E:\\malf\\how2jStudy\\middle\\src\\IO\\chinese.txt");
		try (FileInputStream fileInputStream = new FileInputStream(file)){
			byte[] all = new byte[(int)file.length()];
			fileInputStream.read(all);
			System.out.println("读取出来的数据为：");
			for (byte a: all) {
				int i = a&0x000000ff;	// 只取16进制的后两位
				System.out.println(Integer.toHexString(i));
			}
			System.out.println("中文显示为：");
			String str = new String(all, "GBK");
			System.out.println(str);
		} catch (IOException e) {
		}
	}
}
