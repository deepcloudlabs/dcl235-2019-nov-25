package com.example.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.crm.entity.Customer;
import com.example.crm.service.CustomerCommandService;
import com.example.crm.validation.TcKimlikNo;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("/customers")
@Validated
public class CustomerCommandRestController {
	@Autowired
	private CustomerCommandService customerService;
	@Value("${server.port}")
	int port;

	@DeleteMapping("/{identityNo}")
	public void removeCustomerByIdentity(@PathVariable @TcKimlikNo String identityNo) {
		customerService.deleteByIdentity(identityNo);
	}

	@PostMapping
	public void addCustomer(@RequestBody @Validated Customer customer) {
		customerService.createCustomer(customer);
	}

	@PutMapping
	public void updateCustomer(@RequestBody @Validated Customer customer) {
		customerService.updateCustomer(customer);
	}
}
