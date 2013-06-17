package edu.sjtu.infosec.ismp.manager.BSAM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.BSAM.dao.ColorThresholdDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.ColorThreshold;
import edu.sjtu.infosec.ismp.manager.BSAM.service.ColorThresholdService;

public class ColorThresholdServiceImpl implements ColorThresholdService {
	
	private ColorThresholdDao colorThresholdDao;
	
	public ColorThresholdDao getColorThresholdDao() {
		return colorThresholdDao;
	}

	public void setColorThresholdDao(ColorThresholdDao colorThresholdDao) {
		this.colorThresholdDao = colorThresholdDao;
	}

	@SuppressWarnings("unchecked")
	public List getColorThresholdList() {
		return colorThresholdDao.getColorThresholdList();
	}

	public ColorThreshold getColorThresholdByColor(String color) {
		return colorThresholdDao.getColorThresholdByColor(color);
	}

	public void saveOrUpdate(ColorThreshold colorThreshold) {
		colorThresholdDao.saveOrUpdate(colorThreshold);
	}
	
//	====================================================
	
	

}
