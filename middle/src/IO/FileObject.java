package IO;

import java.io.File;
import java.util.Date;

/**
 * @author malf
 * @description I/O文件对象
 * @project how2jStudy
 * @since 2020/9/28
 */
public class FileObject {
	public static void main(String[] args) {
		// 绝对路径
		File file1 = new File("D:/file1");
		System.out.println(file1.getAbsolutePath());
		// 相对路径
		File file2 = new File("file2");
		System.out.println(file2.getAbsolutePath());
		// file1 作为父目录创建文件
		File file3 = new File(file1, "file3");
		System.out.println(file3.getAbsolutePath());

		File file = new File("D:\\Program Files");
		System.out.println(file.list());
		for (String name: file.list()) {
			System.out.println(name);
		}
		System.out.println(file.getParent());
		System.out.println(file.getParentFile());
		System.out.println(file.length());
		System.out.println(new Date(file.lastModified()));
	}
}
