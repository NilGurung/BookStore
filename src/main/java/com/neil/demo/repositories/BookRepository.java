package com.neil.demo.repositories;

import com.neil.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book , Long> {
}
