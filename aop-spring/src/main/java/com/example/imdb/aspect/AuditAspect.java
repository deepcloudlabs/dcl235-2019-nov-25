package com.example.imdb.aspect;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Component
@Aspect
public class AuditAspect {
//	@Before
//	@AfterReturning
//	@AfterThrowing
//	@After
	@Around("execution(* *.*(int,int))")
	public Object audit(ProceedingJoinPoint pjp) throws Throwable {
		String methodName= pjp.getSignature().getName();
		Date now = new Date();
		System.err.println(methodName+" is called at "+now);
		System.err.println("Parameters are "+Arrays.toString(pjp.getArgs()));
		Object result = pjp.proceed();
		System.err.println(methodName + " returns "+result);
		return result;
	}
}
