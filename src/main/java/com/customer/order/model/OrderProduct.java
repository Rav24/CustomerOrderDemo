package com.customer.order.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class OrderProduct {

	@Id
	@GeneratedValue
	private int id;
	private int quantity;
	
	@OneToOne(targetEntity = Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name="order_product_id", referencedColumnName = "id")
	private Product product;
}
