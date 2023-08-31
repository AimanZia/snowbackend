package com.vcno.snow.service;


import java.util.List;

import com.vcno.snow.model.Services;

public interface ServiceCatalogueService {

    Services createService(Services service);

    Services updatService(Services service,Integer serviceId);

    List<Services> getAllService();

    Services getServiceById(Integer serviceId);

    List<Services> getServicesByName(String serviceName);

    void deleteService(Integer serviceId);
    
}
