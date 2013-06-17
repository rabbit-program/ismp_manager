package edu.sjtu.infosec.ismp.manager.SYSM.user.self.service;

import java.util.List;
import java.util.Set;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.web.vo.UserUpdateVO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.User;

public interface UserService {

	
	 /**
	  * 普通管理员登陆方法
	  * @param us
	  * @param ipaddress
	  * @return
	  */
	   public boolean loginService(List<Domain> domainList,String ipaddress);
	   /**
		  * 超级管理员登陆方法
		  * @param us
		  * @param ipaddress
		  * @return
		  */
	   public boolean loginService(String ipaddress);
	   /**
	    * 超级管理员获取全部域信息
	    * @return
	    */
	   public List<Domain> getAllDomain();
	   
	   /**
	    * 域全局管理员获取管辖域信息
	    * @param set
	    * @return
	    */
	   public List<Domain> getCasecadeDomain(Set<Domain> set);
		
//     public List loginService(UserBO us,String ipaddress);
//	
     /**
      * 添加用户的方法
      * @param usEntity
      */
     void saveUserService(User usEntity);
//     
	 /**
	  * 更新user信息
	  * @param us
	  */
	 void updateUserService(UserUpdateVO us);
	 
	 /**
	  * 删除user用户
	  * @param 
	  */
	 void deleteUserService(User u);
	 
	 
	 /**
	  * 更新user状态
	  * @param usid
	  * @param status
	  */
	 void updateUserStatusService(Integer usid ,Boolean status);
	 
	 /**
	  * 更新user密码
	  * @param us
	  */
	 void updateUserPasswordService(Integer uid,String pass);
	 
	 /**
	  * 模糊查询并且分页
	  * @param us
	  * @param page
	  * @return
	  */
	 PageResult getBlurUserService(User us ,Page page,Integer rid);
//	 
//     /**
//      * 删除
//      * @param UserBOEntity
//      */
//	 void deleteUerService(UserBO UserBOEntity);
//    
//     /**
//      * Id查询
//      * @param id
//      * @return
//      */
//     UserBO getUserByIdService(Integer id);
//     
     /**
      * 根据用户ID查询出 用所对应的委办局信息
      * @param id
      * @return
      */
     User getUserByIdService(Integer uid);
//     
//     /**
//      * 统计函数
//      * @param UserBOEntity
//      * @return
//      */
//     int getCountUserService(UserBO UserBOEntity);
     /**
      *  根据用户名获得用户信息
      * @param username
      * @return {@link UserBO}
      */
     User getUserinfoByNameService(String username);
     
     
//     /**
//      * 通过达梦那边登录后 根据他们返回的用户名 去取相应的角色     
//      * @param userName
//      * @return
//      */
//     public List loginService(String userName);
//     
//   
//     
     /**
      * 修改密码时需要验证用户名跟密码的方法
      * @param UserBOEntity
      * @return
      */
     User getUserByUnameAndPwd(User UserBOEntity);     
//     /**
//      * 暴露给DWR检查用户名是否存在     
//      * @param usrername
//      * @return
//      */
//     boolean getUserNameCountService(String usrername);
//     /**
//      * 暴露给DWR检查旧密码是否正确
//      * @param username
//      * @param pwd
//      * @return
//      */
//     boolean checkpassword(String username,String pwd);
//     /**
//      * 根据用户ID检查该用户是否是管理员
//      * @param uid
//      * @return
//      */
//     boolean checkAdminService(int uid);
//     /**
//      * 根据用户尾巴局名称检查是否有相同的委办局 （dwr）调用
//      * @param uid
//      * @return
//      */
//     boolean checkManagerNameService(String managerName);
     /**
 	 * 查询所有用户
 	 */
	   List<User> getAllUserDao();
 	
 	/**
     * 更新用户信息
     * @param uid
     * @return
     */
 	void updateUser(User user);
 	
 	/**
 	 * 
 	 * @param listUser
 	 */
 	void batchUpdateUser(Set<Domain> set);
}
