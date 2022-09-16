package com.spring4.tr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.spring4.mvc.AuthController;

public class EmpController {
	Logger logger = Logger.getLogger(EmpController.class);
	
	private EmpLogic empLogic = null;
	public void setEmpLogic(EmpLogic empLogic) {
		this.empLogic = empLogic;
	}

	public String doEmp(HttpServletRequest req, HttpServletResponse res) {
		logger.info("dev_spring emp 호출 성공");
		System.out.println("dev_spring emp 호출 성공");
		String path = "redirect:index.jsp";
		int result = 0;
		result = empLogic.doEmp();
		return "redirect:empList.sp";
	}
}
