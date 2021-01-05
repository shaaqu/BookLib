package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    public SaleInfo() {
    }
}
