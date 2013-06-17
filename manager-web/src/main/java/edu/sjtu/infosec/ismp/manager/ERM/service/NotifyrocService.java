/**
 * NotifyrocService.java
 * edu.sjtu.infosec.ismp.manager.service.resp
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2009-6-16 		xpeiyuan
 *
 * Copyright (c) 2009, TNT All Rights Reserved.
*/

package edu.sjtu.infosec.ismp.manager.ERM.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.ERM.model.ContiNotifyProc;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;



/**
 * ClassName:NotifyrocService
 * @author   xpeiyuan
 * @version  
 * @since    Ver 1.1
 * @Date	 2009-6-16		下午04:26:59
 *
 * @see 	 
 * @deprecated 
 */
public interface NotifyrocService {
   
	/**
	 * save:保存一个新的应急通知规程对象
	 * @param      设定文件
	 * @return void    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	 void save(ContiNotifyProc continotifyproc);
	 
	 /**
	  * saveorupdate:更新或添加一个通知规程对象
	  * @param      设定文件
	  * @return void    DOM对象
	  * @throws 
	  * @since  CodingExample　Ver 1.1
	  */
	 void update(ContiNotifyProc notify);
	 
	 /**
	  * findbyid:根据ID查找通知规程对象
	  * @param  @return    设定文件
	  * @return List    DOM对象
	  * @throws 
	  * @since  CodingExample　Ver 1.1
	  */
	 List<ContiNotifyProc> findbyid(int startResult,int maxResult,int id);
	 
	 /**
	  * delete:删除通知规程对象对象
	  * @param      设定文件
	  * @return void    DOM对象
	  * @throws 
	  * @since  CodingExample　Ver 1.1
	  */
	 void delete(ContiNotifyProc continotifyproc);
	 
	 /**
	  * findall:查询全部通知规程对象
	  * @param  @return    设定文件
	  * @return List    DOM对象
	  * @throws 
	  * @since  CodingExample　Ver 1.1
	  */
	 
	 RespInfoBO findRespBoById(String id);
	 
	 List<ContiNotifyProc> findByRespInfo(RespInfoBO info);
	 
	 void deleteNotifyByRespInfo(RespInfoBO resp);
	 
	 int getCount(String respid);
}

