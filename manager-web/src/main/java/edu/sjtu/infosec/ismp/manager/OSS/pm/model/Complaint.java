package edu.sjtu.infosec.ismp.manager.OSS.pm.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import edu.sjtu.infosec.ismp.security.Domain;
/**
 * @author liuqing
 * 投诉
 */
@Entity
@Table(name="oss_pm_domain_complaint")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class Complaint implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5311555188060450012L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 部门
	 */
	@OneToOne
	@JoinColumn(name="domain_id")
	private Domain domain;
	/**
	 * 投诉类型
	 */
	@Column(name = "complaint_type")
	private String complaintType;
	/**
	 * 投诉说明
	 */
	@Column(name = "complaint_help")
	private String complaintHelp;
	/**
	 * 投诉电话
	 */
	@Column(name = "complaint_phone")
	private String complaintPhone;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the domain
	 */
	public Domain getDomain() {
		return domain;
	}
	/**
	 * @param domain the domain to set
	 */
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	/**
	 * @return the complaintType
	 */
	public String getComplaintType() {
		return complaintType;
	}
	/**
	 * @param complaintType the complaintType to set
	 */
	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}
	/**
	 * @return the complaintHelp
	 */
	public String getComplaintHelp() {
		return complaintHelp;
	}
	/**
	 * @param complaintHelp the complaintHelp to set
	 */
	public void setComplaintHelp(String complaintHelp) {
		this.complaintHelp = complaintHelp;
	}
	/**
	 * @return the complaintPhone
	 */
	public String getComplaintPhone() {
		return complaintPhone;
	}
	/**
	 * @param complaintPhone the complaintPhone to set
	 */
	public void setComplaintPhone(String complaintPhone) {
		this.complaintPhone = complaintPhone;
	}
}
