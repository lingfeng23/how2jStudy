package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author malf
 * @description I/O字节流：用于以字节的形式读取和写入数据
 * InputStream 字节输入流
 * outputStream 字节输出流
 * @project how2jStudy
 * @since 2020/10/12
 */
public class ByteStream {
	public static void main(String[] args) {
		FileOutputStream fileOutputStream = null;
		try {
			// 以字节流的形式读取文件内容
			File file = new File("E:\\malf\\how2jStudy\\middle\\src\\IO\\test.txt");
			// 创建基于文件的输入流
			FileInputStream fileInputStream = new FileInputStream(file);
			// 创建字节数组
			byte[] all = new byte[(int) file.length()];
			// 以字节流的形式读取文件内容
			fileInputStream.read(all);
			for (byte a : all) {
				System.out.println(a);
			}
			// 关闭流
			fileInputStream.close();

			// 以字节流的形式向文件写入数据
			byte data[] = {65, 66};    // 文件内容为AB
			// 创建基于文件的输出流
			fileOutputStream = new FileOutputStream(file);
			// 把数据写入到输出流
			fileOutputStream.write(data);
			// 关闭流
			fileOutputStream.close();
		} catch (IOException e) {
		} finally {
			if (null != fileOutputStream) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
