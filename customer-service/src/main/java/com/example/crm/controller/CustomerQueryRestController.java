package com.example.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.crm.entity.Customer;
import com.example.crm.service.CustomerQueryService;
import com.example.crm.validation.TcKimlikNo;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("/customers")
@Validated
public class CustomerQueryRestController {
	@Autowired
	private CustomerQueryService customerService;
	@Value("${server.port}")
	int port;

	@GetMapping("/{identityNo}")
	public Customer getCustomerByIdentity(@PathVariable @TcKimlikNo String identityNo) {
		return customerService.findByIdentity(identityNo);
	}

	@GetMapping
	public List<Customer> getCustomers(@RequestParam(required = false, defaultValue = "0") int pageNo,
			@RequestParam(required = false, defaultValue = "10") int pageSize) {
		System.err.println(port);
		return customerService.findAll(pageNo, pageSize);
	}

}
