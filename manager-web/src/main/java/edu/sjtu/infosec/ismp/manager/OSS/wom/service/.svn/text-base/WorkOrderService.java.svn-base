package edu.sjtu.infosec.ismp.manager.OSS.wom.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Roster;
import edu.sjtu.infosec.ismp.manager.OSS.wom.model.WorkOrder;
import edu.sjtu.infosec.ismp.security.Domain;
/**
 * Service层 派工单Action.
 */
public interface WorkOrderService {
	/**
	 * 保存/更新派工单
	 */
	 void saveOrUpdate(WorkOrder workOrder);

	/**
	 * 删除派工单
	 */
	 void remove(WorkOrder workOrder);

	/**
	 * 批量删除派工单
	 */
	 void remove(String[] workOrders);

	/**
	 * 根据问题id查询派工单
	 */
	 WorkOrder findByQuestion(Integer questionId);
	/**
	 * 根据id查询派工单
	 */
	WorkOrder findById(Integer id);
	/**
	 * 查询工单号
	 */
	String findSN();
	/**
	 * 查找值班人员
	 */
	List<Roster> findOperator();
	/**
	 * 根据值班人员id查询派工单
	 */
	 WorkOrder findByRoster(Integer rosterId);

	/**
	 * 派工单分页信息
	 */
	 List<WorkOrder> findAll(int startResult, int maxResult,Domain domain,Integer state);

	/**
	 * 委办局下派工单分页信息
	 */
	 List<WorkOrder> findAllByDomain(
			List<Domain> userDomainList, int startResult, int maxResult,Domain domain,Integer state);

	/**
	 * 派工单查询记录总条数
	 */
	 int getCount(Domain domain,Integer state);

	/**
	 * 委办局下派工单查询记录总条数
	 */
	 int getCountByDomain(List<Domain> userDomainList,Domain domain,Integer state);
	 /**
	  * 根据id查找值班人员
	  */
	 Roster findOperatorById(Integer id);

}