package com.example.bai_tap.repository;

import com.example.bai_tap.model.BlogType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogTypeRepository extends JpaRepository<BlogType, Integer> {
    List<BlogType> findByisDeleteIsFalse();
}
