package com.construction.sk.service;
import com.construction.sk.entity.Contactus;
import com.construction.sk.repository.ContactUsRepository;
import com.construction.sk.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactUsService {

	private ContactUsRepository contactUsRepository;
	
	@Autowired
	public ContactUsService(ContactUsRepository contactUsRepository) {
		this.contactUsRepository=contactUsRepository;
	}

    

    
    public Contactus saveMessage(Contactus contactUs) {
        return contactUsRepository.save(contactUs);
    }

    
    public List<Contactus> getAllMessages() {
        return contactUsRepository.findAll();
    }
}

