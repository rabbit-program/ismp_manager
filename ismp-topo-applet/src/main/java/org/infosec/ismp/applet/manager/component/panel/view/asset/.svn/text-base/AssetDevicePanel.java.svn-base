package org.infosec.ismp.applet.manager.component.panel.view.asset;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;

import org.infosec.ismp.applet.manager.component.panel.SJTUConst;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;
import org.infosec.ismp.applet.manager.component.panel.view.BorderPanel;

import twaver.swing.TableLayout;

/**
 * 资产信息 面板
 * 接口：
 * setAssetDevice
 * getAssetDevice
 */
public class AssetDevicePanel extends BorderPanel implements PropertyChangeListener {

	private AssetDevice assetDevice = new AssetDevice();

	private JTextField userField = SJTUUtils.getTextField();
	private JTextField telephoneField = SJTUUtils.getTextField();
	private JTextField unitField = SJTUUtils.getTextField();
	private JTextField departmentField = SJTUUtils.getTextField();
	private JTextField statusField = SJTUUtils.getTextField();
	private JTextField stockTimeField = SJTUUtils.getTextField();
	private JTextField validityPeriodField = SJTUUtils.getTextField();
	private JTextField registrationTimeField = SJTUUtils.getTextField();

	private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public AssetDevicePanel() {
		super(" 资产信息  ");
		initGUI();
		updateFields();
		assetDevice.addPropertyChangeListener(this);
	}

	public void initGUI() {
		this.setBackground(SJTUConst.PANELBACKGROUND);

		double rows[] = { TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED };
		double cols[] = { TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL };
		TableLayout layout = new TableLayout(cols, rows, 10, 5);
		this.setLayout(layout);

		this.add(SJTUUtils.getLabel("使用人"), "0,0,0,0");
		this.add(userField, "1,0,1,0");
		this.add(SJTUUtils.getLabel("电话"), "2,0,2,0");
		this.add(telephoneField, "3,0,3,0");

		this.add(SJTUUtils.getLabel("单位"), "0,1,0,1");
		this.add(unitField, "1,1,1,1");
		this.add(SJTUUtils.getLabel("部门"), "2,1,2,1");
		this.add(departmentField, "3,1,3,1");

		this.add(SJTUUtils.getLabel("资产状态"), "0,2,0,2");
		this.add(statusField, "1,2,1,2");
		this.add(SJTUUtils.getLabel("采购时间"), "2,2,2,2");
		this.add(stockTimeField, "3,2,3,2");

		this.add(SJTUUtils.getLabel("有效期"), "0,3,0,3");
		this.add(validityPeriodField, "1,3,1,3");
		this.add(SJTUUtils.getLabel("注册时间"), "2,3,2,3");
		this.add(registrationTimeField, "3,3,3,3");
	}

	private void updateFields() {
		if (assetDevice != null) {
			userField.setText(assetDevice.getUser());
			telephoneField.setText(assetDevice.getTelephone());
			unitField.setText(assetDevice.getUnit());
			departmentField.setText(assetDevice.getDepartment());
			Integer status = assetDevice.getStatus();
			if (status != null) {
				statusField.setText(status + "");
			}
			Date stockTime = assetDevice.getStockTime();
			if (stockTime != null) {
				stockTimeField.setText(format.format(stockTime));
			}

			Integer validityPeriod = assetDevice.getValidityPeriod();
			if (validityPeriod != null) {
				validityPeriodField.setText(validityPeriod + "");
			}
			Date registrationTime = assetDevice.getRegistrationTime();
			if (registrationTime != null) {
				registrationTimeField.setText(format.format(registrationTime));
			}
		} else {
			userField.setText("");
			telephoneField.setText("");
			unitField.setText("");
			departmentField.setText("");
			statusField.setText("");
			stockTimeField.setText("");
			validityPeriodField.setText("");
			registrationTimeField.setText("");
		}
	}

	public AssetDevice getAssetDevice() {
		return assetDevice;
	}

	public void setAssetDevice(AssetDevice assetDevice) {
		if (this.assetDevice != null) {
			this.assetDevice.removePropertyChangeListener(this);
		}
		if (assetDevice != null) {
			assetDevice.addPropertyChangeListener(this);
		}
		this.assetDevice = assetDevice;
		updateFields();
	}

	public void propertyChange(PropertyChangeEvent evt) {
		updateFields();
	}

}
