package com.neil.demo.api;

import com.neil.demo.domain.Book;
import com.neil.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/book")
public class BookApi {

    @Autowired
    private BookService bookService;

    @RequestMapping(value="/add" , method=RequestMethod.POST)
    public Book addBookPost(@RequestBody Book book) {
        return bookService.save(book);
    }
}
