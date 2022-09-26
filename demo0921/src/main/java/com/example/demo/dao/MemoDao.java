package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

//@Service 어노테이션 - 모델계층에만 붙이는 @Component의 자손 어노테이션이다.
@Service
public class MemoDao {
	Logger logger = LoggerFactory.getLogger(MemoDao.class);
	@Autowired(required = false)
	private SqlSessionTemplate sqlSessionTemplate = null;

	public int memoinsert(Map<String, Object> pMap) {
		logger.info("MemoDao : memoinsert 호출 성공" + pMap);
		int result = 0;
		try {
			sqlSessionTemplate.update("memoInsert", pMap);
			logger.info("result :" + result);
		} catch (DataAccessException e) {
			logger.info("Exception : " + e.toString());
		}
		return result;
	}

	public List<Map<String, Object>> sendMemoList(Map<String, Object> pMap) {
		logger.info("MemoDao : sendMemoList 호출 성공" + pMap);
		List<Map<String, Object>> sendMemoList = null;
		sendMemoList = sqlSessionTemplate.selectList("sendMemoList", pMap);
		return sendMemoList;
	}

	public List<Map<String, Object>> receiveMemoList(Map<String, Object> pMap) {
		logger.info("MemoDao : receiveMemoList 호출 성공" + pMap);
		List<Map<String, Object>> receiveMemoList = null;
		receiveMemoList = sqlSessionTemplate.selectList("receiveMemoList", pMap);
		return null;
	}

//	   
//	   public int memoinsert(Map<String, Object> pMap) {
//		      logger.info("memoinsert 호출 성공"+pMap);
//		      int result = 0;
//		      List<Map<String, Object>> boardList = null;
//		      try {
//		         sqlSessionTemplate.selectOne("proc_memoinsert", pMap);
//		         if(pMap.get("result")!=null) {
//		        	 result = Integer.parseInt(pMap.get("result").toString());
//		         }
//		         // insert here
//		         logger.info("result :"+result);
//		      } catch (DataAccessException e) {
//		         logger.info("Exception : "+e.toString());
//		      } 
//		      return result;
//		   }
}