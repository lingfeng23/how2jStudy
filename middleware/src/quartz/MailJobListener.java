package quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/11/7
 */
public class MailJobListener implements JobListener {
	@Override
	public String getName() {
		return "listener of mail job";
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
		System.out.println("准备执行：\t " + jobExecutionContext.getJobDetail().getKey());
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
		System.out.println("取消执行：\t " + jobExecutionContext.getJobDetail().getKey());
	}

	@Override
	public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
		System.out.println("执行结束：\t " + jobExecutionContext.getJobDetail().getKey());
		System.out.println();
	}
}
