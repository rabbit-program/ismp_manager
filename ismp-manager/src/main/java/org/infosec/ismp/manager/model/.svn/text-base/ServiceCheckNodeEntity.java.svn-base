package org.infosec.ismp.manager.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionOfElements;

@Entity
@Table(name="servicecheck_node_entity")
public class ServiceCheckNodeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer serviceCheckId;
	private String domain;
	private String nodeid;
	private String serviceType;
	@Column(name = "servicecheck_interval")
	private Long interval;
	private String ipAddr;

	@CollectionOfElements(fetch=FetchType.EAGER)
	@JoinTable(name = "servicecheck_node_param_entity", joinColumns = @JoinColumn(name = "serviceCheckId"))	
	private List<ServiceCheckNodeParamEntity> param= new ArrayList<ServiceCheckNodeParamEntity>();
	
	public Integer getServiceCheckId() {
		return serviceCheckId;
	}
	public void setServiceCheckId(Integer serviceCheckId) {
		this.serviceCheckId = serviceCheckId;
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
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public Long getInterval() {
		return interval;
	}
	public void setInterval(Long interval) {
		this.interval = interval;
	}
	public List<ServiceCheckNodeParamEntity> getParam() {
		return param;
	}
	public void setParam(List<ServiceCheckNodeParamEntity> param) {
		this.param = param;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

}
