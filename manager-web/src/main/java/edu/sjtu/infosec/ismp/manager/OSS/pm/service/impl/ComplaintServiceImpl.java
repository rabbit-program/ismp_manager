/**
 * 
 */
package edu.sjtu.infosec.ismp.manager.OSS.pm.service.impl;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.OSS.pm.dao.ComplaintDao;
import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Complaint;
import edu.sjtu.infosec.ismp.manager.OSS.pm.service.ComplaintService;

/**
 * @author liuqing
 *
 */
public class ComplaintServiceImpl implements ComplaintService {

	/**
	 * @param complaintDao the complaintDao to set
	 */
	public void setComplaintDao(ComplaintDao complaintDao) {
		this.complaintDao = complaintDao;
	}

	private ComplaintDao complaintDao;
	
	
	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.OSS.pm.service.ComplaintService#del(edu.sjtu.infosec.ismp.manager.OSS.pm.model.Complaint)
	 */
	public void del(Complaint complaint) {
		// TODO Auto-generated method stub
		complaintDao.del(complaint);
	}

	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.OSS.pm.service.ComplaintService#save(edu.sjtu.infosec.ismp.manager.OSS.pm.model.Complaint)
	 */
	public void save(Complaint complaint) {
		// TODO Auto-generated method stub
		complaintDao.save(complaint);
	}

	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.OSS.pm.service.ComplaintService#searchAll()
	 */
	public List<Complaint> searchAll() {
		// TODO Auto-generated method stub
		return complaintDao.searchAll();
	}

	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.OSS.pm.service.ComplaintService#searchById(java.lang.Integer)
	 */
	public Complaint searchById(Integer id) {
		// TODO Auto-generated method stub
		return complaintDao.searchById(id);
	}
	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.OSS.pm.service.ComplaintService#update(edu.sjtu.infosec.ismp.manager.OSS.pm.model.Complaint)
	 */
	public void update(Complaint complaint) {
		// TODO Auto-generated method stub
		complaintDao.update(complaint);
	}

	public List<Complaint> searchByDomian(Integer domianId) {
		// TODO Auto-generated method stub
		return complaintDao.searchByDomian(domianId);
	}

	 public Map<String, String> searchDomainById() {
		// TODO Auto-generated method stub
		return complaintDao.searchDomainById();
	}

}
