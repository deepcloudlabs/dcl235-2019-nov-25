package com.example.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.crm.entity.Customer;
import com.example.crm.entity.FullName;
import com.example.crm.entity.Identity;
import com.example.crm.repository.CustomerRepository;

@SpringBootApplication
@SuppressWarnings("unused")
//@EnableJpaRepositories(basePackages="")
//@EntityScan(basePackages="")
//@ComponentScan(basePackages="")
@EnableEurekaClient
@EnableDiscoveryClient
public class CustomerServiceApplication implements CommandLineRunner {
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer kate = new Customer(new Identity("1"), new FullName("Kate", "Austen"), "kate@abc", 1400);
		// customerRepository.save(kate);
	}

}
