package hutool;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.comparator.PinyinComparator;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.cron.CronUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author malf
 * @description 常用类辅助工具
 * @project how2jStudy
 * @since 2020/10/23
 */
public class ClassHelperDemo {
	// 转换工具
	@Test
	@Comment("转换为字符串")
	public void test1() {
		int a = 1;
		String aStr = Convert.toStr(a);
		int[] b = {1, 2, 3, 4, 5};
		String bStr = Convert.toStr(b);
		Object c = null;
		String cStr = Convert.toStr(c);
		System.out.println(aStr);
		System.out.println(bStr);
		System.out.println(cStr);
	}

	@Test
	@Comment("数组类型互相转化")
	public void test2() {
		String[] a = {"1", "2", "3", "4", "5"};
		Integer[] b = Convert.toIntArray(a);
		System.out.println(Convert.toStr(a));
		System.out.println(Convert.toStr(b));
	}

	@Test
	@Comment("数组和集合互换")
	public void test3() {
		String[] a = {"1", "2", "3", "4", "5"};
		List list = Convert.toList(a);
		String[] b = Convert.toStrArray(list);
		System.out.println(list);
		System.out.println(b);
	}

	@Test
	@Comment("数字转换为金额")
	public void test4() {
		double a = 1234567123456.12;
		String b = Convert.digitToChinese(a);
		System.out.println(b);
	}

	// 日期工具
	@Test
	@Comment("字符串转日期")
	public void test5() {
		Date d;
		String str1 = "12:12:12";
		d = DateUtil.parse(str1);
		System.out.println("字符串=" + str1 + ",日期格式=" + d);

		String str2 = "2012-12-12";
		d = DateUtil.parse(str2);
		System.out.println("字符串=" + str2 + ",日期格式:" + d);

		String str3 = "2012-12-12 12:12";
		d = DateUtil.parse(str3);
		System.out.println("字符串=" + str3 + ",日期格式=" + d);

		String str4 = "2012-12-12 12:12:12";
		d = DateUtil.parse(str4);
		System.out.println("字符串=" + str4 + ",日期格式=" + d);
	}

	@Test
	@Comment("日期转字符串")
	public void test6() {
		Date d = new Date();
		String format = DateUtil.format(d, "yyyy/MM/dd");
		String formatDate = DateUtil.formatDate(d);
		String formatDateTime = DateUtil.formatDateTime(d);
		String formatTime = DateUtil.formatTime(d);
		System.out.println("自定义格式：" + format);
		System.out.println("日期格式：" + formatDate);
		System.out.println("日期和时间格式：" + formatDateTime);
		System.out.println("时间格式：" + formatTime);
	}

	@Test
	@Comment("获取部分信息")
	public void test7() {
		Date d = new Date();
		//获得年的部分
		int year = DateUtil.year(d);
		//获得月份，从0开始计数
		int month = DateUtil.month(d);
		//获得月份枚举
		Enum months = DateUtil.monthEnum(d);
		System.out.println(year);
		System.out.println(month);
		System.out.println(months);
	}

	@Test
	@Comment("开始和结束时间")
	public void test8() {
		Date date = new Date();
		//一天的开始
		Date beginOfDay = DateUtil.beginOfDay(date);
		//一天的结束
		Date endOfDay = DateUtil.endOfDay(date);
		System.out.println(beginOfDay);
		System.out.println(endOfDay);
	}

	@Test
	@Comment("日期时间偏移")
	public void test9() {
		Date date = new Date();
		Date d1 = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);
		Date d2 = DateUtil.offsetDay(date, 3);
		Date d3 = DateUtil.offsetHour(date, -3);
		System.out.println("两天之后的日期：" + d1);
		System.out.println("三天之后的日期：" + d2);
		System.out.println("三小时之前的日期：" + d3);

		Date yesterday = DateUtil.yesterday();
		Date tomorrow = DateUtil.tomorrow();
		Date lastWeek = DateUtil.lastWeek();
		Date nextWeek = DateUtil.nextWeek();
		Date lastMonth = DateUtil.lastMonth();
		Date nextMonth = DateUtil.nextMonth();
		System.out.println(yesterday);
		System.out.println(tomorrow);
		System.out.println(lastWeek);
		System.out.println(nextWeek);
		System.out.println(lastMonth);
		System.out.println(nextMonth);
	}

	// 数字工具
	@Test
	@Comment("精确计算")
	public void test10() {
		double result1 = (1.2 - 0.4);
		double result2 = NumberUtil.sub(1.2, 0.4);
		System.out.println(result1);
		System.out.println(result2);
	}

	@Test
	@Comment("四舍五入")
	public void test11() {
		double a = 100.123;
		double b = 100.125;
		double result1 = NumberUtil.round(a, 2).doubleValue();
		double result2 = NumberUtil.round(b, 2).doubleValue();
		System.out.println(result1);
		System.out.println(result2);
	}

	@Test
	@Comment("整数列表")
	public void test12() {
		int numbers[] = NumberUtil.range(0, 100, 9);
		System.out.println(Convert.toStr(numbers));
	}

	// 数组工具
	@Test
	@Comment("合并数组")
	public void test13() {
		Integer[] a = {1, 2, 3};
		Integer[] b = {10, 11, 12};
		Integer[] c = ArrayUtil.addAll(a, b);
		System.out.println(Convert.toStr(a));
		System.out.println(Convert.toStr(b));
		System.out.println(Convert.toStr(c));

	}

	@Test
	@Comment("转换为字符串")
	public void test14() {
		int a[] = {1, 2, 3};
		System.out.println(ArrayUtil.toString(a));
		System.out.println(ArrayUtil.join(a, "-"));
	}

	// 随机工具
	@Test
	@Comment("各种随机数")
	public void test15() {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		System.out.println(RandomUtil.randomInt(1, 1000));
		System.out.println(RandomUtil.randomString(10));
		System.out.println(RandomUtil.randomEle(list));
		System.out.println(RandomUtil.simpleUUID());
	}

	// 比较器工具
	@Test
	@Comment("拼音比较器")
	public void test16() {
		List<String> names = new ArrayList<>();
		names.add("令狐冲");
		names.add("石破天");
		names.add("陈家洛");
		System.out.println("未排序：" + CollectionUtil.join(names, ","));
		Collections.sort(names, new PinyinComparator());
		System.out.println("根据拼音排序：" + CollectionUtil.join(names, ","));
	}

	// 定时器工具
	@Test
	@Comment("定时器工具")
	public void test17() {
		CronUtil.setMatchSecond(true);
		CronUtil.start();

		CronUtil.schedule("*/2 * * * * ?", new Runnable() {
			@Override
			public void run() {
				System.out.println(DateUtil.now() + "执行新任务");
			}
		});
	}

}