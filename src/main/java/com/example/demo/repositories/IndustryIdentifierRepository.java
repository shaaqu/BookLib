package com.example.demo.repositories;

import com.example.demo.entities.ImageLinks;
import com.example.demo.entities.IndustryIdentifier;
import com.example.demo.entities.VolumeInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IndustryIdentifierRepository extends CrudRepository<IndustryIdentifier, String>, PagingAndSortingRepository<IndustryIdentifier, String> {

    IndustryIdentifier save(IndustryIdentifier industryIdentifier);
    IndustryIdentifier getIndustryIdentifierByIdentifier(String identifier);
}
