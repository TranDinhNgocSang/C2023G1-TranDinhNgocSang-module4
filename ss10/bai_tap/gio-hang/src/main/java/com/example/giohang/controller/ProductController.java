package com.example.giohang.controller;

import com.example.giohang.model.Cart;
import com.example.giohang.model.Product;
import com.example.giohang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }


//    Nếu ở controller khai báo session thì có thể lấy session bằng @ModelAttribute hoặc @SessionAttributes
//    nhưng qua controller khác thì chỉ lất session qua @SessionAttributes => dùng @SessionAttributes cho mọi trường hợp


//    @GetMapping("/add/{id}/{action}")
//    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @PathVariable("action") String action) {
//        Product productOptional = productService.findById(id);
//        if (productOptional==null) {
//            return "/error.404";
//        }
//        if (action.equals("show")) {
//            cart.addProductt(productOptional);
//            return "redirect:/shopping/shopping-cart";
//        }
//        if (action.equals("low")){
//            cart.subProductt(productOptional);
//            return "redirect:/shopping/shopping-cart";
//        }
//        cart.addProductt(productOptional);
//        return "redirect:/product";
//    }

    @GetMapping("/view")
    String showView (@RequestParam("id") long id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "view";
    }

}