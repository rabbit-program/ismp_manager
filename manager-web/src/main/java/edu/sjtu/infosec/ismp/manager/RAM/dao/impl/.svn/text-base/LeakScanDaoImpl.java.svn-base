package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.config.SetFactoryBean;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.LeakScanDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 漏洞扫描Dao实现类.
 * 
 **/
public class LeakScanDaoImpl extends HibernateDaoSupport implements LeakScanDao {

	/**
     * 批量保存/更新扫描漏洞
     * 
     * @param leaks
     * 漏洞列表
     **/
	@SuppressWarnings("unchecked")
	public void batchSaveOrUpdate(final List<AsseInfoLeak> leaks) {
		getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException,SQLException {
                for(int i=0;i<leaks.size();i++) {
                	AsseInfoLeak asseInfoLeak = (AsseInfoLeak) leaks.get(i);
                    session.saveOrUpdate(asseInfoLeak); 
                    System.out.println("batch saved asseInfoLeak:"+asseInfoLeak.toString());
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
     * 查询漏洞
     * 
     * @param id
     *    漏洞id
     * @return 漏洞对象
     **/
	public AsseInfoLeak find(Integer id) {
		AsseInfoLeak infoLeak=null;
		List list = this.getHibernateTemplate().find("from AsseInfoLeak where id = "+id);
		if(list!=null&&list.size()>0){
			infoLeak = (AsseInfoLeak) list.get(0);
		}
		return infoLeak;
	}

	/**
     * 查询漏洞数量
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞数量
     **/
	public int getCount(AsseInfoProj asseInfoProj, String ip) {
		Criteria criteria = getSession().createCriteria(AsseInfoLeak.class)
        									.addOrder(Order.asc("id"));
        if(asseInfoProj!=null ) {
           criteria.add(Expression.eq("asseInfoProj", asseInfoProj));
        }
        if(ip!=null && !"".equals(ip)) {
            criteria.add(Expression.eq("ip", ip));
        }
        return criteria.list().size();
	}

	/**
     * 删除漏洞
     * 
     * @param leak
     * 漏洞
     **/
	public void remove(AsseInfoLeak leak) {
		
		getHibernateTemplate().delete(leak);
	}

	/**
     * 批量删除漏洞
     * 
     * @param leakList
     *     漏洞列表
     **/
	public void remove(List<AsseInfoLeak> leakList) {
		
		getHibernateTemplate().deleteAll(leakList);
	}

	/**
     * 保存/更新扫描漏洞
     * 
     * @param leak
     * 漏洞
     **/
	public void saveOrUpdate(AsseInfoLeak leak) {
		
		getHibernateTemplate().saveOrUpdate(leak);
	}

	/**
     * 查询漏洞
     * 
     * @param cveId
     *    cveId
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞对象
     **/
	public AsseInfoLeak findByCveId(String cveId, AsseInfoProj asseInfoProj) {
		
		AsseInfoLeak asseInfoLeak = null;
		List leakList = getSession().createCriteria(AsseInfoLeak.class)
		                            .add(Expression.eq("cveId", cveId))
		                            .add(Expression.eq("asseInfoProj", asseInfoProj))
		                            .list();
		
		if(leakList!=null && leakList.size()>0) {
			asseInfoLeak = (AsseInfoLeak) leakList.get(0);
        }
		
		return asseInfoLeak;
	}

	/**
     * 查询漏洞记录
     * @param asseInfoProj
     *            测评项目
     * @return 分页记录列表
     **/
	public List<AsseInfoLeak> listAsseInfoLeak(AsseInfoProj asseInfoProj) {
		
		
		Criteria criteria = getSession().createCriteria(AsseInfoLeak.class)
        .addOrder(Order.asc("id"));

        if(asseInfoProj!=null ) {
           criteria.add(Expression.eq("asseInfoProj", asseInfoProj));
        }
        return criteria.list();
	}

	/**
     * 查询漏洞
     * 
     * @param pluginId
     *    pluginId
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞对象
     **/
	public List findByPluginId(String pluginId, AsseInfoProj asseInfoProj) {
		
		
		List leakList = getSession().createCriteria(AsseInfoLeak.class)
        .add(Expression.eq("pluginId", pluginId))
        .add(Expression.eq("asseInfoProj", asseInfoProj))
        .list();
		
		
		
		return leakList;
	}


	/**
     * 查询漏洞
     * 
     * @param vulId
     *    vulId
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞对象
     **/
	public List findByVulId(String vulId, AsseInfoProj asseInfoProj) {
		
		
		List leakList = getSession().createCriteria(AsseInfoLeak.class)
        .add(Expression.eq("knowId", vulId))
        .add(Expression.eq("asseInfoProj", asseInfoProj))
        .list();
		
		
		
		return leakList;
	}

	/**
     * 查询IP地址列表
     * @param asseInfoProj
     *            测评项目
     * @return IP地址列表
     **/
	public List<String> listIP(AsseInfoProj asseInfoProj) {
		
		List ipList = getHibernateTemplate().find("select DISTINCT ip from AsseInfoLeak where asseInfoProj = ?",asseInfoProj);
		return ipList;
	}

	
	public List<String> listCVEId(AsseInfoProj asseInfoProj) {
		
		List CVEIdList = getHibernateTemplate().find("select DISTINCT cveId from AsseInfoLeak where asseInfoProj = ? and cveId is not null",asseInfoProj);
		return CVEIdList;
	}
	/**
     * 查询漏洞分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @return 分页记录列表
     **/

	public List<AsseInfoLeak> findAll(int startResult, int maxResult,
			AsseInfoProj asseInfoProj, String ip) {
		Criteria criteria = getSession().createCriteria(AsseInfoLeak.class)
							.addOrder(Order.asc("id"))
							.setFirstResult(startResult)
							.setMaxResults(maxResult);
					
		if(asseInfoProj!=null ) {
			criteria.add(Restrictions.eq("asseInfoProj", asseInfoProj));
		}
		
		if(ip!=null && !"".equals(ip)) {
			criteria.add(Restrictions.eq("ip", ip));
		}
		return criteria.list();
	}

}
