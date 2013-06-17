package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.StatVulnPoinDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnKind;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnPoin;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 静态脆弱点Dao实现类.
 * 


 */
public class StatVulnPoinDaoImpl extends HibernateDaoSupport implements StatVulnPoinDao {

    /**
     * 查询静态脆弱点
     * 
     * @param id
     *    静态脆弱点类别id
     * @return 静态脆弱点类别对象
     **/
    public AsseKnowStatVulnPoin find(Integer id) {
        AsseKnowStatVulnPoin statVulnPoin =null;
        String hql = "from AsseKnowStatVulnPoin where id = "+id;
        List list = this.getHibernateTemplate().find(hql);
        if(list!=null &&list.size()>0){
        	statVulnPoin = (AsseKnowStatVulnPoin) list.get(0);
        }
        return statVulnPoin;
    }

    /**
     * 查询静态脆弱点数量
     * @return 静态脆弱点数量
     **/
    public int getCount() {
        
        Criteria criteria = getSession().createCriteria(AsseKnowStatVulnPoin.class);
        return 0;//count(criteria);
    }

    /**
     * 查询静态脆弱点分页记录
     * @param page
     *            分页对象
     * @return 分页记录列表
     **/
    public List<AsseKnowStatVulnPoin> listStatVulnPoinPage(Page page) {
       
        List<AsseKnowStatVulnPoin> statVulnPoinlist = null;
        Criteria criteria = getSession().createCriteria(AsseKnowStatVulnPoin.class)
                                        .addOrder(Order.asc("id"));
        if(page!=null) {
            criteria.setFirstResult(page.getBeginIndex())
                    .setMaxResults(page.getEveryPage());
        }
        statVulnPoinlist = criteria.list();
        return statVulnPoinlist;
    }

    /**
     * 删除静态脆弱点对象
     * 
     * @param statVulnKind
     *   静态脆弱点类别对象
     **/
    public void remove(AsseKnowStatVulnPoin statVulnPoin) {
        
        getHibernateTemplate().delete(statVulnPoin);
    }

    /**
     * 保存/更新静态脆弱点对象
     * 
     * @param statVulnKind
     *    静态脆弱点类别对象
     **/
    public void saveOrUpdate(AsseKnowStatVulnPoin statVulnPoin) {
        
        getHibernateTemplate().saveOrUpdate(statVulnPoin);
    }

    /**
     * 根据静态脆弱点类别返回该项目未选静态脆弱点列表
     * @param statVulnKind
     *     静态脆弱点类别
     * @return 静态脆弱点列表
     **/
	public List<AsseKnowStatVulnPoin> listStatVulnPoin(
			Integer asseInfoProjId, AsseKnowStatVulnKind statVulnKind) {
		
		List list = getHibernateTemplate().find("select statVulnPoin " +
        		"from AsseKnowStatVulnPoin statVulnPoin " +
        		"where statVulnPoin.id NOT IN (select dynaVuln.asseKnowStatVulnPoinId from AsseKnowDynaVuln dynaVuln where dynaVuln.asseInfoProjId = '"+asseInfoProjId+"' ) "+
        		"and statVulnPoin.vulnKind = ?",statVulnKind);
        return list;
	}

	/**
     * 返回所有静态脆弱点
     * @return 静态脆弱点列表
     **/
	public List<AsseKnowStatVulnPoin> listAllStatVulnPoin() {
		
		Criteria criteria = getSession().createCriteria(AsseKnowStatVulnPoin.class)
        .addOrder(Order.asc("id"));
		return criteria.list();
	}

	/**
     * 根据静态脆弱点类别返回静态脆弱点列表
     * @return 静态脆弱点列表
     **/
	public List<AsseKnowStatVulnPoin> listStatVulnPoinByKind(
			AsseKnowStatVulnKind vulnKind) {
		
		List list = getHibernateTemplate().find("from AsseKnowStatVulnPoin statVulnPoin " +
        		"where statVulnPoin.vulnKind = ?",vulnKind);
        return list;
	}

}
