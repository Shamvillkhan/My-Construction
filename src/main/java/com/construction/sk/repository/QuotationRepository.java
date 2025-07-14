package com.construction.sk.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.sk.entity.Quotation;

import java.util.List;

public interface QuotationRepository extends JpaRepository<Quotation, Integer> {
    List<Quotation> findByUserId(int userId);
}
