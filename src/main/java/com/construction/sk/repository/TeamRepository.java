package com.construction.sk.repository;

import com.construction.sk.entity.Team; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
