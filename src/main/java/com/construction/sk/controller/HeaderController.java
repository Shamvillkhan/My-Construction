package com.construction.sk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.construction.sk.entity.Contactus;
import com.construction.sk.entity.Project;
import com.construction.sk.service.ContactDetailService;
import com.construction.sk.service.GalleryService;
import com.construction.sk.service.ProjectService;
import com.construction.sk.service.TeamService;
import com.construction.sk.service.TestimonialService;

@Controller
@RequestMapping("/SK")
public class HeaderController {
	 @Autowired
	 private GalleryService galleryService;
	 
	 private TestimonialService testimonialSer;
	
	private ContactDetailService contactDetail;
	
	private TeamService teamService;
	private  ProjectService projectService;
	
 
	
    @Autowired
	public HeaderController(ProjectService projectService,TeamService teamService,ContactDetailService contactDetail,TestimonialService testimonialSer) {
		this.contactDetail=contactDetail;
		this.testimonialSer=testimonialSer;
		this.teamService=teamService;
		this.projectService=projectService;
	}
	
	 @GetMapping("/index") public String home(Model model) { 
		 List<Project> projects = projectService.getAllEvents();
		 model.addAttribute("testimonials",testimonialSer.getAllTestimonials());
		 model.addAttribute("contactDetail",contactDetail.getActiveDetail());
		 model.addAttribute("contactUs", new Contactus());
	        model.addAttribute("projects", projects);
		 return "index"; }
	 
	
	@GetMapping("/about")
	public String about() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("<<<<<<"+username+">>>>>");
		return "about";
	}
	
	@GetMapping("/service")
	public String service() {
		return "service";
	}
 
	
	
	@GetMapping("/project")
	public String project(Model model) {
		 List<Project> projects = projectService.getAllEvents();
	        model.addAttribute("projects", projects);
		return "project";
	}
	@GetMapping("/team")
	public String team(Model model) {
		model.addAttribute("teamMembers",teamService.getAllTeamMembers());
		return "team";
	}
	
	@GetMapping("/gallery")
    public String showGallery(@RequestParam(value = "search", required = false) String search, Model model) {
        model.addAttribute("images",
                (search != null && !search.isEmpty())
                        ? galleryService.searchByCategory(search)
                        : galleryService.getAllImages());
        model.addAttribute("search", search);
        return "gallery";
    }
	
	  @GetMapping("/contact")
	    public String showContactForm(Model model) {
		  	
		  	model.addAttribute("contactDetail",contactDetail.getActiveDetail());
	        model.addAttribute("contactUs", new Contactus());
	        return "contact";  
	    }
	
	 
}
