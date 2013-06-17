package edu.sjtu.infosec.ismp.manager.AIM.web.dwr;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.AIM.model.AlertTypeBO;


public interface AlertDwrServices {

	/**
	 * 检查数据数否有新的告警信息被加入
	 * @param time
	 * @return
	 */
	int getChecknNewAlertinfoService(String time);

    /**
     * 根据界面条件查询出新告警信息 并且DWR 无刷新显示
     * @param curpage -当前页
     * @param pagesize -每页显示记录
     * @param status- 告警状态
     * @param type-告警类型
     * @param subType-告警子类型
     * @param fusioin-是否归并的
     * @param logintime-监控的开始时间 
     * @return
     */
	List getPageListAlertDwrService(int curpage,String pagesize,String status,String type,String subType,String fusioin,String logintime) throws Exception;
	
	/**
	 * DWR根据父名称查询子类型给
	 * @param parentName-类型名称
	 * @return
	 */
	List<AlertTypeBO> getSubTypeByNameService(String parentName);
	
	/**
	 * DWR 根据父类Id查询子类型
	 * @param id
	 * @return
	 */
	public List<AlertTypeBO> getSubTypeByParentId(Integer id);
    /**
     * DWR模糊查询用户信息
     * @param userName --用户名称
     * @param trueName --真实姓名
     * @param currPage -- 当前页
     * @return
     */
	List getUserPageListService(String userName,String trueName,int currPage);
	/**
	 * DWR修改归并窗口的值
	 * @param parentName
	 * @return
	 */
	void saveOrUpdateAlertFustionRule(String parentName);
}
