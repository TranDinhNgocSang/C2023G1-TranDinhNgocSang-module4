package com.example.bai_tap.controller;

import com.example.bai_tap.model.Blog;
import com.example.bai_tap.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showList (Model model){
        model.addAttribute("list",blogService.getListBlog());
        return "list";
    }

    @GetMapping("/add")
    public String showAddBlogForm(Model model){
        model.addAttribute("blog", new Blog());
        return "add";
    }

    @PostMapping("/add")
    public String addBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blog.setDateSubmit(LocalDate.now());
       blogService.addNewBlog(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id){
        if (blogService.getBlogByID(id)==null){
            return "error";
        }
        blogService.deleteBlog(id);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showEditBlogForm(@PathVariable int id, Model model){
        if (blogService.getBlogByID(id)==null){
            return "error";
        }else {
            Blog blog = blogService.getBlogByID(id);
            model.addAttribute("blog", blog);
            return "edit";
        }
    }

    @PostMapping("/edit")
    String editBlog(@ModelAttribute Blog blog) {
        blogService.updateBlog(blog);
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    String viewBlog (@PathVariable int id , Model model){
        if (blogService.getBlogByID(id)==null){
            return "error";
        }else {
            model.addAttribute("blog", blogService.getBlogByID(id));
            return "view";
        }
    }



}
