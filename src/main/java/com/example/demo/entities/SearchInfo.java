package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "searchInfo")
public class SearchInfo {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "textSnippet")
    private String textSnippet;

    public SearchInfo() {
    }
}
