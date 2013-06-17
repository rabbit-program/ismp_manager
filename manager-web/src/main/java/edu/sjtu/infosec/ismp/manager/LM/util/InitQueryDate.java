package edu.sjtu.infosec.ismp.manager.LM.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InitQueryDate {
	
	@SuppressWarnings("deprecation")
	/**
	 * queryDay：从当天起前向推的天数
	 */
	public static List<String> initQueryDate(int queryDay){
		SimpleDateFormat beginSdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat endSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<String> initDateList = new ArrayList<String>();
		
		Date today = new Date();
		Date beforeDay = new Date();
//		beforeDay.setMonth(today.getMonth()-1);				//向前一个月
//		Calendar c = Calendar.getInstance();
//		c.set(Calendar.DAY_OF_WEEK, 1);						// 设置当前日期为每周的第一天，即周日
		beforeDay.setDate(today.getDate() - queryDay);		//向前queryDay天
		
		String beginDate = beginSdf.format(beforeDay);
		String endDate = endSdf.format(today);
		
		initDateList.add(beginDate);
		initDateList.add(endDate);
		return initDateList;
	}
}
