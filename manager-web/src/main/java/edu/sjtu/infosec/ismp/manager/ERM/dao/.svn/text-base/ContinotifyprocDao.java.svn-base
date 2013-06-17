/**
 * ContinotifyprocDao.java
 * edu.sjtu.infosec.ismp.manager.dao.resp
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2009-6-15		mahonglei
 *
 * Copyright (c) 2009, TNT All Rights Reserved.
*/

package edu.sjtu.infosec.ismp.manager.ERM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.ERM.model.ContiNotifyProc;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;


/**
 * ClassName:ContinotifyprocDao
 * Function: TODO ADD FUNCTION
 * 应急响应通知过程DAO接口
 *
 * @author   mahonglei
 * @version  
 * @since    Ver 1.1
 * @Date	 2009-6-15		
 *
 * @see 	 
 * @deprecated 
 */
public interface ContinotifyprocDao {
       
      /**
       * save:新添加一个对象
       * @param  @param transientInstance    
       * @return void    
       * @throws 
       * @since  CodingExample　Ver 1.1
       */
	  void save(ContiNotifyProc transientInstance);
      
	  /**
	   * delete:删除一个对象
	   * @param  @param persistentInstance    
	   * @return void    
	   * @throws 
	   * @since  CodingExample　Ver 1.1
	   */
	  void delete(ContiNotifyProc persistentInstance);
      
	  /**
	   * findById:根据ID查询
	   * @param  @param id
	   * @param  @return    
	   * @return List    
	   * @throws 
	   * @since  CodingExample　Ver 1.1
	   */
	  public List<ContiNotifyProc> findbyid(int startResult,int maxResult,int id);
	  
      /**
       * findByProperty:根据列名和对应的值查询
       * @param  @param propertyName
       * @param  @param value
       * @param  @return    
       * @return List    
       * @throws 
       * @since  CodingExample　Ver 1.1
       */
	  List findByProperty(String propertyName, Object value);
      
	  /**
	   * findAll:查询对象
	   * @param  @return    
	   * @return List    
	   * @throws 
	   * @since  CodingExample　Ver 1.1
	   */
	  List findByPageDao(final Integer projid,final Page page);
	  
	  int findCountDao(final Integer projid);
	   /**
	    * updateresp:更新联系人信息
	    * @param  @param respbo    
	    * @return void    
	    * @throws 
	    * @since  CodingExample　Ver 1.1
	    */
	   void update(ContiNotifyProc continotifyproc);

	   public RespInfoBO findRespBoById(String id);
	   public List<ContiNotifyProc> findByRespInfo(RespInfoBO info);
	   
	   void deleteNotifyByRespInfo(RespInfoBO resp);
	   
	   public int getCount(String respid);
}

