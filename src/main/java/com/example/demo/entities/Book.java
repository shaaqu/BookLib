package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

    @Column(name = "kind")
    private String kind;

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "etag")
    private String etag;

    @Column(name = "selfLink")
    private String selfLink;



}
