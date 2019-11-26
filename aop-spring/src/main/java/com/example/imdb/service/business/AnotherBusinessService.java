package com.example.imdb.service.business;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Service
@Scope("prototype")
public class AnotherBusinessService implements AutoCloseable {
	@PostConstruct
	public void init() {
		System.err.println("AnotherBusinessService::init()");
	}

	@PreDestroy
	public void destroy() {
		System.err.println("AnotherBusinessService::destroy()");
	}

	@Override
	public void close() throws Exception {
		destroy();
	}
}
