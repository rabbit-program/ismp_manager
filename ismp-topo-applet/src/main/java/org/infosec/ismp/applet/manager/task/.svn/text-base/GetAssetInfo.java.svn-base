package org.infosec.ismp.applet.manager.task;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.manager.rmi.tm.manager.model.AssetDevice;

public class GetAssetInfo extends SwingWorker<AssetDevice,Object>{
	private NodeModel node;
	public GetAssetInfo(NodeModel node) {
		if(node == null) return;
		this.node = node;
	}

	@Override
	protected AssetDevice doInBackground() throws Exception {
		return ServiceUtil.newInstance().getWebDeviceService().getAssetByNodeId(node.getNodeId());
	}
	
	protected void done() {
		try {
			node.setAssetInformation(get());
		}catch(Exception e) {
			 JOptionPane.showMessageDialog(null,"获取资产信息失败！" , "错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
	}
}
