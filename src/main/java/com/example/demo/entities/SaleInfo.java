package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "SaleInfo")
public class SaleInfo {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "country")
    private String country;

    @Column(name = "saleAbility")
    private String saleAbility;

    @Column(name = "isEbook")
    private boolean isEbook;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bookId")
    private Book book;

    public SaleInfo() {
    }

    @Builder
    public SaleInfo(String bookId, String country, String saleAbility, boolean isEbook, Book book) {
        this.bookId = bookId;
        this.country = country;
        this.saleAbility = saleAbility;
        this.isEbook = isEbook;
        this.book = book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBookId() {
        return bookId;
    }

    public String getCountry() {
        return country;
    }

    public String getSaleAbility() {
        return saleAbility;
    }

    public boolean isEbook() {
        return isEbook;
    }

    public Book getBook() {
        return book;
    }
}
