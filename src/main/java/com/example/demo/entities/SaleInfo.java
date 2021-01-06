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

    @OneToOne
    @MapsId
    @JoinColumn(name = "bookId")
    private Book book;

    public SaleInfo() {
    }

    @Builder
    public SaleInfo(String bookId, String country, String saleAbility, Book book) {
        this.bookId = bookId;
        this.country = country;
        this.saleAbility = saleAbility;
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

    public Book getBook() {
        return book;
    }
}
