package com.example.bai_tap.controller;

import com.example.bai_tap.model.Blog;
import com.example.bai_tap.service.IBlogService;
import com.example.bai_tap.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(size = 2) Pageable pageable) {
        model.addAttribute("list", blogService.getBlogWithPageable(pageable));
        model.addAttribute("listType", blogTypeService.getBlogType());
        return "/blog/list";
    }

    @GetMapping("/add")
    public String showAddBlogForm(Model model) {
        model.addAttribute("listType", blogTypeService.getBlogType());
        model.addAttribute("blog", new Blog());
        return "/blog/add";
    }

    @PostMapping("/add")
    public String addBlog(@ModelAttribute Blog blog) {
        if (blogService.getBlogByID(blog.getIdBlog()) != null) {
            return "/blog/error";
        } else {
            blog.setDateSubmit(LocalDate.now());
            blogService.addNewBlog(blog);
            return "redirect:/blog/blog";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id) {
        if (blogService.getBlogByID(id) == null) {
            return "/blog/error";
        }
        blogService.deleteBlog(id);
        return "redirect:/blog/blog";
    }

    @GetMapping("/edit/{id}")
    public String showEditBlogForm(@PathVariable int id, Model model) {
        if (blogService.getBlogByID(id) == null) {
            return "/blog/error";
        } else {
            Blog blog = blogService.getBlogByID(id);
            model.addAttribute("listType", blogTypeService.getBlogType());
            model.addAttribute("blog", blog);
            return "/blog/edit";
        }
    }

    @PostMapping("/edit")
    String editBlog(@ModelAttribute Blog blog) {
        if (blogService.getBlogByID(blog.getIdBlog()) == null) {
            return "/blog/error";
        } else {
            blogService.updateBlog(blog);
            return "redirect:/blog/blog";
        }
    }

    @GetMapping("/view/{id}")
    String viewBlog(@PathVariable int id, Model model) {
        if (blogService.getBlogByID(id) == null) {
            return "/blog/error";
        } else {
            model.addAttribute("blog", blogService.getBlogByID(id));
            return "/blog/view";
        }
    }

    @PostMapping("/search")
    String searchBlog(@RequestParam("title") String title, @RequestParam(value = "type", defaultValue = "", required = false) String type, Model model,
                      @PageableDefault(size = 10) Pageable pageable) {
        model.addAttribute("list", blogService.findByTileBlogContainingAndIdBlogType(title, type, pageable));
        model.addAttribute("listType", blogTypeService.getBlogType());
        model.addAttribute("title", title);
        return "/blog/list";
    }
}
