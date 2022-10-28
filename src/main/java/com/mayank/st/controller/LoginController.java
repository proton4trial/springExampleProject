package com.mayank.st.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mayank.st.entity.LoginData;

import com.mayank.st.service.LoginService;

@Controller
public class LoginController {
	
	private LoginService loginService;

	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	
	@GetMapping("/loginpage")
	public String createLogin(Model model) {
		LoginData login= new LoginData(); 
		model.addAttribute("login", login);
		return "login";
	}
	@PostMapping("/loginpage")
	public String loginResult(@ModelAttribute("login") LoginData login) { 
		boolean result = loginService.tryLogin(login);
		return (result) ? "redirect:/employees":"redirect:/error"; 
	}
	

	@GetMapping("/error")
	public String errorPage(Model model) {
		return "error";
	}
	
	@GetMapping("/exit")
	public String blankPage(Model model) {
		return "blank";
	}
}
