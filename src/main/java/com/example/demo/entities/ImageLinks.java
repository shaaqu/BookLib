package com.example.demo.entities;

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
}
