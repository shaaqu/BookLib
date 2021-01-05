package com.example.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "readingModel")
public class ReadingModel {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "text")
    private boolean text;

    @Column(name = "image")
    private boolean image;

    @Column(name = "books")
    @OneToMany(mappedBy = "readingModel")
    private List<VolumeInfo> volumeInfoList;

    public ReadingModel() {
    }
}
