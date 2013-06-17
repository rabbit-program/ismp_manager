package edu.sjtu.infosec.ismp.manager.TM.discover.dao;

import java.util.List;

import org.infosec.ismp.manager.rmi.tm.discover.model.Line;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;


/**
 * 线-数据库操作
 * @author Wu Guojie
 * @date 2009-6-8
 * @version 1.0
 */
public interface LineDao {
	/**
	 * 加线
	 * @param line
	 * 线
	 */
	void addLine(Line line) throws Exception;
	/**
	 * 删线
	 * @param line
	 * 线
	 */
	void deleteLine(Line line) throws Exception;
	/**
	 * 改线
	 * @param line
	 * 线
	 */
	void updateLine(Line line) throws Exception;
	/**
	 * 查所有线
	 * @return 线list
	 */
	List<Line> findAllLines() throws Exception;
	/**
	 * 通过节点查线
	 * @return 线list
	 */
	List<Line> findAllLinesByNode(Node node) throws Exception;
	/**
	 * 通过id查线
	 * @param id
	 * id
	 * @return 线
	 */
	Line findLineById(int id) throws Exception;
}
