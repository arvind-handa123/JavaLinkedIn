package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "linkedinprofile")
@Table(name = "linkedinprofile")
public class LinkedInProfile {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	private String publicProfileURL;
	private String name;
	private String lastName;
	private String title;
	private String geographicArea;
	private int numberOfRecommendations;
	private int numberOfConnections;
	private String currentRole;
	private String industry;
	private String country;

	public LinkedInProfile() {
		super();
	}

	public LinkedInProfile(String publicProfileURL, String name, String lastName, String title, String geographicArea,
			int numberOfRecommendations, int numberOfConnections, String currentRole, String industry, String country) {
		super();
		this.publicProfileURL = publicProfileURL;
		this.name = name;
		this.lastName = lastName;
		this.title = title;
		this.geographicArea = geographicArea;
		this.numberOfRecommendations = numberOfRecommendations;
		this.numberOfConnections = numberOfConnections;
		this.currentRole = currentRole;
		this.industry = industry;
		this.country = country;
	}

	public LinkedInProfile(long id, String publicProfileURL, String name, String lastName, String title,
			String geographicArea, int numberOfRecommendations, int numberOfConnections, String currentRole,
			String industry, String country) {
		super();
		this.id = id;
		this.publicProfileURL = publicProfileURL;
		this.name = name;
		this.lastName = lastName;
		this.title = title;
		this.geographicArea = geographicArea;
		this.numberOfRecommendations = numberOfRecommendations;
		this.numberOfConnections = numberOfConnections;
		this.currentRole = currentRole;
		this.industry = industry;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPublicProfileURL() {
		return publicProfileURL;
	}

	public void setPublicProfileURL(String publicProfileURL) {
		this.publicProfileURL = publicProfileURL;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGeographicArea() {
		return geographicArea;
	}

	public void setGeographicArea(String geographicArea) {
		this.geographicArea = geographicArea;
	}

	public int getNumberOfRecommendations() {
		return numberOfRecommendations;
	}

	public void setNumberOfRecommendations(int numberOfRecommendations) {
		this.numberOfRecommendations = numberOfRecommendations;
	}

	public int getNumberOfConnections() {
		return numberOfConnections;
	}

	public void setNumberOfConnections(int numberOfConnections) {
		this.numberOfConnections = numberOfConnections;
	}

	public String getCurrentRole() {
		return currentRole;
	}

	public void setCurrentRole(String currentRole) {
		this.currentRole = currentRole;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
