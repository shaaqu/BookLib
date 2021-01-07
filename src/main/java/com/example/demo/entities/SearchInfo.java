package com.example.demo.entities;

import lombok.Builder;

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

    public SearchInfo() { }

    @Builder
    public SearchInfo(String bookId, String textSnippet, Book book) {
        this.bookId = bookId;
        this.textSnippet = textSnippet;
        this.book = book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTextSnippet() {
        return textSnippet;
    }

    public Book getBook() {
        return book;
    }
}
