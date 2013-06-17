package edu.sjtu.infosec.ismp.manager.BSAM.service;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.BSAM.model.Machine;
import edu.sjtu.infosec.ismp.security.Domain;

public interface MachineService {
	/**
	 * 获取主机列表。
	 * Author：cchang
	 * @return
	 * 2010-9-29 下午03:15:08
	 */
	List getMachineList();
	
	/**
	 * 获取主机列表(分页)。
	 * Author：cchang
	 * @return
	 * 2010-12-1 14:20:44
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
	 * 根据主机的id删除主机
	 * Author：cchang
	 * @param id
	 * 2010-10-20 上午10:57:30
	 */
	void deleteMachineById(Integer id);
	
	/**
	 * 根据主机的id查找主机
	 * @param id
	 * @return
	 * 2010-10-26 15:23:48
	 */
	Machine getMachineById(Integer id);
	
	/**
	 * 保存或者更新主机信息
	 * @param machine
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
	
//	==================================================================
}
