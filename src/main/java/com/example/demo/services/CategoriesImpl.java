package com.example.demo.services;

import com.example.demo.entities.Book;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.VolumeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesImpl implements Categories{

    VolumeInfoRepository volumeInfoRepository;

    @Autowired
    public CategoriesImpl(VolumeInfoRepository volumeInfoRepository) {
        this.volumeInfoRepository = volumeInfoRepository;
    }

    @Override
    public List<Book> getByCategory(String category) {

        ArrayList<Book> books = new ArrayList<>();

        volumeInfoRepository.findAll().forEach(volumeInfo -> {
            if (volumeInfo.getCategories().contains(category)) {
                books.add(volumeInfo.getBook());
            }
        });

        return books;
    }
}
