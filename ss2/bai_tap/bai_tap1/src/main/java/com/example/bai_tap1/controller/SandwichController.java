package com.example.bai_tap1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SandwichController {
    @GetMapping("")
    public String index(){
        return "index";
    }

}
