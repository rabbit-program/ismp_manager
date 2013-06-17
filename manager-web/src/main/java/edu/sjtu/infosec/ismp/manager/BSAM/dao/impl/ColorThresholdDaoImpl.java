package edu.sjtu.infosec.ismp.manager.BSAM.dao.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.BaseDaoHibernate;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.ColorThresholdDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.ColorThreshold;

public class ColorThresholdDaoImpl extends BaseDaoHibernate implements ColorThresholdDao{
	
	@SuppressWarnings("unchecked")
	public List getColorThresholdList() {
		StringBuffer hql = new StringBuffer("from ColorThreshold");
		List list = this.getHibernateTemplate().find(hql.toString());
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public ColorThreshold getColorThresholdByColor(String color) {
		ColorThreshold colorThreshold = null;
		List list = getHibernateTemplate().find("from ColorThreshold where color = ?",color);
		if(null != list && list.size() > 0){
			colorThreshold = (ColorThreshold) list.get(0);///取出第一个，避免脏数据报错。
		}
		return colorThreshold;
	}
	
	public void saveOrUpdate(ColorThreshold colorThreshold) {
		getHibernateTemplate().saveOrUpdate(colorThreshold);
	}

}
