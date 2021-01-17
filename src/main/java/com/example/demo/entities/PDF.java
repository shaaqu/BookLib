package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "PDF")
public class PDF {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    @Column(name = "acsTokenLink")
    private String acsTokenLink;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bookId")
    private AccessInfo accessInfo;

    public PDF() {
    }

    @Builder
    public PDF(String id, boolean isAvailable, String acsTokenLink, AccessInfo accessInfo) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.acsTokenLink = acsTokenLink;
        this.accessInfo = accessInfo;
    }

    public void setAccessInfo(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
    }

    public String getId() {
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
