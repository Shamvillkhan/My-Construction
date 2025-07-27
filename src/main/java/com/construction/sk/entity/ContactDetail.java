package com.construction.sk.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "_contact_details")
public class ContactDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="location")
    private String location;
    
    @Column(name="contact_number")
    private String phone;
    @Column(name="email")
    private String email;
    @Column(name="website")
    private String website;

    @Column(name="active",nullable = false)
    private boolean active ;
    
    @Column(name="created_at")
    private LocalDateTime createdAt;

    public ContactDetail() {}

	public ContactDetail(Long id, String location, String phone, String email, String website, boolean active,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.location = location;
		this.phone = phone;
		this.email = email;
		this.website = website;
		this.active = active;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ContactDetail [id=" + id + ", location=" + location + ", phone=" + phone + ", email=" + email
				+ ", website=" + website + ", active=" + active + ", createdAt=" + createdAt + "]";
	}

    
    
    
}
