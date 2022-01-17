package com.onlineshop.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/mencategory")
	public String mencategory() {
		return "mencategory";
	}
	@RequestMapping("/womencategory")
	public String womencategory() {
		return "womencategory";
	}
	@RequestMapping("/kidscategory")
	public String kidscategory() {
		return "kidscategory";
	}
	@RequestMapping("/buyer")
	public String buyer() {
		return "buyer";
	}
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
	@RequestMapping("/category")
	public String category() {
		return "category";
	}
	@RequestMapping("/social")
	public String social() {
		return "social";
	}
	@RequestMapping("/aboutus")
	public String aboutus() {
		return "aboutus";
	}
	@RequestMapping("/faq")
	public String faq() {
		return "faq";
	}
	@RequestMapping("/detail")
	public String detail() {
		return "detail";
	}
	@RequestMapping("/shoppingcart")
	public String shoppingcart() {
		return "shoppingcart";
	}
	@RequestMapping("/checkout1")
	public String checkout1() {
		return "checkout1";
	}
	@RequestMapping("/checkout2")
	public String checkout2() {
		return "checkout2";
	}
	@RequestMapping("/checkout3")
	public String checkout3() {
		return "checkout3";
	}
	@RequestMapping("/checkout4")
	public String checkout4() {
		return "checkout4";
	}
	@RequestMapping("/aboutus_seller")
	public String aboutus_seller() {
		return "aboutus_seller";
	}
	@RequestMapping("/category_seller")
	public String category_seller() {
		return "category_seller";
	}
	@RequestMapping("/contact_seller")
	public String contact_seller() {
		return "contact_seller";
	}
	@RequestMapping("/faq_seller")
	public String faq_seller() {
		return "faq_seller";
	}
	@RequestMapping("/kidscategory_seller")
	public String kidscategory_seller() {
		return "kidscategory_seller";
	}
	@RequestMapping("/mencategory_seller")
	public String mencategory_seller() {
		return "mencategory_seller";
	}
	@RequestMapping("/womencategory_seller")
	public String womencategory_seller() {
		return "womencategory_seller";
	}
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	@RequestMapping("/orders")
	public String orders() {
		return "orders";
	}
	@RequestMapping("/posts")
	public String posts() {
		return "posts";
	}
	@RequestMapping("/users_1")
	public String users_1() {
		return "users_1";
	}
	@RequestMapping("/users_2")
	public String users_2() {
		return "users_2";
	}
	@RequestMapping("/admin_login")
	public String admin_login() {
		return "admin_login";
	}
}