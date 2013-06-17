package edu.sjtu.infosec.ismp.manager.TM.discover.dao.impl;

import java.util.List;

import org.infosec.ismp.manager.rmi.tm.discover.model.NodeType;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.TM.discover.dao.NodeTypeDao;


/**
 * 节点类型-数据库操作
 * @author Wu Guojie
 * @date 2009-6-8
 * @version 1.0
 */
public class NodeTypeDaoImpl extends HibernateDaoSupport implements NodeTypeDao {
	/**
	 * 加节点类型
	 * @param nodeType
	 * 类型
	 */
	public void addNodeType(NodeType nodeType) throws Exception {
		getHibernateTemplate().saveOrUpdate(nodeType);
	}

	/**
	 * 删节点类型
	 * @param nodeType
	 * 类型
	 */
	public void deleteNodeType(NodeType nodeType) throws Exception {
		getHibernateTemplate().delete(nodeType);
	}

	/**
	 * 改节点类型
	 * @param nodeType
	 * 类型
	 */
	public void updateNodeType(NodeType nodeType) throws Exception {
		getHibernateTemplate().saveOrUpdate(nodeType);
	}

	/**
	 * 查所有节点类型
	 * @return 类型list
	 */
	@SuppressWarnings("unchecked")
	public List<NodeType> findAllNodeTypes() throws Exception {
		List<NodeType> list = getHibernateTemplate().loadAll(NodeType.class);
		return list;
	}

	/**
	 * 通过id查节点类型
	 * @param id
	 * id
	 * @return 类型
	 */
	public NodeType findNodeTypeById(int id) throws Exception {
		NodeType nodeType = (NodeType)getHibernateTemplate().get(NodeType.class, id);
		return nodeType;
	}
}
