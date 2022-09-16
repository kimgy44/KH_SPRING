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
	public int doEmp() {
		logger.info("EmpLogic : doEmp 호출 성공");
		Map<String,Object> emap = new HashMap<>();
		emap.put("empno", 1004);
		emap.put("ename", "천사");
		emap.put("deptno", 1000);
		try {
			Map<String,Object> dmap = new HashMap<>();
			dmap.put("deptno", 1000);
			dmap.put("dname", "개발부");
			dmap.put("loc", "창동");
			deptDao.deptInsert(dmap);
			empDao.empInsert(emap);
		} catch (DataAccessException de) {
			throw de;
		}
		
		return 0;
	}

}
