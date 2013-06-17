package edu.sjtu.infosec.ismp.manager.TM.manager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AA {
	private TradeMarkService service;

	@Autowired(required=true)
	public void setService(TradeMarkService service) {
		this.service = service;
	}

}
