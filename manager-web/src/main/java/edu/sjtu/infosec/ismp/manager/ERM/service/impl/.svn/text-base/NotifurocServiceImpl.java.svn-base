/**
 * NotifurocService.java
 * edu.sjtu.infosec.ismp.manager.service.resp.impl
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2009-6-16 		xpeiyuan
 *
 * Copyright (c) 2009, TNT All Rights Reserved.
*/

package edu.sjtu.infosec.ismp.manager.ERM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.ERM.dao.ContinotifyprocDao;
import edu.sjtu.infosec.ismp.manager.ERM.model.ContiNotifyProc;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.ERM.service.NotifyrocService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * ClassName:NotifurocService
 * @author   xpeiyuan
 * @version  
 * @since    Ver 1.1
 * @Date	 2009-6-16		下午04:36:12
 *
 * @see 	 
 * @deprecated 
 */
public class NotifurocServiceImpl implements NotifyrocService {
	
	private ContinotifyprocDao continotifyprocDao;

	public void setContinotifyprocDao(ContinotifyprocDao vcontinotifyprocDao) {
		this.continotifyprocDao = vcontinotifyprocDao;
	}

	public void delete(ContiNotifyProc persistentInstance) {

		continotifyprocDao.delete(persistentInstance);

	}


	public void save(ContiNotifyProc continotifyproc) {
		
		
		continotifyprocDao.save(continotifyproc);
	}

	public void update(ContiNotifyProc continotifyproc) {
		
		continotifyprocDao.update(continotifyproc);
		
	}


	public List<ContiNotifyProc> findbyid(int startResult,int maxResult,int id) {
		return continotifyprocDao.findbyid(startResult,maxResult,id);
	}

	public RespInfoBO findRespBoById(String id) {
		// TODO Auto-generated method stub
		return continotifyprocDao.findRespBoById(id);
	}

	public List<ContiNotifyProc> findByRespInfo(RespInfoBO info) {
		return continotifyprocDao.findByRespInfo(info);
	}

	public void deleteNotifyByRespInfo(RespInfoBO resp) {
		continotifyprocDao.deleteNotifyByRespInfo(resp);
	}

	public int getCount(String respid) {
		return continotifyprocDao.getCount(respid);
	}

}

