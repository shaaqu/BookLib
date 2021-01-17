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

    @ManyToMany(mappedBy = "books")
    List<VolumeInfo> books = new ArrayList<VolumeInfo>();

    public Author() {
    }

    @Builder
    public Author(String name, List<VolumeInfo> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<VolumeInfo> getBooks() {
        return books;
    }

    public void addBook(VolumeInfo volumeInfo) {
        books.add(volumeInfo);
    }
}
