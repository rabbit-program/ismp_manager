package edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.model.BlackAndWhiteStatusBO;

public interface BlackAndWhiteStatusDao {

	
	//查询黑白名单的启用状态
	BlackAndWhiteStatusBO getBlackAndWhiteStatusDao();
	
	//修改黑明白单的启用状态
	void updateBlackAndWhiteStatusDao(BlackAndWhiteStatusBO BlackAndWhiteStatusBOEntity);	
	
	//添加黑白名单状态，该方法是在数据表没记录的时候才调用的
	void saveBlackAndWhiteStatusDao(BlackAndWhiteStatusBO BlackAndWhiteStatusBOEntity);
	
	void deleteAllBlackAndWhiteStatusDao();
	
}
