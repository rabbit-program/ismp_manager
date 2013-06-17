package edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog.impl;

import java.util.List;

import org.infosec.ismp.manager.rmi.syslog.SyslogController;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;

import edu.sjtu.infosec.ismp.manager.SYSM.config.dao.lm.dLog.SysLogSourceDao;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSource;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSourceType;
import edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog.SysLogSourceService;
import edu.sjtu.infosec.ismp.security.Domain;

public class SysLogSourceServiceImpl implements SysLogSourceService {
	
	private SysLogSourceDao sysLogSourceDao;
	private SyslogController syslogController;
	
	public boolean addSysLogSource(SysLogSource sysLogSource) throws Exception {
		Integer flox = sysLogSourceDao.addSysLogSource(sysLogSource);
		
		if(flox >= 1){
			if(sysLogSource.getStartCollectSwitch()){
				try{
//					System.out.println(sysLogSource.getDomain().getId().toString()+"--"+sysLogSource.getLogSourceseQuence()+"--"+sysLogSource.getSourceType().getHandleOrParserType().getHandleType()+"--"+sysLogSource.getDeviceIP());
					syslogController.addSyslogSource(sysLogSource.getDomain().getId().toString(), sysLogSource.getLogSourceseQuence(), sysLogSource.getSourceType().getHandleOrParserType().getHandleType(), sysLogSource.getDeviceIP());
				}catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		}else{
			return false;
		}
		return true;
	}

	public List<SysLogSource> getAllSysLogSource(SysLogSource sysLogSource,List<Domain> domain,Integer pageNo,Integer pageRowNum) throws Exception {
		return sysLogSourceDao.getAllSysLogSource(sysLogSource, domain, pageNo, pageRowNum);
	}

	public List<SysLogSourceType> getAllSysLogSourceType() throws Exception {
		return sysLogSourceDao.getAllSysLogSourceType();
	}

	public SysLogSourceDao getSysLogSourceDao() {
		return sysLogSourceDao;
	}

	public void setSysLogSourceDao(SysLogSourceDao sysLogSourceDao) {
		this.sysLogSourceDao = sysLogSourceDao;
	}

	public boolean delSysLogSource(SysLogSource sysLogSource,final TopoWebService topoWebService) throws Exception {
		if(sysLogSource.getStartCollectSwitch()){
			try{
				sysLogSource = sysLogSourceDao.loadObject(sysLogSource.getId().toString());
				syslogController.removeSyslogSource( sysLogSource.getLogSourceseQuence());
				
				NodeEntity node = new NodeEntity();
				node.setNodeId(sysLogSource.getLogSourceseQuence());
				
				topoWebService.deleteNode(node);
				
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		sysLogSourceDao.delSysLogSource(sysLogSource);
		
		return true;
	}

	public Integer getAllSysLogSourceCount(SysLogSource sysLogSource,
			List<Domain> domain) throws Exception {
		return sysLogSourceDao.getAllSysLogSourceCount(sysLogSource, domain);
	}

	public boolean updateSysLogSource(SysLogSource sysLogSource)
			throws Exception {
		Integer flox = sysLogSourceDao.updateSysLogSource(sysLogSource);
		if(flox >= 1){
			if(sysLogSource.getStartCollectSwitch()){
				try{
					sysLogSource = sysLogSourceDao.loadObject(sysLogSource.getId().toString());
//					System.out.println(sysLogSource.getDomain().getId().toString()+"--"+sysLogSource.getLogSourceseQuence()+"--"+sysLogSource.getSourceType().getHandleOrParserType().getHandleType()+"--"+sysLogSource.getDeviceIP());
					syslogController.addSyslogSource(sysLogSource.getDomain().getId().toString(), sysLogSource.getLogSourceseQuence(), sysLogSource.getSourceType().getHandleOrParserType().getHandleType(), sysLogSource.getDeviceIP());
				}catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}else{
				sysLogSource = sysLogSourceDao.loadObject(sysLogSource.getId().toString());
				syslogController.removeSyslogSource( sysLogSource.getLogSourceseQuence());
			}
		}else{
			return false;
		}
		return true;
	}

	public SysLogSource loadObject(String id) throws Exception {
		return sysLogSourceDao.loadObject(id);
	}

	public SyslogController getSyslogController() {
		return syslogController;
	}

	public void setSyslogController(SyslogController syslogController) {
		this.syslogController = syslogController;
	}
	
}
