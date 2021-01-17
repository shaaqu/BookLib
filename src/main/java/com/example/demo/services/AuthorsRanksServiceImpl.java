package com.example.demo.services;

import com.example.demo.Rating;
import com.example.demo.entities.Author;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.VolumeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorsRanksServiceImpl implements AuthorsRankingService{

    AuthorRepository authorRepository;
    VolumeInfoRepository volumeInfoRepository;

    @Autowired
    public AuthorsRanksServiceImpl(AuthorRepository authorRepository, VolumeInfoRepository volumeInfoRepository) {
        this.authorRepository = authorRepository;
        this.volumeInfoRepository = volumeInfoRepository;
    }

    @Override
    public Map<String, Double> getRanking() {
        HashMap<String, Rating> ranking = new HashMap<>();
        authorRepository.findAll().forEach(author -> {
            ranking.put(author.getName(), new Rating(author));
        });


        volumeInfoRepository.findAll().forEach( b -> {
            b.getAuthors().forEach(author -> {
                String authorsName = author.getName();
                ranking.get(authorsName).addRating(b.getRatingCount(), b.getAverageRating());
            });
        });

        HashMap<String, Double> rankingReturn = new HashMap<>();



        rankingReturn = sortRanking(ranking);
        return rankingReturn;
    }

    public HashMap<String, Double> sortRanking(HashMap<String, Rating> ranking) {


    }

}
