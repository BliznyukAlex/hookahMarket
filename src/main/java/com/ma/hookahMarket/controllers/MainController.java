package com.ma.hookahMarket.controllers;

import com.ma.hookahMarket.entity.Product;
import com.ma.hookahMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    ProductService productService;

    private static Log log = LogFactory.getLog(MainController.class);
    @GetMapping("/")
    public String test() {
        return "hello";
    }

//    @PostMapping("/add")
//    public boolean addProduct(@RequestBody Product product){
//        return productService.add(product);
//    }
//
//    @DeleteMapping("/delete")
//    public boolean deleteProduct(@RequestParam long productId){
//        return productService.delete(productId);
//    }
//
//    @GetMapping("/getAll")
//    public List<Product> getAllProducts(){
//        return productService.getAllProducts();

    @GetMapping("/admin")
    public String admin(){
        return "index";
    }
    @RequestMapping("/products")
    public String products(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products",products);
        return "products";
    }

    @GetMapping("/add")
    public String addProduct(){
        return "add";
    }
    @PostMapping("/add")
    public String addProduct(@RequestParam Long productId, @RequestParam String productName, @RequestParam Double productPrice){

        log.info(productId+ productName+ productPrice);
        productService.add(new Product(productId,productName,productPrice));
//        System.out.println(productId+productName+productPrice);
        return "redirect:/products";

    }
}
