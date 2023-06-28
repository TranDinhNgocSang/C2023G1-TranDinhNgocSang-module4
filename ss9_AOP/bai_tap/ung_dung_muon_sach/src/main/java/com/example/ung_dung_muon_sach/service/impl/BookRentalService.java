package com.example.ung_dung_muon_sach.service.impl;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BookRental;
import com.example.ung_dung_muon_sach.repository.IBookRentalRepository;
import com.example.ung_dung_muon_sach.service.IBookRentalService;
import com.example.ung_dung_muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookRentalService implements IBookRentalService {
    @Autowired
    private IBookRentalRepository bookRentalRepository;

    @Autowired
    IBookService bookService;

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

    @Override
    public String addBookRentalAndUpdateBook(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        String codeBookRental;
        boolean flag;
        do {
            flag = false;
            int num1 = (int) (Math.random() * 9);
            int num2 = (int) (Math.random() * 9);
            int num3 = (int) (Math.random() * 9);
            int num4 = (int) (Math.random() * 9);
            int num5 = (int) (Math.random() * 9);
            codeBookRental = String.valueOf(num1) + num2 + num3 + num4 + num5;
            List<BookRental> list = this.getListBookRental();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCodeBookRental().equals(codeBookRental)) {
                    flag = true;
                }
            }
        } while (flag);
        BookRental bookRental = new BookRental();
        bookRental.setCodeBookRental(codeBookRental);
        bookRental.setBorrowDay(LocalDate.now());
        bookRental.setBook(book);
        this.addBookRental(bookRental);
        bookService.updateBook(book);
        return codeBookRental;
    }

    @Override
    public BookRental returnBook(String code) {
        List<BookRental> list = this.getListBookRental();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCodeBookRental().equals(code)) {
                BookRental bookRental = list.get(i);
                bookRental.setDelete(true);
                Book book = bookService.getBookById(list.get(i).getBook().getIdBook());
                book.setQuantity(book.getQuantity() + 1);
                bookRental.setReturnDate(LocalDate.now());
                this.updateBookRental(bookRental);
                return bookRental;
            }
        }
        return null;
    }

}