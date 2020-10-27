package com.airport.dao;

import java.util.List;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.airport.entities.Hangar;
import com.airport.entities.Pilot;
import com.airport.entities.Plane;
import com.airport.entities.Users;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	DataSource datasource;
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public boolean register(Users users) {
		boolean b=false;
		Session session=factory.openSession();
		Integer i=(Integer)session.save(users);
		if(i==users.getUserId())
			b=true;
		session.close();
		return b;
	}

	@Override
	public String loginCheck(Integer id, String password) {
		Session session=factory.openSession();
		Criteria cr = session.createCriteria(Users.class);
		cr.add(Restrictions.eq("userId", id));
		Users user = (Users)cr.uniqueResult();
		if(user==null) {
			return "User needs a registration";
		}
		else {
			if(user.getPassword().equals(password)) {
				return "allow";
			}else {
				return "Entered password is wrong";
			}
		}
	}

	@Override
	public boolean addPilot(Pilot pilot) {
		boolean b=false;
		Session session=factory.openSession();
		Integer i=(Integer)session.save(pilot);
		if(i==pilot.getPilotId())
			b=true;
		session.close();
		return b;
	}

	@Override
	public List<Pilot> pilotList() {
		Session session=factory.openSession();
		Criteria cr = session.createCriteria(Pilot.class);
		List<Pilot> listOfPilots = cr.list();
		return listOfPilots;
	}

	@Override
	public Pilot viewPilotDetails(Integer id) {
		Session session=factory.openSession();
		Criteria cr = session.createCriteria(Pilot.class);
		cr.add(Restrictions.eq("pilotId", id));
		Pilot pilotDetail = (Pilot)cr.uniqueResult();
		return pilotDetail;
	}

	@Override
	public boolean updatePilotDetails(Pilot pilot,String id) {
		Session session=factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Pilot> q=session.createQuery("update Pilot p set p.experience=:e,p.firstName=:f,p.gpa=:g,p.graduatedYear=:gy,p.highSchoolName=:hsn,p.lastName=:l,p.universityName=:u where p.pilotId=:i");  
		q.setParameter("e",pilot.getExperience());  
		q.setParameter("f",pilot.getFirstName());  
		q.setParameter("g",pilot.getGpa());  
		q.setParameter("gy",pilot.getGraduatedYear());  
		q.setParameter("hsn",pilot.getHighSchoolName());  
		q.setParameter("l",pilot.getLastName());  
		q.setParameter("u",pilot.getUniversityName());  
		q.setParameter("i",Integer.parseInt(id));
		int status=q.executeUpdate();
		transaction.commit();
		session.close();
		if(status>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Users> managerList() {
		Session session=factory.openSession();
		Criteria cr = session.createCriteria(Users.class);
		cr.add(Restrictions.eq("admin",0));
		cr.add(Restrictions.eq("manager",0));
		List<Users> listOfManagers = cr.list();
		return listOfManagers;
	}

	@Override
	public boolean managerApproved(Integer id) {
		Session session=factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Users> q=session.createQuery("update Users u set u.manager=:m where userId=:i");
		q.setParameter("m",1);  
		q.setParameter("i",id); 
		int status=q.executeUpdate();
		transaction.commit();
		session.close();
		if(status>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean managerRejected(Integer id) {
		Session session=factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Users> q=session.createQuery("delete from Users u where userId=:i");
		q.setParameter("i",id); 
		int status=q.executeUpdate();
		transaction.commit();
		session.close();
		if(status>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean addPlane(Plane plane) {
		boolean b=false;
		Session session=factory.openSession();
		Integer i=(Integer)session.save(plane);
		if(i==plane.getPlaneId())
			b=true;
		session.close();
		return b;
	}

	@Override
	public List<Plane> planeList() {
		Session session=factory.openSession();
		Criteria cr = session.createCriteria(Plane.class);
		List<Plane> listOfPlanes = cr.list();
		return listOfPlanes;
	}

	@Override
	public Plane getPlaneDetails(Integer id) {
		Session session=factory.openSession();
		Criteria cr = session.createCriteria(Plane.class);
		cr.add(Restrictions.eq("planeId", id));
		Plane planeDetail = (Plane)cr.uniqueResult();
		return planeDetail;
	}

	@Override
	public boolean updatePlaneDetails(Plane plane, String id) {
		Session session=factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Plane> q=session.createQuery("update Plane p set p.planeName=:n,p.fromPlace=:f,p.toPlace=:t,p.capacity=:c where p.planeId=:i");  
		q.setParameter("n",plane.getPlaneName());  
		q.setParameter("f",plane.getFromPlace());  
		q.setParameter("t",plane.getToPlace());  
		q.setParameter("c",plane.getCapacity()); 
		q.setParameter("i",Integer.parseInt(id));
		int status=q.executeUpdate();
		transaction.commit();
		session.close();
		if(status>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean addHangar(@Valid Hangar hangar) {
		boolean b=false;
		Session session=factory.openSession();
		Integer i=(Integer)session.save(hangar);
		if(i==hangar.getHangarId())
			b=true;
		session.close();
		return b;
	}

	@Override
	public List<Hangar> hangarList() {
		Session session=factory.openSession();
		Criteria cr = session.createCriteria(Hangar.class);
		List<Hangar> listOfHangar = cr.list();
		return listOfHangar;
	}

	@Override
	public Hangar getHangarDetails(Integer id) {
		Session session=factory.openSession();
		Criteria cr = session.createCriteria(Hangar.class);
		cr.add(Restrictions.eq("hangarId", id));
		Hangar hangarDetail = (Hangar)cr.uniqueResult();
		return hangarDetail;
	}

	@Override
	public boolean updateHangarDetails(@Valid Hangar hangar, String id) {
		Session session=factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Plane> q=session.createQuery("update Hangar h set h.length=:l,h.width=:w,h.height=:he where h.hangarId=:i");  
		q.setParameter("l",hangar.getLength());  
		q.setParameter("w",hangar.getWidth());  
		q.setParameter("he",hangar.getHeight());
		q.setParameter("i",Integer.parseInt(id));
		int status=q.executeUpdate();
		transaction.commit();
		session.close();
		if(status>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
}
