package edu.sjtu.infosec.ismp.manager.BSAM.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.BSAM.dao.SecurityAreaDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.Machine;
import edu.sjtu.infosec.ismp.manager.BSAM.model.SubUnitVO;
import edu.sjtu.infosec.ismp.manager.BSAM.service.SecurityAreaService;

public class SecurityAreaServiceImpl implements SecurityAreaService {
	
	private SecurityAreaDao securityAreaDao;
	
	public void setSecurityAreaDao(SecurityAreaDao securityAreaDao) {
		this.securityAreaDao = securityAreaDao;
	}

	@SuppressWarnings("unchecked")
	public List getSubUnitById(String id, int startResult, int maxResult) {
//		select c.id,c.name,c.type from 
		List<Object[]> tempSubUnitList = securityAreaDao.getSubUnitById(id,startResult,maxResult);
		List<SubUnitVO> subUnitList = new ArrayList<SubUnitVO>();
		///将List<Object[]> tempSubUnitList解析成List<SubUnitVO>
		if(null != tempSubUnitList && tempSubUnitList.size() > 0){
			for (int i = 0; i < tempSubUnitList.size(); i++) {
				Object[] object = (Object[]) tempSubUnitList.get(i);
				SubUnitVO subUnitVO = new SubUnitVO();
				subUnitVO.setId((Integer)object[0]);///id
				subUnitVO.setName((String)object[1]);///name
				subUnitVO.setType((String)object[2]);///type
				subUnitList.add(subUnitVO);
			}
		}
		return subUnitList;
	}
	
	@SuppressWarnings("unchecked")
	public List getSubUnitById(String id) {
//		select c.id,c.name,c.type from 
		List<Object[]> tempSubUnitList = securityAreaDao.getSubUnitById(id);
		List<SubUnitVO> subUnitList = new ArrayList<SubUnitVO>();
		///将List<Object[]> tempSubUnitList解析成List<SubUnitVO>
		if(null != tempSubUnitList && tempSubUnitList.size() > 0){
			for (int i = 0; i < tempSubUnitList.size(); i++) {
				Object[] object = (Object[]) tempSubUnitList.get(i);
				SubUnitVO subUnitVO = new SubUnitVO();
				subUnitVO.setId((Integer)object[0]);///id
				subUnitVO.setName((String)object[1]);///name
				subUnitVO.setType((String)object[2]);///type
				subUnitList.add(subUnitVO);
			}
		}
		return subUnitList;
	}

	public int getSubUnitCountById(String id) {
		return securityAreaDao.getSubUnitCountById(id);
	}
	

}
