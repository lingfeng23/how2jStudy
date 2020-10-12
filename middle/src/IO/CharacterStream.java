package IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author malf
 * @description 字符流：专门用于字符的形式读取和写入数据
 * Reader 字符输入流
 * Writer 字符输出流
 * @project how2jStudy
 * @since 2020/10/12
 */
public class CharacterStream {
	public static void main(String[] args) {
		File file = new File("E:\\malf\\how2jStudy\\middle\\src\\IO\\test.txt");
		// 使用字符流读取文件
		try (FileReader fileReader = new FileReader(file)) {
			// 创建字符数组
			char[] all = new char[(int) file.length()];
			// 以字符流的形式读取文件内容
			fileReader.read(all);
			for (char a : all) {
				System.out.println(a);
			}
		} catch (IOException e) {
		}

		// 使用字符流把字符串写入到文件
		try (FileWriter fileWriter = new FileWriter(file)){
			// 以字符流的形式把数据写入到文件
			String data = "abcdefghijklmn";	// 文件内容为abcdefghijklmn
			char[] chars = data.toCharArray();
			fileWriter.write(chars);
		}catch (IOException e) {
		}
	}
}
