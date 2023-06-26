package com.example.validate_bai_hat.service;

import com.example.validate_bai_hat.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findByisDeleteIsFalse();

    void updateSong(Song song);

    Song getSongByid(int id);

    void  deleteSong(int id);
}
