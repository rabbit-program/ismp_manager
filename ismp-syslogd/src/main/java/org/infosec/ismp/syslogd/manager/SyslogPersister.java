package org.infosec.ismp.syslogd.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.infosec.ismp.model.syslog.SyslogEntityDao;
import org.infosec.ismp.model.syslog.SyslogWrapper;
import org.springframework.beans.factory.annotation.Autowired;
//
//@Component
//@Transactional
public class SyslogPersister {
	
	private SyslogEntityDao syslogDao;
	
	
    public void saveSyslsog(SyslogWrapper wrapper){
//    	SyslogEntity entity = new SyslogEntity();
//    	Syslog syslog = wrapper.getSyslog();
//    	
//    	entity.setDomain(wrapper.getDomain());
//    	entity.setMsg(syslog.getMsg());
//    	entity.setHostname(syslog.getHostname());
//    	entity.setFacility(syslog.getFacility());
//    	entity.setSeverity(syslog.getSeverity());
//    	String createTimeStr = syslog.getTimestamp();
//    	
//    	System.out.println("create Time is : "+createTimeStr);
//    	
//    	entity.setCreateTime(getTime(createTimeStr));
//    	
//    	syslogDao.save(entity);
    }

    @Autowired(required=true)
	public void setSyslogDao(SyslogEntityDao syslogDao) {
		this.syslogDao = syslogDao;
	}
	
	public Date getTime(String time){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		SimpleDateFormat format = new SimpleDateFormat("yyyy MMM dd HH:mm:ss",Locale.ENGLISH);
		String timeStr = year+" "+time;
		Date date = null;
		try {
			date = format.parse(timeStr);
		} catch (ParseException e) {
			date = new Date();
		}
		return date;
	}
	
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		int year = calendar.get(Calendar.YEAR);
		SimpleDateFormat format = new SimpleDateFormat("yyyy MMM dd HH:mm:ss",Locale.ENGLISH);
		String timeStr = year+"_Oct 18 16:32:33";
		System.out.println(new Date());
		System.out.println(format.format(new Date()));
		
		Date date = null;
		try {
			date = format.parse(timeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("date is : "+date);
	}

}
