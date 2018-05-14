package com.neil.demo.service;


import com.neil.demo.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {
    List<Book> findAll();

    Book findOne(Long id);

    Book save(Book book);

    List<Book> blurrySearch(String title);

    void removeOne(Long id);
}
