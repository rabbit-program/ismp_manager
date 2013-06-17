package org.infosec.ismp.manager.agent.servicecheck;

import java.util.List;

import org.infosec.ismp.manager.model.ServiceCheckNodeEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

/**
 * ServiceCheckNodeEntityDao类
 * @author jiel
 *
 */
@Component
public class ServiceCheckNodeEntityDao extends HibernateDao<ServiceCheckNodeEntity, Integer> {
	
	/**
	 * 删除serviceCheckNode
	 * @param nodeid
	 */
	public void removeServiceCheckNode(String nodeid){
//		String hql = "delete from ServiceCheckNodeEntity  where nodeid=? ";
//		batchExecute(hql, nodeid);
		List<ServiceCheckNodeEntity> lists = findBy("nodeid", nodeid);
		if(lists!=null&&lists.size()>0){
			for(ServiceCheckNodeEntity entity:lists){
				delete(entity);
			}
		}
	} 

}
