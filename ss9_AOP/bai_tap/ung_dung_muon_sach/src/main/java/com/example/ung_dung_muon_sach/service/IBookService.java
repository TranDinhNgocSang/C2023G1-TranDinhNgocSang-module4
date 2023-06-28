package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getListBook ();

    Book getBookById(long id);

    void updateBook(Book book);
}
