package com.example.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accessInfo")
public class AccessInfo {

    @Id
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "country")
    private String country;

    @Column(name = "viewAbility")
    private String viewAbility;

    @Column(name = "embeddable")
    private boolean embeddable;

    @Column(name = "publicDomian")
    private boolean publicDomian;

    @Column(name = "textToSpeechPermission")
    private String textToSpeechPermission;

    @Column(name = "epub")
    @OneToMany(mappedBy = "accessInfo")
    private List<EPub> ePubList;

    @Column(name = "pdf")
    @OneToMany(mappedBy = "accessInfo")
    private List<PDF> pdfList;

    @Column(name = "webReaderLink")
    private String webReaderLink;

    @Column(name = "accessViewStatus")
    private String accessViewStatus;

    @Column(name = "quoteSharingAllowed")
    private boolean quoteSharingAllowed;

    @OneToOne
    @MapsId
    @JoinColumn(name = "bookId")
    private Book book;

    public AccessInfo() {
    }
}
