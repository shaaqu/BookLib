package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "authors_books",
            joinColumns = {@JoinColumn(name = "author")},
            inverseJoinColumns = {@JoinColumn(name = "bookId")}
    )
    List<VolumeInfo> books = new ArrayList<VolumeInfo>();

    public Author() {
    }

    @Builder
    public Author(String name, List<VolumeInfo> books) {
        this.name = name;
        this.books = books;
    }
}
