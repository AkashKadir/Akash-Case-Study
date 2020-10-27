package com.airport.dao;

import java.util.List;

import javax.sql.DataSource;

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
public class ManagerDaoImpl implements ManagerDao{
	
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
		else if((user.getManager()==1)&&(user.getPassword().equals(password))) {
			return "allow";
		}
		else if((user.getAdmin()==1)) {
			return "Invalid! User Needs a registration";
		}
		else if((user.getManager()==0)) {
			return "Your Request is in waiting stage";
		}
		else {
			return "Entered password is wrong";
		}
	}

	@Override
	public List<Hangar> getHangars() {
		Session session=factory.openSession();
		Criteria cr = session.createCriteria(Hangar.class);
		cr.add(Restrictions.eq("status",0));
		List<Hangar> listOfHangars = cr.list();
		return listOfHangars;
	}

	@Override
	public List<Plane> getPlanes() {
		Session session=factory.openSession();
		Criteria cr = session.createCriteria(Plane.class);
		cr.add(Restrictions.eq("status",0));
		List<Plane> listOfPlanes = cr.list();
		return listOfPlanes;
	}

	@Override
	public boolean hangarAndPlaneAlloted(Integer hangarAllotedId, Integer planeAllotedId) {
		Session session1=factory.openSession();
		Transaction transaction1 = session1.beginTransaction();
		Query<Plane> q1=session1.createQuery("update Plane p set status=:s where p.planeId=:i");  
		q1.setParameter("s",1);
		q1.setParameter("i",planeAllotedId);
		int status1=q1.executeUpdate();
		transaction1.commit();
		session1.close();
		
		Session session2=factory.openSession();
		Criteria cr = session2.createCriteria(Plane.class);
		cr.add(Restrictions.eq("planeId", planeAllotedId));
		Plane planeDetail = (Plane)cr.uniqueResult();
		session2.close();
		
		Session session=factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<Hangar> q=session.createQuery("update Hangar h set status=:s,plane=:p where h.hangarId=:i");  
		q.setParameter("s",1);  
		q.setParameter("p",planeDetail);
		q.setParameter("i",hangarAllotedId);
		int status=q.executeUpdate();
		transaction.commit();
		session.close();
		if(status>0&&status1>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Hangar> viewHangars() {
		Session session=factory.openSession();
		Criteria cr = session.createCriteria(Hangar.class);
		List<Hangar> listOfViewHangars = cr.list();
		return listOfViewHangars;
	}
	
}
