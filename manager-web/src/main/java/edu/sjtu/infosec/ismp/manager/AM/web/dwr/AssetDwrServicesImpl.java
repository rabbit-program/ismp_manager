package edu.sjtu.infosec.ismp.manager.AM.web.dwr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceModelEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.TradeMarkEntity;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;

import edu.sjtu.infosec.ismp.manager.LM.pfLog.service.SystemLogService;

public class AssetDwrServicesImpl implements AssetDwrServices {
	private TopoWebService topoWebService;
	
	public void setTopoWebService(TopoWebService topoWebService) {
		this.topoWebService = topoWebService;
	}

	private SystemLogService systemlogService;
	
	public void setSystemlogService(SystemLogService systemlogService) {
		this.systemlogService = systemlogService;
	}
	
	public List<DeviceModelEntity> selectModels(String ename) throws Exception {
//		StringBuffer enNames = new StringBuffer();
		Map<TradeMarkEntity,List<DeviceModelEntity>> map = topoWebService.getModelsByTradeMark();
		 List<DeviceModelEntity> list = new ArrayList<DeviceModelEntity>();
		Set<TradeMarkEntity> sets = map.keySet();
		Iterator<TradeMarkEntity> it = sets.iterator();
		while(it.hasNext()){
			TradeMarkEntity tme = it.next();
			if(tme.getMarkName().equals(ename)){
				list = map.get(tme);
//				continue;
				break;
			}
		}
		return list;
//		for(Map.Entry<TradeMarkEntity,List<DeviceModelEntity>> m :map.entrySet()){
//			TradeMarkEntity tmk = m.getKey();
//			if(tmk.getMarkId()==Integer.parseInt(ename)){
//				System.out.println("--------"+((List)m.getKey()).size());
//				for(DeviceModelEntity dme : (List<DeviceModelEntity>)m.getValue()){
//					list.add(dme.getName());
//				} 
//			}
//			for(DeviceModelEntity dme : (List<DeviceModelEntity>)m.getValue()){
//				list.add(dme.getName());
//			} 
//			System.out.println("--------"+((List)m.getValue()).size());
//		}
//		
//		return list;
	}

}
