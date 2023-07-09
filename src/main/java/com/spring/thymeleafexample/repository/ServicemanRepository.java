package com.spring.thymeleafexample.repository;

import com.spring.thymeleafexample.entity.Serviceman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicemanRepository extends JpaRepository<Serviceman, Integer> {
}