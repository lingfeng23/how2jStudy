package hutool;

import java.lang.annotation.*;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/9/16
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Comment {
	String value();
}
