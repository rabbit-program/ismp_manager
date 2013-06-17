package org.infosec.ismp.applet.manager.component.panel.view.asset;

import java.util.Date;

import org.infosec.ismp.applet.manager.component.panel.view.Info;

public class AssetDevice extends Info {
	//使用人
	private String user;
	//电话
	private String telephone;
	//单位
	private String unit;
	//部门
	private String department;
	//资产状态
	private Integer status;
	//采购时间
	private Date stockTime;
	//有效期
	private Integer validityPeriod;
	//注册时间
	private Date registrationTime;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		String old = this.user;
		this.user = user;
		this.firePropertyChange("user", old, user);
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		String old = this.telephone;
		this.telephone = telephone;
		this.firePropertyChange("telephone", old, telephone);
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		String old = this.unit;
		this.unit = unit;
		this.firePropertyChange("unit", old, unit);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		String old = this.department;
		this.department = department;
		this.firePropertyChange("department", old, department);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		Integer old = this.status;
		this.status = status;
		this.firePropertyChange("status", old, status);
	}

	public Date getStockTime() {
		return stockTime;
	}

	public void setStockTime(Date stockTime) {
		Date old = this.stockTime;
		this.stockTime = stockTime;
		this.firePropertyChange("stockTime", old, stockTime);
	}

	public Integer getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Integer validityPeriod) {
		Integer old = this.validityPeriod;
		this.validityPeriod = validityPeriod;
		this.firePropertyChange("validityPeriod", old, validityPeriod);
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		Date old = this.registrationTime;
		this.registrationTime = registrationTime;
		this.firePropertyChange("registrationTime", old, registrationTime);
	}

}
