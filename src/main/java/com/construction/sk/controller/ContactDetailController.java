package com.construction.sk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.construction.sk.entity.ContactDetail;
import com.construction.sk.service.ContactDetailService;

@Controller
@RequestMapping("/contact-detail")
public class ContactDetailController {
	
	
	private ContactDetailService contactDetailService;
	
	@Autowired
	public ContactDetailController(ContactDetailService contactDetailService) {
		this.contactDetailService=contactDetailService;
	}

	@PostMapping("/submit")
	public String submitContactDetail(@ModelAttribute ContactDetail contactDetail) {
	    contactDetailService.saveContactDetail(contactDetail);
	    return "redirect:/admin/panel";
	}

}
