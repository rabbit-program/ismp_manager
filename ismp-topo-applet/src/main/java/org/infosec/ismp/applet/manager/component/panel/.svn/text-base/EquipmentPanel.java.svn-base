package org.infosec.ismp.applet.manager.component.panel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.infosec.ismp.applet.manager.component.panel.view.asset.AssetDevicePanel;
import org.infosec.ismp.applet.manager.component.panel.view.device.DeviceInfoPanel;
import org.infosec.ismp.applet.manager.component.panel.view.infoview.InfoViewPanel;
import org.infosec.ismp.applet.manager.component.panel.view.network.NetworkStatusPanel;
import org.infosec.ismp.applet.manager.component.panel.view.sensor.SensorPanel;

import twaver.swing.TableLayout;


/**
 * 信息一览面板
 */
@SuppressWarnings("serial")
public class EquipmentPanel extends JPanel {
//	public Timer timer;
	private DeviceInfoPanel deviceInfoPanel = new DeviceInfoPanel();
	private AssetDevicePanel assetDevicePanel = new AssetDevicePanel();
	private NetworkStatusPanel networkStatusPanel = new NetworkStatusPanel();
	private SensorPanel sensorPanel = new SensorPanel();
	private InfoViewPanel infoViewPanel;
	private boolean isSensor = false;
    /**
     * 基本信息面板。
     * @param device
     * @param dyname
     */
	public EquipmentPanel(boolean isSensor) {
		infoViewPanel = new InfoViewPanel();
		this.isSensor = isSensor;
		initGUI();
	}
	private void initGUI() {
		double rows[] = { TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.FILL };
		double cols[] = { TableLayout.FILL };
		TableLayout layout = new TableLayout(cols, rows, 10, 15);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.setLayout(layout);

		this.add(deviceInfoPanel, "0,0,0,0");
		this.add(assetDevicePanel, "0,1,0,1");
		if(isSensor) {
			this.add(sensorPanel, "0,2,0,2");
		} else {
			this.add(networkStatusPanel,"0,2,0,2");
		}
		this.add(infoViewPanel, "0,3,0,3");
	}
	
	long count = 0l;
	
	/**
	 * 获得设备信息面板
	 * @return DeviceInfoPanel
	 */
	public DeviceInfoPanel getDeviceInfoPanel() {
		return deviceInfoPanel;
	}
	/**
	 * 获得资产信息面板
	 * @return AssetDevicePanel
	 */
	public AssetDevicePanel getAssetDevicePanel() {
		return assetDevicePanel;
	}
	
	/**
	 * 获得网络设备面板
	 * @return
	 */
	public NetworkStatusPanel getNetworkStatusPanel() {
		return networkStatusPanel;
	}
	
	/**
	 * 获得Sensor基本信息面板
	 * @return
	 */
	public SensorPanel getSensorPanel() {
		return sensorPanel;
	}
	
	/**
	 * 获得下部图形面板
	 * @return
	 */
	public InfoViewPanel getInfoViewPanel() {
		return infoViewPanel;
	}
}
