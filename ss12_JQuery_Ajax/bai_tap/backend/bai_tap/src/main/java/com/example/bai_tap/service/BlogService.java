package com.example.bai_tap.service;

import com.example.bai_tap.model.Blog;
import com.example.bai_tap.repository.IBogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBogRepository blogRepository;

    @Override
    public List<Blog> getListBlog(Pageable pageable) {
        return blogRepository.findAll();
    }

    @Override
    public void addNewBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(int id) {
        Blog blog = getBlogByID(id);
        blog.setDelete(true);
        blogRepository.save(blog);
    }

    @Override
    public Blog getBlogByID(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> getListBlog() {
        return blogRepository.findByisDeleteIsFalse();
    }

    @Override
    public List<Blog> findBlogByIdType(int id) {
        return blogRepository.findByBlogType_idBlogType(id);
    }

    @Override
    public Page<Blog> findByTileBlogContainingAndIdBlogType(String title, String idBlogType, Pageable pageable) {
        return blogRepository.findByTileBlogContainingAndIdBlogType(title, idBlogType, pageable);
    }

    @Override
    public List<Blog> searchBlog(String title) {
        return blogRepository.searchBlogByTileBlogContainingIgnoreCase(title);
    }

    @Override
    public List<Blog> getListBlogLimit(int num) {
        return blogRepository.getBlogLimit(num);
    }


}
