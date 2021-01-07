package com.example.demo.controllers;

import com.example.demo.entities.Book;
import com.example.demo.services.AuthorsRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthorsRankingController {

    AuthorsRankingService authorsRankingService;

    @Autowired
    public AuthorsRankingController(AuthorsRankingService authorsRankingService) {
        this.authorsRankingService = authorsRankingService;
    }

    @RequestMapping(value = "/ranking", method = RequestMethod.GET)
    public Map<String, Double> getBookByISBN() {
        return authorsRankingService.getRanking();
    }
}
