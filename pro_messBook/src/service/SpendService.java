package service;

import dao.RecordDao;
import entity.Record;
import page.SpendPage;
import util.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * @author malf
 * @description 消费一览业务类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class SpendService {
	public SpendPage getSpendPage() {
		RecordDao recordDao = new RecordDao();
		// 本月数据
		List<Record> thisMonthRecords = recordDao.listThisMonth();
		// 今日数据
		List<Record> todayRecords = recordDao.listToday();
		// 本月总天数
		int thisMonthTotalDay = DateUtil.thisMonthTotalDay();

		int monthSpend = 0, todaySpend = 0, dayAvgSpend = 0;
		int monthAvailable = 0, dayAvgAvailable = 0, monthLeftDay = 0, usagePercentage = 0;
		// 预算
		int monthBudget = new ConfigService().getIntBudget();
		// 统计本月消费
		for (Record record : thisMonthRecords) {
			monthSpend += record.getSpend();
		}
		// 统计今日消费
		for (Record record : todayRecords) {
			todaySpend += record.getSpend();
		}
		// 计算日均消费
		dayAvgSpend = monthSpend / thisMonthTotalDay;
		// 计算本月剩余
		monthAvailable = monthBudget - monthSpend;
		// 距离月末
		monthLeftDay = DateUtil.thisMonthLeftDay();
		// 计算日均可用
		dayAvgAvailable = monthAvailable / monthLeftDay;
		// 计算使用比例
		usagePercentage = monthSpend * 100 / monthBudget;
		// 根据这些信息，生成SpendPage对象
		return new SpendPage(monthSpend, todaySpend, dayAvgSpend, monthAvailable, dayAvgAvailable, monthLeftDay,
				usagePercentage);
	}
}
