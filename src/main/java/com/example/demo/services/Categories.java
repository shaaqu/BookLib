package com.example.demo.services;

import com.example.demo.entities.Book;

import java.util.List;

public interface Categories {

    List<Book> getByCategory(String category);

}
