package org.infosec.ismp.applet.manager.task;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.applet.manager.utilities.TypeUtil;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeTypeEntity;

public class GetAllTypeTask extends SwingWorker<List<NodeTypeEntity>,Object>{

	@Override
	protected List<NodeTypeEntity> doInBackground() throws Exception {
		return ServiceUtil.newInstance().getWebDeviceService().getNodeTypeAll();
	}
	
	 protected void done() {
		 try {
			 	TypeUtil.putType(get());
			 	new GetAllNodeTask().execute();
			} catch (Exception e) {
				 JOptionPane.showMessageDialog(null,"获取设备类型失败！" , "错误", JOptionPane.ERROR_MESSAGE);
				 e.printStackTrace();
			}
	 }
	 
}
