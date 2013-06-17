package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaLeakDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaLeak;

/**
 * 数据层 动态资产漏洞分析Dao实现类.
 * 


 **/
public class DynaLeakDaoImpl extends HibernateDaoSupport implements DynaLeakDao {

	/**
     * 批量保存/更新动态资产漏洞
     * @param dynaLeakList
     * 动态资产漏洞列表
     **/
	@SuppressWarnings("unchecked")
	public void batchSaveOrUpdate(final List<AsseKnowDynaLeak> dynaLeakList) {
		
		getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException,SQLException {
                for(int i=0;i<dynaLeakList.size();i++) {
                	AsseKnowDynaLeak dynaLeak = (AsseKnowDynaLeak) dynaLeakList.get(i);
                    session.saveOrUpdate(dynaLeak); 
                    System.out.println("batch saved dynaLeak:"+dynaLeak.toString());
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
     * 检查是否已存在该资产漏洞
     * @param asseInfoProjId
     *            测评项目Id
     * @param asseInfoAsse
     *            关联资产
     * @param pluginId
     *      插件Id
     * @param vulId
     *      漏洞Id
     * @return 是否已存在
     **/
	public boolean checkExitDynaLeak(Integer asseInfoProjId,
			AsseInfoAsse asseInfoAsse, String pluginId, String vulId) {
		
		boolean ret = false;
		Criteria criteria = getSession().createCriteria(AsseKnowDynaLeak.class)
                                        .addOrder(Order.asc("id"));
       if(asseInfoProjId!=null) {
           criteria.add(Restrictions.eq("asseInfoProjId", asseInfoProjId));
        }
       
       if(asseInfoAsse!=null) {
           criteria.add(Restrictions.eq("asse", asseInfoAsse));
        }
       
       if(pluginId!=null && !"".equals(pluginId)) {
           criteria.add(Restrictions.eq("pluginId", pluginId));
        }
       
       if(vulId!=null && !"".equals(vulId)) {
           criteria.add(Restrictions.eq("vulId", vulId));
        }
       
        List list = criteria.list();
        
        if(list!=null && list.size()>0) {
        	ret = true;
        }
        
		return ret;
	}

	/**
     * 查询动态资产漏洞
     * @param id
     *    动态资产漏洞id
     * @return 动态资产漏洞对象
     **/
	public AsseKnowDynaLeak find(Integer id) {
		AsseKnowDynaLeak dynaLeak= null;
		List list =this.getHibernateTemplate().find("from AsseKnowDynaLeak where id="+id);
		if(list!=null&&list.size()>0){
			dynaLeak=(AsseKnowDynaLeak) list.get(0);
		}
		return dynaLeak;
	}

	/**
     * 查询动态资产漏洞数量
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 动态资产漏洞数量
     **/
	public int getCount(AsseInfoProj asseInfoProj, List<AsseInfoAsse> asseInfoAsse) {
		
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaLeak.class)
		                                .addOrder(Order.asc("id"));
		if(asseInfoProj!=null) {
			criteria.add(Restrictions.eq("asseInfoProjId", asseInfoProj.getId()));
		}
		if(asseInfoAsse!=null&&asseInfoAsse.size()>0) {
			criteria.add(Restrictions.in("asse", asseInfoAsse));
		}
		  return criteria.list().size();
	}

	/**
     * 查询动态资产漏洞记录
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞记录列表
     **/
	public List<AsseKnowDynaLeak> listDynaLeak(AsseInfoProj asseInfoProj) {
		
		
		     Criteria criteria = getSession().createCriteria(AsseKnowDynaLeak.class)
                                             .addOrder(Order.asc("id"));
             if(asseInfoProj!=null) {
              criteria.add(Restrictions.eq("asseInfoProjId", asseInfoProj.getId()));
             }

             return criteria.list();
            
	}

	/**
     * 查询动态资产漏洞分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 分页记录列表
     **/	
	
    public List<AsseKnowDynaLeak> listDynaLeakPage(int startResult,int maxResult, AsseInfoProj asseInfoProj,List<AsseInfoAsse> asseInfoAsse) {
  
		Criteria criteria = getSession().createCriteria(AsseKnowDynaLeak.class)
                                       .addOrder(Order.asc("id"))
                                       .setFirstResult(startResult)
                                       .setMaxResults(maxResult);
           if(asseInfoProj!=null) {
              criteria.add(Restrictions.eq("asseInfoProjId", asseInfoProj.getId()));
            }
           
           if(asseInfoAsse!=null&&asseInfoAsse.size()>0) {
              criteria.add(Restrictions.in("asse", asseInfoAsse));
            }
           
              return criteria.list();
	}

	/**
     * 保存/更新动态资产漏洞
     * @param dynaLeak
     * 动态资产漏洞
     **/
	public void saveOrUpdate(AsseKnowDynaLeak dynaLeak) {
		
		  getHibernateTemplate().saveOrUpdate(dynaLeak);
	}
	
	/**
     * 查询严重性为高的动态资产漏洞数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 严重性为高的动态资产漏洞数目
     */
	public Long statHighRiskLeak(Integer asseInfoProjId) {
		Long count = new Long(0);
		List list = getHibernateTemplate().find("select COUNT(seriLeve) " +
                "from AsseKnowDynaLeak " +
                "where seriLeve='H' and asseInfoProjId=?",asseInfoProjId);
		if(list!=null && list.size()>0) {
			count = (Long) list.get(0);
		}
              return count;
	}
	
	/**
     * 查询严重性为中的动态资产漏洞数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 严重性为中的动态资产漏洞数目
     */
	public Long statMiddRiskLeak(Integer asseInfoProjId) {
		Long count = new Long(0);
		List list = getHibernateTemplate().find("select COUNT(seriLeve) " +
                "from AsseKnowDynaLeak " +
                "where seriLeve='M' and asseInfoProjId=?",asseInfoProjId);
		if(list!=null && list.size()>0) {
			count = (Long) list.get(0);
		}
              return count;
	}
	
	/**
     * 查询严重性为低的动态资产漏洞数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 严重性为低的动态资产漏洞数目
     */
	public Long statLowRiskLeak(Integer asseInfoProjId) {
		Long count = new Long(0);
		List list = getHibernateTemplate().find("select COUNT(seriLeve) " +
                "from AsseKnowDynaLeak " +
                "where seriLeve='L' and asseInfoProjId=?",asseInfoProjId);
		if(list!=null && list.size()>0) {
			count = (Long) list.get(0);
		}
              return count;
	}
	
	/**
     * 不同资产各等级漏洞数目统计
     * @param asseInfoProj
     * 测评项目
     * @param asseInfoAsse
     * 资产
     * @param seriLeve
     * 严重级别
     * @return 严重性为低的动态脆弱点数目
     */
	public Integer statDynaLeakNum(AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse, String seriLeve) {
		Criteria criteria = getSession().createCriteria(AsseKnowDynaLeak.class);
		if(asseInfoProj!=null) {
			criteria.add(Restrictions.eq("asseInfoProjId", asseInfoProj.getId()));
		}
		if(asseInfoAsse!=null) {
			criteria.add(Restrictions.eq("asse", asseInfoAsse));
		}
		if(seriLeve!=null) {
			criteria.add(Restrictions.eq("seriLeve", seriLeve));
		}
		Integer total = (Integer) criteria.setProjection(
                Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        return total;
	}


}
