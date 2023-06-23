package com.example.bai_tap.repository;

import com.example.bai_tap.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IBogRepository extends JpaRepository<Blog, Integer> {
    //    @Query(value = "select * from blog where is_delete = 0", nativeQuery = true)
    Page<Blog> findByisDeleteIsFalse(Pageable pageable);

    //    Page<Blog> findByTileBlogContaining(String keyWord,Pageable pageable);
    @Query(value = "select * from blog where is_delete = 0 and tile_blog like concat('%',:title,'%') and blog_type_id_blog_type like concat('%',:idBlogType,'%')", nativeQuery = true)
    Page<Blog> findByTileBlogContainingAndIdBlogType(@Param("title") String title, @Param("idBlogType") String idBlogType, Pageable pageable);
}
