package com.spring4.mvc;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class Pride extends MultiActionController {
	Logger logger = Logger.getLogger(Pride.class);
	String carColor = null;
	int speed = 0;
	int wheelNum = 0;
	public Pride() {
		logger.info("디폴트 생성자 호출 성공");
	}
}
