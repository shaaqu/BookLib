package com.example.demo.repositories;

import com.example.demo.entities.AccessInfo;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface AccessInfoRepository {

    AccessInfo save(AccessInfo accessInfo);

}
