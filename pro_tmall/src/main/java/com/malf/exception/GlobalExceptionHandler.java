package com.malf.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author malf
 * @description 异常处理，主要是在处理删除父类信息的时候，因为外键约束的存在，而导致违反约束。
 * @project how2jStudy
 * @since 2020/10/28
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public String defaultErrorHandler(HttpServletRequest request, Exception exception) throws Exception {
		Class constraintViolationException = Class.forName("org.hibernate.exception.ConstraintViolationException");
		if (null != exception.getCause() && constraintViolationException == exception.getCause().getClass()) {
			return "违反了约束，多半是外键约束";
		}
		return exception.getMessage();
	}
}
