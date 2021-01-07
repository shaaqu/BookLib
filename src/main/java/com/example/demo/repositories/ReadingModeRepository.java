package com.example.demo.repositories;

import com.example.demo.entities.ReadingMode;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

@EnableJpaRepositories
public interface ReadingModeRepository extends CrudRepository<ReadingMode, String>, PagingAndSortingRepository<ReadingMode, String> {

    ReadingMode save(ReadingMode readingMode);

}
