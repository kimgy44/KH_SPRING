package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.vo.MemberVO;

//@Service 어노테이션 - 모델계층에만 붙이는 @Component의 자손 어노테이션이다.
@Service
public class MemberDao {
	Logger logger = LoggerFactory.getLogger(MemberDao.class);
	@Autowired(required = false)
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	// 받은쪽지 중 읽지 않은 쪽지 카운트하기
	public int noReadMemo(Map<String, Object> pMap) {
		logger.info("MemberDao : noReadMemo 호출 성공 ==> " + pMap);// pMap에 to_id가 있어야함
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne("noReadMemo", pMap);
		logger.info("cnt ===>"+cnt);//배달 사고가 어디서 발생한건지 체크하기 위한 코드 추가 필요함
		return cnt;
	}
	
	public int memberinsert(Map<String, Object> pMap) {
		logger.info("MemberDao : memberinsert 호출 성공 ==> " + pMap);// 101
		int result = 0;
		try {
			sqlSessionTemplate.selectOne("proc_memberinsert", pMap);
			if (pMap.get("result") != null) {
				result = Integer.parseInt(pMap.get("result").toString());
			}
			// insert here
			logger.info("result : " + result);
		} catch (DataAccessException e) {
			logger.info("Exception : " + e.toString());
		}
		return result;
	}

	public MemberVO login(Map<String, Object> pMap) {
		logger.info("MemberDao : login호출 성공");
		MemberVO mVO = null;
		mVO = sqlSessionTemplate.selectOne("login", pMap);
		return mVO;
	}

	   public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		      logger.info("memberList호출 성공");
		      List<Map<String, Object>> memberList = null;
		      memberList = sqlSessionTemplate.selectList("memberList", pMap);
		      return memberList;
		   }

}
