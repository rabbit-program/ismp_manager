package edu.sjtu.infosec.ismp.manager.BSAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.BaseDao;

public interface SecurityAreaDao extends BaseDao {
	
	/**
	 * 获取域下的子单位(机房和主机)列表（分页）。
	 * Author：cchang
	 * @return
	 * 2010-12-20 10:42:47
	 */
	List getSubUnitById(String id,int startResult, int maxResult);

	/**
	 * 获取域下的子单位(机房和主机)列表（不分页）。
	 * Author：cchang
	 * @return
	 * 2010-12-20 10:42:47
	 */
	List getSubUnitById(String id);
	
	/**
	 * 获取域下的子单位总个数(机房和主机)。
	 * Author：cchang
	 * @return
	 * 2010-12-20 16:06:02
	 */
	int getSubUnitCountById(String id);
	
//	======================================================
}
