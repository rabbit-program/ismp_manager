package org.infosec.ismp.applet.manager.task;


import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.model.DomainModel;
import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.applet.manager.utilities.TopoConst;

/**
 * 去后台数据库添加Or 更新记录。
 * @author snail
 *
 */
public class DeleteDomainTask extends SwingWorker<Void, Object>{
	private DomainModel domain;
	public DeleteDomainTask(DomainModel domain) {
		if(domain == null) return;
		this.domain = domain;
	}
	@Override
	protected Void doInBackground() throws Exception {
		ServiceUtil.newInstance().getWebDeviceService().deleteNode(domain.getDatabaseNode());
		return null;
	}
	
	 protected void done() {
		 try {
			get();
			TopoConst.BOX.removeElement(domain);
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null,"数据库删除云图失败！" , "删除错误", JOptionPane.ERROR_MESSAGE);
			 e.printStackTrace();
		}
	 }
}
