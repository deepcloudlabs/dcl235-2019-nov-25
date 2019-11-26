package com.example.crm.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.crm.entity.Customer;
import com.example.crm.entity.Identity;
import com.example.crm.repository.CustomerRepository;
import com.example.crm.service.CustomerQueryService;
import com.example.crm.service.business.exception.CustomerNotFoundException;

@Service
public class SimpleQueryCustomerService implements CustomerQueryService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Cacheable(key = "#identityNo", value = "customers")
	public Customer findByIdentity(String identityNo) {
		System.err.println("findByIdentity(" + identityNo + ")");
		return customerRepository.findById(new Identity(identityNo))
				.orElseThrow(() -> new CustomerNotFoundException("Customer is not found!", "customerNotFound",
						"5e07b8e9-f945-41cf-90c8-33c795125692"));
	}

	@Override
	public List<Customer> findAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return customerRepository.findAll(pageable).getContent();
	}

}
