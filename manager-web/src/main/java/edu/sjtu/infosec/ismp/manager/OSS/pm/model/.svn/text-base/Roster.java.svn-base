package edu.sjtu.infosec.ismp.manager.OSS.pm.model;
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
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 值班人员
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "oss_pm_roster")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class Roster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6669124507535524183L;
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
     * 0 男
     * 1 女
     */
    @Column(name="sex")
    private int sex;
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
	 * 职位
	 */
    @Column(name="position")
	private String position;
	/**
	 * 手机
	 */
    @Column(name="mobile")
	private String mobile;
	/**
	 * 固话
	 */
    @Column(name="phone")
	private String phone;
	/**
	 * E_mail
	 */
    @Column(name="e_mail")
	private String eMail;
	/**
	 * 创建时间
	 */
    @Column(name="create_time")
	private Timestamp createTime;
	/**
	 * 最后修改时间
	 */
    @Column(name="last_update_time")
	private Timestamp lastUpdateTime;
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
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getEMail() {
		return eMail;
	}
	public void setEMail(String mail) {
		eMail = mail;
	}
}
