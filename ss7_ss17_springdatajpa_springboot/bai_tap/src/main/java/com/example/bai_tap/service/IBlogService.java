package com.example.bai_tap.service;

import com.example.bai_tap.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getListBlog();

    void addNewBlog (Blog blog);

    void deleteBlog (int id);

    Blog getBlogByID(int id);

    void updateBlog (Blog blog);
}
