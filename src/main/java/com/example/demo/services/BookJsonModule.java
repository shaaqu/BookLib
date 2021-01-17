package com.example.demo.services;

import com.example.demo.BookItemDeserializer;
import com.example.demo.entities.*;
import com.example.demo.repositories.*;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BookJsonModule {

    BookRepository bookRepository;
    AccessInfoRepository accessInfoRepository;
    EPubRepository ePubRepository;
    ImageLinksRepository imageLinksRepository;
    IndustryIdentifierRepository industryIdentifierRepository;
    PDFRepository pdfRepository;
    ReadingModeRepository readingModeRepository;
    SaleInfoRepository saleInfoRepository;
    SearchInfoRepository searchInfoRepository;
    VolumeInfoRepository volumeInfoRepository;
    AuthorRepository authorRepository;

    @Autowired
    public BookJsonModule(BookRepository bookRepository, AccessInfoRepository accessInfoRepository, EPubRepository ePubRepository, ImageLinksRepository imageLinksRepository, IndustryIdentifierRepository industryIdentifierRepository, PDFRepository pdfRepository, ReadingModeRepository readingModeRepository, SaleInfoRepository saleInfoRepository, SearchInfoRepository searchInfoRepository, VolumeInfoRepository volumeInfoRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.accessInfoRepository = accessInfoRepository;
        this.ePubRepository = ePubRepository;
        this.imageLinksRepository = imageLinksRepository;
        this.industryIdentifierRepository = industryIdentifierRepository;
        this.pdfRepository = pdfRepository;
        this.readingModeRepository = readingModeRepository;
        this.saleInfoRepository = saleInfoRepository;
        this.searchInfoRepository = searchInfoRepository;
        this.volumeInfoRepository = volumeInfoRepository;
        this.authorRepository = authorRepository;
    }

    public void createDataBase() {
        BookItemDeserializer bookItemDeserializer = new BookItemDeserializer("books.json");
        List<Book> books = bookItemDeserializer.deserializeDB();
        books.forEach(v -> {
            v.getAccessInfo().setBook(v);
            v.getSaleInfo().setBook(v);
            v.getVolumeInfo().setBook(v);
            v.getSearchInfo().setBook(v);


            VolumeInfo volumeInfo = v.getVolumeInfo();
            AccessInfo accessInfo = v.getAccessInfo();

            PDF pdf = v.getAccessInfo().getPdf();
            pdf.setAccessInfo(accessInfo);
            accessInfo.setPdf(pdf);
//            pdfRepository.save(pdf);

            EPub ePub = v.getAccessInfo().getePub();
            ePub.setAccessInfo(accessInfo);
            accessInfo.setePub(ePub);
//            ePubRepository.save(ePub);

            ReadingMode readingMode = v.getVolumeInfo().getReadingMode();
            readingMode.setVolumeInfo(volumeInfo);
            volumeInfo.setReadingMode(readingMode);
//            readingModeRepository.save(readingMode);

            ImageLinks imageLinks = v.getVolumeInfo().getImageLinks();
            imageLinks.setVolumeInfo(volumeInfo);
            volumeInfo.setImageLinks(imageLinks);
//            imageLinksRepository.save(imageLinks);

            v.setAccessInfo(accessInfo);
            v.setVolumeInfo(volumeInfo);
            accessInfoRepository.save(accessInfo);
            volumeInfoRepository.save(volumeInfo);

            bookRepository.save(v);

        });
    }



    private void saveVolumeInfo(Book v) {



        v.getVolumeInfo().getAuthors().forEach(a -> {
            a.addBook(v.getVolumeInfo());
        });

        v.getVolumeInfo().getIndustryIdentifiers().forEach(i -> {
            i.setVolumeInfo(v.getVolumeInfo());
        });

//        imageLinksRepository.save(v.getVolumeInfo().getImageLinks());
    }
}
