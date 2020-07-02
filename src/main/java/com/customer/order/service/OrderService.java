package com.customer.order.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.customer.order.repository.OrderRepository;

public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	/*
	 * public <List<CustomerOrder>> getOrders(int customerId){
	 * 
	 * @Query("select ") orderRepository.getByCustomerId(); }
	 */
}
