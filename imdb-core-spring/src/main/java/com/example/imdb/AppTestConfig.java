package com.example.imdb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("test")
@PropertySource("classpath:database-test.properties")
public class AppTestConfig {

}
