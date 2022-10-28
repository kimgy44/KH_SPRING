package com.example.demo.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDao {
	Logger logger = LoggerFactory.getLogger(MemberDao.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int memberInsert(Map<String, Object> pMap) {
		logger.info("MemberDao : memberInsert 호출 성공");
		int result = 0; 
		result = sqlSessionTemplate.update("memberInsert", pMap);
		return result;
	}
	
	
	
}
