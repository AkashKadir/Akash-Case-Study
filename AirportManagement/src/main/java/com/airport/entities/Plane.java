package com.airport.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Plane {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer planeId;
	@NotNull(message="Enter Plane Name")
	private String planeName;
	@NotNull(message="Enter From place")
	private String fromPlace;
	@NotNull(message="Enter To place")
	private String toPlace;
	@NotNull(message="Enter Capacity")
	private Integer capacity;
	private Integer status;
	
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	public Integer getPlaneId() {
		return planeId;
	}
	public void setPlaneId(Integer planeId) {
		this.planeId = planeId;
	}
	public String getPlaneName() {
		return planeName;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Plane(Integer planeId,String planeName,String fromPlace,String toPlace,Integer capacity) {
		super();
		this.planeId = planeId;
		this.planeName = planeName;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.capacity = capacity;
	}
	
	public Plane(){};
	
}
