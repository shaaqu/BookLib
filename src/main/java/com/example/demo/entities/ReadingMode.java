package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "readingMode")
public class ReadingMode {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "text")
    private boolean text;

    @Column(name = "image")
    private boolean image;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bookId")
    private VolumeInfo volumeInfo;

    public ReadingMode() {
    }

    @Builder
    public ReadingMode(String id, boolean text, boolean image, VolumeInfo volumeInfo) {
        this.id = id;
        this.text = text;
        this.image = image;
        this.volumeInfo = volumeInfo;
    }

    public String getId() {
        return id;
    }

    public boolean isText() {
        return text;
    }

    public boolean isImage() {
        return image;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}
