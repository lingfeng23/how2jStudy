package hutool;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/23
 */
public class HutoolDemo {
	public static void main(String[] args) {
		String dateStr = "2020-12-12 10:10:10";
		Date date = DateUtil.parse(dateStr);
		System.out.println(date);
	}
}
