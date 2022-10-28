package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	/* 일반 / 판매자 / 어드민페이지 */
	@GetMapping({"", "/"})
	public String home() {
		logger.info("home 호출");
		return "redirect:home.jsp"; // WEB-INF 안
	}
	@GetMapping("/user")
	public @ResponseBody String User() {
		logger.info("user 호출");
		return "유저페이지 입니다."; // 텍스트로하려면 레스판스 바디 or 레스트
	}
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		logger.info("admin 호출");
		return "관리자페이지 입니다."; 
	}
//	@GetMapping("/login")
//	public String login() {
//		logger.info("user 호출");
//		return "유저페이지 입니다."; 
//	}
	@GetMapping("/loginForm")
	public String loginForm() {
		logger.info("loginForm 호출");
		return "redirect:loginForm.jsp"; 
	}
	@GetMapping("/memberForm")
	public String memberForm() {
		logger.info("memberForm 호출");
		return "redirect:memberForm.jsp";
	}

}
