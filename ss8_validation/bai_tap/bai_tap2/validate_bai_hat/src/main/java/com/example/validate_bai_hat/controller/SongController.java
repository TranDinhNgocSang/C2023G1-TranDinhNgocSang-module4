package com.example.validate_bai_hat.controller;

import com.example.validate_bai_hat.dto.SongDto;
import com.example.validate_bai_hat.model.Song;
import com.example.validate_bai_hat.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping("")
    public String showListSong(Model model) {
        model.addAttribute("list", songService.findByisDeleteIsFalse());
        return "list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "add";
    }

    @PostMapping("/add")
    public String addSong(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult, Model model,
                          RedirectAttributes redirectAttributes) {
        if (songService.getSongByid(songDto.getIdSong()) != null) {
            return "error";
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("songDto", songDto);
            return "add";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.updateSong(song);
            redirectAttributes.addFlashAttribute("msg", "successfully added new");
            return "redirect:/song";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable("id") int id) {
        if (songService.getSongByid(id) == null||songService.getSongByid(id).isDelete()==true) {
            return "error";
        }
        songService.deleteSong(id);
        return "redirect:/song";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        if (songService.getSongByid(id) == null||songService.getSongByid(id).isDelete()==true) {
            return "error";
        }
        Song song = songService.getSongByid(id);
        model.addAttribute("song", song);
        return "edit";
    }

    @PostMapping("/edit")
    public String editSong(@Valid @ModelAttribute SongDto song, BindingResult bindingResult, Model model,
                           RedirectAttributes redirectAttributes) {
        if (songService.getSongByid(song.getIdSong()) == null||songService.getSongByid(song.getIdSong()).isDelete()==true) {
            return "error";
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("song", song);
            return "edit";
        } else {
            Song song1 = new Song();
            BeanUtils.copyProperties(song, song1);
            songService.updateSong(song1);
            redirectAttributes.addFlashAttribute("msg", "successfully edit");
            return "redirect:/song";
        }
    }

}
