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
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, RedirectAttributes redirectAttributes) {
        String str = "";
        if (condiment == null) {
            redirectAttributes.addFlashAttribute("condiment", "no condiment");
        } else {
            for (String s : condiment) {
                str += s + "<br>";
            }
            redirectAttributes.addFlashAttribute("condiment", str);
        }
        return "redirect:/";
    }

}
