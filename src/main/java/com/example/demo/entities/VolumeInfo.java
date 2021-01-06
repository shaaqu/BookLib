package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "volumeInfo")
public class VolumeInfo {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "volumeInfo")
    private List<Author> authors = new ArrayList<Author>();

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "publishedDate")
    private long publishedDate;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "volumeInfo")
    private List<IndustryIdentifier> industryIdentifiers = new ArrayList<IndustryIdentifier>();

    @ManyToOne
    @JoinColumn(name = "readingModel")
    private ReadingModel readingModel;

    @Column(name = "pageCount")
    private int pageCount;

    @Column(name = "printType")
    private String printType;

    @Column(name = "contentVersion")
    private String contentVersion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imageLinks", referencedColumnName = "id")
    private ImageLinks imageLinks;

    @Column(name = "language")
    private String language;

    @Column(name = "previewLink")
    private String previewLink;

    @Column(name = "infoLink")
    private String infoLink;

    @Column(name = "canonicalVolumeLink")
    private String canonicalVolumeLink;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bookId")
    private Book book;

    public VolumeInfo() {}

    @Builder
    public VolumeInfo(String bookId, String title, List<Author> authors, String publisher, long publishedDate, String description, List<IndustryIdentifier> industryIdentifiers, ReadingModel readingModel, int pageCount, String printType, String contentVersion, ImageLinks imageLinks, String language, String previewLink, String infoLink, String canonicalVolumeLink, Book book) {
        this.bookId = bookId;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.industryIdentifiers = industryIdentifiers;
        this.readingModel = readingModel;
        this.pageCount = pageCount;
        this.printType = printType;
        this.contentVersion = contentVersion;
        this.imageLinks = imageLinks;
        this.language = language;
        this.previewLink = previewLink;
        this.infoLink = infoLink;
        this.canonicalVolumeLink = canonicalVolumeLink;
        this.book = book;
    }
}
