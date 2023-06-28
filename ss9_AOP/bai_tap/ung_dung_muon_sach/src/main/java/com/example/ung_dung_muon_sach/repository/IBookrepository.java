package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookrepository extends JpaRepository<Book,Long> {
    List<Book> findByisDeleteIsFalse();
}
