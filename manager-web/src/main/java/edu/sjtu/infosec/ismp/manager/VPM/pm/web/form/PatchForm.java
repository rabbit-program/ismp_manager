package edu.sjtu.infosec.ismp.manager.VPM.pm.web.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts.action.ActionForm;

import edu.sjtu.infosec.ismp.manager.VPM.pm.model.SensorClients;

public class PatchForm extends ActionForm {
	


	//sensor跟资产以及委办局的映射
	private SensorClients s=new SensorClients();
	private String createStartDatePage;
	private String createEndDatePage;
	private String singleCode;
	private String assetDeviceId;
	private String departmentId;
	SimpleDateFormat simpdate=new SimpleDateFormat("yyyy-MM-dd");
	private Date createStartDate;
	private Date createEndDate;
	private String beanId;
	private String sensorName;
	
	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	
	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public String getBeanId() {
		return beanId;
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	public Date getCreateStartDate() {
		return createStartDate;
	}

	public void setCreateStartDate(Date createStartDate) {
		this.createStartDate = createStartDate;
	}

	public Date getCreateEndDate() {
		return createEndDate;
	}

	public void setCreateEndDate(Date createEndDate) {
		this.createEndDate = createEndDate;
	}

	public String getAssetDeviceId() {
		return assetDeviceId;
	}

	public void setAssetDeviceId(String assetDeviceId) {
		this.assetDeviceId = assetDeviceId;
	}

	public String getSingleCode() {
		return singleCode;
	}

	public void setSingleCode(String singleCode) {
		this.singleCode = singleCode;
	}

	public String getCreateStartDatePage() {
		return createStartDatePage;
	}

	public String getCreateEndDatePage() {
		return createEndDatePage;
	}
	public SensorClients getS() {
		return s;
	}

	public void setS(SensorClients s) {
		this.s = s;
	}

	public void setCreateStartDatePage(String createStartDatePage) {
		if(createStartDatePage!=null&&createStartDatePage.trim().length()>0){
			try {
				this.setCreateStartDate(simpdate.parse(createStartDatePage));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			this.setCreateStartDate(null);
		}
		this.createStartDatePage = createStartDatePage;
	}

	public void setCreateEndDatePage(String createEndDatePage) {
		if(createEndDatePage!=null&&createEndDatePage.trim().length()>0){
			try {
				this.setCreateEndDate(simpdate.parse(createEndDatePage));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			this.setCreateEndDate(null);
		}
		this.createEndDatePage = createEndDatePage;
	}
	
}
