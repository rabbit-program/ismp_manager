package org.infosec.ismp.applet.manager.component.panel.info.basic;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.infosec.ismp.applet.manager.component.panel.component.TitlePanel;
import org.infosec.ismp.applet.manager.component.panel.info.AbstractTitlePanel;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;

import twaver.swing.LabelValueLayout;

/**
 * 基本信息面板
 * 接口
 * 操作系统：getOS & setOS
 * 版本:		getVersion & setVersion
 * 运行时间:getRunTime & setRunTime
 */
public class RoutinePanel extends AbstractTitlePanel {
	private JTextField osField = SJTUUtils.getTextField();
	private JTextField versionField = SJTUUtils.getTextField();
	private JTextField runTimeField = SJTUUtils.getTextField();

	public RoutinePanel() {
		LabelValueLayout layout = new LabelValueLayout(5, 2, false);
		this.setLayout(layout);
		this.add(SJTUUtils.getLabel("操作系统"));
		this.add(osField);
		this.add(SJTUUtils.getLabel("型号"));
		this.add(versionField);
		this.add(SJTUUtils.getLabel("品牌"));//
		this.add(runTimeField);
	}

	public JPanel getTitlePanel() {
		return new TitlePanel("常规信息", this);
	}

	/**
	 * 获取操作系统信息
	 * 
	 * @return
	 */
	public String getOs() {
		return osField.getText();
	}

	/**
	 * 设置操作系统信息。
	 * 
	 * @param os
	 */
	public void setOs(String os) {
		this.osField.setText(os);
	}

	/**
	 * 获取版本信息
	 * 
	 * @return
	 */
	public String getVersion() {
		return versionField.getText();
	}

	/**
	 * 设置版本信息。
	 * 
	 * @param version
	 */
	public void setVersion(String version) {
		this.versionField.setText(version);
	}

	/**
	 * 获取运行时间信息。
	 * 
	 * @return
	 */
	public String getRunTime() {
		return runTimeField.getText();
	}

	/**
	 * 设置运行时间信息。
	 * 
	 * @param runTime
	 */
	public void setRunTime(String runTime) {
		this.runTimeField.setText(runTime);
	}
}
