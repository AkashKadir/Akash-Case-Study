package com.airport.dao;

import java.util.List;

import com.airport.entities.Hangar;
import com.airport.entities.Plane;
import com.airport.entities.Users;

public interface ManagerDao {
	
public boolean register(Users users);
	
	public String loginCheck(Integer id,String password);

	public List<Hangar> getHangars();

	public List<Plane> getPlanes();

	public boolean hangarAndPlaneAlloted(Integer hangarAllotedId, Integer planeAllotedId);

	public List<Hangar> viewHangars();
	
}
