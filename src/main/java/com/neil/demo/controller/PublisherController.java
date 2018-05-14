package com.neil.demo.controller;

import com.neil.demo.repository.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController {

    private PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @RequestMapping("/publisher")
    public String getPublisher(Model model) {
        model.addAttribute("publishers", publisherRepository.findAll());
        return "publisher/index";
    }
}
