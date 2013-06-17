package edu.sjtu.infosec.ismp.manager.GOSP.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 法律法规
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "gosp_laws_info")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class LawsAndRules implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 所属域
	 */
    @ManyToOne 
    @JoinColumn(name="domain_id")
	private Domain domain;
	/**
	 * 编号
	 */
    @Column(name="sn")
	private String sn;
	/**
	 * 名称
	 */
    @Column(name="name")
	private String name;
	/**
	 * 文件类型
	 * 1：TXT
	 * 2：word
	 * 3：pdf
	 * 4：其他
	 */
    @Column(name="file_type")
	private String file_type;
	/**
	 * 发布单位
	 */
    @Column(name="issue_unit")
	private String issueUnit;
	/**
	 * 发布时间
	 */
    @Column(name="issue_date")
	private Timestamp issueDate;
	/**
	 * 文件上传时间
	 */
    @Column(name="upload_time")
	private Timestamp uploadTime;
	/**
	 * 备注
	 */
    @Column(name="remark")
	private String remark;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	public String getIssueUnit() {
		return issueUnit;
	}
	public void setIssueUnit(String issueUnit) {
		this.issueUnit = issueUnit;
	}
	public Timestamp getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Timestamp issueDate) {
		this.issueDate = issueDate;
	}
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
