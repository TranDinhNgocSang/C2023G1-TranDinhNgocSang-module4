package com.example.ung_dung_muon_sach.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class BookRental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idBookRental;
    @Column(columnDefinition = "LONGTEXT")
    private String codeBookRental;
    private LocalDate borrowDay;
    private LocalDate returnDate;
    private boolean isDelete;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Book book;

    public BookRental() {
    }

    public BookRental(long idBookRental, String codeBookRental, LocalDate borrowDay, LocalDate returnDate, boolean isDelete, Book book) {
        this.idBookRental = idBookRental;
        this.codeBookRental = codeBookRental;
        this.borrowDay = borrowDay;
        this.returnDate = returnDate;
        this.isDelete = isDelete;
        this.book = book;
    }

    public long getIdBookRental() {
        return idBookRental;
    }

    public void setIdBookRental(long idBookRental) {
        this.idBookRental = idBookRental;
    }

    public String getCodeBookRental() {
        return codeBookRental;
    }

    public void setCodeBookRental(String codeBookRental) {
        this.codeBookRental = codeBookRental;
    }

    public LocalDate getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(LocalDate borrowDay) {
        this.borrowDay = borrowDay;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
