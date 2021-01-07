package com.example.demo.services;

import com.example.demo.entities.Author;

import java.util.List;
import java.util.Map;

public interface AuthorsRankingService {

    Map<String, Double> getRanking();

}
