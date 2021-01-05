package com.example.demo.entities;

import javax.persistence.*;

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

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private VolumeInfo volumeInfo;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private SaleInfo saleInfo;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AccessInfo accessInfo;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private SearchInfo searchInfo;

    public Book() {
    }

    public String getKind() {
        return kind;
    }

    public String getBookId() {
        return bookId;
    }

    public String getEtag() {
        return etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    public SearchInfo getSearchInfo() {
        return searchInfo;
    }
}
