package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "PDF")
public class PDF {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    @Column(name = "acsTokenLink")
    private String acsTokenLink;

    @ManyToOne
    @JoinColumn(name = "accessInfo")
    private AccessInfo accessInfo;

    public PDF() {
    }
}
