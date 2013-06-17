package org.infosec.ismp.applet.manager.component.panel.view.sensor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JTextField;

import org.infosec.ismp.applet.manager.component.panel.SJTUConst;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;
import org.infosec.ismp.applet.manager.component.panel.view.BorderPanel;

import twaver.swing.TableLayout;

public class SensorPanel extends BorderPanel implements PropertyChangeListener{
	
	/**
	 * sensor ID
	 */
	private JTextField txtSensorId = SJTUUtils.getTextField();
	/**
	 * sensor 名称
	 */
	private JTextField txtSysName = SJTUUtils.getTextField();
	/**
	 * 操作系统信息
	 */
	private JTextField txtSysInfo = SJTUUtils.getTextField();
	/**
	 * 注册到信息
	 */
	private JTextField txtRegInfo = SJTUUtils.getTextField();
	/**
	 * 系统配置描述
	 */
	private JTextField txtSysConfigDesc = SJTUUtils.getTextField();
	/**
	 * 工作组名
	 */
	private JTextField txtWorkSpaceName = SJTUUtils.getTextField();
	/**
	 * 计算机描述
	 */
	private JTextField txtSysDesc = SJTUUtils.getTextField();
	/**
	 * 版本号
	 */
	private JTextField txtVersion = SJTUUtils.getTextField();
	/**
	 * sensor安装目录
	 */
    private JTextField txtSensorLocalPath = SJTUUtils.getTextField();
    /**
     * sensor IP
     */
    private JTextField txtSensorIP = SJTUUtils.getTextField();
    /**
     * 更新目录
     */
    private JTextField txtUpdateURL = SJTUUtils.getTextField();
	/**
	 * @return the sensorVersion
	 */
    
    /**
	 * sensor service 版本号
	 */
    private JTextField txtSensorServVersion = SJTUUtils.getTextField();
	/**
	 * Sensor Bean 对象
	 */
	private Sensor sensor = new Sensor();
	
	

	public SensorPanel() {
		super("Sensor 信息");
		this.setBackground(SJTUConst.PANELBACKGROUND);
		if (sensor != null) {
			sensor.addPropertyChangeListener(this);
		}
		initGUI();
		updateField();
		
//		this.deviceInfo = deviceInfo;
//		initGUI();
//		if (deviceInfo != null) {
//			deviceInfo.addPropertyChangeListener(this);
//		}
//		updateFields();
	}
	
	@Override
	public void initGUI() {
		this.setBackground(SJTUConst.PANELBACKGROUND);

		double rows[] = { TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED };
		double cols[] = { TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL };
		TableLayout layout = new TableLayout(cols, rows, 10, 5);
		this.setLayout(layout);


		this.add(SJTUUtils.getLabel("WinSensor更新地址"), "0,0,0,0");
		this.add(txtUpdateURL, "1,0,1,0");
//		this.add(SJTUUtils.getLabel("名称"), "2,0,2,0");
//		this.add(txtSysName, "3,0,3,0");
		this.add(SJTUUtils.getLabel("Sensor-ID"), "2,0,2,0");
		this.add(txtSensorId, "3,0,3,0");
		
		this.add(SJTUUtils.getLabel("操作系统信息"), "0,1,0,1");
		this.add(txtSysInfo, "1,1,1,1");
		this.add(SJTUUtils.getLabel("注册信息"), "2,1,2,1");
		this.add(txtRegInfo, "3,1,3,1");
//		this.add(SJTUUtils.getLabel("Sensor-IP"), "2,1,2,1");
//		this.add(this.tx, "3,1,3,1");

		this.add(SJTUUtils.getLabel("系统配置描述"), "0,2,0,2");
		this.add(txtSysConfigDesc, "1,2,1,2");
		this.add(SJTUUtils.getLabel("WinSensor版本号 "), "2,2,2,2");
		this.add(txtVersion, "3,2,3,2");
		

		this.add(SJTUUtils.getLabel("WinSensorService版本号 "), "0,3,0,3");
		this.add(txtSensorServVersion, "1,3,1,3");
		this.add(SJTUUtils.getLabel("工作组名"), "2,3,2,3");
		this.add(txtWorkSpaceName, "3,3,3,3");
		
	}
	
	private void updateField() {
		if(sensor != null) {
			txtSensorId.setText(sensor.getSensorId());
			txtSysName.setText(sensor.getSysName());
			txtSysInfo.setText(sensor.getSysInfo());
			txtRegInfo.setText(sensor.getRegInfo());
			txtSysConfigDesc.setText(sensor.getSysConfigDesc());
			txtWorkSpaceName.setText(sensor.getWorkSpaceName());
			txtSysDesc.setText(sensor.getSysDesc());
			txtVersion.setText(sensor.getVistion());
			this.txtSensorLocalPath.setText(sensor.getSensorLocalPath());
			this.txtSensorServVersion.setText(sensor.getSensorServVersion());
			this.txtUpdateURL.setText(sensor.getUpdateURL());
			
		} else {
			txtSensorId.setText("");
			txtSysName.setText("");
			txtSysInfo.setText("");
			txtRegInfo.setText("");
			txtSysConfigDesc.setText("");
			txtWorkSpaceName.setText("");
			txtSysDesc.setText("");	
			txtVersion.setText("");
			this.txtSensorLocalPath.setText("");
			this.txtSensorServVersion.setText("");
			this.txtUpdateURL.setText("");
		}
		
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		updateField();
	}
	
	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		if (this.sensor != null) {
			sensor.removePropertyChangeListener(this);
		}
		if (sensor != null) {
			sensor.addPropertyChangeListener(this);
		}
		this.sensor = sensor;
		updateField();
	}
}
