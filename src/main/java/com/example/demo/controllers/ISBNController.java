package com.example.demo.controllers;

import com.example.demo.entities.Book;
import com.example.demo.services.ISBNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
public class ISBNController {


    ISBNService isbnService;

    @Autowired
    public ISBNController(ISBNService isbnService) {
        this.isbnService = isbnService;
    }

    @RequestMapping(value = "/isbn/{isbnCode}", method = RequestMethod.GET)
    public Book getBookByISBN(@PathVariable String isbnCode) {

        Book book = isbnService.getBookByISBN(isbnCode);
        if(book != null) {
            return book;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find book with given ISBN");
        }
    }

}
