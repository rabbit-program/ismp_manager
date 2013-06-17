package org.infosec.ismp.situation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Domain implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3528185221070325147L;
	private Integer id;
	private String domainName;
	private String description;
	private Domain parentDomain;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
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
