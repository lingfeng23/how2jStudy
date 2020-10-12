package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author malf
 * @description 流对象
 * 当不同的介质之间有数据交互的时候，JAVA就使用流来实现。
 * 数据源可以是文件，还可以是数据库，网络甚至是其他的程序。
 * @project how2jStudy
 * @since 2020/9/28
 */
public class StreamObject {
	public static void main(String[] args) {
		File test = new File("E:\\malf\\how2jStudy\\middle\\src\\IO\\test.txt");
		try {
			// 以字节流的形式读取文件内容
			FileInputStream inputStream = new FileInputStream(test);
			byte[] content = new byte[(int)test.length()];
			inputStream.read(content);
			for (byte b :content) {
				System.out.println(b);
			}
			inputStream.close();
			// 以字节流的形式向文件写入数据
			byte data[] = {88,89};	// XY
			FileOutputStream outputStream = new FileOutputStream(test);
			outputStream.write(data);
			outputStream.close();
		} catch (IOException e) {

		}
	}
}
