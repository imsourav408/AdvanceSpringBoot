package com.oracle.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oracle.model.Product;

@Repository
public class ProductDao {

	private List<Product> products = new ArrayList<Product>();

	public String addProduct(Product product) {
		System.out.println("ProductDao.addProduct()");
		products.add(product);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Product added successfuly";
	}

	public Product getProductByPid(Integer pid) {
		System.out.println("ProductDao.getProductByPid()");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return products.stream().filter(product -> product.getPid().equals(pid)).findAny().get();
	}

	public List<Product> getAllProducts() {
		System.out.println("ProductDao.getAllProducts()");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return products;
	}

	public String deleteProductByPid(Integer pid) {
		System.out.println("ProductDao.deleteProductByPid()");
		Product product = products.stream().filter(prod -> prod.getPid().equals(pid)).findAny().get();
		products.remove(product);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Product removed successfully having pid: " + pid;
	}

	public String updateProduct(Product product) {
		System.out.println("ProductDao.updateProduct()");
		Product storedProduct = products.stream().filter(prod -> prod.getPid().equals(product.getPid())).findAny().get();
		products.remove(storedProduct);
		storedProduct.setPname(product.getPname());
		storedProduct.setPrice(product.getPrice());
		products.add(storedProduct);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Product updated successfuly";
	}

}
