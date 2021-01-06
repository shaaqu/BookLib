package com.example.demo.repositories;

import com.example.demo.entities.Book;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

@EnableJpaRepositories
public interface BookRepository extends CrudRepository<Book, String>, PagingAndSortingRepository<Book, String> {
    Book save(Book book);
}
