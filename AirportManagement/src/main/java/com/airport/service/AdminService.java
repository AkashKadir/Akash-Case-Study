package com.airport.service;

import java.util.List;

import javax.validation.Valid;

import com.airport.entities.Hangar;
import com.airport.entities.Pilot;
import com.airport.entities.Plane;
import com.airport.entities.Users;

public interface AdminService {
	
	public boolean register(Users user);
	
	public String loginCheck(Integer id, String password);
	
	public boolean addPilot(Pilot pilot);
	
	public List<Pilot> pilotList();
	
	public Pilot viewPilotDetails(Integer id);

	public boolean updatePilotDetails(Pilot pilot,String id);

	public List<Users> managerList();

	public boolean managerApproved(Integer id);

	public boolean managerRejected(Integer id);

	public boolean addPlane(Plane plane);

	public List<Plane> planeList();

	public Plane getPlaneDetails(Integer id);

	public boolean updatePlaneDetails(Plane plane, String id);

	public boolean addHangar(@Valid Hangar hangar);

	public List<Hangar> hangarList();

	public Hangar getHangarDetails(Integer id);

	public boolean updateHangarDetails(@Valid Hangar hangar, String id);
	
}
