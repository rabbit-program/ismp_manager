package edu.sjtu.infosec.ismp.manager.AIM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.AIM.model.AlertTypeBO;


public interface AlertDwrDao {

	/**
	 * 检查数据数否有新的告警信息被加入
	 * @param time
	 * @return
	 */
	int getChecknNewAlertinfoDao(String time);

	/**
	 * 查询所有的告警信息，当检查到有新的告警信息入库就马上调用
	 * @param curpage
	 * @param pagesize
	 * @param status
	 * @param type
	 * @param subType
	 * @param fusioin
	 * @param logintime
	 * @return
	 */
	List getPageListAlertDwrDao(int curpage, String pagesize, String status,
			String type, String subType, String fusioin,String logintime);
	/**
	 * DWR根据父名称查询子类型给
	 * @param parentName
	 * @return
	 */
	List<AlertTypeBO> getSubTypeByNameDao(String parentName);
	/**
	 * DWR根据父ID查询子类型
	 * @param id
	 * @return
	 */
	public List<AlertTypeBO> getSubTypeByParentId(Integer id);
	
	/**
	 * DWR模糊查询用户信息
	 * @param parentName
	 * @return
	 */
	List getUserPageListDao(String userName,String trueName,int currPage);
}
