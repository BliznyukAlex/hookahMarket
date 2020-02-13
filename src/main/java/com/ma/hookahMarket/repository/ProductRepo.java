package com.ma.hookahMarket.repository;

import com.ma.hookahMarket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
