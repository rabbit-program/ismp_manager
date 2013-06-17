package edu.sjtu.infosec.ismp.manager.ERM.model;

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
 * 业务影响分析(BIA)
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "erm_calltree_linkman")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class LinkMan implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 所属预案
	 */
    @ManyToOne 
    @JoinColumn(name="resp_info_id")
	private RespInfoBO respInfo;
	/**
	 * pid，构建树时标识顺序节点
	 */
    @Column(name="pid")
	private Integer pid;
	/**
	 * fid 构建树时标识父节点
	 */
    @Column(name="fid")
	private Integer fid;
	/**
	 * 姓名
	 */
    @Column(name="name")
	private String name;
	/**
	 * 岗位编号
	 */
    @Column(name="jobid")
	private String jobid;
	/**
	 * 角色
	 */
    @Column(name="job")
	private String job;
	/**
	 * 手机号码
	 */
    @Column(name="mp")
	private String mp;
	/**
	 * 邮件地址
	 */
    @Column(name="email")
	private String email;
	/**
	 * 传真号码
	 */
    @Column(name="fax")
	private String fax;
	/**
	 *小组ID
	 **/
    @Column(name="team_code")
	private String teamCode;
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RespInfoBO getRespInfo() {
		return respInfo;
	}
	public void setRespInfo(RespInfoBO respInfo) {
		this.respInfo = respInfo;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMp() {
		return mp;
	}
	public void setMp(String mp) {
		this.mp = mp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
}
