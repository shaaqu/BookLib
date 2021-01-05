package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "readingModels")
public class ReadingModels {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "text")
    private boolean text;

    @Column(name = "image")
    private boolean image;

    public ReadingModels() {
    }
}
