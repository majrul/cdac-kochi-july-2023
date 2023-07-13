package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
