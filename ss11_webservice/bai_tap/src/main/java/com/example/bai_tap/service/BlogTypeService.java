package com.example.bai_tap.service;

import com.example.bai_tap.model.BlogType;
import com.example.bai_tap.repository.IBlogTypeRepository;
import com.example.bai_tap.repository.IBogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTypeService implements IBlogTypeService {
    @Autowired
    IBlogTypeRepository blogTypeRepository;

    @Override
    public List<BlogType> getBlogType() {
        return blogTypeRepository.findByisDeleteIsFalse();
    }

    @Override
    public void UpdateBlogType(BlogType blogType) {
        blogTypeRepository.save(blogType);
    }

    @Override
    public BlogType getBlogTypeById(int id) {
        return blogTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBlogType(int id) {
        BlogType blogType = getBlogTypeById(id);
        blogType.setDelete(true);
        blogTypeRepository.save(blogType);
    }


}
