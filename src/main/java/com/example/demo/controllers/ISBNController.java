package com.example.demo.controllers;

import com.example.demo.entities.Book;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ISBNController {


    @RequestMapping(value = "/isbn/{isbnCode}", method = RequestMethod.GET)
    public Book getBookByISBN(@PathVariable String isbnCode) {

    }

}
