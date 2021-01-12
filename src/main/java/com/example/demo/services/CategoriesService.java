package com.example.demo.services;

import com.example.demo.entities.Book;

import java.util.List;

public interface CategoriesService {

    List<Book> getByCategory(String category);

}
