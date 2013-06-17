package edu.sjtu.infosec.ismp.manager.ERM.web.form;

import org.apache.struts.action.ActionForm;

public class AddRespInfoForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;  //预案名称
	
	private Integer dmid; //域id
	
	private String sysName; //系统描述
	
	private String sysDesc; //应急目标描述
	
	private String touchBy; //预案的假定
	
	private String references; //参考文献

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDmid() {
		return dmid;
	}

	public void setDmid(Integer dmid) {
		this.dmid = dmid;
	}

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public String getSysDesc() {
		return sysDesc;
	}

	public void setSysDesc(String sysDesc) {
		this.sysDesc = sysDesc;
	}

	public String getTouchBy() {
		return touchBy;
	}

	public void setTouchBy(String touchBy) {
		this.touchBy = touchBy;
	}

	public String getReferences() {
		return references;
	}

	public void setReferences(String references) {
		this.references = references;
	}
	
	
}
