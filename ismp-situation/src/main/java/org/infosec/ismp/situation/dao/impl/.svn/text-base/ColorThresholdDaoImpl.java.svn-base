package org.infosec.ismp.situation.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.situation.common.BaseDaoHibernate;
import org.infosec.ismp.situation.dao.ColorThresholdDao;
import org.infosec.ismp.situation.model.ColorThreshold;

public class ColorThresholdDaoImpl extends BaseDaoHibernate implements ColorThresholdDao{
	/**
	 * 获取绿，黄，红所对应的阈值
	 * @param id
	 */
	public Map<String, Integer> get() {
		
		Map<String, Integer> res = new HashMap<String, Integer>();
		List rows = this.getHibernateTemplate().find("from ColorThreshold");
		for (Iterator iterator = rows.iterator(); iterator.hasNext();) {
			ColorThreshold colorthreshold = (ColorThreshold) iterator.next();
			 String color = colorthreshold.getColor();
			 Integer value = colorthreshold.getValue();
			 res.put(color, value);
		}
//		Iterator it = rows.iterator();   
//		while(it.hasNext()) {
//		    Map map = (Map) it.next();  
//		    String color = (String) map.get("color");
//		    Integer value = (Integer) map.get("value");
//            res.put(color, value);
//		}  
		return res;
	}
}
