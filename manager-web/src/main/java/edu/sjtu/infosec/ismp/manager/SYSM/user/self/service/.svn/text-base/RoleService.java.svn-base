package edu.sjtu.infosec.ismp.manager.SYSM.user.self.service;

import java.io.Serializable;
import java.util.List;

import edu.sjtu.infosec.ismp.security.Role;

public interface RoleService{

	//根据ID 查询相关角色信息
     Role getRoleByIdService(Integer roleID);
     
    //模糊查询
     List<Role> getBlurRoleService(Role roleEntity);
//     
//     //删除
//     void deleteRoleServic(Role roleEntity);    
//     //修改
//     void updateRoleServic(Role roleEntity);
//     //添加
//     void saveRoleServic(Role roleEntity);
     
     //根据用户ID查询所有的角色信息
     List<Role> getRoleByUserIdService(Serializable userID);

}
