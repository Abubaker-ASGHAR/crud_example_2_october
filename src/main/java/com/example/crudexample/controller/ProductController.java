package com.example.crudexample.controller;

import com.example.crudexample.model.Product;
import com.example.crudexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping({"/", "/products"})
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product/list"; // Ensure this view exists
    }


    @GetMapping("/products/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/form"; // Ensure this view exists
    }

    @PostMapping("/products")
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }


    @GetMapping("/products/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Product> product = productService.getProductById(id);
        model.addAttribute("product", product.orElse(new Product()));
        return "product/form"; // Ensure this view exists
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
