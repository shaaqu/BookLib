package com.example.demo.services;

import com.example.demo.entities.Book;
import com.example.demo.entities.IndustryIdentifier;
import com.example.demo.entities.VolumeInfo;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ISBNServiceImpl implements ISBNService {

    BookRepository bookRepository;
    IndustryIdentifierRepository industryIdentifierRepository;
    VolumeInfoRepository volumeInfoRepository;

    @Autowired
    public ISBNServiceImpl(BookRepository bookRepository, IndustryIdentifierRepository industryIdentifierRepository, VolumeInfoRepository volumeInfoRepository, SaleInfoRepository saleInfoRepository, SearchInfoRepository searchInfoRepository, AccessInfoRepository accessInfoRepository) {
        this.bookRepository = bookRepository;
        this.industryIdentifierRepository = industryIdentifierRepository;
        this.volumeInfoRepository = volumeInfoRepository;
    }





    @Override
    public Book getBookByISBN(String isbn) {

        VolumeInfo volumeInfo = volumeInfoRepository.getVolumeInfoByIndustryIdentifiers(isbn);
        if (volumeInfo != null) {
            String id = volumeInfo.getBookId();
            Book book = bookRepository.getBookByBookId(id);
            book.setVolumeInfo(null);
            book.setAccessInfo(null);
            book.setSaleInfo(null);
            book.setSearchInfo(null);
            return book;
        } else {
            return null;
        }
    }

}
