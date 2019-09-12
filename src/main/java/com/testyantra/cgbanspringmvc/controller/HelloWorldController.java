package com.testyantra.cgbanspringmvc.controller;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.testyantra.cgbanspringmvc.beans.StudentInfo;
import com.testyantra.cgbanspringmvc.beans.StudentOtherInfo;

@Controller
@RequestMapping(path = "/hello")
public class HelloWorldController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(path = "/query", method = RequestMethod.GET)
	public String query(@RequestParam("name") String name,
			@RequestParam("age") int age, ModelMap map) {
		map.addAttribute("name",name);
		map.addAttribute("age", age);
		return "index";
	}
	
	@RequestMapping(path = "/path/{name}/{age}", method = RequestMethod.GET)
	public String path(@PathVariable("name") String name,
			@PathVariable("age") int age, ModelMap map) {
		map.addAttribute("name",name);
		map.addAttribute("age", age);
		return "index";
	}
	
	@RequestMapping(path = "/form", method = RequestMethod.GET)
	public String formPage() {
		return "form";
	}
	
	@RequestMapping(path = "/form", method = RequestMethod.POST)
	public String form(StudentInfo info, StudentOtherInfo otherInfo, ModelMap map) {
		
		map.addAttribute("id", info.getId());
		map.addAttribute("name", info.getName());
		map.addAttribute("age", info.getAge());
		map.addAttribute("dob", info.getDob().toString());
		map.addAttribute("email", otherInfo.getEmail());
		map.addAttribute("password", otherInfo.getPassword());
		return "formdata";
	}
	
	@GetMapping(path = "/addcookie")
	public String addCookie(HttpServletResponse response, ModelMap map) {
		Cookie cookie = new Cookie("name", "Kajal_Agarval");
		response.addCookie(cookie);
		map.addAttribute("msg", "Cookie added to the browser");
		return "cookie";
	}
	
	@GetMapping(path = "/getcookie")
	public String getCookie(@CookieValue(name = "name", required = false) String cookie, ModelMap map) {
		if(cookie==null) {
			map.addAttribute("msg", "Cookie doesn't exist");
		}else {
			map.addAttribute("msg", cookie);
		}
		return "cookie";
	}
}









