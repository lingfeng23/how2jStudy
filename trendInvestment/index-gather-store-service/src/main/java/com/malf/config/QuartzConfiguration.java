package com.malf.config;

import com.malf.job.IndexDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author malf
 * @description 定时器配置类
 * @project trendInvestment
 * @since 2020/11/6
 */
@Configuration
public class QuartzConfiguration {
	// 每隔一分钟执行一次(便于观察效果)
	private static final int interval = 1;

	@Bean
	public JobDetail weatherDataSyncJobDetail() {
		return JobBuilder.newJob(IndexDataSyncJob.class).withIdentity("indexDataSyncJob")
				.storeDurably().build();
	}

	@Bean
	public Trigger weatherDataSyncTrigger() {
		SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInMinutes(interval).repeatForever();

		return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
				.withIdentity("indexDataSyncTrigger").withSchedule(schedBuilder).build();
	}
}
