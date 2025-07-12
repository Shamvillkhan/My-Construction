package com.construction.sk.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.construction.sk.entity.Team;
 
import com.construction.sk.service.TeamService; 

@Controller
@RequestMapping("/team")
public class TeamController {
	
	private TeamService teamService;
	 
    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
	
	@PostMapping("/add")
	public String addTeamMember(
	        @ModelAttribute Team team,
	        @RequestParam("photo") MultipartFile photoFile) throws IOException {
 
	      
	       
	        teamService.saveTeamMember(team,photoFile);

	        return "redirect:/SK/index";
 
	}

}
