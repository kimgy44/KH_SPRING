package com.chap2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vo.AppContext;
import com.vo.DeptVO;
// 어떤 추상클래스나 어떤 인터페이스 상속, implements하지 않은 클래스
// 어떠한 메소드 오버라이드 하지 않아도 된다.


public class Main {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
	    		  new AnnotationConfigApplicationContext(AppContext.class);
		DeptVO dVO = ctx.getBean("getDeptVO", DeptVO.class);
		int deptno = dVO.getDeptno();
		String dname = dVO.getDname();
		String loc = dVO.getLoc();
		System.out.println(deptno+", "+dname+", "+loc);
		ctx.close();

	}

}
