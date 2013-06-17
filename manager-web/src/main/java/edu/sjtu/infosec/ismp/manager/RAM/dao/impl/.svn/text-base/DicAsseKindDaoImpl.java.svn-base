package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DicAsseKindDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 资产类型数据字典Dao实现类.
 * 
 */
public class DicAsseKindDaoImpl extends HibernateDaoSupport implements DicAsseKindDao{

    /**
     * 查询资产类型
     * 
     * @param assetKindId
     *            资产类型编号
     * @return 资产类型对象
     */
    public AsseKnowDicAsseKind find(String assetKindId) {
        AsseKnowDicAsseKind asseKind = null;
        List asseKindList = getHibernateTemplate().find("from AsseKnowDicAsseKind dicAsseKind where dicAsseKind.assetKindId = ?", assetKindId);
        if(asseKindList!=null && asseKindList.size() >0 ) {
            asseKind = (AsseKnowDicAsseKind) asseKindList.get(0);
        }
        return asseKind;
    }

    /**
     * 查询资产类型
     * 
     * @param id
     *            资产类型id
     * @return 资产类型对象
     */
    @SuppressWarnings("unchecked")
	public AsseKnowDicAsseKind find(Integer id) {
        AsseKnowDicAsseKind asseKind = null;
        List asseKindLists=this.getHibernateTemplate().find("from AsseKnowDicAsseKind where id="+id);
        if(asseKindLists!=null && asseKindLists.size()>0){
        	asseKind = (AsseKnowDicAsseKind) asseKindLists.get(0);
        }
        return asseKind;
    }
    
    /**
     * 查询资产类型记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 资产类型记录数
     */
    public int getCount(Map paramMap) {
        
        Criteria criteria = getSession().createCriteria(AsseKnowDicAsseKind.class);
        criteria.setProjection(Projections.rowCount())
                .setMaxResults(1)
                .uniqueResult();
        
        if(paramMap!=null) {
            if(paramMap.get("assetKindName")!=null) {
              criteria.add(Expression.like("assetKindName", "%"+((String) paramMap.get("assetKindName")).trim()+"%"));
       
            }
        }
        return ((Integer) criteria.list().get(0)).intValue();
    }

    /**
     * 查询资产类型
     * @param paramMap
     *            查询条件
     * @return 资产类型列表
     */
    public List listDicAsseKind(Map paramMap) {
        
        List list = null;
        Criteria criteria = getSession().createCriteria(AsseKnowDicAsseKind.class)
                            .addOrder(Order.asc("id"));
        
        if(paramMap!=null &&!"".equals(paramMap)) {
            if(paramMap.get("assetKindName")!=null) {
              criteria.add(Expression.like("assetKindName", "%"+((String) paramMap.get("assetKindName")).trim()+"%"));
            }
          }
        return criteria.list();
    }
    
    
	public List listDicAsseKindByid() {
		String sql = "from  AsseKnowDicAsseKind  where  id not in (select distinct asse_kind_id from AsseKnowDicAsseKind  where asse_kind_id is not null)";
		List list = this.getHibernateTemplate().find(sql);
	    return list;
	}
    /**
     * 查询资产类型分页记录
     * 
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
    public List listDicAsseKindPage(Page page, Map paramMap) {
        
        List list = null;
        Criteria criteria = getSession().createCriteria(AsseKnowDicAsseKind.class)
                            .addOrder(Order.asc("id"))
                            .setFirstResult(page.getBeginIndex())
                            .setMaxResults(page.getEveryPage());
        
        if(paramMap!=null) {
            if(paramMap.get("assetKindName")!=null) {
              criteria.add(Expression.like("assetKindName", "%"+((String) paramMap.get("assetKindName")).trim()+"%"));
         }
        }
        return criteria.list();
    }
 
    /**
     * 删除资产类型
     * 
     * @param dicAsseKind
     *            资产类型
     */
    public void remove(AsseKnowDicAsseKind dicAsseKind) {
        
        getHibernateTemplate().delete(dicAsseKind);
    }

    /**
     * 保存/更新资产类型
     * 
     * @param dicAsseKind
     *            资产类型
     */
    public void saveOrUpdate(AsseKnowDicAsseKind dicAsseKind) {
        
        getHibernateTemplate().saveOrUpdate(dicAsseKind);
    }

    /**
     * 查询资产类型树父节点
     * @return 资产类型树父节点列表
     */
    public List listRootNode() {
        
        Criteria criteria = getSession().createCriteria(AsseKnowDicAsseKind.class)
        .addOrder(Order.asc("id"));
        criteria.add(Expression.isNull("parentAsseKind"));
        return criteria.list();
    	 
    }
    
    public List listRootNode1() {
        
  	  List list = getHibernateTemplate().find("select id, assetKindId, assetKindName from AsseKnowDicAsseKind where parentAsseKind is null order by id");
  	  return list;
  }
    
    /**
     * 查询选择的资产类型
     * @return 选择的资产类型列表
     */
    public List listChildNode() {
        
        Criteria criteria = getSession().createCriteria(AsseKnowDicAsseKind.class)
        .addOrder(Order.asc("id"));
        criteria.add(Expression.isNotNull("parentAsseKind"));
        return criteria.list();
    	
    }
    
    public List listChildNode1() {
        
  	List list = getHibernateTemplate().find("select id, assetKindId, assetKindName from AsseKnowDicAsseKind where parentAsseKind is not null order by id");
	    return list;
  }

	public List listChildNode(String assetKindId) {
		List list = getHibernateTemplate().find("select id, assetKindId, assetKindName from AsseKnowDicAsseKind where parentAsseKind.assetKindId='"+assetKindId+"' ");
  	    return list;
	}



}
