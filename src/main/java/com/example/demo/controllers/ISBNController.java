package com.example.demo.controllers;

import com.example.demo.entities.Book;
import com.example.demo.services.ISBNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return isbnService.getBookByISBN(isbnCode);
    }

}
