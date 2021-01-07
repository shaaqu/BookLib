package com.example.demo.services;

import com.example.demo.BookItemDeserializer;
import com.example.demo.entities.Book;
import com.example.demo.repositories.BookRepository;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookJsonModule {

    BookRepository bookRepository;

    @Autowired
    public BookJsonModule(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createDataBase() {
        BookItemDeserializer bookItemDeserializer = new BookItemDeserializer("books.json");
        List<Book> books = bookItemDeserializer.deserializeDB();
        books.forEach(v -> {
            v.getAccessInfo().setBook(v);
            v.getSaleInfo().setBook(v);
            v.getVolumeInfo().setBook(v);
            v.getSearchInfo().setBook(v);
            bookRepository.save(v);
        });
    }
}
