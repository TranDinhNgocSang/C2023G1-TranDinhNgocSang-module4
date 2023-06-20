package com.example.bai_tap2.controller;

import com.example.bai_tap2.service.imp.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam("firtsNum") double firtsNum, @RequestParam("secondNum") double secondNum,
                             @RequestParam String calculator, RedirectAttributes redirectAttributes) {
        String result = calculatorService.calculator(firtsNum, secondNum, calculator);
        redirectAttributes.addFlashAttribute("result", result);
        redirectAttributes.addFlashAttribute("firtsNum", firtsNum);
        redirectAttributes.addFlashAttribute("secondNum", secondNum);
        return "redirect:/";
    }

}
