package com.example.bai_tap1.controller;

import com.example.bai_tap1.model.Mail;
import com.example.bai_tap1.service.impl.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MailController {
    @Autowired
    private MailService mailService;

    @GetMapping("")
    public String detail(Model model) {
        model.addAttribute("mail", mailService.getMail());
        return "detail";
    }

    @GetMapping("/update-form")
    public String showFormSettings(Model model) {
        model.addAttribute("mail", mailService.getMail());
        model.addAttribute("languages", mailService.getLanguages());
        model.addAttribute("pageSize", mailService.getPageSizes());
        return "setting";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Mail mail) {
        mailService.update(mail);
        return "redirect:/";
    }
}
