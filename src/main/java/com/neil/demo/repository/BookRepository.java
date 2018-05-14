package com.neil.demo.repository;

import com.neil.demo.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book , Long> {

    List<Book> findByTitleContaining(String keyword);
}
