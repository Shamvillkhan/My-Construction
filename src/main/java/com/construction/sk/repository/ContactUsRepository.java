package com.construction.sk.repository;

 

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.sk.entity.Contactus;
 

public interface ContactUsRepository extends JpaRepository<Contactus, Long> {
    // You can add custom query methods if needed later
}
