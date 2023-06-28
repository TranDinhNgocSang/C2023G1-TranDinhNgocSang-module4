package com.example.ung_dung_muon_sach.controller;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BookRental;
import com.example.ung_dung_muon_sach.service.IBookRentalService;
import com.example.ung_dung_muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/book-rental")
public class BookRentalController {
    @Autowired
    private IBookRentalService bookRentalService;

    @Autowired
    private IBookService bookService;

    @GetMapping("/add/{id}")
    String addBookRental(@PathVariable("id") long id, Model model) {
        Book book = bookService.getBookById(id);
        if (book.getQuantity() < 0) {
            model.addAttribute("msg", "hết sách rồi :(((");
            return "/fail";
        }
        String codeBookRental = bookRentalService.addBookRentalAndUpdateBook(book);
        model.addAttribute("msg", codeBookRental);
        return "/success";
    }

    @GetMapping("/return")
    String showReturn() {
        return "/return-form";
    }

    @PostMapping("/return")
    String returnBook(@RequestParam("code") String code, Model model) {
        BookRental bookRental = bookRentalService.returnBook(code);
        if (bookRental != null) {
            model.addAttribute("bookRental",bookRental);
            return "/detail";
        }
        model.addAttribute("msg", "mã không đúng");
        return "/fail";
    }

}
