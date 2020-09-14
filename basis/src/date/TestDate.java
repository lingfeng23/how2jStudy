package date;

import com.sun.org.apache.bcel.internal.generic.SIPUSH;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author malf
 * @description 时间日期相关
 * @project how2jStudy
 * @since 2020/9/14
 */
public class TestDate {
	public static void main(String[] args) {
		// 当前时间
		Date current = new Date();
		System.out.println(current);
		// 从1970年1月1日 早上8点0分0秒 开始经历的毫秒数
		Date date = new Date(5000);
		System.out.println(date);
		Date date0 = new Date(0);
		System.out.println(date0);

		System.out.println(current.toString());
		// 当前日期的毫秒数
		System.out.println(current.getTime());

		// 通过System.currentTimeMillis()获取当前日期的毫秒数
		System.out.println(System.currentTimeMillis());

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		String str1 = sdf1.format(current);
		System.out.println(str1);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyy-MM-dd");
		String str2 = sdf2.format(current);
		System.out.println(str2);

		// 单例模式获取日历对象Calendar.getInstance();
		Calendar c = Calendar.getInstance();
		// 通过日历对象得到日期对象
		Date d = c.getTime();
		System.out.println(d);
	}

}
