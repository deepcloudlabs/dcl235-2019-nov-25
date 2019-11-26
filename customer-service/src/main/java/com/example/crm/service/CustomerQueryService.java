package com.example.crm.service;

import java.util.List;

import com.example.crm.entity.Customer;

public interface CustomerQueryService {

	Customer findByIdentity(String identityNo);

	List<Customer> findAll(int pageNo, int pageSize);

}
