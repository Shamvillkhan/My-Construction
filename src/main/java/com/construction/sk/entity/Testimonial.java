package com.construction.sk.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="testimonials")
public class Testimonial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="client_name")
    private String clientName;

    @Column(name="message")
    private String message;

    @Column(name="photo")
    private String photo; // original file name

    @Column(name="image_path")
    private String imagePath; // full saved path (uploads/testimonials/12345_xyz.jpg)

    @Column(name="created_at")
    private LocalDateTime createdAt;

    
    
	public Testimonial() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Testimonial(Long id, String clientName, String message, String photo, String imagePath,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.message = message;
		this.photo = photo;
		this.imagePath = imagePath;
		this.createdAt = createdAt;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getClientName() {
		return clientName;
	}



	public void setClientName(String clientName) {
		this.clientName = clientName;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public String getImagePath() {
		return imagePath;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	@Override
	public String toString() {
		return "Testimonial [id=" + id + ", clientName=" + clientName + ", message=" + message + ", photo=" + photo
				+ ", imagePath=" + imagePath + ", createdAt=" + createdAt + "]";
	}

	
    
}
