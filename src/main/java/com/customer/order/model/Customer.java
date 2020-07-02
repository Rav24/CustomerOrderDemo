package com.customer.order.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private int zip;
	private int customerPhone;
	private String customerEmail;
	@OneToMany(targetEntity = CustomerOrders.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerOrderId_fk", referencedColumnName = "customer_id")
	private List<CustomerOrders> customerOrders;
}
