package edu.sjtu.infosec.ismp.manager.EM.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.manager.rmi.tm.manager.model.DomainEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;

import edu.sjtu.infosec.ismp.manager.EM.comm.Page;
import edu.sjtu.infosec.ismp.manager.EM.dao.IEventGetTopoDao;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition.EventGetTopoCondition;
import edu.sjtu.infosec.ismp.manager.EM.dao.queryResult.EventGetTopoResult;
import edu.sjtu.infosec.ismp.manager.EM.service.IGetTopoInfo;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 从拓朴数据库取数据
 * 
 * @author wudengke 2009-6-29
 * 
 */
public class GetTopoInfo implements IGetTopoInfo {

	private IEventGetTopoDao eventGetTopoDao;

	public void setEventGetTopoDao(IEventGetTopoDao eventGetTopo) {
		this.eventGetTopoDao = eventGetTopo;
	}
	
	/**
	 * 获取TOPO设备IP和MAC地址和设备名
	 * 
	 * @return
	 */
	public List<Object> getTopoInfo() {
		return eventGetTopoDao.getTopoInfo();
	}
	
	/**
	 * 分页获取TOPO设备IP和MAC地址和设备名
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EventGetTopoResult getTopoInfo(Page page, Integer[] bureauIds){
		EventGetTopoCondition condition = new EventGetTopoCondition();
		EventGetTopoResult re = new EventGetTopoResult();
		if (page!=null && page.getCurrentPage()>0 && page.getEveryPage()>0 && bureauIds != null && bureauIds.length>0) {
			condition.setPage(page);	
			condition.setBureauId(bureauIds);
			EventGetTopoResult egt =  eventGetTopoDao.getTopoInfo(condition);
			List<Object[]> list = egt.getDatas();
			page = egt.getPage();
			List<Domain> mbs = SecurityUserHolder.getCurrentUser().getDomainList();
			List<Object[]> res = new ArrayList<Object[]>();
			if( list != null && list.size()>0 && mbs !=null && mbs.size()>0){
				for (int i=0;i<list.size();i++) {
					Object[] oo = (Object[]) list.get(i);
					for (int j=0;j<mbs.size();j++) {
						Domain mb = mbs.get(j);
						if ((((DomainEntity)oo[3]).getId()).equals(mb.getId())){
							Object[] aa = new Object[5];
							aa[0] = oo[0];
							aa[1] = oo[1];
							aa[2] = oo[2];
							aa[3] = oo[3];
							aa[4] = mb.getDomainName();
							res.add(aa);
						}
					}
				}
				re.setPage(page);
				re.setDatas(res);
				return re;
			}
			
		}
		return null;
	}

	/**
	 * 获取域事件总量
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	public List<Object> StatisticsDomain(Timestamp starttime, Timestamp endtime, Integer bureauId) {
		if (starttime!=null && endtime!=null) {
			return eventGetTopoDao.StatisticsDomain(starttime, endtime, bureauId);
		}
		return null;
	}
	
	public NodeEntity queryByIpBureauId(String ip,Integer bureauId) {
		if (ip != null && ip.length()>0 && bureauId != null && bureauId > 0) {
			return eventGetTopoDao.queryByIpBureauId(ip, bureauId);
		}
		return null;
	}

}
