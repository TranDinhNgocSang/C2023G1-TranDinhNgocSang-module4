package com.example.ung_dung_muon_sach.service.impl;

import com.example.ung_dung_muon_sach.model.BookRental;
import com.example.ung_dung_muon_sach.repository.IBookRentalRepository;
import com.example.ung_dung_muon_sach.service.IBookRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookRentalService implements IBookRentalService {
    @Autowired
    private IBookRentalRepository bookRentalRepository;

    @Override
    public List<BookRental> getListBookRental() {
        return bookRentalRepository.findByisDeleteIsFalse();
    }

    @Override
    public void addBookRental(BookRental bookRental) {
        bookRentalRepository.save(bookRental);
    }

    @Override
    public void updateBookRental(BookRental bookRental) {
        bookRentalRepository.save(bookRental);
    }
}