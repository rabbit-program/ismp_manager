package edu.sjtu.infosec.ismp.manager.ERM.model;

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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 应急预案基本信息
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "erm_resp_info")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class RespInfoBO implements Serializable {
	/**
	 * 预案ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 名称
	 */
    @Column(name="name")
	private String name;
	/**
	 * 所属域
	 */
    @ManyToOne 
    @JoinColumn(name="domain_id")
	private Domain domain;
	/**
	 * 对应系统名称
	 */
    @Column(name="sys_name")
	private String sysName;
	/**
	 * 参考文献
	 */
    @Column(name="refs")
	private String refs;
	/**
	 * 状态
	 */
    @Column(name="state")
	private int state;
	/**
	 * 对应系统描述
	 */
    @Column(name="sys_desc")
	private String sysDesc;
	/**
	 * 预案的假定
	 */
    @Column(name="touch_by")
	private String touchBy;
	/**
	 * 应急目标
	 */
    @Column(name="expect")
	private String expect;
	/**
	 * 创建时间
	 */
    @Column(name="create_time")
	private Timestamp createTime;
	/**
	 * 最后修改时间
	 */
    @Column(name="update_time")
	private Timestamp updateTime;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public String getSysName() {
		return sysName;
	}
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
	public String getRefs() {
		return refs;
	}
	public void setRefs(String refs) {
		this.refs = refs;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getSysDesc() {
		return sysDesc;
	}
	public void setSysDesc(String sysDesc) {
		this.sysDesc = sysDesc;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getTouchBy() {
		return touchBy;
	}
	public void setTouchBy(String touchBy) {
		this.touchBy = touchBy;
	}
	public String getExpect() {
		return expect;
	}
	public void setExpect(String expect) {
		this.expect = expect;
	}
}
