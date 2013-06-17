package edu.sjtu.infosec.ismp.manager.SYSM.user.self.web.form;

import org.apache.struts.action.ActionForm;

/**
 * 
 * @author geng tong yong
 * @deprecated DomaimForm 部门对应的Form
 */
public class DomainForm extends ActionForm{
	private Integer id;			
	private String domain_name;		//部门名称
	private String description;		//部门描述
	private Integer parent_id;		//上级ID
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDomain_name() {
		return domain_name;
	}
	public void setDomain_name(String domainName) {
		domain_name = domainName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parentId) {
		parent_id = parentId;
	}
	
}
