package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accessInfo")
public class AccessInfo {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "country")
    private String country;

    @Column(name = "viewAbility")
    private String viewAbility;

    @Column(name = "embeddable")
    private boolean embeddable;

    @Column(name = "publicDomian")
    private boolean publicDomian;

    @Column(name = "textToSpeechPermission")
    private String textToSpeechPermission;

    @Column(name = "epub")
    @OneToMany(mappedBy = "accessInfo")
    private List<EPub> ePubList;

    @Column(name = "pdf")
    @OneToMany(mappedBy = "accessInfo")
    private List<PDF> pdfList;

    @Column(name = "webReaderLink")
    private String webReaderLink;

    @Column(name = "accessViewStatus")
    private String accessViewStatus;

    @Column(name = "quoteSharingAllowed")
    private boolean quoteSharingAllowed;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bookId")
    private Book book;

    public AccessInfo() {
    }

    @Builder
    public AccessInfo(String bookId, String country, String viewAbility, boolean embeddable, boolean publicDomian, String textToSpeechPermission, List<EPub> ePubList, List<PDF> pdfList, String webReaderLink, String accessViewStatus, boolean quoteSharingAllowed, Book book) {
        this.bookId = bookId;
        this.country = country;
        this.viewAbility = viewAbility;
        this.embeddable = embeddable;
        this.publicDomian = publicDomian;
        this.textToSpeechPermission = textToSpeechPermission;
        this.ePubList = ePubList;
        this.pdfList = pdfList;
        this.webReaderLink = webReaderLink;
        this.accessViewStatus = accessViewStatus;
        this.quoteSharingAllowed = quoteSharingAllowed;
        this.book = book;
    }

    public String getBookId() {
        return bookId;
    }

    public String getCountry() {
        return country;
    }

    public String getViewAbility() {
        return viewAbility;
    }

    public boolean isEmbeddable() {
        return embeddable;
    }

    public boolean isPublicDomian() {
        return publicDomian;
    }

    public String getTextToSpeechPermission() {
        return textToSpeechPermission;
    }

    public List<EPub> getEPubList() {
        return ePubList;
    }

    public List<PDF> getPdfList() {
        return pdfList;
    }

    public String getWebReaderLink() {
        return webReaderLink;
    }

    public String getAccessViewStatus() {
        return accessViewStatus;
    }

    public boolean isQuoteSharingAllowed() {
        return quoteSharingAllowed;
    }

    public Book getBook() {
        return book;
    }
}
