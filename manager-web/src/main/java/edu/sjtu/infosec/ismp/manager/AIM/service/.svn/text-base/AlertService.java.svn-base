package edu.sjtu.infosec.ismp.manager.AIM.service;

import java.util.List;

import org.hibernate.Criteria;
import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;

import edu.sjtu.infosec.ismp.manager.AIM.comm.AlertQueryVO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.security.Domain;


public interface AlertService {

	
	 //多条件查询告警信息 并且分页显示
	 PageResult getListPageAlertService(Page page,AlertQueryVO AlertQueryEntity);	 
	 
	 
    //多条件统计 记录数	 
	 int getCountByAlertService(AlertQueryVO AlertQueryEntity,Criteria cri);
	 
	 //根据ID 查看单个记录
	 
	 AlertInfoBO getByIdAlertService(Integer alertid);
	 
	 //更新告警信息
	 void updateAlertService(AlertInfoBO alertInfoEntity);
	 
	 //添加新告警
	 void addAlertService(AlertInfoBO alertInfoEntity);
	 
	 //多条件查询告警信息 并且分页显示
	 PageResult getListPageAlertService(Page page,AlertQueryVO AlertQueryEntity,List<Domain> list);	
}
