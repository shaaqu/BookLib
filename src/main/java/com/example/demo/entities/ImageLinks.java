package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "imageLinks")
public class ImageLinks {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "smallThumbnail")
    private String smallThumbnail;

    @Column(name = "thumbnail")
    private String thumbnail;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bookId")
    private VolumeInfo volumeInfo;

    public ImageLinks() {
    }

    @Builder
    public ImageLinks(String id, String smallThumbnail, String thumbnail, VolumeInfo volumeInfo) {
        this.id = id;
        this.smallThumbnail = smallThumbnail;
        this.thumbnail = thumbnail;
        this.volumeInfo = volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public String getId() {
        return id;
    }

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }
}
