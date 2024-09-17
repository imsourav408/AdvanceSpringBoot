package com.oracle.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.oracle.dao.ProductDao;
import com.oracle.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	@CacheEvict(value = "products", allEntries = true)
	public String addProduct(Product product) {
		System.out.println("ProductService.addProduct()");
		product.setPid(new Random().nextInt(1000000)+1);
		return productDao.addProduct(product);
	}

	@Cacheable(value = "products", key = "#pid")
	public Product getProductByPid(Integer pid) {
		System.out.println("ProductService.getProductByPid()");
		return productDao.getProductByPid(pid);
	}

	@Cacheable("products")
	public List<Product> getAllProducts() {
		System.out.println("ProductService.getAllProducts()");
		return productDao.getAllProducts();
	}

	@CacheEvict(value = "products", allEntries = true)
	public String deleteProductByPid(Integer pid) {
		System.out.println("ProductService.deleteProductByPid()");
		return productDao.deleteProductByPid(pid);
	}

	@CachePut(value = "products", key = "#product.pid")
//    @CacheEvict(value = "products", allEntries = true)
	public String updateProduct(Product product) {
		System.out.println("ProductService.updateProduct()");
		return productDao.updateProduct(product);
	}

}
