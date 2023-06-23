package com.example.bai_tap.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Blog {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idBlog;
    @Column(columnDefinition = "LONGTEXT")
    private String tileBlog;
    private LocalDate dateSubmit;
    private String nameUser;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @Column(columnDefinition = "LONGTEXT")
    private String describeBlog;
    private String image;
    private boolean isDelete;
    @ManyToOne
    @JoinColumn(nullable = false)
    private BlogType blogType;

    public Blog() {
    }

    public Blog(int idBlog, String tileBlog, LocalDate dateSubmit, String nameUser, String content, String describeBlog, String image, boolean isDelete, BlogType blogType) {
        this.idBlog = idBlog;
        this.tileBlog = tileBlog;
        this.dateSubmit = dateSubmit;
        this.nameUser = nameUser;
        this.content = content;
        this.describeBlog = describeBlog;
        this.image = image;
        this.isDelete = isDelete;
        this.blogType = blogType;
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

    public String getDescribeBlog() {
        return describeBlog;
    }

    public void setDescribeBlog(String describeBlog) {
        this.describeBlog = describeBlog;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }
}
