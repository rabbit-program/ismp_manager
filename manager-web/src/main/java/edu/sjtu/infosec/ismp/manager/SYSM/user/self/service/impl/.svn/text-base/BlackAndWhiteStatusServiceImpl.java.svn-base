package edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.impl;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.BlackAndWhiteStatusDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.model.BlackAndWhiteStatusBO;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.BlackAndWhiteStatusService;

public class BlackAndWhiteStatusServiceImpl  implements BlackAndWhiteStatusService{

	
	//注入dao层接口
	private BlackAndWhiteStatusDao blackandwhitestatusdao;
	
	
	

	public void setBlackandwhitestatusdao(
			BlackAndWhiteStatusDao blackandwhitestatusdao) {
		this.blackandwhitestatusdao = blackandwhitestatusdao;
	}

	//查询黑白名单的启用状态
	public BlackAndWhiteStatusBO getBlackAndWhiteStatusService(){
		return blackandwhitestatusdao.getBlackAndWhiteStatusDao();
	}
	
	//修改黑明白单的启用状态
	public void updateBlackAndWhiteStatusService(BlackAndWhiteStatusBO BlackAndWhiteStatusBOEntity){
		blackandwhitestatusdao.updateBlackAndWhiteStatusDao(BlackAndWhiteStatusBOEntity);
	}	
	//添加黑白名单状态，该方法是在数据表没记录的时候才调用的
	public void saveBlackAndWhiteStatusService(BlackAndWhiteStatusBO BlackAndWhiteStatusBOEntity){
		// TODO Auto-generated method stub
		//先删除所有数据在添加
		blackandwhitestatusdao.deleteAllBlackAndWhiteStatusDao();
		blackandwhitestatusdao.saveBlackAndWhiteStatusDao(BlackAndWhiteStatusBOEntity);
	}
//
//	//删除所有数据
//	public void deleteAllBlackAndWhiteStatusService() {
//		// TODO Auto-generated method stub
//		blackandwhitestatusdao.deleteAllBlackAndWhiteStatusDao();
//	}

}
