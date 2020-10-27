package com.airport.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.dao.ManagerDao;
import com.airport.entities.Hangar;
import com.airport.entities.Plane;
import com.airport.entities.Users;

@Service
public class ManagerServiceImpl implements ManagerService{

	@Autowired
	ManagerDao dao;
	
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
	public List<Hangar> getHangars() {
		return dao.getHangars();
	}

	@Override
	public List<Plane> getPlanes() {
		return dao.getPlanes();
	}

	@Override
	public boolean hangarAndPlaneAlloted(Integer hangarAllotedId, Integer planeAllotedId) {
		return dao.hangarAndPlaneAlloted(hangarAllotedId,planeAllotedId);
	}

	@Override
	public List<Hangar> viewHangars() {
		return dao.viewHangars();
	}

}
