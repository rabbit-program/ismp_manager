package edu.sjtu.infosec.ismp.manager.VPM.pm.web.form;

import org.apache.struts.action.ActionForm;
//补丁统计
public class StrateStatiscalPatchForm extends ActionForm {

	// private String strategyName;

	private String assetId;

	private String bTime;

	private String eTime;

	private Integer id;

	private String strategyName;

	private Integer isUp;

	private Integer upStyle;

	private String upAddress;

	private String upTime;

	private String assetCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIsUp() {
		return isUp;
	}

	public void setIsUp(Integer isUp) {
		this.isUp = isUp;
	}

	public Integer getUpStyle() {
		return upStyle;
	}

	public void setUpStyle(Integer upStyle) {
		this.upStyle = upStyle;
	}

	public String getUpAddress() {
		return upAddress;
	}

	public void setUpAddress(String upAddress) {
		this.upAddress = upAddress;
	}

	public String getUpTime() {
		return upTime;
	}

	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public String getBTime() {
		return bTime;
	}

	public void setBTime(String bTime) {
		this.bTime = bTime;
	}

	public String getETime() {
		return eTime;
	}

	public void setETime(String eTime) {
		this.eTime = eTime;
	}

	public String getStrategyName() {
		return strategyName;
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

}
