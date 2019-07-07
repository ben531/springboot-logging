package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogTimeAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Pointcut("@annotation(com.example.demo.annotation.Logtime)")
	public void pointCut() {

	}

	@Around("pointCut()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Signature signature = pjp.getSignature();
		String declaringTypeName = signature.getDeclaringTypeName();
		logger.info(declaringTypeName + "方法begin");
		Object proceed = pjp.proceed();
		logger.info(declaringTypeName + "方法end");
		long end = System.currentTimeMillis();
		logger.debug(declaringTypeName + "方法耗时: " + (end - start) + "ms");
		return proceed;
	}

}
