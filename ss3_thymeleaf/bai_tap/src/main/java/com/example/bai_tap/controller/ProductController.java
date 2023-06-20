package com.example.bai_tap.controller;

import com.example.bai_tap.model.Product;
import com.example.bai_tap.service.IProductService;
import groovyjarjarpicocli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    String showList(Model model) {
        List<Product> list = productService.getListProduct();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/add")
    String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/add")
    String addProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("msg", "successfully add new");
        return "redirect:/";
    }

    @GetMapping("/edit")
    String showEdit(@RequestParam("id") int id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "edit";
    }
}
