package com.lis.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lis.model.User;

@Controller
public class HomeController {
	
	@RequestMapping("/home") 
	public String home() {
		
		return "/home";	
	}
	
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}
	
	@RequestMapping("/register")
	public String register(@Valid User user) {
		return "/register";
	}
	
}
