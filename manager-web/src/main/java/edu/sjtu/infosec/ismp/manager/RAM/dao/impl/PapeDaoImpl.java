package edu.sjtu.infosec.ismp.manager.RAM.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.RAM.dao.PapeDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoPape;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 数据层 问卷Dao实现类.
 * 


 **/
public class PapeDaoImpl extends HibernateDaoSupport implements PapeDao {

    /**
     * 查询问卷问题
     * 
     * @param id
     *    问卷问题id
     * @return 问卷问题对象
     **/
    public AsseInfoPape find(Integer id) {
        AsseInfoPape asseInfoPape = new AsseInfoPape();
        asseInfoPape = (AsseInfoPape) getHibernateTemplate().load(AsseInfoPape.class, id);
        return asseInfoPape;
    }

    public AsseInfoPape findbySecuId(Integer projId,Integer id) {
    	AsseInfoPape asseInfoPape=new AsseInfoPape();
        Query query = this.getSession().createQuery("from AsseInfoPape pape where pape.secuElem.id=:id and pape.asseInfoProjId=:projId");
        query.setInteger("id", id);
        query.setInteger("projId", projId);
        List list = query.list();
        if(list!=null && list.size()>0){
        	asseInfoPape = (AsseInfoPape) list.get(0);
        }
        return asseInfoPape;
    }
    /**
     * 查询问卷问题数量
     * @param asseInfoProj
     *            测评项目
     * @return 问卷问题数量
     **/
    public int getCount(AsseInfoProj asseInfoProj) {
        
        Criteria criteria = getSession().createCriteria(AsseInfoPape.class);
        return 0;//count(criteria);
    }

    /**
     * 查询问卷问题分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @return 分页记录列表
     **/
    public List<AsseInfoPape> listAsseInfoPape(Page page,
            AsseInfoProj asseInfoProj) {
        
        Criteria criteria = getSession().createCriteria(AsseInfoPape.class)
        .addOrder(Order.asc("secuElem"));
        if(page!=null) {
              criteria.setFirstResult(page.getBeginIndex())
                      .setMaxResults(page.getEveryPage());
        }
        if(asseInfoProj!=null) {
            criteria.add(Expression.eq("asseInfoProjId", asseInfoProj.getId()));
      }
          return criteria.list();
    }

    /**
     * 删除问卷问题
     * 
     * @param question
     * 问卷问题
     **/
    public void remove(AsseInfoPape question) {
       
        getHibernateTemplate().delete(question);
    }

    /**
     * 批量删除问卷问题
     * 
     * @param questionList
     *     问卷问题对象列表
     **/
    public void remove(List<AsseInfoPape> questionList) {
        
        getHibernateTemplate().deleteAll(questionList);
    }

    /**
     * 保存/更新问卷问题
     * 
     * @param question
     * 问卷问题
     **/
    public void saveOrUpdate(AsseInfoPape question) {
        
        getHibernateTemplate().saveOrUpdate(question);
    }
    
    /**
     * 批量保存/更新问卷问题
     * 
     * @param question
     * 问卷问题
     **/
    @SuppressWarnings("unchecked")
	public void batchSaveOrUpdate(final List questions) {
        
        getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException,SQLException {
                for(int i=0;i<questions.size();i++) {
                    AsseInfoPape question = (AsseInfoPape) questions.get(i);
                    session.merge(question); 
                    System.out.println("batch saved question:"+question.toString());
                    if((i+1)%20==0){ 
                        session.flush();
                        session.clear();   
                    }
                  }
                return null;
            }
            
        });
    }
    
    /**
     * 查询下一题问题列表
     * @param asseInfoPape
     *            当前问题
     * @return 下一题问题列表
     **/
    public List<AsseInfoPape> listNextPapes(AsseInfoPape asseInfoPape){
        
        Criteria criteria = getSession().createCriteria(AsseInfoPape.class);
        
        if(asseInfoPape!=null) {
            criteria.add(Expression.eq("asseInfoProjId", asseInfoPape.getAsseInfoProjId()));
            criteria.addOrder(Order.asc("secuElem"));
            criteria.add(Expression.gt("secuElem", asseInfoPape.getSecuElem()));
            criteria.setMaxResults(1);
        }
        return criteria.list();
    }

    /**
     * 查询下一题问题
     * @param asseInfoPape
     *   有跳转点的当前问题
     * @return 下一题问题
     **/
    public AsseInfoPape getNextJumpAsseInfoPape(AsseInfoPape asseInfoPape) {
        
        AsseInfoPape question = null;
        Criteria criteria = getSession().createCriteria(AsseInfoPape.class);
        
        if(asseInfoPape!=null) {
            criteria.add(Expression.eq("asseInfoProjId", asseInfoPape.getAsseInfoProjId()));
            criteria.addOrder(Order.asc("secuElem"));
            criteria.add(Expression.eq("secuElem", asseInfoPape.getSecuElem().getJumpSecuElem()));
        }
        List list =  criteria.list();
        if(list!=null && list.size()>0) {
            question = (AsseInfoPape) list.get(0);
        }
        return question;
    }

    /**
     * 查询已答问题列表
     * @param asseInfoProjId
     *   项目编号
     * @return 已答问题列表
     **/
    public List<AsseInfoPape> listAnsweredPapes(Integer asseInfoProjId) {
        
        Criteria criteria = getSession().createCriteria(AsseInfoPape.class)
                                        .add(Expression.eq("asseInfoProjId", asseInfoProjId))
                                        .add(Expression.isNotNull("answer"))
                                        .addOrder(Order.asc("secuElem"));
        return criteria.list();
    }
    
    /**
     * 根据答案查询已答问题列表
     * @param asseInfoProjId
     *   项目编号
     * @param answer
     *   答案
     * @return 已答问题列表
     **/
    public List<AsseInfoPape> listPapesByAnswer(Integer asseInfoProjId, String answer) {
        
        Criteria criteria = getSession().createCriteria(AsseInfoPape.class)
                                        .add(Expression.eq("asseInfoProjId", asseInfoProjId))
                                        .add(Expression.eq("answer",answer))
                                        .addOrder(Order.asc("secuElem"));
        return criteria.list();
    }

}
