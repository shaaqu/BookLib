package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "industryIdentifiers")
public class IndustryIdentifiers {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "type")
    private String type;

    @Column(name = "identifier")
    private String identifier;

    public IndustryIdentifiers() {
    }
}
