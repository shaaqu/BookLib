package com.example.demo.repositories;

import com.example.demo.entities.PDF;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PDFRepository extends CrudRepository<PDF, String>, PagingAndSortingRepository<PDF, String> {

    PDF save(PDF pdf);

}
