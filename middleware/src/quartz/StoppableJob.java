package quartz;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

/**
 * @author malf
 * @description 中断 Job
 * @project how2jStudy
 * @since 2020/11/7
 */
public class StoppableJob implements InterruptableJob {
	private boolean stop = false;

	@Override
	public void interrupt() throws UnableToInterruptJobException {
		System.out.println("被调度叫停");
		stop = true;
	}

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		while (true) {
			if (stop)
				break;
			try {
				System.out.println("每隔1秒，进行一次检测，看看是否停止");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("持续工作中。。。");
		}
	}
}
