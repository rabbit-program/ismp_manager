package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaLeakThreDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeakThre;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 动态资产漏洞威胁分析Dao实现类.
 * 


 **/
public class DynaLeakThreDaoImpl extends HibernateDaoSupport implements DynaLeakThreDao {

	/**
     * 批量保存/更新动态资产漏洞威胁
     * 
     * @param dynaLeakThreList
     * 动态资产漏洞列表
     **/
	@SuppressWarnings("unchecked")
	public void batchSaveOrUpdate(final List<AsseKnowDynaLeakThre> dynaLeakThreList) {
		
		getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException,SQLException {
                for(int i=0;i<dynaLeakThreList.size();i++) {
                	AsseKnowDynaLeakThre dynaLeakThre = (AsseKnowDynaLeakThre) dynaLeakThreList.get(i);
                    session.saveOrUpdate(dynaLeakThre); 
                    System.out.println("batch saved dynaLeakThre:"+dynaLeakThre.toString());
                    if((i+1)%20 == 0){ 
                        session.flush();
                        session.clear();   
                    }
                  }
                return null;
            }
            
        });
	}

	/**
     * 检查是否已存在该资产漏洞威胁
     * @param asseInfoProjId
     *            测评项目Id
     * @param asseInfoAsse
     *            关联资产
     * @param asseKnowStatCveThreId
     *      静态威胁Id
     * @return 是否已存在
     **/
	public boolean checkExitDynaLeakThre(Integer asseInfoProjId,
			AsseInfoAsse asseInfoAsse, Integer asseKnowStatCveThreId) {
		
		   boolean ret = false;
		   Criteria criteria = getSession().createCriteria(AsseKnowDynaLeakThre.class)
                                           .addOrder(Order.asc("id"));
           if(asseInfoProjId!=null) {
                    criteria.add(Expression.eq("asseInfoProjId", asseInfoProjId));
           }

           if(asseInfoAsse!=null) {
                    criteria.add(Expression.eq("asse", asseInfoAsse));
           }

           if(asseKnowStatCveThreId!=null && !"".equals(asseKnowStatCveThreId)) {
                    criteria.add(Expression.eq("asseKnowStatCveThreId", asseKnowStatCveThreId));
           }
    
           List list = criteria.list();

           if(list!=null && list.size()>0) {
                      ret = true;
           }
		              return ret;
	}

	/**
     * 查询动态资产漏洞威胁
     * 
     * @param id
     *    动态资产漏洞威胁id
     * @return 动态资产漏洞威胁对象
     **/
	public AsseKnowDynaLeakThre find(Integer id) {
		AsseKnowDynaLeakThre leakThre = null;
		List list = this.getHibernateTemplate().find("from AsseKnowDynaLeakThre where id="+id);
		if(list!=null&&list.size()>0){
			leakThre=(AsseKnowDynaLeakThre) list.get(0);
		}
		return leakThre;
	}

	/**
     * 查询动态资产漏洞威胁数量
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 动态资产漏洞数量
     **/
	public int getCount(AsseInfoProj asseInfoProj, List<AsseInfoAsse> asseInfoAsse) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaLeakThre.class)
                                        .addOrder(Order.asc("id"));
              if(asseInfoProj!=null) {
                 criteria.add(Expression.eq("asseInfoProjId", asseInfoProj.getId()));
               }
              if(asseInfoAsse!=null) {
                 criteria.add(Expression.in("asse", asseInfoAsse));
               }
              return criteria.list().size();
	}

	/**
     * 查询动态资产漏洞威胁记录
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞记录列表
     **/
	public List<AsseKnowDynaLeakThre> listDynaLeakThre(AsseInfoProj asseInfoProj) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaLeakThre.class)
                                        .addOrder(Order.asc("id"));
                if(asseInfoProj!=null) {
                   criteria.add(Expression.eq("asseInfoProjId", asseInfoProj.getId()));
                }

                   return criteria.list();
	}


	/**
     * 保存/更新动态资产漏洞威胁
     * 
     * @param dynaLeakThre
     * 动态资产漏洞威胁
     **/
	public void saveOrUpdate(AsseKnowDynaLeakThre dynaLeakThre) {
		
		getHibernateTemplate().saveOrUpdate(dynaLeakThre);
	}

	/**
     * 查询可能性为高的动态漏洞威胁数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 可能性为高的动态漏洞威胁数目
     */
	public Long statHighPossDynaLeakThre(Integer asseInfoProjId) {
		Long count = new Long(0);
		List list = getHibernateTemplate().find("select COUNT(possibility) " +
                "from AsseKnowDynaLeakThre " +
                "where possibility='H' and asseInfoProjId=?",asseInfoProjId);
		if(list!=null && list.size()>0) {
			count = (Long) list.get(0);
		}
              return count;
	}
	
	/**
     * 查询可能性为中的动态漏洞威胁数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 可能性为中的动态漏洞威胁数目
     */
	public Long statMiddPossDynaLeakThre(Integer asseInfoProjId) {
		Long count = new Long(0);
		List list = getHibernateTemplate().find("select COUNT(possibility) " +
                "from AsseKnowDynaLeakThre " +
                "where possibility='M' and asseInfoProjId=?",asseInfoProjId);
		if(list!=null && list.size()>0) {
			count = (Long) list.get(0);
		}
              return count;
	}
	
	/**
     * 查询可能性为低的动态漏洞威胁点数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 可能性为低的动态漏洞威胁数目
     */
	public Long statLowPossDynaLeakThre(Integer asseInfoProjId) {
		Long count = new Long(0);
		List list = getHibernateTemplate().find("select COUNT(possibility) " +
                "from AsseKnowDynaLeakThre " +
                "where possibility='L' and asseInfoProjId=?",asseInfoProjId);
		if(list!=null && list.size()>0) {
			count = (Long) list.get(0);
		}
              return count;
	}

	/**
     * 不同可能性等级的漏洞威胁数量统计
     * @param asseInfoProj
     * 测评项目
     * @param asseInfoAsse
     * 资产
     * @param possibility
     * 严重级别
     * @return 不同可能性等级的漏洞威胁数量
     */
	public Integer statAsseDynaLeakThreNum(AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse, String possibility) {
		Criteria criteria = getSession().createCriteria(AsseKnowDynaLeakThre.class);
		if(asseInfoProj!=null) {
			criteria.add(Expression.eq("asseInfoProjId", asseInfoProj.getId()));
		}
		if(asseInfoAsse!=null) {
			criteria.add(Expression.eq("asse", asseInfoAsse));
		}
		if(possibility!=null) {
			criteria.add(Expression.eq("possibility", possibility));
		}
		Integer total = (Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        return total;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<AsseKnowDynaLeakThre> listDynaLeakThrePage(int startResult1,
			int maxResult1, AsseInfoProj asseInfoProj,List<AsseInfoAsse> asseInfo) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaLeakThre.class)
									        .addOrder(Order.asc("id"))
									        .setFirstResult(startResult1)
									        .setMaxResults(maxResult1);
		
		if(asseInfoProj!=null) {
		criteria.add(Expression.eq("asseInfoProjId", asseInfoProj.getId()));
		}
		
		if(asseInfo!=null) {
		criteria.add(Expression.in("asse", asseInfo));
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<AsseKnowDynaLeakThre> listByDynaLeakId(int dynaLeakId) {
		Criteria criteria = getSession().createCriteria(AsseKnowDynaLeakThre.class)
        			.addOrder(Order.asc("id"));
		if(dynaLeakId>0&&!"".equals(dynaLeakId)) {
			criteria.add(Expression.eq("dynaLeak.id", dynaLeakId));
		}else{
			criteria.add(Expression.eq("dynaLeak.id", 0));
		}
		return criteria.list();
	}
	
}
