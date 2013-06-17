package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.StatSecuElemDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatSecuElem;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 静态安全要素Dao实现类.
 * 


 */
public class StatSecuElemDaoImpl extends HibernateDaoSupport implements StatSecuElemDao {

    /**
     * 查询静态安全要素
     * 
     * @param elemCode
     *        要素编码
     * @return 静态安全要素对象
     **/
    public AsseKnowStatSecuElem find(String elemCode) {
        
        AsseKnowStatSecuElem statSecuElem=null;
        List list = getHibernateTemplate().find("from AsseKnowStatSecuElem secuE where secuE.elemCode = ?",elemCode);
        if(list!=null && list.size()>0) {
            statSecuElem = (AsseKnowStatSecuElem) list.get(0);
        }
        return statSecuElem;
    }

    /**
     * 查询静态安全要素
     * 
     * @param id
     *    要素id
     * @return 静态安全要素对象
     **/
    public AsseKnowStatSecuElem find(Integer id) {
        
        AsseKnowStatSecuElem statSecuElem = (AsseKnowStatSecuElem) getHibernateTemplate().load(AsseKnowStatSecuElem.class, id);
        return statSecuElem;
    }

    /**
     * 返回静态安全要素树各个根节点列表
     * @return 静态安全要素根节点列表
     **/
    public List<AsseKnowStatSecuElem> findTree() {
        
        List list = getHibernateTemplate().find("from AsseKnowStatSecuElem secuE where length(trim(secuE.elemCode))<=2 order by secuE.elemCode");
        return list;
    }

    /**
     * 查询静态安全要素数量
     * @return 业务信息记录数
     **/
    public int getCount() {
        
        Criteria criteria = getSession().createCriteria(AsseKnowStatSecuElem.class);
        return 0;//count(criteria);
    }

    /**
     * 查询静态安全要素分页记录
     * @param page
     *            分页对象
     * @return 分页记录列表
     **/
    public List<AsseKnowStatSecuElem> listStatSecuElemPage(Page page) {
       
        Criteria criteria = this.getSession().createCriteria(AsseKnowStatSecuElem.class)
                                        .addOrder(Order.asc("id"));
        if(page!=null) {
            criteria.setFirstResult(page.getBeginIndex())
                    .setMaxResults(page.getEveryPage());
        }
        return criteria.list();
    }

    /**
     * 删除静态安全要素
     * 
     * @param statSecuElem
     *         静态安全要素
     **/
    public void remove(AsseKnowStatSecuElem statSecuElem) {
        
        getHibernateTemplate().delete(statSecuElem);
    }

    /**
     * 批量删除静态安全要素
     * 
     * @param statSecuElemList
     *     静态安全要素对象列表
     **/
    public void remove(List<AsseKnowStatSecuElem> statSecuElemList) {
        
        getHibernateTemplate().deleteAll(statSecuElemList);
    }

    /**
     * 保存/更新静态安全要素
     *         静态安全要素
     **/
    public void saveOrUpdate(AsseKnowStatSecuElem statSecuElem) {
        
        getHibernateTemplate().saveOrUpdate(statSecuElem);
    }

	@SuppressWarnings("unchecked")
	public List<AsseKnowStatSecuElem> listStatSecuElem() {
		return getHibernateTemplate().find("from AsseKnowStatSecuElem");
	}

}
