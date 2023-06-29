package com.example.giohang.controller;

import com.example.giohang.model.Cart;
import com.example.giohang.model.Product;
import com.example.giohang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shopping")
public class ShoppingCartController {

    @Autowired
    private IProductService productService;


    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    String deleteItem(@SessionAttribute("cart") Cart cart, @PathVariable("id") long id, Model model) {
        Product product = productService.findById(id);
        cart.deleteProduct(product);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/add/{id}/{action}")
    public String addToCart(@PathVariable Long id, @SessionAttribute Cart cart, @PathVariable("action") String action) {
        Product productOptional = productService.findById(id);
        if (productOptional == null) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProductt(productOptional);
            return "redirect:/shopping/shopping-cart";
        }
        if (action.equals("low")) {
            cart.subProductt(productOptional);
            return "redirect:/shopping/shopping-cart";
        }
        cart.addProductt(productOptional);
        return "redirect:/product";
    }

    @GetMapping("/end-cart")
    String endCart(HttpSession session) {
        session.invalidate();
        return "redirect:/product";
    }
}