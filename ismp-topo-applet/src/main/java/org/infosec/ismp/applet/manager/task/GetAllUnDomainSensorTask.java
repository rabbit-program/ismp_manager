package org.infosec.ismp.applet.manager.task;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.infosec.ismp.applet.manager.component.dialog.SensorAllotDialog;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.model.TopoSensorModel;
import org.infosec.ismp.applet.manager.utilities.ChangeModelUtil;
import org.infosec.ismp.applet.manager.utilities.ServiceUtil;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceEntity;

public class GetAllUnDomainSensorTask extends SwingWorker<List<DeviceEntity>,Object>{
	private SensorAllotDialog sensor = null;
	public GetAllUnDomainSensorTask(SensorAllotDialog sensor) {
		this.sensor = sensor;
	}
	@Override
	protected List<DeviceEntity> doInBackground() throws Exception {
		return ServiceUtil.newInstance().getWebDeviceService().getSensorAllByUnDomain();
	}
	
	 protected void done() {
		 try {
			 List<DeviceEntity> devices = get();
			 if(devices == null || devices.size() == 0) {
				 return;
			 }
			 List<NodeModel> nodes = new ArrayList<NodeModel>();
			 
			 for(DeviceEntity device:devices) {
				 NodeModel node = new TopoSensorModel();
				 nodes.add(ChangeModelUtil.changeModel(node, device));
			 }
			 if(sensor != null) {
				 sensor.setSensorModel(nodes);
			 }
			} catch (Exception e) {
				 JOptionPane.showMessageDialog(null,"获取未分配域PC发生错误！" , "错误", JOptionPane.ERROR_MESSAGE);
				 e.printStackTrace();
			}
	 }

}
