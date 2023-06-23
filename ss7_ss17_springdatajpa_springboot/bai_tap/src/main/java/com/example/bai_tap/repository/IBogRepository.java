package com.example.bai_tap.repository;

import com.example.bai_tap.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IBogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByIsDeleteFalse(Pageable pageable);
}
