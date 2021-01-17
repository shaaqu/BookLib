package com.example.demo;

import java.util.Comparator;

public class RatingComparator implements Comparator<Rating> {

    @Override
    public int compare(Rating r1, Rating r2) {
        if (r1.getRating() < r2.getRating()) {
            return 1;
        }
        if (r1.getRating() > r2.getRating()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
