package com.example.bai_tap2.controller;

import com.example.bai_tap2.service.impl.TuDienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class TuDienController {
    @Autowired
    TuDienService tuDienService;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @PostMapping("search")
    public String search(@RequestParam("eng") String eng, Model model) {
        model.addAttribute("vn", tuDienService.search(eng));
        return "index";

    }
}
