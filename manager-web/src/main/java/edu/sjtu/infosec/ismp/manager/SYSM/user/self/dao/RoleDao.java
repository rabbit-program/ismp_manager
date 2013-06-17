package edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.security.Role;

public interface RoleDao {
	//根据ID 查询相关角色信息
    Role getRoleByIdDao(Integer roleID);
    
   //模糊查询
    List<Role> getBlurRoleDao(Role roleEntity);
//    //删除
//    void deleteRoleDao(RoleBO roleEntity);    
//    //修改
//    void updateRoleDao(RoleBO roleEntity);
//    //添加
//    void saveRoleDao(RoleBO roleEntity);
    
    //根据用户ID查询所有的角色信息
    List<Role> getRoleByUserIdDao(Serializable userID);
}
