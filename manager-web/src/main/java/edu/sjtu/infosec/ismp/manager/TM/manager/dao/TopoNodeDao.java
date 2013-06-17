package edu.sjtu.infosec.ismp.manager.TM.manager.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.TopoManageConstant;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

@Component(value="topoNodeDao")
public class TopoNodeDao extends HibernateDao<NodeEntity,String>{
	private static final String SENSOR = "from NodeEntity where parentDomain=null and managerStyle='"+TopoManageConstant.SENSOR+"'";
	private static final String DELETE_NODES = "delete from NodeEntity where nodeId in(:ids)";
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 删除节点集合(没做联删除云图处理)
	 * @param nodeEntitys
	 */
	public void deleteNodes(List<NodeEntity> nodeEntitys) {
		if(nodeEntitys == null) return;
		List<String> ids = new ArrayList<String>();
		for(NodeEntity nodeEntity:nodeEntitys) {
			ids.add(nodeEntity.getNodeId());
		}
		Map<String, List<String>> map = Collections.singletonMap("ids", ids);
		batchExecute(DELETE_NODES,map);
	}
	
	/**
	 * 保存或更新节点
	 * @param nodeEntity
	 */
	public void saveOrUpdateNode(NodeEntity nodeEntity) {
		if(getSession() != null) {
			if(nodeEntity.getParentDomain() != null && nodeEntity.getParentDomain().getId() == null) {
				nodeEntity.setDomain(null);
			}
			nodeEntity.setCreateTime(Timestamp.valueOf(simpleDateFormat.format(new Date())));
			getSession().saveOrUpdate(nodeEntity);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<NodeEntity> findSensorByUnDomain() {
		Query query = createQuery(SENSOR);
		return distinct(query).list();
	}
}
