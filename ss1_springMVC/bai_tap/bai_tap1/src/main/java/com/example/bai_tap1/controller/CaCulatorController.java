package com.example.bai_tap1.controller;

import com.example.bai_tap1.service.impl.CaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaCulatorController {
    @Autowired
    CaculatorService caculatorService;
    @GetMapping("")
    public String index() {
        return "index";
    }

    @PostMapping("/changeMoney")
    public String doiTien(@RequestParam("USD") double usd, Model model) {
        model.addAttribute("kq",caculatorService.changeMoney(usd)+" VND");
        return "index";
    }
}
