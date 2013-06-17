package edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog.impl;

import java.util.List;

import org.infosec.ismp.manager.rmi.snmpTrap.SnmpTrapController;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;

import edu.sjtu.infosec.ismp.manager.SYSM.config.dao.lm.dLog.SnmpTrapSourceDao;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SnmpTrapSource;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SnmpTrapSourceType;
import edu.sjtu.infosec.ismp.manager.SYSM.config.service.lm.dLog.SnmpTrapSourceService;
import edu.sjtu.infosec.ismp.security.Domain;

public class SnmpTrapSourceServiceImpl implements SnmpTrapSourceService {
	
	private SnmpTrapSourceDao snmpTrapSourceDao;
	private SnmpTrapController snmpTrapController;
	
	public boolean addSnmpTrapSource(SnmpTrapSource snmpTrapSource)
			throws Exception {
		Integer flox = snmpTrapSourceDao.addSnmpTrapSource(snmpTrapSource);
		
		if(flox >= 1){
			if(snmpTrapSource.getStartCollectSwitch()){
				try{
					snmpTrapController.addSnmpTrapSource(snmpTrapSource.getDomain().getId().toString(), snmpTrapSource.getLogSourceseQuence(), snmpTrapSource.getSourceType().getHandleOrParserType().getHandleType(), snmpTrapSource.getDeviceIP());
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

	public boolean delSnmpTrapSource(SnmpTrapSource snmpTrapSource,final TopoWebService topoWebService)
			throws Exception {
	
		if(snmpTrapSource.getStartCollectSwitch()){
			try{
				snmpTrapSource = snmpTrapSourceDao.loadObject(snmpTrapSource.getId().toString());
				snmpTrapController.removeSnmpTrapSource( snmpTrapSource.getLogSourceseQuence());

				NodeEntity node = new NodeEntity();
				node.setNodeId(snmpTrapSource.getLogSourceseQuence());
				
				topoWebService.deleteNode(node);
				
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		snmpTrapSourceDao.delSnmpTrapSource(snmpTrapSource);
		return true;
	}

	public List<SnmpTrapSource> getAllSnmpTrapSource(
			SnmpTrapSource snmpTrapSource, List<Domain> domain, Integer pageNo,
			Integer pageRowNum) throws Exception {
		return snmpTrapSourceDao.getAllSnmpTrapSource(snmpTrapSource, domain, pageNo, pageRowNum);
	}

	public Integer getAllSnmpTrapSourceCount(SnmpTrapSource snmpTrapSource,
			List<Domain> domain) throws Exception {
		return snmpTrapSourceDao.getAllSnmpTrapSourceCount(snmpTrapSource, domain);
	}

	public List<SnmpTrapSourceType> getAllSnmpTrapSourceType() throws Exception {
		return snmpTrapSourceDao.getAllSnmpTrapSourceType();
	}

	public SnmpTrapSource loadObject(String id) throws Exception {
		return snmpTrapSourceDao.loadObject(id);
	}

	public boolean updateSnmpTrapSource(SnmpTrapSource snmpTrapSource)
			throws Exception {
		Integer flox = snmpTrapSourceDao.updateSnmpTrapSource(snmpTrapSource);
		
		if(flox >= 1){
			
			if(snmpTrapSource.getStartCollectSwitch()){
				try{
					snmpTrapSource = snmpTrapSourceDao.loadObject(snmpTrapSource.getId().toString());
					
					snmpTrapController.addSnmpTrapSource(snmpTrapSource.getDomain().getId().toString(), snmpTrapSource.getLogSourceseQuence(), snmpTrapSource.getSourceType().getHandleOrParserType().getHandleType(), snmpTrapSource.getDeviceIP());
				}catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}else{
				snmpTrapSource = snmpTrapSourceDao.loadObject(snmpTrapSource.getId().toString());
				snmpTrapController.removeSnmpTrapSource( snmpTrapSource.getLogSourceseQuence());
			}
		}else{
			return false;
		}
		return true;
	}

	public SnmpTrapSourceDao getSnmpTrapSourceDao() {
		return snmpTrapSourceDao;
	}

	public void setSnmpTrapSourceDao(SnmpTrapSourceDao snmpTrapSourceDao) {
		this.snmpTrapSourceDao = snmpTrapSourceDao;
	}

	public SnmpTrapController getSnmpTrapController() {
		return snmpTrapController;
	}

	public void setSnmpTrapController(SnmpTrapController snmpTrapController) {
		this.snmpTrapController = snmpTrapController;
	}

}
