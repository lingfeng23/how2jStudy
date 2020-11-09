package com.malf.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author malf
 * @description TODO
 * @project shiroSpringBoot
 * @since 2020/11/9
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtils.context = applicationContext;
	}

	public static ApplicationContext getContext() {
		return context;
	}
}
