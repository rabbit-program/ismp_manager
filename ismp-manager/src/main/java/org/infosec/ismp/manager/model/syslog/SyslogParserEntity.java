package org.infosec.ismp.manager.model.syslog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 记录了解析Syslog的处理器类的表
 * 
 * @author lianglin
 * 
 */
@Entity
@Table(name = "lm_dlog_syslog_source_handle_or_parser")
public class SyslogParserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "handle_type")
	private String handleType;
	@Column(name = "agent_handle_class")
	private String rawParserClass;
	@Column(name = "server_handle_class")
	private String specialParserClass;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}

	public String getRawParserClass() {
		return rawParserClass;
	}

	public void setRawParserClass(String rawParserClass) {
		this.rawParserClass = rawParserClass;
	}

	public String getSpecialParserClass() {
		return specialParserClass;
	}

	public void setSpecialParserClass(String specialParserClass) {
		this.specialParserClass = specialParserClass;
	}

}
