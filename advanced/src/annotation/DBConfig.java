package annotation;

import java.lang.annotation.*;

/**
 * @author malf
 * @description 数据库配置的注解类
 * @project how2jStudy
 * @since 2020/9/15
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DBConfig {
	String ip();
	int port() default 3306;
	String database();
	String encoding();
	String user();
	String password();
}
