package com.vcno.snow.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vcno.snow.dao.ServiceCatalogueDao;
import com.vcno.snow.model.Services;
import com.vcno.snow.service.ServiceCatalogueService;

@Service
@Transactional
public class ServiceCatalougeServiceImpl implements ServiceCatalogueService{

    @Autowired
    private ServiceCatalogueDao serviceCatalogueDao;

    @Override
    public Services createService(Services service) {
        service.setServiceCreationDate(new Date().toString());
        Services savedService = this.serviceCatalogueDao.save(service);
        return savedService;
        
    }

    @Override
    public Services updatService(Services service, Integer serviceId) {
        Services serviceById = this.serviceCatalogueDao.findById(serviceId).get();
        serviceById.setServiceName(service.getServiceName());
        serviceById.setServiceDescription(service.getServiceDescription());
        serviceById.setServiceCreationDate(new Date().toString());

        Services updatedService = this.serviceCatalogueDao.save(serviceById);

        return updatedService;

    }

    @Override
    public List<Services> getAllService() {
        List<Services> allServices = this.serviceCatalogueDao.findAll();
        return allServices;
    }

    @Override
    public Services getServiceById(Integer serviceId) {
        Optional<Services> service = this.serviceCatalogueDao.findById(serviceId);

        return service.get();
    }

    @Override
    public List<Services> getServicesByName(String serviceName) {
        List<Services> filteredServices = this.serviceCatalogueDao.findByServiceNameContaining(serviceName);
        return filteredServices;
    }

    @Override
    public void deleteService(Integer serviceId) {
        Services serviceById = this.serviceCatalogueDao.findById(serviceId).get();

        this.serviceCatalogueDao.delete(serviceById);
    }
    
}
