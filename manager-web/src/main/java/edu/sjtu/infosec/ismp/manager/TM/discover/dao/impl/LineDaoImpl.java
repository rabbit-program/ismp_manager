package edu.sjtu.infosec.ismp.manager.TM.discover.dao.impl;

import java.util.List;

import org.infosec.ismp.manager.rmi.tm.discover.model.Line;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.TM.discover.dao.LineDao;


/**
 * 线-数据库操作
 * @author Wu Guojie
 * @date 2009-6-8
 * @version 1.0
 */
public class LineDaoImpl extends HibernateDaoSupport implements LineDao {
	/**
	 * 加线
	 * @param line
	 * 线
	 */
	public void addLine(Line line) throws Exception {
		getHibernateTemplate().saveOrUpdate(line);
	}

	/**
	 * 删线
	 * @param line
	 * 线
	 */
	public void deleteLine(Line line) throws Exception {
		getHibernateTemplate().delete(line);
	}

	/**
	 * 改线
	 * @param line
	 * 线
	 */
	public void updateLine(Line line) throws Exception {
		getHibernateTemplate().saveOrUpdate(line);
	}

	/**
	 * 查所有线
	 * @return 线list
	 */
	@SuppressWarnings("unchecked")
	public List<Line> findAllLines() throws Exception {
		List<Line> list = getHibernateTemplate().loadAll(Line.class);
		return list;
	}

	/**
	 * 通过节点查线
	 * @return 线list
	 */
	@SuppressWarnings("unchecked")
	public List<Line> findAllLinesByNode(Node node) throws Exception {
		String hql = "from Line l where l.nodeSelf.id=" + node.getId();
		List<Line> list = getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 通过id查线
	 * @param id
	 * id
	 * @return 线
	 */
	public Line findLineById(int id) throws Exception {
		Line line = (Line)getHibernateTemplate().get(Line.class, id);
		return line;
	}
}
