package com.neil.demo.bootstrap;

import com.neil.demo.model.Author;
import com.neil.demo.model.Book;
import com.neil.demo.model.Publisher;
import com.neil.demo.repositories.AuthorRepository;
import com.neil.demo.repositories.BookRepository;
import com.neil.demo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository  bookRepository;
    private PublisherRepository publisherRepository;



    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }




    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData() {
        Author neil = new Author("Neil" , "Gurung");
        Publisher publisher1 = new Publisher("Rame", "Ktm");
        Book a = new Book("Domain Driven Design", "1234", publisher1);


        neil.getBooks().add(a);

        authorRepository.save(neil);
        publisherRepository.save(publisher1);
        bookRepository.save(a);



        Author kris = new Author("Kris" , "Gurung");
        Publisher publisher2 = new Publisher("Shyame", "Mel");
        Book b = new Book("Earth Design", "1234", publisher2);


        kris.getBooks().add(b);
        authorRepository.save(kris);
        publisherRepository.save(publisher2);
        bookRepository.save(b);


    }
}
