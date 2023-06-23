package com.example.bai_tap.service;

import com.example.bai_tap.model.BlogType;
import com.example.bai_tap.repository.IBlogTypeRepository;
import com.example.bai_tap.repository.IBogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogTypeService implements  IBlogTypeService{
    @Autowired
    IBlogTypeRepository blogTypeRepository;

    @Override
    public List<BlogType> getBlogType() {
       return blogTypeRepository.findAll();
    }
}
