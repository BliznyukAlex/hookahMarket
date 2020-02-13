package com.ma.hookahMarket.service;

import com.ma.hookahMarket.entity.Product;

import java.util.List;

/**
 * Сервис товаров.
 */
public interface ProductService {
	boolean add(Product product);
	boolean delete(long productId);
	Product getProduct(long productId);
	List<Product> getAllProducts();
}
