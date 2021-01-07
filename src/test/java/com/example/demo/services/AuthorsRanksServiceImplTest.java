package com.example.demo.services;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AuthorsRanksServiceImplTest {

    @Test
    void sortingTest() {
        Map<String, Double> map= new HashMap<>();
        map.put("trzy", 1.0);
        map.put("dwa", 2.0);
        map.put("jeden", 3.0);

        AuthorsRanksServiceImpl authorsRanksService = new AuthorsRanksServiceImpl(null, null);

        Map<String, Double> sorted = new TreeMap<>();
        sorted = authorsRanksService.sortMap(map);
        ArrayList<Double> sortedList = new ArrayList<>();
        sorted.forEach((k, v) -> {
            sortedList.add(v);
        });
        assertEquals( 3.0, sortedList.get(0));
        assertEquals( 2.0, sortedList.get(1));
        assertEquals( 1.0, sortedList.get(2));
    }
}