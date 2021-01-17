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

            List<IndustryIdentifier> industryIdentifierList = volumeInfo.getIndustryIdentifiers();
            List<Author> authors = volumeInfo.getAuthors();
            volumeInfo.getIndustryIdentifiers().clear();
            volumeInfo.getAuthors().clear();

            industryIdentifierList.forEach( i -> {
                i.setVolumeInfo(volumeInfo);
                volumeInfo.addIndustryIdentifiers(i);
            });

            authors.forEach(a -> {
                a.addBook(volumeInfo);
                volumeInfo.addAuthor(a);
            });

            PDF pdf = v.getAccessInfo().getPdf();
            pdf.setAccessInfo(accessInfo);
            accessInfo.setPdf(pdf);

            EPub ePub = v.getAccessInfo().getePub();
            ePub.setAccessInfo(accessInfo);
            accessInfo.setePub(ePub);

            ReadingMode readingMode = v.getVolumeInfo().getReadingMode();
            readingMode.setVolumeInfo(volumeInfo);
            volumeInfo.setReadingMode(readingMode);

            ImageLinks imageLinks = v.getVolumeInfo().getImageLinks();
            imageLinks.setVolumeInfo(volumeInfo);
            volumeInfo.setImageLinks(imageLinks);

            v.setAccessInfo(accessInfo);
            v.setVolumeInfo(volumeInfo);

            bookRepository.save(v);

            authors.forEach(author -> {
                authorRepository.save(author);
            });

            industryIdentifierList.forEach( i -> {
                industryIdentifierRepository.save(i);
            });

        });
    }

}
