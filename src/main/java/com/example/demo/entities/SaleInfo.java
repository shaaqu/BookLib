package com.example.demo.entities;

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
}
