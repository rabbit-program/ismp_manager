package org.infosec.ismp.manager.model.snmp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionOfElements;

/**
 * @author guoxianwei
 * @date 2010-12-24 下午12:28:31
 * 
 */
@Entity
@Table(name="snmpdevice_history_entity")
public class SnmpDeviceHistoryBaseEntity implements Serializable {

	private static final long serialVersionUID = -3422345511991381562L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nodeid;
	private String domain;
	private String ipAddr;
	private String type;
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	@CollectionOfElements(fetch = FetchType.LAZY)
	@JoinTable(name = "host_history_entity", joinColumns = @JoinColumn(name = "devicebaseid"))
	private List<HostResourceHistoryEntity> hostHistory; //主机设备历史表(CPU,HD,MEMORY
															// ,PROCESS)
	@CollectionOfElements(fetch = FetchType.LAZY)
	@JoinTable(name = "weblogic_history_entity", joinColumns = @JoinColumn(name = "devicebaseid"))
	private List<WeblogicHistoryEntity> weblogicHistory; // WEBLOGIC设备历史表(JVM,
															// jdbcPool
															// ,treadPool)
	@CollectionOfElements(fetch = FetchType.LAZY)
	@JoinTable(name = "network_history_entity", joinColumns = @JoinColumn(name = "devicebaseid"))
	private List<NetworkHistoryEntity> networkHistory; // CISCO设备历史表(
	
	public Date getTime() {
		return time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public String getNodeid() {
		return nodeid;
	}

	public String getDomain() {
		return domain;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public List<HostResourceHistoryEntity> getHostHistory() {
		return hostHistory;
	}

	public void setHostHistory(List<HostResourceHistoryEntity> hostHistory) {
		this.hostHistory = hostHistory;
	}

	public List<WeblogicHistoryEntity> getWeblogicHistory() {
		return weblogicHistory;
	}

	public void setWeblogicHistory(List<WeblogicHistoryEntity> weblogicHistory) {
		this.weblogicHistory = weblogicHistory;
	}

	public List<NetworkHistoryEntity> getNetworkHistory() {
		return networkHistory;
	}

	public void setNetworkHistory(List<NetworkHistoryEntity> networkHistory) {
		this.networkHistory = networkHistory;
	}

}

