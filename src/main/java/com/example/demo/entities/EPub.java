package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "epub")
public class EPub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    @Column(name = "acsTokenLink")
    private String acsTokenLink;

    @OneToOne
    @JoinColumn(name = "bookId")
    private AccessInfo accessInfo;

    public EPub() {
    }

    @Builder
    public EPub(long id, boolean isAvailable, String acsTokenLink, AccessInfo accessInfo) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.acsTokenLink = acsTokenLink;
        this.accessInfo = accessInfo;
    }

    public long getId() {
        return id;
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
