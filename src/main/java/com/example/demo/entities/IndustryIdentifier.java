package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "industryIdentifier")
public class IndustryIdentifier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "identifier")
    private String identifier;

    @ManyToOne
    @JoinColumn(name = "bookId", nullable = false)
    VolumeInfo volumeInfo;

    public IndustryIdentifier() {
    }

    @Builder
    public IndustryIdentifier(long id, String type, String identifier, VolumeInfo volumeInfo) {
        this.id = id;
        this.type = type;
        this.identifier = identifier;
        this.volumeInfo = volumeInfo;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}
