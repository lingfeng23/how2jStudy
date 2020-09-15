package junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/9/16
 */
public class JunitCase {
	@Before
	public void before() {
		System.out.println("测试前");
	}
	@After
	public void after() {
		System.out.println("测试后");
	}

	@Test
	public void testSum1() {
		int result = SumUtil.sum1(1, 2);
		Assert.assertEquals(result, 3);
	}

	@Test
	public void testSum2() {
		int result = SumUtil.sum2(1, 2, 3);
		Assert.assertEquals(result, 6);
	}

}
