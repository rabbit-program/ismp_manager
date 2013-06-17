package org.infosec.ismp.manager.model.syslog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * syslog节点
 * @author lianglin
 *
 */
@Entity
@Table(name = "manager_syslog_node_entity")
public class SyslogNodeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nodeid;
	private String ipaddr;
	private String domain;
	private String syslogType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNodeid() {
		return nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSyslogType() {
		return syslogType;
	}

	public void setSyslogType(String syslogType) {
		this.syslogType = syslogType;
	}

}
