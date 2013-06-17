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

import edu.sjtu.infosec.ismp.manager.RAM.dao.DynaVTARepoDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVTARepo;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 知识库动态V-T-A-R评估报告Dao实现类.
 **/
public class DynaVTARepoDaoImpl extends HibernateDaoSupport implements DynaVTARepoDao {

	/**
     * 批量保存/更新V-T-A-R评估记录
     * @param dynaVTARepoList
     *    V-T-A-R评估记录集合
     **/
	@SuppressWarnings("unchecked")
	public void batchSaveOrUpdate(final List<AsseKnowDynaVTARepo> dynaVTARepoList) {
		
		getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException,SQLException {
                for(int i=0;i<dynaVTARepoList.size();i++) {
                	AsseKnowDynaVTARepo dynaVTARepo = (AsseKnowDynaVTARepo) dynaVTARepoList.get(i);
                    session.merge(dynaVTARepo); 
                    System.out.println("batch saved dynaVTARepo:"+dynaVTARepo.toString());
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
     * 查询项目V-T-A-R评估记录
     * @param id
     * V-T-A-R评估记录id
     * @return V-T-A-R评估记录对象
     **/
	public AsseKnowDynaVTARepo find(Integer id) {
		
		AsseKnowDynaVTARepo dynaVTARepo = null;
		dynaVTARepo = (AsseKnowDynaVTARepo) getHibernateTemplate().load(AsseKnowDynaVTARepo.class, id);
		return dynaVTARepo;
	}

	/**
     * 查询项目V-T-A-R评估记录数
     * @param asseInfoProj
     * 测评项目
     * @return 项目V-T-A-R评估记录数
     **/
	public int getCount(AsseInfoProj asseInfoProj) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaVTARepo.class)
        .addOrder(Order.asc("id"));

        if(asseInfoProj!=null ) {
           criteria.add(Expression.eq("asseInfoProj", asseInfoProj));
        }

        return criteria.list().size();
	}

	/**
     * 返回项目V-T-A-R评估记录列表
     * @param asseInfoProj
     * 测评项目
     * @return 项目V-T-A-R评估记录列表
     **/
	public List<AsseKnowDynaVTARepo> listDynaVTARepo(AsseInfoProj asseInfoProj) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaVTARepo.class)
        .addOrder(Order.asc("id"));

        if(asseInfoProj!=null ) {
           criteria.add(Expression.eq("asseInfoProj", asseInfoProj));
        }
        return criteria.list();
	}

	/**
     * 查询项目V-T-A-R评估记录分页记录
     * @param page
     * 分页对象
     * @param asseInfoProj
     * 测评项目
     * @return 分页记录列表
     **/
	public List<AsseKnowDynaVTARepo> listDynaVTARepoPage(Page page,
			AsseInfoProj asseInfoProj) {
		
		Criteria criteria = getSession().createCriteria(AsseKnowDynaVTARepo.class)
        .addOrder(Order.asc("id"));
        
		if(page!=null) {
			criteria.setFirstResult(page.getBeginIndex());
			criteria.setMaxResults(page.getEveryPage());
		 }
		
        if(asseInfoProj!=null ) {
           criteria.add(Expression.eq("asseInfoProj", asseInfoProj));
        }
        return criteria.list();
	}

	/**
     * 删除项目V-T-A-R评估记录
     * @param dynaVTARepo
     * 项目V-T-A-R评估记录
     **/
	public void remove(AsseKnowDynaVTARepo dynaVTARepo) {
		
		getHibernateTemplate().delete(dynaVTARepo);
	}

	/**
     * 保存/更新项目V-T-A-R评估记录
     * @param dynaVTARepo
     * 项目V-T-A-R评估记录
     **/
	public void saveOrUpdate(AsseKnowDynaVTARepo dynaVTARepo) {
		
		getHibernateTemplate().saveOrUpdate(dynaVTARepo);
	}

	
	public List executeHQL(String hql) {
		
		return getHibernateTemplate().find(hql);
	}

}
