package com.example.demo.services;

import com.example.demo.BookItemDeserializer;
import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.entities.IndustryIdentifier;
import com.example.demo.entities.ReadingMode;
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

            v.getVolumeInfo().getReadingMode().setVolumeInfo(v.getVolumeInfo());

            bookRepository.save(v);

            saveVolumeInfo(v);
            saveSaleInfo(v);
            saveAccessInfo(v);
            saveSearchInfo(v);

        });
    }

    private void saveSearchInfo(Book v) {
        //searchInfoRepository.save(v.getSearchInfo());
    }

    private void saveAccessInfo(Book v) {
        //accessInfoRepository.save(v.getAccessInfo());
        pdfRepository.save(v.getAccessInfo().getPdf());
        ePubRepository.save(v.getAccessInfo().getePub());
    }

    private void saveSaleInfo(Book v) {
        //saleInfoRepository.save(v.getSaleInfo());
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
