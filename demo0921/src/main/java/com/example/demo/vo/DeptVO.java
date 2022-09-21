package com.example.demo.vo;

import lombok.Data;
// 맵을 사용하지 않고 vo로 처리할 예정

@Data
public class DeptVO {
	private int deptno;
	private String dname;
	private String loc;
}
