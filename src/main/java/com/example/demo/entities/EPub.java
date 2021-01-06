package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "epub")
public class EPub {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    @Column(name = "acsTokenLink")
    private String acsTokenLink;

    @ManyToOne
    @JoinColumn(name = "accessInfo")
    private AccessInfo accessInfo;

    public EPub() {
    }

    @Builder
    public EPub(String bookId, boolean isAvailable, String acsTokenLink, AccessInfo accessInfo) {
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.acsTokenLink = acsTokenLink;
        this.accessInfo = accessInfo;
    }

    public String getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getAcsTokenLink() {
        return acsTokenLink;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }
}
