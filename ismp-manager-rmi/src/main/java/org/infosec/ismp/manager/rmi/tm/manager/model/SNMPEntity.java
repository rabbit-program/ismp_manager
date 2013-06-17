package org.infosec.ismp.manager.rmi.tm.manager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * SNMP管理方式
 * @author 肖高峰
 *
 */
@Entity
@Table(name = "tm_topo_manager_snmp")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SNMPEntity implements Serializable{
	private static final long serialVersionUID = 2740759651594709309L;

	/**
	 * ID
	 */
	@Id
	@Column(name = "snmp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long snmpId;
	
	/**
	 * 管理团体名
	 */
	private String community;
	
	/**
	 * 版本信息
	 */
	private String version;
	
	/**
	 * 端口
	 */
	private String port;
	
	/**
	 * node 外键
	 */
	@OneToOne
	@JoinColumn(name = "node_id")
	private NodeEntity node;
	
	public NodeEntity getNode() {
		return node;
	}

	public void setNode(NodeEntity node) {
		this.node = node;
	}

	public Long getSnmpId() {
		return snmpId;
	}

	public void setSnmpId(Long snmpId) {
		this.snmpId = snmpId;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public final boolean equals(Object o) {
		if (!(o instanceof SNMPEntity)) {
			return false;
		}
		SNMPEntity another = (SNMPEntity) o;
		return new EqualsBuilder().append(snmpId, another.snmpId)
		                          .append(community, another.community)
		                          .append(version, another.version)
		                          .append(node, another.node)
		                          .isEquals();
	}

	@Override
	public final int hashCode() {
		return new HashCodeBuilder().append(snmpId)
							        .append(community)
							        .append(version)
							        .append(node)
							        .hashCode();
	}

	@Override
	public final String toString() {
		return new ToStringBuilder(this).append(snmpId)
								        .append(community)
								        .append(version)
								        .append(node)
								        .toString();
	}

}
