package com.example.demo.services;

import com.example.demo.entities.Book;
import com.example.demo.entities.IndustryIdentifier;
import com.example.demo.entities.VolumeInfo;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.IndustryIdentifierRepository;
import com.example.demo.repositories.VolumeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ISBNServiceImpl implements ISBNService {

    BookRepository bookRepository;
    IndustryIdentifierRepository industryIdentifierRepository;
    VolumeInfoRepository volumeInfoRepository;


    @Autowired
    public ISBNServiceImpl(BookRepository bookRepository, IndustryIdentifierRepository industryIdentifierRepository, VolumeInfoRepository volumeInfoRepository) {
        this.bookRepository = bookRepository;
        this.industryIdentifierRepository = industryIdentifierRepository;
        this.volumeInfoRepository = volumeInfoRepository;
    }


    @Override
    public Book getBookByISBN(String isbn) {

        IndustryIdentifier industryIdentifier = industryIdentifierRepository.getIndustryIdentifierByIdentifier(isbn);
        VolumeInfo volumeInfo = volumeInfoRepository.getVolumeInfoByIndustryIdentifiers(industryIdentifier);
        return bookRepository.getBookByBookId("7tkN1CYzn2cC");

    }

}
