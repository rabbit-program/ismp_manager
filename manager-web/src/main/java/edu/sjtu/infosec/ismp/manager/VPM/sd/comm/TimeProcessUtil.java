package edu.sjtu.infosec.ismp.manager.VPM.sd.comm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**  
 * @Title: TimeProcessUtil.java
 * @Package edu.sjtu.infosec.ismp.center.virus.software.util
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-8-13 下午04:20:38   
 * @version V1.0  
 */
/**
 * @ClassName: TimeProcessUtil
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-8-13 下午04:20:38
 *
 */
public class TimeProcessUtil {
	/**
	 * 获取现在时间字符串
	 * 
	 * @return 返回当前的时间字符串 yyyy-MM-dd HH:mm:ss
	 * @throws ParseException
	 */
	public static String getNowDateString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return format.format(calendar.getTime());
	}
	
	/**
	 * 
	 * getNowDate
	 *      decription : 获取现在时间 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date getNowDate(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = format.getCalendar();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return calendar.getTime();
	}
	
	/**
	 * 
	 * getFormatDate
	 *      decription : 根据传输的时间字符串，得到相对应的时间
	 * @param dateStr 必须为yyyy-MM-dd HH:mm:ss 的格式 (如：2009-01-01 03:01:01)
	 * @return
	 * @throws ParseException
	 */
	public static Date getFormatDate(String dateStr) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.parse(dateStr);
	}
	
	/**
	 * 
	 * compileTime
	 *      decription : 比较指定时间是否在某一段时间内
	 * @param time
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static boolean compileTime(Date time,Date startTime,Date endTime){
		// 当需要比较的时间为空的情况
		if(time == null) {
			if(startTime !=null  || endTime != null) {
				// 当开始时间或者结束时间不为空的情况
				return false;
			}else {
				// 当开始时间和结束时间和需要比较的时间都为空的情况
				return true;
			}
		}
		// 当开始时间不为空的情况
		if(startTime != null) {
			// 当需要比较的时间小于开始时间时的情况
			if(time.getTime() < startTime.getTime()) {
				return false;
			}
		}
		// 当结束时间不为空的情况
		if(endTime != null) {
			// 当需要比较的时间大于结束时间时的情况
			if(time.getTime() > endTime.getTime()) {
				return false;
			}
		}
		return true;
	}
}
