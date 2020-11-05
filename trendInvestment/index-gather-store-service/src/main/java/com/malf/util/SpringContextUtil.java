package com.malf.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author malf
 * @description 工具类，用于获取 IndexService
 * @project trendInvestment
 * @since 2020/11/5
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
	private SpringContextUtil() {
		System.out.println("SpringContextUtil()");
	}

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		System.out.println("applicationContext:" + applicationContext);
		SpringContextUtil.applicationContext = applicationContext;
	}

	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
}
