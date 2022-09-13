package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.controller.TestController;
import com.example.demo.logic.TestLogic;

@Configuration
public class ControllerConfig2 {
	Logger logger = LoggerFactory.getLogger(TestController.class);
	@Bean
	public TestController testController() {
		TestController testController = new TestController();
		TestLogic testLogic = new TestLogic();
		testController.setTestLogic(testLogic);
		return testController;
	}
}
