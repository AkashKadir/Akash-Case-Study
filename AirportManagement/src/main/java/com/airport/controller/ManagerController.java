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
import com.airport.entities.Plane;
import com.airport.entities.Users;
import com.airport.model.Login;
import com.airport.service.ManagerService;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController {
	
	@Autowired
	ManagerService service;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("manager",new Login());
		model.addAttribute("userType","manager");
		return "login";
	}
	
	@RequestMapping(value = "/logined",method=RequestMethod.POST)
	public String logined(@Valid @ModelAttribute("manager") Login login, BindingResult result,Model model,HttpServletRequest req) {
		if(result.hasErrors()) {
			model.addAttribute("userType","manager");
			model.addAttribute("message","Please update the highlighted mandatory fields");
			return "login";
		}
		else {
			String serviceResult = service.loginCheck(login.getId(), login.getPassword());
			if(serviceResult.equals("allow")) {
				HttpSession session = req.getSession();
				session.setAttribute("Id",login.getId());
				model.addAttribute("userType","manager");
				return "manager";
			}
			else {
				model.addAttribute("userType","manager");
				model.addAttribute("message",serviceResult);
				return "login";
			}
		}
	}
	
	@RequestMapping(value = "/register",method=RequestMethod.GET)
	public String register( Model model) {
		model.addAttribute("manager",new Users());
		model.addAttribute("userType","manager");
		return "register";
	}
	
	@RequestMapping(value = "/registered",method=RequestMethod.POST)
	public String processAdd(@Valid @ModelAttribute("manager") Users users, BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("userType","manager");
			model.addAttribute("message","Please Update the highlighted mandatory fields");
			return "register";		
		}
		else {
			users.setAdmin(0);
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
			model.addAttribute("userType","manager");
			return "register";
		}
	}
	
	@RequestMapping(value="/allotHangar",method=RequestMethod.GET)
	public String allotHangar(Model model) {
		List<Hangar> hangers = service.getHangars();
		List<Plane> planes = service.getPlanes();
		model.addAttribute("hangars",hangers);
		model.addAttribute("planes",planes);
		model.addAttribute("hangar",new Hangar());
		return "allotHangar";
	}
	
	@RequestMapping(value="/allotPlaneWithHangar", method=RequestMethod.POST)
	public String allotPlaneWithHangar(HttpServletRequest req,Model model) {
		if(req.getParameter("hangar")==null) {
			List<Hangar> hangers = service.getHangars();
			List<Plane> planes = service.getPlanes();
			model.addAttribute("hangars",hangers);
			model.addAttribute("planes",planes);
			model.addAttribute("hangar",new Hangar());
			model.addAttribute("message","Ther is no Hangar to allot");
			return "allotHangar";
		}
		else if(req.getParameter("plane")==null) {
			List<Hangar> hangers = service.getHangars();
			List<Plane> planes = service.getPlanes();
			model.addAttribute("hangars",hangers);
			model.addAttribute("planes",planes);
			model.addAttribute("hangar",new Hangar());
			model.addAttribute("message","Ther is no plane to waiting");
			return "allotHangar";
		}
		else if((req.getParameter("hangar")==null)&&(req.getParameter("plane")==null)) {
			List<Hangar> hangers = service.getHangars();
			List<Plane> planes = service.getPlanes();
			model.addAttribute("hangars",hangers);
			model.addAttribute("planes",planes);
			model.addAttribute("hangar",new Hangar());
			model.addAttribute("message","Ther is no Hangar and Plane to allot");
			return "allotHangar";
		}
		else {
			Integer hangarAllotedId = Integer.parseInt(req.getParameter("hangar"));
			Integer planeAllotedId = Integer.parseInt(req.getParameter("plane"));
			service.hangarAndPlaneAlloted(hangarAllotedId,planeAllotedId);
			List<Hangar> hangers = service.getHangars();
			List<Plane> planes = service.getPlanes();
			model.addAttribute("hangars",hangers);
			model.addAttribute("planes",planes);
			model.addAttribute("hangar",new Hangar());
			model.addAttribute("message","Plane is alloted with a Hangar");
			return "allotHangar";
		}
	}
	
	@RequestMapping(value="/viewHangar", method=RequestMethod.GET)
	public String viewHangar(Model model) {
		List<Hangar> listOfViewHangars = service.viewHangars();
		model.addAttribute("listOfViewHangars", listOfViewHangars);
		return "viewManagerHangar";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("Id");
		session.invalidate();
		return "redirect:/home";
	}
	
}
