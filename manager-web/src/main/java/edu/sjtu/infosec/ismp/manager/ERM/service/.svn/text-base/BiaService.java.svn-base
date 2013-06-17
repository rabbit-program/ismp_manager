package edu.sjtu.infosec.ismp.manager.ERM.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.ERM.model.ContiBia;
import edu.sjtu.infosec.ismp.manager.ERM.model.PriorityLevel;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;

public interface BiaService {
	//根据RespInfoBO查询是否存在bia信息
	List<ContiBia> findBiaById(RespInfoBO resp);
	
	//根据id查询应急对象
	RespInfoBO findRespBoById(String id);
	
	//更新或保存ContiBia对象
	void saveorupdate(ContiBia contibia);
	
	//根据id得到PriorityLevel对象
	PriorityLevel findPriByid(int id);
	
	//查询高中低级别
	List<PriorityLevel> findPrior();
	
	void deleteBiaByRespInfo(RespInfoBO resp);
}
