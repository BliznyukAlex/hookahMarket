package com.ma.hookahMarket.service.impl;

import com.ma.hookahMarket.entity.Product;
import com.ma.hookahMarket.repository.ProductRepo;
import com.ma.hookahMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public boolean add(Product product) {
        if (productRepo.existsById(product.getId())) return false;
        productRepo.save(product);
        return true;
    }

    @Override
    public boolean delete(long productId) {
        if (productRepo.existsById(productId)) {
            productRepo.deleteById(productId);
            return true;
        }
        return false;
    }

    @Override
    public Product getProduct(long productId) {
        return productRepo.findById(productId).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

}
