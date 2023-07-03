package com.example.bai_tap.service;

import com.example.bai_tap.model.BlogType;


import java.util.List;

public interface IBlogTypeService {
    List<BlogType> getBlogType();

    void UpdateBlogType(BlogType blogType);

    BlogType getBlogTypeById(int id);

    void deleteBlogType(int id);
}
