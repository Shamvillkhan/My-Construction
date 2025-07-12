package com.construction.sk.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contact_us")
public class Contactus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	private String name;
	
	private String email;
	
	private String message;
	
	private LocalDateTime sentAt;
	
	

	public Contactus() {
		super();
	}



	public Contactus(Long id, String name, String email, String message, LocalDateTime sentAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.message = message;
		this.sentAt = sentAt;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public LocalDateTime getSentAt() {
		return sentAt;
	}



	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}



	@Override
	public String toString() {
		return "Contactus [id=" + id + ", name=" + name + ", email=" + email + ", message=" + message + ", sentAt="
				+ sentAt + "]";
	}
	
	
	
	
	
	

}
