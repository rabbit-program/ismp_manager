package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaElemResuDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaElemResu;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 知识库资产评估要素结果Dao实现类.
 **/
public class DynaElemResuDaoImpl extends HibernateDaoSupport implements DynaElemResuDao {

	/**
     * 批量保存/更新项目资产评估要素
     * @param dynaElemResuList
     *    资产评估要素集合
     **/
	@SuppressWarnings("unchecked")
	public void batchSaveOrUpdate(final List<AsseKnowDynaElemResu> dynaElemResuList) {
		
		getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException,SQLException {
                for(int i=0;i<dynaElemResuList.size();i++) {
                	AsseKnowDynaElemResu dynaElemResu = (AsseKnowDynaElemResu) dynaElemResuList.get(i);
                    session.saveOrUpdate(dynaElemResu); 
                    System.out.println("batch saved dynaElemResu:"+dynaElemResu.toString());
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
     * 查询项目资产评估要素
     * @param id
     * 资产评估要素id
     * @return 资产评估要素对象
     **/
	public AsseKnowDynaElemResu find(Integer id) {
		
		AsseKnowDynaElemResu dynaElemResu = null;
		dynaElemResu = (AsseKnowDynaElemResu) getHibernateTemplate().load(AsseKnowDynaElemResu.class, id);
		return dynaElemResu;
	}

	/**
     * 查询项目资产评估要素记录数
     * @param asseInfoProjId
     * 测评项目id
     * @return 项目资产评估要素记录数
     **/
	public int getCount(Integer asseInfoProjId) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaElemResu.class)
                                        .addOrder(Order.asc("id"));
           if(asseInfoProjId!=null ) {
             criteria.add(Expression.eq("asseInfoProjId", asseInfoProjId));
           }
           return criteria.list().size();
	}

	/**
     * 返回项目资产评估要素列表
     * @param asseInfoProjId
     * 测评项目id
     * @return 项目资产评估要素列表
     **/
	public List<AsseKnowDynaElemResu> listDynaElemResu(Integer asseInfoProjId) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaElemResu.class)
                                        .addOrder(Order.asc("id"));

        if(asseInfoProjId!=null ) {
                 criteria.add(Expression.eq("asseInfoProjId", asseInfoProjId));
        }
        return criteria.list();
	}

	/**
     * 查询项目资产评估要素分页记录
     * @param page
     * 分页对象
     * @param asseInfoProjId
     * 测评项目id
     * @return 分页记录列表
     **/
	@SuppressWarnings("unchecked")
	public List<AsseKnowDynaElemResu> listDynaElemResuPage(Integer startResult, Integer maxResult,Integer asseInfoProjId) {
		   
		Criteria criteria = getSession().createCriteria(AsseKnowDynaElemResu.class)
                                        .addOrder(Order.asc("id"))
                                        .setFirstResult(startResult)
										.setMaxResults(maxResult);
        if(asseInfoProjId!=null ) {
           criteria.add(Expression.eq("asseInfoProjId", asseInfoProjId));
         }
        return criteria.list();
	}

	/**
     * 删除项目资产评估要素
     * @param dynaElemResu
     *     项目资产评估要素
     **/
	public void remove(AsseKnowDynaElemResu dynaElemResu) {
		
		getHibernateTemplate().delete(dynaElemResu);
	}

	/**
     * 保存/更新项目资产评估要素
     * @param dynaElemResu
     *     项目资产评估要素
     **/
	public void saveOrUpdate(AsseKnowDynaElemResu dynaElemResu) {
		
		getHibernateTemplate().saveOrUpdate(dynaElemResu);
	}

	/**
     * 统计风险值
     * @param asseInfoProjId
     * 测评项目id
     * @return 风险值
     **/
	public List statRiskValue(Integer asseInfoProjId) {
		
		List list = getHibernateTemplate().find("select sum(vulnHighNum) ,sum(vulnMiduNum) ,sum(vulnLowNum) " +
				                                "from AsseKnowDynaElemResu " +
				                                "where asseInfoProjId=?",asseInfoProjId);
		return list;
	}
	
	/**
     * 查询风险为高的资产数目
     * @param asseInfoProjId
     * 测评项目Id
     * @param asseInfoAsse
     * 资产
     * @return 风险为高的资产数目
     */
	public Integer statHighRiskAsse(Integer asseInfoProjId, AsseInfoAsse asseInfoAsse) {
		Integer count = new Integer(0);
		List list = getHibernateTemplate().find("select vulnHighNum " +
                "from AsseKnowDynaElemResu " +
                "where asseInfoProjId='"+asseInfoProjId+"' and asse=?",asseInfoAsse);
		if(list!=null && list.size()>0) {
			count = (Integer) list.get(0);
		}
              return count;
	}
	
	/**
     * 风险为中的资产数目
     * @param asseInfoProjId
     * 测评项目Id
     * @param asseInfoAsse
     * 资产
     * @return 风险为中的资产数目
     */
	public Integer statMiddRiskAsse(Integer asseInfoProjId, AsseInfoAsse asseInfoAsse) {
		Integer count = new Integer(0);
		List list = getHibernateTemplate().find("select vulnMiduNum " +
                "from AsseKnowDynaElemResu " +
                "where asseInfoProjId='"+asseInfoProjId+"' and asse=?",asseInfoAsse);
		if(list!=null && list.size()>0) {
			count = (Integer) list.get(0);
		}
              return count;
	}
	
	/**
     * 风险为低的资产数目
     * @param asseInfoProjId
     * 测评项目Id
     * @param asseInfoAsse
     * 资产
     * @return 风险为低的资产数目
     */
	public Integer statLowRiskAsse(Integer asseInfoProjId, AsseInfoAsse asseInfoAsse) {
		Integer count = new Integer(0);
		List list = getHibernateTemplate().find("select vulnLowNum " +
                "from AsseKnowDynaElemResu " +
                "where asseInfoProjId='"+asseInfoProjId+"' and asse=?",asseInfoAsse);
		if(list!=null && list.size()>0) {
			count = (Integer) list.get(0);
		}
              return count;
	}

	public boolean checkAlertType(String type, String subType, String category) {/*
		boolean ret = false;
		List<AlertTypeBO> parent = getHibernateTemplate().find("from AlertTypeBO where typeMarker = 1 and category = '"+type+"'");
		AlertTypeBO parentAlertType = null;
		for(AlertTypeBO alertType : parent) {
			parentAlertType = alertType;
		}
		if(parentAlertType != null) {
			List alertTypeList = getHibernateTemplate().find("from AlertTypeBO where typeMarker = 2 and parentId = "+parentAlertType.getId()
					             +" and typeName = '"+subType+"' and category = '"+category+"'");
		    if(alertTypeList != null && alertTypeList.size()>0) {
		    	ret = true;
		    }
		}
		return ret;
	*/	return false;
		}

	/*public void sendAlert(AlertInfoBO alertInfo) {
		getHibernateTemplate().saveOrUpdate(alertInfo);
	}*/

}
