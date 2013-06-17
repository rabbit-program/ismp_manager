package edu.sjtu.infosec.ismp.manager.BSAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.BaseDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.Machine;
import edu.sjtu.infosec.ismp.security.Domain;

public interface MachineDao extends BaseDao {
	
	/**
	 * 获取主机列表。
	 * Author：cchang
	 * @return
	 * 2010-9-29 下午03:15:08
	 */
	List getMachineList();
	
	/**
	 * 获取主机列表(分页)
	 * Author：cchang
	 * @return
	 * 2010-12-1 14:09:39
	 */
	List getMachineList(int startResult, int maxResult);
	
	/**
	 * 获取主机列表（分页  分域）。
	 * Author：cchang
	 * @return
	 * 2010-12-3 15:05:16
	 */
	List getMachineListByDomain(List<Domain> userDomainList, int startResult, int maxResult);
	
	/**
	 * 保存或更新主机信息
	 * Author：cchang
	 * @param machine
	 * 2010-10-27 15:23:24
	 */
	void saveOrUpdate(Machine machine);
	
	/**
	 * 取得主机列表总记录条数
	 * Author：cchang
	 * 2010-12-2 10:09:09
	 */
	int getCount();
	
	/**
	 * 取得主机列表总记录条数（分域）
	 * Author：cchang
	 * 2010-12-2 10:09:09
	 */
	int getCountByDomain(List<Domain> userDomainList);
	
	/**
	 * 按照权重获取前maxResult主机
	 * Author：cchang
	 * @return
	 * 2010-12-3 15:05:16
	 */
	List getTopMachineListByWeight(int maxResult);
	
	/**
	 * 按照权重获取前maxResult主机(分域)
	 * Author：cchang
	 * @return
	 * 2010-12-3 15:05:16
	 */
	List getTopMachineListByWeightByDomain(List<Domain> userDomainList,int maxResult);
	
}
