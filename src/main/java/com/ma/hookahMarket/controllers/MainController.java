package com.ma.hookahMarket.controllers;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private static Log log = LogFactory.getLog(MainController.class);
    @GetMapping("/")
    public String test() {
        return "hello";
    }

    @GetMapping("/admin")
    public String admin(){
        return "index";
    }
    @GetMapping("/products")
    public String products(){
        return "products";
    }

    @GetMapping("/add")
    public String addProduct(){
        return "add";
    }
    @PostMapping("/add")
    public String addProduct(@RequestParam String productId, @RequestParam String productName, @RequestParam Double productPrice){

        log.info(productId+ productName+ productPrice);
//        System.out.println(productId+productName+productPrice);
        return "redirect:/products";
    }
}
