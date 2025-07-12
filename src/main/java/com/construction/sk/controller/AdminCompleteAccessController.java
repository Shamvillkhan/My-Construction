package com.construction.sk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.construction.sk.entity.ContactDetail;
import com.construction.sk.entity.Project;
import com.construction.sk.entity.Team;
import com.construction.sk.entity.Testimonial;
import com.construction.sk.service.ContactUsService;

@Controller
@RequestMapping("/admin")
public class AdminCompleteAccessController {
	
	@Autowired
	private ContactUsService contactUsService;
	
	@GetMapping("/panel")
	public String Admin() {
		return "admin/admin-index";
	}
	@GetMapping("/testimonial")
    public String showForm(Model model) {
        model.addAttribute("testimonial", new Testimonial());
        return "admin/testimonial-form"; // make testimonial/form.html
    }
	 @GetMapping("/gallery")
	    public String showUploadForm() {
	        return "admin/gallery-upload";
	    }
	 @GetMapping("/project")
	    public String showCreateForm(Model model) {
	        model.addAttribute("project", new Project());
	        return "admin/project-upload"; // views/project/create.html
	    }

	 @GetMapping("/team")
	 public String showTeamForm(Model model) {
		 model.addAttribute("team",new Team());
		 return "admin/team-upload";
	 }

	    // (Optional) Show all messages (Admin View)
	    @GetMapping("/all")
	    public String viewAllMessages(Model model) {
	        model.addAttribute("messages", contactUsService.getAllMessages());
	        return "redirect:/admin/panel"; // Create contact-messages.html to show all entries
	    }
	
	@GetMapping("/contact-detail")
	public String showContactForm(Model model) {
	    model.addAttribute("contactDetail", new ContactDetail());
	    return "admin/contact-detail"; // matches the HTML file name
	}
}
