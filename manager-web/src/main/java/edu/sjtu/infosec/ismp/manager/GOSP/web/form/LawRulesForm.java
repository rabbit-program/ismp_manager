package edu.sjtu.infosec.ismp.manager.GOSP.web.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;
/**
 *  法律法规Form表单
 * 
 * @author cxk
 *
 * date:2010-11-16
 */
public class LawRulesForm extends ActionForm{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 法律法规的名字（上传文件的名字）
	 */
	private String name;
	/**
	 * 法律法规所属域 id
	 */
	private Integer dmid;
	/**
	 * 法律法规的编号
	 */
	private String sn;
	/**
	 * 法律法规的发布单位
	 */
	private String issueUnit;
	/**
	 * 法律法规的文件类型
	 */
	private String file_type;
	/**
	 * 法律法规的备注
	 */
	private String remark;
	
	/**
	 * 法律法规的上传文件的相关信息
	 */
	private FormFile file;

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

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getIssueUnit() {
		return issueUnit;
	}

	public void setIssueUnit(String issueUnit) {
		this.issueUnit = issueUnit;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}
	
}
