package com.mvc.kh;
// ApplicationContext를 통해서 주입 ﻿→ 이른 인스턴스화
// BeanFactory를 통해서 주입 ﻿→ 게으른 인스턴스화
public class View {
	Service service = null;
	public View() {
		
	}
	public View(Service service) { //지역변수는 다른메서등서 사용할 수 없다. 그래서 4번에서 선언하고 여기서 초기화를 한다.
		this.service = service;
	}
	public void methodA() {
		System.out.println(service);
		// 생성자의 선택의 문제
		// 호출 위치의 문제
		// 500번의 문제를 피할 수 있도록 관리를 받자 - spring framework
		// DI
		service.methodB();// 생성자의 선택에 따라 ﻿→ NullPointException 발생할 수 있다.
	}
}
