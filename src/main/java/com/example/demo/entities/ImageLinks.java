package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ImageLinks")
public class ImageLinks {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "smallThumbnail")
    private String smallThumbnail;

    @Column(name = "thumbnail")
    private String thumbnail;

    public ImageLinks() {
    }
}
