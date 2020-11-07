package quartz;

import org.quartz.*;

/**
 * @author malf
 * @description 数据库备份任务
 * @project how2jStudy
 * @since 2020/11/7
 */
@DisallowConcurrentExecution
public class DatabaseBackupJob implements Job {
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDetail detail = context.getJobDetail();
		String database = detail.getJobDataMap().getString("database");
		System.out.printf("给数据库 %s 备份, 耗时10秒 %n", database);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
