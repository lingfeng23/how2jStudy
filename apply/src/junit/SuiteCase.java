package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author malf
 * @description 可同时进行多个类的测试
 * @project how2jStudy
 * @since 2020/9/16
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(JunitCase.class)
public class SuiteCase {
}
