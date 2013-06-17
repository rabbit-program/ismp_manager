package org.infosec.ismp.applet.manager.task;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.utilities.ChangeModelUtil;
import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.applet.manager.utilities.TopoConst;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoManagerService;

public class SaveDomainSensorTask extends SwingWorker<Void,Object>{
	List<NodeModel> nodes;
	public SaveDomainSensorTask(List<NodeModel> nodes) {
		if(nodes == null || nodes.size() == 0) {
			return;
		}
		this.nodes = nodes;
	}
	@Override
	protected Void doInBackground() throws Exception {
		TopoManagerService severice = ServiceUtil.newInstance().getTopoManagerDeviceService();
		List<DeviceEntity> devices = new ArrayList<DeviceEntity>();
		for(NodeModel node:nodes) {
			NodeEntity nodeEntity = new NodeEntity();
			DeviceEntity d = new DeviceEntity();
			ChangeModelUtil.changeModel(nodeEntity, node);
			d.setNode(nodeEntity);
			d.setSensor(node.getSensor());
			devices.add(d);
		}
		severice.allotSensorDomain(devices);
		return null;
	}
	
	 protected void done() {
		 try {
			 get();
			 TopoConst.BOX.addElements(nodes);
			} catch (Exception e) {
				 JOptionPane.showMessageDialog(null,"PC设备分配域失败！" , "错误", JOptionPane.ERROR_MESSAGE);
				 e.printStackTrace();
			}
	 }
	
}
