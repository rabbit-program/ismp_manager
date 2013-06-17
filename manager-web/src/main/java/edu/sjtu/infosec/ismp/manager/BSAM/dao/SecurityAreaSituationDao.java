package edu.sjtu.infosec.ismp.manager.BSAM.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.dao.DataAccessResourceFailureException;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.BaseDao;

public interface SecurityAreaSituationDao extends BaseDao {
	
	/**
	 * 获取id为id的安全域态势(在beginTime——endTime时间段内)
	 * @param beginTime
	 * @param endTime
	 * @param id
	 * @param firstIndex
	 * @return
	 */
	List getHistoryValue(String beginTime, String endTime,Integer id, Integer firstIndex) throws DataAccessResourceFailureException, IllegalStateException, ParseException;
//	======================================================
}
