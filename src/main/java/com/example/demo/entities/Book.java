package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;

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

    @OneToOne(mappedBy = "book", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private VolumeInfo volumeInfo;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private SaleInfo saleInfo;

    @OneToOne(mappedBy = "book", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private AccessInfo accessInfo;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private SearchInfo searchInfo;

    public Book() {
    }

    @Builder
    public Book(String kind, String bookId, String etag, String selfLink, VolumeInfo volumeInfo, SaleInfo saleInfo, AccessInfo accessInfo, SearchInfo searchInfo) {
        this.kind = kind;
        this.bookId = bookId;
        this.etag = etag;
        this.selfLink = selfLink;
        this.volumeInfo = volumeInfo;
        this.saleInfo = saleInfo;
        this.accessInfo = accessInfo;
        this.searchInfo = searchInfo;
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

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public void setAccessInfo(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
    }
}
