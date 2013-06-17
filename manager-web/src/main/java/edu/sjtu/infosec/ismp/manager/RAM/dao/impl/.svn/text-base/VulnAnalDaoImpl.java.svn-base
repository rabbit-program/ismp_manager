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
import org.springframework.beans.factory.config.SetFactoryBean;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.VulnAnalDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVuln;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 动态脆弱点分析Dao实现类.
 **/
public class VulnAnalDaoImpl extends HibernateDaoSupport implements VulnAnalDao {

	/**
     * 批量保存/更新动态脆弱点
     * 
     * @param dynaVulnPoints
     * 动态脆弱点列表
     **/
	@SuppressWarnings("unchecked")
	public void batchSaveOrUpdate(final List<AsseKnowDynaVuln> dynaVulnPoints) {
		
		getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException,SQLException {
                for(int i=0;i<dynaVulnPoints.size();i++) {
                	AsseKnowDynaVuln dynaVulnPoint = (AsseKnowDynaVuln) dynaVulnPoints.get(i);
                    session.saveOrUpdate(dynaVulnPoint); 
                    System.out.println("batch saved dynaVulnPoint:"+dynaVulnPoint.toString());
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
     * 查询动态脆弱点
     * 
     * @param id
     *    动态脆弱点id
     * @return 动态脆弱点对象
     **/
	public AsseKnowDynaVuln find(Integer id) {
		AsseKnowDynaVuln dynaVulnPoint = null;
		List list =this.getHibernateTemplate().find("from AsseKnowDynaVuln where id="+id);
		if(list!=null &&list.size()>0){
			dynaVulnPoint=(AsseKnowDynaVuln) list.get(0);
		}
		return dynaVulnPoint;
	}

	 /**
     * 查询动态脆弱点数量
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 动态脆弱点数量
     **/
	public int getCount(AsseInfoProj asseInfoProj,AsseInfoAsse asseInfoAsse) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaVuln.class,"dynaVuln");
		if(asseInfoProj!=null) {
			criteria.add(Expression.eq("dynaVuln.asseInfoProjId", asseInfoProj.getId()));
		}
		if(asseInfoAsse!=null) {
			criteria.add(Expression.eq("dynaVuln.asse", asseInfoAsse));
		}
		return criteria.list().size();
	}

	/**
     * 查询动态脆弱点分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @param asseInfoAsse
     *            资产
     * @return 分页记录列表
     **/
	@SuppressWarnings("unchecked")
	public List<AsseKnowDynaVuln> listDynaVulnPoint(int startResult,int maxResult,AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaVuln.class,"dynaVuln")
                                        .addOrder(Order.asc("dynaVuln.id"))
									    .setFirstResult(startResult)
									    .setMaxResults(maxResult);
		if(asseInfoProj!=null) {
			criteria.add(Expression.eq("dynaVuln.asseInfoProjId", asseInfoProj.getId()));
		}
		if(asseInfoAsse!=null) {
			criteria.add(Expression.eq("dynaVuln.asse", asseInfoAsse));
		}
		return criteria.list();
	}

	/**
     * 删除动态脆弱点
     * 
     * @param dynaVulnPoint
     * 动态脆弱点
     **/
	public void remove(AsseKnowDynaVuln dynaVulnPoint) {
		
		getHibernateTemplate().delete(dynaVulnPoint);
	}

	/**
     * 批量删除动态脆弱点
     * 
     * @param dynaVulnPoints
     *    动态脆弱点列表
     **/
	public void remove(List<AsseKnowDynaVuln> dynaVulnPoints) {
		
		getHibernateTemplate().deleteAll(dynaVulnPoints);
	}

	/**
     * 保存/更新动态脆弱点
     * 
     * @param dynaVulnPoint
     * 动态脆弱点
     **/
	public void saveOrUpdate(AsseKnowDynaVuln dynaVulnPoint) {
		
		getHibernateTemplate().saveOrUpdate(dynaVulnPoint);
	}

	/**
     * 检查是否已存在该脆弱点
     * @param asseInfoProjId
     *            测评项目Id
     * @param asseInfoAsse
     *            关联资产
     * @param asseKnowStatVulnPoinId
     *            脆弱点Id
     * @return 是否已存在
     **/
	public boolean checkExitDynaVulnPoint(Integer asseInfoProjId, AsseInfoAsse asseInfoAsse, 
			Integer asseKnowStatVulnPoinId) {
		boolean ret = false;
		Query query = getSession().createQuery("from AsseKnowDynaVuln where asseInfoProjId =:asseInfoProjId and asse=:asse and asseKnowStatVulnPoinId=:asseKnowStatVulnPoinId")
		                          .setParameter("asseInfoProjId", asseInfoProjId)
		                          .setParameter("asse", asseInfoAsse)
		                          .setParameter("asseKnowStatVulnPoinId", asseKnowStatVulnPoinId);
		List extList = query.list();
		if(extList!=null && extList.size()>0) {
			ret = true;
		}
		return ret;
	}

	/**
     * 查询动态脆弱点记录
     * @param asseInfoProj
     * @return 记录列表
     **/
	public List<AsseKnowDynaVuln> listDynaVulnPoint(Integer asseInfoProjId) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaVuln.class)
        .addOrder(Order.asc("id"));

         criteria.add(Expression.eq("asseInfoProjId", asseInfoProjId));
         return criteria.list();
	}

	/**
     * 查询动态脆弱点记录
     * @param asseInfoProj
     * 测评项目编号
     * @param asseKnowStatVulnKindId
     * 脆弱点类别编号
     * @return 记录列表
     **/
	public List<AsseKnowDynaVuln> listDynaVulnPointByKind(
			Integer asseInfoProjId, Integer asseKnowStatVulnKindId) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaVuln.class)
        .addOrder(Order.asc("id"))
        .add(Expression.eq("asseInfoProjId", asseInfoProjId))
        .add(Expression.eq("asseKnowStatVulnKindId", asseKnowStatVulnKindId));
         return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List listDynaVulnPointByKindDwr(String asseInfoProjId,
			String asseKnowStatVulnKindId) {
		return getHibernateTemplate().find("select id from AsseKnowDynaVuln where asseInfoProjId = "+asseInfoProjId+" and asseKnowStatVulnKindId = "+asseKnowStatVulnKindId);
	}
	
	/**
     * 查询严重性为高的动态脆弱点数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 严重性为高的动态脆弱点数目
     */
	public Long statHighSeriDynaVulnPoint(Integer asseInfoProjId) {
		Long count = new Long(0);
		List list = getHibernateTemplate().find("select COUNT(seriLeve) " +
                "from AsseKnowDynaVuln " +
                "where seriLeve='H' and asseInfoProjId=?",asseInfoProjId);
		if(list!=null && list.size()>0) {
			count = (Long) list.get(0);
		}
              return count;
	}
	
	/**
     * 查询严重性为中的动态脆弱点数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 严重性为中的动态脆弱点数目
     */
	public Long statMiddSeriDynaVulnPoint(Integer asseInfoProjId) {
		Long count = new Long(0);
		List list = getHibernateTemplate().find("select COUNT(seriLeve) " +
                "from AsseKnowDynaVuln " +
                "where seriLeve='M' and asseInfoProjId=?",asseInfoProjId);
		if(list!=null && list.size()>0) {
			count = (Long) list.get(0);
		}
              return count;
	}
	
	/**
     * 查询严重性为低的动态脆弱点数目
     * @param asseInfoProjId
     * 测评项目Id
     * @return 严重性为低的动态脆弱点数目
     */
	public Long statLowSeriDynaVulnPoint(Integer asseInfoProjId) {
		Long count = new Long(0);
		List list = getHibernateTemplate().find("select COUNT(seriLeve) " +
                "from AsseKnowDynaVuln " +
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
     * @return 不同资产各等级漏洞数目
     */
	public Integer statAsseDynaVulnPointNum(AsseInfoProj asseInfoProj, AsseInfoAsse asseInfoAsse, String seriLeve) {
		Criteria criteria = getSession().createCriteria(AsseKnowDynaVuln.class);
		if(asseInfoProj!=null) {
			criteria.add(Expression.eq("asseInfoProjId", asseInfoProj.getId()));
		}
		if(asseInfoAsse!=null) {
			criteria.add(Expression.eq("asse", asseInfoAsse));
		}
		if(seriLeve!=null) {
			criteria.add(Expression.eq("seriLeve", seriLeve));
		}
		Integer total = (Integer) criteria.setProjection(
                Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        return total;
	}

	public Object[] findByDwr(Integer id) {
		
		Object[] ret = new Object[2];
		Object[] dynaVulnPoint = null;
		String assetCode = "";
		List list1 = getHibernateTemplate().find("select id , asseKnowStatVulnPoinId, asseKnowStatVulnKindId, asseInfoBusiId, seriLeve, source, asseInfoProjId from AsseKnowDynaVuln where id = "+id);
		List list2 = getHibernateTemplate().find("select asse.assetCode from AsseKnowDynaVuln where id = "+id);
		if(list1!=null && list1.size()>0) {
			dynaVulnPoint = (Object[]) list1.get(0);
		}
		if(list2!=null && list2.size()>0) {
			assetCode = (String) list2.get(0);
		}
		ret[0] = dynaVulnPoint;
		ret[1] = assetCode;
		System.out.println(assetCode);
		return ret;
	}
}
