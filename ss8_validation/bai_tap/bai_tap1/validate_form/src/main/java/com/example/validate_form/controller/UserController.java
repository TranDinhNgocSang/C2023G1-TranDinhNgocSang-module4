package com.example.validate_form.controller;

import com.example.validate_form.dto.UserDto;
import com.example.validate_form.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("")
    public String showFormSignUP(Model model){
        model.addAttribute("userDto", new UserDto());
            return "index";
    }
    @PostMapping("/validateUser")
    public String showFormSignUP(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("userDto",new UserDto());
            return "index";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        redirectAttributes.addFlashAttribute("msg", "thanh cong");
        return "result";
    }
}
