package com.spring4.tr;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

public class EmpLogic {
	Logger logger = Logger.getLogger(EmpLogic.class);

	private DeptDao deptDao = null;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	private EmpDao empDao = null;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	//@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor= {DataAccessException.class})
//	public int doEmp() { // 한번에 커밋하시오.
	public int cudEmp() { // 건건이 커밋해라
		logger.info("EmpLogic : doEmp 호출 성공");
		Map<String,Object> emap = new HashMap<>();
		emap.put("empno", 1002);
		emap.put("ename", "천이");
		emap.put("deptno", 56);
		try {
			Map<String,Object> dmap = new HashMap<>();
			dmap.put("deptno", 56);
			dmap.put("dname", "개발부");
			dmap.put("loc", "노원");
			deptDao.deptInsert(dmap);
			empDao.empInsert(emap);
		} catch (DataAccessException de) {
			throw de;
		}
		
		return 0;
	}

}
