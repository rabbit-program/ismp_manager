package org.infosec.ismp.agent.winsensor.operation.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.operation.Problem;
import org.infosec.ismp.agent.winsensor.operation.dao.ProblemDao;
import org.infosec.ismp.agent.winsensor.operation.entity.ProblemBO;
import org.infosec.ismp.agent.winsensor.operation.service.ProblemService;

/**
 * @author Rocky
 * @version create time: Jan 14, 2011 6:06:55 PM
 *
 */
public class ProblemServiceImpl implements ProblemService {
	
	private ProblemDao dao;

	@Override
	public Boolean addProblem(Problem problem) {
		ProblemBO existProblem = dao.findProblem(problem.getProblemId());
		
		if (existProblem == null) {
			ProblemBO problemBO = new ProblemBO();
			problemBO.setContact(problem.getContact());
			problemBO.setContactAddress(problem.getContactAddress());
			problemBO.setCreateTime(problem.getCreateTime());
			problemBO.setDescription(problem.getDescription());
			problemBO.setProblemId(problem.getProblemId());
			problemBO.setSensorId(problem.getSensorId());
			problemBO.setServiceAddress(problem.getServiceAddress());
			problemBO.setTitle(problem.getTitle());
			problemBO.setIfSendToManager(false);
			
			dao.addProblem(problemBO);
			return true;
		}
		
		return false;
	}
	
	@Override
	public void updateUploadSuccessInfo(String problemId) {
		ProblemBO problem = dao.findProblem(problemId);
		
		if (problem != null) {
			problem.setIfSendToManager(true);
			dao.updateProblem(problem);
		}
	}
	
	@Override
	public List<Problem> getAllUnuploadProblem() {
		List<ProblemBO> problemBOs = dao.getAllUnuploadProblem();
		List<Problem> problems = new ArrayList<Problem>();
		
		for (ProblemBO problemBO : problemBOs) {
			Problem problem = new Problem();
			problem.setContact(problemBO.getContact());
			problem.setContactAddress(problemBO.getContactAddress());
			problem.setCreateTime(problemBO.getCreateTime());
			problem.setDescription(problemBO.getDescription());
			problem.setProblemId(problemBO.getProblemId());
			problem.setSensorId(problemBO.getSensorId());
			problem.setServiceAddress(problemBO.getServiceAddress());
			problem.setTitle(problemBO.getTitle());
			
			problems.add(problem);
		}
		
		return problems;
	}
	

	@Override
	public ProblemBO findByProblemId(String problemId) {
		return dao.findProblem(problemId);
	}
	
	@Override
	public void receivedOperationProblem(ProblemBO problem) {
		problem.setIfManagerReceived(true);
		dao.updateProblem(problem);
	}
	
	@Override
	public void closeOperationProblem(ProblemBO problem) {
		problem.setIfProblemClosed(true);
		problem.setProbClosedTime(new Date());
		problem.setIfSendProbClosed(false);
		
		dao.updateProblem(problem);		
	}
	
	@Override
	public void generateWorkOrders(ProblemBO problem, String workOrdersId) {
		problem.setWorkOrdersId(workOrdersId);
		problem.setIfGeneratedWorkOrders(true);
		problem.setWorkOrdersGeneTime(new Date());
		problem.setIfSendGeneWorkOrders(false);
		
		dao.updateProblem(problem);
	}
	
	@Override
	public void closeWorkOrders(ProblemBO problem) {
		problem.setIfWorkOrdersClosed(true);
		problem.setWorkOrdersClosedTime(new Date());
		problem.setIfSendWorkOrdersClosed(false);
		
		dao.updateProblem(problem);
	}
	
	@Override
	public void completeWorkOrders(ProblemBO problem) {
		problem.setIfWorkOrdersComplete(true);
		problem.setWorkOrdersCompTime(new Date());
		problem.setIfSendOrdersCompleted(false);
		
		dao.updateProblem(problem);		
	}
	
	@Override
	public List<ProblemBO> getAllStateChangedProblems() {
		
		return dao.getAllStateChangedProblems();
	}
	
	@Override
	public List<ProblemBO> findBySensorId(String sensorId) {
		return dao.findBySensorId(sensorId);
	}
	

	@Override
	public void sendProblemClosedSuccess(ProblemBO problem) {
		problem.setIfSendProbClosed(true);
		problem.setSendProbClosedTime(new Date());
		
		dao.updateProblem(problem);
	}

	@Override
	public void sendOrdersGeneratedSuccess(ProblemBO problem) {
		problem.setIfSendGeneWorkOrders(true);
		problem.setSendGeneworkOrdersTime(new Date());
		
		dao.updateProblem(problem);
	}

	@Override
	public void sendOrdersClosedSuccess(ProblemBO problem) {
		problem.setIfSendWorkOrdersClosed(true);
		problem.setSendOrdersClosedTime(new Date());
		
		dao.updateProblem(problem);
	}

	@Override
	public void sendOrdersCompleteSuccess(ProblemBO problem) {
		problem.setIfSendOrdersCompleted(true);
		problem.setSendOrdersCompTime(new Date());
		
		dao.updateProblem(problem);
	}

	public void setDao(ProblemDao dao) {
		this.dao = dao;
	}
}
