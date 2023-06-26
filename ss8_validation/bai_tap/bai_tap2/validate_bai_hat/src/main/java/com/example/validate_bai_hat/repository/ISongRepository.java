package com.example.validate_bai_hat.repository;

import com.example.validate_bai_hat.model.Song;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISongRepository extends JpaRepository<Song,Integer> {
    List<Song> findByisDeleteIsFalse();

}
