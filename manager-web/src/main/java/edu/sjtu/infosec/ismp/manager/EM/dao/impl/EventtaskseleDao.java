package edu.sjtu.infosec.ismp.manager.EM.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.EM.dao.IEventtaskseleDao;
import edu.sjtu.infosec.ismp.manager.EM.model.Eventtasksele;

/**
 * 自选事件表的DAO实现
 * @author wudengke 2009-6-29
 *
 */
public class EventtaskseleDao extends HibernateDaoSupport implements IEventtaskseleDao {

	/**
	 * 添加单个对象。
	 * @param data 需要添加的对象。
	 * 
	 */
	public void add(Eventtasksele data) {
		getHibernateTemplate().save(data);

	}

	/**
	 * 删除指定的对象。
	 * @param data
	 * 
	 */
	public void delete(Eventtasksele data) {
		getHibernateTemplate().delete(data);

	}

	/**
	 * 通过查询Eventrealdisp对象
	 * 
	 * @param id
	 * 
	 */
	public Eventtasksele get(Serializable id) {
		return (Eventtasksele) getHibernateTemplate().get(Eventtasksele.class, id);
	}

	/**
	 * 修改指定的对象的内容，注意对象的主键不能修改。
	 * 
	 * @param data 需要修改的对象。
	 * 
	 * 
	 */
	public void update(Eventtasksele data) {
		getHibernateTemplate().saveOrUpdate(data);
	}

	/**
	 * 通过用户自定义的编号查询
	 * @param ids
	 * @return List<Eventtasksele>
	 */
	@SuppressWarnings("unchecked")
	public List<Eventtasksele> queryEventtaskseleBydefineid(final String userName,final Serializable define_id) {
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Eventtasksele.class);
				criteria.add(Restrictions.eq("userName", userName));
				criteria.add(Restrictions.eq("define_id", (Integer)define_id));
				List list = criteria.list();
				return list;
			}
		});
		
	}

	/**
	 * 添加多个对象。
	 * 
	 * @param data
	 * 
	 */
	public void add(List<Eventtasksele> datas) {
		getHibernateTemplate().saveOrUpdateAll(datas);
	}

	/**
	 * 删除指定的多个对象。
	 * @param data
	 * 
	 */
	public void delete(String userName,String define_id,List<Serializable> ids) {
		Iterator<Serializable> it = ids.iterator();
		StringBuffer buffer = new StringBuffer();
		buffer.append("delete from Eventtasksele e where e.define_id="+define_id+" and e.userName='"+userName+"' and e.faci_ip in (");
		while (it.hasNext()) {
			buffer.append("?");
			it.next();
			if (it.hasNext()) {
				buffer.append(",");
			}
		}
		buffer.append(")");

		getHibernateTemplate().bulkUpdate(buffer.toString(), ids.toArray());
		
	}

}
