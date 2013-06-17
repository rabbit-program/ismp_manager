package org.infosec.ismp.manager.winsensor.operation.service;

import org.infosec.ismp.agent.comm.winsensor.model.operation.Problem;
import org.infosec.ismp.manager.winsensor.operation.entity.ManagerProblemBO;

/**
 * @author Rocky
 * @version create time: Jan 15, 2011 4:53:22 PM
 *
 */
public interface ManagerProblemService {

	public Boolean addProblem(Problem problem, String domainId);

	public ManagerProblemBO findByProblemId(String problemId);

	public void closeOperationProblem(ManagerProblemBO problem);
	
	public void sendProblemClosed(ManagerProblemBO problem);

	public void generateWorkOrders(ManagerProblemBO problem, String workOrdersId);

	public void sendGenerateWorkOrders(ManagerProblemBO problem);

	public void closeWorkOrders(ManagerProblemBO problem, String workOrdersId);

	public void sendWorkOrdersClosed(ManagerProblemBO problem);

	public void completeWorkOrders(ManagerProblemBO problem, String workOrdersId);

	public void sendWorkOrdersCompleted(ManagerProblemBO problem);
}
