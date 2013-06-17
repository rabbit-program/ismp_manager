package edu.sjtu.infosec.ismp.manager.ERM.service.impl;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.ERM.dao.RespInfoDao;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespFilePrint;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.ERM.service.RespInfoService;
import edu.sjtu.infosec.ismp.security.Domain;

public class RespInfoServiceImpl implements RespInfoService {
	
	private RespInfoDao respInfoDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setRespInfoDao(RespInfoDao respInfoDao) {
		this.respInfoDao = respInfoDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	

	
	public void add(RespInfoBO respInfo) throws Exception {
		respInfoDao.add(respInfo);
	}

	public void delete(RespInfoBO respInfo) throws Exception {
		respInfoDao.delete(respInfo);
	}

	public void update(RespInfoBO respInfo) throws Exception {
		respInfoDao.update(respInfo);
	}

	public List<RespInfoBO> findAll() throws Exception {
		List<RespInfoBO> list = respInfoDao.findAll();
		return list;
	}



	public RespInfoBO findrespInfoById(int id) {
		return respInfoDao.findrespInfoById(id);
	}



	public List<RespInfoBO> findAllByDomain(List<Domain> domainList)
			throws Exception {
		if(domainList == null){
			return null;
		}else if(domainList.size()<=0){
			return null;
		}else{
			List<RespInfoBO> list = respInfoDao.findAllByDomain(domainList);
			return list;
		}
	}



	public List<RespInfoBO> findAllByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,
			int startResult, int maxResult,int id,Domain domain,String respname,String sysname,String updatetime) throws Exception {
		if(domainList == null){
			return null;
		}else if(domainList.size()<=0){
			return null;
		}else{
			List list = respInfoDao.findAllByDomain(domainList, startRecordTime, endRecordTime, startResult, maxResult,id,domain,respname,sysname,updatetime);
			for(Object o : list)
			{
				//System.out.println("~~~~~~~");
				System.out.println(o);
			}
			return list;
		}
	}



	public long findAllNumByDomain(List<Domain> domainList,
			Timestamp startRecordTime, Timestamp endRecordTime,int id,String respname,String sysname,String updatetime)
			throws Exception {
		if(domainList == null){
			return 0;
		}else if(domainList.size()<=0){
			return 0;
		}else{
			long num = respInfoDao.findAllNumByDomain(domainList, startRecordTime, endRecordTime,id,respname,sysname,updatetime);
			return num;
		}
	}



	public List<RespInfoBO> findAll(Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult,int id,Domain domain,String respname,String sysname,String updatetime)
			throws Exception {
		List<RespInfoBO> list = respInfoDao.findAll(startRecordTime, endRecordTime, startResult, maxResult,id,domain,respname,sysname,updatetime);
		return list;
	}



	public RespFilePrint findFileContentById(RespInfoBO id) {
		List<RespFilePrint> list=respInfoDao.findFileContentById(id);
		if(list.isEmpty() || list.size()==0)
		{
			return null;
		}
		return list.get(0);
	}



	public void saveorupdate(RespFilePrint file) {
		respInfoDao.saveorupdate(file);
	}



	public void deleteFileByRespInfo(RespInfoBO resp) {
		respInfoDao.deleteFileByRespInfo(resp);
	}



	public long findAllNum(Timestamp startRecordTime, Timestamp endRecordTime,
			int id, String respname, String sysname, String updatetime)
			throws Exception {
		long num = respInfoDao.findAllNum(startRecordTime, endRecordTime,id,respname,sysname,updatetime);
		return num;
	}
	

}
