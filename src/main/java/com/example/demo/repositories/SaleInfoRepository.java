package com.example.demo.repositories;

import com.example.demo.entities.SaleInfo;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

@EnableJpaRepositories
public interface SaleInfoRepository extends CrudRepository<SaleInfo, String>, PagingAndSortingRepository<SaleInfo, String> {

    SaleInfo save(SaleInfo saleInfo);

}
