package com.example.bai_tap.controller;

import com.example.bai_tap.model.BlogType;
import com.example.bai_tap.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog-type")
public class BlogTypeController {
    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping("")
    public String showListBlogType(Model model) {
        model.addAttribute("list", blogTypeService.getBlogType());
        return "blog_type/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("type", new BlogType());
        return "/blog_type/add";
    }

    @PostMapping("/add")
    public String addBlogType(@ModelAttribute BlogType blogType, RedirectAttributes redirectAttributes) {
        if (blogTypeService.getBlogTypeById(blogType.getIdBlogType())!=null){
            return "/blog/error";
        }
        blogTypeService.UpdateBlogType(blogType);
        redirectAttributes.addFlashAttribute("msg", "successfully added new");
        return "redirect:/blog-type";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("id") int id, Model model) {
        if (blogTypeService.getBlogTypeById(id)==null||blogTypeService.getBlogTypeById(id).isDelete()==true){
            return "/blog/error";
        }
        model.addAttribute("type", blogTypeService.getBlogTypeById(id));
        return "/blog_type/edit";
    }

    @PostMapping("/edit")
    public String editBlogType(@ModelAttribute BlogType blogType) {
        if (blogTypeService.getBlogTypeById(blogType.getIdBlogType())==null||blogTypeService.getBlogTypeById(blogType.getIdBlogType()).isDelete()==true){
            return "/blog/error";
        }
        blogTypeService.UpdateBlogType(blogType);
        return "redirect:/blog-type";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlogType(@PathVariable("id") int id) {
        if (blogTypeService.getBlogTypeById(id)==null||blogTypeService.getBlogTypeById(id).isDelete()==true){
            return "/blog/error";
        }
        blogTypeService.deleteBlogType(id);
        return "redirect:/blog-type";
    }

}
