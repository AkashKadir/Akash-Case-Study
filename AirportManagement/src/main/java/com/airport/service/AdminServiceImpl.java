package com.airport.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.dao.AdminDao;
import com.airport.entities.Hangar;
import com.airport.entities.Pilot;
import com.airport.entities.Plane;
import com.airport.entities.Users;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao dao;
	
	@Override
	@Transactional
	public boolean register(Users users) {
		return dao.register(users);
	}

	@Override
	public String loginCheck(Integer id, String password) {
		return dao.loginCheck(id, password);
	}

	@Override
	public boolean addPilot(Pilot pilot) {
		return dao.addPilot(pilot);
	}

	@Override
	public List<Pilot> pilotList() {
		return dao.pilotList();
	}

	@Override
	public Pilot viewPilotDetails(Integer id) {
		return dao.viewPilotDetails(id);
	}

	@Override
	public boolean updatePilotDetails(Pilot pilot,String id) {
		return dao.updatePilotDetails(pilot,id);
	}

	@Override
	public List<Users> managerList() {
		return dao.managerList();
	}

	@Override
	public boolean managerApproved(Integer id) {
		return dao.managerApproved(id);
	}

	@Override
	public boolean managerRejected(Integer id) {
		return dao.managerRejected(id);
	}

	@Override
	public boolean addPlane(Plane plane) {
		return dao.addPlane(plane);
	}

	@Override
	public List<Plane> planeList() {
		return dao.planeList();
	}

	@Override
	public Plane getPlaneDetails(Integer id) {
		return dao.getPlaneDetails(id);
	}

	@Override
	public boolean updatePlaneDetails(Plane plane, String id) {
		return dao.updatePlaneDetails(plane,id);
	}

	@Override
	public boolean addHangar(@Valid Hangar hangar) {
		return dao.addHangar(hangar);
	}

	@Override
	public List<Hangar> hangarList() {
		return dao.hangarList();
	}

	@Override
	public Hangar getHangarDetails(Integer id) {
		return dao.getHangarDetails(id);
	}

	@Override
	public boolean updateHangarDetails(@Valid Hangar hangar, String id) {
		return dao.updateHangarDetails(hangar,id);
	}
	
	

}
