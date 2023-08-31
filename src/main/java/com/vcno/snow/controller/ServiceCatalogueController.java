package com.vcno.snow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcno.snow.model.Services;
import com.vcno.snow.service.ServiceCatalogueService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000/")
public class ServiceCatalogueController {

    @Autowired
    private ServiceCatalogueService serviceCatalogueService;

    @GetMapping
    public ResponseEntity<Map<String,List<Services>>> getAllService(){
        List<Services> allServices = this.serviceCatalogueService.getAllService();
        Map<String,List<Services>> response= new HashMap<>();
        response.put("services",allServices);

        return new ResponseEntity<Map<String,List<Services>>>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Services> createService(@RequestBody Services service)
    {
      Services createdService = this.serviceCatalogueService.createService(service);

      return new ResponseEntity<Services>(createdService, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable Integer id)
    {
        this.serviceCatalogueService.deleteService(id);

        return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Services> findServiceById(@PathVariable Integer id)
    {
        Services serviceById = this.serviceCatalogueService.getServiceById(id);

        return new ResponseEntity<Services>(serviceById, HttpStatus.FOUND);
    }
    
}
