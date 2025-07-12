package com.construction.sk.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    
    @Column(name="name")
    private String name;
    @Column(name="position")
    private String position;
    @Column(name="about")
    private String about;
    @Column(name="photo_url")
    private String photoUrl;

    @Column(name="facebook_url")
    private String facebookUrl;
    @Column(name="twitter_url")
    private String twitterUrl;
    @Column(name="linkedin_url")
    private String linkedinUrl;
    

    public Team(Long id, String name, String position, String about, String photoUrl, String facebookUrl,
			String twitterUrl, String linkedinUrl) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.about = about;
		this.photoUrl = photoUrl;
		this.facebookUrl = facebookUrl;
		this.twitterUrl = twitterUrl;
		this.linkedinUrl = linkedinUrl;
	}
    
    public Team() {
		super();
		// TODO Auto-generated constructor stub
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", position=" + position + ", about=" + about + ", photoUrl="
				+ photoUrl + ", facebookUrl=" + facebookUrl + ", twitterUrl=" + twitterUrl + ", linkedinUrl="
				+ linkedinUrl + "]";
	}
    
    
}
