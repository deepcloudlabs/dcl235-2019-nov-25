package com.example.crm.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crm.entity.Customer;
import com.example.crm.entity.Identity;
import com.example.crm.repository.CustomerRepository;
import com.example.crm.service.CustomerCommandService;
import com.example.crm.service.business.exception.ExistingCustomerException;

@Service
public class SimpleCommandCustomerService implements CustomerCommandService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional
	@CacheEvict(key = "#identityNo", cacheNames = "customers")
	public void deleteByIdentity(String identityNo) {
		customerRepository.deleteById(new Identity(identityNo));
	}

	@Override
	@Transactional
	public void createCustomer(Customer customer) {
		if (customerRepository.existsById(customer.getIdentity())) {
			throw new ExistingCustomerException(customer.getIdentity().getNo(), "Customer already exists!",
					"customerAlreadyExists", "5c56ea39-67f1-47fc-868d-51c0abd0984a");
		}
		customerRepository.save(customer);
	}

	@Override
	@Transactional
	@CacheEvict(key = "#customer.identity.no", cacheNames = "customers")
	public void updateCustomer(Customer customer) {
		/*
		 * Customer managed = this.findByIdentity(customer.getIdentity().getNo()); if
		 * (Objects.nonNull(customer.getPhoto())) managed.setPhoto(customer.getPhoto());
		 * if (Objects.nonNull(customer.getEmail()))
		 * managed.setEmail(customer.getEmail());
		 */
	}

}
