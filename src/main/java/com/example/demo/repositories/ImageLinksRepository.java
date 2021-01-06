package com.example.demo.repositories;

import com.example.demo.entities.ImageLinks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ImageLinksRepository extends CrudRepository<ImageLinks, String>, PagingAndSortingRepository<ImageLinks, String> {

    ImageLinks save(ImageLinks imageLinks);

}
