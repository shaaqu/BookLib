package com.example.demo.repositories;

import com.example.demo.entities.SearchInfo;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

@EnableJpaRepositories
public interface SearchInfoRepository extends CrudRepository<SearchInfo, String>, PagingAndSortingRepository<SearchInfo, String> {

    SearchInfo save(SearchInfo searchInfo);

}
