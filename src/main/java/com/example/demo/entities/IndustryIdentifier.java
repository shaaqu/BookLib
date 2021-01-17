package com.example.demo.entities;

import lombok.Builder;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "industryIdentifier")
public class IndustryIdentifier {

    @Id
    @Column(name = "identifier")
    private String identifier;

    @Column(name = "type")
    private String type;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId", nullable = true)
    VolumeInfo volumeInfo;

    public IndustryIdentifier() {
    }

    @Builder
    public IndustryIdentifier(String type, String identifier, VolumeInfo volumeInfo) {
        this.type = type;
        this.identifier = identifier;
        this.volumeInfo = volumeInfo;
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
