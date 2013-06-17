package edu.sjtu.infosec.ismp.manager.SYSM.user.self.web.dwr;


import org.springframework.beans.factory.annotation.Autowired;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.impl.UserDaoImp;
import edu.sjtu.infosec.ismp.security.User;
import edu.sjtu.infosec.ismp.util.Md5Util;

public class UserDwrValidateService {
	@Autowired
	private UserDaoImp userservice;
	
	public Boolean checkPassWord(String username,String pass){
		User user = new User();
		user.setLoginName(username);
		user.setPassword(Md5Util.getMD5Str(pass.trim()));
		User u =userservice.getUserByUnameAndPwd(user);
		if(u==null){
			return false;
		}else{
			return true;
		}
	}
	public Boolean checkUserName(String username){
		
		User user =userservice.getUserinfoByNameDao(username);
		System.out.println("===="+user);
		if(user==null){
			return true;
		}else{
			return false;
		}
	}
}
