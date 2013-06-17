package edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog;

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
 * * Ftp 的日志源
 * @date 2010-10-18
 * @version 1.0
 * @author 林超
 *
 */
@Entity
@Table(name = "lm_dlog_ftp_source")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class FtpSource implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9204423137887358244L;

	/** 编号 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * ftp日志采集源唯一标示
	 */
	@Column(name = "log_source_sequence")
	private String logSourceSequence;

	/**
	 * 日志采集源创建时间
	 */
	@Column(name = "create_time")
	private Timestamp createTime;

	/**
	 * ftp模式日志采集源的ip
	 */
	@Column(name = "ftp_collect_source_ip")
	private String ftpCollectSourceIp;

	/**
	 * ftp模式日志采集源的port
	 */
	@Column(name = "ftp_collect_source_port")
	private Integer ftpCollectSourcePort;

	/**
	 * ftp模式日志采集源的用户名
	 */
	@Column(name = "ftp_collect_source_name")
	private String ftpCollectSourceName;

	/**
	 * ftp模式日志采集源的用户密码
	 */
	@Column(name = "ftp_collect_source_Password")
	private String ftpCollectSourcePassword;

	/**
	 * ftp模式日志采集源的文件路径
	 */
	@Column(name = "ftp_collect_source_path")
	private String ftpCollectSourcePath;
	
	/**
	 * ftp模式日志采集源的文件名
	 */
	@Column(name = "ftp_collect_source_file_name")
	private String ftpCollectSourceFileName;

	/**
	 * 轮循采集时间间隔:毫秒
	 */
	@Column(name = "interval_collect_time")
	private Long intervalCollectTime;

	/**
	 * 日志采集的开始开关 :true 表示采集 false:表示不采集
	 */
	@Column(name = "start_collect_switch")
	private Boolean startCollectSwitch;

	/**
	 * 委办局sequence
	 */
	@ManyToOne 
	@JoinColumn(name="domain")
	private Domain domain;

	/**
	 * 采集代理到manager层注册的id
	 */
	@Column(name = "agent_id")
	private Integer agentId;

	/**
	 * sourceName
	 */
	@Column(name = "source_name")
	private String sourceName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogSourceSequence() {
		return logSourceSequence;
	}

	public void setLogSourceSequence(String logSourceSequence) {
		this.logSourceSequence = logSourceSequence;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getFtpCollectSourceIp() {
		return ftpCollectSourceIp;
	}

	public void setFtpCollectSourceIp(String ftpCollectSourceIp) {
		this.ftpCollectSourceIp = ftpCollectSourceIp;
	}

	public Integer getFtpCollectSourcePort() {
		return ftpCollectSourcePort;
	}

	public void setFtpCollectSourcePort(Integer ftpCollectSourcePort) {
		this.ftpCollectSourcePort = ftpCollectSourcePort;
	}

	public String getFtpCollectSourceName() {
		return ftpCollectSourceName;
	}

	public void setFtpCollectSourceName(String ftpCollectSourceName) {
		this.ftpCollectSourceName = ftpCollectSourceName;
	}

	public String getFtpCollectSourcePassword() {
		return ftpCollectSourcePassword;
	}

	public void setFtpCollectSourcePassword(String ftpCollectSourcePassword) {
		this.ftpCollectSourcePassword = ftpCollectSourcePassword;
	}

	public String getFtpCollectSourcePath() {
		return ftpCollectSourcePath;
	}

	public void setFtpCollectSourcePath(String ftpCollectSourcePath) {
		this.ftpCollectSourcePath = ftpCollectSourcePath;
	}

	public String getFtpCollectSourceFileName() {
		return ftpCollectSourceFileName;
	}

	public void setFtpCollectSourceFileName(String ftpCollectSourceFileName) {
		this.ftpCollectSourceFileName = ftpCollectSourceFileName;
	}

	public Long getIntervalCollectTime() {
		return intervalCollectTime;
	}

	public void setIntervalCollectTime(Long intervalCollectTime) {
		this.intervalCollectTime = intervalCollectTime;
	}

	public Boolean getStartCollectSwitch() {
		return startCollectSwitch;
	}

	public void setStartCollectSwitch(Boolean startCollectSwitch) {
		this.startCollectSwitch = startCollectSwitch;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	
}
