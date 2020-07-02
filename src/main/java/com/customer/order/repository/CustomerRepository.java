package com.customer.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.order.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
