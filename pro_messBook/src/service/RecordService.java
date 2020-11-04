package service;

import dao.RecordDao;
import entity.Category;
import entity.Record;

import java.util.Date;

/**
 * @author malf
 * @description 消费记录业务类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class RecordService {
	RecordDao recordDao = new RecordDao();

	public void add(int spend, Category category, String comment, Date date) {
		Record record = new Record();
		record.spend = spend;
		record.cid = category.id;
		record.comment = comment;
		record.date = date;
		recordDao.add(record);
	}
}
