package com.example.demo.services;

import com.example.demo.Rating;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.VolumeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public LinkedHashMap<String, Double> sortRanking(HashMap<String, Rating> ranking) {
        LinkedHashMap<String, Double> rank = new LinkedHashMap<>();

        List<Rating> rankList = new ArrayList<>(ranking.values());

        Collections.sort(rankList,
                Comparator.comparing(Rating::getRating));

        Collections.reverse(rankList);

        rankList.forEach(rating -> {
            rank.put(rating.getAuthor().getName(), rating.getRating());
        });

        return rank;
    }

}
