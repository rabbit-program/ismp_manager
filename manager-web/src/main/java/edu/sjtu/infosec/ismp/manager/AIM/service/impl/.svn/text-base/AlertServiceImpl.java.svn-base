package edu.sjtu.infosec.ismp.manager.AIM.service.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;

import edu.sjtu.infosec.ismp.manager.AIM.comm.AlertQueryVO;
import edu.sjtu.infosec.ismp.manager.AIM.dao.AlertDao;
import edu.sjtu.infosec.ismp.manager.AIM.service.AlertService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.security.Domain;


public class AlertServiceImpl implements AlertService{
	
	private AlertDao alertDao;	
	public void setAlertDao(AlertDao alertDao) {
		this.alertDao = alertDao;
	}	
    //统计函数
	public int getCountByAlertService(AlertQueryVO AlertQueryEntity,Criteria cri) {
		// TODO Auto-generated method stub
		return alertDao.getCountByAlertDao(AlertQueryEntity,cri);
	}
   //多条件分页查询
	public PageResult getListPageAlertService(Page page,
			AlertQueryVO AlertQueryEntity) {
		return alertDao.getListPageAlertDao(page,AlertQueryEntity);
	}
	//根据ID 查询
	public AlertInfoBO getByIdAlertService(Integer alertid) {
		// TODO Auto-generated method stub
		return alertDao.getByIdAlertDao(alertid);
	}

	public void updateAlertService(AlertInfoBO alertinfoEntity) {
		// TODO Auto-generated method stub
		 alertDao.updateAlertDao(alertinfoEntity);
	}
	
	public void addAlertService(AlertInfoBO alertInfoEntity){
		alertDao.addAlertDao(alertInfoEntity);
	}
	
	//多条件分页查询，加权限
	public PageResult getListPageAlertService(Page page,
			AlertQueryVO AlertQueryEntity, List<Domain> list) {
		
		return alertDao.getListPageAlertDao(page,AlertQueryEntity,list);
	}


}
