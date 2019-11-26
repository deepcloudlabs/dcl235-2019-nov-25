package com.example.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.crm.feign.CustomerService;

@Service
public class CustomerServiceConsumer {
	@Autowired
	private CustomerService customerService;

	@Scheduled(fixedRate = 1_000)
	public void readCustomers() {
		customerService.findAllCustomers(0, 10).forEach(System.out::println);
	}
}
