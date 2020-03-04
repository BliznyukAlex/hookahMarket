package com.ma.hookahMarket.controllers;

import com.ma.hookahMarket.entity.Product;
import com.ma.hookahMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    ProductService productService;

    private static Log logger = LogFactory.getLog(MainController.class);

    @GetMapping("/")
    public String test() {
        return "hello";
    }

//    @DeleteMapping("/delete")
//    public boolean deleteProduct(@RequestParam long productId){
//        return productService.delete(productId);
//    }

    @GetMapping("/admin")
    public String admin() {
        return "index";
    }

    @RequestMapping("/products")
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
    public String addProduct(@RequestParam Long productId, @RequestParam String productName, @RequestParam Double productPrice,
                            @RequestParam("productImagePath") MultipartFile file, RedirectAttributes redirectAttributes) {
//        if (file.isEmpty()) {
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:fileUploadView";
//        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        productService.add(new Product(productId, productName, productPrice,file.getOriginalFilename()));
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
    public String updateProduct(@RequestParam Long productId, @RequestParam String productName, @RequestParam Double productPrice, @RequestParam String productImagePath) {
        productService.add(new Product(productId, productName, productPrice, productImagePath));
        return "redirect:/products";
    }
//    @GetMapping("/upload")
//    public String upload(){
//        return "upload";
//    }

    private static String UPLOADED_FOLDER = "C:\\Users\\Alexander\\Documents\\hookahMarket\\src\\main\\webapp\\resources\\img\\products\\";
//    @PostMapping("/upload") // //new annotation since 4.3
//    public String singleFileUpload(@RequestParam("file") MultipartFile file,
//                                   RedirectAttributes redirectAttributes) {
//
//        if (file.isEmpty()) {
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:fileUploadView";
//        }
//
//        try {
//
//            // Get the file and save it somewhere
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            Files.write(path, bytes);
//
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:/fileUploadView";
//    }
    @GetMapping("/fileUploadView")
    public String uploadStatus() {
        return "fileUploadView";
    }




}
