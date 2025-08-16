package com.wipro.gp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Aspect  //extra logic
@Component //object creation
@Slf4j
public class LoggingAspect {

	//
	@Before("execution(* com.wipro.gp.controllers.MedicalRecordController.saveRecord(..))")
	public void logBeforeAddDoctor(JoinPoint joinpoint) 
	{
		log.warn("loging something before storing medical record endpoint"+joinpoint.getArgs());
	}
	
}