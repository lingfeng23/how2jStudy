package classAndObject;

/**
 * @author malf
 * @description 饿汉式单例模式
 * @project how2jStudy
 * @since 2020/9/14
 */
public class GiantDragon1 {
	// 私有化构造方法使得该类无法在外部通过new 进行实例化
	private GiantDragon1(){
	}
	// 准备一个类属性，指向一个实例化对象。 因为是类属性，所以只有一个
	private static GiantDragon1 instance = new GiantDragon1();

	//public static 方法，提供给调用者类中定义的对象
	public static GiantDragon1 getInstance() {
		return instance;
	}

}
