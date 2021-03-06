package org.infosec.ismp.applet.manager.component.panel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.infosec.ismp.applet.manager.application.dynamicInfo.DynamicInfo;
import org.infosec.ismp.applet.manager.component.panel.progress.ProcessPanel;
import org.infosec.ismp.applet.manager.component.panel.reflash.OtherNetworkRefreshPanelUI;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.utilities.NullFilter;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceInformation;

import twaver.swing.TableLayout;

/**
 * 普通设备信息面板
 * 
 * @author 肖高峰
 * 
 */
public class OtherNetworkDeviceInfoPanel extends JPanel{
	private NodeModel model;

	private EquipmentPanel equipment;
	private ProcessPanel process;
	private InfoPanel info;
	private boolean flag ;
	private DataRefresh dataRefresh;
	public OtherNetworkDeviceInfoPanel(final NodeModel node) {
		model = node;
		JTabbedPane pane = new JTabbedPane();
		equipment = new EquipmentPanel(false);
		info = new InfoPanel();
		process = new ProcessPanel();
		pane.add("详细信息", equipment);
		pane.add("动态信息", info);
		pane.add("进程管理", process);
		double rows[] = { TableLayout.PREFERRED};
		double cols[] = { TableLayout.FILL };
		TableLayout layout = new TableLayout(cols, rows, 10, 15);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.setLayout(layout);

		this.add(pane, "0,0");
		DynamicInfo.startGetDynamicInfo(node);
		SJTUUtils.showCompoentInFrame(pane,node);
		flag = true;
		
		node.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getPropertyName().equals("CP:"+NodeModel.DEVICE_INFORMATION)) {
					DeviceInformation deviceInfo = (DeviceInformation)evt.getNewValue();
					if(flag) {
						dataRefresh = new DataRefresh(deviceInfo);
						dataRefresh.start();
						flag = false;
					}
					dataRefresh.setDeviceInfo(deviceInfo);
				}
			}
			
		});
	}
	
	/**
	 * 引用数据线程。
	 */
	class DataRefresh extends Thread {
		DeviceInformation deviceInfo = null;
		NullFilter filter;
		public DataRefresh(DeviceInformation info) {
			this.deviceInfo = info;
			filter = new NullFilter(model,deviceInfo);
		}
		public void run() {
			OtherNetworkRefreshPanelUI refresh = new OtherNetworkRefreshPanelUI(filter);
			//----------指定面板的刷新频率
			refresh.refreshDevice(equipment.getDeviceInfoPanel(), 10000);
			refresh.refreshAsset(equipment.getAssetDevicePanel(), 20000);
			refresh.refreshIsActive(model, 1500);
			refresh.refreshCPU(equipment.getInfoViewPanel().getCpuPanel(), 1500);
			refresh.refreshMemory(equipment.getInfoViewPanel().getMemoryPanel(), 1500);
			refresh.refreshNetwork(equipment.getNetworkStatusPanel(), 5000);
			
			refresh.refreshMidMemory(info.getMemoryPanel(), 1500);
			refresh.refreshMidNetwork(info.getNetPortPanel(), 1000);
			refresh.refreshMidCPUs(info.getCpupPanel(), 1000);
		}
		public void setDeviceInfo(DeviceInformation deviceInfo) {
			this.deviceInfo = deviceInfo;
			filter.setInfo(deviceInfo);
		}
	}
	
	
	public EquipmentPanel getEquipment() {
		return equipment;
	}



	public ProcessPanel getProcess() {
		return process;
	}



	public InfoPanel getInfo() {
		return info;
	}



	public NodeModel getModel() {
		return model;
	}

	public void setModel(NodeModel model) {
		this.model = model;
	}


}
