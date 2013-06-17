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

import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaAsseResuDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaAsseResu;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 知识库项目动态评估结果Dao实现类.
 **/
public class DynaAsseResuDaoImpl extends HibernateDaoSupport implements DynaAsseResuDao {

	/**
     * 查询项目动态评估结果
     * @param id
     * 动态评估结果id
     * @return 动态评估结果对象
     **/
	public AsseKnowDynaAsseResu find(Integer id) {
		
		AsseKnowDynaAsseResu dynaAsseResu = null;
		dynaAsseResu = (AsseKnowDynaAsseResu) getHibernateTemplate().load(AsseKnowDynaAsseResu.class, id);
		return dynaAsseResu;
	}

	

	/**
     * 查询项目总体评估值记录数
     * @param asseInfoProjId
     * 测评项目id
     * @return 项目总体评估值记录数
     **/
	public int getCount(Integer asseInfoProjId) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaAsseResu.class)
        .addOrder(Order.asc("id"));
           if(asseInfoProjId!=null ) {
             criteria.add(Expression.eq("asseInfoProjId", asseInfoProjId));
           }
        return 0;//count(criteria);
	}

	/**
     * 返回项目动态评估结果列表
     * @param asseInfoProjId
     * 测评项目id
     * @return 项目动态评估结果列表
     **/
	public List<AsseKnowDynaAsseResu> listDynaAsseResu(Integer asseInfoProjId) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaAsseResu.class)
                                        .addOrder(Order.asc("id"));
          if(asseInfoProjId!=null ) {
             criteria.add(Expression.eq("asseInfoProjId", asseInfoProjId));
           }
         return criteria.list();
	}

	/**
     * 查询项目动态评估结果分页记录
     * @param page
     * 分页对象
     * @param asseInfoProjId
     * 测评项目id
     * @return 分页记录列表
     **/
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<AsseKnowDynaAsseResu> listDynaAsseResuPage(Page page,
			Integer asseInfoProjId) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaAsseResu.class)
                                        .addOrder(Order.asc("id"));
		   if(page!=null) {
			criteria.setFirstResult(page.getBeginIndex());
			criteria.setMaxResults(page.getEveryPage());
		   }
           if(asseInfoProjId!=null ) {
             criteria.add(Expression.eq("asseInfoProjId", asseInfoProjId));
           }
         return criteria.list();
	}

	/**
     * 删除项目动态评估结果
     * @param dynaAsseResu
     *     项目动态评估结果
     **/
	public void remove(AsseKnowDynaAsseResu dynaAsseResu) {
		
		getHibernateTemplate().delete(dynaAsseResu);
	}

	/**
     * 保存/更新项目动态评估结果
     * @param dynaAsseResu
     *     项目动态评估结果
     **/
	public void saveOrUpdate(AsseKnowDynaAsseResu dynaAsseResu) {
		
		getHibernateTemplate().saveOrUpdate(dynaAsseResu);
	}

	/**
     * 批量保存/更新项目动态评估结果
     * @param dynaAsseResuList
     *     项目动态评估结果集合
     **/
	@SuppressWarnings("unchecked")
	public void batchSaveOrUpdate(final List<AsseKnowDynaAsseResu> dynaAsseResuList) {
		
		getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				 for(int i=0;i<dynaAsseResuList.size();i++) {
	                	AsseKnowDynaAsseResu dynaAsseResu = (AsseKnowDynaAsseResu) dynaAsseResuList.get(i);
	                    session.merge(dynaAsseResu); 
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
     * 统计此次项目资产风险值
     * @param asseInfoProjId
     * 测评项目id
     * @return 分页记录列表
     **/
	public List listRiskNumByAsse(Integer asseInfoProjId) {

		String sql="select asse_info_asse_id," +
				"sum(risk_valu='H') as high," +
				"sum(risk_valu='M') as middum," +
				"sum(risk_valu='L') as low " +
				"from ram_know_dyna_asse_resu "+
				"where asse_info_proj_id = "+asseInfoProjId+
				" group by asse_info_asse_id" ;
		return getSession().createSQLQuery(sql).list();
	}

}
