package com.example.demo.repositories;

import com.example.demo.entities.VolumeInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VolumeInfoRepository extends CrudRepository<VolumeInfo, String>, PagingAndSortingRepository<VolumeInfo, String> {

    VolumeInfo save(VolumeInfo volumeInfo);

}
