package edu.sjtu.infosec.ismp.manager.VPM.sd.service.impl;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPageUtil;
import edu.sjtu.infosec.ismp.manager.VPM.sd.dao.SoftwareManagerDao;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.SoftwareInfo;
import edu.sjtu.infosec.ismp.manager.VPM.sd.service.SoftwareManagerService;


/**
 * @Description: TODO
 * @author liuqing
 * 
 */
public class SoftwareManagerServiceImpl implements SoftwareManagerService {

	/**
	 * 中心层软件操作Dao
	 */
	private SoftwareManagerDao softwareManagerDao;

	/**
	 * @param vSoftwareManagerDao
	 *            the softwareManagerDao to set
	 */
	public void setSoftwareManagerDao(SoftwareManagerDao vSoftwareManagerDao) {
		softwareManagerDao = vSoftwareManagerDao;
	}

	public void del(SoftwareInfo softwareInfo) {
		softwareManagerDao.del(softwareInfo);		
	}

	public void save(SoftwareInfo softwareInfo) {
		// TODO Auto-generated method stub
		softwareManagerDao.save(softwareInfo);
	}

	public List<SoftwareInfo> searchAll() {
		// TODO Auto-generated method stub
		return softwareManagerDao.searchAll();
	}

	public List<SoftwareInfo> searchByConditions(SoftwareInfo softwareInfo,PMPage page,Timestamp uploadStartTime,Timestamp uploadEndTime) {
		int count = (Integer) softwareManagerDao.searchByConditionsCount(softwareInfo, page, uploadStartTime, uploadEndTime);
		page.setPageInfo(PMPageUtil.createPage(page, count));
		return softwareManagerDao.searchByConditions(softwareInfo,page,uploadStartTime,uploadEndTime);
	}

	public SoftwareInfo searchById(Integer id) {
		// TODO Auto-generated method stub
		return softwareManagerDao.searchById(id);
	}

	public List<SoftwareInfo> searchByType(Integer typeId) {
		// TODO Auto-generated method stub
		return softwareManagerDao.searchByType(typeId);
	}

	public void update(SoftwareInfo softwareInfo) {
		// TODO Auto-generated method stub
		softwareManagerDao.update(softwareInfo);
	}



}
