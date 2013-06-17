package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import edu.sjtu.infosec.ismp.security.Domain;


/**
 * 信息库业务信息类.
 */
@Entity
@Table(name = "RAM_INFO_BUSI")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
public class AsseInfoBusi implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
     * 主键id
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;
    
    /**
     * 业务编号
     * */
    @Column(name="BUSINESS_ID", length = 20, nullable = false,unique=true)
    private String businessId;
    
    /**
     * 业务名称
     * */
    @Column(name="BUSINESS_NAME", length=200, nullable=false)
    private String businessName;
    
    /**
     * 业务负责人
     * */
    @Column(name="RESP_MAN", length=10)
    private String respMan;
    
    /**
     * 业务重要性
     * */
    @Column(name="IMPORTANCE", length=5, nullable=false)
    private String importance;
    
    //委办局参与人
    @ManyToOne 
    @JoinColumn(name="domain_id")
	private Domain domain;
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getRespMan() {
		return respMan;
	}

	public void setRespMan(String respMan) {
		this.respMan = respMan;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}
    
    
}
