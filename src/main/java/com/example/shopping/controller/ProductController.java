package com.example.shopping.controller;

import com.example.shopping.model.Product;
import com.example.shopping.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String home(Model model, HttpSession session) {
        model.addAttribute("products", productService.findAll());
        @SuppressWarnings("unchecked") var cart = (List<Product>) session.getAttribute("cart");
        var cartItems = 0;
        if (cart != null) {
            cartItems = cart.size();
        }
        model.addAttribute("cartItems", cartItems);
        return "home";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("products", productService.findAll());
        return "admin";
    }

    @GetMapping("/admin/create")
    public String createProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @GetMapping("/admin/edit/{id}")
    public String createEditPage(Model model, @PathVariable Long id) {
        var product = productService.findById(id);
        model.addAttribute("product", product);
        return "create";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteProduct(Model model, @PathVariable Long id) {
        productService.deleteById(id);
        model.addAttribute("products", productService.findAll());
        return "redirect:/admin";
    }

    @PostMapping("/admin/create")
    public String createProduct(@ModelAttribute Product product, BindingResult bindingResult, Model model) {
        productService.save(product);
        model.addAttribute("products", productService.findAll());
        return "redirect:/admin";
    }

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable Long id, HttpSession session) {
        var product = productService.findById(id);
        @SuppressWarnings("unchecked")
        var cart = (List<Product>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.add(product);
        session.setAttribute("cart", cart);
        return "redirect:/";
    }
}
