package com.example.demo.services;

import com.example.demo.Rating;
import com.example.demo.entities.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AuthorsRanksServiceImplTest {

    AuthorsRanksServiceImpl ranksService;
    Author a1;
    Author a2;
    Author a3;
    Rating r1;
    Rating r2;
    Rating r3;

    @BeforeEach
    void setUp() {
        ranksService = new AuthorsRanksServiceImpl(null, null);
        a1 = Author.builder().name("first").build();
        a2 = Author.builder().name("second").build();
        a3 = Author.builder().name("third").build();

        r1 = new Rating(a1);
        r1.addRating(1, 3.0);
        r2 = new Rating(a2);
        r2.addRating(1, 2.0);
        r3 = new Rating(a3);
        r3.addRating(1, 1.0);
    }

    @Test
    void sortingTest() {
        HashMap<String, Rating> ranking = new HashMap<>();

        ranking.put("third", r3);
        ranking.put("first", r1);
        ranking.put("second", r2);

        HashMap<String, Double> sorted = ranksService.sortRanking(ranking);
        List<Double> actual = new ArrayList<>(sorted.values());

        assertEquals(3.0, actual.get(0));
        assertEquals(2.0, actual.get(1));
        assertEquals(1.0, actual.get(2));
    }
}