package com.vcno.snow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;


@Entity
@Table(name="services")
public class Services {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer serviceId;

    @Column(length=100,nullable=false)
    private String serviceName;

    private String serviceDescription;

    private String serviceCreationDate;

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getServiceCreationDate() {
        return serviceCreationDate;
    }

    public void setServiceCreationDate(String serviceCreationDate) {
        this.serviceCreationDate = serviceCreationDate;
    }

    
}
