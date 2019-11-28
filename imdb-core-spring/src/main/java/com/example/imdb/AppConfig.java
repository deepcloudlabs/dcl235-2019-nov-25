package com.example.imdb;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages= {
	"com.example.imdb.service.impl"	
})
@Profile({"dev", "test"})
@Import({
	AppDevConfig.class, AppTestConfig.class
})
public class AppConfig {
	@Value("${database.host}") // SpEL
	private String hostname;
	@Value("${database.port}") 
	private int port;
	@Value("${database.username}") 
	private String username;
	@Value("${database.password}") 
	private String password;
	
	@PostConstruct
	public void init() {
		System.err.println(hostname);
		System.err.println(port);
		System.err.println(username);
		System.err.println(password);
	}
}
