package edu.sjtu.infosec.ismp.manager.AIM.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;

import edu.sjtu.infosec.ismp.manager.AIM.comm.AlertQueryVO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.security.Domain;


public interface AlertDao {
        
	 //多条件查询告警信息 并且分页显示
	 PageResult getListPageAlertDao(Page page,AlertQueryVO AlertQueryEntity);	 
	 
	 //多条件统计 记录数
	 
	 int getCountByAlertDao(AlertQueryVO AlertQueryEntity,Criteria cri);
	 //ID 查询
	 AlertInfoBO getByIdAlertDao(Integer alertid);
	 
	 //更新告警信息
	 void updateAlertDao(AlertInfoBO alertInfoEntity);
	 
	 void addAlertDao(AlertInfoBO alertInfoEntity);
	 
	 //多条件查询告警信息 并且分页显示，根据部门
	 PageResult getListPageAlertDao(Page page,AlertQueryVO AlertQueryEntity,List<Domain> set);	 
}
