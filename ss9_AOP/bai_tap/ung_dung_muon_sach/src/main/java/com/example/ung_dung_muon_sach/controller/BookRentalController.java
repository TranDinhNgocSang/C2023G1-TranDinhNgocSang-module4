package com.example.ung_dung_muon_sach.controller;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BookRental;
import com.example.ung_dung_muon_sach.service.IBookRentalService;
import com.example.ung_dung_muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
        book.setQuantity(book.getQuantity() - 1);
        if (book.getQuantity() <= 0) {
            model.addAttribute("msg", "hết sách rồi :(((");
            return "/fail";
        }
        String codeBookRental = "";
        boolean flag;
        do {
            flag = false;
            int num1 = (int) (Math.random() * 100000);
            codeBookRental += num1;
            List<BookRental> list = bookRentalService.getListBookRental();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCodeBookRental().equals(codeBookRental)) {
                    flag = true;
                }
            }
        } while (flag);
        BookRental bookRental = new BookRental();
        bookRental.setCodeBookRental(codeBookRental);
        bookRental.setBorrowDay(LocalDate.now());
        bookRental.setBook(book);
        bookRentalService.addBookRental(bookRental);
        model.addAttribute("msg", codeBookRental);
        bookService.updateBook(book);
        return "/success";
    }

    @GetMapping("/return")
    String showReturn() {
        return "/return-form";
    }

    @PostMapping("/return")
    String returnBook(@RequestParam("code") String code, Model model) {
        List<BookRental> list = bookRentalService.getListBookRental();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCodeBookRental().equals(code)) {
                BookRental bookRental = list.get(i);
                bookRental.setDelete(true);
                Book book = bookService.getBookById(list.get(i).getBook().getIdBook());
                book.setQuantity(book.getQuantity()+1);
                bookRental.setReturnDate(LocalDate.now());
                bookRentalService.updateBookRental(bookRental);
                model.addAttribute("bookRental",bookRental);
                return "/detail";
            }
        }
        model.addAttribute("msg","mã không đúng");
        return "/fail";
    }

}
