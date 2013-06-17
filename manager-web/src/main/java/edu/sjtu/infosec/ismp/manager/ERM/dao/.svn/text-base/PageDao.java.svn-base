/**
 * PageDao.java
 * edu.sjtu.infosec.ismp.manager.resp.dao.impl
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2009-6-30 		xpeiyuan
 *
 * Copyright (c) 2009, TNT All Rights Reserved.
 */

package edu.sjtu.infosec.ismp.manager.ERM.dao;

import java.util.List;

//import edu.sjtu.infosec.ismp.manager.ERM.web.form.RespIndexForm;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * ClassName:PageDao
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   xpeiyuan
 * @version  
 * @since    Ver 1.1
 * @Date	 2009-6-30		下午02:13:44
 *
 * @see 	 
 * @deprecated 
 */
public interface PageDao {

	void init(int start, String tableName);
	
    void initPage(int pno,String userToManager);

	int getRowCount();

	Page getPage();
	
//	List getShowPage(String s,RespIndexForm respform);

	void setPreOrNextBoolean();

	void setCurrentPage();

	void setPrePage();

	void setNextPage();

	void setTotalPage();

	void setRowCount();

	int getStartIndex();
	
	/*
	 * 根据id得到对应的委办局名称
	 */
	public String getDepaetmentNames(String id);

}
