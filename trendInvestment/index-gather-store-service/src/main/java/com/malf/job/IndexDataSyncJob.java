package com.malf.job;

import cn.hutool.core.date.DateUtil;
import com.malf.pojo.Index;
import com.malf.service.IndexDataService;
import com.malf.service.IndexService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @author malf
 * @description 任务类，同时刷新指数代码和指数数据。
 * @project trendInvestment
 * @since 2020/11/6
 */
public class IndexDataSyncJob extends QuartzJobBean {
	@Autowired
	private IndexService indexService;

	@Autowired
	private IndexDataService indexDataService;

	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println("定时启动：" + DateUtil.now());
		List<Index> indexes = indexService.fresh();
		for (Index index : indexes) {
			indexDataService.fresh(index.getCode());
		}
		System.out.println("定时结束：" + DateUtil.now());
	}
}
