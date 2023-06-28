package com.example.ung_dung_muon_sach.controller;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    String showListBook(Model model){
        model.addAttribute("books",bookService.getListBook());
        return "list";
    }

    @GetMapping("/view/{id}")
    String showView (@PathVariable("id") long id, Model model){
        model.addAttribute("book",bookService.getBookById(id));
        return "view";
    }

    @GetMapping("/add")
    String showAddForm (Model model){
        model.addAttribute("book", new Book());
        return "add";
    }

    @PostMapping("/add")
    String addBook(@ModelAttribute Book book){
        bookService.updateBook(book);
        return "redirect:/book";
    }
}
