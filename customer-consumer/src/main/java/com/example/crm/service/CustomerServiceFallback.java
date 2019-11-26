package com.example.crm.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crm.entity.Customer;
import com.example.crm.feign.CustomerService;

@Service
public class CustomerServiceFallback implements CustomerService {

	@Override
	public List<Customer> findAllCustomers(int pageNo, int pageSize) {
		return Collections.emptyList();
	}

}
