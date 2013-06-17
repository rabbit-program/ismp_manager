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
 * SysLog的日志源
 * @author Lin Chao
 * @date 2010-09-20
 * @version 1.0
 */
/**
 * @author 林超
 *
 */
@Entity
@Table(name = "lm_dlog_syslog_source")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SysLogSource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9053904752895601032L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/**
	 * 日志源 名称
	 */
	@Column(name="source_name")
	private String sourceName;
	
	/**
	 * 创建时间
	 */
	@Column(name="create_time")
	private Timestamp createTime;
	
	
	/**
	 * 日志源类型：与lm_dlog_syslog_source_type表 ID 对应
	 */
	@ManyToOne 
	@JoinColumn(name="source_type")
	private SysLogSourceType sourceType;
	
	/**
	 * 设备IP
	 */
	@Column(name="device_ip")
	private String deviceIP;
	
	/**
	 * 日志源唯一标识
	 */
	@Column(name="log_sourcese_quence")
	private String logSourceseQuence;
	
////////////////////分割线/////////////////////////////
//	/**												//
//	 * 所要下发日志源的Agent							//
//	 */	
//	@Column(name="agent")							//
//	private Integer agent;							//
//////////////////////分割线//////////////////////////

	/**
	 * 日志源所在的域
	 */
	@ManyToOne 
	@JoinColumn(name="domain")
	private Domain domain;
	
	/**
	 * 日志采集的开始开关 :true 表示采集 false:表示不采集
	 */
	@Column(name="start_collect_switch")
	private Boolean startCollectSwitch;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public SysLogSourceType getSourceType() {
		return sourceType;
	}

	public void setSourceType(SysLogSourceType sourceType) {
		this.sourceType = sourceType;
	}

	public String getDeviceIP() {
		return deviceIP;
	}

	public void setDeviceIP(String deviceIP) {
		this.deviceIP = deviceIP;
	}

	public String getLogSourceseQuence() {
		return logSourceseQuence;
	}

	public void setLogSourceseQuence(String logSourceseQuence) {
		this.logSourceseQuence = logSourceseQuence;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Boolean getStartCollectSwitch() {
		return startCollectSwitch;
	}

	public void setStartCollectSwitch(Boolean startCollectSwitch) {
		this.startCollectSwitch = startCollectSwitch;
	}
}