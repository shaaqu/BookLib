package com.example.demo.repositories;

import com.example.demo.entities.EPub;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EPubRepository extends CrudRepository<EPub, String>, PagingAndSortingRepository<EPub, String> {

    EPub save(EPub ePub);

}
