package edu.sjtu.infosec.ismp.manager.TM.discover.dao.impl;

import java.util.List;

import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.TM.discover.dao.NodeDao;


/**
 * 节点-数据库操作
 * @author Wu Guojie
 * @date 2009-6-8
 * @version 1.0
 */
public class NodeDaoImpl extends HibernateDaoSupport implements NodeDao {
	/**
	 * 加节点
	 * @param node
	 * 节点
	 */
	public void addNode(Node node) throws Exception {
		getHibernateTemplate().saveOrUpdate(node);
	}

	/**
	 * 删节点
	 * @param node
	 * 节点
	 */
	public void deleteNode(Node node) throws Exception {
		getHibernateTemplate().delete(node);
	}

	/**
	 * 改节点
	 * @param node
	 * 节点
	 */
	public void updateNode(Node node) throws Exception {
		getHibernateTemplate().saveOrUpdate(node);
	}

	/**
	 * 查所有节点
	 * @return 节点list
	 */
	@SuppressWarnings("unchecked")
	public List<Node> findAllNodes() throws Exception {
		List<Node> list = getHibernateTemplate().loadAll(Node.class);
		return list;
	}

	/**
	 * 通过id查节点
	 * @param id
	 * id
	 * @return 节点
	 */
	public Node findNodeById(int id) throws Exception {
		Node node = (Node)getHibernateTemplate().get(Node.class, id);
		return node;
	}
}
