package com.customer.order.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.order.model.Product;
import com.customer.order.service.ProductService;

@CrossOrigin
@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/products/productId")
	public Optional<Product> getProducts(@PathVariable("productId") int productId){
		return productService.getProduct(productId);
	}
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product,
			@PathVariable("productId") int productId) {
		return productService.updateProduct(product, productId);
	}
	
	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId) {
		productService.deleteProduct(productId);
	}
}
