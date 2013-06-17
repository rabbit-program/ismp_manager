package edu.sjtu.infosec.ismp.manager.BSAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.BaseDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineCabinet;
import edu.sjtu.infosec.ismp.security.Domain;

public interface MachineCabinetDao extends BaseDao {
	
	/**
	 * 获取机柜列表。
	 * Author：cchang
	 * @return
	 * 2010-10-12 20:45:49
	 */
	List getMachineCabinetList();
	
	/**
	 * 获取机柜列表（分页）。
	 * Author：cchang
	 * @return
	 * 2010-12-1 19:56:41
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
	 * 保存或者更新机柜信息
	 * Author：cchang
	 * @param machineCabinet
	 * 2010-10-27 15:25:09
	 */
	void saveOrUpdateMachineCabinet(MachineCabinet machineCabinet);
	
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
	
	/**
	 * 根据机柜的name查找机柜列表
	 * Author：cchang
	 * @param name
	 * @return
	 * 2010-11-25 18:38:04
	 */
	List<MachineCabinet> getMachineCabinetByName(String name);
	
}
