package com.spring4.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.vo.MemberVO;

public class AuthController extends MultiActionController {
	Logger logger = Logger.getLogger(AuthController.class);
	// setter 객체주입법(﻿자바코드에서 처리)과 생성자 객체주입법(﻿xml에서 처리)이 있다.
	private AuthLogic authLogic = null;
	// setter 객체주입법 코드이다.
	// 인스턴스화 대신이다. ﻿→ authLogic = new AuthLogic();
	// 오잉? 코드가 더 긴데요? ﻿→ 이러면 뭐가 좋은거죠??? ﻿→ ApplicationContext가 관래해준다.
	// ApplicationContext가 객체(﻿ AuthLogic 객체)를 메모리에 올려준다.
	public void setAuthLogic(AuthLogic authLogic) {
		this.authLogic = authLogic;
	}
	public String login(HttpServletRequest req, HttpServletResponse res) {
		logger.info("dev_spring4 login 호출 성공");
		System.out.println("dev_spring login 호출 성공");
		String path = "redirect:index.jsp";
		MemberVO memVO = null;
		// 아래 코드는 NullPointerException이 발생한다.|안한다. 
		// 15번 라인에 선언된 객체는 아래코드에서 사용된다.
		// 그러니까 여기서 인스턴스화를 하면 게으른 인스턴스화 라고 한다.
		memVO = authLogic.login();
		HttpSession session = req.getSession();
		session.setAttribute("memVO", memVO);
		return path;
		}
}
