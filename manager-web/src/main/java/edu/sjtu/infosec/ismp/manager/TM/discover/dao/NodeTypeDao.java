package edu.sjtu.infosec.ismp.manager.TM.discover.dao;

import java.util.List;

import org.infosec.ismp.manager.rmi.tm.discover.model.NodeType;


/**
 * 节点类型-数据库操作
 * @author Wu Guojie
 * @date 2009-6-8
 * @version 1.0
 */
public interface NodeTypeDao {
	/**
	 * 加节点类型
	 * @param nodeType
	 * 类型
	 */
	void addNodeType(NodeType nodeType) throws Exception;
	/**
	 * 删节点类型
	 * @param nodeType
	 * 类型
	 */
	void deleteNodeType(NodeType nodeType) throws Exception;
	/**
	 * 改节点类型
	 * @param nodeType
	 * 类型
	 */
	void updateNodeType(NodeType nodeType) throws Exception;
	/**
	 * 查所有节点类型
	 * @return 类型list
	 */
	List<NodeType> findAllNodeTypes() throws Exception;
	/**
	 * 通过id查节点类型
	 * @param id
	 * id
	 * @return 类型
	 */
	NodeType findNodeTypeById(int id) throws Exception;
}
