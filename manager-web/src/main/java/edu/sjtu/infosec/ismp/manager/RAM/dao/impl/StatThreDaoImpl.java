package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.StatThreDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThreKind;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnPoin;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 静态威胁Dao实现类
 * 


 **/
public class StatThreDaoImpl extends HibernateDaoSupport implements StatThreDao {

	/**
     * 查询静态威胁
     * @param id
     *    静态威胁id
     * @return 静态威胁对象
     **/
	public AsseKnowStatThre find(Integer id) {
		String hql = "from AsseKnowStatThre where id ="+id;
		AsseKnowStatThre statThre = null;
		List list = this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			statThre = (AsseKnowStatThre) list.get(0);
		}
		return statThre;
	}

	/**
     * 查询静态威胁数量
     * @return 静态威胁数量
     **/
	public int getCount() {
		
		Criteria criteria = getSession().createCriteria(AsseKnowStatThre.class);
		  return 0;//count(criteria);
	}

	/**
     * 返回所有静态威胁
     * @return 静态威胁列表
     **/
	public List<AsseKnowStatThre> listAllStatThre() {
		
		Criteria criteria = getSession().createCriteria(AsseKnowStatThre.class)
		                                .addOrder(Order.asc("id"));
		return criteria.list();
	}

	/**
     * 根据静态威胁类别返回静态威胁列表
     * @param asseInfoProjId
     *     测评项目编号
     * @param statThreKind
     *     静态威胁类别
     * @return 静态威胁列表
     **/
	public List<AsseKnowStatThre> listStatThre(Integer asseInfoProjId,
			AsseKnowStatThreKind statThreKind) {
		
		
		List list = getHibernateTemplate().find("select statThre " +
        		"from AsseKnowStatThre statThre " +
        		"where statThre.id NOT IN (select dynaThre.asseKnowStatThreId from AsseKnowDynaThre dynaThre where dynaThre.asseInfoProjId = '"+asseInfoProjId+"' ) "+
        		"and statThre.threKind = ?",statThreKind);
        return list;
	}

	/**
     * 查询静态威胁分页记录
     * @param page
     *     分页对象
     * @return 分页记录列表
     **/
	public List<AsseKnowStatThre> listStatThrePage(Page page) {
		
		 List<AsseKnowStatThre> statThrelist = null;
	        Criteria criteria = getSession().createCriteria(AsseKnowStatThre.class)
	                                        .addOrder(Order.asc("id"));
	        if(page!=null) {
	            criteria.setFirstResult(page.getBeginIndex())
	                    .setMaxResults(page.getEveryPage());
	        }
	        statThrelist = criteria.list();
	        return statThrelist;
	}

	/**
     * 删除静态威胁对象
     * @param statThre
     *   静态威胁对象
     **/
	public void remove(AsseKnowStatThre statThre) {
		
		getHibernateTemplate().delete(statThre);
	}

	/**
     * 保存/更新静态威胁对象
     * @param statThre
     *    静态威胁对象
     **/
	public void saveOrUpdate(AsseKnowStatThre statThre) {
		
		getHibernateTemplate().saveOrUpdate(statThre);
	}

	/**
     * 根据静脆弱点返回静态威胁列表
     * @param vulnPoin
     *    静态脆弱点
     * @return 静态威胁列表
     **/
	@SuppressWarnings("unchecked")
	public List<AsseKnowStatThre> listStatThreByVulnPoin(
			AsseKnowStatVulnPoin vulnPoin) {
		String hql = "from AsseKnowStatThre where vulnPoin.id="+vulnPoin.getId();
		List<AsseKnowStatThre> list =this.getHibernateTemplate().find(hql);
		return list;
	}

}
