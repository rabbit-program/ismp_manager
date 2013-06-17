package org.infosec.ismp.situation.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/** 工具类 **/
public class ToolUtil {
	/**
	 * 时间转换器：将yyyy-MM-dd HH:mm:ss(24小时制)样式的时间字符串转换成Timestamp。
	 * Author：cchang
	 * @param strTime
	 * @return
	 * 2010-10-15 下午03:29:18
	 */
	public static Timestamp string2Timestamp(String strTime){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Timestamp timestamp = null;
		try {
			timestamp = new Timestamp(dateFormat.parse(strTime).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timestamp;
	}
	/**
	 * 时间转换器：将Timestamp类型的时间转换成yyyy-MM-dd HH:mm:ss(24小时制)样式的字符串
	 * Author：cchang
	 * @param timestamp
	 * @return
	 * 2010-10-19 下午03:04:22
	 */
	public static String timestamp2string(Timestamp timestamp){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String timeStr = dateFormat.format(new Date(timestamp.getTime()));
		return timeStr;
	}
	/**
	 * 根据日历的规则，为给定的日历字段添加或减去指定的时间量。
	 * Author：cchang
	 * @param timestamp
	 * @param field
	 * @param amount
	 * @return
	 * 2010-10-19 下午03:20:05
	 */
	public static Timestamp afterTimestamp(Timestamp timestamp,int field, int amount){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timestamp.getTime());
		calendar.add(field, amount);
		Timestamp timestamp2 = new Timestamp(calendar.getTimeInMillis());
		return timestamp2;
	}
	
	///main方法测试
	public static void main(String[] args) {
//		String _tempTime = ToolUtil.timestamp2string(new Timestamp(new Date().getTime()));
//		System.out.println(_tempTime);
		Timestamp timestamp = new Timestamp(new Date().getTime());
		for (int i = 0; i < 10; i++) {
			timestamp = ToolUtil.afterTimestamp(timestamp, Calendar.SECOND, 2);
			System.out.println(timestamp);
		}
	}
}
