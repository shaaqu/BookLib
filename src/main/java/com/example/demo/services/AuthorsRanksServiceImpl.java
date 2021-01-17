package com.example.demo.services;

import com.example.demo.entities.Author;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.VolumeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        HashMap<String, Double> ranking = new HashMap<>();
        authorRepository.findAll().forEach(author -> {
            ranking.put(author.getName(), 0.0);
        });

        volumeInfoRepository.findAll().forEach( b -> {
            if (b.getRatingCount() == null)
            b.getAuthors().forEach(author -> {
                String authorsName = author.getName();
                double r = ranking.get(authorsName);
                double rank = ranking.get(authorsName) + (b.getAverageRating() / b.getRatingCount());
                if (r != 0.0) {
                    rank /= 2 ;
                }
                ranking.put(author.getName(), rank);
            });
        });

        return  ranking;
    }

}
