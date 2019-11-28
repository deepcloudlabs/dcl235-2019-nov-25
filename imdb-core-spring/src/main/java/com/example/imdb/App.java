package com.example.imdb;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.imdb.service.MovieService;

public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=
		// new ClassPathXmlApplicationContext("spring-min-config.xml");
		new AnnotationConfigApplicationContext(AppConfig.class);
		MovieService movieSrv = ctx.getBean(MovieService.class);
		movieSrv.findAllMoviesByYearRange(1970, 1979)
		        .forEach(System.out::println);
		ctx.close();
	}
}
