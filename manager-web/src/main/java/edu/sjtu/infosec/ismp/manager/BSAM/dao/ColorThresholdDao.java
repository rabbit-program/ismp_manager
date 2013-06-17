package edu.sjtu.infosec.ismp.manager.BSAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.BaseDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.ColorThreshold;


public interface ColorThresholdDao extends BaseDao{
	
	/**
	 * 获取全部(顏色閾值)ColorThreshold信息。
	 * Author：cchang
	 * @return
	 * 2010-10-13 10:31:02
	 */
	List getColorThresholdList();
	
	/**
	 * 根据color查出相应的ColorThreshold。
	 * Author：cchang
	 * @param color
	 * @return
	 * 2010-9-25 下午02:14:37
	 */
	ColorThreshold getColorThresholdByColor(String color);
	
	/**
	 * 更新或者保存ColorThreshold。
	 * Author：cchang
	 * @param colorThreshold
	 * 2010-9-25 下午02:14:58
	 */
	void saveOrUpdate(ColorThreshold colorThreshold);
	
}
