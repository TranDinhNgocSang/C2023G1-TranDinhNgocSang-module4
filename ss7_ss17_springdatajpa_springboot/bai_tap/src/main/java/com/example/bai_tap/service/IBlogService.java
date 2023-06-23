package com.example.bai_tap.service;

import com.example.bai_tap.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> getListBlog(Pageable pageable);

    void addNewBlog (Blog blog);

    void deleteBlog (int id);

    Blog getBlogByID(int id);

    void updateBlog (Blog blog);

    Page<Blog> getBlogWithPageable(Pageable pageable);
}
