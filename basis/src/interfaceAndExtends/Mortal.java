package interfaceAndExtends;

/**
 * @author malf
 * @description 凡人类
 * @project how2jStudy
 * @since 2020/9/14
 */
public interface Mortal {
	public void die();

	// 默认方法是JDK8新特性，指的是接口也可以提供具体方法了
	default public void revive(){
		System.out.println("我复活了。");
	}
}
