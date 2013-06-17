package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.StatWarnStriDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatWarnStri;

/**
 * 数据层 知识库静态安全阈值Dao实现类.
 */
public class StatWarnStriDaoImpl extends HibernateDaoSupport implements StatWarnStriDao {

	/**
     * 查询静态安全阈值
     * 
     * @param id
     *    静态安全阈值id
     * @return 静态安全阈值对象
     **/
	public AsseKnowStatWarnStri find(Integer id) {
		
		return (AsseKnowStatWarnStri) getHibernateTemplate().load(AsseKnowStatWarnStri.class, id);
	}

	/**
     * 获取静态安全阈值
     * @return 静态安全阈值
     **/
	public AsseKnowStatWarnStri getWarnStri() {
		
		AsseKnowStatWarnStri statWarnStri = null;
		List list = getSession().createCriteria(AsseKnowStatWarnStri.class)
                                .addOrder(Order.desc("id")).list();
		if(list!=null && list.size()>0) {
			statWarnStri = (AsseKnowStatWarnStri) list.get(0);
		}
		return statWarnStri;
	}

	/**
     * 删除静态安全阈值对象
     * 
     * @param statWarnStri
     *   静态安全阈值对象
     **/
	public void remove(AsseKnowStatWarnStri statWarnStri) {
		
		getHibernateTemplate().delete(statWarnStri);
	}

	/**
     * 保存/更新静态安全阈值对象
     * 
     * @param statWarnStri
     *    静态安全阈值对象
     **/
	public void saveOrUpdate(AsseKnowStatWarnStri statWarnStri) {
		
		getHibernateTemplate().saveOrUpdate(statWarnStri);
	}

	
}
