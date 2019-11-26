package com.example.crm.service;

import com.example.crm.entity.Customer;

public interface CustomerCommandService {

	void deleteByIdentity(String identityNo);

	void createCustomer(Customer customer);

	void updateCustomer(Customer customer);

}
