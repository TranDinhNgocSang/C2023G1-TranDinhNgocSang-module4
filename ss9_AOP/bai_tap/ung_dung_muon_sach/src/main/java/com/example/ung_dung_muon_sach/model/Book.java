package com.example.ung_dung_muon_sach.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idBook;
    @Column(columnDefinition = "LONGTEXT")
    private String nameBook;
    @Column(columnDefinition = "LONGTEXT")
    private String describeBook;
    @Column(columnDefinition = "LONGTEXT")
    private String authorBook;
    private long quantity;
    private boolean isDelete;

    public Book() {
    }

    public Book(long idBook, String nameBook, String describeBook, String authorBook, long quantity, boolean isDelete) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.describeBook = describeBook;
        this.authorBook = authorBook;
        this.quantity = quantity;
        this.isDelete = isDelete;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getDescribeBook() {
        return describeBook;
    }

    public void setDescribeBook(String describeBook) {
        this.describeBook = describeBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
