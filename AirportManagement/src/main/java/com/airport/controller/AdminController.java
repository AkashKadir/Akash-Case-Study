package com.airport.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airport.entities.Hangar;
import com.airport.entities.Pilot;
import com.airport.entities.Plane;
import com.airport.entities.Users;
import com.airport.model.Login;
import com.airport.service.AdminService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	AdminService service;
	
	Hangar hangar;
	Plane plane;
	Pilot pilot;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("admin",new Login());
		model.addAttribute("userType","admin");
		return "login";
	}
	
	@RequestMapping(value = "/logined",method=RequestMethod.POST)
	public String logined(@Valid @ModelAttribute("admin") Login login, BindingResult result,Model model,HttpServletRequest req) {
		if(result.hasErrors()) {
			model.addAttribute("userType","admin");
			model.addAttribute("message","Please update the highlighted mandatory fields");
			return "login";
		}
		else {
			String serviceResult = service.loginCheck(login.getId(), login.getPassword());
			if(serviceResult.equals("allow")) {
				HttpSession session = req.getSession();
				session.setAttribute("Id",login.getId());
				model.addAttribute("userType","admin");
				return "admin";
			}
			else {
				model.addAttribute("userType","admin");
				model.addAttribute("message",serviceResult);
				return "login";
			}
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("Id");
		session.invalidate();
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/register",method=RequestMethod.GET)
	public String register(HttpServletRequest req, Model model) {
			model.addAttribute("admin",new Users());
			model.addAttribute("userType","admin");
			return "register";
	}
	
	@RequestMapping(value = "/registered",method=RequestMethod.POST)
	public String processAdd(@Valid @ModelAttribute("admin") Users users, BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("userType","admin");
			model.addAttribute("message","Please Update the highlighted mandatory fields");
			return "register";		
		}
		else {
			users.setAdmin(1);
			users.setManager(0);
			boolean isRegistered = service.register(users);
			if(isRegistered) {
				model.addAttribute("Idmessage","Your Id is");
				model.addAttribute("Id",users.getUserId());
				model.addAttribute("message","Your details are submitted successfully");	
			}
			else {
				model.addAttribute("message","Something Went wrong!");	
			}
			model.addAttribute("userType","admin");
			return "register";
		}
	}
	
	@RequestMapping(value="/pilot/add", method=RequestMethod.GET)
	public String addPilot(Model model) {
		model.addAttribute("pilot",new Pilot());
		return "pilot";
	}
	
	@RequestMapping(value="/pilot/added",method=RequestMethod.POST)
	public String pilotAdded(@Valid @ModelAttribute("pilot") Pilot pilot,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("message","Please update the mandatory highlighted fields");
			return "pilot";
		}
		else {
			if(service.addPilot(pilot)) {
				model.addAttribute("message","Your details are submitted successfully");
				model.addAttribute("pilot",new Pilot());
				return "pilot";
			}
			else {
				model.addAttribute("message","Something Went wrong!");
				return "pilot";
			}
		}
	}
	@RequestMapping(value="/pilot/updatePilot",method=RequestMethod.POST)
	public String pilotUpdated(@Valid @ModelAttribute("pilot") Pilot pilot1,BindingResult result,Model model,HttpServletRequest req) {
		if(result.hasErrors()) {
			model.addAttribute("message","Please update the mandatory highlighted fields");
			model.addAttribute("updatePilot", new Pilot(pilot.getHighSchoolName(),pilot.getUniversityName(),pilot.getGraduatedYear(),pilot.getGpa(),pilot.getExperience(),pilot.getFirstName(),pilot.getLastName(),pilot.getPilotId()));
			return "updatePilot";
		}
		else {
			if(req.getParameter("id")!=null) {
				service.updatePilotDetails(pilot1,req.getParameter("id"));
				model.addAttribute("message","Your details are updated successfully");
				model.addAttribute("pilot",new Pilot());
				return "pilot";
			}
			else {
				model.addAttribute("message","Something Went wrong!");
				return "updatePilot";
			}
		}
	}
	
	@RequestMapping(value="/pilot/view", method=RequestMethod.GET)
	public String viewPilot(Model model) {
		List<Pilot> listOfPilots = service.pilotList();
		model.addAttribute("listOfPilots",listOfPilots);
		return "viewPilot";
	}
	
	@RequestMapping(value="/pilot/pilotId", method=RequestMethod.GET)
	public String viewPilotDetails(HttpServletRequest req,Model model) {
		Integer id = (Integer.parseInt(req.getParameter("id")));
		Pilot pilotDetail = service.viewPilotDetails(id);
		model.addAttribute("pilotDetail",pilotDetail);
		return "pilotDetails";
	}
	
	@RequestMapping(value="/pilot/addedUpdate",method=RequestMethod.POST)
	public String pilotAddedUpdate(HttpServletRequest req , Model model) {
		model.addAttribute("pilot",new Pilot());
		pilot = new Pilot(req.getParameter("highSchoolName"),req.getParameter("universityName"),req.getParameter("graduatedYear"),Double.parseDouble(req.getParameter("gpa")),Integer.parseInt(req.getParameter("experience")),req.getParameter("firstName"),req.getParameter("lastName"),Integer.parseInt(req.getParameter("pilotId")));
		model.addAttribute("updatePilot",pilot);
		return "updatePilot";
	}
	
	@RequestMapping(value="/manager/viewManagers", method=RequestMethod.GET)
	public String viewManagers(Model model) {
		List<Users> listOfManagers = service.managerList();
		model.addAttribute("listOfManagers",listOfManagers);
		return "viewManagers";
	}
	
	@RequestMapping(value="/manager/managerApproved", method=RequestMethod.GET)
	public String managerApproved(HttpServletRequest req,Model model) {
		Integer id = Integer.parseInt(req.getParameter("id"));
		service.managerApproved(id);
		List<Users> listOfManagers = service.managerList();
		model.addAttribute("listOfManagers",listOfManagers);
		return "viewManagers";
	}
	
	@RequestMapping(value="/manager/managerRejected", method=RequestMethod.GET)
	public String managerRejected(HttpServletRequest req,Model model) {
		Integer id = Integer.parseInt(req.getParameter("id"));
		service.managerRejected(id);
		List<Users> listOfManagers = service.managerList();
		model.addAttribute("listOfManagers",listOfManagers);
		return "viewManagers";
	}
	
	@RequestMapping(value="/plane/add", method=RequestMethod.GET)
	public String planeAdd(Model model) {
		model.addAttribute("plane",new Plane());
		return "addPlane";
	}
	
	@RequestMapping(value="/plane/added", method=RequestMethod.POST)
	public String planeAdded(@Valid @ModelAttribute(value="plane") Plane plane,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("message","Please Upadate the mandatory highlighted fields");
			return "addPlane";
		}else {
			plane.setStatus(0);
			service.addPlane(plane);
			model.addAttribute("message","Your details are submitted successfully");
			model.addAttribute("plane",new Plane());
			return "addPlane";
		}
	}
	
	@RequestMapping(value="/plane/view", method=RequestMethod.GET)
	public String planeView(Model model) {
		List<Plane> planeList = service.planeList();
		model.addAttribute("listOfPlanes",planeList);
		return "viewPlanes";
	}
	
	@RequestMapping(value="/plane/planeId", method=RequestMethod.GET)
	public String planeViewPlaneDetails(HttpServletRequest req,Model model) {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Plane planeDetails = service.getPlaneDetails(id);
		model.addAttribute("planeDetails", planeDetails);
		return "planeDetails";
	}
	
	@RequestMapping(value="/plane/addedUpdate",method=RequestMethod.POST)
	public String planeAddedUpdate(HttpServletRequest req , Model model) {
		model.addAttribute("plane",new Plane());
		model.addAttribute("updatePlane",new Plane(Integer.parseInt(req.getParameter("planeId")),req.getParameter("planeName"),req.getParameter("fromPlace"),req.getParameter("toPlace"),Integer.parseInt(req.getParameter("capacity"))));
		return "updatePlane";
	}
	
	@RequestMapping(value="/plane/updatePlane",method=RequestMethod.POST)
	public String planeUpdated(@Valid @ModelAttribute("plane") Plane plane1,BindingResult result,Model model,HttpServletRequest req) {
		if(result.hasErrors()) {
			model.addAttribute("message","Please update the mandatory highlighted fields");
			model.addAttribute("updatePlane", new Plane(plane.getPlaneId(),plane.getPlaneName(),plane.getFromPlace(),plane.getToPlace(),plane.getCapacity()));
			return "updatePlane";
		}
		else {
			if(req.getParameter("id")!=null) {
				service.updatePlaneDetails(plane1,req.getParameter("id"));
				model.addAttribute("message","Your details are updated successfully");
				model.addAttribute("plane",new Plane());
				return "updatePlane";
			}
			else {
				model.addAttribute("message","Something Went wrong!");
				return "updatePlane";
			}
		}
	}
	
	@RequestMapping(value="/hangar/add", method=RequestMethod.GET)
	public String hangarAdd(Model model) {
		model.addAttribute("hangar",new Hangar());
		return "addHangar";
	}
	
	@RequestMapping(value="/hangar/added", method=RequestMethod.POST)
	public String hangarAdded(@Valid @ModelAttribute(value="hangar") Hangar hangar,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("message","Please Upadate the mandatory highlighted fields");
			return "addHangar";
		}else {
			hangar.setPlane(null);
			hangar.setStatus(0);
			service.addHangar(hangar);
			model.addAttribute("message","Your details are submitted successfully");
			model.addAttribute("hangar",new Hangar());
			return "addHangar";
		}
	}
	
	@RequestMapping(value="/hangar/view", method=RequestMethod.GET)
	public String hangarView(Model model) {
		List<Hangar> hangarList = service.hangarList();
		model.addAttribute("listOfHangar",hangarList);
		return "viewHangar";
	}
	
	@RequestMapping(value="/hangar/hangarId", method=RequestMethod.GET)
	public String hangarDetails(HttpServletRequest req,Model model) {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Hangar hangarDetails = service.getHangarDetails(id);
		model.addAttribute("hangarDetails", hangarDetails);
		return "hangarDetails";
	}
	
	@RequestMapping(value="/hangar/addedUpdate",method=RequestMethod.POST)
	public String hangarAddedUpdate(HttpServletRequest req , Model model) {
		model.addAttribute("hangar",new Hangar());
		hangar = new Hangar(Integer.parseInt(req.getParameter("hangarId")),Double.parseDouble(req.getParameter("length")),Double.parseDouble(req.getParameter("width")),Double.parseDouble(req.getParameter("height")));
		model.addAttribute("updateHangar",hangar);
		return "updateHangar";
	}
	
	@RequestMapping(value="/hangar/updateHangar",method=RequestMethod.POST)
	public String hangarUpdated(@Valid @ModelAttribute("hangar") Hangar hangar1,BindingResult result,Model model,HttpServletRequest req) {
		if(result.hasErrors()) {
			model.addAttribute("message","Please update the mandatory highlighted fields");
			model.addAttribute("updateHangar",new Hangar(hangar.getHangarId(),hangar.getLength(),hangar.getWidth(),hangar.getHeight()));
			return "updateHangar";
		}
		else {
			if(req.getParameter("id")!=null) {
				service.updateHangarDetails(hangar1,req.getParameter("id"));
				model.addAttribute("message","Your details are updated successfully");
				model.addAttribute("hangar",new Hangar());
				return "updateHangar";
			}
			else {
				model.addAttribute("message","Something Went wrong!");
				return "updateHangar";
			}
		}
	}
	
}
