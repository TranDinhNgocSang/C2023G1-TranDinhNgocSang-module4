package com.example.ung_dung_muon_sach.service.impl;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.repository.IBookrepository;
import com.example.ung_dung_muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookrepository bookrepository;

    @Override
    public List<Book> getListBook() {
        return bookrepository.findByisDeleteIsFalse();
    }

    @Override
    public Book getBookById(long id) {
        return bookrepository.findById(id).orElse(null);
    }

    @Override
    public void updateBook(Book book) {
        bookrepository.save(book);
    }


}
