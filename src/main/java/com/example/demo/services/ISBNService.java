package com.example.demo.services;

import com.example.demo.entities.Book;

public interface ISBNService {

    Book getBookByISBN(String isbn);

}
