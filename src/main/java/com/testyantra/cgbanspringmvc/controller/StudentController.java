package com.testyantra.cgbanspringmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.testyantra.cgbanspringmvc.beans.StudentInfo;
import com.testyantra.cgbanspringmvc.beans.StudentOtherInfo;
import com.testyantra.cgbanspringmvc.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@GetMapping("/register")
	public String registerStudentForm() {
		return "form";
	}
	
	@PostMapping("/register")
	public String registerStudent(StudentInfo info, StudentOtherInfo otherInfo, ModelMap map) {
		if(service.addStudent(info, otherInfo)) {
			map.addAttribute("msg", "Student is registered");
		}else {
			map.addAttribute("msg", "Student id already exist");
		}
		return "login";
	}
	
	@GetMapping("/login")
	public String loginPage(@SessionAttribute(name = "info", required = false)
															StudentInfo info) {
		if(info==null)
			return "login";
		return "home";
	}
	
	@PostMapping("/login")
	public String login(int id, String password, ModelMap map, HttpServletRequest request) {
		StudentInfo info = service.auth(id, password);
		if(info!=null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("info", info);
			return "home";
		}
		else {
			map.addAttribute("msg", "invalid credencials");
			return "login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect: login";
	}
	
	@GetMapping("/edit")
	public String editStudentForm(@SessionAttribute(name = "info", required = false)
																StudentInfo info) {
		if(info==null) {
			return "login";
		}
		return "editstudent";
	}
	
	@PostMapping("/edit")
	public String editStudent(StudentInfo info, StudentOtherInfo otherInfo, HttpSession session) {
		service.editStudent(info, otherInfo);
		session.setAttribute("info", service.auth(info.getId(), otherInfo.getPassword()));
		return "redirect: login";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@SessionAttribute("info") StudentInfo info, HttpSession session) {
		service.deleteStudent(info);
		session.invalidate();
		return "redirect: login";
	}
	
}
