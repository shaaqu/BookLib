package com.example.demo.repositories;

import com.example.demo.entities.SaleInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SaleInfoRepository extends CrudRepository<SaleInfo, String>, PagingAndSortingRepository<SaleInfo, String> {

    SaleInfo save(SaleInfo saleInfo);

}
