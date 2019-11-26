package com.example.imdb.aspect;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Component
@Scope("prototype")
@Aspect
public class ProfileAspect {
	@Around("@annotation(profile)")
	public Object profileMethod(ProceedingJoinPoint pjp, Profile profile) throws Throwable {
		long start = System.nanoTime();
		Object result = pjp.proceed();
		long stop = System.nanoTime();
		String methodName = pjp.getSignature().getName()+"*";
		TimeUnit tu = profile.unit();
		long duration = stop - start;
		long converted = tu.convert(duration, TimeUnit.NANOSECONDS);
		System.err.println(methodName + " runs at " + converted + " " + tu.name());
		return result;
	}

	@Around("@within(profile)")
	public Object profileClass(ProceedingJoinPoint pjp, Profile profile) throws Throwable {
		long start = System.nanoTime();
		Object result = pjp.proceed();
		long stop = System.nanoTime();
		String methodName = pjp.getSignature().getName();
		TimeUnit tu = profile.unit();
		long duration = stop - start;
		long converted = tu.convert(duration, TimeUnit.NANOSECONDS);
		System.err.println(methodName + " runs at " + converted + " " + tu.name());
		return result;
	}
}
