package IO;

import java.io.*;

/**
 * @author malf
 * @description 缓存流
 * 缓存流在写入数据的时候，会先把数据写入到缓存区，直到缓存区达到一定的量，才把这些数据，一起写入到硬盘中去。按照这种操作模式，就不会像字节流，字符
 * 流那样每写一个字节都访问硬盘，从而减少了IO操作
 * @project how2jStudy
 * @since 2020/10/12
 */
public class BufferedStream {
	public static void main(String[] args) {
		// 使用缓存流读取数据
		File file = new File("E:\\malf\\how2jStudy\\middle\\src\\IO\\buffer.txt");
		// 创建文件字符流
		// 缓存流必须建立在一个存在的流的基础上
		try (
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
		) {
			while (true) {
				// 一次读一行
				String line = bufferedReader.readLine();
				if (null == line)
					break;
				System.out.println(line);
			}
		} catch (IOException e) {
		}

		// 使用缓存流写入数据
		try (
				// 创建文件字符流
				FileWriter fileWriter = new FileWriter(file);
				// 缓存流必须建立在一个存在的流的基础上
				PrintWriter printWriter = new PrintWriter(fileWriter);
		) {
			printWriter.println("asdfg");
			printWriter.flush();	// 立即把数据写入到硬盘
			printWriter.println("qwert");
			printWriter.println("zxcvb");
		} catch (IOException e) {
		}
	}
}
