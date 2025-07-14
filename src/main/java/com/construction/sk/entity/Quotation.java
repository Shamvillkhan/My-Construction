package com.construction.sk.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "quotations")
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;

    @Column(name="estimate_budget")
    private BigDecimal estimatedBudget;

    @Column(name="details")
    private String details;
    
    @Column(name="created_at")
    private LocalDateTime createdAt;
    
    @Column(name="project")
    private String project;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public BigDecimal getEstimatedBudget() {
		return estimatedBudget;
	}

	public void setEstimatedBudget(BigDecimal estimatedBudget) {
		this.estimatedBudget = estimatedBudget;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Quotation(int id, Users user, BigDecimal estimatedBudget, String details, LocalDateTime createdAt,
			String project) {
		super();
		this.id = id;
		this.user = user;
		this.estimatedBudget = estimatedBudget;
		this.details = details;
		this.createdAt = createdAt;
		this.project = project;
	}

	public Quotation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Quotation [id=" + id + ", user=" + user + ", estimatedBudget=" + estimatedBudget + ", details="
				+ details + ", createdAt=" + createdAt + ", project=" + project + "]";
	}

    // Getters and Setters
    
}
