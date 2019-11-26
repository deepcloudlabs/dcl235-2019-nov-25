package com.example.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import javax.interceptor.InterceptorBinding;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@InterceptorBinding
@Documented
@Inherited
public @interface Profile {
	TimeUnit value() default TimeUnit.MICROSECONDS;
}