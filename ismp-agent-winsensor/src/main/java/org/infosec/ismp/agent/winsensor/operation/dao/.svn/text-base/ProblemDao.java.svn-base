package org.infosec.ismp.agent.winsensor.operation.dao;

import java.util.List;

import org.infosec.ismp.agent.winsensor.operation.entity.ProblemBO;

/**
 * @author Rocky
 * @version create time: Jan 14, 2011 6:05:09 PM
 *
 */
public interface ProblemDao {

	public ProblemBO findProblem(String problemId);

	public void addProblem(ProblemBO problem);

	public void updateProblem(ProblemBO problem);

	public List<ProblemBO> getAllUnuploadProblem();

	public List<ProblemBO> getAllStateChangedProblems();

	public List<ProblemBO> findBySensorId(String sensorId);

}
