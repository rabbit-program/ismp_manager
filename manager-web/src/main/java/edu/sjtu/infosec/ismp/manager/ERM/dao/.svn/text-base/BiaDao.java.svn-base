package edu.sjtu.infosec.ismp.manager.ERM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.ERM.model.ContiBia;
import edu.sjtu.infosec.ismp.manager.ERM.model.PriorityLevel;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;

public interface BiaDao {
	//根据RespInfoBO查询是否存在bia信息
	List<ContiBia> findBiaById(RespInfoBO resp);
	
	//根据id查询应急对象
	List<RespInfoBO> findRespBoById(String id);
	
	//更新或保存ContiBia对象
	void saveorupdate(ContiBia contibia);
	
	//根据id得到PriorityLevel对象
	PriorityLevel findPriByid(int id);
	
	//查询高中低级别
	List<PriorityLevel> findPrior();
	
	//根据RespInfoBO删除bia信息
	void deleteBiaByRespInfo(RespInfoBO resp);
}
