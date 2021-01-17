package com.example.demo.repositories;

import com.example.demo.entities.AccessInfo;
import com.example.demo.entities.Author;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

@EnableJpaRepositories
public interface AccessInfoRepository  extends CrudRepository<Author, String>, PagingAndSortingRepository<Author, String> {

    AccessInfo save(AccessInfo accessInfo);

    AccessInfo findByBookId(String id);

}
