package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "epub")
public class EPub {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    @Column(name = "acsTokenLink")
    private String acsTokenLink;

    public EPub() {
    }
}
