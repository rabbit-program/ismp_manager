package org.infosec.ismp.applet.manager.component.panel.view.device;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JTextField;

import org.infosec.ismp.applet.manager.component.panel.SJTUConst;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;
import org.infosec.ismp.applet.manager.component.panel.view.BorderPanel;

import twaver.swing.TableLayout;

/**
 * 面板：	设备基本信息面板
 * 调用接口：getDeviceInfo&setDeviceInfo
 * 
 */
public class DeviceInfoPanel extends BorderPanel implements PropertyChangeListener {

	public static void main(String[] args) {
//		SJTUUtils.showCompoentInFrame(new DeviceInfoPanel());
	}

	private DeviceInfo deviceInfo = new DeviceInfo();

	private JTextField deviceNumberField = SJTUUtils.getTextField();
	private JTextField deviceNameField = SJTUUtils.getTextField();
	private JTextField complanyField = SJTUUtils.getTextField();
	private JTextField deviceTradeMarkField = SJTUUtils.getTextField();
	private JTextField deviceModelNumField = SJTUUtils.getTextField();
	private JTextField createrField = SJTUUtils.getTextField();
	private JTextField agentIdField = SJTUUtils.getTextField();

	public DeviceInfoPanel() {
		//		this(null);
		super("  设备基本信息  ");
		initGUI();
		if (deviceInfo != null) {
			deviceInfo.addPropertyChangeListener(this);
		}
		updateFields();

	}

	public DeviceInfoPanel(DeviceInfo deviceInfo) {
		super("  设备基本信息  ");
		this.deviceInfo = deviceInfo;
		initGUI();
		if (deviceInfo != null) {
			deviceInfo.addPropertyChangeListener(this);
		}
		updateFields();
	}

	public void initGUI() {
		this.setBackground(SJTUConst.PANELBACKGROUND);

		double rows[] = { TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED };
		double cols[] = { TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL };
		TableLayout layout = new TableLayout(cols, rows, 10, 5);
		this.setLayout(layout);

		this.add(SJTUUtils.getLabel("编号"), "0,0,0,0");
		this.add(deviceNumberField, "1,0,1,0");
		this.add(SJTUUtils.getLabel("名称"), "2,0,2,0");
		this.add(deviceNameField, "3,0,3,0");

		this.add(SJTUUtils.getLabel("设备厂家    "), "0,1,0,1");
		this.add(complanyField, "1,1,1,1");
		this.add(SJTUUtils.getLabel("品牌"), "2,1,2,1");
		this.add(deviceTradeMarkField, "3,1,3,1");

		this.add(SJTUUtils.getLabel("型号"), "0,2,0,2");
		this.add(deviceModelNumField, "1,2,1,2");
//		this.add(SJTUUtils.getLabel("创建人"), "2,2,2,2");
//		this.add(createrField, "3,2,3,2");
//		this.add(SJTUUtils.getLabel("数据代理    "), "2,2,2,2");
//		this.add(agentIdField, "3,2,3,2");
//		this.add(SJTUUtils.getLabel("数据代理    "), "0,3,0,3");
//		this.add(agentIdField, "1,3,1,3");
	}

	public void propertyChange(PropertyChangeEvent evt) {
		updateFields();
	}

	private void updateFields() {
		if (deviceInfo != null) {
			deviceNumberField.setText(deviceInfo.getDeviceNumber());
			deviceNameField.setText(deviceInfo.getDeviceName());
			complanyField.setText(deviceInfo.getCompany());
			deviceTradeMarkField.setText(deviceInfo.getDeviceTradeMark());
			deviceModelNumField.setText(deviceInfo.getDeviceModelNum());
			createrField.setText(deviceInfo.getCreater());
			String id = deviceInfo.getAgentId();
			Integer agentId = null;
			if(id != null && !id.equals("")) {
				try {
					agentId = Integer.parseInt(id);
				} catch (Exception e) {
					throw new RuntimeException();
				}
			}
		} else {
			deviceNumberField.setText("");
			deviceNameField.setText("");
			complanyField.setText("");
			deviceTradeMarkField.setText("");
			deviceModelNumField.setText("");
			createrField.setText("");
			agentIdField.setText("");
		}
	}

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		if (this.deviceInfo != null) {
			deviceInfo.removePropertyChangeListener(this);
		}
		if (deviceInfo != null) {
			deviceInfo.addPropertyChangeListener(this);
		}
		this.deviceInfo = deviceInfo;
		updateFields();
	}

}
