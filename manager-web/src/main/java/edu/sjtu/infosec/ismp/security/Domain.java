package edu.sjtu.infosec.ismp.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 代表一个独立的管理单位或者区域，如委办局等. 
 * 可以管理自身，即下属可以存在域 . 
 * 
 * 
 * $Id: Domain.java 791 2010-10-08 02:55:20Z caoqi $
 * 
 */
@Entity
@Table(name = "ismp_domain")
public class Domain extends IdEntity implements Serializable{
	private String domainName;
	private String description;
	private Domain parentDomain;

    
	@Column(name="domain_name")
	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    @ManyToOne
    @JoinColumn(name="parent_id")
	public Domain getParentDomain() {
		return parentDomain;
	}

	public void setParentDomain(Domain parentDomain) {
		this.parentDomain = parentDomain;
	}

}
