package br.com.gabriel.springframework.spring5webapp.controller;

import br.com.gabriel.springframework.spring5webapp.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String listBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }
}
