package com.example.demo.repositories;

import com.example.demo.entities.ReadingMode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReadingModeRepository extends CrudRepository<ReadingMode, String>, PagingAndSortingRepository<ReadingMode, String> {

    ReadingMode save(ReadingMode readingMode);

}
