package org.infosec.ismp.manager.rmi.sensor.operation.service;
/**
 * @author Rocky
 * @version create time：Dec 16, 2010 7:29:06 PM
 * 运维工单的相关操作。
 */
public interface WinsensorOperationWorkOrdersService {

	/**
	 * 关闭问题
	 * @param problemId 问题Id
	 */
	public void closeProblem(String problemId);
	
	/**
	 * 产生工单
	 * @param problemId 问题Id
	 * @param workOrdersId 工单Id
	 */
	public void generateWorkOrders(String problemId, String workOrdersId);
	
	/**
	 * 关闭工单
	 * @param problemId 问题Id
	 * @param workOrdersId 工单Id
	 */
	public void closeWorkOrders(String problemId, String workOrdersId);
	
	/**
	 * 完成工单
	 * @param problemId 问题Id
	 * @param workOrdersId 工单Id
	 */
	public void completeWorkOrders(String problemId, String workOrdersId);
}
