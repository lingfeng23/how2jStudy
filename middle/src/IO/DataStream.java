package IO;

import java.io.*;

/**
 * @author malf
 * @description 数据流
 * DataInputStream 数据输入流
 * DataOutputStream 数据输出流
 * @project how2jStudy
 * @since 2020/10/12
 */
public class DataStream {
	public static void main(String[] args) {
		File file = new File("E:\\malf\\how2jStudy\\middle\\src\\IO\\buffer.txt");
		// 向文件顺序写出 布尔值，整数和字符串
		try (
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)
		) {
			dataOutputStream.writeBoolean(true);
			dataOutputStream.writeInt(200);
			dataOutputStream.writeUTF("hello");
		} catch (IOException e) {
		}

		// 读取文件内容
		try (
				FileInputStream fileInputStream = new FileInputStream(file);
				DataInputStream dataInputStream = new DataInputStream(fileInputStream);
		) {
			boolean b = dataInputStream.readBoolean();
			int i = dataInputStream.readInt();
			String str = dataInputStream.readUTF();
			System.out.println("读取到布尔值:" + b);
			System.out.println("读取到整数:" + i);
			System.out.println("读取到字符串:" + str);
		} catch (IOException e) {
		}

	}
}
