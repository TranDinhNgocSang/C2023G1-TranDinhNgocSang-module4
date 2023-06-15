package com.example.bai_tap1.controller;

import com.example.bai_tap1.service.impl.BangTinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BangTinhController {
    @Autowired
    BangTinhService bangTinhService;
    @GetMapping("")
    public String index() {
        return "index";
    }

    @PostMapping("/Tinh")
    public String doiTien(@RequestParam("USD") double usd, Model model) {
        model.addAttribute("kq",bangTinhService.doiTien(usd)+" VND");
        return "index";
    }
}
