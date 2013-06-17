package org.infosec.ismp.manager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "snmptrap_node_entity")
public class SnmpTrapNodeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String domain;
	private String nodeid;
	private String snmpTrapType;
	private String snmpTrapAddress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getNodeid() {
		return nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public String getSnmpTrapType() {
		return snmpTrapType;
	}

	public void setSnmpTrapType(String snmpTrapType) {
		this.snmpTrapType = snmpTrapType;
	}

	public String getSnmpTrapAddress() {
		return snmpTrapAddress;
	}

	public void setSnmpTrapAddress(String snmpTrapAddress) {
		this.snmpTrapAddress = snmpTrapAddress;
	}

}
