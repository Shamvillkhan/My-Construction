package com.construction.sk.controller;

import com.construction.sk.entity.Project;
import com.construction.sk.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // Display all projects
    @GetMapping
    public String listProjects(Model model) {
        List<Project> projects = projectService.getAllEvents();
        model.addAttribute("projects", projects);
        return "project"; // views/project/list.html (Thymeleaf)
    }

    // Show form to create a new project
   
    // Handle form submission for new project
    @PostMapping("/add")
    public String createProject(@ModelAttribute("project") Project project,@RequestParam("imageFile") MultipartFile  file) throws IOException {
        projectService.createEvent(file,project);
        return "redirect:/SK/index";
    }

    // Show form to update a project
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Project project = projectService.getEventById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project ID: " + id));
        model.addAttribute("project", project);
        return "project/edit"; // views/project/edit.html
    }

    // Handle update submission
    @PostMapping("/update/{id}")
    public String updateProject(@PathVariable Long id, @ModelAttribute("project") Project project) {
        projectService.updateEvent(id, project);
        return "redirect:/projects";
    }

    // Delete project
    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteEvent(id);
        return "redirect:/projects";
    }

    // View single project details
    @GetMapping("/{id}")
    public String viewProject(@PathVariable Long id, Model model) {
        Project project = projectService.getEventById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project ID: " + id));
        model.addAttribute("project", project);
        return "project/view"; // views/project/view.html
    }
}
