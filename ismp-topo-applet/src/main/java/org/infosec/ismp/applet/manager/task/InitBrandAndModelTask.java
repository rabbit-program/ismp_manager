package org.infosec.ismp.applet.manager.task;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.applet.manager.utilities.TopoConst;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceModelEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.TradeMarkEntity;

public class InitBrandAndModelTask extends SwingWorker<Map<TradeMarkEntity, List<DeviceModelEntity>>,Object>{

	@Override
	protected Map<TradeMarkEntity, List<DeviceModelEntity>> doInBackground()
			throws Exception {
		return ServiceUtil.newInstance().getWebDeviceService().getModelsByTradeMark();
	}

		
	 protected void done() {
		 try {
			 Map<TradeMarkEntity, List<DeviceModelEntity>> map = get();
			 Set<TradeMarkEntity> set = map.keySet();
			 TopoConst.TRADE_MARKS = new TradeMarkEntity[set.size()];
			 int j = 0;
			 for(TradeMarkEntity key : set) {
				 List<DeviceModelEntity> list = map.get(key);
				 if(list == null) continue;
				 TopoConst.TRADE_MARKS[j++] = key;
				 DeviceModelEntity[] temp = new DeviceModelEntity[list.size()];
				 for(int i = 0;i<list.size();i++) {
					 temp[i] = list.get(i);
				 }
				 TopoConst.MODELS_WITH_BRAND.put(key, temp);
			 }
			 
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"初始化品牌、类型发生错误！" , "错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
	 }
}
