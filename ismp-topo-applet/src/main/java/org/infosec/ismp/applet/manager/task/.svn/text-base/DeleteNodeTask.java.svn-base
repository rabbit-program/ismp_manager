package org.infosec.ismp.applet.manager.task;


import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.utilities.ChangeModelUtil;
import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.applet.manager.utilities.TopoConst;

/**
 * 去后台数据库添加Or 更新记录。
 * @author snail
 *
 */
public class DeleteNodeTask extends SwingWorker<Void, Object>{
	private NodeModel node;
	public DeleteNodeTask(NodeModel node) {
		if(node == null) return;
		this.node = node;
	}
	@Override
	protected Void doInBackground() throws Exception {
//		NodeEntity nodeEntity = new NodeEntity();
//		ChangeModelUtil.changeModel(nodeEntity, node);
//		ServiceUtil.newInstance().getWebDeviceService().deleteNode(nodeEntity);
		ServiceUtil.newInstance().getTopoManagerDeviceService().deleteDevice(ChangeModelUtil.changeDeviceEntity(node));
		return null;
	}
	
	 protected void done() {
		 try {
			get();
			TopoConst.BOX.removeElement(node);
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"数据库删除节点失败！" , "删除错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
	 }
}
