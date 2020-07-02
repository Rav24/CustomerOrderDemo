package com.customer.order.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.order.model.Customer;
import com.customer.order.model.CustomerOrders;
import com.customer.order.service.CustomerService;

@CrossOrigin
@RestController
public class CustomerOrderController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomer();
		
	}
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer){
		return customerService.save(customer);
		
	}
	
	@GetMapping("/customers/{customerId}")
	public Optional<Customer> getCustomerById(@PathVariable("customerId") int id){
		return customerService.getCustomerById(id);
		
	}
	
	@GetMapping("/customers/{customerId}/orders")
	public Optional<List<CustomerOrders>> getCustomerOrders(@PathVariable("customerId") int id){
		return customerService.getCustomerOrders(id);
		
	}
	
	@GetMapping("/customers/{customerId}/orders/{orderId}")
	public Optional<CustomerOrders> getOrderById(@PathVariable("customerId") int customerId, @PathVariable("orderId") int orderId){
		return customerService.getCustomerOrderById(customerId,orderId);
		
	}
	
	
	
}
