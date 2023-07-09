package com.spring.thymeleafexample.service;

import com.spring.thymeleafexample.entity.Serviceman;
import com.spring.thymeleafexample.repository.ServicemanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicemanService {
    private final ServicemanRepository servicemanRepository;

    public ServicemanService(ServicemanRepository servicemanRepository) {
        this.servicemanRepository = servicemanRepository;
    }

    public List<Serviceman> getAllServicemen() {
        return servicemanRepository.findAll();
    }

    public Serviceman getOneServicemanById(int id) {
        return servicemanRepository.findById(id).orElseThrow();
    }

    public Serviceman saveServiceman(Serviceman serviceman) {
        return servicemanRepository.save(serviceman);
    }

    public void deleteServiceman(int id){

    }
}