package com.example.bai_tap.model;

import javax.persistence.*;

@Entity
public class BlogType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idBlogType;
    @Column(nullable = false)
    private String nameBlogType;

    public boolean isDelete;

    public BlogType() {
    }

    public BlogType(int idBlogType, String nameBlogType) {
        this.idBlogType = idBlogType;
        this.nameBlogType = nameBlogType;
    }

    public BlogType(int idBlogType, String nameBlogType, boolean isDelete) {
        this.idBlogType = idBlogType;
        this.nameBlogType = nameBlogType;
        this.isDelete = isDelete;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getIdBlogType() {
        return idBlogType;
    }

    public void setIdBlogType(int idBlogType) {
        this.idBlogType = idBlogType;
    }

    public String getNameBlogType() {
        return nameBlogType;
    }

    public void setNameBlogType(String nameBlogType) {
        this.nameBlogType = nameBlogType;
    }
}
