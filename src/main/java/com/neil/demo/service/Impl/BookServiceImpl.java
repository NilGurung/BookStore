package com.neil.demo.service.Impl;

import com.neil.demo.domain.Book;
import com.neil.demo.repository.BookRepository;
import com.neil.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        List<Book> bookList = (List<Book>) bookRepository.findAll();

        List<Book> activeBookList = new ArrayList<>();

        for (Book book: bookList) {
            if(book.isActive()) {
                activeBookList.add(book);
            }
        }
        return activeBookList;
    }


    @Override
    public Book findOne(Long id) {
        return bookRepository.findOne(id);
    }


    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> blurrySearch(String keyword) {
        List<com.neil.demo.domain.Book> bookList = bookRepository.findByTitleContaining(keyword);

        List<Book> activeBookList = new ArrayList<>();

        for (com.neil.demo.domain.Book book: bookList) {
            if(book.isActive()) {
                activeBookList.add(book);
            }
        }
        return activeBookList;
    }

    @Override
    public void removeOne(Long id) {
        bookRepository.delete(id);
    }
}
