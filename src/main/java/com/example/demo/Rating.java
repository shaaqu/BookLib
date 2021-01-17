package com.example.demo;

import com.example.demo.entities.Author;

import java.util.Comparator;

public class Rating {
    Author author;
    int ratingCount;
    double ratingSum;

    public Rating(Author author) {
        this.author = author;
        this.ratingCount = 0;
        this.ratingSum = 0;
    }

    public void addRating(int ratingCount, double rating){
        this.ratingCount = this.ratingCount + ratingCount;
        this.ratingSum = this.ratingSum + ratingCount * rating;
    }

    public double getRating() {
        return ratingSum/ratingCount;
    }

    public Author getAuthor() {
        return author;
    }

}
