package edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao;

import java.util.List;
import java.util.Set;

import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.User;

public interface UserDao {
  
	/**
	 * 查询所有用户
	 */
	List<User> getAllUserDao();
	/**
	 * 模糊查询
	 * @param us
	 * @param page
	 * @param rid
	 * @return
	 */
	PageResult getBlurUserDao(User us,Page page,Integer rid);
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
//	
//	/**
//	 * 登录的方法
//	 * @param us
//	 * @param ipaddress
//	 * @return
//	 */
//	List loginDao(User us,String ipaddress);
	
	/**
	 * 更新user信息
	 * @param us
	 */
	void updateUserDao(User us);
    
    
    /**
     * 添加用户的方法
     * @param usEntity
     */
    void saveUserDao(User usEntity);
    
    /**
     * 删除
     * @param User
     */
    void deleteUserDao(User userEntity);
    
    /**
     * Id查询
     * @param id
     * @return
     */
    User getUserByIdDao(Integer id);
    /**
     * 根据用户获得用户信息
     * @param username
     * @return
     */
    public User getUserinfoByNameDao(String username) ;
    
//    
//    /**
//     * 达梦根据用户名 查询角色信息
//     * @param uname
//     * @return
//     */
//    User getUserByNameDao(String uname);
    
    
    /**
     * 统计函数
     * @param UserBOEntity
     * @return
     */
    int getCountUserDao(User UserBOEntity,Integer rid);    
    /**
     * 修改密码时需要验证用户名跟密码的方法
     * @param UserBOEntity
     * @return
     */
    User getUserByUnameAndPwd(User UserBOEntity);
    
//    /***************************DWR调用*********************/
//    boolean getUserNameCountDao(String usrername);
//    /**
//     * 检查旧密码是否正确
//     * @param username
//     * @param pwd
//     * @return
//     */
//    boolean checkPwdDao(String username,String pwd);
//    /**
//     * 根据用户ID检查用户是否是ADMIN；
//     * @param uid
//     * @return
//     */
//    public boolean checkAdminDao(int uid);
//    /**
//     * 根据用户尾巴局名称检查是否有相同的委办局 （dwr）调用
//     * @param uid
//     * @return
//     */
//    boolean checkManagerNameDao(String managerName);
    /**
     * 更新用户信息
     * @param uid
     * @return
     */
 	void updateUser(User user);
 	
 	void batchUser(String ids);
}
