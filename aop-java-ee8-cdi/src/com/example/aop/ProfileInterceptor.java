package com.example.aop;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@SuppressWarnings("serial")
@Interceptor
@Profile
public class ProfileInterceptor implements Serializable {

	@AroundInvoke
	public Object profile(InvocationContext ic) throws Exception {
		long start = System.nanoTime();
		Object result = ic.proceed();
		long stop = System.nanoTime();
		long duration = (stop - start);
		TimeUnit tu = TimeUnit.MICROSECONDS;
		String methodName = ic.getMethod().getName();
		if (ic.getMethod().isAnnotationPresent(Profile.class)) {
			Profile profile = ic.getMethod().getAnnotation(Profile.class);
			tu = profile.value();
		}
		duration = TimeUnit.NANOSECONDS.convert(duration, tu);
		System.err.println(
				ic.getTarget().getClass().getName() + "::" + methodName + " runs " + duration + " " + tu.name());
		return result;
	}

}
