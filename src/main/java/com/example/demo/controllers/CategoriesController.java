package com.example.demo.controllers;

import com.example.demo.entities.Book;
import com.example.demo.services.AuthorsRankingService;
import com.example.demo.services.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CategoriesController {

    Categories categories;

    @Autowired
    public CategoriesController(Categories categories) {
        this.categories = categories;
    }


    @RequestMapping(value = "/categories/{category}", method = RequestMethod.GET)
    public List<Book> getBookByCategory(@PathVariable String category) {
        return categories.getByCategory(category);
    }

}
