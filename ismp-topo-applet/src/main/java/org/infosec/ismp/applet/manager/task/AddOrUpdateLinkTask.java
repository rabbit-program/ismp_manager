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
 * @author 肖高峰
 *
 */
public class AddOrUpdateLinkTask extends SwingWorker<LinkEntity, Object>{
	private LinkModel link;
	public AddOrUpdateLinkTask(LinkModel link) {
		if(link == null) return;
		this.link = link;
	}
	@Override
	protected LinkEntity doInBackground() throws Exception {
		LinkEntity linkEntity = new LinkEntity();
		ChangeModelUtil.changeLinkModel(linkEntity, link);
		return ServiceUtil.newInstance().getWebDeviceService().saveOrUpdateLink(linkEntity);
	}
	
	 protected void done() {
		 try {
			LinkEntity linkEntity = get();
			String databaseId = linkEntity.getLinkId().toString();
			if(TopoConst.getTopoID(databaseId) == null) {
				ChangeModelUtil.changeLinkModel(link,linkEntity);
				TopoConst.registerID(databaseId, link.getID().toString());
			}
		} catch (Exception e) {
			 TopoConst.BOX.removeElement(link);
			 JOptionPane.showMessageDialog(null,"数据库保存连接发生错误！" , "保存错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
	 }
}
