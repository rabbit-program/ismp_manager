package org.infosec.ismp.applet.manager.task;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.model.DomainModel;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.utilities.ChangeModelUtil;
import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.applet.manager.utilities.TopoConst;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;

public class SaveAllTask extends SwingWorker<Object, Object>{
	
	@SuppressWarnings("unchecked")
	@Override
	protected Object doInBackground() throws Exception {
		List elments = TopoConst.BOX.getAllElements();
		List<NodeEntity> nodeEntitys = new ArrayList<NodeEntity>();
		for(Object element:elments) {
			if(element instanceof NodeModel) {
				NodeEntity nodeEntity = new NodeEntity();
				ChangeModelUtil.changeModel(nodeEntity,(NodeModel)element);
				nodeEntitys.add(nodeEntity);
			}else if(element instanceof DomainModel) {
				NodeEntity nodeEntity = ((DomainModel)element).getDatabaseNode();
				nodeEntity.setPointX((int)((DomainModel)element).getX());
				nodeEntity.setPointY((int)((DomainModel)element).getY());
				nodeEntitys.add(nodeEntity);
			}
		}
		return ServiceUtil.newInstance().getWebDeviceService().saveOrUpdateNodes(nodeEntitys);
	}
	
	 protected void done() {
		 try {
			get();
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"保存设备位置错误！" , "错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
	 }
}
