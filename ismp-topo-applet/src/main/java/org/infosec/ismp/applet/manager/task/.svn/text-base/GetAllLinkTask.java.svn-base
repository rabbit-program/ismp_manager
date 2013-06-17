package org.infosec.ismp.applet.manager.task;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.model.LinkModel;
import org.infosec.ismp.applet.manager.utilities.ChangeModelUtil;
import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.applet.manager.utilities.TopoConst;
import org.infosec.ismp.manager.rmi.tm.manager.model.LinkEntity;

public class GetAllLinkTask extends SwingWorker<List<LinkEntity>,Object>{

	@Override
	protected List<LinkEntity> doInBackground() throws Exception {
		return ServiceUtil.newInstance().getWebDeviceService().getLinkAll();
	}
	
	 protected void done() {
		 try {
			 	List<LinkEntity>  links = get();
			 	for(LinkEntity link : links) {
			 		LinkModel model = new LinkModel();
			 		ChangeModelUtil.changeLinkModel(model, link);
			 		TopoConst.registerID(link.getLinkId()+"", model.getID().toString());
			 		TopoConst.BOX.addElement(model);
			 	}
			 	TopoConst.isInited = true;
			} catch (Exception e) {
				 JOptionPane.showMessageDialog(null,"获取连接失败！" , "错误", JOptionPane.ERROR_MESSAGE);
				 e.printStackTrace();
			}
	 }

}
