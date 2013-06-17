package org.infosec.ismp.applet.manager.task;


import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.model.LinkModel;
import org.infosec.ismp.applet.manager.utilities.ChangeModelUtil;
import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.applet.manager.utilities.TopoConst;
import org.infosec.ismp.manager.rmi.tm.manager.model.LinkEntity;

/**
 * 去后台数据库添加Or 更新记录。
 * @author snail
 *
 */
public class DeleteLinkTask extends SwingWorker<Void, Object>{
	private LinkModel link;
	public DeleteLinkTask(LinkModel link) {
		if(link == null) return;
		this.link = link;
	}
	@Override
	protected Void doInBackground() throws Exception {
		LinkEntity linkEntity = new LinkEntity();
		ChangeModelUtil.changeLinkModel(linkEntity, link);
		ServiceUtil.newInstance().getWebDeviceService().deleteLink(linkEntity);
		return null;
	}
	
	 protected void done() {
		 try {
			get();
			TopoConst.BOX.removeElement(link);
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"数据库删除连接失败！" , "删除错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
	 }
}
