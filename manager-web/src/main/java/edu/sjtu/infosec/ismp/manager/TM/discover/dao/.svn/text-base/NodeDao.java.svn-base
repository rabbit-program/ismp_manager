package edu.sjtu.infosec.ismp.manager.TM.discover.dao;

import java.util.List;

import org.infosec.ismp.manager.rmi.tm.discover.model.Node;


/**
 * 节点-数据库操作
 * @author Wu Guojie
 * @date 2009-6-8
 * @version 1.0
 */
public interface NodeDao {
	/**
	 * 加节点
	 * @param node
	 * 节点
	 */
	void addNode(Node node) throws Exception;
	/**
	 * 删节点
	 * @param node
	 * 节点
	 */
	void deleteNode(Node node) throws Exception;
	/**
	 * 改节点
	 * @param node
	 * 节点
	 */
	void updateNode(Node node) throws Exception;
	/**
	 * 查所有节点
	 * @return 节点list
	 */
	List<Node> findAllNodes() throws Exception;
	/**
	 * 通过id查节点
	 * @param id
	 * id
	 * @return 节点
	 */
	Node findNodeById(int id) throws Exception;
}
