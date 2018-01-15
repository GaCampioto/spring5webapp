package br.com.gabriel.springframework.spring5webapp.controller;


import br.com.gabriel.springframework.spring5webapp.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    AuthorRepository authorRepository;

    @RequestMapping("/authors")
    public String listAuthors(Model model) {

        model.addAttribute("authors", authorRepository.findAll());

        return "authors";
    }
}
