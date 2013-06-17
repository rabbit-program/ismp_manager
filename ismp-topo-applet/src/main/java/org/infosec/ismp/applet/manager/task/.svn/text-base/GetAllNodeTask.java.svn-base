package org.infosec.ismp.applet.manager.task;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.model.DomainModel;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.utilities.ChangeModelUtil;
import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.applet.manager.utilities.TopoConst;
import org.infosec.ismp.applet.manager.utilities.TypeUtil;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceEntity;

public class GetAllNodeTask extends SwingWorker<List<DeviceEntity>,Object>{

	@Override
	protected List<DeviceEntity> doInBackground() throws Exception {
		return ServiceUtil.newInstance().getWebDeviceService().getDeviceAll();
	}
	
	 protected void done() {
		 try {
			 	List<DeviceEntity> devices = get();
			 	for(DeviceEntity device:devices) {
			 		
			 		if(device.getNode().getDomain() != null) {
			 			//处理云图
			 			DomainModel domain = new DomainModel();
			 			domain = ChangeModelUtil.changeDomainModel(domain, device.getNode());
			 			TopoConst.registerID(device.getNode().getNodeId(), domain.getID().toString());
			 			TopoConst.registerID(TopoConst.DOMAIN_ID+domain.getId(), domain.getID().toString());
				 		TopoConst.BOX.addElement(domain);
			 		} else {
			 			NodeModel node = null;
			 			String typeEnglish = "";
			 			if(device.getNode() != null && device.getNode().getType()!=null 
			 					&& device.getNode().getType().getEnglishTag() != null) {
			 				typeEnglish = device.getNode().getType().getEnglishTag();
			 			}
			 			node = TypeUtil.getType(typeEnglish);
			 			ChangeModelUtil.changeModel(node, device);
				 		TopoConst.registerID(device.getNode().getNodeId(), node.getID().toString());
				 		if(node.getIsVisible() != null && node.getIsVisible() == 1 && node.getType() != null && node.getParentDomain() != null) {
				 			TopoConst.BOX.addElement(node);
				 		}
			 		}
			 		
			 	}
			 	new GetAllLinkTask().execute();	
			} catch (Exception e) {
				 JOptionPane.showMessageDialog(null,"获取设备失败！" , "错误", JOptionPane.ERROR_MESSAGE);
				 e.printStackTrace();
			}
	 }

}
