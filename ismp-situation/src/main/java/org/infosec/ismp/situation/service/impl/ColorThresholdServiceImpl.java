package org.infosec.ismp.situation.service.impl;

import org.infosec.ismp.situation.dao.ColorThresholdDao;
import org.infosec.ismp.situation.service.ColorThresholdService;

public class ColorThresholdServiceImpl implements ColorThresholdService {
	
	private ColorThresholdDao colorThresholdDao;
	
	public ColorThresholdDao getColorThresholdDao() {
		return colorThresholdDao;
	}

	public void setColorThresholdDao(ColorThresholdDao colorThresholdDao) {
		this.colorThresholdDao = colorThresholdDao;
	}

//	public List getColorThresholdList() {
//		return this.colorThresholdDao.getColorThresholdList();
//	}
	
//	====================================================
	
	

}
