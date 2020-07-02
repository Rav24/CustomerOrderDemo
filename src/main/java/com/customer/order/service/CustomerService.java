package com.customer.order.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.order.model.Customer;
import com.customer.order.model.CustomerOrders;
import com.customer.order.repository.CustomerRepository;
import com.customer.order.repository.OrderRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository cutomerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	public List<Customer> getCustomer() {
		
		return cutomerRepository.findAll();
	}
	public Customer save(Customer customer) {
		return cutomerRepository.save(customer);
	}
	public Optional<Customer> getCustomerById(int id) {
		return cutomerRepository.findById(id);
	}
	public Optional<List<CustomerOrders>> getCustomerOrders(int id) {
		return getCustomerById(id).map(customer -> {
			return customer.getCustomerOrders();
		});
		
		//return orderRepository.findAllBycustomerOrderId(id);
	}
	public Optional<CustomerOrders> getCustomerOrderById(int customerId, int orderId) {
		Optional<CustomerOrders> customerOrders = null;
		Optional<List<CustomerOrders>> orders = getCustomerById(customerId).map(customer -> {
			return customer.getCustomerOrders();
		});
		if(orders.isPresent()) {
			return customerOrders = orders.get().stream().filter( ord -> (ord.getId() == orderId)).findAny();
		};
		CustomerOrders c = new CustomerOrders();
		//return Optional<c>;
		return customerOrders;
		
		//return orderRepository.FindByOrderByCustomerIdOrderId();
	}

	
}
