package com.example.demo.repositories;

import com.example.demo.entities.IndustryIdentifier;
import com.example.demo.entities.VolumeInfo;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

@EnableJpaRepositories
public interface VolumeInfoRepository extends CrudRepository<VolumeInfo, String>, PagingAndSortingRepository<VolumeInfo, String> {

    VolumeInfo save(VolumeInfo volumeInfo);

    @Query("SELECT v FROM VolumeInfo v " +
            "LEFT JOIN v.industryIdentifiers as i " +
            "WHERE i.identifier = ?1")
    VolumeInfo getVolumeInfoByIndustryIdentifiers(String identifier);

    List<VolumeInfo> findAll();

    List<VolumeInfo> findByAverageRatingGreaterThan(Double minRating);
}
