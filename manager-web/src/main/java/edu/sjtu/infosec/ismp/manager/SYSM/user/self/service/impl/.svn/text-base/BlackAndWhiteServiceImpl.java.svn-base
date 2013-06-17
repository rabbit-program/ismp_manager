package edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.dao.BlackAndWhiteDao;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.model.BlackAndWhiteBO;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.BlackAndWhiteService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

public class BlackAndWhiteServiceImpl implements BlackAndWhiteService{

	
	//注入Dao接口
	private BlackAndWhiteDao blackandwhitedao;
	
	public void setBlackandwhitedao(BlackAndWhiteDao blackandwhitedao) {
		this.blackandwhitedao = blackandwhitedao;
	}

//	//多条件模糊查询
//	public List<BlackAndWhiteBO> getBlurBlackAndWhiteService(BlackAndWhiteBO BlackAndWhiteBOEntity) {
//		// TODO Auto-generated method stub
//		return blackandwhitedao.getBlurBlackAndWhiteDao(BlackAndWhiteBOEntity);
//	}	
	//根据ID 地址和黑白标记查询;用来登录的时候判断是否在启用的黑/白名单中
	public BlackAndWhiteBO getUniqueBlackAndWhiteService(
			BlackAndWhiteBO BlackAndWhiteBOEntity) {
		// TODO Auto-generated method stub
		return blackandwhitedao.getUniqueBlackAndWhiteDao(BlackAndWhiteBOEntity);
	}	
	//添加黑白名单	
	public void saveBlackAndWhiteService(BlackAndWhiteBO BlackAndWhiteBOEntity){
		blackandwhitedao.saveBlackAndWhiteDao(BlackAndWhiteBOEntity);
	}
	//更新黑/白名单 
	public void updateBelackAndWhiteService(BlackAndWhiteBO BlackAndWhiteBOEntity){
		blackandwhitedao.updateBelackAndWhiteDao(BlackAndWhiteBOEntity);
	}
	//删除黑/白名单
	public void deleteBlackAndWhiteService(BlackAndWhiteBO BlackAndWhiteBOEntity){
		blackandwhitedao.deleteBlackAndWhiteDao(BlackAndWhiteBOEntity);
	}
	//ID 模糊查询
	public BlackAndWhiteBO getBlackAndWhiteByIdService(Integer ID){
		return blackandwhitedao.getBlackAndWhiteByIdDao(ID);
	}

	public int getCountBlurBlackAndWhiteService(BlackAndWhiteBO BlackAndWhiteBOEntity){
		return blackandwhitedao.getCountBlurBlackAndWhiteService(BlackAndWhiteBOEntity);
	}
	public PageResult getPageListBlurBlackAndWhiteService(
			BlackAndWhiteBO BlackAndWhiteBOEntity, Page page) {
		List list=blackandwhitedao.getPageListBlurBlackAndWhiteDao(BlackAndWhiteBOEntity, page);
		int count=getCountBlurBlackAndWhiteService(BlackAndWhiteBOEntity);
		PageResult rs=new PageResult();
		page=PageUtil.createPage(page.getEveryPage(), page.getCurrentPage(), count);
		rs.setPage(page);
		rs.setPageList(list);
		return rs;
	}
    

}
