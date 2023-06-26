package com.example.validate_bai_hat.service.imp;

import com.example.validate_bai_hat.model.Song;
import com.example.validate_bai_hat.repository.ISongRepository;
import com.example.validate_bai_hat.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository songRepository;


    @Override
    public List<Song> findByisDeleteIsFalse() {
        return songRepository.findByisDeleteIsFalse();
    }

    @Override
    public void updateSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song getSongByid(int id) {
        return songRepository.findById(id).orElse(null);
    }
    @Override
    public void  deleteSong(int id){
        Song song = getSongByid(id);
        song.setDelete(true);
        songRepository.save(song);
    }
}
