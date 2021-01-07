package com.example.demo.repositories;

import com.example.demo.entities.Author;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

@EnableJpaRepositories
public interface AuthorRepository extends CrudRepository<Author, String>, PagingAndSortingRepository<Author, String> {

    Author save(Author author);

    List<Author> findAll();
}
