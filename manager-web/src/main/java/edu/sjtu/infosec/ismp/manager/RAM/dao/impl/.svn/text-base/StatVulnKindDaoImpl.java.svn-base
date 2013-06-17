package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.StatVulnKindDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVuln;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnKind;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 静态脆弱点类别Dao实现类.
 * 


 */
public class StatVulnKindDaoImpl extends HibernateDaoSupport implements StatVulnKindDao {

    /**
     * 查询静态脆弱点类别
     * 
     * @param id
     *    静态脆弱点类别id
     * @return 静态脆弱点类别对象
     **/
    public AsseKnowStatVulnKind find(Integer id) {
        AsseKnowStatVulnKind statVulnKind = null;
        List list =this.getHibernateTemplate().find("from AsseKnowStatVulnKind where id="+id);
		if(list!=null &&list.size()>0){
			statVulnKind=(AsseKnowStatVulnKind) list.get(0);
		}
        return statVulnKind;
    }

    /**
     * 查询静态脆弱点类别数量
     * @return 静态脆弱点类别数量
     **/
    public int getCount() {
        
        Criteria criteria = getSession().createCriteria(AsseKnowStatVulnKind.class);
        return 0;//count(criteria);
    }

    /**
     * 查询静态脆弱点类别分页记录
     * @param page
     *            分页对象
     * @return 分页记录列表
     **/
    public List<AsseKnowStatVulnKind> listStatVulnKindPage(Page page) {
        
        List<AsseKnowStatVulnKind> statVulnKindlist = null;
        Criteria criteria = getSession().createCriteria(AsseKnowStatVulnKind.class)
                                        .addOrder(Order.asc("id"));
        if(page!=null) {
            criteria.setFirstResult(page.getBeginIndex())
                    .setMaxResults(page.getEveryPage());
        }
        statVulnKindlist = criteria.list();
        return statVulnKindlist;
    }

    /**
     * 删除静态脆弱点类别对象
     * 
     * @param statVulnKind
     *   静态脆弱点类别对象
     **/
    public void remove(AsseKnowStatVulnKind statVulnKind) {
        
        getHibernateTemplate().delete(statVulnKind);
    }

    /**
     * 保存/更新静态脆弱点类别对象
     * 
     * @param statVulnKind
     *    静态脆弱点类别对象
     **/
    public void saveOrUpdate(AsseKnowStatVulnKind statVulnKind) {
       
        getHibernateTemplate().saveOrUpdate(statVulnKind);
    }

    /**
     * 返回所有静态脆弱点类别记录
     * @return 所有静态脆弱点类别列表
     **/
	public List<AsseKnowStatVulnKind> listAllStatVulnKinds() {
		
		Criteria criteria = getSession().createCriteria(AsseKnowStatVulnKind.class)
        .addOrder(Order.asc("id"));
		return criteria.list();
	}

}
