package com.oracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.model.Product;
import com.oracle.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping
	public String addProduct(@RequestBody Product product) {
		System.out.println("ProductController.addProduct()");
		return productService.addProduct(product);
	}

	@GetMapping("/{pid}")
	public Product getProductByPid(@PathVariable Integer pid) {
		System.out.println("ProductController.getProductByPid()");
		return productService.getProductByPid(pid);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		System.out.println("ProductController.getAllProducts()");
		return productService.getAllProducts();
	}

	@DeleteMapping("/{pid}")
	public String deleteProductByPid(@PathVariable Integer pid) {
		System.out.println("ProductController.deleteProductByPid()");
		return productService.deleteProductByPid(pid);
	}

	@PutMapping
	public String updateProduct(@RequestBody Product product) {
		System.out.println("ProductController.updateProduct()");
		return productService.updateProduct(product);
	}

}
