package edu.sjtu.infosec.ismp.manager.BSAM.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.dao.DataAccessResourceFailureException;


public interface SubUnitSituationService {
	
	/**
	 * 根据传入的subUnit的ids返回这些下级子单位的态势列表
	 * @param subUnitIds
	 * @return
	 */
	List getSubUnitSituation(String subUnitIds);
	
	/**
	 * 此方法由applet访问Servlet的时候调用(获取初始值)
	 * 根据传入的单位id和单位flag查出其子单位的态势等信息并组成字符串信息返回
	 * @param id,flag
	 * @return
	 */
	String getInitValues(Integer id,String flag) throws DataAccessResourceFailureException, IllegalStateException, ParseException ;
	/**
	 * 此方法由applet访问Servlet的时候调用(获取当前态势拼接字符串)
	 * 根据传入的单位id和单位flag查出其子单位的态势等信息并组成字符串信息返回
	 * @param id
	 * @param flag
	 * @return
	 */
	String getCurrentValues(Integer id,String flag);
	/**
	 * 此方法由applet访问Servlet的时候调用(获取历史态势拼接字符串)
	 * 根据传入的id,flag获取beginTime——endTime时间段的历史态势并组成字符串信息返回
	 * @param beginTime
	 * @param endTime
	 * @param id,flag
	 * @param firstIndex
	 * @return
	 * @throws DataAccessResourceFailureException
	 * @throws IllegalStateException
	 * @throws ParseException
	 */
	String getHistoryValue(String beginTime, String endTime,Integer id,String flag, Integer firstIndex)
			throws DataAccessResourceFailureException, IllegalStateException, ParseException;
}
