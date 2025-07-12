package com.construction.sk.service;

 
import com.construction.sk.entity.Project;
import com.construction.sk.filehandling.FileUploadUtil;
import com.construction.sk.repository.ProjectRepository;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service

public class ProjectService  {

    private  ProjectRepository eventRepository;

    @Autowired
    public ProjectService(ProjectRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

  
    public Project createEvent(MultipartFile file,Project event) throws IOException {
    	String filename=FileUploadUtil.saveFile(file);
    	event.setImage(filename);
        return eventRepository.save(event);
    }

 
    public Project updateEvent(Long id, Project event) {
        return eventRepository.findById(id)
                .map(existing -> {
                    existing.setName(event.getName());
                    existing.setDescription(event.getDescription());
                    existing.setLocation(event.getLocation());
                    existing.setStartDate(event.getStartDate());
                    existing.setEndDate(event.getEndDate());
                    existing.setStatus(event.getStatus());
                    existing.setImage(event.getImage());
                    return eventRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Event not found with ID " + id));
    }

 
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
 
    public Optional<Project> getEventById(Long id) {
        return eventRepository.findById(id);
    }

 
    public List<Project> getAllEvents() {
        return eventRepository.findAll();
    }
}
