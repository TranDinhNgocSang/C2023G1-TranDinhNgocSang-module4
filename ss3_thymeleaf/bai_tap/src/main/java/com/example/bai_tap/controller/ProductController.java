package com.example.bai_tap.controller;

import com.example.bai_tap.model.Product;
import com.example.bai_tap.service.IProductService;
import groovyjarjarpicocli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

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
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    String showEdit(@PathVariable int id, Model model) {
        if (productService.findIndexById(id)==-1){
            return "error";
        }else {
            model.addAttribute("product", productService.getProductById(id));
            return "edit";
        }
    }

    @PostMapping("/edit")
    String editProduct(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    String deleteProduct(@PathVariable int id) {
        if (productService.findIndexById(id)==-1) {
            return "error";
        }else {
            productService.deleteProduct(id);
            return "redirect:/product";
        }
    }

    @GetMapping("/view/{id}")
    String viewProduct(@PathVariable int id, Model model) {
        if (productService.findIndexById(id)==-1) {
            return "error";
        }else {
            model.addAttribute("product", productService.getProductById(id));
            return "view";
        }
    }

    @GetMapping("/search")
    String searchProduct(@RequestParam(value = "search") String search, Model model) {
        model.addAttribute("list", productService.searchProduct(search));
        return "list";
    }
}
