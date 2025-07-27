package com.construction.sk.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "_gallery")
public class Gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="image_path")
    private String imagePath;
    @Column(name="image_name")
    private String imageName;

    @Column(name="category")
    private String category;

    // Constructors
    public Gallery() {}
    
    

	public Gallery(Long id, String title, String imagePath, String imageName, String category) {
		super();
		this.id = id;
		this.title = title;
		this.imagePath = imagePath;
		this.imageName = imageName;
		this.category = category;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	@Override
	public String toString() {
		return "Gallery [id=" + id + ", title=" + title + ", imagePath=" + imagePath + ", imageName=" + imageName
				+ ", category=" + category + "]";
	}
	
	
     
}
