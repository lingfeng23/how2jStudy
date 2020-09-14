package exceptHandle;

import objectOriented.Hero;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/9/14
 */
public class TestException {
	public static void main(String[] args) {
		File file = new File("D:/LOL.txt");

		// 试图打开文件LOL.txt，会抛出FileNotFoundException，如果不处理该异常，就会有编译错误
		//new FileInputStream(file);
	}
}
