package com.ma.hookahMarket.controllers;

import com.ma.hookahMarket.entity.Product;
import com.ma.hookahMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String test() {
        return "hello";
    }

    @PostMapping("/add")
    public boolean addProduct(@RequestBody Product product){
        return productService.add(product);
    }

    @DeleteMapping("/delete")
    public boolean deleteProduct(@RequestParam long productId){
        return productService.delete(productId);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
