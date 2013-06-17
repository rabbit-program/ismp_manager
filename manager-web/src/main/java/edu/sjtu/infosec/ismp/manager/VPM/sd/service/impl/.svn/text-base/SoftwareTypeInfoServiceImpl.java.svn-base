package edu.sjtu.infosec.ismp.manager.VPM.sd.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.sd.dao.SoftwareTypeInfoDao;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.TypeInfo;
import edu.sjtu.infosec.ismp.manager.VPM.sd.service.SoftwareTypeInfoService;

/**
 * @author liuqing
 *
 */
public class SoftwareTypeInfoServiceImpl implements SoftwareTypeInfoService {

	private SoftwareTypeInfoDao  softwareTypeInfoDao;
	/**
	 * @param softwareTypeInfoDao the softwareTypeInfoDao to set
	 */
	public void setSoftwareTypeInfoDao(SoftwareTypeInfoDao softwareTypeInfoDao) {
		this.softwareTypeInfoDao = softwareTypeInfoDao;
	}
	public void del(Integer id) {
		softwareTypeInfoDao.del(id);
	}

	public void save(TypeInfo typeInfo) {
		softwareTypeInfoDao.save(typeInfo);
	}

	public List<TypeInfo> searchAll() {
		return softwareTypeInfoDao.searchAll();
	}

	public void update(TypeInfo typeInfo) {
		softwareTypeInfoDao.update(typeInfo);
	}

	
}
