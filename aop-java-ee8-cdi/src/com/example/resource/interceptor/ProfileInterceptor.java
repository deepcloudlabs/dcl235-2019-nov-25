package com.example.resource.interceptor;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

@Provider
public class ProfileInterceptor implements WriterInterceptor, ReaderInterceptor {

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		long start = System.currentTimeMillis();
		Object result = context.proceed();
		long stop = System.currentTimeMillis();
		System.err.println("Duration: " + (stop - start) + " ms.");
		return result;
	}

	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
		long start = System.currentTimeMillis();
		context.proceed();
		long stop = System.currentTimeMillis();
		System.err.println("Duration: " + (stop - start) + " ms.");
	}

}
