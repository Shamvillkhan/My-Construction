package com.construction.sk.repository;

import com.construction.sk.entity.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 @Repository
public interface ContactDetailRepository extends JpaRepository<ContactDetail, Long> {

    // Finds the latest active contact detail based on ID (assumes higher ID = more recent)
    ContactDetail findFirstByActiveTrueOrderByIdDesc();
}
