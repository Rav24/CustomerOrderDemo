package com.customer.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.order.model.Product;
import com.customer.order.repository.ProductRepository;
@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public Optional<Product> getProduct(int productId) {
		return productRepository.findById(productId);
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Product product, int productId) {
		Optional<Product> prod = getProduct(productId);
		if(prod.isPresent()) {
			Product p = prod.get();
			p.setProductName(product.getProductName());
			p.setProductPrice(product.getProductPrice());
			return productRepository.save(p);
		}else {
			return null;
		}
	}

	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

	
}
