package com.example.crm.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.crm.entity.Customer;
import com.example.crm.entity.Identity;

public interface CustomerRepository extends MongoRepository<Customer, Identity> {
//	@Query(value="select c from Customer c where c.birthYear between :from and :to")
	Stream<Customer> findAllByBirthYearBetween(int from, int to);

	Optional<Customer> findByEmail(String email);
}
