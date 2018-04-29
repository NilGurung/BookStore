package com.neil.demo.bootstrap;

import com.neil.demo.model.Author;
import com.neil.demo.model.Book;
import com.neil.demo.repositories.AuthorRepository;
import com.neil.demo.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository  bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData() {
        Author neil = new Author("Neil" , "Gurung");
        Book a = new Book("Domain Driven Design", "1234", "Harper Collins");

        neil.getBooks().add(a);
        authorRepository.save(neil);
        bookRepository.save(a);


        Author kris = new Author("Kris" , "Gurung");
        Book b = new Book("Earth Design", "1234", "Berlin");

        kris.getBooks().add(a);
        authorRepository.save(kris);
        bookRepository.save(a);


    }
}
