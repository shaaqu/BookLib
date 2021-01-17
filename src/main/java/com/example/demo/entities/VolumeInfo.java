package com.example.demo.entities;

import lombok.Builder;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "authors_books",
            joinColumns = {@JoinColumn(name = "bookId")},
            inverseJoinColumns = {@JoinColumn(name = "name")}
    )
    private List<Author> authors = new ArrayList<Author>();

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "publishedDate")
    private long publishedDate;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "volumeInfo") @NotFound(action = NotFoundAction.IGNORE)
    private List<IndustryIdentifier> industryIdentifiers = new ArrayList<IndustryIdentifier>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "readingMode", referencedColumnName = "id")
    private ReadingMode readingMode;

    @Column(name = "pageCount")
    private int pageCount;

    @Column(name = "printType")
    private String printType;

    @Column(name = "categories") @ElementCollection
    List<String> categories = new ArrayList<>();

    @Column(name = "averageRating")
    private double averageRating;

    @Column(name = "ratingCount")
    private int ratingCount;

    @Column(name = "maturityRating")
    private String maturityRating;

    @Column(name = "allowAnonLogging")
    private String allowAnonLogging;

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
    public VolumeInfo(String bookId, String title, List<Author> authors, String publisher,
                      long publishedDate, String description, List<IndustryIdentifier> industryIdentifiers,
                      ReadingMode readingMode, int pageCount, String printType, List<String> categories,double averageRating,
                      int ratingCount, String maturityRating, String allowAnonLogging, String contentVersion,
                      ImageLinks imageLinks, String language, String previewLink, String infoLink,
                      String canonicalVolumeLink, Book book) {
        this.bookId = bookId;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.industryIdentifiers = industryIdentifiers;
        this.readingMode = readingMode;
        this.pageCount = pageCount;
        this.printType = printType;
        this.categories = categories;
        this.averageRating = averageRating;
        this.ratingCount = ratingCount;
        this.maturityRating = maturityRating;
        this.allowAnonLogging = allowAnonLogging;
        this.contentVersion = contentVersion;
        this.imageLinks = imageLinks;
        this.language = language;
        this.previewLink = previewLink;
        this.infoLink = infoLink;
        this.canonicalVolumeLink = canonicalVolumeLink;
        this.book = book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void addCategories(List<String> categories) {
        this.categories.addAll(categories);
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public long getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public List<IndustryIdentifier> getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    public ReadingMode getReadingMode() {
        return readingMode;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getPrintType() {
        return printType;
    }

    public List<String> getCategories() {
        return categories;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public String getMaturityRating() {
        return maturityRating;
    }

    public String getAllowAnonLogging() {
        return allowAnonLogging;
    }

    public String getContentVersion() {
        return contentVersion;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public String getLanguage() {
        return language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public String getCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }

    public Book getBook() {
        return book;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void addIndustryIdentifiers(IndustryIdentifier industryIdentifier) {
        this.industryIdentifiers.add(industryIdentifier);
    }

    public void setReadingMode(ReadingMode readingMode) {
        this.readingMode = readingMode;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }
}
