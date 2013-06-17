package org.infosec.ismp.applet.manager.task;


import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.utilities.ChangeModelUtil;
import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.applet.manager.utilities.TopoConst;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceEntity;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;

/**
 * 去后台数据库添加Or 更新记录。
 * @author snail
 *
 */
public class AddOrUpdateNodeTask extends SwingWorker<DeviceEntity, Object>{
	private NodeModel node;
	public AddOrUpdateNodeTask(NodeModel node) {
		if(node == null) return;
		this.node = node;
	}
	@Override
	protected DeviceEntity doInBackground() throws Exception {
		TopoWebService severice = ServiceUtil.newInstance().getWebDeviceService();
		DeviceEntity device = ChangeModelUtil.changeToDeviceModel(node);
		device = severice.saveOrUpdateDevice(device);
		return device;
	}
	
	 protected void done() {
		 try {
			DeviceEntity device = get();
			String databaseId = device.getNode().getNodeId();
			if(TopoConst.getTopoID(databaseId) == null) {
				ChangeModelUtil.changeModel(node, device);
				TopoConst.BOX.addElement(node);
				TopoConst.registerID(databaseId, node.getID().toString());
			}
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"数据库保存节点发生错误！" , "保存错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
		
	 }
}
