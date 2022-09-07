package com.basic.step1;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.MemberVO;
// DAO뒤에서는 오라클 서버와 연동하기
// myBatis 레이어에 대한 설정이 필요하다
@Service
public class AuthDao {
	// SqlSessionTemplate는 mybatis-spring.jar에서 제공하는 클래스로
	// SqlSession의 역할이다.
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	public MemberVO login() {
		//logger.info("login 호출 성공");
		MemberVO memVO = null;
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("mem_id", "test");
		pMap.put("mem_pw", "123");
		// selectOne(One은 Object)은 조회건 수가 반드시 한건이어야 한다.
		// Too Many . . . 
		memVO = sqlSessionTemplate.selectOne("login", pMap);
	    if(memVO!=null) {
	    //  logger.info(memVO.getMem_name());
	    }
	    //sqlSessionTemplate.selectOne("login", pMap);
	    // //logger.info(memVO);
	     return memVO;
	}
}
