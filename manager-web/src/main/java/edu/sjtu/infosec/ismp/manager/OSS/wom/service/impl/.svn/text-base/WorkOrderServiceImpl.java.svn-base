package edu.sjtu.infosec.ismp.manager.OSS.wom.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Roster;
import edu.sjtu.infosec.ismp.manager.OSS.wom.dao.WorkOrderDao;
import edu.sjtu.infosec.ismp.manager.OSS.wom.model.WorkOrder;
import edu.sjtu.infosec.ismp.manager.OSS.wom.service.WorkOrderService;
import edu.sjtu.infosec.ismp.security.Domain;
/**
 * Service层 派工单service.
 */
public class WorkOrderServiceImpl implements WorkOrderService {
	private WorkOrderDao workOrderDao;
	
	public WorkOrderDao getWorkOrderDao() {
		return workOrderDao;
	}

	public void setWorkOrderDao(WorkOrderDao workOrderDao) {
		this.workOrderDao = workOrderDao;
	}
	
	

	public List<WorkOrder> findAll(int startResult, int maxResult,Domain domain,Integer state) {
		return workOrderDao.findAll(startResult, maxResult, domain, state);
	}

	public List<WorkOrder> findAllByDomain(List<Domain> userDomainList,
			int startResult, int maxResult,Domain domain,Integer state) {
		return workOrderDao.findAllByDomain(userDomainList, startResult, maxResult,domain,state);
	}

	public WorkOrder findById(Integer id) {
		return workOrderDao.findById(id);
	}

	public WorkOrder findByQuestion(Integer questionId) {
		return workOrderDao.findByQuestion(questionId);
	}

	public WorkOrder findByRoster(Integer rosterId) {
		return workOrderDao.findByRoster(rosterId);
	}

	public int getCount(Domain domain,Integer state) {
		return workOrderDao.getCount(domain,state);
	}

	public int getCountByDomain(List<Domain> userDomainList,Domain domain,Integer state) {
		return workOrderDao.getCountByDomain(userDomainList,domain,state);
	}

	public void remove(WorkOrder workOrder) {
		workOrderDao.remove(workOrder);
	}


	public void saveOrUpdate(WorkOrder workOrder) {
		workOrderDao.saveOrUpdate(workOrder);
	}

	public void remove(String[] workOrders) {
		List<WorkOrder> workOrderList = new ArrayList<WorkOrder>();
        for(int i=0;i<workOrders.length;i++) {
        	WorkOrder workOrder = workOrderDao.findById(Integer.parseInt(workOrders[i]));
        	workOrderList.add(workOrder);
        }
        if(workOrderList.size()>0) {
        	workOrderDao.remove(workOrderList);
        }
	}

	public String findSN() {
		return workOrderDao.findSN();
	}
	
	public List<Roster> findOperator() {
		return workOrderDao.findOperator();
	}

	public Roster findOperatorById(Integer id) {
		return workOrderDao.findOperatorById(id);
	}
	
}
