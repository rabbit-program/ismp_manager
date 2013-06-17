package edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.UserDao;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.User;

public class UserDaoImp extends HibernateDaoSupport implements UserDao {
	
	//模糊查询
	public PageResult getBlurUserDao(User us,Page page,Integer rid) {
		
		Criteria cri=this.termMaker(us,this.getSession());
		if(rid!=null&&rid!=-1&&rid!=0){
			Query query = getSession().createSQLQuery("select user_id from ismp_user_role where role_id=?");
			query.setInteger(0, rid);
			List<Integer> list = query.list();
			cri.add(Restrictions.in("id", list));
//			cri.add(Restrictions.e);   
		}
		int count = getCountUserDao(us,rid);
//		int count =13;
		 page = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), count);
		
		//判断需不需要分页
		if(page!=null){
			cri.setFirstResult(page.getBeginIndex());		
			cri.setMaxResults(page.getEveryPage());
		}
		
		PageResult rs=new PageResult();
		page = PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), (int)count);
		rs.setPage(page);
		rs.setPageList(cri.list());
//		this.getSession().flush();
		return rs;
	}		
	//查询条件生成器
	public Criteria termMaker(User us,Session session){
		 Criteria cri=session.createCriteria(User.class);
		 if(us!=null){	
			 
			 if(us.getPassword()!=null){
			     cri.add(Restrictions.eq("password", us.getPassword()))	; 
			 }
			 if(us.getEnabled()!=null){
				 cri.add(Restrictions.eq("enabled",us.getEnabled()));
			 }
			 if(us.getEmail()!=null&&us.getEmail().trim().length()>0){
				 cri.add(Restrictions.like("email", "%"+us.getEmail()+"%"));				 
			 }
			 if(us.getJob()!=null&&us.getJob().trim().length()>0){
				 cri.add(Restrictions.like("job", "%"+us.getJob()+"%"));
			 }
			 if(us.getMobile()!=null&&us.getMobile().trim().length()>0){
				 cri.add(Restrictions.like("mobile", "%"+us.getMobile()+"%"));
			 }
			 if(us.getUsername()!=null&&us.getUsername().trim().length()>0){
				 cri.add(Restrictions.like("username","%"+us.getUsername()+"%"));
			 }
			 if(us.getLoginName()!=null){
				 cri.add(Restrictions.like("loginName", "%"+us.getLoginName()+"%"));
			 }
		 }
		 return cri;
	}

//   //用户登录的方法
//	public List loginDao(UserBO us,String ipaddress) {
//		// TODO Auto-generated method stub
//		List list=new ArrayList(3);
//		Timestamp curdate=new Timestamp(System.currentTimeMillis());
//		Criteria cri1=getSession().createCriteria(UserBO.class);
//    	cri1.add(Restrictions.eq("username", us.getUsername()));
//    	UserBO user1=(UserBO) cri1.uniqueResult();
//    	if(user1==null){ 
//    		list.add(0,null);
//    		list.add(1,"001");//代表用户错误！
//    		return list;
//    	}else{
//    		//先检查是否连续登陆后被禁用了 	
//    		String forbid="";
//    		String forbidstr=user1.getForbidtime();
//    		if(forbidstr!=null&&forbidstr.trim().length()>0){
//	    		String forbidstrs[]= forbidstr.split(",");
//	  			Timestamp ts=null;
//    			int cout=0;
//	    		for (String string : forbidstrs) {	  
//					if(string.indexOf("-")!=-1){
//					    ts=Timestamp.valueOf(string);
//					}else{
//					    cout=Integer.valueOf(string);				   
//					}
//				}
//		       //判断是否登录失败了三次				  
//			   //如果失败后就判断是否过来30分钟了
//			   long l=(curdate.getTime()-ts.getTime());			
//			   if(cout>=3){
//				   if(l/(60 * 1000)<30){							  
//					    list.add(0,null);
//					    list.add(1,(l / (60 * 1000)));//代表三次失败了告诉用户还有多久能登陆
//					    return list;							  
//				   }else{
//					    forbid="003";//设置状态代表禁止后已经超过了三十分钟
//				   }
//			   }				   
//    		}    		
//			Criteria cri=getSession().createCriteria(UserBO.class);
//			cri.add(Restrictions.eq("username", us.getUsername()));
//			cri.add(Restrictions.eq("password", us.getPassword()));			
//	        UserBO user=(UserBO) cri.uniqueResult();
//	        list.add(0,user);//用户信息存储取来
//	        if(user==null)  {  
//	        	if(forbid.length()>0){
//	        		list.add(1,forbid);//代表密码错误;  
//	        	}else{
//        			list.add(1,"002");//代表密码错误;  
//        		}
//    	    }else{
//    	    	if(user.getStatus()==null||(!user.getStatus())){
//    	    		list.add(0,null);
//    	    		list.add(1,"005");
//    	    	}else{
//    	    		list.add(1,"200");
//    	    	}    	    	
//    	    }	        
//	    }       
//		return list;
//	}
//
  //更新用户
	public void updateUserDao(User us) {
		// TODO Auto-generated method stub
		if(us!=null){
			getHibernateTemplate().saveOrUpdate(us);
		}
		
	}

    //添加用户
	public void saveUserDao(User usEntity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(usEntity);
	}
    //删除用户
	public void deleteUserDao(User userEntity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(userEntity);
	}
    //ID 查询
	public User getUserByIdDao(Integer id) {
		// TODO Auto-generated method stub
		return (User) getHibernateTemplate().get(User.class, id);
	}
	
	/**
	 * 查询所有域信息
	 */
	@SuppressWarnings("unchecked")
	public List<Domain> getAllDomain() {
		String Hql="select d from Domain d";
		Query query = this.getSession().createQuery(Hql);
		return query.list();
	}
	/**
	 * 查询域及其子域信息
	 * @param set 
	 */
	@SuppressWarnings("unchecked")
	public List<Domain> getCasecadeDomain(Set<Domain> set) {
		if(set!=null&&set.size()!=0){
			List result = new ArrayList(set);
//			result.addAll();
			for(Domain domain:set){
				List qr = getDomianByParent(domain,result);
				result.addAll(qr);
			}
			return result;
		}
		return null;
	}
	/**
	 * 递归查询子域信息
	 * @param set 
	 */
	@SuppressWarnings("unchecked")
	private List<Domain> getDomianByParent(Domain domain,List result){
		Query query = this.getSession().createQuery("select d from Domain d where d.parentDomain =:fDomain");
		query.setParameter("fDomain", domain);
		List<Domain> pr = query.list();
		if(pr!=null&&pr.size()!=0){
			result.addAll(pr);
			for(Domain yu:pr){
				List<Domain> anore = getDomianByParent(yu,result);
				result.addAll(anore);
			}
		}
		return result;
	}
    //统计函数
    public int getCountUserDao(User UserBOEntity,Integer rid){
    	Criteria cri=termMaker(UserBOEntity,this.getSession());
    	if(rid!=null&&rid!=-1&&rid!=0){
			Query query = getSession().createSQLQuery("select user_id from ismp_user_role where role_id=?");
			query.setInteger(0, rid);
			List<Integer> list = query.list();
			cri.add(Restrictions.in("id", list));
//			cri.add(Restrictions.e);   
		}
    	int count=((Integer)cri.setProjection(Projections.rowCount()).uniqueResult()).intValue();
    	return count;
    }
//    
//    //DWR调用
//	public boolean getUserNameCountDao(String usrername) {
//		Criteria cri=getSession().createCriteria(UserBO.class);
//		cri.add(Restrictions.eq("username", usrername));
//		if(((Integer)cri.setProjection(Projections.rowCount()).uniqueResult()).intValue()>0){
//		   return true;		
//		}
//		return false;
//	}
//	//检查旧密码是否正确
//	public boolean checkPwdDao(String username, String pwd) {
//		Criteria cri=getSession().createCriteria(UserBO.class);
//		cri.add(Restrictions.eq("username", username));
//		cri.add(Restrictions.eq("password", pwd));
//		if(((Integer)cri.setProjection(Projections.rowCount()).uniqueResult()).intValue()>0){
//			return true;
//		}
//		return false;
//	}
	//
	public User getUserByUnameAndPwd(User UserBOEntity) {
		Criteria cri=getSession().createCriteria(User.class);
		cri.add(Restrictions.eq("loginName", UserBOEntity.getLoginName()));
		cri.add(Restrictions.eq("password", UserBOEntity.getPassword()));
		return (User) cri.uniqueResult();
	}
//	//根据用户ID检查用户是否是管理员
//	public boolean checkAdminDao(int uid) {
//		String hql = "from RoleBO role where role.id in (select pos.roleId from UserToRoleBO pos where pos.userId=:userId) and role.rolename='admin'";
//		Query query = getSession().createQuery(hql);
//		query.setParameter("userId", uid); 
//		if(query.list().size()>0){
//			return true;
//		}
//		return false;
//	}
//	
//	//达梦根据用户查询用户信息
//	public UserBO getUserByNameDao(String uname) {
//		// TODO Auto-generated method stub
//		Criteria cri=getSession().createCriteria(UserBO.class);
//		cri.add(Restrictions.eq("username", uname));
//		return (UserBO) cri.uniqueResult();		
//	}
	/**
	 * 根据用户名获得用户信息
	 */
	public User getUserinfoByNameDao(String username) {
	    Criteria cri=getSession().createCriteria(User.class);
	    cri.add(Restrictions.eq("loginName", username));
	    Object obj=cri.uniqueResult();
	    if(obj!=null){
	    	return (User) obj;
	    }
		return null;
		
	}
//	public boolean checkManagerNameDao(String managerName) {
//		if(managerName==null||managerName.trim().length()<=0){
//			return false;
//		}
//		Criteria cri=getSession().createCriteria(ManagerBO.class);
//		cri.add(Restrictions.eq("managerName", managerName));
//		List list= cri.list();
//		if(list!=null&&list.size()>0){
//			return true;
//		}
//		return false;
//	}
	public List<User> getAllUserDao() {
		List<User> allUserList = null;
		allUserList = getHibernateTemplate().loadAll(User.class);
		return allUserList;
	}
	public void updateUser(User user) {
		getSession().update(user);
	}
	
	public void batchUser(String ids){
		Session session = getSession();
		Query query = session.createSQLQuery("delete from ismp_user_domain where domain_id in(:ids)");
		query.setString("ids", ids);
		query.executeUpdate();
	}
	
	
             
}
