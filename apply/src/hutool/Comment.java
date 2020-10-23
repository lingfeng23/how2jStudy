package hutool;

import java.lang.annotation.*;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/23
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Comment {
	String value();
}