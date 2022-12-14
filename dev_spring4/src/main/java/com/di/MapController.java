package com.di;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class MapController extends AbstractController {
	Logger logger = Logger.getLogger(MapController.class);
	// spring-servlet.xml에 선언된 bean[MapController]태그안에 정의된
	private Map<String,Object> insaMsg = null; // 주입받고 싶어요.누가?(스프링에서 필요할 때 : 게으른[BeanFactory] / 이른[Application]])
	// 아래 setter메소드는 setter객체주입법 코드이다.
	// 그 객체는 어디에 있는 객체인가요? ﻿→ spring-servlet.xml / 타입 : Map
	public void setInsaMsg(Map<String, Object> insaMsg) {
		this.insaMsg = insaMsg;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("handleRequestInternal --→"+insaMsg);
		  ModelAndView mav = new ModelAndView();
	      mav.addObject("insaMsg",insaMsg);
	      mav.setViewName("di/insaList");

		return null;
	}
}
