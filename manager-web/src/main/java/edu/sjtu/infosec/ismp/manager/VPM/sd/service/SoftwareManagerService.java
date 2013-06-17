package edu.sjtu.infosec.ismp.manager.VPM.sd.service;

import java.sql.Timestamp;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.SoftwareInfo;


public interface SoftwareManagerService {

	   /**
	    * 增
	    * @param softwareInfo
	    */
	   public void save(SoftwareInfo softwareInfo);
		
	   /**
	    * 删
	    * @param softwareInfo
	    */
	   public void del(SoftwareInfo softwareInfo);
	   /**
	    * 更新
	    * @param softwareInfo
	    */
	   public void update(SoftwareInfo softwareInfo);
	   /**
	    * 查询所以
	    * @return
	    */
	   public List<SoftwareInfo> searchAll();
	   /**
	    * 条件查询
	    * @param softwareInfo
	    * @return
	    */
	   public List<SoftwareInfo> searchByConditions(SoftwareInfo softwareInfo,PMPage page,Timestamp uploadStartTime,Timestamp uploadEndTime);
	   /**
	    * 根据id 查询对象
	    * @param id
	    * @return
	    */
	   public SoftwareInfo searchById(Integer id);
	   /**
	    *  根据 类型 查询对象
	    * @param typeId
	    * @return
	    */
	   public List<SoftwareInfo> searchByType(Integer typeId);
}
