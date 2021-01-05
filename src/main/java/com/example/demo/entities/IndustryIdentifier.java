package com.example.demo.entities;

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
}
