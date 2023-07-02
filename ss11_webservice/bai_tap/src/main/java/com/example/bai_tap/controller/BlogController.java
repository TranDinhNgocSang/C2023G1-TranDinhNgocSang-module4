package com.example.bai_tap.controller;

import com.example.bai_tap.model.Blog;
import com.example.bai_tap.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getlistBlog() {
        return new ResponseEntity<>(blogService.getListBlog(),HttpStatus.OK);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addBlog(@RequestBody Blog blog) {
        if (blogService.getBlogByID(blog.getIdBlog()) != null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blog.setDateSubmit(LocalDate.now());
            blogService.addNewBlog(blog);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<List<Blog>> editBlog(@PathVariable int id ,@RequestBody Blog blog) {
        if (blogService.getBlogByID(blog.getIdBlog()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blog.setIdBlog(id);
            blogService.updateBlog(blog);
            List<Blog> list = blogService.getListBlog();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<Blog>> deleteBlog(@PathVariable int id){
        if (blogService.getBlogByID(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Blog blog = blogService.getBlogByID(id);
            blog.setDelete(true);
            blogService.updateBlog(blog);
            List<Blog> list = blogService.getListBlog();
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> view (@PathVariable int id){
        Blog blog =  blogService.getBlogByID(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blog,HttpStatus.OK);
        }
    }

    @PostMapping("{id}")
    public ResponseEntity<List<Blog>> getListBlogByIdType(@PathVariable int id){
        return new ResponseEntity<>(blogService.findBlogByIdType(id),HttpStatus.OK);
    }
}
