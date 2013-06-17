package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.StatCVEThreDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatCVEThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThreKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 知识库静态漏洞威胁Dao实现类.
 **/
public class StatCVEThreDaoImpl extends HibernateDaoSupport implements StatCVEThreDao{

	/**
     * 查询静态漏洞威胁
     * @param id
     *    静态漏洞威胁id
     * @return 静态漏洞威胁对象
     **/
	public AsseKnowStatCVEThre find(Integer id) {
		AsseKnowStatCVEThre statCVEthre=null;
		List list = getHibernateTemplate().find("from AsseKnowStatCVEThre where id=?", id);
		if(list!=null&&list.size()>0){
			statCVEthre= (AsseKnowStatCVEThre) list.get(0);
		}
		return statCVEthre;
	}

	/**
     * 查询静态漏洞威胁
     * @param cveId
     * CVE_ID
     * @return 静态漏洞威胁对象
     **/
	public List find(String cveId) {
		
		AsseKnowStatCVEThre statCVEThre = null;
		List list = getHibernateTemplate().find("from AsseKnowStatCVEThre where cveId=?", cveId);
		
		return list;
	}

	/**
     * 查询静态漏洞威胁数量
     * @return 静态漏洞威胁数量
     **/
	public int getCount() {
		
		Criteria criteria = getSession().createCriteria(AsseKnowStatCVEThre.class)
                                        .addOrder(Order.asc("id"));
		  return 0;//count(criteria);
	}

	/**
     * 返回所有静态漏洞威胁
     * @return 静态漏洞威胁列表
     **/
	public List<AsseKnowStatCVEThre> listAllStatCVEThre() {
		
		Criteria criteria = getSession().createCriteria(AsseKnowStatCVEThre.class)
		                                .addOrder(Order.asc("id"));
		return criteria.list();
	}

	/**
     * 根据静态威胁类别返回静态漏洞威胁列表
     * @param statThreKind
     *     静态威胁类别
     * @return 静态威胁列表
     **/
	public List<AsseKnowStatCVEThre> listStatCVEThre(
			AsseKnowStatThreKind statThreKind) {
		
		    Criteria criteria = getSession().createCriteria(AsseKnowStatCVEThre.class)
                                            .addOrder(Order.asc("id"));
		    if(statThreKind!=null) {
			   criteria.add(Expression.eq("threKind", statThreKind));
		    }
                     return criteria.list();
	}

	/**
     * 根据静态威胁编号返回静态漏洞威胁列表
     * @param threCode
     *    静态威胁编号
     * @return 静态漏洞威胁列表
     **/
	public List<AsseKnowStatCVEThre> listStatCVEThre(String threCode) {
		
		          
		Criteria criteria = getSession().createCriteria(AsseKnowStatCVEThre.class)
                                        .addOrder(Order.asc("id"));
                   if(threCode!=null && !"".equals(threCode)) {
                     criteria.add(Expression.eq("threCode", threCode));
                   }
                   return criteria.list();
	}

	/**
     * 查询静态漏洞威胁分页记录
     * @param page
     *     分页对象
     * @return 分页记录列表
     **/
	public List<AsseKnowStatCVEThre> listStatCVEThrePage(Page page) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowStatCVEThre.class)
                                        .addOrder(Order.asc("id"));
		if(page != null) {
			  criteria.setFirstResult(page.getBeginIndex())
                  .setMaxResults(page.getEveryPage());
		    }
                         return criteria.list();
	}

	/**
     * 删除静态漏洞威胁对象
     * @param statCVEThre
     *   静态漏洞威胁对象
     **/
	public void remove(AsseKnowStatCVEThre statCVEThre) {
		
		getHibernateTemplate().delete(statCVEThre);
	}

	/**
     * 保存/更新静态漏洞威胁对象
     * @param statCVEThre
     *    静态漏洞威胁对象
     **/
	public void saveOrUpdate(AsseKnowStatCVEThre statCVEThre) {
		
		getHibernateTemplate().saveOrUpdate(statCVEThre);
	}

	
	@SuppressWarnings("unchecked")
	public List<AsseKnowStatCVEThre> listStatCVEThreByCVEIdScale(List CVEIdList) {
		 Criteria criteria = getSession().createCriteria(AsseKnowStatCVEThre.class);
		 if(CVEIdList != null && CVEIdList.size()>0) {
			 criteria.add(Expression.in("cveId", CVEIdList));
         }else{
        	 criteria.add(Expression.eq("cveId", "0"));
         }
		 
		 List<AsseKnowStatCVEThre> list = criteria.list();
		 return list;
	}

}
