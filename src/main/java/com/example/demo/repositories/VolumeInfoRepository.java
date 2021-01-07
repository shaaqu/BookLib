package com.example.demo.repositories;

import com.example.demo.entities.IndustryIdentifier;
import com.example.demo.entities.VolumeInfo;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface VolumeInfoRepository extends CrudRepository<VolumeInfo, String>, PagingAndSortingRepository<VolumeInfo, String> {

    VolumeInfo save(VolumeInfo volumeInfo);
    VolumeInfo getVolumeInfoByIndustryIdentifiers(IndustryIdentifier industryIdentifier);

    List<VolumeInfo> findAll();

    List<VolumeInfo> findByAverageRatingGreaterThan(Double minRating);
}
