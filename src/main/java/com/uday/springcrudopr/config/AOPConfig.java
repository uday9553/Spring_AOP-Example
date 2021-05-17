package com.uday.springcrudopr.config;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class AOPConfig {

	Logger log = LoggerFactory.getLogger(AOPConfig.class);
	
//	@Pointcut(value="execution(* com.uday.springcrudopr.*.*.*(..) )")
//	public void pointcutmethod() {
//		
//	}
	
	//you can also give above methodname as pointcut and define pointcut by giving value
	//@Around("pointcutmethod()")
	@Around("execution(* com.uday.springcrudopr.*.*.*(..) )")
	public Object applicationLogger(ProceedingJoinPoint proceedjoinpoint) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = proceedjoinpoint.getSignature().getName();
		String className = proceedjoinpoint.getTarget().getClass().toString();
		Object[] array = proceedjoinpoint.getArgs();
		log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
				+ mapper.writeValueAsString(array));
		Object object = proceedjoinpoint.proceed();
		log.info(className + " : " + methodName + "()" + "Response : "
				+ mapper.writeValueAsString(object));
		return object;
	}
	
	
	//Here @Before is the advice and execution(* com.uday.springcrudopr.*.*.*(..) )"
	//@Before("execution(* com.uday.springcrudopr.*.*.*(..) )") This is combinely called pointcut
	@Before("execution(* com.uday.springcrudopr.*.*.*(..) )")
	public void loggingAdvice(JoinPoint joinPoint){
		System.out.println("Before running loggingAdvice on method="+joinPoint.toString());
		
		System.out.println("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));

	}
	
	
	@After("execution(* com.uday.springcrudopr.service.EmployeeService.getEmpName(..))")
	public void logStringArguments(JoinPoint joinPoint){
		System.out.println("Running After Advice. String argument passed="+ Arrays.toString(joinPoint.getArgs()));
	}
}
