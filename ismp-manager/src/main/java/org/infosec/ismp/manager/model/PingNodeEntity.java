package org.infosec.ismp.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ping_node_entity")
public class PingNodeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String domain;
	private String nodeid;
	private String ipaddr;
	@Column(name = "ping_interval")
	private Long interval;
	private Boolean halfIntervalWhenDown;

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

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	public Long getInterval() {
		return interval;
	}

	public void setInterval(Long interval) {
		this.interval = interval;
	}

	public Boolean getHalfIntervalWhenDown() {
		return halfIntervalWhenDown;
	}

	public void setHalfIntervalWhenDown(Boolean halfIntervalWhenDown) {
		this.halfIntervalWhenDown = halfIntervalWhenDown;
	}
	
	

}
