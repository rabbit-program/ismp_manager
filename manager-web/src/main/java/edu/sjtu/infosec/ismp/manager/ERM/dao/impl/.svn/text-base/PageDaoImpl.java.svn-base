/**
 * PageDaoImpl.java
 * edu.sjtu.infosec.ismp.manager.resp.dao.impl
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2009-6-30 		xpeiyuan
 *
 * Copyright (c) 2009, TNT All Rights Reserved.
*/

package edu.sjtu.infosec.ismp.manager.ERM.dao.impl;
/**
 * ClassName:PageDaoImpl
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   lisiwen
 * @version  
 * @since    Ver 1.1
 * @Date	 2010-5-21		下午02:00:06
 *
 * @see 	 
 * @deprecated 
 */
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.ERM.dao.PageDao;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
//import edu.sjtu.infosec.ismp.manager.ERM.web.form.RespIndexForm;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

//import com.sy.dao.BaseDao;


@SuppressWarnings({ "unchecked", "deprecation" })
public class PageDaoImpl extends HibernateDaoSupport implements PageDao {

    private String hql;
    private Page page;
    private int start;
//    public BaseDao dao;
//    public void setDao(BaseDao dao) {
//        this.dao = dao;
//    }

    /**
	 * (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.resp.dao.PageDao#init(int, java.lang.String)
	 */
    public void init(int start,String tableName){    // 
       page = new Page();
       
       this.hql = "from "+tableName+" Order by id desc";
       this.start = start;
       setRowCount();
       setTotalPage();
       setCurrentPage();
       setPrePage();
       setNextPage();
       setPreOrNextBoolean();
    }

    public void initPage(int pno, String userToManager) {
    	page = new Page();
        this.start = pno;
        this.setRowCountnum(userToManager);   //得到总行数
       this.setTotalPageNum(userToManager);   //得到总页数
       System.out.println("总页数:"+page.getTotalPage());
       System.out.println(page);
        setCurrentPage();   //当前页
        setPrePage();    //是否有上一页
        setNextPage();	
        setPreOrNextBoolean();
		
	}
    
    public int getRowCountnum(String userToManager)
    {
//    	 String[]  userToManagers=userToManager.split(",");
//         StringBuilder sb=new StringBuilder();
//         Query query;
//         int num=0;
//         List selectList=null;   //查询集合
//         for(String a:userToManagers)
//         {
//        	 num=Integer.parseInt(a);
//        	 query = this.getSession().createQuery("select managerName from ManagerBO as m where m.id=:id");
//        	 query.setInteger("id", num);
//        	 selectList=query.list();
//        	 if(!selectList.isEmpty() && selectList.size()>0)
//        	 {
//        		 sb.append("'"+selectList.get(0)+"',");
//        	 }
//        }
//         int a=0;
//         if(sb.toString().length()>0)
//         {
//        	 String sbString=sb.toString().substring(0, sb.length()-1);
//             String bql="from RespinfoBO as m where m.department in";
//             query=this.getSession().createQuery(bql+"("+sbString+")");
//             System.out.println(query.list().size());
//             a=query.list().size();
//         }
//         
//        return a;
    	return 0;
        
    }
    //设置总页数
    public void setTotalPageNum(String userToManager) {
        int rowCount = this.getRowCountnum(userToManager); //总行数
        int pageSize = page.getEveryPage(); //每行显示的页数
        if (rowCount > pageSize) {
            if (rowCount % pageSize == 0) {
                page.setTotalPage(rowCount / pageSize);
            } else {
                page.setTotalPage(1 + (rowCount / pageSize));
            }
        } else {
            page.setTotalPage(1);
        }
    }
    
    public void setRowCountnum(String userToManager) {
        page.setTotalCount(getRowCountnum(userToManager));
    }
    /**
	 * (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.resp.dao.PageDao#getRowCount()
	 */
    public int getRowCount(){
    int count=0;	
    try {
//    	this.getShowPage(userToManager);
    	 List list = getHibernateTemplate().find(hql);
         if(list.isEmpty()){
          return 0;
         }
         count = list.size();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
      return count;
    }

   
    
    /**
	 * (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.resp.dao.PageDao#setPreOrNextBoolean()
	 */
    public void setPreOrNextBoolean() {
        if (page.getCurrentPage() <= 1) {
            page.setHasPrePage(false);
        } else {
            page.setHasPrePage(true);
        }
        if (page.getCurrentPage() >= page.getTotalPage()) {
            page.setHasNextPage(false);
        } else {
            page.setHasNextPage(true);
        }
    }

    /**
	 * (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.resp.dao.PageDao#setCurrentPage()
	 */
    public void setCurrentPage() {
        if (start < 1) {
            page.setCurrentPage(1);
        }
        if (start > page.getTotalPage()) {
            page.setCurrentPage(page.getTotalPage());
        }
        page.setCurrentPage(start);
    }

    /**
	 * (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.resp.dao.PageDao#setPrePage()
	 */
    public void setPrePage() {
        page.setPrePage(page.getCurrentPage() - 1);
    }

    /**
	 * (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.resp.dao.PageDao#setNextPage()
	 */
    public void setNextPage() {
        page.setNextPage(page.getCurrentPage() + 1);
    }

    /**
	 * (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.resp.dao.PageDao#setTotalPage()
	 * 设置总页数
	 */
    public void setTotalPage() {
        int rowCount = getRowCount(); //总行数
        int pageSize = page.getEveryPage(); //每行显示的页数
        if (rowCount > pageSize) {
            if (rowCount % pageSize == 0) {
                page.setTotalPage(rowCount / pageSize);
            } else {
                page.setTotalPage(1 + (rowCount / pageSize));
            }
        } else {
            page.setTotalPage(1);
        }
    }

    /**
	 * (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.resp.dao.PageDao#setRowCount()
	 */
    public void setRowCount() {
        page.setEveryPage(getRowCount());
    }

    /**
	 * (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.resp.dao.PageDao#getStartIndex()
	 */
    public int getStartIndex() {
        int startIndex = 0;
        if (start < 0) {
            startIndex = 0;
        } else {
            if (start > page.getTotalPage()) {
                startIndex = page.getEveryPage() * (page.getTotalPage() - 1);
            } else {
                startIndex = page.getEveryPage() * (start - 1);
            }
        }
        return startIndex;
    }

//	public List getShowPage(String s,RespIndexForm respform) {
//		Criteria criteria=this.getSession().createCriteria(RespInfoBO.class);
//		if(null!=respform.getRespunits() && !"".equals(respform.getRespunits()))
//		{
////			System.out.println("respform.getRespunits()"+respform.getRespunits());
//			criteria.add(Expression.eq("department", respform.getRespunits()));
//		}
//		if(null!=respform.getRespname() && !"".equals(respform.getRespname()))
//		{
////			System.out.println("respform.getRespname()"+respform.getRespname());
//			criteria.add(Expression.eq("projname", respform.getRespname()));
//		}
//		if(null!=respform.getThissystem() && !"".equals(respform.getThissystem()))
//		{
////			System.out.println("respform.getThissystem()"+respform.getThissystem());
//			criteria.add(Expression.eq("itsysname", respform.getThissystem()));
//		}
//		if(null!=respform.getUpdatetime() && !"".equals(respform.getUpdatetime()))
//		{
////			System.out.println("respform.getUpdatetime()"+respform.getUpdatetime());
//			criteria.add(Expression.like("modidate", "%"+respform.getUpdatetime()+"%"));
//		}
////		System.out.println("selest===="+select);
//		System.out.println("传过来的委办局======"+s);
//		criteria.add(Expression.in("department", s.split(",")));
//		criteria.setFirstResult(getStartIndex());
//		criteria.setMaxResults(page.getEveryPage());
////		System.out.println("查询的总集合是:"+criteria.list().size());
////		page.setList(criteria.list());
////		return page;
//		return criteria.list();
//	}
	
	
	 /**
	 * (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.resp.dao.PageDao#getPage()
	 */
    public Page getPage(){
       List list = (List)getHibernateTemplate().execute(new HibernateCallback(){
        public Object doInHibernate(Session session) throws HibernateException, SQLException {
         Query query = session.createQuery(hql);
         query.setFirstResult(getStartIndex());
         query.setMaxResults(page.getEveryPage());
         return query.list();
        }   
       });
       page.setList(list);
       return page;
    }

	public String getDepaetmentNames(String id) {
		StringBuffer sb=new StringBuffer();
		int num=0;
		Query query;
		String[] arrid=id.split(",");
		 for(String a : arrid)
         {
        	 num=Integer.parseInt(a);
        	 query = this.getSession().createQuery("select managerName from ManagerBO as m where m.id=:id");
        	 query.setInteger("id", num);
        	 if(!query.list().isEmpty() && query.list().size()>0)
        	 {
        		sb.append(query.list().get(0)+",");
        	 }
        }
		 if(sb.length()==0)
		 {
			 return "noDepartment";
		 }
		 
			 return sb.toString().substring(0,sb.toString().length()-1);
		
		
	}

	
}



