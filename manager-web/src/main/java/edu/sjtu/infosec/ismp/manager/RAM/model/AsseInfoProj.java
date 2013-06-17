package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import edu.sjtu.infosec.ismp.security.Domain;



/**
 * 信息库测评项目类. 
 */
@Entity
@Table(name = "RAM_INFO_PROJ")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
public class AsseInfoProj implements Serializable {

    //项目编号
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    //项目名称
    @Column(name="PROJ_NAME", length = 50)
    private String projName;

    //测评单位
    @Column(name="ASSE_COMP", length = 50)
    private String asseComp;

    //测评人
    @Column(name="ASSE_PERS", length = 10, nullable = false)
    private String assePers;

     //测评开始时间
    @Column(name="ASSE_BEGIN_TIME", nullable = false)
    private Timestamp asseBeginTime;

     // 测评结束时间
    @Column(name="ASSE_END_TIME")
    private Timestamp asseEndTime;

    // 安全级别
    @Column(name="SECU_LEVE", length = 10)
    private String secuLeve;

    //测评状态
    @Column(name="ASSE_STATUS", length = 10, nullable = false)
    private String asseStatus;

    //所处流程
    @Column(name="PROGRESS", length = 10, nullable = false)
    private String progress;

    //测评类型
    @Column(name="CP_KIND",length = 10,nullable = false)
    private String cpKind;

    //委办局参与人
    @ManyToOne 
    @JoinColumn(name="domain_id")
	private Domain domain;

    //法人
    @Column(name="LAW_PERS", length=10)
    private String lawPers;

    // 地址
    @Column(name="ADDRESS", length=50)
    private String address;

    //联系方式
    @Column(name="LINKWAY", length=20)
    private String linkway;

    //邮编
    @Column(name="ZIPCODE", length=6)
    private String zipcode;

    //电话
    @Column(name="PHONE", length=15)
    private String phone;

 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getAsseComp() {
		return asseComp;
	}

	public void setAsseComp(String asseComp) {
		this.asseComp = asseComp;
	}

	public String getAssePers() {
		return assePers;
	}

	public void setAssePers(String assePers) {
		this.assePers = assePers;
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

	public String getAsseStatus() {
		return asseStatus;
	}

	public void setAsseStatus(String asseStatus) {
		this.asseStatus = asseStatus;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getCpKind() {
		return cpKind;
	}

	public void setCpKind(String cpKind) {
		this.cpKind = cpKind;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public String getLawPers() {
		return lawPers;
	}

	public void setLawPers(String lawPers) {
		this.lawPers = lawPers;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLinkway() {
		return linkway;
	}

	public void setLinkway(String linkway) {
		this.linkway = linkway;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
   
}
