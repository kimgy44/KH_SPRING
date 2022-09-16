package com.mvc.kh;

public class DiTest {
	Service service = new Service();
	//View view = new View(); //→망하는것임
	View view = new View(service); // 이른 인스턴스화
	public void testRun() {
		
	}
	public static void main(String[] args) {
		DiTest dt= new DiTest();
		dt.testRun();
	}
}
