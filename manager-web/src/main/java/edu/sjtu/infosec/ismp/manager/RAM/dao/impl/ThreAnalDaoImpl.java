package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.ThreAnalDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVuln;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnPoin;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 动态威胁分析Dao实现类.
 * 


 **/
public class ThreAnalDaoImpl extends HibernateDaoSupport implements ThreAnalDao {

	/**
     * 批量保存/更新动态威胁
     * 
     * @param dynaThres
     * 动态威胁列表
     **/
	@SuppressWarnings("unchecked")
	public void batchSaveOrUpdate(final List<AsseKnowDynaThre> dynaThres) {
		
		getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException,SQLException {
                for(int i=0;i<dynaThres.size();i++) {
                	AsseKnowDynaThre dynaThre = (AsseKnowDynaThre) dynaThres.get(i);
                    session.saveOrUpdate(dynaThre); 
                    System.out.println("batch saved dynaThre:"+dynaThre.toString());
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
     * 检查是否已存在该威胁
     * @param asseInfoProjId
     *            测评项目Id
     * @param asseInfoAsse
     *            关联资产
     * @param asseKnowStatThreId
     *            威胁Id
     * @return 是否已存在
     **/
	public boolean checkExitDynaVulnPoint(Integer asseInfoProjId,
			AsseInfoAsse asseInfoAsse, Integer asseKnowStatThreKindId,  Integer asseKnowStatThreId) {
		
		boolean ret = false;
		Query query = getSession().createQuery("from AsseKnowDynaThre where asseInfoProjId =:asseInfoProjId and asse=:asse and asseKnowStatThreKindId=:asseKnowStatThreKindId and asseKnowStatThreId=:asseKnowStatThreId")
		                          .setParameter("asseInfoProjId", asseInfoProjId)
		                          .setParameter("asse", asseInfoAsse)
		                          .setParameter("asseKnowStatThreKindId", asseKnowStatThreKindId)
		                          .setParameter("asseKnowStatThreId", asseKnowStatThreId);
		List extList = query.list();
		if(extList!=null && extList.size()>0) {
			ret = true;
		}
		return ret;
	}

	/**
     * 查询动态威胁
     * 
     * @param id
     *    动态威胁id
     * @return 动态威胁对象
     **/
	public AsseKnowDynaThre find(Integer id) {
		
		AsseKnowDynaThre asseKnowDynaThre =null;
	        String hql = "from AsseKnowDynaThre where id = "+id;
	        List list = this.getHibernateTemplate().find(hql);
	        if(list!=null &&list.size()>0){
	        	asseKnowDynaThre = (AsseKnowDynaThre) list.get(0);
	        }
		return asseKnowDynaThre;
	}

	/**
     * 查询动态威胁数量
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 动态威胁数量
     **/
	public int getCount(AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaThre.class);
		if(asseInfoProj!=null) {
			criteria.add(Expression.eq("asseInfoProjId", asseInfoProj.getId()));
		}
		if(asseInfoAsse!=null) {
			criteria.add(Expression.eq("asse", asseInfoAsse));
		}
		  return criteria.list().size();
	}

	/**
     * 查询动态威胁分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 分页记录列表
     **/
	public List<AsseKnowDynaThre> listDynaThrePage(Page page,
			AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaThre.class)
        .addOrder(Order.asc("id"));
        if(page != null) {
             criteria.setFirstResult(page.getBeginIndex())
                     .setMaxResults(page.getEveryPage());
         }
        if(asseInfoProj!=null) {
             criteria.add(Expression.eq("asseInfoProjId", asseInfoProj.getId()));
         }
        if(asseInfoAsse!=null) {
             criteria.add(Expression.eq("asse", asseInfoAsse));
        }
         return criteria.list();
	}

	/**
     * 删除动态威胁
     * 
     * @param dynaThre
     * 动态威胁
     **/
	public void remove(AsseKnowDynaThre dynaThre) {
		
		getHibernateTemplate().delete(dynaThre);
	}

	/**
     * 批量删除动态威胁
     * 
     * @param dynaThres
     *    动态威胁列表
     **/
	public void remove(List<AsseKnowDynaThre> dynaThres) {
		
		getHibernateTemplate().deleteAll(dynaThres);
	}

	/**
     * 保存/更新动态威胁
     * 
     * @param dynaThre
     * 动态威胁
     **/
	public void saveOrUpdate(AsseKnowDynaThre dynaThre) {
		
		getHibernateTemplate().saveOrUpdate(dynaThre);
	}

	/**
     * 查询动态威胁记录
     * @param asseInfoProjId
     *            测评项目Id
     * @return 记录列表
     **/
	public List<AsseKnowDynaThre> listDynaThre(Integer asseInfoProjId) {
		Criteria criteria = getSession().createCriteria(AsseKnowDynaThre.class)
        .addOrder(Order.asc("id"));
        
         criteria.add(Expression.eq("asseInfoProjId", asseInfoProjId));
         return criteria.list();
	}

	/**
     * 查询脆弱点威胁关联分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @param dynaVuln
     *       动态脆弱点
     * @return 分页记录列表
     **/
	public List<AsseKnowDynaThre> listDynaVulnThrePage(Page page,
			AsseInfoProj asseInfoProj, AsseKnowDynaVuln dynaVuln) {
		Criteria criteria = getSession().createCriteria(AsseKnowDynaThre.class,"dynaThre")
        .addOrder(Order.asc("dynaThre.id"));
        if(page != null) {
             criteria.setFirstResult(page.getBeginIndex())
                     .setMaxResults(page.getEveryPage());
         }
        if(asseInfoProj!=null) {
             criteria.add(Expression.eq("dynaThre.asseInfoProjId", asseInfoProj.getId()));
         }
        if(dynaVuln!=null) {
        	  criteria.add(Expression.eq("dynaThre.dynaVuln", dynaVuln));
        }
         return criteria.list();
	}

	/**
     * 查询动态威胁数量
     * @param asseInfoProj
     *            测评项目
     * @param dynaVuln
     *            动态脆弱点
     * @return 动态威胁数量
     **/
	@SuppressWarnings("deprecation")
	public int getCount(AsseInfoProj asseInfoProj, AsseKnowDynaVuln dynaVuln) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaThre.class,"dynaThre");
		if(asseInfoProj!=null) {
			criteria.add(Expression.eq("dynaThre.asseInfoProjId", asseInfoProj.getId()));
		}
		if(dynaVuln!=null) {
			criteria.add(Expression.eq("dynaThre.dynaVuln", dynaVuln));
		}
		  return criteria.list().size();
	}
	
	/**
     * 查询可能性为高的动态威胁数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 可能性为高的动态威胁数目
     */
	public Long statHighPossDynaThre(Integer asseInfoProjId) {
		Long count = new Long(0);
		List list = getHibernateTemplate().find("select COUNT(possibility) " +
                "from AsseKnowDynaThre " +
                "where possibility='H' and asseInfoProjId=?",asseInfoProjId);
		if(list!=null && list.size()>0) {
			count = (Long) list.get(0);
		}
              return count;
	}
	
	/**
     * 查询可能性为中的动态威胁数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 可能性为中的动态威胁数目
     */
	public Long statMiddPossDynaThre(Integer asseInfoProjId) {
		Long count = new Long(0);
		List list = getHibernateTemplate().find("select COUNT(possibility) " +
                "from AsseKnowDynaThre " +
                "where possibility='M' and asseInfoProjId=?",asseInfoProjId);
		if(list!=null && list.size()>0) {
			count = (Long) list.get(0);
		}
              return count;
	}
	
	/**
     * 查询可能性为低的动态威胁点数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 可能性为低的动态威胁数目
     */
	public Long statLowPossDynaThre(Integer asseInfoProjId) {
		Long count = new Long(0);
		List list = getHibernateTemplate().find("select COUNT(possibility) " +
                "from AsseKnowDynaThre " +
                "where possibility='L' and asseInfoProjId=?",asseInfoProjId);
		if(list!=null && list.size()>0) {
			count = (Long) list.get(0);
		}
              return count;
	}

	/**
     * 不同可能性等级的威胁数量统计
     * @param asseInfoProj
     * 测评项目
     * @param asseInfoAsse
     * 资产
     * @param possibility
     * 严重级别
     * @return 不同可能性等级的威胁数量
     */
	public Integer statAsseDynaThreNum(AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse, String possibility) {
		Criteria criteria = getSession().createCriteria(AsseKnowDynaThre.class);
		if(asseInfoProj!=null) {
			criteria.add(Expression.eq("asseInfoProjId", asseInfoProj.getId()));
		}
		if(asseInfoAsse!=null) {
			criteria.add(Expression.eq("asse", asseInfoAsse));
		}
		if(possibility!=null) {
			criteria.add(Expression.eq("possibility", possibility));
		}
		Integer total = (Integer) criteria.setProjection(
                Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        return total;
	}

	public Object[] findByDwr(String id) {
		Object[] dynaThre = null;
		List list = getHibernateTemplate().find("select id, asse.assetCode, dynaVuln.id, asseKnowStatThreId, threCode, asseKnowStatThreKindId, possibility, asseInfoProjId from AsseKnowDynaThre where id = "+id);
		if(list!=null && list.size()>0) {
			dynaThre = (Object[]) list.get(0);
		}else{
			List list1 = getHibernateTemplate().find("select id, id, dynaVuln.id, asseKnowStatThreId, threCode, asseKnowStatThreKindId, possibility, asseInfoProjId from AsseKnowDynaThre where id = "+id);
			if(list1!=null && list1.size()>0) {
				dynaThre = null;
				dynaThre = (Object[]) list1.get(0);
				dynaThre[1]="";
			}
		}
		return dynaThre;
	}

	@SuppressWarnings("unchecked")
	public List<AsseKnowDynaThre> findAll(int startResult, int maxResult,
			AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse) {
		Criteria criteria = getSession().createCriteria(AsseKnowDynaThre.class,"dynaThre")
        .addOrder(Order.asc("dynaThre.id"))
        .setFirstResult(startResult)
        .setMaxResults(maxResult);
		
        if(asseInfoProj!=null) {
             criteria.add(Expression.eq("dynaThre.asseInfoProjId", asseInfoProj.getId()));
         }
        if(asseInfoAsse!=null) {
        	  criteria.add(Expression.eq("dynaThre.asse", asseInfoAsse));
        }
         return criteria.list();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<AsseKnowDynaThre> listAllByVuln(int startResult, int maxResult,
			AsseInfoProj asseInfoProj, AsseKnowDynaVuln dynaVulnPoint) {
		Criteria criteria = getSession().createCriteria(AsseKnowDynaThre.class,"dynaThre")
											        .addOrder(Order.asc("dynaThre.id"))
													.setFirstResult(startResult)
													.setMaxResults(maxResult);
        if(asseInfoProj!=null) {
             criteria.add(Expression.eq("dynaThre.asseInfoProjId", asseInfoProj.getId()));
         }
        if(dynaVulnPoint!=null) {
        	  criteria.add(Expression.eq("dynaThre.dynaVuln", dynaVulnPoint));
        }
         return criteria.list();
	}

	public List<AsseKnowDynaThre> ListThreByVulnId(int vulnId) {
		Criteria criteria = getSession().createCriteria(AsseKnowDynaThre.class,"dynaThre")
        						.addOrder(Order.asc("dynaThre.id"));
		if(!"".equals(vulnId)&&vulnId>0){
			 criteria.add(Expression.eq("dynaThre.dynaVuln.id", vulnId));
		}else{
			criteria.add(Expression.eq("dynaThre.dynaVuln.id", 0));
		}
		return criteria.list();
	}

}
