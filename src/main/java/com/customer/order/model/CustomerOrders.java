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
public class CustomerOrders {
	@Column(name = "order_id")
	@Id
	@GeneratedValue
	private int id;
	
	@OneToMany(targetEntity = OrderProduct.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_orders_id", referencedColumnName = "order_id")
	private List<OrderProduct> ordersProducts;
	private String orderStatus;
	private double totalPrice;
	/*
	 * public double getTotalPrice(List<Product> products) {
	 * 
	 * products.stream().map( product -> { double prodPrice = 0.0; return prodPrice
	 * = prodPrice + product.getProductPrice(); }); return 0.0;
	 * 
	 * }
	 */
	
	
}
