package com.neil.demo.controller;

import com.neil.demo.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @RequestMapping("/author")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());

        return "author/index";
    }
}
