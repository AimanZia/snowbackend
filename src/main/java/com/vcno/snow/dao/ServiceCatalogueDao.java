package com.vcno.snow.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcno.snow.model.Services;

public interface ServiceCatalogueDao extends JpaRepository<Services,Integer>{

    List<Services> findByServiceNameContaining(String serviceName);
    
}
