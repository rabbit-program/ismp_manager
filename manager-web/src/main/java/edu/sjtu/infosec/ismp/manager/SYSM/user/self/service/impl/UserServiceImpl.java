package edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.BlackAndWhiteDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.BlackAndWhiteStatusDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.UserDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.model.BlackAndWhiteBO;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.model.BlackAndWhiteStatusBO;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.web.vo.UserUpdateVO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.User;

public class UserServiceImpl implements UserService {

	private UserDao userdao; // 注入userDao接口

	//	private UserToRoleDao ustorl; // 注入用户跟角色映射的DAO接口
//	private RoleDao roledao; // 注入角色 Dao 接口
	private BlackAndWhiteDao blackandwhitedao;// 注入Dao接口
	private BlackAndWhiteStatusDao blackandwhitestatusdao;// 注入黑白名单 状态Dao接口
//	private ManagerService managerService;
//	
//	public void setManagerService(ManagerService managerService) {
//		this.managerService = managerService;
//	}
//
	/**
	 * 普通管理员登录的方法
	 * (黑白名单查询的ＩＰ与特定的域关联）
	 */
	
	public boolean loginService(List<Domain> domainList, String ipaddress) {
		List Resultlist = new ArrayList();
		// 检查是否在启用的相应的黑/白名单中
		// 先获得黑白/名单的启用状态
		BlackAndWhiteStatusBO blackandwhitestatusbo = blackandwhitestatusdao.getBlackAndWhiteStatusDao();
		//当不等于空的情况下才是有状态启用
		if (blackandwhitestatusbo != null&&blackandwhitestatusbo.getStatus()!=2) {
			// 取得的数据status（0，1，2
			// 分别代表启用的是黑名单或者白名单或者全部不启用
			// ）
			Integer status = blackandwhitestatusbo.getStatus();			
			//在通过IP地址和启用的黑/白的条件查询状态表
			if(status==0){
				for(Domain domain:domainList){
					System.out.print("启用了黑名单");				
					BlackAndWhiteBO blackandwhitebo=new BlackAndWhiteBO();
					blackandwhitebo.setIpaddress(ipaddress);
					blackandwhitebo.setMarker(status);
					blackandwhitebo.setDomain(domain.getId());
					if(blackandwhitedao.getUniqueBlackAndWhiteDao(blackandwhitebo)!=null){
						System.out.println("是黑名单里的用户");
						return false;
					}
				}
				return true;
			}
			if(status==1){
				//启动白名单必须有所管辖的域
				if(domainList.size()==0){
					return false;
				}
				for(Domain domain:domainList){
					BlackAndWhiteBO blackandwhitebo=new BlackAndWhiteBO();
					blackandwhitebo.setIpaddress(ipaddress);
					blackandwhitebo.setMarker(status);
					blackandwhitebo.setDomain(domain.getId());
					if(blackandwhitedao.getUniqueBlackAndWhiteDao(blackandwhitebo)!=null){
						System.out.println("是白名单里的用户");
						return true;
					}
				}
				return false;
			}
		} 
		return true;
	}
	/**
	 * 超级管理员登录的方法
	 * (黑白名单查询的ＩＰ不限于某些域，匹配对应角色为超级管理员的所有IP，）
	 */
	public boolean loginService(String ipaddress) {
		List Resultlist = new ArrayList();
		// 检查是否在启用的相应的黑/白名单中
		// 先获得黑白/名单的启用状态
		BlackAndWhiteStatusBO blackandwhitestatusbo = blackandwhitestatusdao.getBlackAndWhiteStatusDao();
		//当不等于空的情况下才是有状态启用
		if (blackandwhitestatusbo != null&&blackandwhitestatusbo.getStatus()!=2) {
			// 取得的数据status（0，1，2
			// 分别代表启用的是黑名单或者白名单或者全部不启用
			// ）
			Integer status = blackandwhitestatusbo.getStatus();			
			//在通过IP地址和启用的黑/白的条件查询状态表
			if(status==0){
				BlackAndWhiteBO blackandwhitebo=new BlackAndWhiteBO();
				blackandwhitebo.setIpaddress(ipaddress);
				blackandwhitebo.setMarker(status);
				blackandwhitebo.setRole("AdminAll");
				if(blackandwhitedao.getUniqueBlackAndWhiteDao(blackandwhitebo)!=null){
					System.out.println("是黑名单里的用户");
					return false;
				}
				return true;
			}
			if(status==1){
				BlackAndWhiteBO blackandwhitebo=new BlackAndWhiteBO();
				blackandwhitebo.setIpaddress(ipaddress);
				blackandwhitebo.setMarker(status);
				blackandwhitebo.setRole("AdminAll");
				if(blackandwhitedao.getUniqueBlackAndWhiteDao(blackandwhitebo)!=null){
					System.out.println("是白名单里的用户");
					return true;
				}
				return false;
			}
		} 
		return true;
	}
	 /**
     * 根据用户ID查询出 用所对应的委办局信息
     * @param username
     * @return {@link UserBO}
     */
	public User getUserByIdService(Integer uid) {
		// TODO Auto-generated method stub
		//先获得用户信息
		User userbo=userdao.getUserByIdDao(uid);
		return userbo;
	}
	/**
	    * 超级管理员获取全部域信息
	    * @return
	    */
	public List<Domain> getAllDomain() {
		return userdao.getAllDomain();
	}
	 /**
	    * 域全局管理员获取管辖域信息
	    * @param set
	    * @return
	    */
	public List<Domain> getCasecadeDomain(Set<Domain> set) {
		return userdao.getCasecadeDomain(set);
	}
//	public List loginService(UserBO us, String ipaddress) {
//		List Resultlist = new ArrayList();
//		// 检查是否在启用的相应的黑/白名单中
//		// 先获得黑白/名单的启用状态
//		BlackAndWhiteStatusBO blackandwhitestatusbo = blackandwhitestatusdao
//				.getBlackAndWhiteStatusDao();
//		//当不等于空的情况下才是有状态启用
//		if (blackandwhitestatusbo != null&&blackandwhitestatusbo.getStatus()!=2) {
//			// 取得的数据status（0，1，2
//			// 分别代表启用的是黑名单或者白名单或者全部不启用
//			// ）
//			Integer status = blackandwhitestatusbo.getStatus();			
//			//在通过IP地址和启用的黑/白的条件查询状态表
//			if(status==0){
//				System.out.print("启用了黑名单");				
//				BlackAndWhiteBO blackandwhitebo=new BlackAndWhiteBO();
//				blackandwhitebo.setIpaddress(ipaddress);
//				blackandwhitebo.setMarker(status);
//				if(blackandwhitedao.getUniqueBlackAndWhiteDao(blackandwhitebo)!=null){
//					Resultlist.add(0, null);
//					Resultlist.add(1, "006");
//					return Resultlist;
//				}
//			}
//			if(status==1){
//				BlackAndWhiteBO blackandwhitebo=new BlackAndWhiteBO();
//				blackandwhitebo.setIpaddress(ipaddress);
//				blackandwhitebo.setMarker(status);
//				if(blackandwhitedao.getUniqueBlackAndWhiteDao(blackandwhitebo)==null){
//					Resultlist.add(0, null);
//					Resultlist.add(1, "004");
//					return Resultlist;
//				}
//			}
//		} 
//		// 执行登录方法调用
//		List userlist = userdao.loginDao(us, ipaddress);
//		if (null != userlist.get(0)
//				&& ((UserBO) userlist.get(0)).getPassword().equals(
//						us.getPassword())) {
//			// 当不等于空并且密码相等的情况下就根据用户ID 查询所对应的角色ID
//			if (((UserBO) userlist.get(0)).getForbidtime() != null) {
//				((UserBO) userlist.get(0)).setForbidtime(null);
//				userdao.updateUserDao(((UserBO) userlist.get(0)));
//			}
//			//查询用户所对应的角色
//			List<RoleBO> roleList = new ArrayList();
//			//根据用户ID查询所对应的角色
//			roleList=roledao.getRoleByUserIdDao(((UserBO) userlist.get(0)).getId());
//			//将用户信息和角色信息封装到LIST
//			Resultlist.add(0, ((UserBO) userlist.get(0)));//0是用户信息
//			Resultlist.add(1, roleList);// 1是角色信息
//			return Resultlist;
//		} else {
//			//当如果是密码错误但是过了三次失败的禁止时间的话就更新禁止状态
//			return statusSave(us, Resultlist, userlist);
//		}
//
//	}
//
//	//失败后根据状态 执行相应的操作
//	private List statusSave(UserBO us, List Resultlist, List userlist) {
//		if (userlist.get(1).equals("003")) {
//			UserBO usb = new UserBO();
//			usb.setUsername(us.getUsername());
//			List<UserBO> listusb = userdao.getBlurUserDao(usb,null,null);
//			for (UserBO userBO : listusb) {
//				userBO.setForbidtime(null);
//				userdao.updateUserDao(userBO);
//			}
//		}
//		if (userlist.get(1).equals("002") || userlist.get(1).equals("003")) {
//			UserBO usb = new UserBO();
//			usb.setUsername(us.getUsername());
//			List<UserBO> listusb = userdao.getBlurUserDao(usb,null,null);
//			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//			for (UserBO userBO1 : listusb) {
//				String forbidstr = userBO1.getForbidtime();
//				String newforbid;
//				if (forbidstr != null&&forbidstr.trim().length()>0) {
//					int cout = 0;
//					String forbidstrs[] = forbidstr.split(",");
//					Timestamp ts = null;
//					for (String string : forbidstrs) {
//						if (string.indexOf("-") != -1) {
//							ts = Timestamp.valueOf(string);
//						} else {
//							cout = Integer.valueOf(string);
//						}
//					}
//					cout = cout + 1;
//					newforbid = timestamp.toString() + "," + cout;
//				} else {
//					newforbid = timestamp.toString() + "," + 1;
//				}
//				userBO1.setForbidtime(newforbid);
//				userdao.updateUserDao(userBO1);
//			}
//		}
//		Resultlist.add(0, null);
//		Resultlist.add(1, userlist.get(1));
//		return Resultlist;
//	}
//
	// 添加用户
	public void saveUserService(User usEntity) {
		// TODO Auto-generated method stub
		userdao.saveUserDao(usEntity);
	}
//
	// 更新用户
	public void updateUserService(UserUpdateVO us) {
		//先根据ID查询出来
		User userbo=userdao.getUserByIdDao(us.getId());
		if(userbo!=null){
			try {
				System.out.println("#################");
				BeanUtils.copyProperties(userbo, us);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("@@@@@@@@@@");
		userdao.updateUserDao(userbo);
	}
	
	
	/*******************************
	 * 功能：删除user
	 * 
	 *******************************/
	public void deleteUserService(User u){
		 userdao.deleteUserDao(u);
	 }
	
	// 模糊查询
	public PageResult getBlurUserService(User us ,Page page,Integer rid) {
		// TODO Auto-generated method stub		
//		PageResult rs=new PageResult();
//		int count=getCountUserService(us,rid);
//		page=PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), count);
//		rs.setPageList(userdao.getBlurUserDao(us,page,rid));
//		rs.setPage(page);
//		return rs;
		return userdao.getBlurUserDao(us,page,rid);
	}
//
//	// 删除
//	public void deleteUerService(UserBO UserBOEntity) {
//		// TODO Auto-generated method stub
//		userdao.deleteUerDao(UserBOEntity);
//		UserToRoleBO usertorolebo=new UserToRoleBO();
//		usertorolebo.setUserId(UserBOEntity.getId());
//		List<UserToRoleBO> list=ustorl.getBlurUserToRoleDao(usertorolebo);
//		//将角色对应表中的记录同时清除
//		for (UserToRoleBO userToRoleBO2 : list) {
//			ustorl.deleteUserToRoleDao(userToRoleBO2);
//		}
//	}
	//更改用户的状态
	public void updateUserStatusService(Integer usid ,Boolean status) {
		// TODO Auto-generated method stub
	      User user=userdao.getUserByIdDao(usid);
	      user.setEnabled(status);
	      userdao.updateUserDao(user);
	}
    //更新用户密码
	public void updateUserPasswordService(Integer uid,String pass) {
		User userbo = userdao.getUserByIdDao(uid);
		System.out.println("+++++++++++++++"+userbo);
		userbo.setPassword(pass);
//		userbo.setEmail("ff@df.com");
		System.out.println("------d----"+userbo);
		userdao.updateUserDao(userbo);
	}
//
//
//	// ID 查询
//	public UserBO getUserByIdService(Integer id) {
//		// TODO Auto-generated method stub
//		return userdao.getUserByIdDao(id);
//	}
   //统计函数
	public int getCountUserService(User UserBOEntity,Integer rid) {		
		return userdao.getCountUserDao(UserBOEntity,rid);
	}
//	
//	
//	// Spring 依赖注入需要的set方法
//	public void setUstorl(UserToRoleDao ustorl) {
//		this.ustorl = ustorl;
//	}
//
	
//	public void setUserdao(UserDao userdao) {
//		this.userdao = userdao;
//	}
//
//	public void setRoledao(RoleDao roledao) {
//		this.roledao = roledao;
//	}
//
//	
//	//DWR专用
//	public boolean getUserNameCountService(String usrername) {
//		
//		 return userdao.getUserNameCountDao(usrername);
//	}
//    //检查旧密码是否正确
//	public boolean checkpassword(String username, String pwd) {
//		// TODO Auto-generated method stub
//		String md5Str=Md5Util.getMD5Str(pwd);
//		return userdao.checkPwdDao(username, md5Str);
//	}
   //修改密码时候验证用户名和密码的方法
	public User getUserByUnameAndPwd(User UserBOEntity) {
		// TODO Auto-generated method stub
		return userdao.getUserByUnameAndPwd(UserBOEntity);
	}
//	//检查用户是否有管理员身份
//	public boolean checkAdminService(int uid) {
//		// TODO Auto-generated method stub
//		return userdao.checkAdminDao(uid);
//	}
//
//	
//	
//	//达梦根据用户名称取角色
//	public List loginService(String userName) {
//		// TODO Auto-generated method stub
//		//先查询出用户信息
//		UserBO userbo=userdao.getUserByNameDao(userName);
//		//在 根据用户ID查询相应角色信息
//		List roleList=new ArrayList();
//		roleList=roledao.getRoleByUserIdDao(userbo.getId());
//		//将角色和用户信息封装到List 后返回
//		List list=new ArrayList();
//		list.add(0,userbo);
//		list.add(1,roleList);
//		return list;
//	}
//   
	 /**
     *  根据用户名获得用户信息
     * @param username
     * @return {@link UserBO}
     */
	public User getUserinfoByNameService(String username) {
		System.out.println(username);
		return userdao.getUserinfoByNameDao(username);
	}
   
//
//	public boolean checkManagerNameService(String managerName) {
//		// TODO Auto-generated method stub
//		return userdao.checkManagerNameDao(managerName);
//	}
//
	public List<User> getAllUserDao() {
		return userdao.getAllUserDao();
	}
//
//	public void updateUser(UserBO user) {
//		// TODO Auto-generated method stub
//		userdao.updateUser(user);
//	}

	public void setBlackandwhitedao(BlackAndWhiteDao blackandwhitedao) {
		this.blackandwhitedao = blackandwhitedao;
	}

	public void setBlackandwhitestatusdao(
			BlackAndWhiteStatusDao blackandwhitestatusdao) {
		this.blackandwhitestatusdao = blackandwhitestatusdao;
	}
	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	/**
	 * 更新用户对象。
	 */
	public void updateUser(User user) {
		userdao.updateUserDao(user);
	}
	
	public void batchUpdateUser(Set<Domain> set){
		List<Domain> list = userdao.getCasecadeDomain(set);
		String str=null;
		for(Domain d:list){
			if(str==null){
				str=d.getId()+"";
			}else{
				str+=","+d.getId();
			}
		}
		System.out.println(str+"=========");
		userdao.batchUser(str);
	}

}
