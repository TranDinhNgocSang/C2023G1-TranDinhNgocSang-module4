package com.example.validate_bai_hat.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idSong;
    @Column(nullable = false)
    private String nameSong;
    @Column(nullable = false)
    private String singer;
    @Column(nullable = false)
    private String kindMusic;

    public boolean isDelete;

    public Song() {
    }

    public Song(int idSong, String nameSong, String singer, String kindMusic, boolean isDelete) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.singer = singer;
        this.kindMusic = kindMusic;
        this.isDelete = isDelete;
    }

    public int getIdSong() {
        return idSong;
    }

    public void setIdSong(int idSong) {
        this.idSong = idSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindMusic() {
        return kindMusic;
    }

    public void setKindMusic(String kindMusic) {
        this.kindMusic = kindMusic;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
