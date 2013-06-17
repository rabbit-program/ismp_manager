package edu.sjtu.infosec.ismp.manager.LM.dLog.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysLog的产生日志的程序模块
 * @author Lin Chao
 * @date 2010-09-06
 * @version 1.0
 */

@Entity
@Table(name = "lm_dlog_syslog_severity")
public class SysLogSeverity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8319366426705555082L;
	
	@Id
	private Integer severityNumber;
	
	private String severityDescribe;

	public Integer getSeverityNumber() {
		return severityNumber;
	}

	public void setSeverityNumber(Integer severityNumber) {
		this.severityNumber = severityNumber;
	}

	public String getSeverityDescribe() {
		return severityDescribe;
	}

	public void setSeverityDescribe(String severityDescribe) {
		this.severityDescribe = severityDescribe;
	}

}
