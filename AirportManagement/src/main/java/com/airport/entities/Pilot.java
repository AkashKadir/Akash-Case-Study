package com.airport.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Pilot {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pilotId;
	@NotNull(message="Enter First Name")
	private String firstName;
	@NotNull(message="Enter Last Name")
	private String lastName;
	@NotBlank(message="Enter High School Name")
	private String highSchoolName;
	@NotNull(message="Enter University Name")
	private String universityName;
	@NotNull(message="Enter Graduated Year")
	private String graduatedYear;
	@NotNull(message="Enter GPA")
	@Max(value=5,message="Enter GPA below 5")
	private Double gpa;
	@NotNull(message="Enter experience")
	private Integer experience;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getPilotId() {
		return pilotId;
	}
	public void setPilotId(Integer pilotId) {
		this.pilotId = pilotId;
	}
	public String getHighSchoolName() {
		return highSchoolName;
	}
	public void setHighSchoolName(String highSchoolName) {
		this.highSchoolName = highSchoolName;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getGraduatedYear() {
		return graduatedYear;
	}
	public void setGraduatedYear(String graduatedYear) {
		this.graduatedYear = graduatedYear;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public Pilot(String highSchoolName,String universityName,String graduatedYear,Double gpa,Integer experience,String firstName,String lastName,Integer pilotId) {
		super();
		this.highSchoolName = highSchoolName;
		this.firstName=firstName;
		this.lastName=lastName;
		this.universityName = universityName;
		this.graduatedYear = graduatedYear;
		this.gpa = gpa;
		this.experience = experience;
		this.pilotId=pilotId;
	}
	
	public Pilot() {}
	
}
