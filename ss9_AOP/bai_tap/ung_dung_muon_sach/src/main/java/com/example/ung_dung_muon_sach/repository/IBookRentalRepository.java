package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookRentalRepository extends JpaRepository<BookRental,Long> {
    List<BookRental> findByisDeleteIsFalse();
}
