package edu.sjtu.infosec.ismp.manager.TM.manager.dao;

import org.infosec.ismp.manager.rmi.tm.manager.model.TradeMarkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TradeMarkService {
    private TradeMarkDao entityDao;

     @Autowired(required=true)
	public void setEntityDao(TradeMarkDao entityDao) {
		this.entityDao = entityDao;
	}
     
     @Transactional(readOnly=false)
     public void save(TradeMarkEntity en){
    	 entityDao.save(en);
     }
     
}
