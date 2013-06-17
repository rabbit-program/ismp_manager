package edu.sjtu.infosec.ismp.manager.ERM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.ERM.dao.RespProcDao;
import edu.sjtu.infosec.ismp.manager.ERM.model.ContiRespProc;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.ERM.model.SafeThreatenInfo;
import edu.sjtu.infosec.ismp.manager.ERM.service.RespProcService;

public class RespProcServiceImpl implements RespProcService{
	private RespProcDao respprocDao;

	public void setRespprocDao(RespProcDao respprocDao) {
		this.respprocDao = respprocDao;
	}

	public List<ContiRespProc> findRespProcByrespinfo(int pageNow,int pageSize,String id,String sid) {
		return respprocDao.findRespProcByrespinfo(pageNow,pageSize,id,sid);
	}

	public List<SafeThreatenInfo> findSafeThreat() {
		return respprocDao.findSafeThreat();
	}

	public RespInfoBO findRespBoById(String id) {
		return respprocDao.findRespBoById(id);
	}

	public SafeThreatenInfo findSafeThreatenInfoById(String id) {
		return respprocDao.findSafeThreatenInfoById(id);
	}

	public List<ContiRespProc> findallByTwoId(RespInfoBO rid,
			SafeThreatenInfo sid) {
		return respprocDao.findallByTwoId(rid, sid);
	}

	public void delete(ContiRespProc con) {
		respprocDao.delete(con);
	}

	public void update(ContiRespProc con) {
		respprocDao.update(con);
	}

	public void save(ContiRespProc con) {
		respprocDao.save(con);
	}

	public String findSafeNameById(String id) 
	{
		String name=null;
		List<SafeThreatenInfo> list=respprocDao.findSafeNameById(id);
		for(SafeThreatenInfo s : list)
		{
			name=s.getName();
		}
		return name;
	}
	
	public void deleteProcByRespInfo(RespInfoBO resp){
		respprocDao.deleteProcByRespInfo(resp);
	}

	public int getCount(String respid,String safeid) {
		return respprocDao.getCount(respid,safeid);
	}

	
}
