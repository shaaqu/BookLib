package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PDF")
public class PDF {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column
    private boolean isAvailable;

    @Column
    private String acsTokenLink;

    public PDF() {
    }
}
