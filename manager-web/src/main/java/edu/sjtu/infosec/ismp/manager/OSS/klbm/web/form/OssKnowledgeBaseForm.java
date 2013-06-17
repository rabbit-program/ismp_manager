package edu.sjtu.infosec.ismp.manager.OSS.klbm.web.form;

import org.apache.struts.action.ActionForm;

/**
 * 运维知识库Form表单
 * 
 * @author cxk
 *
 * date:2010-11-25
 */
public class OssKnowledgeBaseForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 运维知识库的名字
	 */
	private String name;
	/**
	 * 运维知识库所属域 id
	 */
	private int dmid;
	/**
	 * 运维知识库的内容
	 */
	private String file_content;
	/**
	 * 运维知识库的发布人员
	 */
	private String issuer;
	/**
	 * 运维知识库的编号
	 */
	private String sn;
	/**
	 * 运维知识库的描述
	 */
	private String remark;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDmid() {
		return dmid;
	}
	public void setDmid(int dmid) {
		this.dmid = dmid;
	}
	public String getFile_content() {
		return file_content;
	}
	public void setFile_content(String file_content) {
		this.file_content = file_content;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
		
}
