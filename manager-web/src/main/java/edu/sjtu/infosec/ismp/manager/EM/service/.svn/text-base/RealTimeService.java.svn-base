package edu.sjtu.infosec.ismp.manager.EM.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.manager.rmi.event.Ilnvoker;
import org.infosec.ismp.manager.rmi.event.IEventReceive;
import org.infosec.ismp.manager.rmi.event.modle.Eventmoni;

import edu.sjtu.infosec.ismp.manager.EM.dao.IEventGetTopoDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.IEventmoniDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.IEventrealdispDao;

/**
 * @author wudengke
 * @version 创建时间：2009-6-16 下午06:43:48
 * 用于接收传入的参数
 */
public class RealTimeService implements Ilnvoker {
	//IOC注入
	private IEventReceive serviceClient;
	
	public void setServiceClient(IEventReceive serviceClient) {
		this.serviceClient = serviceClient;
	}
	
	//IOC注入
	private IEventGetTopoDao eventGetTopoDao;	

	public void setEventGetTopoDao(IEventGetTopoDao eventGetTopo) {
		this.eventGetTopoDao = eventGetTopo;
	}
	
	//IOC注入
	private IEventrealdispDao  eventrealdispDao;

	public void setEventrealdispDao(IEventrealdispDao eventrealdispDao) {
			this.eventrealdispDao = eventrealdispDao;
		}
	
	//IOC注入
	private IEventmoniDao eventmoniDao;

	public void setEventmoniDao(IEventmoniDao eventmoniDao) {
		this.eventmoniDao = eventmoniDao;
	}

	public List<Object> getDates(){
		return serviceClient.getDates();
	}

	public List<Object> initRealTimeList(String value, Integer bureauId) {
//		List<Object> l = new ArrayList<Object>();
//		Eventmoni em = new Eventmoni();
//		em.setFaciIp("192.168.9.119");
//		em.setDomain("3");
//		em.setCurrValue(50);
//		l.add(em);
//		
//		System.out.println(em);
//		return l;
		return eventmoniDao.queryRealTimeList(value,bureauId);
	}


	public List<Object> StatisticsDomain(Timestamp starttime,Timestamp endtime, Integer bureauId) {
			if (starttime!=null && endtime!=null) {
				return eventGetTopoDao.StatisticsDomain(starttime, endtime,bureauId);
				}
			return null;
		}


	public List<Object> staticticsEventType(Timestamp starttime,Timestamp endtime, Integer bureauId) {
		if (starttime!=null && endtime!=null) {
			return eventrealdispDao.staticticsEventType(starttime, endtime,bureauId);
			}
		return null;
	}


	public List<Object> staticticsSafety(Timestamp starttime,Timestamp endtime, Integer bureauId) {
		if (starttime!=null && endtime!=null) {
			return eventrealdispDao.staticticsSafety(starttime, endtime, bureauId);
		}
		return null;
	}

}
