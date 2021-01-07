package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "readingMode")
public class ReadingMode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private boolean text;

    @Column(name = "image")
    private boolean image;

    @Column(name = "books")
    @OneToMany(mappedBy = "readingMode")
    private List<VolumeInfo> volumeInfoList;

    public ReadingMode() {
    }

    @Builder
    public ReadingMode(long id, boolean text, boolean image, List<VolumeInfo> volumeInfoList) {
        this.id = id;
        this.text = text;
        this.image = image;
        this.volumeInfoList = volumeInfoList;
    }

    public long getId() {
        return id;
    }

    public boolean isText() {
        return text;
    }

    public boolean isImage() {
        return image;
    }

    public List<VolumeInfo> getVolumeInfoList() {
        return volumeInfoList;
    }
}
