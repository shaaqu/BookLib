package com.example.demo.repositories;

import com.example.demo.entities.SearchInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SearchInfoRepository extends CrudRepository<SearchInfo, String>, PagingAndSortingRepository<SearchInfo, String> {

    SearchInfo save(SearchInfo searchInfo);

}
