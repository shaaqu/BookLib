package com.example.demo.repositories;

import com.example.demo.entities.EPub;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

@EnableJpaRepositories
public interface EPubRepository extends CrudRepository<EPub, String>, PagingAndSortingRepository<EPub, String> {

    EPub save(EPub ePub);

}
