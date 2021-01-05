package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "searchInfo")
public class SearchInfo {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "textSnippet")
    private String textSnippet;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bookId")
    private Book book;

    public SearchInfo() {
    }
}
