package edu.sjtu.infosec.ismp.manager.ERM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.ERM.dao.BiaDao;
import edu.sjtu.infosec.ismp.manager.ERM.model.ContiBia;
import edu.sjtu.infosec.ismp.manager.ERM.model.PriorityLevel;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.ERM.service.BiaService;

public class BiaServiceImpl implements BiaService {
	private BiaDao biaDao;

	public void setBiaDao(BiaDao biaDao) {
		this.biaDao = biaDao;
	}

	public List<ContiBia> findBiaById(RespInfoBO resp) {
		return biaDao.findBiaById(resp);
	}

	public RespInfoBO findRespBoById(String id) {
		List<RespInfoBO> list=biaDao.findRespBoById(id);
		if(list.isEmpty() || list.size()==0)
		{
			return null;
		}
		return list.get(0);
	}

	public void saveorupdate(ContiBia contibia) {
		biaDao.saveorupdate(contibia);
	}
	
	//根据id得到PriorityLevel对象
	public PriorityLevel findPriByid(int id)
	{
		return biaDao.findPriByid(id);
	}

	public List<PriorityLevel> findPrior() {
		return biaDao.findPrior();
	}

	public void deleteBiaByRespInfo(RespInfoBO resp) {
		biaDao.deleteBiaByRespInfo(resp);
	}
	
}
