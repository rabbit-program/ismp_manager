package edu.sjtu.infosec.ismp.manager.SYSM.user.self.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.model.BlackAndWhiteBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

public interface BlackAndWhiteService {

//	
//	//多条件模糊查询
//	List<BlackAndWhiteBO> getBlurBlackAndWhiteService(BlackAndWhiteBO BlackAndWhiteBOEntity);	
//	
//	//根据ID 地址和黑白标记查询;用来登录的时候判断是否在启用的黑/白名单中
//	BlackAndWhiteBO getUniqueBlackAndWhiteService(BlackAndWhiteBO BlackAndWhiteBOEntity);
//	
	
	//添加黑白名单	
	void saveBlackAndWhiteService(BlackAndWhiteBO BlackAndWhiteBOEntity);
	//更新黑/白名单 
	void updateBelackAndWhiteService(BlackAndWhiteBO BlackAndWhiteBOEntity);
	//删除黑/白名单
	void deleteBlackAndWhiteService(BlackAndWhiteBO BlackAndWhiteBOEntity);
	//ID 模糊查询
    BlackAndWhiteBO getBlackAndWhiteByIdService(Integer ID);
	
	//多条件模糊查询加分页显示
	PageResult getPageListBlurBlackAndWhiteService(BlackAndWhiteBO BlackAndWhiteBOEntity ,Page page);
//	//统计函数
//	int getCountBlurBlackAndWhiteService(BlackAndWhiteBO BlackAndWhiteBOEntity);
}
