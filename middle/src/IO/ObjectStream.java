package IO;

import java.io.*;

/**
 * @author malf
 * @description 对象流
 * 指的是可以直接把一个对象以流的形式传输给其他的介质，比如硬盘
 * 一个对象以流的形式进行传输，叫做序列化。 该对象所对应的类，必须是实现Serializable接口
 * @project how2jStudy
 * @since 2020/10/12
 */
public class ObjectStream {
	public static void main(String[] args) {
		Hero hero = new Hero();
		hero.name = "AAA";
		hero.blood = 200;
		File file = new File("E:\\malf\\how2jStudy\\middle\\src\\IO\\hero.txt");
		try (
				// 对象输出流
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				// 对象输入流
				FileInputStream fileInputStream = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		) {
			objectOutputStream.writeObject(hero);
			Hero result = (Hero) objectInputStream.readObject();
			System.out.println(result.name);
			System.out.println(result.blood);
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
	}
}
