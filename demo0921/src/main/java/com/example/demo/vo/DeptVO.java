package com.example.demo.vo;

import lombok.Data;
// 맵을 사용하지 않고 vo로 처리할 예정
//getter,setter을 대신한 어노테이션. 
//'생성자'를 대신할 수 있는 어노테이션은? @Builder
@Data
public class DeptVO {
	private int deptno;
	private String dname;
	private String loc;
}
