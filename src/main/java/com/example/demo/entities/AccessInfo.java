package com.example.demo.entities;

import lombok.Builder;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accessInfo")
public class AccessInfo {

    @Id
    @Column(name = "id")
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

    @OneToOne(mappedBy = "accessInfo", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @PrimaryKeyJoinColumn
    private EPub ePub;

    @OneToOne(mappedBy = "accessInfo", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private PDF pdf;

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
    public AccessInfo(String bookId, String country, String viewAbility, boolean embeddable, boolean publicDomian, String textToSpeechPermission, EPub ePub, PDF pdf, String webReaderLink, String accessViewStatus, boolean quoteSharingAllowed, Book book) {
        this.bookId = bookId;
        this.country = country;
        this.viewAbility = viewAbility;
        this.embeddable = embeddable;
        this.publicDomian = publicDomian;
        this.textToSpeechPermission = textToSpeechPermission;
        this.ePub = ePub;
        this.pdf = pdf;
        this.webReaderLink = webReaderLink;
        this.accessViewStatus = accessViewStatus;
        this.quoteSharingAllowed = quoteSharingAllowed;
        this.book = book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setePub(EPub ePub) {
        this.ePub = ePub;
    }

    public void setPdf(PDF pdf) {
        this.pdf = pdf;
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

    public EPub getePub() {
        return ePub;
    }

    public PDF getPdf() {
        return pdf;
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
