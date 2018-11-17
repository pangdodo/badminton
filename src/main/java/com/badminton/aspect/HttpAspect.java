package com.badminton.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {

	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * com.badminton.controller.UserController.getUserList(..))")
	public void log() {
		
	}
	
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request =  attributes.getRequest();
		
		//url
		logger.info("url={}", request.getRequestURL());
		
		// method post get
		logger.info("method = {}",request.getMethod());
		//ip
		logger.info("ip = {}",request.getRemoteAddr());
		//类方法
		logger.info("class_method = {}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		//param
		logger.info("args={}", joinPoint.getArgs());
		
	}
	
	@After("log()")
	public void doAfert() {
		logger.info("后面拦截了**********************");
	}
	
	@AfterReturning(returning = "object",pointcut = "log()")
	public void doAterReturning(Object object) {
		logger.info("response={}",object.toString());
		
	}
}
