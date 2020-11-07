package quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;
import org.quartz.jobs.ee.mail.SendMailJob;

/**
 * @author malf
 * @description 定时器测试类
 * @project how2jStudy
 * @since 2020/11/7
 */
public class QuartzTest {
	public static void main(String[] args) throws Exception {
		// 创建调度器
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		// 定义一个触发器
		Trigger trigger = newTrigger()
				.withIdentity("trigger", "group")
				.startNow()
//				.withSchedule(simpleSchedule()
//						.withIntervalInSeconds(2) // 每个2秒执行一次
//						.withRepeatCount(10)) // 总共执行11次(第一次执行不计数)
				.build();
		// 定义一个 JobDetail
		JobDetail jobDetail = mailJob();
		// JobDetail jobDetail = databaseJob();
		//JobDetail jobDetail = stopJob();

		// 增加 Job 监听
		MailJobListener mailJobListener = new MailJobListener();
		KeyMatcher<JobKey> keyMatcher = KeyMatcher.keyEquals(jobDetail.getKey());
		scheduler.getListenerManager().addJobListener(mailJobListener, keyMatcher);

		// 调度加入这个 JobDetail
		scheduler.scheduleJob(jobDetail, trigger);
		// 启动
		scheduler.start();
		// Thread.sleep(5000);
		// System.out.println("过5秒，调度停止 job");
		// key 就相当于这个 Job 的主键
		// scheduler.interrupt(jobDetail.getKey());

		// 等待20秒，让前面的任务都执行完了之后，再关闭调度器
		Thread.sleep(20000);
		scheduler.shutdown(true);
	}

	private static JobDetail stopJob() throws Exception {
		//定义一个 JobDetail
		JobDetail jobDetail = newJob(StoppableJob.class)
				.withIdentity("stopJob", "stopGroup")
				.build();
		return jobDetail;
	}

	private static JobDetail databaseJob() throws Exception {
		//定义一个JobDetail
		JobDetail job = newJob(DatabaseBackupJob.class)
				.withIdentity("backupJob", "databaseGroup")
				.usingJobData("database", "how2java")
				.build();
		return job;
	}

	private static JobDetail mailJob() throws Exception {
		JobDetail jobDetail = newJob(MailJob.class) // 指定干活的类 MailJob
				.withIdentity("mailJob", "mailGroup") // 定义任务名称和分组
				.usingJobData("email", "15131257162@163.com") // 定义属性
				.build();
		// 用 JobDataMap 修改 email
		jobDetail.getJobDataMap().put("email", "admin@taobao.com");
		return jobDetail;
	}
}
