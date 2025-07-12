package com.construction.sk.service;

  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.construction.sk.entity.Team;
import com.construction.sk.filehandling.FileUploadUtil;
import com.construction.sk.repository.TeamRepository;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.UUID;

@Service
public class TeamService {

    

    @Autowired
    private TeamRepository teamRepository;

    // Save a team member with image
    public Team saveTeamMember(Team team, MultipartFile photoFile) throws IOException {
        if (photoFile != null && !photoFile.isEmpty()) {
            String savedFileName =FileUploadUtil.saveFile(photoFile);
            team.setPhotoUrl(savedFileName);
        }

        return teamRepository.save(team);
    }

    // List all team members
    public List<Team> getAllTeamMembers() {
        return teamRepository.findAll();
    }

    // Get single team member
    public Team getTeamMemberById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    // Delete
    public void deleteTeamMember(Long id) {
        teamRepository.deleteById(id);
    }

    // Utility method to save image
   
}
