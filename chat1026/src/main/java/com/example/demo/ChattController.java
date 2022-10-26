package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ChattController {
	
//	@GetMapping("/mychatt")
//	public String chatt() {
//		return "chatting";
//	}
	
	@GetMapping("/mychatt")
	public ModelAndView chatt() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("chatting");
		return mav;  
	}
	
	
}
