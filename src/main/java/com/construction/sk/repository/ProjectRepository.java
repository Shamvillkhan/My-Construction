package com.construction.sk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.construction.sk.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Optional: add custom query methods if needed
}