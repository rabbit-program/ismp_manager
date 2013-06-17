package edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.impl;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.RoleDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.RoleService;
import edu.sjtu.infosec.ismp.security.Role;

//import edu.sjtu.infosec.ismp.manager.user.dao.RoleDao;
//import edu.sjtu.infosec.ismp.manager.user.model.RoleBO;
//import edu.sjtu.infosec.ismp.manager.user.service.RoleService;

public class RoleServiceImpl implements RoleService{

	//注入Dao接口
	private RoleDao roledao;
	
	public void setRoledao(RoleDao roledao) {
		this.roledao = roledao;
	}
   //模糊查询
	public List<Role> getBlurRoleService(Role roleEntity) {
		// TODO Auto-generated method stub
		return roledao.getBlurRoleDao(roleEntity);
	}
	//ID查询
	public Role getRoleByIdService(Integer roleID) {
		return roledao.getRoleByIdDao(roleID);
	}
//   //删除
//	public void deleteRoleServic(RoleBO roleEntity) {
//		// TODO Auto-generated method stub
//		roledao.deleteRoleDao(roleEntity);
//	}
//   //添加 
//	public void saveRoleServic(RoleBO roleEntity) {
//		// TODO Auto-generated method stub
//		roledao.saveRoleDao(roleEntity);
//	}
//   //更新
//	public void updateRoleServic(RoleBO roleEntity) {
//		// TODO Auto-generated method stub
//		roledao.updateRoleDao(roleEntity);
//	}
	//根据用户ID 查询出所对应的角色
	public List<Role> getRoleByUserIdService(Serializable userID) {
		// TODO Auto-generated method stub
		return roledao.getRoleByUserIdDao(userID);
	}

}
