package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "industryIdentifier")
public class IndustryIdentifier {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "type")
    private String type;

    @Column(name = "identifier")
    private String identifier;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "industryIdentifier_books",
            joinColumns = {@JoinColumn(name = "industryIdentifier")},
            inverseJoinColumns = {@JoinColumn(name = "bookId")}
    )
    List<VolumeInfo> books = new ArrayList<VolumeInfo>();

    public IndustryIdentifier() {
    }

    @Builder
    public IndustryIdentifier(String bookId, String type, String identifier, List<VolumeInfo> books) {
        this.bookId = bookId;
        this.type = type;
        this.identifier = identifier;
        this.books = books;
    }
}
