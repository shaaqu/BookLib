package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "imageLinks")
public class ImageLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "smallThumbnail")
    private String smallThumbnail;

    @Column(name = "thumbnail")
    private String thumbnail;

    @OneToOne(mappedBy = "imageLinks")
    private VolumeInfo volumeInfo;

    public ImageLinks() {
    }

    @Builder
    public ImageLinks(Long id, String smallThumbnail, String thumbnail, VolumeInfo volumeInfo) {
        this.id = id;
        this.smallThumbnail = smallThumbnail;
        this.thumbnail = thumbnail;
        this.volumeInfo = volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public Long getId() {
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
