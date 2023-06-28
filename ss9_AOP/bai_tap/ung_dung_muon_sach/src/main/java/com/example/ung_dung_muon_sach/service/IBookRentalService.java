package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.BookRental;

import java.util.List;

public interface IBookRentalService {
    List<BookRental> getListBookRental ();

    void addBookRental (BookRental bookRental);

    void updateBookRental(BookRental bookRental);
}
