package com.example.validate_bai_hat.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    private int idSong;
    @NotBlank(message = "")
    @Pattern(regexp = "^[^@;,.\\-=+!#$%&<>]{1,800}$",message = "không đúng định dạng")
    private String nameSong;
    @NotBlank(message = "")
    @Pattern(regexp = "^[^@;,.\\-=+!#$%&<>]{1,300}$",message = "không đúng định dạng")
    private String singer;
    @NotBlank(message = "")
    @Pattern(regexp = "^[^@;.\\-=+!#$%&<>]{1,1000}$",message = "không đúng định dạng")
    private String kindMusic;
    private boolean isDelete;

    public SongDto() {
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
