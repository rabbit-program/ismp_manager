package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.StatThreKindDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThreKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 静态威胁类别Dao实现类.
 */
public class StatThreKindDaoImpl extends HibernateDaoSupport implements StatThreKindDao {

	/**
     * 查询静态威胁类别
     * 
     * @param id
     *    静态威胁类别id
     * @return 静态威胁类别对象
     **/
	public AsseKnowStatThreKind find(Integer id) {
		
		AsseKnowStatThreKind statThreKind = null;
		statThreKind = (AsseKnowStatThreKind) getHibernateTemplate().load(AsseKnowStatThreKind.class, id);
		return statThreKind;
	}

	/**
     * 查询静态威胁类别数量
     * @return 静态威胁类别数量
     **/
	public int getCount() {
		
		Criteria criteria = getSession().createCriteria(AsseKnowStatThreKind.class);
		  return 0;//count(criteria);
	}

	/**
     * 返回所有静态威胁类别
     * @return 所有静态威胁类别列表
     **/
	public List<AsseKnowStatThreKind> listAllStatThreKind() {
		
		Criteria criteria = getSession().createCriteria(AsseKnowStatThreKind.class);
        return criteria.list();
	}

	/**
     * 查询静态威胁类别分页记录
     * @param page
     *            分页对象
     * @return 分页记录列表
     **/
	public List<AsseKnowStatThreKind> listStatThreKindPage(Page page) {
		
		List<AsseKnowStatThreKind> statThreKindlist = null;
        Criteria criteria = getSession().createCriteria(AsseKnowStatThreKind.class)
                                        .addOrder(Order.asc("id"));
        if(page!=null) {
            criteria.setFirstResult(page.getBeginIndex())
                    .setMaxResults(page.getEveryPage());
        }
        statThreKindlist = criteria.list();
        return statThreKindlist;
	}

	/**
     * 删除静态威胁类别对象
     * 
     * @param statThreKind
     *   静态威胁类别对象
     **/
	public void remove(AsseKnowStatThreKind statThreKind) {
		
		getHibernateTemplate().delete(statThreKind);
	}

	/**
     * 保存/更新静态威胁类别对象
     * 
     * @param statThreKind
     *    静态脆弱点类别对象
     **/
	public void saveOrUpdate(AsseKnowStatThreKind statThreKind) {
		
		getHibernateTemplate().saveOrUpdate(statThreKind);
	}

	
	public AsseKnowStatThreKind find(String kind) {
		
		AsseKnowStatThreKind statThreKind = null;
		Criteria criteria = getSession().createCriteria(AsseKnowStatThreKind.class)
		                                .add(Expression.like("kind", kind));
		List list = criteria.list();
		if(list!=null && list.size()>0) {
			statThreKind = (AsseKnowStatThreKind) list.get(0);
		}
		
		return statThreKind;
	}

}
