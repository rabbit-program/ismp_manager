package edu.sjtu.infosec.ismp.manager.BSAM.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineCabinet;
import edu.sjtu.infosec.ismp.security.Domain;

public interface MachineCabinetService {
	/**
	 * 获取机柜列表。
	 * Author：cchang
	 * @return
	 * 2010-10-12 20:39:02
	 */
	List getMachineCabinetList();
	
	/**
	 * 获取机柜列表(分页)。
	 * Author：cchang
	 * @return
	 * 2010-12-1 20:22:22
	 */
	List getMachineCabinetList(int startResult, int maxResult);
	
	/**
	 * 获取机柜列表（分页  分域）。
	 * Author：cchang
	 * @return
	 * 2010-12-3 15:05:16
	 */
	List getMachineCabinetListByDomain(List<Domain> userDomainList, int startResult, int maxResult);
	
	/**
	 * 获取机柜列表（分域）。
	 * Author：cchang
	 * @return
	 * 2010-12-3 15:05:16
	 */
	List getMachineCabinetListByDomain(List<Domain> userDomainList);
	
	/**
	 * 根据机柜的id删除机柜
	 * Author：cchang
	 * @param id
	 * 2010-10-26 14:50:11
	 */
	void deleteMachineCabinetById(Integer id);
	
	/**
	 * 根据机柜的id查找机柜
	 * Author：cchang
	 * @param id
	 * @return
	 * 2010-10-27 14:55:11
	 */
	MachineCabinet getMachineCabinetById(Integer id);
	
	/**
	 * 根据机柜的name查找机柜
	 * Author：cchang
	 * @param name
	 * @return
	 * 2010-10-27 14:55:11
	 */
	List<MachineCabinet> getMachineCabinetByName(String name);
	
	/**
	 * 保存或者更新机柜信息
	 * Author：cchang
	 * @param machineCabinet
	 * 2010-10-27 15:17:05
	 */
	void saveOrUpdate(MachineCabinet machineCabinet);
	
	/**
	 * 取得机柜列表总记录条数
	 * Author：cchang
	 * 2010-12-2 10:09:09
	 */
	int getCount();
	
	/**
	 * 取得机柜列表总记录条数（分域）
	 * Author：cchang
	 * 2010-12-2 10:09:09
	 */
	int getCountByDomain(List<Domain> userDomainList);
	
	/**
	 * 获取机柜下的子单位(主机)列表（分页）。
	 * Author：cchang
	 * @return
	 * 2010-12-20 10:42:47
	 */
	List getSubUnitById(String id,int startResult, int maxResult);

	/**
	 * 获取机柜下的子单位(主机)列表（不分页）。
	 * Author：cchang
	 * @return
	 * 2010-12-20 10:42:47
	 */
	List getSubUnitById(String id);
	
	/**
	 * 获取机柜下的子单位总个数(主机)。
	 * Author：cchang
	 * @return
	 * 2010-12-20 16:06:02
	 */
	int getSubUnitCountById(String id);
	
//	==================================================================
	
}
