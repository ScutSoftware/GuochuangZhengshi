package com.lis.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lis.model.User;
import com.lis.service.UserService;

@Controller
@RequestMapping("user/")
@SessionAttributes("user")
public class UserController {

	@Autowired
	public UserService userService;

	@RequestMapping(value = "loginIn", method = RequestMethod.POST)
	public String login(Model model,
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		System.out.println(username);
		User user = userService.getByPK(username);
		System.out.println(user);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				model.addAttribute("user", user);
				return "redirect:/home";
			} else
				model.addAttribute("error", "瀵嗙爜閿欒锛?");
			return "/login";
		}
		model.addAttribute("error", "鐢ㄦ埛涓嶅瓨鍦?");
		return "/login";
	}


	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") @Valid User user,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/register";
		}
		System.out.println(user);
		userService.save(user);
		return "redirect:list";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(@ModelAttribute("user") User user, Model model) {

		model.addAttribute("userList", userService.list());
		return "user/list";
	}

	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}

}
