package com.ma.hookahMarket.controllers;

import com.ma.hookahMarket.entity.Product;
import com.ma.hookahMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/admin")
    public String admin() {
        return "index";
    }

    @GetMapping("/products")
    public String products(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/add")
    public String addProduct(Model Model) {
        Product product = new Product();

        Model.addAttribute("product", product);

        return "add";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam Long productId, @RequestParam String productName, @RequestParam Double productPrice) {
        productService.add(new Product(productId, productName, productPrice));
        return "redirect:/products";
    }

    @GetMapping("/updateProduct")
    public String updateProduct(@RequestParam("productId") long theId,
                                Model Model) {

        // get the customer from our service
        Product product = productService.getProduct(theId);

        // set customer as a model attribute to pre-populate the form
        Model.addAttribute("product", product);

        // send over to our form
        return "add";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@RequestParam Long productId, @RequestParam String productName, @RequestParam Double productPrice) {
        productService.add(new Product(productId, productName, productPrice));
        return "redirect:/products";
    }

    @PostMapping("/products")
//    @RequestMapping(method = RequestMethod.DELETE, value = "/product/{productId}")
    public String deleteProduct(@RequestParam Long productId) {
        productService.delete(productId);
        return "redirect:/products";
    }
}
