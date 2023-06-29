package com.example.giohang.controller;

import com.example.giohang.model.Cart;
import com.example.giohang.model.Product;
import com.example.giohang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shopping")
public class ShoppingCartController {

    @Autowired
    private IProductService productService;


    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    String deleteItem (@SessionAttribute("cart") Cart cart, @PathVariable("id") long id, Model model){
        Product product = productService.findById(id);
        cart.deleteProduct(product);
        model.addAttribute("cart",cart);
        return "cart";
    }
}