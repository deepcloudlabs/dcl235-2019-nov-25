package com.example.crm.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crm.entity.Customer;
import com.example.crm.service.CustomerServiceFallback;

@FeignClient(name = "customer", fallback = CustomerServiceFallback.class)
public interface CustomerService {
	@GetMapping("/crm/api/v1/customers")
	public List<Customer> findAllCustomers(@RequestParam int pageNo, @RequestParam int pageSize);
}