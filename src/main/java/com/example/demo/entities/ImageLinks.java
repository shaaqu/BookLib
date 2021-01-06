package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "ImageLinks")
public class ImageLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "smallThumbnail")
    private String smallThumbnail;

    @Column(name = "thumbnail")
    private String thumbnail;

    @OneToOne(mappedBy = "ImageLinks")
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
}
