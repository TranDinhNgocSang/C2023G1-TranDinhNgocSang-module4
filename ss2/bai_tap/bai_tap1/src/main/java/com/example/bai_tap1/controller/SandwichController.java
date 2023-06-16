package com.example.bai_tap1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SandwichController {
    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/save")
    public String save(@RequestParam String[] condiment, RedirectAttributes redirectAttributes) {
        String str = "";
        for (String s : condiment) {
            str += s + "<br>";
        }
        redirectAttributes.addFlashAttribute("condiment", str);
        return "redirect:/";
    }

}
