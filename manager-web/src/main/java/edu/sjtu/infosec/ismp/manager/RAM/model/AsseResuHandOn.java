package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import edu.sjtu.infosec.ismp.security.Domain;


@Entity
@Table(name = "ram_info_asse")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseResuHandOn implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	    
	@Column(name="PROJ_ID", nullable = false)
	private Integer projId;
	  
	@Column(name="PROJ_NAME",length = 50, nullable = false)
	private String projName;
	 
	@ManyToOne 
	@JoinColumn(name="domain_id")
	private Domain domain;
	  
	@Column(name="ASSE_COMP",length = 50)
	private String asseComp;
	  
	@Column(name="ASSE_BEGIN_TIME",nullable = false)
	private Timestamp asseBeginTime;
	  
	@Column(name="ASSE_END_TIME")
	private Timestamp asseEndTime;
	  
	@Column(name="SECU_LEVE",length = 10)
	private String secuLeve;
	
	@Column(name="ASSE_PERS",length = 20)
	private String assePers;
	
	@Column(name="VULN_HIGH_NUM")
	private Integer vulnHighNum;
	  
	@Column(name="VULN_MIDU_NUM")
	private Integer vulnMiduNum;
	  
	@Column(name="VULN_LOW_NUM")
	private Integer vulnLowNum;
	  
	@Column(name="VULN_HIGH_IP_NUM")
	private Integer vulnHighIPNum;
	  
	@Column(name="VULN_MIDU_IP_NUM")
	private Integer vulnMiduIPNum;
	  
	@Column(name="VULN_LOW_IP_NUM")
	private Integer vulnLowIPNum;
	
	@Column(name="EXPERT_SUGGEST")
	@Type(type="text")
	private String expertSuggest;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjId() {
		return projId;
	}

	public void setProjId(Integer projId) {
		this.projId = projId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public String getAsseComp() {
		return asseComp;
	}

	public void setAsseComp(String asseComp) {
		this.asseComp = asseComp;
	}

	public Timestamp getAsseBeginTime() {
		return asseBeginTime;
	}

	public void setAsseBeginTime(Timestamp asseBeginTime) {
		this.asseBeginTime = asseBeginTime;
	}

	public Timestamp getAsseEndTime() {
		return asseEndTime;
	}

	public void setAsseEndTime(Timestamp asseEndTime) {
		this.asseEndTime = asseEndTime;
	}

	public String getSecuLeve() {
		return secuLeve;
	}

	public void setSecuLeve(String secuLeve) {
		this.secuLeve = secuLeve;
	}


	public String getAssePers() {
		return assePers;
	}

	public void setAssePers(String assePers) {
		this.assePers = assePers;
	}

	public Integer getVulnHighNum() {
		return vulnHighNum;
	}

	public void setVulnHighNum(Integer vulnHighNum) {
		this.vulnHighNum = vulnHighNum;
	}

	public Integer getVulnMiduNum() {
		return vulnMiduNum;
	}

	public void setVulnMiduNum(Integer vulnMiduNum) {
		this.vulnMiduNum = vulnMiduNum;
	}

	public Integer getVulnLowNum() {
		return vulnLowNum;
	}

	public void setVulnLowNum(Integer vulnLowNum) {
		this.vulnLowNum = vulnLowNum;
	}

	public Integer getVulnHighIPNum() {
		return vulnHighIPNum;
	}

	public void setVulnHighIPNum(Integer vulnHighIPNum) {
		this.vulnHighIPNum = vulnHighIPNum;
	}

	public Integer getVulnMiduIPNum() {
		return vulnMiduIPNum;
	}

	public void setVulnMiduIPNum(Integer vulnMiduIPNum) {
		this.vulnMiduIPNum = vulnMiduIPNum;
	}

	public Integer getVulnLowIPNum() {
		return vulnLowIPNum;
	}

	public void setVulnLowIPNum(Integer vulnLowIPNum) {
		this.vulnLowIPNum = vulnLowIPNum;
	}

	public String getExpertSuggest() {
		return expertSuggest;
	}

	public void setExpertSuggest(String expertSuggest) {
		this.expertSuggest = expertSuggest;
	}
  
}