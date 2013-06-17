package org.infosec.ismp.agent.winsensor.operation.service;

import java.util.List;

import org.infosec.ismp.agent.comm.winsensor.model.operation.Problem;
import org.infosec.ismp.agent.winsensor.operation.entity.ProblemBO;

/**
 * @author Rocky
 * @version create time: Jan 14, 2011 6:06:33 PM
 *
 */
public interface ProblemService {

	public Boolean addProblem(Problem problem);

	public void updateUploadSuccessInfo(String problemId);

	public List<Problem> getAllUnuploadProblem();

	public void receivedOperationProblem(ProblemBO problem);

	public void closeOperationProblem(ProblemBO problem);

	public void generateWorkOrders(ProblemBO problem, String workOrdersId);

	public ProblemBO findByProblemId(String problemId);

	public void closeWorkOrders(ProblemBO problem);

	public void completeWorkOrders(ProblemBO problem);

	public List<ProblemBO> getAllStateChangedProblems();

	public List<ProblemBO> findBySensorId(String sensorId);

	public void sendProblemClosedSuccess(ProblemBO problem);

	public void sendOrdersGeneratedSuccess(ProblemBO problem);

	public void sendOrdersClosedSuccess(ProblemBO problem);

	public void sendOrdersCompleteSuccess(ProblemBO problem);

}
