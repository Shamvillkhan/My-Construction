package com.construction.sk.service;

 

import com.construction.sk.entity.ContactDetail;
import com.construction.sk.repository.ContactDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactDetailService {

    @Autowired
    private ContactDetailRepository contactDetailRepository;

    public ContactDetail saveContactDetail(ContactDetail contactDetail) {
    	contactDetail.setCreatedAt(LocalDateTime.now());
        return contactDetailRepository.save(contactDetail);
    }

    public List<ContactDetail> getAllDetails() {
        return contactDetailRepository.findAll();
    }

    public ContactDetail getActiveDetail() {
        return contactDetailRepository.findFirstByActiveTrueOrderByIdDesc();
    }

    public void deleteById(Long id) {
        contactDetailRepository.deleteById(id);
    }
}

