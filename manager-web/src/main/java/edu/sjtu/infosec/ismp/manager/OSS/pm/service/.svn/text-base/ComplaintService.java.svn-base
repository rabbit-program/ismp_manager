package edu.sjtu.infosec.ismp.manager.OSS.pm.service;
import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Complaint;
/**
 * @author liuqing
 *
 */
public interface ComplaintService {

	   /**
	    * 增
	    * @param softwareInfo
	    */
	   public void save(Complaint complaint);
		
	   /**
	    * 删
	    * @param softwareInfo
	    */
	   public void del(Complaint complaint);
	   /**
	    * 更新
	    * @param softwareInfo
	    */
	   public void update(Complaint complaint);
	   /**
	    * 查询所以
	    * @return
	    */
	   public List<Complaint> searchAll();
	   /**
	    * 根据id 查询对象
	    * @param id
	    * @return
	    */
	   public Complaint searchById(Integer id);
	   /**
	    *  根据 域 查询对象
	    * @param typeId
	    * @return
	    */
	   public List<Complaint> searchByDomian(Integer domianId);
	   /**
	    * 查询域所有Id
	    * @return
	    */
	   public Map<String, String> searchDomainById();
}
