package org.infosec.ismp.manager.winsensor.operation.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.infosec.ismp.agent.comm.util.OperationConstant;
import org.infosec.ismp.agent.comm.winsensor.model.operation.Problem;
import org.infosec.ismp.manager.winsensor.operation.dao.ManagerProblemDao;
import org.infosec.ismp.manager.winsensor.operation.entity.ManagerProblemBO;
import org.infosec.ismp.manager.winsensor.operation.service.ManagerProblemService;

/**
 * @author Rocky
 * @version create time: Jan 15, 2011 4:53:52 PM
 *
 */
public class ManagerProblemServiceImpl implements ManagerProblemService {

	private ManagerProblemDao dao;

	@Override
	public Boolean addProblem(Problem problem, String domainId) {
		ManagerProblemBO existProblem = dao.findProblem(problem.getProblemId());
		
		if (existProblem == null) {
			ManagerProblemBO problemBO = new ManagerProblemBO();
			problemBO.setContact(problem.getContact());
			problemBO.setContactAddress(problem.getContactAddress());
			SimpleDateFormat format = new SimpleDateFormat(OperationConstant.DUTY_MANAGER_DATE_FORMAT);
			long createTime;
			try {
				createTime = format.parse(problem.getCreateTime()).getTime();
			} catch (ParseException e) {
				createTime = System.currentTimeMillis();
			}
			
			problemBO.setCreateTime(new Timestamp(createTime));
			problemBO.setDescription(problem.getDescription());
			problemBO.setProblemId(problem.getProblemId());
			problemBO.setSensorId(problem.getSensorId());
			problemBO.setServiceAddress(problem.getServiceAddress());
			problemBO.setTitle(problem.getTitle());
			problemBO.setDomainId(Integer.valueOf(domainId));
			problemBO.setState(1);
			
			dao.addProblem(problemBO);
			return true;
		}
		
		return false;
	}

	@Override
	public ManagerProblemBO findByProblemId(String problemId) {
		return dao.findProblem(problemId);
	}
	
	@Override
	public void sendProblemClosed(ManagerProblemBO problem) {
		problem.setIfSendProbClosed(true);
		problem.setSendProbClosedTime(new Date());
		
		dao.updateProblem(problem);
	}
	
	@Override
	public void closeOperationProblem(ManagerProblemBO problem) {
		problem.setIfproblemClosed(true);
		problem.setProbClosedTime(new Date());
		
		dao.updateProblem(problem);
	}
	
	@Override
	public void generateWorkOrders(ManagerProblemBO problem, String workOrdersId) {
		problem.setWorkOrdersId(workOrdersId);
		problem.setIfGeneratedWorkOrders(true);
		problem.setWorkOrdersGeneTime(new Date());
		
		dao.updateProblem(problem);
	}
	
	@Override
	public void sendGenerateWorkOrders(ManagerProblemBO problem) {
		problem.setIfSendGeneWorkOrders(true);
		problem.setSendGeneworkOrdersTime(new Date());
		
		dao.updateProblem(problem);
	}
	
	@Override
	public void closeWorkOrders(ManagerProblemBO problem, String workOrdersId) {
		if (problem.getWorkOrdersId().equals(workOrdersId)) {
			problem.setIfWorkOrdersClosed(true);
			problem.setWorkOrdersClosedTime(new Date());
			
			dao.updateProblem(problem);
		}
	}
	
	@Override
	public void sendWorkOrdersClosed(ManagerProblemBO problem) {
		problem.setIfSendWorkOrdersClosed(true);
		problem.setSendOrdersClosedTime(new Date());
		
		dao.updateProblem(problem);
	}
	
	@Override
	public void completeWorkOrders(ManagerProblemBO problem, String workOrdersId) {
		if (problem.getWorkOrdersId().equals(workOrdersId)) {
			problem.setIfWorkOrdersComplete(true);
			problem.setWorkOrdersCompTime(new Date());
			
			dao.updateProblem(problem);
		}
	}
	
	@Override
	public void sendWorkOrdersCompleted(ManagerProblemBO problem) {
		problem.setIfSendWorkOrdersClosed(true);
		problem.setSendOrdersCompTime(new Date());
		
		dao.updateProblem(problem);
	}
	
	public void setDao(ManagerProblemDao dao) {
		this.dao = dao;
	}
}
