package IO;

import java.io.Serializable;

/**
 * @author malf
 * @description 序列化类
 * @project how2jStudy
 * @since 2020/10/12
 */
public class Hero implements Serializable {
	// 该类当前的版本号，变动后需要修改此值
	private static final long serialVersionUID = 1L;

	public String name;
	public float blood;
}
