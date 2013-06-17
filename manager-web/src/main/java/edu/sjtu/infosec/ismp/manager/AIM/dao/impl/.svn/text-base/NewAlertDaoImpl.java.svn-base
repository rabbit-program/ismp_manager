package edu.sjtu.infosec.ismp.manager.AIM.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;

import edu.sjtu.infosec.ismp.manager.AIM.dao.NewAlertDao;

public class NewAlertDaoImpl implements NewAlertDao{

	public Map<String, List<AlertInfoBO>> getNewAlert(Long maxId) {
		LinkedList list = new LinkedList();
		AlertInfoBO alert = new AlertInfoBO();
		alert.setId(1);
		alert.setAlertReason("ddd");
		alert.setAlertSubType("IDS事件");
		alert.setAlertType("安全事件");
		alert.setAlertSubType("防火墙事件");
//		alert.setFusioin("dd");
//		alert.setType("d");
		alert.setIfnew(1);
		alert.setRawContent("大大");
		alert.setNodeid(1l);
		alert.setLevel(2);
		list.add(alert);
		Map<String,List<AlertInfoBO>> map = new HashMap();
		map.put("1", list);
		if(maxId==0){
			return map;
		}
		return map;
	}

}
