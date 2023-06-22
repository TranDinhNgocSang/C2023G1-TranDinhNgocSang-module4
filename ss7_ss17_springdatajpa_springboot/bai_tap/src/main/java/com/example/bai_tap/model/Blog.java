package com.example.bai_tap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
public class Blog {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idBlog;
    private String tileBlog;
    private LocalDate dateSubmit;
    private String nameUser;
    private String content;

    public Blog() {
    }

    public Blog(int idBlog, String tileBlog, LocalDate dateSubmit, String nameUser, String content) {
        this.idBlog = idBlog;
        this.tileBlog = tileBlog;
        this.dateSubmit = dateSubmit;
        this.nameUser = nameUser;
        this.content = content;
    }

    public Blog(String tileBlog, LocalDate dateSubmit, String nameUser, String content) {
        this.tileBlog = tileBlog;
        this.dateSubmit = dateSubmit;
        this.nameUser = nameUser;
        this.content = content;
    }

    public Blog(LocalDate dateSubmit) {
        this.dateSubmit = dateSubmit;
    }

    public int getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
    }

    public String getTileBlog() {
        return tileBlog;
    }

    public void setTileBlog(String tileBlog) {
        this.tileBlog = tileBlog;
    }

    public LocalDate getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(LocalDate dateSubmit) {
        this.dateSubmit = dateSubmit;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
