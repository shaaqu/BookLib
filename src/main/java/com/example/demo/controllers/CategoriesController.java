package com.example.demo.controllers;

import com.example.demo.entities.Book;
import com.example.demo.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController {

    CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }


    @RequestMapping(value = "/categories/{category}", method = RequestMethod.GET)
    public List<Book> getBookByCategory(@PathVariable String category) {
        return categoriesService.getByCategory(category);
    }

}
