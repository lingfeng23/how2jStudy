package com.malf.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author malf
 * @description 日志切面
 * @project how2jStudy
 * @since 2020/10/27
 */
@Aspect
@Component
public class LoggerAspect {
	@Around(value = "execution(* com.malf.service.ProductService.*(..))")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("start log:" + joinPoint.getSignature().getName());
		Object object = joinPoint.proceed();
		System.out.println("end log:" + joinPoint.getSignature().getName());
		return object;
	}
}
