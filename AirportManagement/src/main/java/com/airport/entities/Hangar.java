package com.airport.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Hangar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer hangarId;
	@NotNull(message="Enter the Length")
	@Min(value=200,message="Entered value is below 200")
	private Double length;
	@NotNull(message="Enter Width")
	private Double width;
	@NotNull(message="Enter Height")
	private Double height;
	private Integer status;
	@OneToOne
	private Plane plane;
	public Integer getHangarId() {
		return hangarId;
	}
	public void setHangarId(Integer hangarId) {
		this.hangarId = hangarId;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	public Hangar(Integer hangarId, Double length, Double width, Double height) {
		super();
		this.hangarId = hangarId;
		this.length = length;
		this.width = width;
		this.height = height;
	}
	
	public Hangar() {}
	
}
