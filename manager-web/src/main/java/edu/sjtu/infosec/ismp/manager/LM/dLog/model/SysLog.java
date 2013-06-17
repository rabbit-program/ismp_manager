package edu.sjtu.infosec.ismp.manager.LM.dLog.model;

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
 * SysLog的原始日志
 * @author Lin Chao
 * @date 2010-09-06
 * @version 1.0
 */
@Entity
@Table(name = "lm_dlog_syslog")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SysLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5570078546960813843L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 产生日志的程序模块
	 */
	@ManyToOne 
	@JoinColumn(name="facility_oid")
	private SysLogFacility facility;
	/**
	 * 严重性
	 */
	@ManyToOne 
	@JoinColumn(name="severity_oid")
	private SysLogSeverity severity;
	/**
	 * 主机名或者IP
	 */
    @Column(name="hostname")
	private String hostname;
	/**
	 * 时间
	 */
    @Column(name="timestamp")
	private Timestamp timestamp;
	/**
	 *消息主体部分 
	 */
    @Column(name="message",length = 2000)
	private String message;
	/**
	 * 关联的部门的名字
	 */
    @ManyToOne 
    @JoinColumn(name="domain_id")
	private Domain domain;
    
///////////////////////////////////////////分割线//////////////////////////////////////////////
//    /**																					//
//     * 优化后的消息主体																	//
//     */																					//
//   @Formula(value="")																		//
//    private StringOptimize messageOptimize;												//
//    																						//
//	public StringOptimize getMessageOptimize() {											//
//		return messageOptimize;																//
//	}																						//
//	public void setMessageOptimize(StringOptimize messageOptimize) {						//
//		this.messageOptimize = messageOptimize;												//
//	}																						//
///////////////////////////////////////////分割线//////////////////////////////////////////////
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public SysLogFacility getFacility() {
		return facility;
	}
	public void setFacility(SysLogFacility facility) {
		this.facility = facility;
	}
	public SysLogSeverity getSeverity() {
		return severity;
	}
	public void setSeverity(SysLogSeverity severity) {
		this.severity = severity;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
}
