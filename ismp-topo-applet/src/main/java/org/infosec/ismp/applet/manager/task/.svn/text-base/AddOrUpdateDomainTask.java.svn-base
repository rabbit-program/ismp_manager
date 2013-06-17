package org.infosec.ismp.applet.manager.task;


import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.model.DomainModel;
import org.infosec.ismp.applet.manager.utilities.ChangeModelUtil;
import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.applet.manager.utilities.TopoConst;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;

/**
 * 去后台数据库添加Or 更新记录。
 * @author snail
 *
 */
public class AddOrUpdateDomainTask extends SwingWorker<NodeEntity, Object>{
	private DomainModel domain;
	public AddOrUpdateDomainTask(DomainModel domain) {
		if(domain == null) return;
		this.domain = domain;
	}
	@Override
	protected NodeEntity doInBackground() throws Exception {
		NodeEntity nodeEntity =  domain.getDatabaseNode();
		if(nodeEntity == null) {
			nodeEntity = new NodeEntity();
		}
		return  ServiceUtil.newInstance().getWebDeviceService().saveOrUpdateNode(ChangeModelUtil.changeDomainModel(nodeEntity, domain));
	}
	
	 protected void done() {
		 try {
			NodeEntity nodeEntity =  get();
			ChangeModelUtil.changeDomainModel(domain, nodeEntity);
			String databaseId = domain.getDatabaseNode().getNodeId().toString();
			if(TopoConst.getTopoID(databaseId) == null) {
				TopoConst.BOX.addElement(domain);
				TopoConst.registerID(databaseId, domain.getID().toString());
				TopoConst.registerID(TopoConst.DOMAIN_ID+domain.getId(), domain.getID().toString());
			}
			
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"数据库保存云图发生错误！" , "保存错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
	 }
}
