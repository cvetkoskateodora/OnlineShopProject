package com.onlineshop.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlineshop.model.users;
import com.onlineshop.service.usersService;

@Controller
public class usersController {

	private final usersService userservice;

	public usersController(usersService userservice) {
		this.userservice = userservice;
	}

	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("registerRequest", new users());
		return "register_page";
	}

	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("loginRequest", new users());
		return "login_page";
	}
	@GetMapping("/login2")
	public String getSellerLoginPage(Model model) {
		model.addAttribute("loginRequest", new users());
		return "login_page2";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute users users) {
		System.out.println("register request: " + users);
		users registereduser = userservice.registeruser(users.getUsername(), users.getEmail(), users.getPassword(),
				users.getRegisteras());
		return registereduser == null ? "error_page" : "redirect:/login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute users users, Model model) {
		System.out.println("login request: " + users);
		users authenticated = userservice.authenticate(users.getEmail(), users.getPassword());
		if (authenticated != null) {
			model.addAttribute("userLogin", authenticated.getUsername());
			return "buyer";
		} else {
			return "error_page";
		}
	}
	@PostMapping("/login2")
	public String login2(@ModelAttribute users users, Model model) {
		System.out.println("login request: " + users);
		users authenticated = userservice.authenticate(users.getEmail(), users.getPassword());
		if (authenticated != null) {
			model.addAttribute("userLogin", authenticated.getUsername());
			return "seller";
		} else {
			return "error_page";
		}
	}

}